package id.aspi.sipeka

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class BerandaActivity : AppCompatActivity() {

    private lateinit var sliderViewPager: ViewPager2
    private val sliderImages = listOf(
        R.drawable.slide1,
        R.drawable.slide2,
        R.drawable.slide3,

    )
    private var sliderHandler = Handler(Looper.getMainLooper())
    private var sliderIndex = 0
    private val sliderRunnable = object : Runnable {
        override fun run() {
            sliderIndex = (sliderIndex + 1) % sliderImages.size
            sliderViewPager.setCurrentItem(sliderIndex, true)
            sliderHandler.postDelayed(this, 180000) // 3 menit = 180000 ms
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        // ViewPager Slider
        sliderViewPager = findViewById(R.id.sliderViewPager)
        sliderViewPager.adapter = SliderAdapter(sliderImages)
        sliderHandler.postDelayed(sliderRunnable, 180000)

        // Grid Menu
        val menuRecycler = findViewById<RecyclerView>(R.id.menuRecyclerView)
        menuRecycler.layoutManager = GridLayoutManager(this, 3)
        menuRecycler.adapter = MenuAdapter()

        // Kelas Core
        val kelasRecycler = findViewById<RecyclerView>(R.id.kelasRecyclerView)
        kelasRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        kelasRecycler.adapter = KelasAdapter()

        // Bottom Navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener {
            // Navigasi sementara
            true
        }
    }

    override fun onDestroy() {
        sliderHandler.removeCallbacks(sliderRunnable)
        super.onDestroy()
    }
}

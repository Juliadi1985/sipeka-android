package id.aspi.sipeka

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tunda 2 detik, lalu pindah ke BerandaActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, BerandaActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}

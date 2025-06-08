package id.aspi.sipeka

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val menuList = listOf(
        Pair("Menu1", R.drawable.ic_profil_sekolah),
        Pair("Menu2", R.drawable.ic_administrasi),
        Pair("Menu3", R.drawable.ic_data_gtk),
        Pair("Menu4", R.drawable.ic_jadwal_pelajaran),
        Pair("Menu5", R.drawable.ic_kalender_pendidikan),
        Pair("Menu6", R.drawable.ic_galeri_kegiatan)
    )

    inner class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.menuIcon)
        val title: TextView = view.findViewById(R.id.menuTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val (title, iconRes) = menuList[position]
        holder.title.text = title
        holder.icon.setImageResource(iconRes)
    }

    override fun getItemCount(): Int = menuList.size
}

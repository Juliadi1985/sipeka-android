package id.aspi.sipeka

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KelasAdapter : RecyclerView.Adapter<KelasAdapter.KelasViewHolder>() {

    private val kelasList = listOf("Kelas1", "Kelas2", "Kelas3", "Kelas4", "Kelas5", "Kelas6")

    inner class KelasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val namaKelas: TextView = view.findViewById(R.id.textKelas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KelasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kelas, parent, false)
        return KelasViewHolder(view)
    }

    override fun onBindViewHolder(holder: KelasViewHolder, position: Int) {
        holder.namaKelas.text = kelasList[position]
    }

    override fun getItemCount(): Int = kelasList.size
}

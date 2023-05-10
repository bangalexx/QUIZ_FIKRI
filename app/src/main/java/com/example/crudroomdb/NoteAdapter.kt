package com.example.crudroomdb
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudroomdb.room.Skripsi
import kotlinx.android.synthetic.main.adapter_main.view.*

class NoteAdapter (private var skripsis: ArrayList<Skripsi>, private val listener: OnAdapterListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.adapter_main,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount() = skripsis.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = skripsis[position]
        holder.view.text_nisn.text = note.nisn
        holder.view.text_nama.text = note.nama
        holder.view.text_alamat.text = note.alamat
        holder.view.text_asalsekolah.text = note.asalsekolah

        holder.view.text_nisn.setOnClickListener {
            listener.onRead(note)
        }
        holder.view.icon_edit.setOnClickListener {
            listener.onUpdate(note)
        }
        holder.view.icon_delete.setOnClickListener {
            listener.onDelete(note)
        }

    }

    inner class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(newList: List<Skripsi>) {
        skripsis.clear()
        skripsis.addAll(newList)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onRead(skripsi: Skripsi)
        fun onUpdate(skripsi: Skripsi)
        fun onDelete(skripsi: Skripsi)
    }
}

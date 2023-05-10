package com.example.crudroomdb.room
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity
data class Skripsi (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nisn: String,
    val nama: String,
    val alamat: String,
    val asalsekolah: String

)
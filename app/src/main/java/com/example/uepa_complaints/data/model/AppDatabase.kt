package com.example.uepa_complaints.data.model

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Banco de dados local do aplicativo.
 *
 * O Room utiliza essa classe para criar e gerenciar
 * o banco SQLite.
 */
@Database(
    entities = [
        ComplaintEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Disponibiliza o DAO de reclamações.
     */
    abstract fun complaintDao(): ComplaintDao
}
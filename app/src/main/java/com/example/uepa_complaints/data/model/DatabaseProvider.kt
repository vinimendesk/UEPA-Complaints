package com.example.uepa_complaints.data.model

import android.content.Context
import androidx.room.Room

/**
 * Responsável por criar uma única instância
 * do banco de dados durante a execução do aplicativo.
 *
 * Utilizamos o padrão Singleton para evitar
 * criar várias conexões com o mesmo banco.
 */
object DatabaseProvider {

    /**
     * Instância única do banco.
     */
    @Volatile
    private var INSTANCE: AppDatabase? = null

    /**
     * Retorna a instância do banco.
     *
     * synchronized garante que duas threads não
     * criem o banco simultaneamente.
     */
    fun getDatabase(context: Context): AppDatabase {

        return INSTANCE ?: synchronized(this) {

            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "reclamacoes_uepa.db"
            )
                .build()

            INSTANCE = instance

            instance
        }
    }
}
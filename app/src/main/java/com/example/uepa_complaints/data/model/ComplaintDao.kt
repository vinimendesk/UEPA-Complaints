package com.example.uepa_complaints.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * DAO = Data Access Object.
 *
 * Essa classe define todas as operações que podem
 * ser realizadas na tabela de reclamações.
 */
@Dao
interface ComplaintDao {

    /**
     * Retorna todas as reclamações.
     *
     * O Flow faz com que o Room avise automaticamente
     * quando os dados da tabela forem modificados.
     */
    @Query(
        """
        SELECT * FROM complaints
        ORDER BY date DESC
        """
    )
    fun observeComplaints(): Flow<List<ComplaintEntity>>

    /**
     * Insere uma nova reclamação no banco.
     *
     * O ID será gerado automaticamente pelo Room.
     */
    @Insert
    suspend fun insertComplaint(
        complaint: ComplaintEntity
    )

    /**
     * Atualiza uma reclamação existente.
     */
    @Update
    suspend fun updateComplaint(
        complaint: ComplaintEntity
    )

    /**
     * Remove uma reclamação.
     */
    @Delete
    suspend fun deleteComplaint(
        complaint: ComplaintEntity
    )

    /**
     * Remove todas as reclamações.
     *
     * Útil posteriormente para testes ou logout,
     * caso essa regra seja necessária.
     */
    @Query("DELETE FROM complaints")
    suspend fun deleteAll()
}
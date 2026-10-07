package com.example.uepa_complaints.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Representa uma reclamação armazenada no banco de dados local.
 *
 * Cada objeto dessa classe representa uma linha
 * dentro da tabela "complaints".
 */
@Entity(tableName = "complaints")
data class ComplaintEntity(

    /**
     * Identificador único da reclamação.
     *
     * autoGenerate = true faz o Room gerar o ID
     * automaticamente para novas reclamações.
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    /**
     * Destinatário da reclamação.
     *
     * Será armazenado como texto no SQLite.
     *
     * Exemplos:
     * "UEPA"
     * "Professor"
     * "Aluno"
     */
    val recipient: String,

    /**
     * Texto escrito pelo usuário.
     */
    val text: String,

    /**
     * Data e hora em que a reclamação foi criada.
     *
     * Usaremos Long para armazenar o timestamp.
     */
    val date: String,

    /**
     * Situação atual da reclamação.
     *
     * Exemplos:
     * "Em análise"
     * "Respondida"
     */
    val status: String
)
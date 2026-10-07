package com.example.uepa_complaints.data.model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Repository responsável por fazer a comunicação
 * entre o ViewModel e o banco de dados.
 *
 * O ViewModel não precisa conhecer Room diretamente.
 */
class ComplaintRepository(
    private val dao: ComplaintDao
) {

    /**
     * Observa as reclamações armazenadas no banco.
     *
     * O Room fornece Flow<List<ComplaintEntity>>.
     *
     * Aqui fazemos a conversão para
     * Flow<List<Complaint>>.
     */
    fun observeComplaints(): Flow<List<Complaint>> {

        return dao.observeComplaints()
            .map { entities ->

                entities.map { entity ->

                    Complaint(
                        id = entity.id,
                        recipient = Recipient.valueOf(entity.recipient),
                        text = entity.text,
                        date = formatDate(entity.date.toLong()),
                        status = ComplaintStatus.valueOf(entity.status)
                    )
                }
            }
    }

    /**
     * Adiciona uma nova reclamação.
     */
    suspend fun addComplaint(
        recipient: Recipient,
        text: String
    ) {

        val entity = ComplaintEntity(

            recipient = recipient.name,

            text = text,

            // Momento atual em milissegundos.
            date = System.currentTimeMillis().toString(),

            status = ComplaintStatus.EM_ANALISE.name
        )

        dao.insertComplaint(entity)
    }

    /**
     * Atualiza uma reclamação.
     */
    suspend fun updateComplaint(
        complaint: Complaint
    ) {

        val entity = ComplaintEntity(

            id = complaint.id,

            recipient = complaint.recipient.name,

            text = complaint.text,

            date = complaint.date,

            status = complaint.status.name
        )

        dao.updateComplaint(entity)
    }

    /**
     * Remove uma reclamação.
     */
    suspend fun deleteComplaint(
        complaint: Complaint
    ) {

        val entity = ComplaintEntity(

            id = complaint.id,

            recipient = complaint.recipient.name,

            text = complaint.text,

            date = complaint.date,

            status = complaint.status.name
        )

        dao.deleteComplaint(entity)
    }

    /*
     * Converte o timestamp armazenado no banco
     * para o formato apresentado na tela.
     */
    private fun formatDate(timestamp: Long): String {

        val formatter = SimpleDateFormat(
            "dd MMM, HH:mm",
            Locale("pt", "BR")
        )

        return formatter.format(
            Date(timestamp)
        )
    }
}
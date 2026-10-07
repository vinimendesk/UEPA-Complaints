package com.example.uepa_complaints.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uepa_complaints.data.model.Complaint
import com.example.uepa_complaints.data.model.ComplaintRepository
import com.example.uepa_complaints.data.model.ComplaintStatus
import com.example.uepa_complaints.data.model.Recipient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

// ============================================================
// VIEWMODEL PRINCIPAL
// ============================================================
//
// Responsável pelo estado da aplicação.
//
// Neste primeiro momento os dados estão em memória.
// Posteriormente podemos trocar essa implementação por:
// Firebase, Supabase, Room ou uma API REST.
//

class ComplaintViewModel(
    private val repository: ComplaintRepository
) : ViewModel() {

    val complaints: StateFlow<List<Complaint>> =
        repository
            .observeComplaints()
            .stateIn(
                scope = viewModelScope,

                // Começamos com uma lista vazia enquanto
                // o Room carrega os dados.
                started = SharingStarted.WhileSubscribed(5_000),

                initialValue = emptyList()
            )


    // --------------------------------------------------------
    // Reclamações iniciais
    // --------------------------------------------------------

    private val _complaints = MutableStateFlow(
        listOf(

            Complaint(
                id = 1042,
                recipient = Recipient.UEPA,
                text = "Os aparelhos de ar-condicionado da sala 12 precisam de manutenção.",
                date = "Hoje, 09:42",
                status = ComplaintStatus.EM_ANALISE
            ),

            Complaint(
                id = 1038,
                recipient = Recipient.PROFESSOR,
                text = "Gostaria de solicitar mais clareza sobre os critérios da última avaliação.",
                date = "18 Jun, 14:20",
                status = ComplaintStatus.RESPONDIDA
            ),

            Complaint(
                id = 1027,
                recipient = Recipient.ALUNO,
                text = "Ocorreram conversas em volume alto durante as atividades na biblioteca.",
                date = "15 Jun, 11:06",
                status = ComplaintStatus.RESPONDIDA
            )
        )
    )

    /*val complaints: StateFlow<List<Complaint>> =
        _complaints.asStateFlow()*/

    // --------------------------------------------------------
    // Adicionar reclamação
    // --------------------------------------------------------

    /**
     * Cria uma nova reclamação.
     */
    fun addComplaint(
        recipient: Recipient,
        text: String
    ) {

        viewModelScope.launch {

            repository.addComplaint(
                recipient = recipient,
                text = text
            )
        }
    }

    /**
     * Remove uma reclamação.
     */
    fun deleteComplaint(
        complaint: Complaint
    ) {

        viewModelScope.launch {

            repository.deleteComplaint(complaint)
        }
    }

    /*fun addComplaint(
        recipient: Recipient,
        text: String
    ) {

        val currentComplaints = _complaints.value

        val nextId =
            (currentComplaints.maxOfOrNull { it.id } ?: 0) + 1

        val newComplaint = Complaint(

            id = nextId,

            recipient = recipient,

            text = text.trim(),

            date = "Agora",

            status = ComplaintStatus.EM_ANALISE
        )

        // A nova reclamação fica no início da lista.
        _complaints.value =
            listOf(newComplaint) + currentComplaints
    }*/
}
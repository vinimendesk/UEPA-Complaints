package com.example.uepa_complaints.data.model

// ============================================================
// DESTINATÁRIO DA RECLAMAÇÃO
// ============================================================

enum class Recipient {

    UEPA,

    PROFESSOR,

    ALUNO
}

// ============================================================
// STATUS DA RECLAMAÇÃO
// ============================================================

enum class ComplaintStatus {

    EM_ANALISE,

    RESPONDIDA
}

// ============================================================
// MODELO DE UMA RECLAMAÇÃO
// ============================================================

data class Complaint(

    val id: Int,

    val recipient: Recipient,

    val text: String,

    val date: String,

    val status: ComplaintStatus
)
package com.example.uepa_complaints.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uepa_complaints.ui.theme.UepaSlate200
import com.example.uepa_complaints.ui.theme.UepaSlate500
import com.example.uepa_complaints.ui.theme.UepaTeal700

// ============================================================
// INDICADOR DE ETAPA
// ============================================================
//
// Representa uma etapa do formulário.
//
// active = true:
//     etapa atual, utilizando a cor principal.
//
// active = false:
//     etapa ainda não iniciada.
//

@Composable
fun StepIndicator(
    number: String,
    active: Boolean
) {

    Box(
        modifier = Modifier
            .size(44.dp)
            .background(
                color = if (active) {
                    UepaTeal700
                } else {
                    UepaSlate200
                },
                shape = RoundedCornerShape(14.dp)
            ),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = number,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,
            color = if (active) {
                androidx.compose.ui.graphics.Color.White
            } else {
                UepaSlate500
            }
        )
    }
}
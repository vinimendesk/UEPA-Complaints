package com.example.uepa_complaints.ui.components

import com.example.uepa_complaints.ui.theme.UepaSlate400

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uepa_complaints.ui.theme.UepaSlate100
import com.example.uepa_complaints.ui.theme.UepaSlate700


// ============================================================
// ESTADO VAZIO
// ============================================================
//
// Exibido quando o filtro atual não possui reclamações.
//

@Composable
fun EmptyComplaints() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // ----------------------------------------------------
        // Ícone
        // ----------------------------------------------------

        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = UepaSlate100,
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Default.Campaign,
                contentDescription = null,
                tint = UepaSlate400,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(
            modifier = Modifier.size(16.dp)
        )

        // ----------------------------------------------------
        // Título
        // ----------------------------------------------------

        Text(
            text = "Nenhum registro encontrado",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,
            color = UepaSlate700
        )

        Spacer(
            modifier = Modifier.size(4.dp)
        )

        // ----------------------------------------------------
        // Descrição
        // ----------------------------------------------------

        Text(
            text = "Não há reclamações com esse status.",
            fontSize = 14.sp,
            color = UepaSlate400
        )
    }
}
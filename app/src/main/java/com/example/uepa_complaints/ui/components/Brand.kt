package com.example.uepa_complaints.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.uepa_complaints.ui.theme.UepaSlate500
import com.example.uepa_complaints.ui.theme.UepaSlate900
import com.example.uepa_complaints.ui.theme.UepaTeal700

@Composable
fun Brand(
    compact: Boolean = false
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // ----------------------------------------------------
        // Ícone do aplicativo
        // ----------------------------------------------------

        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .size(if (compact) 40.dp else 48.dp)
                .background(
                    color = UepaTeal700,
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Default.Campaign,
                contentDescription = "EscutaUEPA",
                tint = Color.White,
                modifier = Modifier.size(
                    if (compact) 20.dp else 24.dp
                )
            )
        }

        // ----------------------------------------------------
        // Nome
        // ----------------------------------------------------

        androidx.compose.foundation.layout.Column {

            Row {

                Text(
                    text = "Escuta",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = if (compact) 18.sp else 20.sp,
                    color = UepaSlate900
                )

                Text(
                    text = "UEPA",

                    fontWeight = FontWeight.ExtraBold,
                    fontSize = if (compact) 18.sp else 20.sp,
                    color = UepaTeal700
                )
            }

            if (!compact) {

                Spacer(
                    modifier = Modifier.size(4.dp)
                )

                Text(
                    text = "SUA VOZ IMPORTA",
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = UepaSlate500,
                    letterSpacing = 1.sp
                )
            }
        }
    }
}
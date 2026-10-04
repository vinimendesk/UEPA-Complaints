package com.example.uepa_complaints.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uepa_complaints.ui.theme.UepaSlate500
import com.example.uepa_complaints.ui.theme.UepaSlate700
import com.example.uepa_complaints.ui.theme.UepaSlate900

@Composable
fun AppHeader(
    title: String,
    subtitle: String? = null,
    onBack: (() -> Unit)? = null,
    onLogout: (() -> Unit)? = null
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(
                horizontal = 20.dp,
                vertical = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        if (onBack != null) {

            IconButton(
                onClick = onBack,
                modifier = Modifier.size(40.dp)
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar",
                    tint = UepaSlate700
                )
            }

        } else {

            Brand(compact = true)
        }

        androidx.compose.foundation.layout.Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = if (onBack != null) 18.sp else 14.sp,
                color = UepaSlate900
            )

            if (subtitle != null) {

                Text(
                    text = subtitle,
                    fontSize = 12.sp,
                    color = UepaSlate500
                )
            }
        }

        if (onLogout != null) {

            IconButton(
                onClick = onLogout,
                modifier = Modifier.size(40.dp)
            ) {

                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = "Sair",
                    tint = UepaSlate500
                )
            }
        }
    }
}
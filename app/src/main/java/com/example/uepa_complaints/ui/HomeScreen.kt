package com.example.uepa_complaints.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uepa_complaints.ui.components.AppHeader
import com.example.uepa_complaints.ui.components.AppScreen
import com.example.uepa_complaints.ui.components.BottomNavigationBar
import com.example.uepa_complaints.ui.theme.UepaAmber50
import com.example.uepa_complaints.ui.theme.UepaAmber700
import com.example.uepa_complaints.ui.theme.UepaSlate200
import com.example.uepa_complaints.ui.theme.UepaSlate50
import com.example.uepa_complaints.ui.theme.UepaSlate500
import com.example.uepa_complaints.ui.theme.UepaSlate900
import com.example.uepa_complaints.ui.theme.UepaTeal100
import com.example.uepa_complaints.ui.theme.UepaTeal50
import com.example.uepa_complaints.ui.theme.UepaTeal700
import com.example.uepa_complaints.ui.theme.UepaTeal800

@Composable
fun HomeScreen(
    complaintCount: Int,
    onCreateComplaint: () -> Unit,
    onComplaints: () -> Unit,
    onLogout: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(UepaSlate50)
    ) {

        AppHeader(
            title = "Olá, Samuel",
            subtitle = "Campus Parauapebas",
            onLogout = onLogout
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {

            // =================================================
            // BANNER
            // =================================================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(
                    containerColor = UepaTeal800
                )
            ) {

                Column(
                    modifier = Modifier.padding(28.dp)
                ) {

                    Surface(
                        shape = RoundedCornerShape(50),
                        color = Color.White.copy(alpha = 0.10f)
                    ) {

                        Text(
                            text = "CANAL DE ESCUTA",
                            modifier = Modifier.padding(
                                horizontal = 12.dp,
                                vertical = 6.dp
                            ),
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = Color.White
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    Text(
                        text = "O que você quer compartilhar hoje?",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 32.sp,
                        lineHeight = 38.sp,
                        color = Color.White
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Sua reclamação ajuda a construir uma universidade mais acolhedora e eficiente para todos.",
                        fontSize = 15.sp,
                        lineHeight = 24.sp,
                        color = UepaTeal100
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            // =================================================
            // TÍTULO
            // =================================================

            Text(
                text = "ACESSO RÁPIDO",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 11.sp,
                letterSpacing = 2.sp,
                color = UepaTeal700
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Como podemos ajudar?",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 21.sp,
                color = UepaSlate900
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =================================================
            // GERAR RECLAMAÇÃO
            // =================================================

            HomeActionCard(
                icon = Icons.Default.Edit,
                title = "Gerar reclamação",
                description = "Escolha o destinatário e conte o que aconteceu.",
                actionText = "Começar",
                iconBackground = UepaTeal50,
                iconTint = UepaTeal700,
                actionColor = UepaTeal700,
                onClick = onCreateComplaint
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =================================================
            // HISTÓRICO
            // =================================================

            HomeActionCard(
                icon = Icons.Default.Campaign,
                title = "Minhas reclamações",
                description = "Visualize o andamento e as respostas recebidas.",
                actionText = "$complaintCount registros",
                iconBackground = UepaAmber50,
                iconTint = UepaAmber700,
                actionColor = UepaAmber700,
                onClick = onComplaints
            )
        }
    }
}

@Composable
private fun HomeActionCard(
    icon: ImageVector,
    title: String,
    description: String,
    actionText: String,
    iconBackground: Color,
    iconTint: Color,
    actionColor: Color,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(
            1.dp,
            UepaSlate200
        )
    ) {

        Column(
            modifier = Modifier.padding(24.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        iconBackground,
                        RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconTint,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                color = UepaSlate900
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = description,
                fontSize = 14.sp,
                lineHeight = 21.sp,
                color = UepaSlate500
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = actionText,
                    fontWeight = FontWeight.ExtraBold,
                    color = actionColor
                )

                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    tint = actionColor,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
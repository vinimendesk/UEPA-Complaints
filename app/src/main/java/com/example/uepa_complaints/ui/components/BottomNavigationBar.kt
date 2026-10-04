package com.example.uepa_complaints.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uepa_complaints.ui.theme.UepaSlate400
import com.example.uepa_complaints.ui.theme.UepaTeal50
import com.example.uepa_complaints.ui.theme.UepaTeal700

enum class AppScreen {
    HOME,
    CREATE,
    COMPLAINTS
}

@Composable
fun BottomNavigationBar(
    currentScreen: AppScreen,
    onNavigate: (AppScreen) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .navigationBarsPadding()
            .padding(
                horizontal = 20.dp,
                vertical = 12.dp
            ),

        horizontalArrangement = Arrangement.SpaceAround
    ) {

        BottomNavigationItem(
            label = "Início",
            icon = Icons.Default.Home,
            selected = currentScreen == AppScreen.HOME,
            onClick = {
                onNavigate(AppScreen.HOME)
            }
        )

        BottomNavigationItem(
            label = "Reclamar",
            icon = Icons.Default.Edit,
            selected = currentScreen == AppScreen.CREATE,
            onClick = {
                onNavigate(AppScreen.CREATE)
            }
        )

        BottomNavigationItem(
            label = "Histórico",
            icon = Icons.Default.Campaign,
            selected = currentScreen == AppScreen.COMPLAINTS,
            onClick = {
                onNavigate(AppScreen.COMPLAINTS)
            }
        )
    }
}

@Composable
private fun BottomNavigationItem(
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(
                horizontal = 12.dp,
                vertical = 4.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .size(
                    width = 48.dp,
                    height = 28.dp
                )
                .background(
                    color = if (selected) {
                        UepaTeal50
                    } else {
                        Color.Transparent
                    },
                    shape = RoundedCornerShape(50)
                ),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (selected) {
                    UepaTeal700
                } else {
                    UepaSlate400
                },
                modifier = Modifier.size(20.dp)
            )
        }

        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = if (selected) {
                UepaTeal700
            } else {
                UepaSlate400
            }
        )
    }
}
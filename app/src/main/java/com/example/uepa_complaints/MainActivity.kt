package com.example.uepa_complaints

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uepa_complaints.ui.ComplaintsScreen
import com.example.uepa_complaints.ui.CreateComplaintScreen
import com.example.uepa_complaints.ui.HomeScreen
import com.example.uepa_complaints.ui.LoginScreen
import com.example.uepa_complaints.ui.components.AppScreen
import com.example.uepa_complaints.ui.theme.UEPAComplaintsTheme
import com.example.uepa_complaints.viewmodel.ComplaintViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            UEPAComplaintsTheme {

                ReclamacoesUepaApp()
            }
        }
    }
}

@Composable
fun ReclamacoesUepaApp(
    viewModel: ComplaintViewModel = viewModel()
) {

    // ========================================================
    // ESTADO DA TELA
    // ========================================================

    var screen by remember {
        mutableStateOf<AppScreen?>(null)
    }

    // ========================================================
    // ESTADO DE LOGIN
    // ========================================================

    var loggedIn by remember {
        mutableStateOf(false)
    }

    // ========================================================
    // RECLAMAÇÕES
    // ========================================================

    val complaints by viewModel.complaints.collectAsState()

    // ========================================================
    // LOGIN
    // ========================================================

    if (!loggedIn) {

        LoginScreen(
            onLogin = {

                loggedIn = true

                screen = AppScreen.HOME
            }
        )

        return
    }

    // ========================================================
    // TELAS PRINCIPAIS
    // ========================================================

    when (screen) {

        AppScreen.HOME -> {

            HomeScreen(
                complaintCount = complaints.size,

                onCreateComplaint = {
                    screen = AppScreen.CREATE
                },

                onComplaints = {
                    screen = AppScreen.COMPLAINTS
                },

                onLogout = {
                    loggedIn = false
                    screen = null
                }
            )
        }

        AppScreen.CREATE -> {

            CreateComplaintScreen(

                onBack = {
                    screen = AppScreen.HOME
                },

                onSubmit = { recipient, text ->

                    viewModel.addComplaint(
                        recipient = recipient,
                        text = text
                    )

                    screen = AppScreen.COMPLAINTS
                }
            )
        }

        AppScreen.COMPLAINTS -> {

            ComplaintsScreen(

                complaints = complaints,

                onBack = {
                    screen = AppScreen.HOME
                },

                onNewComplaint = {
                    screen = AppScreen.CREATE
                }
            )
        }

        null -> {

            screen = AppScreen.HOME
        }
    }
}
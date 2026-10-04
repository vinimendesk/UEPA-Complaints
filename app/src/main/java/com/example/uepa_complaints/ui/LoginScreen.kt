package com.example.uepa_complaints.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uepa_complaints.ui.components.Brand
import com.example.uepa_complaints.ui.theme.UepaSlate400
import com.example.uepa_complaints.ui.theme.UepaSlate50
import com.example.uepa_complaints.ui.theme.UepaSlate500
import com.example.uepa_complaints.ui.theme.UepaSlate700
import com.example.uepa_complaints.ui.theme.UepaSlate900
import com.example.uepa_complaints.ui.theme.UepaTeal50
import com.example.uepa_complaints.ui.theme.UepaTeal700

@Composable
fun LoginScreen(
    onLogin: () -> Unit
) {

    var email by remember {
        mutableStateOf("aluno@uepa.br")
    }

    var password by remember {
        mutableStateOf("12345678")
    }

    var showPassword by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(UepaSlate50)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        // ----------------------------------------------------
        // Logo
        // ----------------------------------------------------

        Brand()

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        // ----------------------------------------------------
        // Card de login
        // ----------------------------------------------------

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {

            Column(
                modifier = Modifier.padding(24.dp)
            ) {

                // Ícone
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            UepaTeal50,
                            RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = UepaTeal700
                    )
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = "Boas-vindas",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp,
                    color = UepaSlate900
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Entre com seus dados institucionais.",
                    color = UepaSlate500
                )

                Spacer(
                    modifier = Modifier.height(28.dp)
                )

                // ------------------------------------------------
                // Email
                // ------------------------------------------------

                Text(
                    text = "E-mail ou matrícula",
                    fontWeight = FontWeight.Bold,
                    color = UepaSlate700
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                // ------------------------------------------------
                // Senha
                // ------------------------------------------------

                Text(
                    text = "Senha",
                    fontWeight = FontWeight.Bold,
                    color = UepaSlate700
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    visualTransformation =
                        if (showPassword) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {

                        IconButton(
                            onClick = {
                                showPassword = !showPassword
                            }
                        ) {

                            Icon(
                                imageVector =
                                    if (showPassword) {
                                        Icons.Default.VisibilityOff
                                    } else {
                                        Icons.Default.Visibility
                                    },
                                contentDescription =
                                    if (showPassword) {
                                        "Ocultar senha"
                                    } else {
                                        "Mostrar senha"
                                    }
                            )
                        }
                    },
                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                // ------------------------------------------------
                // Entrar
                // ------------------------------------------------

                Button(
                    onClick = onLogin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {

                    Text(
                        text = "Entrar",
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Icon(
                        Icons.Default.ChevronRight,
                        contentDescription = null
                    )
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = "Ao entrar, você concorda com os termos de uso e privacidade.",
                    fontSize = 12.sp,
                    color = UepaSlate400
                )
            }
        }
    }
}
package com.example.uepa_complaints.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uepa_complaints.data.model.Recipient
import com.example.uepa_complaints.ui.components.AppHeader
import com.example.uepa_complaints.ui.components.AppScreen
import com.example.uepa_complaints.ui.components.BottomNavigationBar
import com.example.uepa_complaints.ui.theme.UepaAmber600
import com.example.uepa_complaints.ui.theme.UepaSlate100
import com.example.uepa_complaints.ui.theme.UepaSlate200
import com.example.uepa_complaints.ui.theme.UepaSlate400
import com.example.uepa_complaints.ui.theme.UepaSlate50
import com.example.uepa_complaints.ui.theme.UepaSlate500
import com.example.uepa_complaints.ui.theme.UepaSlate900
import com.example.uepa_complaints.ui.theme.UepaTeal50
import com.example.uepa_complaints.ui.theme.UepaTeal700

@Composable
fun CreateComplaintScreen(
    onBack: () -> Unit,
    onSubmit: (Recipient, String) -> Unit
) {

    var recipient by remember {
        mutableStateOf(Recipient.UEPA)
    }

    var text by remember {
        mutableStateOf("")
    }

    val maxLength = 600

    val canSubmit =
        text.trim().length >= 10

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(UepaSlate50)
    ) {

        AppHeader(
            title = "Nova reclamação",
            subtitle = "Preencha os dados abaixo",
            onBack = onBack
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = 20.dp,
                    vertical = 28.dp
                )
        ) {

            // =================================================
            // INDICADOR DE ETAPAS
            // =================================================

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                StepIndicator(
                    number = "1",
                    active = true
                )

                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = UepaTeal700,
                    thickness = 4.dp
                )

                StepIndicator(
                    number = "2",
                    active = false
                )
            }

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            Text(
                text = "DESTINATÁRIO",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 11.sp,
                letterSpacing = 2.sp,
                color = UepaTeal700
            )

            Text(
                text = "Para quem é a reclamação?",
                modifier = Modifier.padding(top = 4.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                color = UepaSlate900
            )

            Text(
                text = "Selecione uma opção para direcionarmos corretamente.",
                modifier = Modifier.padding(top = 8.dp),
                fontSize = 14.sp,
                color = UepaSlate500
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // =================================================
            // DESTINATÁRIOS
            // =================================================

            RecipientOption(
                recipient = Recipient.UEPA,
                title = "UEPA",
                description = "Estrutura e serviços",
                icon = Icons.Default.Business,
                selected = recipient == Recipient.UEPA,
                onClick = {
                    recipient = Recipient.UEPA
                }
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            RecipientOption(
                recipient = Recipient.PROFESSOR,
                title = "Professor",
                description = "Docentes e disciplinas",
                icon = Icons.Default.Person,
                selected = recipient == Recipient.PROFESSOR,
                onClick = {
                    recipient = Recipient.PROFESSOR
                }
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            RecipientOption(
                recipient = Recipient.ALUNO,
                title = "Aluno",
                description = "Convivência estudantil",
                icon = Icons.Default.Group,
                selected = recipient == Recipient.ALUNO,
                onClick = {
                    recipient = Recipient.ALUNO
                }
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            // =================================================
            // MENSAGEM
            // =================================================

            Text(
                text = "SUA MENSAGEM",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 11.sp,
                letterSpacing = 2.sp,
                color = UepaTeal700
            )

            Text(
                text = "Conte o que aconteceu",
                modifier = Modifier.padding(top = 4.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                color = UepaSlate900
            )

            Text(
                text = "Descreva a situação com detalhes. Evite incluir informações pessoais sensíveis.",
                modifier = Modifier.padding(top = 8.dp),
                fontSize = 14.sp,
                lineHeight = 21.sp,
                color = UepaSlate500
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            OutlinedTextField(
                value = text,
                onValueChange = {
                    if (it.length <= maxLength) {
                        text = it
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                placeholder = {
                    Text(
                        "Ex.: Gostaria de relatar uma situação que aconteceu..."
                    )
                },
                shape = RoundedCornerShape(20.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 4.dp,
                        vertical = 8.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Mínimo de 10 caracteres",
                    fontSize = 12.sp,
                    color = UepaSlate400
                )

                Text(
                    text = "${text.length}/$maxLength",
                    fontWeight =
                        if (text.length > maxLength * 0.9)
                            FontWeight.Bold
                        else
                            FontWeight.Normal,
                    fontSize = 12.sp,
                    color =
                        if (text.length > maxLength * 0.9)
                            UepaAmber600
                        else
                            UepaSlate400
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =================================================
            // BOTÕES
            // =================================================

            OutlinedButton(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    text = "Cancelar",
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Button(
                enabled = canSubmit,
                onClick = {
                    onSubmit(
                        recipient,
                        text.trim()
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    text = "Enviar reclamação",
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = null
                )
            }
        }

        BottomNavigationBar(
            currentScreen = AppScreen.CREATE,
            onNavigate = {}
        )
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

@Composable
private fun RecipientOption(
    recipient: Recipient,
    title: String,
    description: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (selected)
                    UepaTeal50
                else
                    Color.White
        ),
        border = BorderStroke(
            width = if (selected) 2.dp else 1.dp,
            color =
                if (selected)
                    UepaTeal700
                else
                    UepaSlate200
        )
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        if (selected)
                            UepaTeal700
                        else
                            UepaSlate100,
                        RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint =
                        if (selected)
                            Color.White
                        else
                            UepaSlate500
                )
            }

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    fontWeight = FontWeight.ExtraBold,
                    color = UepaSlate900
                )

                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = UepaSlate500
                )
            }

            if (selected) {

                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            UepaTeal700,
                            RoundedCornerShape(50)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(13.dp)
                    )
                }
            }
        }
    }
}
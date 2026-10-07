package com.example.uepa_complaints.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.uepa_complaints.data.model.Complaint
import com.example.uepa_complaints.data.model.ComplaintStatus
import com.example.uepa_complaints.data.model.Recipient
import com.example.uepa_complaints.ui.components.AppHeader
import com.example.uepa_complaints.ui.components.AppScreen
import com.example.uepa_complaints.ui.components.BottomNavigationBar
import com.example.uepa_complaints.ui.components.EmptyComplaints
import com.example.uepa_complaints.ui.theme.UepaAmber50
import com.example.uepa_complaints.ui.theme.UepaAmber700
import com.example.uepa_complaints.ui.theme.UepaEmerald50
import com.example.uepa_complaints.ui.theme.UepaEmerald700
import com.example.uepa_complaints.ui.theme.UepaSlate100
import com.example.uepa_complaints.ui.theme.UepaSlate200
import com.example.uepa_complaints.ui.theme.UepaSlate400
import com.example.uepa_complaints.ui.theme.UepaSlate50
import com.example.uepa_complaints.ui.theme.UepaSlate500
import com.example.uepa_complaints.ui.theme.UepaSlate600
import com.example.uepa_complaints.ui.theme.UepaSlate900
import com.example.uepa_complaints.ui.theme.UepaTeal700
import com.example.uepa_complaints.viewmodel.ComplaintViewModel

@Composable
fun ComplaintsScreen(
    viewModel: ComplaintViewModel,
    onNavigate: (AppScreen) -> Unit,
    onBack: () -> Unit,
    onNewComplaint: () -> Unit
) {


    /**
     * Coleta o Flow proveniente do Room.
     *
     * Sempre que uma reclamação for adicionada,
     * removida ou alterada, a tela será recomposta.
     */
    val complaints by viewModel.complaints.collectAsStateWithLifecycle()

    var filter by remember {
        mutableStateOf<ComplaintStatus?>(null)
    }

    val filteredComplaints =
        complaints.filter { complaint ->

            filter == null ||
                    complaint.status == filter
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(UepaSlate50)
    ) {

        AppHeader(
            title = "Minhas reclamações",
            subtitle = "${complaints.size} registros no total",
            onBack = onBack
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {

            Text(
                text = "ACOMPANHAMENTO",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 11.sp,
                letterSpacing = 2.sp,
                color = UepaTeal700
            )

            Text(
                text = "Histórico de reclamações",
                modifier = Modifier.padding(top = 4.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                color = UepaSlate900
            )

            Text(
                text = "Consulte o status das suas solicitações.",
                modifier = Modifier.padding(top = 8.dp),
                fontSize = 14.sp,
                color = UepaSlate500
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // =================================================
            // FILTROS
            // =================================================

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                FilterChip(
                    selected = filter == null,
                    onClick = {
                        filter = null
                    },
                    label = {
                        Text("Todas")
                    }
                )

                FilterChip(
                    selected =
                        filter == ComplaintStatus.EM_ANALISE,
                    onClick = {
                        filter = ComplaintStatus.EM_ANALISE
                    },
                    label = {
                        Text("Em análise")
                    }
                )

                FilterChip(
                    selected =
                        filter == ComplaintStatus.RESPONDIDA,
                    onClick = {
                        filter = ComplaintStatus.RESPONDIDA
                    },
                    label = {
                        Text("Respondida")
                    }
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =================================================
            // LISTA
            // =================================================
            if (filteredComplaints.isEmpty()) {

                EmptyComplaints()

            } else {

                /*
                 * Percorre somente as reclamações que passaram
                 * pelo filtro selecionado.
                 */
                filteredComplaints.forEach { complaint ->

                    ComplaintCard(
                        complaint = complaint
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            OutlinedButton(
                onClick = onNewComplaint,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {

                Icon(
                    Icons.Default.Edit,
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    "Fazer nova reclamação",
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        BottomNavigationBar(
            currentScreen = AppScreen.COMPLAINTS,
            onNavigate = onNavigate
        )
    }
}

@Composable
private fun ComplaintCard(
    complaint: Complaint
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(
            1.dp,
            UepaSlate200
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Row(
                verticalAlignment = Alignment.Top
            ) {

                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(
                            UepaSlate100,
                            RoundedCornerShape(14.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = when (complaint.recipient) {
                            Recipient.UEPA ->
                                Icons.Default.Business

                            Recipient.PROFESSOR ->
                                Icons.Default.Person

                            Recipient.ALUNO ->
                                Icons.Default.Group
                        },
                        contentDescription = null,
                        tint = UepaSlate600
                    )
                }

                Spacer(
                    modifier = Modifier.width(14.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Row(
                        horizontalArrangement =
                            Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column {

                            Text(
                                text = "#${complaint.id}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = UepaSlate400
                            )

                            Text(
                                text = when (complaint.recipient) {
                                    Recipient.UEPA -> "UEPA"
                                    Recipient.PROFESSOR -> "Professor"
                                    Recipient.ALUNO -> "Aluno"
                                },
                                fontWeight = FontWeight.ExtraBold,
                                color = UepaSlate900
                            )
                        }

                        StatusBadge(
                            status = complaint.status
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = complaint.text,
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        color = UepaSlate600,
                        maxLines = 2
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = complaint.date,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = UepaSlate400
                    )
                }
            }
        }
    }
}

@Composable
private fun StatusBadge(
    status: ComplaintStatus
) {

    val background =
        when (status) {
            ComplaintStatus.RESPONDIDA ->
                UepaEmerald50

            ComplaintStatus.EM_ANALISE ->
                UepaAmber50
        }

    val foreground =
        when (status) {
            ComplaintStatus.RESPONDIDA ->
                UepaEmerald700

            ComplaintStatus.EM_ANALISE ->
                UepaAmber700
        }

    Surface(
        color = background,
        shape = RoundedCornerShape(50)
    ) {

        Text(
            text = when (status) {
                ComplaintStatus.RESPONDIDA ->
                    "Respondida"

                ComplaintStatus.EM_ANALISE ->
                    "Em análise"
            },
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 6.dp
            ),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 11.sp,
            color = foreground
        )
    }
}
package com.memtionsandroid.memotions.ui.components.journal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.memtionsandroid.memotions.R
import com.memtionsandroid.memotions.ui.theme.customColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTimeAskDialog(
    onDismiss: () -> Unit,
    onSetDate: () -> Unit,
    onSetTime: () -> Unit
) {
    val customColors = MaterialTheme.customColors
    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Card(
            colors = CardColors(
                containerColor = customColors.backgroundColor,
                contentColor = customColors.onBackgroundColor,
                disabledContentColor = customColors.onSecondBackgroundColor,
                disabledContainerColor = customColors.backgroundColor
            ),
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 12.dp)
                    .padding(horizontal = 12.dp)
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = customColors.secondBackgroundColor,
                            shape = RoundedCornerShape(50.dp),
                        )
                        .padding(12.dp)
                ) {
                    Icon(
                        contentDescription = null,
                        painter = painterResource(R.drawable.ic_datetime),
                        tint = customColors.onSecondBackgroundColor,
                        modifier = Modifier.size(36.dp)
                    )
                }
                Text(
                    text = "Tanggal dan Waktu",
                    style = MaterialTheme.typography.titleMedium,
                    color = customColors.onBackgroundColor,
                    modifier = Modifier
                        .padding(top = 12.dp)
                )
                Text(
                    text = "Sesuaikan tanggal dan waktu agar sesuai dengan jurnal kamu",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = customColors.onSecondBackgroundColor,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .padding(horizontal = 8.dp)
                        .weight(1f)
                )
                TextButton(
                    onClick = onSetDate,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Atur Tanggal",
                        style = MaterialTheme.typography.titleSmall,
                        color = customColors.onBackgroundColor,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                TextButton(
                    onClick = onSetTime,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                        Text(
                            text = "Atur Waktu",
                            style = MaterialTheme.typography.titleSmall,
                            color = customColors.onBackgroundColor,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                }
//                Row(
//                    modifier = Modifier.align(Alignment.CenterHorizontally),
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    OutlinedButton(
//                        onClick = { onSetDate() },
//                        border = BorderStroke(0.5.dp, MaterialTheme.customColors.outlineColor),
//                        shape = RoundedCornerShape(10.dp),
//                    ) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_date),
//                            contentDescription = "Date Icon",
//                            tint = MaterialTheme.customColors.TextOnBackgroundColor
//                        )
//                    }
//                    Spacer(modifier = Modifier.width(60.dp))
//                    OutlinedButton(
//                        onClick = { onSetTime() },
//                        border = BorderStroke(0.5.dp, MaterialTheme.customColors.outlineColor),
//                        shape = RoundedCornerShape(10.dp),
//                    ) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_access_time),
//                            contentDescription = "Date Icon",
//                            tint = MaterialTheme.customColors.TextOnBackgroundColor
//                        )
//                    }
//                }
            }
        }
    }
}
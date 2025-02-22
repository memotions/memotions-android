package com.memtionsandroid.memotions.ui.onboarding.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memtionsandroid.memotions.R
import com.memtionsandroid.memotions.ui.components.auth.Constant.gradientBackground
import com.memtionsandroid.memotions.ui.theme.Poppins
import kotlinx.coroutines.delay

@Composable
fun OnBoardingScreen4() {
    val contentDesc = buildAnnotatedString {
        append("Jadikan perjalanan emosional Anda lebih bermakna. Raih penghargaan atas setiap langkah kecil yang Anda capai bersama ")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(" Memotions")
        }
    }
    val contentImage: Painter = painterResource(id = R.drawable.onboarding4)

    var titleVisible by remember { mutableStateOf(false) }
    var descVisible by remember { mutableStateOf(false) }
    var imageVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        titleVisible = true
        delay(500)
        imageVisible = true
        delay(500)
        descVisible = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(36.dp))
        AnimatedVisibility(
            visible = titleVisible,
            enter = fadeIn(animationSpec = tween(durationMillis = 800)) +
                    scaleIn(initialScale = 0.8f, animationSpec = tween(durationMillis = 800))
        ) {
            Text(
                text = "Raih Pencapaian",
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Poppins,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF292828)
                ),
                modifier = Modifier.width(231.dp)
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        AnimatedVisibility(
            visible = imageVisible,
            enter = fadeIn(animationSpec = tween(durationMillis = 800)) +
                    scaleIn(initialScale = 0.8f, animationSpec = tween(durationMillis = 800))
        ) {
            Image(
                painter = contentImage,
                contentDescription = "Content Image",
                modifier = Modifier.size(width = 321.dp, 186.dp)
            )
        }

        Spacer(modifier = Modifier.height(64.dp))

        AnimatedVisibility(
            visible = descVisible,
            enter = fadeIn(animationSpec = tween(durationMillis = 800)) +
                    scaleIn(initialScale = 0.8f, animationSpec = tween(durationMillis = 800))
        ) {
            Text(
                text = contentDesc,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = Poppins,
                    color = Color(0xFF292828)
                ),
                modifier = Modifier.size(width = 317.dp, height = 225.dp)
            )
        }

        Spacer(modifier = Modifier.height(64.dp))
    }
}
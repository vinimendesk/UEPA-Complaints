package com.example.uepa_complaints.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

// ============================================================
// CORES DO MATERIAL 3
// ============================================================

private val LightColors = lightColorScheme(

    primary = UepaTeal700,

    onPrimary = UepaWhite,

    primaryContainer = UepaTeal50,

    onPrimaryContainer = UepaTeal800,

    background = UepaSlate50,

    onBackground = UepaSlate900,

    surface = UepaWhite,

    onSurface = UepaSlate900,

    surfaceVariant = UepaSlate100,

    onSurfaceVariant = UepaSlate600,

    outline = UepaSlate200
)

@Composable
fun UEPAComplaintsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = LightColors


    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
package com.lab6.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF2196F3),         // Nice Blue
    secondary = Color(0xFF03DAC5),       // Teal
    tertiary = Color(0xFFBB86FC),        // Purple
    background = Color(0xFF121212),      // Deep Dark
    surface = Color(0xFF1E1E1E),         // Slightly Lighter Dark
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color(0xFFE3E3E3),    // Light Gray
    onSurface = Color(0xFFE3E3E3)        // Light Gray
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1976D2),         // Deeper Blue
    secondary = Color(0xFF018786),       // Dark Teal
    tertiary = Color(0xFF6200EE),        // Deep Purple
    background = Color(0xFFFAFAFA),      // Almost White
    surface = Color(0xFFFFFFFF),         // Pure White
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),    // Almost Black
    onSurface = Color(0xFF1C1B1F)        // Almost Black
)



@Composable
fun Lab6Theme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
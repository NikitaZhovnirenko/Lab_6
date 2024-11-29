package com.lab6.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lab6.data.entity.WeatherMain

/**
 * WeatherMainCustomView() - custom and reusable compose view for weather data
 * [weatherMain]: WeatherMain - accepts WeatherMain object as parameter
 * - is used on WeatherScreen and WeatherForecastScreen
 */
@Composable
fun WeatherMainCustomView(weatherMain: WeatherMain, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(16.dp)) {
        Column(modifier = Modifier.padding(6.dp)) {
            Text(
                "Температура: ${weatherMain.temp} °C",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                "Відчувається як: ${weatherMain.feels_like}°C",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
            Text(
                "Вологість: ${weatherMain.humidity}%",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
            Text(
                "Тиск: ${weatherMain.pressure} мм",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
        }
    }
}

@Preview
@Composable
private fun WeatherMainCustomViewPreview() {
    WeatherMainCustomView(
        weatherMain = WeatherMain(
            temp = 322.0,
            feels_like = 321.0,
            pressure = 322,
            humidity = 322
        )
    )
}
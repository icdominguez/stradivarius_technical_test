package com.icdominguez.stradivariustechnicaltest.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.icdominguez.stradivariustechnicaltest.core.designsystem.R

@Composable
fun NoDataFound() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.no_data_found),
            contentDescription = "",
        )
        Text(text = "Ups! There's no data here")
    }
}

@Composable
@Preview
private fun NoDataFoundPreview() {
    NoDataFound()
}
package com.icdominguez.stradivariustechnicaltest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.icdominguez.stradivariustechnicaltest.navigation.StradivariusNavHost

@Composable
fun StradivariusApp(
    appState: StradivariusAppState = rememberStradivariusAppState(),
) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            StradivariusNavHost(appState = appState)
        }
    }
}

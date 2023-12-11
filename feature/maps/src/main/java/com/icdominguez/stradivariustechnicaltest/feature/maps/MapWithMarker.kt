package com.icdominguez.stradivariustechnicaltest.feature.maps

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapWithMarker (
    latitude: Double,
    longitude: Double
) {
    val marker = LatLng(latitude, longitude)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(marker, 2f)
    }

    GoogleMap(
        modifier = Modifier
            .width(300.dp)
            .height(300.dp)
            .padding(vertical = 10.dp),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = marker)
        )
    }
}

@Composable
@Preview
fun MapWithMarkerPreview() {
    MapWithMarker(
        latitude = 40.487113,
        longitude = -3.353862
    )
}
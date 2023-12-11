package com.icdominguez.stradivariustechnicaltest.feature.detail.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    icon: ImageVector,
    placeholder: String,
    text: String,
    onTextChanged: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 30.dp,
                vertical = 10.dp
            ),
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.CenterStart),
            imageVector = icon,
            contentDescription = "Icon",
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 50.dp),
        ) {
            Text(
                text = placeholder,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                ),
            )
            Text(
                text = text,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold,
                ),
            )
            Divider(
                modifier = Modifier.padding(top = 10.dp).height(1.dp)
            )
        }
    }
}

@Preview
@Composable
fun CustomTextFieldPreview() {
    CustomTextField(
        icon = Icons.Default.PersonPin,
        placeholder = "Nombre y Apellidos",
        text = "Laura Navarro Martinez",
        onTextChanged = {},
    )
}

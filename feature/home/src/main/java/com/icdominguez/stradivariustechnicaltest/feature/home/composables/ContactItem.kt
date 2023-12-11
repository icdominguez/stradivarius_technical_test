package com.icdominguez.stradivariustechnicaltest.feature.home.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.icdominguez.stradivariustechnicaltest.core.model.Contact
import com.icdominguez.stradivariustechnicaltest.core.model.ContactLocation

@Composable
fun ContactItem(
    contact: Contact,
    onUserClicked: (Contact) -> Unit
) {
    Column(
        modifier = Modifier.clickable {
            onUserClicked(contact)
        }
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                model = contact.picture,
                contentDescription = "${contact.name} image",
            )

            Column {
                Text(
                    text = contact.name,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = FontWeight.Medium,
                    ),
                )
                Text(
                    text = contact.email,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    ),
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                modifier = Modifier.width(15.dp).height((15.dp)),
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Arrow forward",
                tint = Color.LightGray
            )
        }

        Divider(
            modifier = Modifier.padding(start = 90.dp),
            color = Color.LightGray
        )
    }

}

@Composable
@Preview
fun ContactItemPreview() {
    ContactItem(
        contact =
            Contact(
                name = "Mr Karl Johnson",
                email = "karl.johnson@example.com",
                gender = "male",
                location = ContactLocation(
                    latitude = 88.9222,
                    longitude = -82.9558
                ),
                phone = "(268) 420-4900",
                picture = "https://randomuser.me/api/portraits/thumb/men/6.jpg",
                registered = "2014-12-02T18:39:42.988Z"
            ),
        onUserClicked = {}
    )
}

package com.icdominguez.stradivariustechnicaltest.feature.detail.composables

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.icdominguez.stradivariustechnicaltest.feature.maps.MapWithMarker
import com.icdominguez.stradivariustechnicaltest.core.designsystem.component.StradivariusTopAppBar
import com.icdominguez.stradivariustechnicaltest.feature.detail.DetailViewModel
import com.icdominguez.stradivariustechnicaltest.feature.detail.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    uiEvent: (DetailViewModel.Event) -> Unit,
    onBackClick: () -> Unit,
) {
    val state = viewModel.state.collectAsState().value

    var imageSelected by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }

    val multiplePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(maxItems = 8),
    ) { images ->
        images.forEach {
            imageSelected = it
        }
    }

    Scaffold(
        topBar = {
            TopAppBar({
                StradivariusTopAppBar(
                    title = state.selectedContact?.name ?: "",
                    actionIcon = Icons.Filled.Menu,
                    onActionClick = {},
                    actionIconContentDescription = "Menu Icon",
                    needsNavigationIcon = true,
                    onNavigationButtonClick = onBackClick
                )
            })
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            state.selectedContact?.let { selectedContact ->
                Box {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        painter = painterResource(id = R.drawable.background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    AsyncImage(
                        modifier = Modifier
                            .padding(start = 20.dp, top = 120.dp)
                            .size(80.dp)
                            .clip(CircleShape)
                            .border(
                                2.dp,
                                color = Color.White,
                                shape = CircleShape,
                            )
                            .align(Alignment.CenterStart),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(selectedContact.picture)
                            .crossfade(true)
                            .build(),
                        contentScale = ContentScale.Crop,
                        contentDescription = "User Image",
                    )

                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 20.dp, top = 150.dp),
                    ) {
                        IconButton(onClick = {
                            multiplePhotoPicker.launch(
                                PickVisualMediaRequest(
                                    ActivityResultContracts.PickVisualMedia.ImageOnly,
                                ),
                            )
                        }) {
                            Icon(
                                imageVector = Icons.Default.CameraAlt,
                                contentDescription = "Person Pin Icon",
                            )
                        }

                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Person Pin Icon",
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    CustomTextField(
                        icon = Icons.Default.Person,
                        placeholder = "Nombre y Apellidos",
                        text = selectedContact.name,
                        onTextChanged = {},
                    )
                    CustomTextField(
                        icon = Icons.Default.Email,
                        placeholder = "Email",
                        text = selectedContact.email,
                        onTextChanged = {},
                    )
                    CustomTextField(
                        icon = Icons.Default.Female,
                        placeholder = "Género",
                        text = selectedContact.gender,
                        onTextChanged = {},
                    )
                    CustomTextField(
                        icon = Icons.Default.DateRange,
                        placeholder = "Fecha de registro",
                        text = selectedContact.registered,
                        onTextChanged = {},
                    )
                    CustomTextField(
                        icon = Icons.Default.Phone,
                        placeholder = "Teléfono",
                        text = selectedContact.phone,
                        onTextChanged = {},
                    )

                    Text(
                        modifier = Modifier.padding(start = 70.dp),
                        text = "Dirección",
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        ),
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        MapWithMarker(
                            latitude = selectedContact.location.latitude,
                            longitude = selectedContact.location.longitude
                        )
                    }
                }
            }
        }
    }
}

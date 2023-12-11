package com.icdominguez.stradivariustechnicaltest.feature.home.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.icdominguez.stradivariustechnicaltest.core.designsystem.component.FullScreenLoading
import com.icdominguez.stradivariustechnicaltest.core.designsystem.component.NoDataFound
import com.icdominguez.stradivariustechnicaltest.core.designsystem.component.StradivariusTopAppBar
import com.icdominguez.stradivariustechnicaltest.core.model.Contact
import com.icdominguez.stradivariustechnicaltest.feature.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersScreen(
    viewModel: HomeViewModel,
    uiEvent: (HomeViewModel.Event) -> Unit,
    navigateToDetail: () -> Unit
) {
    val state = viewModel.state.collectAsState().value

    val contactPagingItems: LazyPagingItems<Contact> =
        viewModel.usersState.collectAsLazyPagingItems()

    //val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            /*TopAppBar(
                title = {
                    Text(text = "Contacts")
                },
                actions = {},
                scrollBehavior = scrollBehavior,
            )*/
            StradivariusTopAppBar(
                title = "Contacts"
            )
        },
    ) { paddingValues ->

        when (contactPagingItems.loadState.refresh) {
            is androidx.paging.LoadState.Loading -> {
                FullScreenLoading()
            }
            is androidx.paging.LoadState.Error -> {
                NoDataFound()
            }
            else -> {
                LazyColumn(modifier = Modifier.padding(paddingValues)) {
                    items(contactPagingItems.itemCount) { index ->
                        ContactItem(
                            contact = contactPagingItems[index]!!,
                            onUserClicked = {
                                uiEvent(HomeViewModel.Event.OnUserClicked(it))
                                navigateToDetail()
                            }
                        )
                    }
                }
            }
        }
    }
}

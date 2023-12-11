package com.icdominguez.stradivariustechnicaltest.feature.home.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

    Scaffold(
        topBar = {
            StradivariusTopAppBar(
                title = "Contacts"
            )
        },
    ) { paddingValues ->

        DockedSearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            query = state.searchText,
            onQueryChange = {
                uiEvent(
                    HomeViewModel.Event.OnSearchTextChanged(
                        it
                    ),
                )
            },
            onSearch = {
                uiEvent(HomeViewModel.Event.OnSearchClicked)
            },
            active = state.isSearchBarActive,
            onActiveChange = { uiEvent(HomeViewModel.Event.OnSearchBarActiveChange) },
            placeholder = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = ""
                )
            },
            trailingIcon = {
                if(state.isSearchBarActive) {
                    Icon(
                        modifier = Modifier.clickable {
                            uiEvent(
                                HomeViewModel.Event.OnSearchBarClose
                            )
                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close search bar"
                    )
                }
            }
        ) {
            LazyColumn {
                items(state.searchHistory) {
                    Row(
                        modifier = Modifier
                            .padding(all = 14.dp)
                            .clickable {
                                uiEvent(
                                    HomeViewModel.Event.OnHistoryItemClicked(it)
                                )
                            }
                    ) {
                        Icon(
                            modifier = Modifier.padding(end = 10.dp),
                            imageVector = Icons.Default.History,
                            contentDescription = ""
                        )
                        Text(text = it)
                    }
                }
            }
        }

        Column {
            when (contactPagingItems.loadState.refresh) {
                is androidx.paging.LoadState.Loading -> {
                    FullScreenLoading()
                }
                is androidx.paging.LoadState.Error -> {
                    NoDataFound()
                }
                else -> {
                    if(contactPagingItems.itemCount > 0) {
                        LazyColumn(
                            modifier = Modifier.padding(paddingValues)
                        ) {
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
                    } else {
                        NoDataFound()
                    }
                }
            }
        }
    }
}

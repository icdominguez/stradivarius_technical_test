package com.icdominguez.stradivariustechnicaltest.feature.home

import android.util.Log
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.icdominguez.stradivariustechnicaltest.core.common.mvi.MviViewModel
import com.icdominguez.stradivariustechnicaltest.core.model.Contact
import com.icdominguez.stradivariustechnicaltest.domain.contacts.GetAllContactsUseCase
import com.icdominguez.stradivariustechnicaltest.domain.contacts.StoreUserUseCase
import com.icdominguez.stradivariustechnicaltest.feature.home.serializer.ContactSerializer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllUsersUseCase: GetAllContactsUseCase,
    private val storeUserUseCase: StoreUserUseCase,
    private val contactSerializer: ContactSerializer,
) : MviViewModel<HomeViewModel.State, HomeViewModel.Event>() {

    private val _usersState: MutableStateFlow<PagingData<Contact>> =
        MutableStateFlow(value = PagingData.empty())
    val usersState: MutableStateFlow<PagingData<Contact>> get() = _usersState

    data class State(
        val lastContactsStored: PagingData<Contact> = PagingData.empty(),
        val searchText: String = "",
        val isSearchBarActive: Boolean = false,
        val searchHistory: List<String> = emptyList(),
        val showBottomSheetDialog: Boolean = false
    )

    override var currentState = State()

    init {
        getAllContacts()
    }

    sealed class Event {
        class OnUserClicked(val contact: Contact) : Event()
        class OnSearchTextChanged(val newSearchText: String) : Event()
        data object OnSearchClicked : Event()
        data object OnSearchBarActiveChange : Event()
        data object OnSearchBarClose : Event()
        class OnHistoryItemClicked(val historyItemClicked: String) : Event()
    }

    override fun uiEvent(event: Event) {
        when (event) {
            is Event.OnUserClicked -> {
                try {
                    val userString = contactSerializer.serialize(event.contact)
                    storeUserUseCase(userString)
                } catch (exception: Exception) {
                    Log.e("MY_LOG","There was an error saving user")
                }
            }
            is Event.OnSearchTextChanged -> {
                updateState {
                    copy(
                        searchText = event.newSearchText,
                    )
                }
            }
            is Event.OnSearchClicked -> {
                if (state.value.searchText.isNotEmpty()) {
                    getContactsByFilter()
                    updateState {
                        copy(
                            isSearchBarActive = false,
                            searchHistory = searchHistory.toMutableList()
                                .apply { this.add(state.value.searchText) },
                        )
                    }
                }
            }

            is Event.OnSearchBarActiveChange -> {
                updateState {
                    copy(
                        isSearchBarActive = !isSearchBarActive,
                    )
                }
            }

            is Event.OnSearchBarClose -> {
                getAllContacts()
                updateState {
                    copy(
                        isSearchBarActive = false,
                        searchText = "",
                    )
                }
            }

            is Event.OnHistoryItemClicked -> {
                updateState {
                    copy(
                        searchText = event.historyItemClicked,
                    )
                }
                getContactsByFilter()
                updateState {
                    copy(
                        isSearchBarActive = false,
                        searchText = "",
                    )
                }
            }
        }
    }

    private fun getContactsByFilter() {
        val listFiltered = _usersState.value.filter { it.name.lowercase().contains(state.value.searchText.lowercase()) ||it.email.lowercase().contains(state.value.searchText.lowercase()) }
        _usersState.value = listFiltered
    }

    private fun getAllContacts() {
        viewModelScope.launch {
            getAllUsersUseCase().distinctUntilChanged().cachedIn(viewModelScope).collect { pagingData ->
                _usersState.value = pagingData
            }
        }
    }
}

package com.icdominguez.stradivariustechnicaltest.feature.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
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
        val users: PagingData<Contact> = PagingData.empty(),
    )

    override var currentState = State()

    init {
        getAllUsers()
    }

    sealed class Event {
        class OnUserClicked(val contact: Contact) : Event()
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
        }
    }

    private fun getAllUsers() {
        viewModelScope.launch {
            getAllUsersUseCase().distinctUntilChanged().cachedIn(viewModelScope).collect {
                _usersState.value = it
            }
        }
    }
}

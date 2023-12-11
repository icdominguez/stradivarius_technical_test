package com.icdominguez.stradivariustechnicaltest.feature.detail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.icdominguez.stradivariustechnicaltest.core.common.mvi.MviViewModel
import com.icdominguez.stradivariustechnicaltest.core.model.Contact
import com.icdominguez.stradivariustechnicaltest.domain.contacts.RetrieveContactUseCase
import com.icdominguez.stradivariustechnicaltest.feature.detail.deserializer.ContactDeserializer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val retrieveUserUseCase: RetrieveContactUseCase,
    private val contactDeserializer: ContactDeserializer
) : MviViewModel<DetailViewModel.State, DetailViewModel.Event>() {

    override var currentState = State()

    init {
        getContactToShow()
    }

    sealed class Event

    override fun uiEvent(event: Event) {
    }

    private fun getContactToShow() {
        viewModelScope.launch {
            val contactSelectedString = retrieveUserUseCase()
            contactSelectedString?.let {
                try {
                    val selectedUser = contactDeserializer.deserialize(it)
                    updateState {
                        copy(
                            selectedContact = selectedUser
                        )
                    }
                } catch (exception: Exception) {
                    Log.e("MY_LOG", "There was an error deserializing contact: $exception")
                }

            }
        }
    }

    data class State(
        val isLoading: Boolean = false,
        val selectedContact: Contact? = null
    )
}

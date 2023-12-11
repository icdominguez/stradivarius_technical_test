package com.icdominguez.stradivariustechnicaltest.domain.contacts

import com.icdominguez.stradivariustechnicaltest.data.users.repository.UsersRepository
import javax.inject.Inject

class StoreUserUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    operator fun invoke(user: String) = usersRepository.storeUser(user)
}
package com.icdominguez.stradivariustechnicaltest.domain.contacts

import com.icdominguez.stradivariustechnicaltest.data.users.repository.UsersRepository
import javax.inject.Inject

class GetAllContactsUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {

    suspend operator fun invoke() = usersRepository.getAllUsers()
}
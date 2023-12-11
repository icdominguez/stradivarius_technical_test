package com.icdominguez.stradivariustechnicaltest.core.preferences

import android.content.SharedPreferences
import javax.inject.Inject

class LocalStradivariusPreferencesDataSource @Inject constructor(
    private val sharedPreferences: SharedPreferences
): StradivariusPreferencesDataSource {

    override fun setUser(user: String) {
        sharedPreferences.edit().putString(USER, user).apply()
    }

    override fun getUser(): String? = sharedPreferences.getString(USER, null)

    companion object {
        private const val USER: String = "user"
    }

}
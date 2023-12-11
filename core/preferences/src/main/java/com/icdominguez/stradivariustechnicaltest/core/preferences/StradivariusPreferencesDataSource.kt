package com.icdominguez.stradivariustechnicaltest.core.preferences

interface StradivariusPreferencesDataSource {
    fun setUser(user: String)
    fun getUser(): String?
}
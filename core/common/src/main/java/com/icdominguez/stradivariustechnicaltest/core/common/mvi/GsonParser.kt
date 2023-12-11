package com.icdominguez.stradivariustechnicaltest.core.common.mvi

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object GsonParser {
    inline fun <reified T> toJson(src: T): String {
        return Gson().toJson(src)
    }

    inline fun <reified T> fromJson(src: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson(src, type)
    }
}
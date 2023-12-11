package com.icdominguez.stradivariustechnicaltest.core.common.mvi.deserializer

import kotlin.jvm.Throws

abstract class JsonDeserializer<T> {
    protected abstract fun deserializeJson(json: String): T

    @Throws(JsonDeserializerException::class)
    fun deserialize(json: String): T = try {
        this.deserializeJson(json)
    } catch (exception: Exception) {
        throw JsonDeserializerException("Exception deserializing: $json", exception)
    }
}
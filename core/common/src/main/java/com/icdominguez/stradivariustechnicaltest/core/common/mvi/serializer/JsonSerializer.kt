package com.icdominguez.stradivariustechnicaltest.core.common.mvi.serializer

abstract class JsonSerializer<T> {

    protected abstract fun serializeJson(any: T): String

    @Throws(JsonSerializerException::class)
    fun serialize(any: T): String = try {
        this.serializeJson(any)
    } catch (exception: Exception) {
        throw JsonSerializerException("Exception serializing object $any", exception)
    }
}
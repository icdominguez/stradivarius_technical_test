package com.icdominguez.stradivariustechnicaltest.core.common.mvi.deserializer

class JsonDeserializerException (
    message: String,
    cause: Throwable? = null
) : Exception(message, cause)
package com.icdominguez.stradivariustechnicaltest.core.common.mvi.serializer

class JsonSerializerException(
    message: String,
    cause: Throwable? = null
) : Exception(message, cause)
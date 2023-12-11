package com.icdominguez.stradivariustechnicaltest.feature.detail.deserializer

import com.icdominguez.stradivariustechnicaltest.core.common.mvi.GsonParser
import com.icdominguez.stradivariustechnicaltest.core.model.Contact
import javax.inject.Inject

internal class GsonContactDeserializer @Inject constructor() : ContactDeserializer() {
    override fun deserializeJson(json: String): Contact =
        GsonParser.fromJson(json)
}
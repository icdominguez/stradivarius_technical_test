package com.icdominguez.stradivariustechnicaltest.feature.home.serializer

import com.icdominguez.stradivariustechnicaltest.core.common.mvi.GsonParser
import com.icdominguez.stradivariustechnicaltest.core.model.Contact
import javax.inject.Inject

class GsonContactSerializer @Inject constructor() : ContactSerializer() {
    override fun serializeJson(contact: Contact): String = GsonParser.toJson(contact)
}
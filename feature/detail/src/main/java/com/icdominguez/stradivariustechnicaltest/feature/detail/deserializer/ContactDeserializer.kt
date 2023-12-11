package com.icdominguez.stradivariustechnicaltest.feature.detail.deserializer

import com.icdominguez.stradivariustechnicaltest.core.common.mvi.deserializer.JsonDeserializer
import com.icdominguez.stradivariustechnicaltest.core.model.Contact

abstract class ContactDeserializer : JsonDeserializer<Contact>()
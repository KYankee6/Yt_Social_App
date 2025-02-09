package com.uicheon.ytsocialapp.android

import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import com.uicheon.ytsocialapp.android.common.datastore.UserSettings
import com.uicheon.ytsocialapp.android.common.datastore.toAuthResultData
import kotlinx.coroutines.flow.map

class MainActivityViewModel(
    private val dataStore: DataStore<UserSettings>
) : ViewModel() {
    val authState = dataStore.data.map { it.toAuthResultData().token }
}
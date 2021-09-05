package com.clint.consolelogapp

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers

class ConsoleLogViewModel : ViewModel() {

    private val _logcat = MutableLiveData<String>()
    val logcat: LiveData<String> = _logcat


    fun logCatOutput() = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        Runtime.getRuntime().exec("logcat -c")
        Runtime.getRuntime().exec("logcat -e")
            .inputStream
            .bufferedReader()
            .useLines { lines ->
                lines.forEach { line -> emit(line) }
            }
    }
}

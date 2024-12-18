package com.dyatmarize.postabletrnd.view.main.pos

import androidx.lifecycle.ViewModel
import com.dyatmarize.postabletrnd.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

//@HiltViewModel
class PosViewModel : BaseViewModel() {
//
    init {
        _isLoading.value = false
        _isDone.value = false
    }
}
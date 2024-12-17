package com.dyatmarize.postabletrnd.view.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dyatmarize.postabletrnd.view.data.ExceptionData
import com.parkee.agentmobile.event.SingleLiveEvent

class BaseViewModel : ViewModel() {
    protected val TAG: String = javaClass.simpleName

    protected val _errorData: SingleLiveEvent<ExceptionData> = SingleLiveEvent()
    val errorData: LiveData<ExceptionData> get() = _errorData

    /**
     * Checker if loading is done, then it will trigger another action in UI
     */
    protected val _isDone: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val isDone: LiveData<Boolean> get() = _isDone

    /**
     * Checker whether something is loading or not
     */
    protected val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> get() = _isLoading
}
package com.dyatmarize.postabletrnd.validator

import androidx.lifecycle.MutableLiveData

/**
 * Validation got from here, special thanks to oozou
 * https://oozou.com/blog/modern-android-form-validations-with-data-binding-147
 *
 * Improved style using generic class, so what we set, they will automatically know what is the type
 */
typealias Predicate<T> = (value: T?) -> Boolean

class LiveDataValidator<T>(private val liveData: MutableLiveData<T>) {
    private val validationRules = mutableListOf<Predicate<T>>()
    private val errorMessages = mutableListOf<String>()


    var error = MutableLiveData<String?>()

    //For checking if the liveData value matches the error condition set in the validation rule predicate
    //The livedata value is said to be valid when its value doesn't match an error condition set in the predicate
    fun isValid(): Boolean {
        for (i in 0 until validationRules.size) {
            if (validationRules[i](liveData.value)) {
                emitErrorMessage(errorMessages[i])
                return false
            }
        }

        emitErrorMessage(null)
        return true
    }

    //For emitting error messages
    private fun emitErrorMessage(messageRes: String?) {
        error.value = messageRes
    }

    //For adding validation rules
    fun addRule(errorMsg: String, predicate: Predicate<T>) {
        validationRules.add(predicate)
        errorMessages.add(errorMsg)
    }

    fun resetErrorMessage() {
        emitErrorMessage(null)
    }
}
package com.dyatmarize.postabletrnd.validator

/**
 * Validation got from here, special thanks to oozou
 * https://oozou.com/blog/modern-android-form-validations-with-data-binding-147
 */
class LiveDataValidatorResolver(private val validators: List<LiveDataValidator<*>>) {
    fun isValid(): Boolean {
        for (validator in validators) {
            if (!validator.isValid()) return false
        }
        return true
    }

    fun resetErrorMessage() {
        for (validator in validators) {
            validator.resetErrorMessage()
        }
    }
}
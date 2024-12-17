package com.dyatmarize.postabletrnd.view.data

data class ExceptionData(
    val throwable: Throwable,
    val messageKey: Int, //Set error message key
    val isAccessDenied: Boolean, //Check if access is denied or not
    val args: List<String>? = null, //More parameter for message
    val developerMessage: String? = null, //For error message in throwable
)

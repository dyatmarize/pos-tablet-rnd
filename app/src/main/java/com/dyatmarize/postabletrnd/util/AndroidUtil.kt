package com.dyatmarize.postabletrnd.util

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import timber.log.Timber

class AndroidUtil {

    companion object {
        const val TAG = "ANDROID_UTIL"

        fun View.blockingClickListener(debounceTime: Long = 1000L, action: (v: View?) -> Unit) {
            this.setOnClickListener(object : View.OnClickListener {
                private var lastClickTime: Long = 0
                override fun onClick(v: View) {
                    val timeNow = SystemClock.elapsedRealtime()
                    val elapsedTimeSinceLastClick = timeNow - lastClickTime
                    Timber.d(
                        "DebounceTime: $debounceTime\n" +
                                "Time Elapsed: $elapsedTimeSinceLastClick\n" +
                                "Is within debounce time: ${elapsedTimeSinceLastClick < debounceTime}"
                    )

                    if (elapsedTimeSinceLastClick < debounceTime) {
                        Timber.d("Double click shielded")
                        return
                    } else {
                        Timber.d("Click happened")
                        action(v)
                    }
                    lastClickTime = SystemClock.elapsedRealtime()
                }
            })
        }

        fun NavController.safeNavigate(direction: NavDirections) {
            currentDestination?.getAction(direction.actionId)?.run { navigate(direction) }
        }

        fun NavController.safeNavigate(
            @IdRes currentDestinationId: Int,
            @IdRes id: Int,
            args: Bundle? = null
        ) {
            if (currentDestinationId == currentDestination?.id) {
                navigate(id, args)
            }
        }
    }
}
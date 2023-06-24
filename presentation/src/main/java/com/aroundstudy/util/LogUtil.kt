package com.aroundstudy.util

import android.util.Log

object LogUtil {
    fun d(message: String) {
        Log.d("aroundLog", message)
    }

    fun e(message: String) {
        Log.e("aroundLog", message)
    }

    fun w(message: String) {
        Log.w("aroundLog", message)
    }

    fun longD(message: String) {
        var msg = message
        try {
            while (msg.isNotEmpty()) {
                if (msg.length > 3000) {
                    d(msg.substring(0, 3000))
                    msg = msg.substring(3000)
                } else {
                    d(msg)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun longE(message: String) {
        var msg = message
        try {
            while (msg.isNotEmpty()) {
                if (msg.length > 3000) {
                    e(msg.substring(0, 3000))
                    msg = msg.substring(3000)
                } else {
                    e(msg)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun longW(message: String) {
        var msg = message
        try {
            while (msg.isNotEmpty()) {
                if (msg.length > 3000) {
                    w(msg.substring(0, 3000))
                    msg = msg.substring(3000)
                } else {
                    w(msg)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
package com.nextint.patani.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutor constructor(private val diskIO : Executor, private val mainThread : Executor
) {
    constructor() : this(
        Executors.newSingleThreadExecutor(),
        MainThreadExecutor()
    )
    fun executeInIOThread() : Executor = diskIO
    fun executeInMainThread() : Executor = mainThread

    private class MainThreadExecutor : Executor {
        val mainThreadHandlerThread = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandlerThread.post(command)
        }

    }
}
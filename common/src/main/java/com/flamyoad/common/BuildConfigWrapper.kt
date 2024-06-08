package com.flamyoad.common

import android.os.Build

interface BuildConfigWrapper {
    fun sdkInt(): Int
}

class BuildConfigWrapperImpl: BuildConfigWrapper {
    override fun sdkInt(): Int {
        return Build.VERSION.SDK_INT
    }
}
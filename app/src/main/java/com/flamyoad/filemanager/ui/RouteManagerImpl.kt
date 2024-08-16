package com.flamyoad.filemanager.ui

import com.flamyoad.common.Route
import com.flamyoad.common.RouteEmitter
import com.flamyoad.common.RouteObserver
import com.flamyoad.gallery_kit_impl.ImageViewerRoute
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.io.File

class RouteManager: RouteObserver, RouteEmitter {
    // https://github.com/Kotlin/kotlinx.coroutines/issues/2387
    // WHAT!
    private val routeFlow = MutableSharedFlow<Route>(
        extraBufferCapacity = 1
    )

    override fun observeRoute(): Flow<Route> {
        return routeFlow.asSharedFlow()
    }

    override fun emitRoute(route: Route) {
        routeFlow.tryEmit(route)
    }
}


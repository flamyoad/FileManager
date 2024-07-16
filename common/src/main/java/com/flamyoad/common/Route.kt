package com.flamyoad.common

import kotlinx.coroutines.flow.Flow

interface Route

interface RouteObserver {
    fun observeRoute(): Flow<Route>
}

interface RouteEmitter {
    fun emitRoute(route: Route)
}
package com.flamyoad.gallery_kit_impl

import android.content.Context
import android.content.Intent
import com.flamyoad.common.RouteEmitter
import com.flamyoad.gallery_kit.GalleryKit
import java.io.File

class GalleryKitImpl(
    private val routeEmitter: RouteEmitter
): GalleryKit {

    override fun openImage(directory: File, selectedPicture: File) {
        routeEmitter.emitRoute(
            ImageViewerRoute(
                directoryPath = directory.path,
                selectedPicture = selectedPicture.path
            )
        )
    }
}
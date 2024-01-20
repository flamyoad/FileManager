package com.flamyoad.gallery_kit_impl

import android.content.Context
import android.content.Intent
import com.flamyoad.gallery_kit.GalleryKit

class GalleryKitImpl: GalleryKit {

    override fun openImage(context: Context) {
        // todo: Replace with real impl
        Intent(context, GalleryActivity::class.java).also {
            context.startActivity(it)
        }
    }
}
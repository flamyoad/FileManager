package com.flamyoad.gallery_kit

import java.io.File

interface GalleryKit {
    fun openImage(directory: File, selectedPicture: File)
}
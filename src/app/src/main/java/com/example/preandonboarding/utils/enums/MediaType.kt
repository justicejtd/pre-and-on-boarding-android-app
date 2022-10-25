package com.example.preandonboarding.utils.enums

/**
 * List of file types that can be used for media message block item.
 * The available type are video, image, gif and document.
 * @param typeName is the name of the file type.
 */
enum class MediaType(val typeName: String) {
    VIDEO("video"),
    IMAGE("image"),
    GIF("gif"),
    DOCUMENT("document")
}
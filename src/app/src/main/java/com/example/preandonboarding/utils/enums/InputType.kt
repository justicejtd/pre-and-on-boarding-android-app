package com.example.preandonboarding.utils.enums

/**
 * The type of input block item.
 * The available types are text, image, document.
 * @param typeName is the name of the input type.
 */
enum class InputType(val typeName: String) {
    TEXT("text"),
    IMAGE("image"),
    DOCUMENT("document")
}
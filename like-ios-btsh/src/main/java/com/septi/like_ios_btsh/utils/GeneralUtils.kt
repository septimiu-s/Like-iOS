package com.septi.like_ios_btsh.utils

fun convertIntToHexColor(colorInt: Int): String =
    java.lang.String.format("#%06X", (0xFFFFFF and colorInt))

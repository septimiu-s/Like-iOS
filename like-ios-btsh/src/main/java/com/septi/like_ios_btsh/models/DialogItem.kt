package com.septi.like_ios_btsh.models

import android.content.Context
import androidx.core.content.ContextCompat
import com.septi.like_ios_btsh.R
import com.septi.like_ios_btsh.utils.convertIntToHexColor

data class DialogItem(
    val context: Context,
    val text: String,
    val color: String = convertIntToHexColor(ContextCompat.getColor(context, R.color.blue_ios))
)
package com.example.mymeditationui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

/**
 * @author zkmsz
 * @date ٢٦‏/٩‏/٢٠٢١
 */
data class Feature(
    val title:String,
    @DrawableRes val iconId:Int,
    val lightColor:Color,
    val mediumColor:Color,
    val darkColor: Color
)

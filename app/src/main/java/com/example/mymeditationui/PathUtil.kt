package com.example.mymeditationui

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path

/**
 * @author zkmsz
 * @date ٢٧‏/٩‏/٢٠٢١
 */

fun Path.standard(from:Offset, to:Offset){

    quadraticBezierTo(
        from.x,
        from.y,
        (from.x + to.y)/2,
        (from.y + to.y)/2
    )

}
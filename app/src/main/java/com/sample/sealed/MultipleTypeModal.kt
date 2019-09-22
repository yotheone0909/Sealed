package com.sample.sealed

import androidx.annotation.DrawableRes

/*
* Created by yothinindy on 2019-08-25.
*/

sealed class MultipleTypeModal {
    abstract val type: Int
}

data class Header(val header: String, override val type: Int) : MultipleTypeModal()

data class Body(
    val typeStartMusic: String,
    val typeEndMusic: String,
    @DrawableRes val imageStartRes: Int,
    @DrawableRes val imageEndRes: Int,
    override val type: Int
) : MultipleTypeModal()

data class Footer(override val type: Int) : MultipleTypeModal()

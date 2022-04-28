package com.example.core3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable


@Parcelize
class medalrecord (
    val country: String,
    val ioccode: String,
    val timescompeted: Int,
    val gold: Int,
    val silver :Int,
    val bronze: Int
    )
    : Parcelable, Serializable {}
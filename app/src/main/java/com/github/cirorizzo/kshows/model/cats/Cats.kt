package com.github.cirorizzo.kshows.model.cats

import java.util.*


data class Cats(var data: Data? = null)

data class Data(var images: ArrayList<Image>? = null)

data class Image(var url: String? = "", var id: String? = "", var source_url: String? = "")
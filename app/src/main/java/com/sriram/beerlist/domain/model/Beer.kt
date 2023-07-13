package com.sriram.beerlist.domain.model

data class Beer(
    val id: Int,
    val name: String,
    val tagLine: String?,
    val description: String,
    val firstBrewed: String,
    val imageUrl: String?
)

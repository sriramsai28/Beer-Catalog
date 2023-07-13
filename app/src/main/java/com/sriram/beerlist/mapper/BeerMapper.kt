package com.sriram.beerlist.mapper

import com.sriram.beerlist.data.database.BeerEntity
import com.sriram.beerlist.data.remote.BeerDto
import com.sriram.beerlist.domain.model.Beer

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagLine = tagLine,
        firstBrewed = first_brewed,
        imageUrl = image_url,
        description = description
    )
}

fun BeerEntity.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagLine = tagLine,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl,
        description = description
    )
}
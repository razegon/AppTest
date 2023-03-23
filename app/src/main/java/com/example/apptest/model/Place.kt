package com.example.apptest.model

import com.example.apptest.R

data class Place(
    val id: Int,
    val titleResourceId: Int,
    val transTitleResourceId: Int,
    val titleDescriptionId: Int = R.string.card_description_text,
    val imageResourceId: Int,
    //val imageBanner: Int,
    val placesDescription1: Int = R.string.places_detail_text,
    val placesDescription2: Int = R.string.places_detail_text,
    val placesDescription3: Int = R.string.places_detail_text
)


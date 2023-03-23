package com.example.apptest.data

import com.example.apptest.R
import com.example.apptest.model.Place

object PlacesData {

    fun getArchZonesData(): ArrayList<Place> {
        return arrayListOf(
            Place(
                id = 1,
                titleResourceId = R.string.chichen_itza,
                transTitleResourceId = R.string.trans_chichen_itza,
                titleDescriptionId = R.string.discovery_chichen_itza,
                imageResourceId = R.drawable.img_chichen_itza,
                placesDescription1 = R.string.desc1_chichen_itza,
                placesDescription2 = R.string.desc2_chichen_itza,
                placesDescription3 = R.string.desc3_chichen_itza
            ),
            Place(
                id = 2,
                titleResourceId = R.string.tulum,
                transTitleResourceId = R.string.trans_tulum,
                titleDescriptionId = R.string.discovery_tulum,
                imageResourceId = R.drawable.img_tulum,
                placesDescription1 = R.string.desc1_tulum,
                placesDescription2 = R.string.desc2_tulum,
                placesDescription3 = R.string.desc3_tulum
            ),
            Place(
                id = 3,
                titleResourceId = R.string.coba,
                transTitleResourceId = R.string.trans_coba,
                titleDescriptionId = R.string.discovery_coba,
                imageResourceId = R.drawable.img_coba,
                placesDescription1 = R.string.desc1_chichen_itza
            ),
            Place(
                id = 4,
                titleResourceId = R.string.ek_balam,
                transTitleResourceId = R.string.trans_ek_balam,
                titleDescriptionId = R.string.discovery_ek_balam,
                imageResourceId = R.drawable.img_ek_balam,

            ),
            Place(
                id = 5,
                titleResourceId = R.string.uxmal,
                transTitleResourceId = R.string.trans_uxmal,
                titleDescriptionId = R.string.discovery_uxmal,
                imageResourceId = R.drawable.img_uxmal,
            ),
            Place(
                id = 6,
                titleResourceId = R.string.palenque,
                transTitleResourceId = R.string.trans_palenque,
                titleDescriptionId = R.string.discovery_palenque,
                imageResourceId = R.drawable.img_palenque,
            ),
            Place(
                id = 7,
                titleResourceId = R.string.yaxchilan,
                transTitleResourceId = R.string.trans_yaxchilan,
                titleDescriptionId = R.string.discovery_yaxchilan,
                imageResourceId = R.drawable.img_yaxchilan,
            ),
            Place(
                id = 8,
                titleResourceId = R.string.bonampak,
                transTitleResourceId = R.string.trans_bonampak,
                titleDescriptionId = R.string.discovery_bonampak,
                imageResourceId = R.drawable.img_bonampak,
            )
        )
    }

    fun getCitiesData(): ArrayList<Place> {
        return arrayListOf(
            Place(
                id = 1,
                titleResourceId = R.string.cancun,
                transTitleResourceId = R.string.trans_cancun,
                imageResourceId = R.drawable.img_cancun,
                placesDescription1 = R.string.desc1_chichen_itza
            ),
            Place(
                id = 2,
                titleResourceId = R.string.playa_del_carmen,
                transTitleResourceId = R.string.trans_playa_del_carmen,
                imageResourceId = R.drawable.img_playa_del_carmen
            ),
            Place(
                id = 3,
                titleResourceId = R.string.tulum_city,
                transTitleResourceId = R.string.trans_tulum_city,
                imageResourceId = R.drawable.img_tulum_city
            )
        )
    }

    fun getNatureData(): ArrayList<Place> {
        return arrayListOf(
            Place(
                id = 1,
                titleResourceId = R.string.cenote_azul,
                transTitleResourceId = R.string.trans_cenote_azul,
                imageResourceId = R.drawable.img_cenote_azul
            ),
            Place(
                id = 2,
                titleResourceId = R.string.gran_cenote,
                transTitleResourceId = R.string.trans_gran_cenote,
                imageResourceId = R.drawable.img_gran_cenote
            ),
            Place(
                id = 3,
                titleResourceId = R.string.las_coloradas,
                transTitleResourceId = R.string.trans_las_coloradas,
                imageResourceId = R.drawable.img_las_coloradas
            )
        )
    }

}
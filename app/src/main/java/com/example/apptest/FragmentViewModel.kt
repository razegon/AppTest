package com.example.apptest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptest.data.PlacesData
import com.example.apptest.model.Place

class FragmentViewModel : ViewModel() {

    private var _currentPlace: MutableLiveData<Place> = MutableLiveData<Place>()
    val currentPlace: LiveData<Place>
        get() = _currentPlace

    private var _archZoneData: ArrayList<Place> = ArrayList()
    val archZoneData: ArrayList<Place>
        get() = _archZoneData

    private var _cityData: ArrayList<Place> = ArrayList()
    val cityData: ArrayList<Place>
        get() = _cityData

    private var _natureData: ArrayList<Place> = ArrayList()
    val natureData: ArrayList<Place>
        get() = _natureData

    init {
        _archZoneData = PlacesData.getArchZonesData()
        _cityData = PlacesData.getCitiesData()
        _natureData = PlacesData.getNatureData()
        _currentPlace.value = _archZoneData[0]
    }

    fun updateCurrentPlace(place: Place) {
        _currentPlace.value = place
    }

}
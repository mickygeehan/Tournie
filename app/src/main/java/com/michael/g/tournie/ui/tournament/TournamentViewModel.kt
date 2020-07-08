package com.michael.g.tournie.ui.tournament

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TournamentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Tournament Fragment"
    }
    val text: LiveData<String> = _text
}
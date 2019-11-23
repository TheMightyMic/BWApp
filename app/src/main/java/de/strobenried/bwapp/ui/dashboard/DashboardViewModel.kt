package de.strobenried.bwapp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Do kena d Leid schaun wer im bw is und wos a soiba gsuffa hod."
    }
    val text: LiveData<String> = _text
}
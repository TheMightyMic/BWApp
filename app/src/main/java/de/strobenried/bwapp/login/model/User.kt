package de.strobenried.bwapp.login.model

data class User(val name: String,
                val bio: String) {
    constructor():this("","")
}
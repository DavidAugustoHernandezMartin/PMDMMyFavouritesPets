package edu.augustohernandez.myfavouritespets.model

data class Pet(
    val id: Int,
    val name: String,
    val scientificName: String,
    val furType: String,
    val classType: String,
    val imageUri: String, // Almacenamos la Uri como una cadena
    val loveLevel: Int,
    val additionalInfoLink: String,
    val location:String,
    val isFavorite: Boolean
)
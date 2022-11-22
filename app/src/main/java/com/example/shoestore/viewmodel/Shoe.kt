package com.example.shoestore.viewmodel

// data class with required fields :
data class Shoe(
    var shoeName: String = "",
    var companyName: String = "",
    var shoeSize: Double ?= null,
    var shoeDescription: String = ""
)

package com.example.recyclerviewexample

import androidx.lifecycle.ViewModel

class FruitViewModel : ViewModel() {
    val fruitList = listOf(
        Fruit("Apple"),
        Fruit("Apricot"),
        Fruit("Mango"),
        Fruit("Watermelon")
    )
}
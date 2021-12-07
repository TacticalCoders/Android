package com.example.finallastpractice

import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel(){

    val dataLists = listOf(
        Data("강병하","모든 실패는 실패를 가장한 축복이다.",R.drawable.profile),
        Data("강인하","생각만으로는 힘이 없다.",R.drawable.profile),
        Data("디카프리오","젊은 여자가 최고다.",R.drawable.profile),
        Data("브래드피트","자본주의의 노예가 되지 말거라.",R.drawable.profile)
    )

}
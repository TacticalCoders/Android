package com.example.wordquiz
//데이터 클래스는 구현이 목적이 아니라 데이터 저장을 위한 틀(schema)을 제공.
data class Word(val question: String,
                val number_1: String,
                val number_2: String,
                val number_3: String,
                val number_4: String,
                val answer:Int)

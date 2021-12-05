package com.example.wordquiz

import androidx.lifecycle.ViewModel

class WordDictViewModel : ViewModel() {

    var curIndexDict = 0

    private val wordDictBank = listOf<WordDict>(
        WordDict("degenerate", "퇴화(퇴보)하다", "unity", "단일,통일체,일치,화합",
            "inadvertent", " 부주의한, 소홀한", "array", "(군대를)정렬시키다"),
        WordDict("vanity", "덧없음, 무상함, 공허", "underhand", "비밀의 음흉한",
            "enslave", " 노예로 만들다", "debilitate", "쇠약하게 하다"),
        WordDict("artisan", "기능공", "sadistic", "남을 학대하는", "glossy",
            " 윤이 나는", "obviate", "(위험·곤란)제거하다"),
        WordDict("prostrate", "넘어뜨리다, 항복시키다", "delude", "현혹하다, 속이다",
            "urbane", " 우아한", "renowned", "유명한,명성있는"),
        WordDict("bereave", "(생명, 희망을)빼앗다", "enliven", "활기있게 하다",
            "occult", " 신비로운 불가사의한", "besiege", "포위(공격)하다")
    )

    val curWord1: String
        get() = wordDictBank[curIndexDict].word1
    val curWord1Meaning: String
        get() = wordDictBank[curIndexDict].word1meaning
    val curWord2: String
        get() = wordDictBank[curIndexDict].word2
    val curWord2Meaning: String
        get() = wordDictBank[curIndexDict].word2meaning
    val curWord3: String
        get() = wordDictBank[curIndexDict].word3
    val curWord3Meaning: String
        get() = wordDictBank[curIndexDict].word3meaning
    val curWord4: String
        get() = wordDictBank[curIndexDict].word4
    val curWord4Meaning: String
        get() = wordDictBank[curIndexDict].word4meaning
}
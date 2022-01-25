package com.videogang.tuletkatop.db

import com.videogang.tuletkatop.model.Profile

/* Заглушка, исполняющая роль базы данных
* */
class ProfileBase {
    var ankets = listOf(
        Profile(
            "Виктория Елизарова",
            "Москва",
            photo = "https://cdn.fishki.net/upload/post/2019/10/06/3107236/20190928-131428.jpg"
        ),
        Profile(
            "Марина Белозерова",
            "Казань",
            photo = "https://i.pinimg.com/736x/a0/c8/f5/a0c8f5eab0e0f64ac3658631c79e5800.jpg"
        ),
        Profile(
            "Анна Петрова",
            "Москва",
            photo = "https://shutnikov.club/wp-content/uploads/2020/01/562.jpg"
        )
    )
        private set

    var profile = Profile()

    companion object {
        private var db: ProfileBase? = null

        fun getProfileBase() = db ?: ProfileBase().also {
            db = it
        }
    }
}
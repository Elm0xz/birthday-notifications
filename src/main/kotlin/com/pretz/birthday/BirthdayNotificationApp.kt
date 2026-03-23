package com.pretz.birthday

import org.springframework.boot.runApplication

@SpringBootApplication
class BirthdayNotificationApp {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<BirthdayNotificationApp>(*args)
        }
    }
}

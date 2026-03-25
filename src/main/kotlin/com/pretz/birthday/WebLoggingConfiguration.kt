package com.pretz.birthday

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CommonsRequestLoggingFilter

@Configuration
class WebLoggingConfiguration {
    @Bean
    fun logFilter(): CommonsRequestLoggingFilter {
        val filter = CommonsRequestLoggingFilter()
        filter.setIncludeQueryString(true)
        filter.setIncludePayload(true)
        filter.setIncludeHeaders(false)
        filter.setIncludeClientInfo(true)
        filter.setMaxPayloadLength(10000)
        filter.setAfterMessagePrefix("REQUEST DATA : ")
        return filter
    }
}

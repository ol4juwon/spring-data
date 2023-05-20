package com.ol4juwon.Content.calendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("cc")
public record CCProperties(String message, String about) {
}

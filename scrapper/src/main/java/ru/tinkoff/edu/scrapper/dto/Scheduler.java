package ru.tinkoff.edu.scrapper.dto;

import java.time.Duration;

public record Scheduler(
        Duration interval
) {
}

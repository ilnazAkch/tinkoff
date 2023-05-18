package ru.tinkoff.edu.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Links {
    GITHUB("github.com"),
    STACK_OVERFLOW("stackoverflow.com");

    private final String host;
}

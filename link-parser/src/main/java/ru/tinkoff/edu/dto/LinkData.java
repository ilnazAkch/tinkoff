package ru.tinkoff.edu.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.tinkoff.edu.enums.Links;

import java.net.URL;

@AllArgsConstructor
@NoArgsConstructor
public abstract class LinkData {
    private URL url;
    private Links links;
}

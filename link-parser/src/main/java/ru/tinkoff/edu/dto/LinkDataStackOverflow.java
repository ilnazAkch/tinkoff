package ru.tinkoff.edu.dto;

import lombok.Data;
import ru.tinkoff.edu.enums.Links;

import java.net.URL;

@Data
public final class LinkDataStackOverflow extends LinkData{
    private Long id;

    public LinkDataStackOverflow(URL url, Links links, Long id) {
        super(url, links);
        this.id = id;
    }
}

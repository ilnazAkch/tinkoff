package ru.tinkoff.edu.dto;

import lombok.Data;
import ru.tinkoff.edu.enums.Links;

import java.net.URL;

@Data
public final class LinkDataGithub extends LinkData{
    private String user;
    private String repository;

    public LinkDataGithub(URL url, Links links, String user, String repository) {
        super(url, links);
        this.user = user;
        this.repository = repository;
    }
}

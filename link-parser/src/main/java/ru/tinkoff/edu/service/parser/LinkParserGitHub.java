package ru.tinkoff.edu.service.parser;

import ru.tinkoff.edu.dto.LinkData;
import ru.tinkoff.edu.dto.LinkDataGithub;
import ru.tinkoff.edu.enums.Links;

import java.net.URL;

final class LinkParserGitHub extends LinkParser{

    @Override
    public LinkData parseUrl(URL url) {
        if (url.getHost().equals(Links.GITHUB.getHost())) {
            String[] githubPath = url.getPath().replaceFirst("/", "").split("/");
            if (githubPath.length == 2) {
                return new LinkDataGithub(
                        url,
                        Links.GITHUB,
                        githubPath[0],
                        githubPath[1]
                );
            } else {
                return null;
            }
        } else if (nextParser != null) {
            return nextParser.parseUrl(url);
        }
        return null;
    }
}

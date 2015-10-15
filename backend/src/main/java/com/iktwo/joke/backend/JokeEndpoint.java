package com.iktwo.joke.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.joke.iktwo.com",
                ownerName = "backend.joke.iktwo.com",
                packagePath = ""
        )
)
public class JokeEndpoint {
    @ApiMethod(name = "tellJoke")
    public JokeBean tellJoke(JokeBean joke) {
        return joke;
    }
}

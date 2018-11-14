package com.data.reactive.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "db")
public class DbProperties {

    String name, user, password, url;
    Server server;

    @Data
    public static class Server {
        String host;
        Integer port;
    }
}
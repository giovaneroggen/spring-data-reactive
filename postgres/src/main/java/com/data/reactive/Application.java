package com.data.reactive;

import com.data.reactive.data.NothingEntity;
import com.data.reactive.data.repository.NothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@EnableWebFlux
@SpringBootApplication
public class Application{

    @Autowired
    private NothingRepository nothingRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return route(GET("/nothing/{id}"), req -> {
            Long id = Long.parseLong(req.pathVariable("id"));
            this.nothingRepository.findById(id);
            return ok()
                    .body(this.nothingRepository.findById(id), NothingEntity.class);
        });
    }
}

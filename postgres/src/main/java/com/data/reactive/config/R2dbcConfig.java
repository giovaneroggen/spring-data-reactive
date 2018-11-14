package com.data.reactive.config;

import com.data.reactive.config.properties.DbProperties;
import com.data.reactive.data.repository.NothingRepository;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;

@Configuration
public class R2dbcConfig {

    @Autowired
    private DbProperties dbProperties;

    @Bean
    R2dbcRepositoryFactory factory(DatabaseClient client) {
        RelationalMappingContext context = new RelationalMappingContext();
        context.afterPropertiesSet();
        return new R2dbcRepositoryFactory(client, context);
    }

    @Bean
    DatabaseClient databaseClient(PostgresqlConnectionFactory connectionFactory) {
        return DatabaseClient.create(connectionFactory);
    }

    @Bean
    PostgresqlConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .database(this.dbProperties.getName())
                .username(this.dbProperties.getUser())
                .password(this.dbProperties.getPassword())
                .host(this.dbProperties.getServer().getHost())
                .port(this.dbProperties.getServer().getPort())
                .build());
    }

    @Bean
    NothingRepository nothingRepository(R2dbcRepositoryFactory factory){
        return factory.getRepository(NothingRepository.class);
    }
}

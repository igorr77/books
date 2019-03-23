package ru.otus.igorr.books.lesson06.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(ConnectionSettings.class)
public class DataBaseConfig {

    private final ConnectionSettings connectionSettings;

    @Autowired
    public DataBaseConfig(ConnectionSettings connectionSettings) {
        this.connectionSettings = connectionSettings;
    }

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(connectionSettings.getJdbcDriver());
        hikariConfig.setJdbcUrl(connectionSettings.getJdbcString());
        hikariConfig.setUsername(connectionSettings.getJdbcUser());
        hikariConfig.setPassword(connectionSettings.getJdbcPassword());
        hikariConfig.setMaximumPoolSize(connectionSettings.getJdbcMaxPoolSize());
        hikariConfig.setPoolName("main");
        return new HikariDataSource(hikariConfig);
    }
}

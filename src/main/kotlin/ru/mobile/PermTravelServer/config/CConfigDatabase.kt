package ru.mobile.PermTravelServer.config

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@Configuration
@EnableR2dbcRepositories
class CConfigDatabase {

    @Bean
    fun databaseInitializer(connectionFactory: ConnectionFactory): ConnectionFactoryInitializer =
        ConnectionFactoryInitializer().apply {
            setConnectionFactory(connectionFactory)
            setDatabasePopulator(
                CompositeDatabasePopulator().apply {
                    addPopulators(
                        ResourceDatabasePopulator(
                            // Функции ниже добавляют структуру БД и данные. На данный момент они не нужны,
                            // поскольку данные и структура уже есть в БД (также БД уже менялась, поэтому если
                            // это раскомментировать то проект упадёт с ошибкой). Если необходимо сделать
                            // подобные скрипты для своих данных, то создайте свои SQL-файлы и сделайте ссылку на них ниже
                            // ClassPathResource("sql/schema.sql"),
                            // ClassPathResource("sql/data.sql")
                        )
                    )
                }
            )
        }
}
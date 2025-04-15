package ru.mobile.PermTravelServer.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter
import ru.mobile.PermTravelServer.handlers.CHandlerAuthors
import ru.mobile.PermTravelServer.handlers.CHandlerFiles
import ru.mobile.PermTravelServer.handlers.CHandlerPlaces
import ru.mobile.PermTravelServer.handlers.CHandlerPosts

@Configuration
class CConfigRouter {
    @Bean
    fun routesPlaces (
        handlerPlaces: CHandlerPlaces
    ) = coRouter {
        GET("/places", handlerPlaces::getAll)
        GET("/places/{id}", handlerPlaces::getById)
        onError<Exception> { e, _ -> badRequest()
            .bodyValueAndAwait("Ошибка на стороне сервера.\n"+e.message+"\n"+e.stackTrace.joinToString(separator = "\n"))
        }
    }

    @Bean
    fun routesFiles(
        handlerFiles : CHandlerFiles
    ) = coRouter  {
        GET("/files/{id}", handlerFiles::getById )
        onError<Exception> { e, _ -> badRequest()
            .bodyValueAndAwait("Ошибка на стороне сервера.\n"+e.message+"\n"+e.stackTrace.joinToString(separator = "\n"))
        }
    }

    @Bean
    fun routesAuthors (
        handlerAuhors: CHandlerAuthors
    ) = coRouter {
        GET("/authors", handlerAuhors::getAll)
        GET("/authors/{id}", handlerAuhors::getById)
        onError<Exception> { e, _ -> badRequest()
            .bodyValueAndAwait("Ошибка на стороне сервера. \n"+e.message+"\n"+e.stackTrace.joinToString(separator = "\n"))
        }
    }

    @Bean
    fun routesPosts (
        handlerPosts: CHandlerPosts
    ) = coRouter {
        GET("/posts/{authorId}", handlerPosts::getAllByAuthor)
        onError<Exception> { e, _ -> badRequest()
            .bodyValueAndAwait("Ошибка на стороне сервера. \n"+e.message+"\n"+e.stackTrace.joinToString(separator = "\n"))
        }
    }

    @Bean
    fun postRoutes(handler: CHandlerPosts)
    = coRouter {
            POST("/posts", handler::createPost)
        onError<Exception> { e, _ -> badRequest()
            .bodyValueAndAwait("Ошибка на стороне сервера. \n"+e.message+"\n"+e.stackTrace.joinToString(separator = "\n"))
        }
    }
}
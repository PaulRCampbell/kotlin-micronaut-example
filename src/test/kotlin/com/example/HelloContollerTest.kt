package com.example

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test



@MicronautTest
class HelloContollerTest {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient


    @Test
    fun controllerReturnsHello() {

        val result = client.toBlocking().retrieve("/hello")
        assertEquals("Hello World", result)
    }
}
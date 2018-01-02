package com.example.demo

import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Component

data class Person
(
    val id: String,
    @Version val version: Long? = null
)

@Component
class PersonHandler(val template: ReactiveMongoTemplate)
{
    fun initialize()
    {
        val jim = Person("Jim")
        require(jim.version == null)

        template.save<Person>(jim).block()
        require(jim.version == null)
        {
            "Immutable object has been modified"
        }
    }
}
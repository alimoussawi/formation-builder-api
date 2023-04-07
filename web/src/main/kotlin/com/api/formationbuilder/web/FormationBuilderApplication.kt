package com.api.formationbuilder.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.api.formationbuilder"])
open class FormationBuilderApplication
    fun main(args: Array<String>) {
        runApplication<FormationBuilderApplication>(*args)
    }




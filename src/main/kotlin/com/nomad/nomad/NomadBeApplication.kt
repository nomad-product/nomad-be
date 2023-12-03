package com.nomad.nomad

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NomadBeApplication

fun main(args: Array<String>) {
    runApplication<NomadBeApplication>(*args)
}

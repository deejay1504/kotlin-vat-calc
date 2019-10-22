package org.springframework.vatcalc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Vat Calculator Spring Boot Application.
 *
 * @author Dee Jay
 */
@SpringBootApplication
class VatCalculatorApplication

fun main(args: Array<String>) {
    runApplication<VatCalculatorApplication>(*args)
}

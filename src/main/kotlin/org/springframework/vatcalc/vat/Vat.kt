package org.springframework.vatcalc.vat

import javax.validation.constraints.NotEmpty

class Vat () {
    var monthAndYear = ""

    @NotEmpty
    var numberOfDays = ""

    @NotEmpty
    var dailyRate = ""

    var netAmount = ""

    var vatAmount = ""

    var grossAmount = ""

}

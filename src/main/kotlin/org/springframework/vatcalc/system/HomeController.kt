/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.vatcalc.system

import org.springframework.stereotype.Controller
import org.springframework.vatcalc.vat.Vat
import org.springframework.vatcalc.vat.VatDetails
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    val VIEWS_VAT_CALC__FORM = "vat/vatCalcForm"


    @GetMapping("/")
    fun welcome(model: MutableMap<String, Any>): String {
        var vatRow1 = Vat()
        var vatRow2 = Vat()
        var vatRow3 = Vat()
        vatRow1.monthAndYear = "Jan 2019"
        vatRow2.monthAndYear = "Feb 2019"
        vatRow3.monthAndYear = "Mar 2019"

        var vatList: ArrayList<Vat> = ArrayList<Vat>()
        vatList.add(vatRow1)

        model["vatDetails"] = VatDetails(vatList)

        return VIEWS_VAT_CALC__FORM
    }
}

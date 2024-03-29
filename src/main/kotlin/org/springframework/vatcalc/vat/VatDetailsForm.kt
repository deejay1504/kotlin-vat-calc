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
package org.springframework.vatcalc.vat

/**
 * Simple domain object representing a list of vat items.
 */
class VatDetailsForm {

    var currentQuarter = 1

    var vatList: List<Vat>? = null

    var totalGrossAmount = "%.2f".format(0.00)

    var outputVat = "%.2f".format(0.00)
}

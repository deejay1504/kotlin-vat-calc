package org.springframework.vatcalc.service

import org.springframework.stereotype.Service
import org.springframework.vatcalc.vat.Vat
import org.springframework.vatcalc.vat.VatDetails

@Service
class VatService {

    fun createVatDetails(): VatDetails {
        var vatRow1 = Vat()
        var vatRow2 = Vat()
        var vatRow3 = Vat()

        vatRow1.monthAndYear = "Jan 2019"
        vatRow2.monthAndYear = "Feb 2019"
        vatRow3.monthAndYear = "Mar 2019"

        var vatList: ArrayList<Vat> = ArrayList<Vat>()
        vatList.add(vatRow1)
        vatList.add(vatRow2)
        vatList.add(vatRow3)

        return VatDetails(vatList)
    }

}

package org.springframework.vatcalc.service

import org.springframework.stereotype.Service
import org.springframework.vatcalc.vat.Vat
import org.springframework.vatcalc.vat.VatDetailsForm

@Service
class VatService {

    fun createVatDetails(): VatDetailsForm {
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

        var vatDetailsForm = VatDetailsForm()
        vatDetailsForm.vatList = vatList

        return vatDetailsForm
    }

    fun calculateVat(vatDetailsForm: VatDetailsForm): VatDetailsForm {
        var vatList: ArrayList<Vat> = ArrayList<Vat>()

        var totalGrossAmount = 0.00

        vatDetailsForm.vatList?.forEach {
            var vatRow = Vat()
            vatRow.monthAndYear = it.monthAndYear
            vatRow.numberOfDays = it.numberOfDays
            vatRow.dailyRate    = it.dailyRate
            vatRow.netAmount    = it.dailyRate * it.numberOfDays
            vatRow.vatAmount    = vatRow.netAmount * 0.20
            vatRow.grossAmount  = vatRow.netAmount + vatRow.vatAmount
            totalGrossAmount   += vatRow.grossAmount
            vatList.add(vatRow)
        }

        var returnVatDetailsForm = VatDetailsForm()
        returnVatDetailsForm.vatList = vatList
        returnVatDetailsForm.totalGrossAmount = totalGrossAmount
        returnVatDetailsForm.outputVat = totalGrossAmount * 0.175

        return returnVatDetailsForm
    }

}

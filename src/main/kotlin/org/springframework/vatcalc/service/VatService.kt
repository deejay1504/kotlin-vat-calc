package org.springframework.vatcalc.service

import org.springframework.stereotype.Service
import org.springframework.vatcalc.vat.Vat
import org.springframework.vatcalc.vat.VatDetailsForm
import java.util.*
import kotlin.collections.ArrayList

@Service
class VatService {

    fun createVatDetails(): VatDetailsForm {
        val vatList: ArrayList<Vat> = ArrayList()
        Collections.addAll(vatList, Vat(), Vat(), Vat())

        val vatDetailsForm = VatDetailsForm()
        vatDetailsForm.vatList = vatList

        return vatDetailsForm
    }

    fun calculateVat(vatDetailsForm: VatDetailsForm): VatDetailsForm {
        val vatList: ArrayList<Vat> = ArrayList()

        var totalGrossAmount = 0.00

        vatDetailsForm.vatList?.forEach {
            val vatRow = Vat()
            vatRow.monthAndYear = it.monthAndYear
            vatRow.numberOfDays = it.numberOfDays
            vatRow.dailyRate    = it.dailyRate
            val dailyRate       = it.dailyRate.toDouble()
            val netAmount       = dailyRate * it.numberOfDays
            val vatAmount       = netAmount * 0.20
            val grossAmount     = netAmount + vatAmount
            vatRow.netAmount    = "%.2f".format(netAmount)
            vatRow.vatAmount    = "%.2f".format(vatAmount)
            vatRow.grossAmount  = "%.2f".format(grossAmount)
            totalGrossAmount   += grossAmount
            vatList.add(vatRow)
        }

        val returnVatDetailsForm = VatDetailsForm()
        returnVatDetailsForm.currentQuarter = vatDetailsForm.currentQuarter
        returnVatDetailsForm.vatList = vatList
        returnVatDetailsForm.totalGrossAmount = "%.2f".format(totalGrossAmount)
        returnVatDetailsForm.outputVat = "%.2f".format(totalGrossAmount * 0.165)

        return returnVatDetailsForm
    }

}

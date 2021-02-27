package com.target.targetcasestudy.data

/**
 * For an explanation of how to validate credit card numbers read:
 *
 * https://www.freeformatter.com/credit-card-number-generator-validator.html#fakeNumbers
 *
 * This contains a breakdown of how this algorithm should work as
 * well as a way to generate fake credit card numbers for testing
 *
 * The structure and signature of this is open to modification, however
 * it *must* include a method, field, etc that returns a [Boolean]
 * indicating if the input is valid or not
 *
 * Additional notes:
 *  * This method does not need to validate the credit card issuer
 *  * This method must validate card number length (13 - 19 digits), but does not
 *    need to validate the length based on the issuer.
 *
 * @param creditCardNumber - credit card number of (13, 19) digits
 * @return true if a credit card number is believed to be valid,
 * otherwise false
 */
class CredCardValidator(){
  private val listOfPattern by lazy {
    listOfCreditCard()
  }

  fun validateCreditCard(creditCardNumber: String): Boolean {
    listOfPattern.forEach { it ->
      if(creditCardNumber.matches(it.toRegex())&& creditCardNumber.length<=19 && creditCardNumber.length>=13){
        return true
      }
    }
    return false
  }

  private fun listOfCreditCard(): List<String> {
    val ptVisa = "^4[0-9]{6,}$"
    val ptMasterCard = "^5[1-5][0-9]{5,}$"
    val ptAmeExp = "^3[47][0-9]{5,}$"
    val ptDinClb = "^3(?:0[0-5]|[68][0-9])[0-9]{4,}$"
    val ptDiscover = "^6(?:011|5[0-9]{2})[0-9]{3,}$"
    val ptJcb = "^(?:2131|1800|35[0-9]{3})[0-9]{3,}$"
    return listOf(ptVisa,ptMasterCard,ptAmeExp,ptDinClb,ptDiscover,ptJcb)
  }
}

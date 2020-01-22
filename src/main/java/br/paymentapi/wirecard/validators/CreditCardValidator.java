package br.paymentapi.wirecard.validators;

import br.paymentapi.wirecard.models.Card;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCardValidator {

    private Card creditCard;

    public CreditCardValidator(Card creditCard) {
        this.creditCard = creditCard;
    }

    public boolean validateCreditCard() throws ParseException {
        boolean isValid = false;

        if (this.validateCreditCardNumber() && this.cardExpired()){
            isValid = true;
        }

        return isValid;
    }

    public boolean validateCreditCardNumber() {
        return creditCard.getNumber() != null && creditCard.getNumber().replaceAll("[.\\s]", "").matches("\\d{13,19}");
    }

    private boolean cardExpired() throws ParseException {

        DateFormat formatter;
        formatter = new SimpleDateFormat("MM/yyyy");
        Date date = formatter.parse(creditCard.getExpiration());

        return date.compareTo(new Date()) > 0 ? true : false;

    }
}

package br.paymentapi.wirecard.validators;

import br.paymentapi.wirecard.models.Card;

public class CreditCardValidator {

    private Card creditCard;

    public CreditCardValidator(Card creditCard) {
        this.creditCard = creditCard;
    }

    public boolean validateCreditCard() {

    }

    public boolean validateCreditCardNumber() {
        return creditCard.getNumber() != null && creditCard.getNumber().replaceAll("[.\\s]", "").matches("\\d{13,19}");
    }

    private boolean cardExpired() {

        return false;
    }
}

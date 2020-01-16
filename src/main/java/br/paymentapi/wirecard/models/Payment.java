package br.paymentapi.wirecard.models;

import br.paymentapi.wirecard.enums.PaymentType;

public class Payment {

    private Double amount;
    private PaymentType paymentType;
    private Card card;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}

package br.paymentapi.wirecard.models;

import br.paymentapi.wirecard.enums.PaymentType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private Double amount;

    @NotBlank
    private PaymentType paymentType;

    @OneToOne
    @JoinTable(name = "card")
    private Card card;

    @OneToOne
    @JoinTable(name = "buyer")
    private Buyer buyer;

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

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

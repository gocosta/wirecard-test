package br.paymentapi.wirecard.models;

import br.paymentapi.wirecard.enums.PaymentType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private Double amount;

    @NotNull
    private PaymentType paymentType;

    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
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

    public static final class PaymentBuilder {
        private long id;
        private Double amount;
        private PaymentType paymentType;
        private Card card;
        private Buyer buyer;

        public PaymentBuilder() {
        }

        public static PaymentBuilder aPayment() {
            return new PaymentBuilder();
        }

        public PaymentBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public PaymentBuilder withAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public PaymentBuilder withPaymentType(PaymentType paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public PaymentBuilder withCard(Card card) {
            this.card = card;
            return this;
        }

        public PaymentBuilder withBuyer(Buyer buyer) {
            this.buyer = buyer;
            return this;
        }

        public Payment build() {
            Payment payment = new Payment();
            payment.setId(id);
            payment.setAmount(amount);
            payment.setPaymentType(paymentType);
            payment.setCard(card);
            payment.setBuyer(buyer);
            return payment;
        }
    }
}

package br.paymentapi.wirecard.models;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String holder;

    private String number;

    private String expiration;

    private String cvv;

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public static final class CardBuilder {
        private long id;
        private String holder;
        private String number;
        private String expiration;
        private String cvv;

        public CardBuilder() {
        }

        public static CardBuilder aCard() {
            return new CardBuilder();
        }

        public CardBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public CardBuilder withHolder(String holder) {
            this.holder = holder;
            return this;
        }

        public CardBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public CardBuilder withExpiration(String expiration) {
            this.expiration = expiration;
            return this;
        }

        public CardBuilder withCvv(String cvv) {
            this.cvv = cvv;
            return this;
        }

        public Card build() {
            Card card = new Card();
            card.setId(id);
            card.setHolder(holder);
            card.setNumber(number);
            card.setExpiration(expiration);
            card.setCvv(cvv);
            return card;
        }
    }
}

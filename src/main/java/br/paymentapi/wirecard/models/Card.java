package br.paymentapi.wirecard.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
@EntityListeners(AuditingEntityListener.class)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "holder", nullable = false)
    private String holder;

    @Column(name = "cardnumber", nullable = false)
    private String number;

    @Column(name = "expiration", nullable = false)
    private Date expiration;

    @Column(name = "cvv", nullable = false)
    private int cvv;

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

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}

package br.paymentapi.wirecard.repository;

import br.paymentapi.wirecard.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

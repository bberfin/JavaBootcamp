package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.business.dto.requests.create.payment.CreatePaymentRequest;
import kodlama.io.rentacar.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByCardNumber(String cardNumber);

    boolean existsByCardNumber(String cardNumber);

    boolean existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
            String cardNumber,
            String cardHolder,
            int cardExpirationyear,
            int cardExpirationMonth,
            String cardCvv
    );

    //SPel: spring expression language
//    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END"+
//            "FROM Payment p WHERE p.cardNumber = :#{paymentRequest.cardNumber}"+
//            "AND p.cardExpirationYear = :#{paymentRequest.ExpirationYear}"+
//            "...........")
//    boolean existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCarCvv(
//            @Param("paymentRequest")CreatePaymentRequest paymentRequest);

}

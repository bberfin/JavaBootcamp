package kodlama.io.rentacar.business.dto.requests.create.rental;

import kodlama.io.rentacar.business.dto.requests.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalRequest {
    private int cardId;
    private double dailyPrice;
    private int  rentedForDays;
    private PaymentRequest paymentRequest;
}

package kodlama.io.rentacar.business.dto.requests.update.rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRentalRequest {
    private int cardId;
    private double dailyPrice;
    private int  rentedForDays;
    private LocalDateTime startDate;
}

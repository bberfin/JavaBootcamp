package kodlama.io.ecommerce.dto.requests.update;

import kodlama.io.ecommerce.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private Status status;
}

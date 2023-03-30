package kodlama.io.ecommerce.dto.responses.create;

import kodlama.io.ecommerce.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResponse {
    private int id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private Status status;
}

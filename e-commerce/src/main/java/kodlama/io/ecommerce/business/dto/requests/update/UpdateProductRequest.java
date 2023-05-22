package kodlama.io.ecommerce.business.dto.requests.update;

import kodlama.io.ecommerce.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private List<UUID> categoryIds;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private Status status;
}

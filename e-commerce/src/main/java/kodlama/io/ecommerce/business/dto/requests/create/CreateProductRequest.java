package kodlama.io.ecommerce.business.dto.requests.create;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class CreateProductRequest {
    private List<UUID> categoryIds;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private Status status;
}

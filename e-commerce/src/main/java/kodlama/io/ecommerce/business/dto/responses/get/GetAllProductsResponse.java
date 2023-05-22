package kodlama.io.ecommerce.business.dto.responses.get;

import kodlama.io.ecommerce.business.dto.responses.create.CreateCategoryResponse;
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
public class GetAllProductsResponse {
    private UUID id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private Status status;
    private List<UUID> categoryIds;
}

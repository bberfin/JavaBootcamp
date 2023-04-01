package kodlama.io.rentacar.business.dto.responses.create.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelResponse {
    private int id;
    private int brandId;
    private String name;
}

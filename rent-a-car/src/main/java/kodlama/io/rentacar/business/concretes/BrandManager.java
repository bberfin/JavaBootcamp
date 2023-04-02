package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.dto.requests.create.brand.CreateBrandRequest;
import kodlama.io.rentacar.business.dto.requests.update.brand.UpdateBrandRequest;
import kodlama.io.rentacar.business.dto.responses.create.brand.CreateBrandResponse;
import kodlama.io.rentacar.business.dto.responses.get.brand.GetAllBrandsResponse;
import kodlama.io.rentacar.business.dto.responses.get.brand.GetBrandResponse;
import kodlama.io.rentacar.business.dto.responses.update.brand.UpdateBrandResponse;
import kodlama.io.rentacar.entities.Brand;
import kodlama.io.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllBrandsResponse> getAll() {
//        List<Brand> brands = repository.findAll();
//        List<GetAllBrandsResponse> response = new ArrayList<>();
//        for(Brand brand: brands){
//            response.add(new GetAllBrandsResponse(brand.getId(), brand.getName()));}

        List<Brand> brands = repository.findAll();
        List<GetAllBrandsResponse> response = brands
                .stream()
                .map(brand -> mapper.map(brand, GetAllBrandsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetBrandResponse getById(int id) {
        checkIfBrandExistsById(id);

//        Brand brand = repository.findById(id).orElseThrow();
//        GetBrandResponse response = new GetBrandResponse();
//        response.setId(brand.getId());
//        response.setName(brand.getName());

        Brand brand = repository.findById(id).orElseThrow();
        GetBrandResponse response = mapper.map(brand, GetBrandResponse.class);

        return response;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {
//        Brand brand = new Brand();
//        brand.setName(request.getName());
//        repository.save(brand);
//
//        CreateBrandResponse response = new CreateBrandResponse();
//        response.setId(brand.getId());
//        response.setName(brand.getName());
        checkIfBrandExistsByName(request.getName());
        Brand brand = mapper.map(request, Brand.class);
        brand.setId(0);
        Brand createdBrand = repository.save(brand);

        CreateBrandResponse response = mapper.map(createdBrand, CreateBrandResponse.class);

        return response;
    }

    @Override
    public UpdateBrandResponse update(int id, UpdateBrandRequest request) {
        checkIfBrandExistsById(id);
        Brand brand = mapper.map(request, Brand.class);
        brand.setId(id);
        repository.save(brand);

        UpdateBrandResponse response = mapper.map(brand, UpdateBrandResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        checkIfBrandExistsById(id);
        repository.deleteById(id);
    }

    //BUSINESS RULES
    private void checkIfBrandExistsById(int id) {
        if (!repository.existsById(id)) throw new IllegalArgumentException("böyle bir marka mevcut değil.");
    }

    private void checkIfBrandExistsByName(String name) {
        if (repository.existsByNameIgnoreCase(name))
            throw new IllegalArgumentException("böyle bir marka sistemde kayıtlı.");
    }
}

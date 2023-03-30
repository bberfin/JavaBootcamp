package kodlama.io.rentacar.configuration.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper() {  //bize ait bir sınıf olmadığı için burada oluşturduk. Bize ait olsaydı manager sınıfımızda bean oluşturabilirdik
        return new ModelMapper();
    }
}

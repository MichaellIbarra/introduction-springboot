package pe.com.matichelo.springdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import pe.com.matichelo.springdi.repositories.IProductRepository;
import pe.com.matichelo.springdi.repositories.ProductRepositoryJson;

import java.io.IOException;

@Configuration
@PropertySources(
        {
                @PropertySource("classpath:values.properties"),
        }
)
public class AppConfig {
        @Bean("productJson")
         IProductRepository productRepositoryJson() throws IOException {
                return new ProductRepositoryJson();
        }
}

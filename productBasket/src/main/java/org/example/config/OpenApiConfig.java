package org.example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "ProductBasketApi",
                description = "Product Basket Api", version = "1.0",
                contact = @Contact(
                        name = "Fakhrtdinov Nail",
                        email = "fakh-nail@yandex.ru",
                        url = "https://1c-ulmix-soft.ru/"
                )
        )
)
public class OpenApiConfig {
// http://localhost:8080/swagger-ui/index.html
}

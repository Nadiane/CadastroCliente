package br.com.compasso.web.cadastroclientes.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguracao {

    public Docket cadastroClientesApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.compasso.web.cadastroclientes"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(informacoesApi());
    }

    private ApiInfo informacoesApi() {
        ApiInfo apiInfo = new ApiInfo("Produtos API REST",
                "API REST de cadastro de produtos.",
                "1.0",
                "Terms of Service",
                new Contact("Nadiane Ferreira", "", "nadianetff@hotmail.com"),
                "Apache Licencse Version 1.0", "",new ArrayList<VendorExtension>());
        return apiInfo;
    }
}

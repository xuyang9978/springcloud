package run.xuyang.springcloud.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * swagger 3 配置
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SpringDoc-OpenAPI")
                        .description("Cloud Provider Payment8001 Doc")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Apache2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("my blog")
                        .url("http://xuyang.run/blog"));
    }

}

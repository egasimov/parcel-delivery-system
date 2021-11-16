package org.company.order.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private final Swagger swagger = new Swagger();

    @Getter
    @Setter
    public static class Swagger {
        private String basePackage;
        private String paths;
        private SwaggerApiInfo apiInfo;

        @Getter
        @Setter
        public static class SwaggerApiInfo {
            private String version;
            private String title;
            private String description;
            private String termsOfServiceUrl;
            private String license;
            private String licenseUrl;
            private SwaggerContact contact;

            @Getter
            @Setter
            public static class SwaggerContact {
                private String name;
                private String url;
                private String email;
            }
        }
    }
}

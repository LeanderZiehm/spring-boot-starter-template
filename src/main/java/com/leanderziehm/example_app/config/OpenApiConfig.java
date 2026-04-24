package com.leanderziehm.example_app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(title = "Example API",contact = @Contact(name= "Leander", email="contact@leanderziehm.com"), version="0.1.0"),
    servers = {
        @Server(description = "Local", url="http://localhost:8080")
    }
)
public class OpenApiConfig {
    
}

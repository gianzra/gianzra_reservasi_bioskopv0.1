package com.binar.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

public class SwaggerConfig {

    public OpenAPI reservasibioskopOpenApi(){
        return new OpenAPI()
                .info(new Info().title("gianzra_reservasi_bioskop"))
                .servers(List.of(new Server().url("https://gianzrareservasibioskop-production.up.railway.app/")));
    }
}

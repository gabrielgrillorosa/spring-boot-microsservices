package com.gabriel.authentication.docs;

import com.gabriel.authentication.config.BaseSwaggerConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    public SwaggerConfig() {
        super("com.gabriel.authentication.controller");
    }
}

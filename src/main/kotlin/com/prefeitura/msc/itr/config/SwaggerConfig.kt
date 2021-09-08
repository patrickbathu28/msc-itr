package com.prefeitura.msc.itr.config


import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@Configuration
@EnableSwagger2
class SpringFoxConfig {

    @Value("\${spring.application.name}")
    var name: String? = null

    @Value("\${swagger.version}")
    var version: String? = null

    @Value("\${swagger.description}")
    var description: String? = null

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .paths(PathSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.prefeitura.msc.itr.controller"))
            .build()
            .apiInfo(apiInfo())
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
            name,
            description,
            version,
            null,
            null,
            null,
            null,
            ArrayList()
        )
    }
}
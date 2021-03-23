package com.prefeitura.msc.itr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class MscItrApplication

fun main(args: Array<String>) {
	runApplication<MscItrApplication>(*args)
}

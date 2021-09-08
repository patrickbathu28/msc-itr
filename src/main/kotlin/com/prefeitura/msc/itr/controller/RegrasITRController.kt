package com.prefeitura.msc.itr.controller


import com.prefeitura.msc.itr.client.SturClient
import com.prefeitura.msc.itr.dtos.RegrasDTO
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/itr/{ano}/regras")
class RegrasITRController ( val sturClient : SturClient? ) {

    @ApiOperation(value = "Get regras por ao para calculo ITR")
    @GetMapping(produces= [MediaType.APPLICATION_JSON_VALUE])
    fun getRuleITR(@PathVariable("ano") ano: String): ResponseEntity<RegrasDTO> = ResponseEntity.status(HttpStatus.OK).body(sturClient?.getRegrasAno(ano))

    @ApiOperation(value = "Cadastro de Regras por ano para calculo ITR")
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces= [MediaType.APPLICATION_JSON_VALUE])
    fun createRuleITR(@RequestBody regrasDTO: RegrasDTO, @PathVariable("ano") ano: String) = ResponseEntity.status(HttpStatus.CREATED).body(sturClient?.setRegras(regrasDTO, ano))

    @ApiOperation(value = "Atualização de Regras por ano para calculo ITR")
    @PutMapping(produces= [MediaType.APPLICATION_JSON_VALUE])
    fun updateRule(@RequestBody regrasDTO: RegrasDTO, @PathVariable("ano") ano: String) = ResponseEntity.status(HttpStatus.OK).body(sturClient?.setRegras(regrasDTO, ano))


}
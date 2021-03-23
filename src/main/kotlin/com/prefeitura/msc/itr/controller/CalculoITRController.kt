package com.prefeitura.msc.itr.controller


import com.prefeitura.msc.itr.dtos.ImovelDTO
import com.prefeitura.msc.itr.services.ITRService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/itr")
class CalculoITRController {

    @Autowired
    private var itrService: ITRService? = null

    @ApiOperation(value = "Api de Calculo do ITR com ano Base")
    @PostMapping(path = arrayOf("{anoBase}/calculo"), produces= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun calculoITR(@PathVariable("anoBase") anoBase: String, @RequestBody imovelDTO: ImovelDTO):
            ResponseEntity<ImovelDTO> = ResponseEntity.status(HttpStatus.OK).body(itrService?.getValorITR(anoBase, imovelDTO))

}
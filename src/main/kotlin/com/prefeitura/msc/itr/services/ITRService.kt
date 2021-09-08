package com.prefeitura.msc.itr.services

import com.prefeitura.msc.itr.dtos.ImovelDTO

@FunctionalInterface
interface ITRService {
    fun getValorITR(anoBase: String, imovelDTO: ImovelDTO): ImovelDTO
}
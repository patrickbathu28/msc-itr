package com.prefeitura.msc.itr.services

import com.prefeitura.msc.itr.client.SturClient
import com.prefeitura.msc.itr.dtos.ImovelDTO
import com.prefeitura.msc.itr.dtos.RegrasDTO
import org.springframework.stereotype.Service

@Service
class CalculoITRServiceImp(val sturClient: SturClient) : ITRService {

    override fun getValorITR(anoBase: String, imovelDTO: ImovelDTO): ImovelDTO {

        var regrasDTO : RegrasDTO? = sturClient.getRegrasAno(anoBase)

        imovelDTO.anoBase = anoBase

        if (regrasDTO != null) {
            this.valorVenalTerreno(imovelDTO, regrasDTO)
            this.valorVenalConstrucao(imovelDTO, regrasDTO)
            this.valorVenalImovel(imovelDTO)
            this.valorImposto(imovelDTO, regrasDTO)
        }

        return imovelDTO
    }

    private fun valorVenalTerreno(imovelDTO: ImovelDTO, regrasDTO: RegrasDTO){
       imovelDTO.valorVenalTerreno =  (imovelDTO.areaTotal?.minus(imovelDTO.areaConstruida)) * (regrasDTO.valorMetroTerreno)
    }

    private fun valorVenalConstrucao(imovelDTO: ImovelDTO, regrasDTO: RegrasDTO){
        imovelDTO.valorVenalConstrucao =  regrasDTO.valorMetroConstruido * imovelDTO.areaConstruida
    }

    private fun valorVenalImovel(imovelDTO: ImovelDTO){
        imovelDTO.valorVenalImovel = imovelDTO.valorVenalTerreno?.plus(imovelDTO.valorVenalConstrucao!!)
    }

    private fun valorImposto(imovelDTO: ImovelDTO, regrasDTO: RegrasDTO) {
        imovelDTO.iptu = (imovelDTO.valorVenalImovel!! * regrasDTO.aliguota!!) / 100
    }

}
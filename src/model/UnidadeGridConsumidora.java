
/******************************************************************************
 * Nome do arquivo  : StationManager.java
 * Autor            : Leonidio Alves de Moraes Junior
 * Data de criação  : 07/02/2025
 * Empresa          : FATESG - Engenharia de Software - V Período
 * Descrição        : Gerenciador de Rede Radial
 *
 * Histórico de modificações:
 * Data        | Autor                          | Descrição
 * ------------|--------------------------------|--------------------------------
 * 07/02/2025  | Leonidio Alves de Moraes Junior| Implementação inicial
 * 09/02/2025  | Leonidio Alves de Moraes Junior| Correção de bugs
 * 
 * Copyright (c) 2025 FATESG. Todos os direitos reservados.
 * Este código é confidencial e de propriedade de FATESG.
 * A sua distribuição ou reprodução é proibida sem autorização expressa.
 ******************************************************************************/

package model;

import application.TipoUnidadeGrid;
import static application.TipoUnidadeGrid.CONSUMIDOR;

public class UnidadeGridConsumidora extends UnidadeGrid{
            
    final TipoUnidadeGrid tipoUnidade = CONSUMIDOR;            
    private boolean consumidorOnline = false;
    private final int consumoPorHora = 0;      
    
    public UnidadeGridConsumidora() {
        
    }

    public TipoUnidadeGrid getTipoUnidade() {
        return tipoUnidade;
    }

    public boolean isConsumidorOnline() {
        return consumidorOnline;
    }

    public void setConsumidorOnline(boolean consumidorOnline) {
        this.consumidorOnline = consumidorOnline;
    } 

    @Override
    public String toString() {
        return "Consumidor{" + "tipoUnidade=" + tipoUnidade + ", consumidorOnline=" + consumidorOnline + ", consumoPorHora=" + consumoPorHora + '}';
    }
    
    
}


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
import static application.TipoUnidadeGrid.PRODUTOR;
import java.util.ArrayList;
import java.util.List;

public class UnidadeGridUsinaDeProducao extends UnidadeGrid {
       
    private final TipoUnidadeGrid tipoUnidade = PRODUTOR;    
    private boolean fornecedorOnline = false;      
    private final List<UnidadeGridMatrizEnergetica> listaMatrizEnergetica = new ArrayList<>();                      
    private double quantEstoqueParaRepassar = 0;

    //Atributo Estatico de controle de instancia
    private static UnidadeGridUsinaDeProducao usinadoGrid = null;

    //Metodo estatico para obter a instancia unica da classe
    public static UnidadeGridUsinaDeProducao getInstanciaDaUsinadoGrid(){
        if(usinadoGrid == null) usinadoGrid = new UnidadeGridUsinaDeProducao();
        return usinadoGrid;
    }        
    
    private UnidadeGridUsinaDeProducao() {
        
    }

    public TipoUnidadeGrid getTipoUnidade() {
        return tipoUnidade;
    }

    public double getQuantEstoqueParaRepassar() {
        return quantEstoqueParaRepassar;
    }

    public void setQuantEstoqueParaRepassar(double quantEstoqueParaRepassar) {
        this.quantEstoqueParaRepassar = quantEstoqueParaRepassar;
    }
            
    public boolean isFornecedorOnline() {
        return fornecedorOnline;
    }

    public void setFornecedorOnline(boolean fornecedorOnline) {
        this.fornecedorOnline = fornecedorOnline;
    }    

    @Override
    public List<UnidadeGridMatrizEnergetica> getMatrizEnergetica() {
        return listaMatrizEnergetica;
    }

    @Override
    public void addMatrizEnergetica(UnidadeGridMatrizEnergetica matrizEnergetica) {
        listaMatrizEnergetica.add(matrizEnergetica);
    }

    @Override
    public void removeMatrizEnergetica(UnidadeGridMatrizEnergetica matrizEnergetica) {
        listaMatrizEnergetica.remove(matrizEnergetica);
    }
}

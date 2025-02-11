
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

import java.time.LocalDateTime;

public class ConexaoBifasica implements ConexaoRede{           
    
    UnidadeGridGerenciadorDeRedesRadiais unidadeGrid = UnidadeGridGerenciadorDeRedesRadiais.getInstanciaDoDistribuidor();
    
    @Override
    public boolean conectar(UnidadeGridConsumidora consumidorAConectar, UnidadeGridUsinaDeProducao produtorDisponivel) {
                
        consumidorAConectar.setOnLineDesde(LocalDateTime.now());
        if (consumidorAConectar.getTipoCorrenteFase() == produtorDisponivel.getTipoCorrenteFase()){
            System.out.println("Conexão bifásica estabelecida.");
            consumidorAConectar.setOperaRedeMonofasica(true);
            consumidorAConectar.setConsumidorOnline(true);
            consumidorAConectar.setRedeOnline(true);                    
            consumidorAConectar.setOnLineDesde(LocalDateTime.now());
        } else {
            System.out.println("Conexão bifásica estabelecida com adaptação.");
            consumidorAConectar.setOperaRedeMonofasica(true);
            consumidorAConectar.setConsumidorOnline(true);
            consumidorAConectar.setRedeOnline(true);                    
            consumidorAConectar.setOnLineDesde(LocalDateTime.now());            
        }  
        System.out.println("Unidade consumidora " + consumidorAConectar.getIdentificadorUnidadeGrid() + "-" + consumidorAConectar.tipoUnidade + " conectada desde " +consumidorAConectar.getOnLineDesde() );
        System.out.println(consumidorAConectar);
        return true;
    }
    
    @Override
    public boolean desconectar(UnidadeGridConsumidora consumidorAConectar, UnidadeGridUsinaDeProducao produtorDisponivel) {
        consumidorAConectar.setOnLineDesde(null);
        if (consumidorAConectar.getTipoCorrenteFase() == produtorDisponivel.getTipoCorrenteFase()){
            System.out.println("Conexão monofásica estabelecida.");
            consumidorAConectar.setRedeOnline(false);
            consumidorAConectar.setOperaRedeMonofasica(false);
            consumidorAConectar.setConsumidorOnline(false);            
            consumidorAConectar.setOnLineDesde(null);
        } else {
            System.out.println("Conexão monofásica estabelecida com adaptação.");
            consumidorAConectar.setRedeOnline(false);
            consumidorAConectar.setOperaRedeMonofasica(false);
            consumidorAConectar.setConsumidorOnline(false);                        
            consumidorAConectar.setOnLineDesde(null);
        }  
        System.out.println("Unidade consumidora " + consumidorAConectar.getIdentificadorUnidadeGrid() + "-" + consumidorAConectar.tipoUnidade + " desconectada." );
        System.out.println(consumidorAConectar);
        return true;
    }
    
    @Override
    public boolean conectarGerenciador(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel) {
        gerenciadorRede.setOnLineDesde(LocalDateTime.now());
        gerenciadorRede.setRedeOnline(true);
        gerenciadorRede.setGerenciadorRedeAtivo(true);  
        System.out.println("Gerenciador conectado: " + gerenciadorRede.getIdentificadorGerenciador());
        for (UnidadeGridConsumidora consumidor : unidadeGrid.getListaConsumidores()) {
            consumidor.setRedeOnline(true);
            consumidor.setOnLineDesde(LocalDateTime.now());
        }                
        return true;
    }
    
    @Override
    public boolean desconectarGerenciador(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel) {
        gerenciadorRede.setOnLineDesde(null);
        gerenciadorRede.setRedeOnline(false);
        gerenciadorRede.setGerenciadorRedeAtivo(false);
        System.out.println("Gerenciador desconectado: " + gerenciadorRede.getIdentificadorGerenciador());
        for (UnidadeGridConsumidora consumidor : unidadeGrid.getListaConsumidores()) {
            consumidor.setRedeOnline(false);
            consumidor.setOnLineDesde(null);
        }                
        return true;
    }   
    
    @Override
    public boolean conectarUsina(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel) {
        produtorDisponivel.setOnLineDesde(LocalDateTime.now());
        produtorDisponivel.setRedeOnline(true);
        produtorDisponivel.setFornecedorOnline(true);
        produtorDisponivel.setOperaRedeBifasica(true);        
        for (UnidadeGridConsumidora consumidor : unidadeGrid.getListaConsumidores()) {
            consumidor.setRedeOnline(true);
            consumidor.setOnLineDesde(LocalDateTime.now());
        }                
        System.out.println("Usina conectada: " + gerenciadorRede.getIdentificadorGerenciador());
        return true;
    }
    
    @Override
    public boolean desconectarUsina(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel) {
        produtorDisponivel.setOnLineDesde(null);
        produtorDisponivel.setRedeOnline(false);
        produtorDisponivel.setFornecedorOnline(false);
        produtorDisponivel.setOperaRedeBifasica(false);   
        for (UnidadeGridConsumidora consumidor : unidadeGrid.getListaConsumidores()) {
            consumidor.setRedeOnline(false);
            consumidor.setOnLineDesde(null);
        }                        
        System.out.println("Usina desconectada: " + gerenciadorRede.getIdentificadorGerenciador());
        return true;
    }   

}

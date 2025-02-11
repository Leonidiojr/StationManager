
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

public interface ConexaoRede {    
    boolean conectar(UnidadeGridConsumidora consumidorAConectar, UnidadeGridUsinaDeProducao produtorDisponivel);    
    boolean desconectar(UnidadeGridConsumidora consumidorAConectar, UnidadeGridUsinaDeProducao produtorDisponivel);       
    boolean conectarGerenciador(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel);    
    boolean desconectarGerenciador(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel);    
    boolean conectarUsina(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel);    
    boolean desconectarUsina(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel);        
}

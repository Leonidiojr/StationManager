
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

public class AdaptadorConexao implements ConexaoRede {
    private ConexaoRede conexao;

    public AdaptadorConexao(ConexaoRede conexao) {
        this.conexao = conexao;
    }

    @Override
    public boolean conectar(UnidadeGridConsumidora consumidorAConectar, UnidadeGridUsinaDeProducao produtorDisponivel) {
        return conexao.conectar(consumidorAConectar, produtorDisponivel);
    }
    
    @Override
    public boolean desconectar(UnidadeGridConsumidora consumidorAConectar, UnidadeGridUsinaDeProducao produtorDisponivel) {
        return conexao.conectar(consumidorAConectar, produtorDisponivel);
    }
     
    @Override
    public boolean conectarGerenciador(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel){
        return conexao.conectarGerenciador(gerenciadorRede, produtorDisponivel);
    }   
    
    @Override
    public boolean desconectarGerenciador(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel){
        return conexao.desconectarGerenciador(gerenciadorRede, produtorDisponivel);
    }   
    
    @Override
    public boolean conectarUsina(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel){
        return conexao.conectarGerenciador(gerenciadorRede, produtorDisponivel);
    }   
    
    @Override
    public boolean desconectarUsina(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel){
        return conexao.desconectarGerenciador(gerenciadorRede, produtorDisponivel);
    }       
}

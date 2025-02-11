
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

import java.util.ArrayList;
import java.util.List;
import application.TipoUnidadeGrid;
import static application.TipoUnidadeGrid.GERENCIADOR;

public class UnidadeGridGerenciadorDeRedesRadiais extends UnidadeGrid implements ConexaoRede{
    
    private String identificadorGerenciador = "Gerenciador de Rede Radial";
    private int quantidadeDeConsumidores = 0;
    private int quantidadeDeProdutores = 0;
    private boolean gerenciadorRedeAtivo = false;    
    private final List<UnidadeGridUsinaDeProducao> listaUsinaDeProducao = new ArrayList<>();                      
    private final List<UnidadeGridConsumidora> listaConsumidores = new ArrayList<>();                      
    
    //Atributo Estatico de controle de instancia
    private static UnidadeGridGerenciadorDeRedesRadiais unicoGerenciador = null;        
    
    //Construtor Private
    private  UnidadeGridGerenciadorDeRedesRadiais(){
    }
    
    //Metodo estatico para obter a instancia unica da classe
    public static UnidadeGridGerenciadorDeRedesRadiais getInstanciaDoDistribuidor(){
        if(unicoGerenciador == null) unicoGerenciador = new UnidadeGridGerenciadorDeRedesRadiais();
        return unicoGerenciador;
    }

    public String getIdentificadorGerenciador() {
        return identificadorGerenciador;
    }

    public void setIdentificadorGerenciador(String identificadorGerenciador) {
        this.identificadorGerenciador = identificadorGerenciador;
    }

    public int getQuantidadeDeConsumidores() {
        return quantidadeDeConsumidores;
    }

    public void setQuantidadeDeConsumidores(int quantidadeDeConsumidores) {
        this.quantidadeDeConsumidores = quantidadeDeConsumidores;
    }

    public int getQuantidadeDeProdutores() {
        return quantidadeDeProdutores;
    }

    public void setQuantidadeDeProdutores(int quantidadeDeProdutores) {
        this.quantidadeDeProdutores = quantidadeDeProdutores;
    }

    public boolean isGerenciadorRedeAtivo() {
        return gerenciadorRedeAtivo;
    }

    public void setGerenciadorRedeAtivo(boolean gerenciadorRedeAtivo) {
        this.gerenciadorRedeAtivo = gerenciadorRedeAtivo;
    }

    public List<UnidadeGridUsinaDeProducao> getUsinaDeProducao() {
        return listaUsinaDeProducao;
    }

    public void addUsinaDeProducao(UnidadeGridUsinaDeProducao usinaDeProducao) {
        listaUsinaDeProducao.add(usinaDeProducao);
    }

    public void removeUsinaDeProducao(UnidadeGridUsinaDeProducao usinaDeProducao) {
        listaUsinaDeProducao.remove(usinaDeProducao);
    }
    
    public List<UnidadeGridConsumidora> getListaConsumidores() {
        return listaConsumidores;
    }

    public void addConsumidor(UnidadeGridConsumidora consumidor) {
        listaConsumidores.add(consumidor);
    }

    public void removeConsumidor(UnidadeGridConsumidora consumidor) {
        listaConsumidores.remove(consumidor);
    }        
    
    @Override
    public boolean conectar(UnidadeGridConsumidora consumidorAConectar, UnidadeGridUsinaDeProducao produtorDisponivel) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
   @Override
    public boolean desconectar(UnidadeGridConsumidora consumidorAConectar, UnidadeGridUsinaDeProducao produtorDisponivel) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
     @Override
    public boolean conectarGerenciador(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel){
        throw new UnsupportedOperationException("Not supported yet."); 
    }   
    
    @Override
    public boolean desconectarGerenciador(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel){
        throw new UnsupportedOperationException("Not supported yet."); 
    }   
    
      @Override
    public boolean conectarUsina(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel){
        throw new UnsupportedOperationException("Not supported yet."); 
    }   
    
    @Override
    public boolean desconectarUsina(UnidadeGridGerenciadorDeRedesRadiais gerenciadorRede, UnidadeGridUsinaDeProducao produtorDisponivel){
        throw new UnsupportedOperationException("Not supported yet."); 
    }   
    
    
}
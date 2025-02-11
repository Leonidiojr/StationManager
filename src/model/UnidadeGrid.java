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

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UnidadeGrid {
    
    private String identificadorUnidadeGrid = "";
    private double consumidaPorHora = 0;
    private double producaoPorHora = 0;
    private double limitePotenciaEntregue = 0;
    private double potenciaMaximaFornecida = 0;
    private double quantidadeEnergiaConsumida = 0;
    private double quantidadeEnergiaProduzida = 0;
    private int tipoCorrenteFase = 1;
    private String responsavelUnidade = "";
    private String telefoneResponsavel = "";
    private String emailResponsavel = "";
    private String enderecoUnidade = "";
    private String coordenadaUnidade = "";   
    private boolean fornecedorHomologado = false;
    private boolean redeOnline = false;
    protected LocalDateTime onLineDesde;
    private final List<UnidadeGridMatrizEnergetica> listaMatrizeEnergeticaUnidade = new ArrayList<>();                      
    private final List<UnidadeGrid> listaUnidadeGrid = new ArrayList<>();                      
    private boolean operaRedeMonofasica = false;
    private boolean operaRedeBifasica = false;   
    private boolean operaRedeTrifasica = false;
            
    public UnidadeGrid() {
    }

    public boolean isOperaRedeMonofasica() {
        return operaRedeMonofasica;
    }

    public void setOperaRedeMonofasica(boolean operaRedeMonofasica) {
        this.operaRedeMonofasica = operaRedeMonofasica;
    }

    public boolean isOperaRedeBifasica() {
        return operaRedeBifasica;
    }

    public void setOperaRedeBifasica(boolean operaRedeBifasica) {
        this.operaRedeBifasica = operaRedeBifasica;
    }

    public boolean isOperaRedeTrifasica() {
        return operaRedeTrifasica;
    }

    public void setOperaRedeTrifasica(boolean operaRedeTrifasica) {
        this.operaRedeTrifasica = operaRedeTrifasica;
    }

    // Getters and Setters
    public String getIdentificadorUnidadeGrid() {
        return identificadorUnidadeGrid;
    }

    public void setIdentificadorUnidadeGrid(String identificadorUnidadeGrid) {
        this.identificadorUnidadeGrid = identificadorUnidadeGrid;
    }

    public double getConsumidaPorHora() {
        return consumidaPorHora;
    }

    public void setConsumidaPorHora(double consumidaPorHora) {
        this.consumidaPorHora = consumidaPorHora;
    }

    public double getProducaoPorHora() {
        return producaoPorHora;
    }

    public void setProducaoPorHora(double producaoPorHora) {
        this.producaoPorHora = producaoPorHora;
    }

    public double getLimitePotenciaEntregue() {
        return limitePotenciaEntregue;
    }

    public void setLimitePotenciaEntregue(double limitePotenciaEntregue) {
        this.limitePotenciaEntregue = limitePotenciaEntregue;
    }

    public double getPotenciaMaximaConsumida() {
        return potenciaMaximaFornecida;
    }

    public void setPotenciaMaximaConsumida(double potenciaMaximaConsumida) {
        this.potenciaMaximaFornecida = potenciaMaximaConsumida;
    }

    public double getQuantidadeEnergiaConsumida() {
        return quantidadeEnergiaConsumida;
    }

    public void setQuantidadeEnergiaConsumida(double quantidadeEnergiaConsumida) {
        this.quantidadeEnergiaConsumida = quantidadeEnergiaConsumida;
    }

    public double getQuantidadeEnergiaProduzida() {
        return quantidadeEnergiaProduzida;
    }

    public void setQuantidadeEnergiaProduzida(double quantidadeEnergiaProduzida) {
        this.quantidadeEnergiaProduzida = quantidadeEnergiaProduzida;
    }

    public int getTipoCorrenteFase() {
        return tipoCorrenteFase;
    }

    public void setTipoCorrenteFase(int tipoCorrenteFase) {
        this.tipoCorrenteFase = tipoCorrenteFase;
    }

    public String getResponsavelUnidade() {
        return responsavelUnidade;
    }

    public void setResponsavelUnidade(String responsavelUnidade) {
        this.responsavelUnidade = responsavelUnidade;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    public String getEnderecoUnidade() {
        return enderecoUnidade;
    }

    public void setEnderecoUnidade(String enderecoUnidade) {
        this.enderecoUnidade = enderecoUnidade;
    }

    public String getCoordenadaUnidade() {
        return coordenadaUnidade;
    }

    public void setCoordenadaUnidade(String coordenadaUnidade) {
        this.coordenadaUnidade = coordenadaUnidade;
    }

    public boolean isFornecedorHomologado() {
        return fornecedorHomologado;
    }

    public void setFornecedorHomologado(boolean fornecedorHomologado) {
        this.fornecedorHomologado = fornecedorHomologado;
    }

    public boolean isRedeOnline() {
        return redeOnline;
    }

    public void setRedeOnline(boolean redeOnline) {
        this.redeOnline = redeOnline;
    }

    public LocalDateTime getOnLineDesde() {
        return onLineDesde;
    }

    public void setOnLineDesde(LocalDateTime onLineDesde) {
        this.onLineDesde = onLineDesde;
    }

    public List<UnidadeGridMatrizEnergetica> getMatrizEnergetica() {
        return listaMatrizeEnergeticaUnidade;
    }

    public List<UnidadeGrid> getListaUnidadeGrid() {
        return listaUnidadeGrid;
    }

    public void addMatrizEnergetica(UnidadeGridMatrizEnergetica matrizeEnergeticaUnidade) {
        listaMatrizeEnergeticaUnidade.add(matrizeEnergeticaUnidade);
    }

    public void removeMatrizEnergetica(UnidadeGridMatrizEnergetica matrizeEnergeticaUnidade) {
        listaMatrizeEnergeticaUnidade.remove(matrizeEnergeticaUnidade);
    }

   public double calcProducaoEnergia() {

        double energiaLiquida = 0;

        UnidadeGridGerenciadorDeRedesRadiais usinadoGrid = UnidadeGridGerenciadorDeRedesRadiais.getInstanciaDoDistribuidor();
        
        if (usinadoGrid.isRedeOnline()) {
            
            if (usinadoGrid.getOnLineDesde() == null) {
                this.setOnLineDesde(LocalDateTime.now());
            } else {
                Duration duration = Duration.between(usinadoGrid.getOnLineDesde(), LocalDateTime.now());
                long segundosDecorridos = duration.getSeconds();

                // Consumo deste item
                double energiaProduzida = producaoPorHora * (segundosDecorridos / 3600.0); // Converter segundos para horas
                double energiaConsumida = consumidaPorHora  * (segundosDecorridos / 3600.0); // Converter segundos para horas

                // Calcular energia produzida e consumida no período
                energiaProduzida += quantidadeEnergiaProduzida * (segundosDecorridos / 3600.0); // Converter segundos para horas
                energiaConsumida += quantidadeEnergiaConsumida * (segundosDecorridos / 3600.0); // Converter segundos para horas                
            
                // Calcular energia líquida
                energiaLiquida = energiaProduzida - energiaConsumida;

                quantidadeEnergiaConsumida += energiaConsumida / 1000; // Dividir por 1000 para converter para kWh
                quantidadeEnergiaProduzida += energiaProduzida / 1000; // Dividir por 1000 para converter para kWh

            
            }            
            

        } else {
            energiaLiquida = 0;
        }

        // Retornar a média de produção de energia das matrizes energéticas
        return energiaLiquida;
    }
}

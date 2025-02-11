
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
import java.util.List;
import java.util.ArrayList;

public class UnidadeGridMatrizEnergetica extends UnidadeGrid{
        
    private int potenciaEmEstoque = 0;      
    private int capacidadeProducaoPorHora = 10;      
    private int modoOperacao = 0;
    private int tempoOperacaoEstimado = 8;
    private List<UnidadeGridFonteProducaoEnergia> listaFontesProducaoEnergias = new ArrayList<>();        
       
    public int getCapacidadeProducaoPorHora() {
        return capacidadeProducaoPorHora;
    }

    public void setCapacidadeProducaoPorHora(int capacidadeProducaoPorHora) {
        this.capacidadeProducaoPorHora = capacidadeProducaoPorHora;
    }  
    public UnidadeGridMatrizEnergetica() {
        this.listaFontesProducaoEnergias = new ArrayList<>();
    }
     
    public int getPotenciaEmEstoque() {
        return potenciaEmEstoque;
    }

    public void setPotenciaEmEstoque(int potenciaEmEstoque) {
        this.potenciaEmEstoque = potenciaEmEstoque;
    }

    public int getModoOperacao() {
        return modoOperacao;
    }

    public void setModoOperacao(int modoOperacao) {
        this.modoOperacao = modoOperacao;
    }

    public int getTempoOperacaoEstimado() {
        return tempoOperacaoEstimado;
    }

    public void setTempoOperacaoEstimado(int tempoOperacaoEstimado) {
        this.tempoOperacaoEstimado = tempoOperacaoEstimado;
    }
          
    public List<UnidadeGridFonteProducaoEnergia> getFontesProducaoEnergias(){
        return listaFontesProducaoEnergias;
    }

    public void addFontesProducaoEnergia(UnidadeGridFonteProducaoEnergia fonteProducaoEnergia) {
        listaFontesProducaoEnergias.add(fonteProducaoEnergia);
    }

    public void removeFontesProducaoEnergia(UnidadeGridFonteProducaoEnergia fonteProducaoEnergia) {
        listaFontesProducaoEnergias.remove(fonteProducaoEnergia); 
    }
        
    @Override
    public double calcProducaoEnergia() {
        
        double energiaProduzida = 0;
        double energiaConsumida = 0;
        double energiaLiquida = 0;
        double quantidadeEnergiaConsumida = 0;
        double quantidadeEnergiaProduzida = 0;

        if (super.onLineDesde == null) {
            this.setOnLineDesde(LocalDateTime.now());
            System.out.println(this.getOnLineDesde());
        }

        double porcentagemTotal = 0;
        int cont = 0;

        // Calcular o tempo decorrido em segundos
        Duration duration = Duration.between(this.onLineDesde, LocalDateTime.now());
        long segundosDecorridos = duration.getSeconds();

        for (UnidadeGridFonteProducaoEnergia fonteProducaoEnergia : listaFontesProducaoEnergias) {
            energiaProduzida += fonteProducaoEnergia.calcularPotenciaEmEstoque();
            cont++;
            //System.out.println(fonteProducaoEnergia.getIdentificadorFonteProducao());
        }
        
        // Calcular energia produzida e consumida no período
        energiaProduzida = quantidadeEnergiaProduzida * (segundosDecorridos / 3600.0); // Converter segundos para horas
        energiaConsumida = quantidadeEnergiaConsumida * (segundosDecorridos / 3600.0); // Converter segundos para horas

        // Calcular energia líquida
        energiaLiquida = energiaProduzida - energiaConsumida;

        System.out.println(energiaLiquida);

        // Retornar a média de produção de energia das matrizes energéticas
        return porcentagemTotal / cont + energiaLiquida;
    }

}

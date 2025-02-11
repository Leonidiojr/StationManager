
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

import application.TipoFonteDeEnergia;
import static application.TipoFonteDeEnergia.HIDROELETRICA;
import java.time.Duration;
import java.time.LocalDateTime;

public class UnidadeGridFonteProducaoEnergia {
    
    private String identificadorFonteProducao = "";
    private int potenciaMaximaConsumida = 0;
    private int quantidadeEnergiaConsumidaporHora = 0;
    private int quantidadeEnergiaProduzidaporHora = 0;
    private TipoFonteDeEnergia tipoFonteEnergia = HIDROELETRICA;
    private boolean fonteRenovavel = false;
    private int modoOperacao = 0;
    private int tempoOperacaoEstimado = 0;
    private boolean operaRedeMonofasica = false;
    private boolean operaRedeBifasica = false;   
    private boolean operaRedetrifasica = false;
    private int potenciaEmEstoque = 0;   
    private LocalDateTime onLineDesde;

    public String getIdentificadorFonteProducao() {
        return identificadorFonteProducao;
    }

    public void setIdentificadorFonteProducao(String identificadorFonteProducao) {
        this.identificadorFonteProducao = identificadorFonteProducao;
    }

    public UnidadeGridFonteProducaoEnergia() {
    }

    public int getQuantidadeEnergiaConsumidaporHora() {
        return quantidadeEnergiaConsumidaporHora;
    }

    public void setQuantidadeEnergiaConsumidaporHora(int quantidadeEnergiaConsumidaporHora) {
        this.quantidadeEnergiaConsumidaporHora = quantidadeEnergiaConsumidaporHora;
    }

    public int getQuantidadeEnergiaProduzidaporHora() {
        return quantidadeEnergiaProduzidaporHora;
    }

    public void setQuantidadeEnergiaProduzidaporHora(int quantidadeEnergiaProduzidaporHora) {
        this.quantidadeEnergiaProduzidaporHora = quantidadeEnergiaProduzidaporHora;
    }

    public LocalDateTime getOnLineDesde() {
        return onLineDesde;
    }

    public void setOnLineDesde(LocalDateTime onLineDesde) {
        this.onLineDesde = onLineDesde;
    }

    public String getIdentificadorMatriz() {
        return identificadorFonteProducao;
    }

    public void setIdentificadorMatriz(String identificadorMatriz) {
        this.identificadorFonteProducao = identificadorMatriz;
    }

    public int getPotenciaMaximaConsumida() {
        return potenciaMaximaConsumida;
    }

    public void setPotenciaMaximaConsumida(int potenciaMaximaConsumida) {
        this.potenciaMaximaConsumida = potenciaMaximaConsumida;
    }

    public int getQuantidadeEnergiaConsumida() {
        return quantidadeEnergiaConsumidaporHora;
    }

    public void setQuantidadeEnergiaConsumida(int quantidadeEnergiaConsumida) {
        this.quantidadeEnergiaConsumidaporHora = quantidadeEnergiaConsumida;
    }

    public int getQuantidadeEnergiaProduzida() {
        return quantidadeEnergiaProduzidaporHora;
    }

    public void setQuantidadeEnergiaProduzida(int quantidadeEnergiaProduzida) {
        this.quantidadeEnergiaProduzidaporHora = quantidadeEnergiaProduzida;
    }

    public TipoFonteDeEnergia getTipoFonteEnergia() {
        return tipoFonteEnergia;
    }

    public void setTipoFonteEnergia(TipoFonteDeEnergia tipoFonteEnergia) {
        this.tipoFonteEnergia = tipoFonteEnergia;
    }

    public boolean isFonteRenovavel() {
        return fonteRenovavel;
    }

    public void setFonteRenovavel(boolean fonteRenovavel) {
        this.fonteRenovavel = fonteRenovavel;
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

    public boolean isOperaRedetrifasica() {
        return operaRedetrifasica;
    }

    public void setOperaRedetrifasica(boolean operaRedetrifasica) {
        this.operaRedetrifasica = operaRedetrifasica;
    }

    public int getPotenciaEmEstoque() {
        return potenciaEmEstoque;
    }

    public void setPotenciaEmEstoque(int potenciaEmEstoque) {
        this.potenciaEmEstoque = potenciaEmEstoque;
    }
        
    
    public double calcularPotenciaEmEstoque(){
        
        this.potenciaEmEstoque =  (this.quantidadeEnergiaProduzidaporHora - this.quantidadeEnergiaConsumidaporHora) * this.tempoOperacaoEstimado;
        this.setPotenciaEmEstoque(potenciaEmEstoque);        
        return this.potenciaEmEstoque;            
    }        

    @Override
    public String toString() {
        return "FonteProducaoEnergia{" + "identificadorMatriz=" + identificadorFonteProducao + ", potenciaMaximaConsumida=" + potenciaMaximaConsumida + ", quantidadeEnergiaConsumida=" + quantidadeEnergiaConsumidaporHora + ", quantidadeEnergiaProduzida=" + quantidadeEnergiaProduzidaporHora + ", tipoFonteEnergia=" + tipoFonteEnergia + ", fonteRenovavel=" + fonteRenovavel + ", modoOperacao=" + modoOperacao + ", tempoOperacaoEstimado=" + tempoOperacaoEstimado + ", operaRedeMonofasica=" + operaRedeMonofasica + ", operaRedeBifasica=" + operaRedeBifasica + ", operaRedetrifasica=" + operaRedetrifasica + ", potenciaEmEstoque=" + potenciaEmEstoque + '}';
    }
    
    public int repassarPotenciaEmEstoque() {
        int potenciaRepassada = this.potenciaEmEstoque;
        this.potenciaEmEstoque = 0;
        this.onLineDesde = LocalDateTime.now();
        return potenciaRepassada;
        
    }
    
    public void calcularEArmazenarEnergiaProduzida() {
        // Calcular o tempo decorrido em horas
        Duration duration = Duration.between(onLineDesde, LocalDateTime.now());
        long horasDecorridas = duration.toHours();

        // Calcular a energia produzida
        int energiaProduzida = (quantidadeEnergiaProduzidaporHora - quantidadeEnergiaConsumidaporHora) * (int) horasDecorridas;

        // Armazenar a energia produzida em potenciaEmEstoque
        this.setPotenciaEmEstoque(energiaProduzida);
    }    
                
    
}

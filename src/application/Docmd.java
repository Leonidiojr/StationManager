
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

package application;

import static application.TipoFonteDeEnergia.BIOMASSA;
import static application.TipoFonteDeEnergia.CARVAO;
import static application.TipoFonteDeEnergia.EOLICA;
import static application.TipoFonteDeEnergia.GAS_NATURAL;
import static application.TipoFonteDeEnergia.GEOTERMICA;
import static application.TipoFonteDeEnergia.HIDROELETRICA;
import static application.TipoFonteDeEnergia.NUCLEAR;
import static application.TipoFonteDeEnergia.SOLAR;
import java.awt.*;
import java.time.LocalDateTime;
import model.UnidadeGridConsumidora;
import model.UnidadeGridFonteProducaoEnergia;
import model.UnidadeGridGerenciadorDeRedesRadiais;
import model.UnidadeGridMatrizEnergetica;
import model.UnidadeGridUsinaDeProducao;
import view.Consumidores;
import view.Usina;
import view.Gerenciador;


public class Docmd {
    
    
    //Atributo Estatico de controle de instancia
    private static Docmd docmd = null;    

    //Metodo estatico para obter a instancia unica da classe
    public static Docmd getInstaciaDoCmd(){
        if(docmd == null) docmd = new Docmd();
        return docmd;
    }    

    private Docmd() {
        
    }
    
    private void criarUnidadesdoGrid(){
        
        UnidadeGridGerenciadorDeRedesRadiais unidadeGrid = UnidadeGridGerenciadorDeRedesRadiais.getInstanciaDoDistribuidor();
        UnidadeGridUsinaDeProducao usinadoGrid = UnidadeGridUsinaDeProducao.getInstanciaDaUsinadoGrid();    
                        
        //Define propriedades do Gerenciador        
        unidadeGrid.setIdentificadorUnidadeGrid("CyborgGrid Management - Gerenciador");
        unidadeGrid.setEmailResponsavel("leonidiojr@gmail.com");        
        unidadeGrid.setCoordenadaUnidade("-15.8267 -47.928");
        unidadeGrid.setTelefoneResponsavel("(62)98555-5997");
        unidadeGrid.setLimitePotenciaEntregue(10);
        unidadeGrid.setResponsavelUnidade("Leonidio Alves de Moraes Junior");
        unidadeGrid.setPotenciaMaximaConsumida(1000);        
        unidadeGrid.setLimitePotenciaEntregue(5000);
        unidadeGrid.setQuantidadeEnergiaConsumida(10000);
        unidadeGrid.setQuantidadeEnergiaProduzida(12000);
        unidadeGrid.setTipoCorrenteFase(3);
        unidadeGrid.setResponsavelUnidade("João Silva");
        unidadeGrid.setTelefoneResponsavel("(62) 91234-5678");
        unidadeGrid.setEnderecoUnidade("Rua das Flores, 123, Goiânia, GO");
        unidadeGrid.setCoordenadaUnidade("-16.6869, -49.2648");
        unidadeGrid.setFornecedorHomologado(true);
        unidadeGrid.setRedeOnline(false);
        unidadeGrid.setTipoCorrenteFase(3);
        unidadeGrid.setOnLineDesde(LocalDateTime.now());
                                
        //Cria uma Usina de Produção para a rede
        usinadoGrid.setIdentificadorUnidadeGrid("USINA DA CAVEIRA VERMELHA");
        usinadoGrid.setPotenciaMaximaConsumida(100);        
        usinadoGrid.setLimitePotenciaEntregue(5000);
        usinadoGrid.setQuantidadeEnergiaConsumida(10);
        usinadoGrid.setQuantidadeEnergiaProduzida(12000);
        usinadoGrid.setTipoCorrenteFase(3);
        usinadoGrid.setResponsavelUnidade("Leonidio Alves de Moraes Junior");
        usinadoGrid.setTelefoneResponsavel("(62) 91234-5678");
        usinadoGrid.setEmailResponsavel("joao.silva@example.com");
        usinadoGrid.setEnderecoUnidade("Rua das Flores, 123, Goiânia, GO");
        usinadoGrid.setCoordenadaUnidade("-16.6869, -49.2648");
        usinadoGrid.setFornecedorHomologado(true);
        usinadoGrid.setRedeOnline(false);    
        usinadoGrid.setFornecedorOnline(false);
        usinadoGrid.setOnLineDesde(LocalDateTime.now());
        usinadoGrid.setQuantEstoqueParaRepassar(150000);
        unidadeGrid.addUsinaDeProducao(usinadoGrid);
        unidadeGrid.setQuantidadeDeConsumidores(9);
        unidadeGrid.setQuantidadeDeProdutores(1);
        
        
        //Cria Matrix para acumular
        UnidadeGridMatrizEnergetica matrizEnergetica = new UnidadeGridMatrizEnergetica();
        matrizEnergetica.setIdentificadorUnidadeGrid("Matriz Base");
        matrizEnergetica.setPotenciaMaximaConsumida(5);
        matrizEnergetica.setLimitePotenciaEntregue(50);        
        matrizEnergetica.setPotenciaEmEstoque(0);      
        matrizEnergetica.setCapacidadeProducaoPorHora(8);
        matrizEnergetica.setModoOperacao(0);
        matrizEnergetica.setTempoOperacaoEstimado(8);
        matrizEnergetica.setOperaRedeMonofasica(false);
        matrizEnergetica.setOperaRedeBifasica(false);   
        matrizEnergetica.setOperaRedeTrifasica(true);            
        matrizEnergetica.setOnLineDesde(LocalDateTime.now());
        usinadoGrid.addMatrizEnergetica(matrizEnergetica);

        //Crie as fontes de energia e adiciona a matriz
        UnidadeGridFonteProducaoEnergia fonteProducaoEnergia = new UnidadeGridFonteProducaoEnergia();        
        fonteProducaoEnergia.setIdentificadorFonteProducao("USINA HIDRELETRICA DE PARAUNAUE");
        fonteProducaoEnergia.setPotenciaMaximaConsumida(2);
        fonteProducaoEnergia.setQuantidadeEnergiaConsumidaporHora(1500);
        fonteProducaoEnergia.setQuantidadeEnergiaProduzidaporHora(2500);
        fonteProducaoEnergia.setTipoFonteEnergia(HIDROELETRICA);
        fonteProducaoEnergia.setFonteRenovavel(true);
        fonteProducaoEnergia.setModoOperacao(0);
        fonteProducaoEnergia.setTempoOperacaoEstimado(24);
        fonteProducaoEnergia.setOperaRedeMonofasica(false);
        fonteProducaoEnergia.setOperaRedeBifasica(false);   
        fonteProducaoEnergia.setOperaRedetrifasica(true);
        fonteProducaoEnergia.setPotenciaEmEstoque(1500);   
        fonteProducaoEnergia.setOnLineDesde(LocalDateTime.now());
        fonteProducaoEnergia.calcularEArmazenarEnergiaProduzida();    
        matrizEnergetica.addFontesProducaoEnergia(fonteProducaoEnergia);

        UnidadeGridFonteProducaoEnergia fonteProducaoEnergia2 = new UnidadeGridFonteProducaoEnergia();        
        fonteProducaoEnergia2.setIdentificadorFonteProducao("USINA SOLAR UFCOM");
        fonteProducaoEnergia2.setPotenciaMaximaConsumida(2);
        fonteProducaoEnergia2.setQuantidadeEnergiaConsumidaporHora(1500);
        fonteProducaoEnergia2.setQuantidadeEnergiaProduzidaporHora(2500);
        fonteProducaoEnergia2.setTipoFonteEnergia(SOLAR);
        fonteProducaoEnergia2.setFonteRenovavel(true);
        fonteProducaoEnergia2.setModoOperacao(0);
        fonteProducaoEnergia2.setTempoOperacaoEstimado(8);
        fonteProducaoEnergia2.setOperaRedeMonofasica(false);
        fonteProducaoEnergia2.setOperaRedeBifasica(false);   
        fonteProducaoEnergia2.setOperaRedetrifasica(true);
        fonteProducaoEnergia2.setPotenciaEmEstoque(500);   
        fonteProducaoEnergia2.setOnLineDesde(LocalDateTime.now());
        fonteProducaoEnergia2.calcularEArmazenarEnergiaProduzida();                    
        matrizEnergetica.addFontesProducaoEnergia(fonteProducaoEnergia2);        

        UnidadeGridFonteProducaoEnergia fonteProducaoEnergia3 = new UnidadeGridFonteProducaoEnergia();        
        fonteProducaoEnergia3.setIdentificadorFonteProducao("USINA EOLICA UFCOM");
        fonteProducaoEnergia3.setPotenciaMaximaConsumida(2);
        fonteProducaoEnergia3.setQuantidadeEnergiaConsumidaporHora(1500);
        fonteProducaoEnergia3.setQuantidadeEnergiaProduzidaporHora(2500);
        fonteProducaoEnergia3.setTipoFonteEnergia(EOLICA);
        fonteProducaoEnergia3.setFonteRenovavel(true);
        fonteProducaoEnergia3.setModoOperacao(0);
        fonteProducaoEnergia3.setTempoOperacaoEstimado(12);
        fonteProducaoEnergia3.setOperaRedeMonofasica(false);
        fonteProducaoEnergia3.setOperaRedeBifasica(false);   
        fonteProducaoEnergia3.setOperaRedetrifasica(true);
        fonteProducaoEnergia3.setPotenciaEmEstoque(2500);   
        fonteProducaoEnergia3.setOnLineDesde(LocalDateTime.now());
        fonteProducaoEnergia3.calcularEArmazenarEnergiaProduzida();            
        matrizEnergetica.addFontesProducaoEnergia(fonteProducaoEnergia3);        
        
        UnidadeGridFonteProducaoEnergia fonteProducaoEnergia4 = new UnidadeGridFonteProducaoEnergia();        
        fonteProducaoEnergia4.setIdentificadorFonteProducao("USINA NUCLEAR UFCOM");
        fonteProducaoEnergia4.setPotenciaMaximaConsumida(2);
        fonteProducaoEnergia4.setQuantidadeEnergiaConsumidaporHora(15000);
        fonteProducaoEnergia4.setQuantidadeEnergiaProduzidaporHora(25000);
        fonteProducaoEnergia4.setTipoFonteEnergia(NUCLEAR);
        fonteProducaoEnergia4.setFonteRenovavel(false);
        fonteProducaoEnergia4.setModoOperacao(0);
        fonteProducaoEnergia4.setTempoOperacaoEstimado(12);
        fonteProducaoEnergia4.setOperaRedeMonofasica(true);
        fonteProducaoEnergia4.setOperaRedeBifasica(true);   
        fonteProducaoEnergia4.setOperaRedetrifasica(true);
        fonteProducaoEnergia4.setPotenciaEmEstoque(2500);   
        fonteProducaoEnergia4.setOnLineDesde(LocalDateTime.now());
        fonteProducaoEnergia4.calcularEArmazenarEnergiaProduzida();            
        matrizEnergetica.addFontesProducaoEnergia(fonteProducaoEnergia4);                
        
        UnidadeGridFonteProducaoEnergia fonteProducaoEnergia5 = new UnidadeGridFonteProducaoEnergia();        
        fonteProducaoEnergia5.setIdentificadorFonteProducao("USINA CARVAO UF3COM");
        fonteProducaoEnergia5.setPotenciaMaximaConsumida(2);
        fonteProducaoEnergia5.setQuantidadeEnergiaConsumidaporHora(500);
        fonteProducaoEnergia5.setQuantidadeEnergiaProduzidaporHora(500);
        fonteProducaoEnergia5.setTipoFonteEnergia(CARVAO);
        fonteProducaoEnergia5.setFonteRenovavel(true);
        fonteProducaoEnergia5.setModoOperacao(0);
        fonteProducaoEnergia5.setTempoOperacaoEstimado(24);
        fonteProducaoEnergia5.setOperaRedeMonofasica(false);
        fonteProducaoEnergia5.setOperaRedeBifasica(false);   
        fonteProducaoEnergia5.setOperaRedetrifasica(true);
        fonteProducaoEnergia5.setPotenciaEmEstoque(2500);   
        fonteProducaoEnergia5.setOnLineDesde(LocalDateTime.now());
        fonteProducaoEnergia5.calcularEArmazenarEnergiaProduzida();            
        matrizEnergetica.addFontesProducaoEnergia(fonteProducaoEnergia5);                
        
        UnidadeGridFonteProducaoEnergia fonteProducaoEnergia6 = new UnidadeGridFonteProducaoEnergia();        
        fonteProducaoEnergia6.setIdentificadorFonteProducao("USINA BIOMASSA UF3COM");
        fonteProducaoEnergia6.setPotenciaMaximaConsumida(2);
        fonteProducaoEnergia6.setQuantidadeEnergiaConsumidaporHora(500);
        fonteProducaoEnergia6.setQuantidadeEnergiaProduzidaporHora(500);
        fonteProducaoEnergia6.setTipoFonteEnergia(BIOMASSA);
        fonteProducaoEnergia6.setFonteRenovavel(true);
        fonteProducaoEnergia6.setModoOperacao(0);
        fonteProducaoEnergia6.setTempoOperacaoEstimado(24);
        fonteProducaoEnergia6.setOperaRedeMonofasica(false);
        fonteProducaoEnergia6.setOperaRedeBifasica(false);   
        fonteProducaoEnergia6.setOperaRedetrifasica(true);
        fonteProducaoEnergia6.setPotenciaEmEstoque(200);   
        fonteProducaoEnergia6.setOnLineDesde(LocalDateTime.now());
        fonteProducaoEnergia6.calcularEArmazenarEnergiaProduzida();            
        matrizEnergetica.addFontesProducaoEnergia(fonteProducaoEnergia6); 
        
        UnidadeGridFonteProducaoEnergia fonteProducaoEnergia7 = new UnidadeGridFonteProducaoEnergia();        
        fonteProducaoEnergia7.setIdentificadorFonteProducao("USINA GEOTERMICA UF3COM");
        fonteProducaoEnergia7.setPotenciaMaximaConsumida(2);
        fonteProducaoEnergia7.setQuantidadeEnergiaConsumidaporHora(50);
        fonteProducaoEnergia7.setQuantidadeEnergiaProduzidaporHora(100);
        fonteProducaoEnergia7.setTipoFonteEnergia(GEOTERMICA);
        fonteProducaoEnergia7.setFonteRenovavel(false);
        fonteProducaoEnergia7.setModoOperacao(0);
        fonteProducaoEnergia7.setTempoOperacaoEstimado(24);
        fonteProducaoEnergia7.setOperaRedeMonofasica(false);
        fonteProducaoEnergia7.setOperaRedeBifasica(false);   
        fonteProducaoEnergia7.setOperaRedetrifasica(true);
        fonteProducaoEnergia7.setPotenciaEmEstoque(200);   
        fonteProducaoEnergia7.setOnLineDesde(LocalDateTime.now());
        fonteProducaoEnergia7.calcularEArmazenarEnergiaProduzida();            
        matrizEnergetica.addFontesProducaoEnergia(fonteProducaoEnergia7); 
        
        UnidadeGridFonteProducaoEnergia fonteProducaoEnergia8 = new UnidadeGridFonteProducaoEnergia();        
        fonteProducaoEnergia8.setIdentificadorFonteProducao("USINA GAS_NATURAL UF3COM");
        fonteProducaoEnergia8.setPotenciaMaximaConsumida(2);
        fonteProducaoEnergia8.setQuantidadeEnergiaConsumidaporHora(50);
        fonteProducaoEnergia8.setQuantidadeEnergiaProduzidaporHora(100);
        fonteProducaoEnergia8.setTipoFonteEnergia(GAS_NATURAL);
        fonteProducaoEnergia8.setFonteRenovavel(true);
        fonteProducaoEnergia8.setModoOperacao(0);
        fonteProducaoEnergia8.setTempoOperacaoEstimado(24);
        fonteProducaoEnergia8.setOperaRedeMonofasica(false);
        fonteProducaoEnergia8.setOperaRedeBifasica(false);   
        fonteProducaoEnergia8.setOperaRedetrifasica(true);
        fonteProducaoEnergia8.setPotenciaEmEstoque(200);   
        fonteProducaoEnergia8.setOnLineDesde(LocalDateTime.now());
        fonteProducaoEnergia8.calcularEArmazenarEnergiaProduzida();            
        matrizEnergetica.addFontesProducaoEnergia(fonteProducaoEnergia8); 
       
        //Cria um cliente para a rede - 1/9
        UnidadeGridConsumidora consumidor = new UnidadeGridConsumidora();
        consumidor.setConsumidaPorHora(1);
        consumidor.setProducaoPorHora(0);
        consumidor.setIdentificadorUnidadeGrid("UG12346");
        consumidor.setPotenciaMaximaConsumida(300);        
        consumidor.setLimitePotenciaEntregue(0);
        consumidor.setQuantidadeEnergiaConsumida(100);
        consumidor.setQuantidadeEnergiaProduzida(0);
        consumidor.setTipoCorrenteFase(1);
        consumidor.setResponsavelUnidade("Maria Silva");
        consumidor.setTelefoneResponsavel("(64) 92234-5678");
        consumidor.setEmailResponsavel("maria.silva@example.com");
        consumidor.setEnderecoUnidade("Rua dos Espinhos, 4123, Goiânia, GO");
        consumidor.setCoordenadaUnidade("-17.6869, -29.2648");
        consumidor.setFornecedorHomologado(false);
        consumidor.setRedeOnline(false);                 
        consumidor.setConsumidorOnline(false);
        consumidor.setOnLineDesde(LocalDateTime.now());
        unidadeGrid.addConsumidor(consumidor);

        //Cria um cliente para a rede - 2/9
        UnidadeGridConsumidora consumidor1 = new UnidadeGridConsumidora();
        consumidor1.setConsumidaPorHora(1);
        consumidor1.setProducaoPorHora(0);        
        consumidor1.setIdentificadorUnidadeGrid("UOU12346");
        consumidor1.setPotenciaMaximaConsumida(300);        
        consumidor1.setLimitePotenciaEntregue(0);
        consumidor1.setQuantidadeEnergiaConsumida(100);
        consumidor1.setQuantidadeEnergiaProduzida(0);
        consumidor1.setTipoCorrenteFase(2);
        consumidor1.setResponsavelUnidade("Mariano Salva");
        consumidor1.setTelefoneResponsavel("(64) 92224-5678");
        consumidor1.setEmailResponsavel("mariano.salva@example.com");
        consumidor1.setEnderecoUnidade("Rua dos Espinhos, 4123, Goiânia, GO");
        consumidor1.setCoordenadaUnidade("-17.6869, -29.2648");
        consumidor1.setFornecedorHomologado(false);
        consumidor1.setRedeOnline(false);                 
        consumidor1.setConsumidorOnline(false);
        consumidor1.setOnLineDesde(LocalDateTime.now());
        unidadeGrid.addConsumidor(consumidor1);
        
        //Cria um cliente para a rede - 3/9
        UnidadeGridConsumidora consumidor2 = new UnidadeGridConsumidora();
        consumidor2.setConsumidaPorHora(1.5);
        consumidor2.setProducaoPorHora(0);        
        consumidor2.setIdentificadorUnidadeGrid("AG12346");
        consumidor2.setPotenciaMaximaConsumida(300);        
        consumidor2.setLimitePotenciaEntregue(0);
        consumidor2.setQuantidadeEnergiaConsumida(100);
        consumidor2.setQuantidadeEnergiaProduzida(0);
        consumidor2.setTipoCorrenteFase(1);
        consumidor2.setResponsavelUnidade("Marialsa Silviana");
        consumidor2.setTelefoneResponsavel("(64) 92234-5688");
        consumidor2.setEmailResponsavel("marialsa.silva@example.com");
        consumidor2.setEnderecoUnidade("Rua dos Espinhos, 4123, Goiânia, GO");
        consumidor2.setCoordenadaUnidade("-17.6869, -29.2648");
        consumidor2.setFornecedorHomologado(false);
        consumidor2.setRedeOnline(false);                 
        consumidor2.setConsumidorOnline(false);
        consumidor2.setOnLineDesde(LocalDateTime.now());
        unidadeGrid.addConsumidor(consumidor2);

        //Cria um cliente para a rede - 4/9
        UnidadeGridConsumidora consumidor3 = new UnidadeGridConsumidora();
        consumidor2.setConsumidaPorHora(1.5);
        consumidor3.setIdentificadorUnidadeGrid("UAAG12346");
        consumidor3.setPotenciaMaximaConsumida(300);        
        consumidor3.setLimitePotenciaEntregue(0);
        consumidor3.setQuantidadeEnergiaConsumida(100);
        consumidor3.setQuantidadeEnergiaProduzida(0);
        consumidor3.setTipoCorrenteFase(2);
        consumidor3.setResponsavelUnidade("Ostrogildo Silva");
        consumidor3.setTelefoneResponsavel("(64) 91234-5678");
        consumidor3.setEmailResponsavel("ostrogildo.silva@example.com");
        consumidor3.setEnderecoUnidade("Rua dos Espinhos, 4123, Goiânia, GO");
        consumidor3.setCoordenadaUnidade("-17.6869, -29.2648");
        consumidor3.setFornecedorHomologado(false);
        consumidor3.setRedeOnline(false);                 
        consumidor3.setConsumidorOnline(false);
        consumidor3.setOnLineDesde(LocalDateTime.now());
        unidadeGrid.addConsumidor(consumidor3);

        //Cria um cliente para a rede - 5/9
        UnidadeGridConsumidora consumidor4 = new UnidadeGridConsumidora();
        consumidor2.setConsumidaPorHora(1.5);
        consumidor4.setIdentificadorUnidadeGrid("UBHG12346");
        consumidor4.setPotenciaMaximaConsumida(300);        
        consumidor4.setLimitePotenciaEntregue(0);
        consumidor4.setQuantidadeEnergiaConsumida(100);
        consumidor4.setQuantidadeEnergiaProduzida(0);
        consumidor4.setTipoCorrenteFase(1);
        consumidor4.setResponsavelUnidade("Martonildo Silva");
        consumidor4.setTelefoneResponsavel("(64) 92234-1678");
        consumidor4.setEmailResponsavel("martonildo.silva@example.com");
        consumidor4.setEnderecoUnidade("Rua dos Espinhos, 4123, Goiânia, GO");
        consumidor4.setCoordenadaUnidade("-17.6869, -29.2648");
        consumidor4.setFornecedorHomologado(false);
        consumidor4.setRedeOnline(false);                 
        consumidor4.setConsumidorOnline(false);
        consumidor4.setOnLineDesde(LocalDateTime.now());
        unidadeGrid.addConsumidor(consumidor4);

        //Cria um cliente para a rede - 6/9
        UnidadeGridConsumidora consumidor5 = new UnidadeGridConsumidora();
        consumidor2.setConsumidaPorHora(1.5);
        consumidor5.setIdentificadorUnidadeGrid("AUG12346");
        consumidor5.setPotenciaMaximaConsumida(300);        
        consumidor5.setLimitePotenciaEntregue(0);
        consumidor5.setQuantidadeEnergiaConsumida(100);
        consumidor5.setQuantidadeEnergiaProduzida(0);
        consumidor5.setTipoCorrenteFase(1);
        consumidor5.setResponsavelUnidade("Elerterio Silva");
        consumidor5.setTelefoneResponsavel("(65) 92234-5678");
        consumidor5.setEmailResponsavel("elerterio.silva@example.com");
        consumidor5.setEnderecoUnidade("Rua dos Espinhos, 4123, Goiânia, GO");
        consumidor5.setCoordenadaUnidade("-17.6869, -29.2648");
        consumidor5.setFornecedorHomologado(false);
        consumidor5.setRedeOnline(false);                 
        consumidor5.setConsumidorOnline(false);
        consumidor5.setOnLineDesde(LocalDateTime.now());
        unidadeGrid.addConsumidor(consumidor5);

         //Cria um cliente para a rede - 7/9
        UnidadeGridConsumidora consumidor6 = new UnidadeGridConsumidora();
        consumidor2.setConsumidaPorHora(1.5);
        consumidor6.setIdentificadorUnidadeGrid("UGGG12346");
        consumidor6.setPotenciaMaximaConsumida(300);        
        consumidor6.setLimitePotenciaEntregue(0);
        consumidor6.setQuantidadeEnergiaConsumida(100);
        consumidor6.setQuantidadeEnergiaProduzida(0);
        consumidor6.setTipoCorrenteFase(3);
        consumidor6.setResponsavelUnidade("Pebildo Silva");
        consumidor6.setTelefoneResponsavel("(64) 92234-5678");
        consumidor6.setEmailResponsavel("pebildo.silva@example.com");
        consumidor6.setEnderecoUnidade("Rua dos Espinhos, 4123, Goiânia, GO");
        consumidor6.setCoordenadaUnidade("-17.6869, -29.2648");
        consumidor6.setFornecedorHomologado(false);
        consumidor6.setRedeOnline(false);                 
        consumidor6.setConsumidorOnline(false);
        consumidor6.setOnLineDesde(LocalDateTime.now());
        unidadeGrid.addConsumidor(consumidor6);

        //Cria um cliente para a rede - 8/9
        UnidadeGridConsumidora consumidor7 = new UnidadeGridConsumidora();
        consumidor7.setIdentificadorUnidadeGrid("AAUG12346");
        consumidor7.setPotenciaMaximaConsumida(300);        
        consumidor7.setLimitePotenciaEntregue(0);
        consumidor7.setQuantidadeEnergiaConsumida(100);
        consumidor7.setQuantidadeEnergiaProduzida(0);
        consumidor7.setTipoCorrenteFase(1);
        consumidor7.setResponsavelUnidade("Albanesio Silva");
        consumidor7.setTelefoneResponsavel("(64) 92234-5678");
        consumidor7.setEmailResponsavel("albanesio.silva@example.com");
        consumidor7.setEnderecoUnidade("Rua dos Espinhos, 4123, Goiânia, GO");
        consumidor7.setCoordenadaUnidade("-17.6869, -29.2648");
        consumidor7.setFornecedorHomologado(false);
        consumidor7.setRedeOnline(false);                 
        consumidor7.setConsumidorOnline(false);
        consumidor7.setOnLineDesde(LocalDateTime.now());
        unidadeGrid.addConsumidor(consumidor7);

        //Cria um cliente para a rede - 9/9
        UnidadeGridConsumidora consumidor8 = new UnidadeGridConsumidora();
        consumidor8.setIdentificadorUnidadeGrid("TTTG12346");
        consumidor8.setPotenciaMaximaConsumida(300);        
        consumidor8.setLimitePotenciaEntregue(0);
        consumidor8.setQuantidadeEnergiaConsumida(100);
        consumidor8.setQuantidadeEnergiaProduzida(0);
        consumidor8.setTipoCorrenteFase(3);
        consumidor8.setResponsavelUnidade("Antuerpio Silva");
        consumidor8.setTelefoneResponsavel("(64) 92234-5678");
        consumidor8.setEmailResponsavel("antuerpio.silva@example.com");
        consumidor8.setEnderecoUnidade("Rua dos Espinhos, 4123, Goiânia, GO");
        consumidor8.setCoordenadaUnidade("-17.6869, -29.2648");
        consumidor8.setFornecedorHomologado(false);
        consumidor8.setRedeOnline(false);                 
        consumidor8.setConsumidorOnline(false);
        consumidor8.setOnLineDesde(LocalDateTime.now());
        unidadeGrid.addConsumidor(consumidor8);                
                
        //Cria um cliente para a rede - 9/9
        UnidadeGridConsumidora consumidor9 = new UnidadeGridConsumidora();
        consumidor9.setIdentificadorUnidadeGrid("AUAUG12346");
        consumidor9.setPotenciaMaximaConsumida(300);        
        consumidor9.setLimitePotenciaEntregue(0);
        consumidor9.setQuantidadeEnergiaConsumida(1000);
        consumidor9.setQuantidadeEnergiaProduzida(0);
        consumidor9.setTipoCorrenteFase(3);
        consumidor9.setResponsavelUnidade("Shiauau Silva");
        consumidor9.setTelefoneResponsavel("(64) 92234-5678");
        consumidor9.setEmailResponsavel("shiauau.silva@example.com");
        consumidor9.setEnderecoUnidade("Rua dos Espinhos, 4123, Goiânia, GO");
        consumidor9.setCoordenadaUnidade("-17.6869, -29.2648");
        consumidor9.setFornecedorHomologado(false);
        consumidor9.setRedeOnline(false);                 
        consumidor9.setConsumidorOnline(false);
        consumidor9.setOnLineDesde(LocalDateTime.now());
        consumidor9.setConsumidaPorHora(1000);
        unidadeGrid.addConsumidor(consumidor9);                
        
    }
    
        
    public void iniciarlizarOrganizarGridFrames() {

        criarUnidadesdoGrid();

        // Obter as dimensões da tela
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int larguraTela = screenSize.width;
        int alturaTela = screenSize.height;

        // Configurações da grade
        int colunas = 4;
        int linhas = 3;
        int numeroDeFrames = 12;

        // Dimensões de cada frame
        int larguraFrame = larguraTela / colunas;
        int alturaFrame = alturaTela / linhas;

        // Criar e posicionar os frames
        for (int i = 0; i < numeroDeFrames; i++) {
           
            // Calcular a posição do frame
            int x = (i % colunas) * larguraFrame;
            int y = (i / colunas) * alturaFrame;

            switch (i) {
                case 0 -> {
                    Gerenciador usinaDeProducaoCube = new Gerenciador();
                    usinaDeProducaoCube.setSize(larguraFrame, alturaFrame);
                    // Definir a posição do frame
                    usinaDeProducaoCube.setLocation(x, y);
                    usinaDeProducaoCube.setVisible(true);
                }
                case 1 ->{
                        Usina unidadeGridCube = new Usina();
                        unidadeGridCube.setSize(larguraFrame, alturaFrame);
                        // Definir a posição do frame
                        unidadeGridCube.setLocation(x, y);
                        unidadeGridCube.setVisible(true);
                    }
                default ->{
                        Consumidores unidadeGridCube = new Consumidores();
                        unidadeGridCube.setSize(larguraFrame, alturaFrame);
                        // Definir a posição do frame
                        unidadeGridCube.setLocation(x, y);
                        unidadeGridCube.setVisible(true);
                        // Atribuir o consumidor correto a partir da lista
                        unidadeGridCube.indiceObjeto = i - 2;
                        unidadeGridCube.setVisible(false);
                    }
            }
        }
    }

         
    
    public void organizarGridDeFrames(boolean setFrameVisible) {
        
        // Obter todos os frames ativos
        Frame[] frames = Frame.getFrames();
        int countFrame = 0;
        for (Frame frame : frames) {
            ++countFrame;
            if (countFrame > 3){
                frame.setVisible(setFrameVisible);
            }
        }

    }

}

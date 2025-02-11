
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

import javax.swing.JFrame;

import view.frmSplash;

public class StationManager {

    public static void main(String[] args) {
                        
        System.out.println("⚠️⚠️ ATENÇÃO! ⚠️⚠️");
        
        Docmd docmd = Docmd.getInstaciaDoCmd();
        
        frmSplash telaAbertura = new frmSplash(new JFrame(), true);
        telaAbertura.setVisible(true);
        
        docmd.iniciarlizarOrganizarGridFrames();
        
    }
    
}

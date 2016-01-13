/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.es1.as2130557.minesfinder;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author tony
 */
public class BotaoCampoMinado extends JButton{
    private int estadoQuadricula;
    private int numVizinhos;
    
    private int coluna;
    private int linha;
        
        // ************ Constrtutor da classe *************
    public BotaoCampoMinado(int coluna, int linha){
        estadoQuadricula = CampoMinado.TAPADO;
        this.linha= linha;
        this.coluna = coluna;
        setEstadoQuadricula(estadoQuadricula);
        
                        
    }
    // ************  FIM Constrtutor da classe *************

    /**
     *
     * @param estado
     */
    public void setEstadoQuadricula(int estado){
        this.estadoQuadricula = estado;
        if (estadoQuadricula==CampoMinado.TAPADO){
            setText("");
            setForeground(Color.black);
            setBackground(null);    // Abaixo segue o meu código!!! extra tutorial
            
        }else if (estadoQuadricula==CampoMinado.DUVIDA){
            setText("?");
            setForeground(Color.black);
            setBackground(new java.awt.Color(255,255,0)); // yelow?
          
        }else if (estadoQuadricula==CampoMinado.MARCADO){
            setText("!");
            setForeground(Color.black);
            setBackground(Color.red);
         
        }else if (estadoQuadricula == CampoMinado.VAZIO){
            setText("");
            setForeground(Color.black);
            setBackground(Color.DARK_GRAY);    
            
        }else if (estadoQuadricula>CampoMinado.VAZIO && estadoQuadricula<CampoMinado.TAPADO){
            setText(Integer.toString(estadoQuadricula));
            setForeground(Color.red);
            setBackground(Color.DARK_GRAY);       
        }else if (estadoQuadricula==CampoMinado.REBENTADO){
            setText("*");
            setForeground(Color.black);
            setBackground(Color.ORANGE);
        }
    }
    
    public int getLinha(){
        return linha;
    }
    
    public int getColuna(){
        return coluna;
    }
    
    public void setNumVizinhos(){
        
    }
    
    public int getNumVizinhos (){
        return numVizinhos;
    }
    
}

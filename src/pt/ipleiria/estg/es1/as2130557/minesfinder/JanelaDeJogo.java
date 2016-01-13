/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.es1.as2130557.minesfinder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author tony
 */
public class JanelaDeJogo extends javax.swing.JFrame {
    // guarda referencias para os botoes e para o campo minado
    // o uso do modificador "final" torna os tipos primitivos constantes - não podem ter stters associados!
    // e as referencias constantes (não os objectos)
    
    private  BotaoCampoMinado [][] botoes;   // java style; C style, botoes [ ][ ];
    
    private  CampoMinado campoMinado;
    private TabelaRecordes recordes;
    
    /* ********************* CONSTRUTOR DE JANELA DE JOGO ******************* */
    /**
     * Creates new form JanelaDeJogo
     * @param campo
     */
    public JanelaDeJogo(CampoMinado campo, TabelaRecordes tabela) {    // recebe objecto do tipo CampoMinado por parametro
        initComponents();
        // Inicializar atributos
        this.campoMinado = campo; // this apenas necessário, se utilizar o mesmo nome identificador
        this.recordes = tabela;
        
        // definição do título da janela de Jogo em função do numero de minas - não pedido no tutorial
        
        if (campoMinado.getAlturaCampoMinado()==9){
            setTitle("Jogo Fácil");
        }else if (campoMinado.getAlturaCampoMinado()==16){
            setTitle("Jogo Médio");
        }else setTitle("Jogo Dificil");
        
        // instanciação do objecto botoes da Classe BotaoCampoMinado
         botoes = new 
BotaoCampoMinado[campoMinado.getLarguraCampoMinado()][campoMinado.getAlturaCampoMinado()];
        // Definir o Layout Manager da janela
        getContentPane().setLayout ( new 
        GridLayout(campoMinado.getAlturaCampoMinado(),campoMinado.getLarguraCampoMinado()));
        
        // *********************************************************************************************************************************
        // *********  Criar um controlador para os eventos ***********************************************************************
        // *********************************************************************************************************************************
        ActionListener action  = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                BotaoCampoMinado botao = (BotaoCampoMinado) e.getSource();
                int x = botao.getColuna();
                int y = botao.getLinha();
                campoMinado.revelarQuadricula(x, y);
                actualizarEstadoBotoes();   // fim da página 20 do tutorial -> Funciona!
                if (campoMinado.isJogoTerminado()) { 
                    if (campoMinado.isJogadorDerrotado())
                        JOptionPane.showMessageDialog(JanelaDeJogo.this, "Oh, rebentou uma mina!","Perdeu",JOptionPane.INFORMATION_MESSAGE);
                    else{
                        JOptionPane.showMessageDialog(JanelaDeJogo.this, "Parabéns. Conseguiu descobrir todas as minas em "
                                +(campoMinado.getDuracaoJogo()/1000)+" segundos!","Vitoria",JOptionPane.INFORMATION_MESSAGE);
                        boolean novoRecorde = (campoMinado.getDuracaoJogo() < recordes.getTempoJogo());
                        if (novoRecorde){
                            String nome = JOptionPane.showInputDialog("Introduza o seu nome: ");
                             recordes.setRecorde(nome,campoMinado.getDuracaoJogo());                           
                        }                                                                             
                    }                        
                    setVisible(false);
                }
            }
            
        };
        MouseListener mouseListener = new MouseListener() {
           @Override
            public void mouseClicked(MouseEvent e) {
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    BotaoCampoMinado botao = (BotaoCampoMinado) e.getSource();
                    int x = botao.getColuna();
                    int y = botao.getLinha();
                     marcarQuadricula(x,y);                   
                    actualizarEstadoBotoes();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {             
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {                
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                BotaoCampoMinado botao = (BotaoCampoMinado) e.getSource();
                int x = botao.getColuna();
                int y = botao.getLinha();
                if (e.getKeyCode() == KeyEvent.VK_UP && y > 0) {
                    botoes[x][y-1].requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT && x > 0) {
                    botoes[x-1][y].requestFocus();
                }else if (e.getKeyCode() == KeyEvent.VK_DOWN && y < campoMinado.getAlturaCampoMinado()-1) {
                    botoes[x][y+1].requestFocus();                            
                }else if (e.getKeyCode() == KeyEvent.VK_RIGHT && x < campoMinado.getLarguraCampoMinado()-1) {
                    botoes[x+1][y].requestFocus();
                }else if (e.getKeyCode() == KeyEvent.VK_M) {
                    marcarQuadricula(x,y);
                    actualizarEstadoBotoes(); 
                }
                
            }
        
            @Override
            public void keyReleased(KeyEvent e) {               
            }
        };
       
       // *********************************************************************************************************************************
        // *********  Fim de controlador para os eventos ***********************************************************************
        // *********************************************************************************************************************************
// Criar e adicionar os botoes à janela
        for (int y=0; y<campoMinado.getAlturaCampoMinado(); y++){
            for (int x=0; x<campoMinado.getLarguraCampoMinado(); x++){
                botoes[x][y] = new BotaoCampoMinado(x,y);
                botoes[x][y].addActionListener(action);
                botoes[x][y].addMouseListener(mouseListener);                
                botoes[x][y].addKeyListener(keyListener);
                getContentPane().add(botoes[x][y]);
            }        
        }        
    }
    /* *********************  FIM CONSTRUTOR DE JANELA DE JOGO ******************* */

    private void actualizarEstadoBotoes(){
        for (int x=0;x< campoMinado.getLarguraCampoMinado(); x++){
            for (int y=0; y<campoMinado.getAlturaCampoMinado();y++){
                botoes[x][y].setEstadoQuadricula(campoMinado.getEstadoQuadricula(x, y));
            }
        }
    }
    // Método auxiliar para código repetido no mouseListener e no keyListener
    private void marcarQuadricula(int x,int y){
         if (campoMinado.getEstadoQuadricula(x, y) == CampoMinado.TAPADO)
                        campoMinado.marcarComoTendoMina(x,y);
                    else if (campoMinado.getEstadoQuadricula(x,y) == CampoMinado.MARCADO)
                        campoMinado.marcarComoSuspeita(x, y);
                    else if (campoMinado.getEstadoQuadricula(x, y) == CampoMinado.DUVIDA)
                        campoMinado.desmarcarQuadricula(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setAlwaysOnTop(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

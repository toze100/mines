/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.es1.as2130557.minesfinder;

import java.util.Random;

/**
 *
 * @author tony
 * Esta classe corresponde na trilogia MVC, ao M - Model, ou modelo de dados
 */
public class CampoMinado {
    // identifica posições com minas (true ou false)
    private final boolean [][]minas;
    /*
    se cada quadricula está tapada
    se cada quadricula está assinalada como tendo mina
    se cada quadricula está assinalada como duvidosa
    quantas minas existem na vizinhança
    */
    // definição de ESTADOS
    public static final int VAZIO=0;
    /* de 1 a 8 são o numero de minas á volta */
    public static final int TAPADO=9;
    public static final int DUVIDA=10;
    public static final int MARCADO=11;
    public static final int REBENTADO=12;
    // definição de atributo
    private final int [][]estado;
    //definição do campo de minas
    private final int largura;
    private final int  altura;
    private final int numMinas;
    private boolean primeiraJogada;
    private final Random gerador;
    
    // para cumprir com a REGRA4
    private boolean jogoTerminado;
    private boolean jogadorDerrotado;
    
    // REGRA 11 - contabilização do tempo
    private long instanteInicioJogo;
    private long duracaoJogo;
    
    
    // ************ Constrtutor da classe ***************************************
    public CampoMinado(int largura, int altura, int numMinas){
        this.largura = largura;
        this.altura = altura;
        this.numMinas = numMinas;
        primeiraJogada=true;
        minas = new boolean[largura][altura]; // Valores começam a false
        estado = new int [largura][altura]; // valores começam a 0
        gerador = new Random();
        jogoTerminado = false;
        jogadorDerrotado = false;
        
        // Inicialização do estado para TAPADO 
        // REGRA 1
        for (int x=0; x<largura; x++){
            for (int y=0; y<altura; y++)
                estado[x][y]=TAPADO;
        }
        
    }     // ************ FIM Construtor da classe *******************************
    
    public void revelarQuadricula(int x, int y){
        
        if (estado[x][y] ==TAPADO && !jogoTerminado){
            //parte da REGRA3
            if (primeiraJogada){
                primeiraJogada=false;
                colocarMinas(x, y);
                instanteInicioJogo = System.currentTimeMillis();    // REGRA 11
                
            }
             if (minas[x][y]){
                estado[x][y]=REBENTADO;
               // botoes[x][y].setEstadoQuadricula(estado[x][y]);                
                jogoTerminado=true;
                jogadorDerrotado=true;               
                duracaoJogo = System.currentTimeMillis() - instanteInicioJogo;  // REGRA 11
                
            }   // REGRA 5
             else {
                 estado[x][y] = contarMinasAVolta(x, y);
                 // REGRA 6
                 if (estado[x][y] == VAZIO){
                     revelarQuadriculasVizinhas(x,y);
                 }
                 if (verificarVitoria()){
                     jogoTerminado = true;
                     jogadorDerrotado = false;
                     duracaoJogo = System.currentTimeMillis() - instanteInicioJogo;  // REGRA 11
                 }
             }
               
        }
    }
    // REGRA 6
    private void revelarQuadriculasVizinhas(int x, int y){
        for (int  coluna=Math.max(0, x-1);coluna<Math.min(largura, x+2); coluna++)
        {
            for (int linha=Math.max(0, y-1); linha<Math.min(altura, y+2); linha++)
            {
                revelarQuadricula(coluna,linha);
            }
        }                
    }
    
    private void colocarMinas(int exceptoX, int exceptoY){
        for (int i=0; i<numMinas;i++){
            int x=0; int y=0;
            do{
                x=gerador.nextInt(largura);
                y=gerador.nextInt(altura);                         
            } while (minas[x][y] || (x==exceptoX && y==exceptoY));
            minas[x][y]=true;
        }
    }
    
    public int contarMinasAVolta(int x, int y){
        int resultado=0;
        for (int  coluna=Math.max(0, x-1);coluna<Math.min(largura, x+2); coluna++)
        {
            for (int linha=Math.max(0, y-1); linha<Math.min(altura, y+2); linha++)
            {
                if (minas[coluna][linha]){  //  minas [largura][altura] na instanciação
                    resultado++;                    
                }
            }
        }
        return resultado-(minas[x][y] ? 1 : 0); // previne contagem da própria quadricula se tem mina
    }
    
    // REGRA 7
    private boolean  verificarVitoria(){
        boolean vitoria = true;
        for (int x=0; x<largura; x++){
            for (int y=0; y<altura; y++){
                if (!minas[x][y]){
                    vitoria = vitoria && estado[x][y] >= 0 && estado[x][y] <9;
                }
            }
        }
        return vitoria;
    }
    
    // REGRA 8
    public void marcarComoTendoMina(int x, int y){
        if (estado[x][y] == TAPADO || estado[x][y] == DUVIDA){
            estado[x][y] = MARCADO;
        }
    }
    
    // REGRA 9
    public void marcarComoSuspeita(int x, int y){
        if (estado[x][y] == TAPADO || estado[x][y] == MARCADO){
            estado[x][y] = DUVIDA;
        }
    }
    
    // REGRA 10
    public void desmarcarQuadricula(int x, int y){
        if (estado[x][y] == MARCADO || estado[x][y] == DUVIDA){
            estado[x][y] = TAPADO;
        }
    }
    
// métodos get's para saber atributos do objecto
    public int getEstadoQuadricula(int x, int y){
        return estado[x][y];
    }
    public boolean hasMina(int x, int y){
        return minas[x][y];
    }
    public int getLarguraCampoMinado(){
        return this.largura;
    }
    public int getAlturaCampoMinado(){
        return this.altura;
    }
    public int getNumMinasCampoMinado(){
        return this.numMinas;
    }
    public boolean isJogoTerminado(){
        return this.jogoTerminado;
    }
    public boolean isJogadorDerrotado(){
        return this.jogadorDerrotado;
    }
    public long getDuracaoJogo(){
        if (primeiraJogada)  // O jogo ainda não começou
            return 0;
        if (!jogoTerminado)
            return System.currentTimeMillis() - instanteInicioJogo;
        return duracaoJogo;
    }
    
    /* Fim de definição do modelo de dados */
        
}

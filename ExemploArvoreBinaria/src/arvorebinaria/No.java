package arvorebinaria;

public class No {
    
    private No esquerda;
    private No direita;
    
    private double valor;
    
    public No(double valor){
        this.esquerda = null;
        this.direita = null;
        this.valor = valor;                 
    }

    public No getEsquerda() {  return esquerda;    }
    public void setEsquerda(No esquerda) {this.esquerda = esquerda;    }
    public No getDireita() {  return direita;    }
    public void setDireita(No direita) {  this.direita = direita;    }
    public double getValor() {  return valor;    }
    public void setValor(double valor) {  this.valor = valor;    }
    
    
    
}

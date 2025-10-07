package arvorebinaria;

public class ArvoreABB {
    
    private No raiz;
    
    public ArvoreABB(){
        this.raiz = null;
    }
    
    public boolean vazia(){
        return (this.raiz == null);
    }
    
    private boolean direitaVazia(No elemento){
        return (elemento.getDireita() == null);
    }
    
    private boolean esquerdaVazia(No elemento){
        return (elemento.getEsquerda() == null);
    }
    
    public boolean insere(double valor){
        if (vazia()){
            No aux = new No(valor);
            this.raiz = aux;
            return true;
        }
        
        No aux = new No(valor);
        
        No ant = null;
        No temp = this.raiz;
        while(temp != null){
            if (valor == temp.getValor()){
                return false;
            }
            else if (valor > temp.getValor()){ 
                ant = temp;
                temp = temp.getDireita();
            } 
            //if (valor < temp.getValor()){
            else {
                ant = temp;
                temp = temp.getEsquerda();
            }
        }
        
        if (valor > ant.getValor()){
            ant.setDireita(aux);
            return true;
        } else {
            ant.setEsquerda(aux);
            return true;
        }
    }
    
    public void printPrecurso(){
        if (vazia()) {
            System.out.println("Arvore vazia");
        }
        precurso(this.raiz);
    }
    public void printIncurso(){
        if (vazia()) {
            System.out.println("Arvore vazia");
        }
        incurso(this.raiz);
    }
    
    private void precurso(No elemento){
        
        if (elemento == null) { 
            return;
        }
        else {
            System.out.println(elemento.getValor());
            if (elemento.getEsquerda() != null) 
                precurso(elemento.getEsquerda());
            
            if (elemento.getDireita() != null) 
                precurso(elemento.getDireita());
        }
    }
    
    private void incurso(No elemento){
        
        if (elemento == null) { 
            return;
        }
        else {
            
            if (elemento.getEsquerda() != null) 
                incurso(elemento.getEsquerda());
            
            System.out.println(elemento.getValor());
            
            if (elemento.getDireita() != null) 
                incurso(elemento.getDireita());
        }
    }
    
    public boolean busca (double valor){
        if (vazia()){
            return false;
        }
        
        No aux = this.raiz;
        while(aux != null){
            if(aux.getValor()== valor){
                return true;
            }
            else if(valor > aux.getValor()){
                aux=aux.getDireita();
            }
            else{
                aux=aux.getEsquerda();
            }
        }
        
        return false;
    }
    
    
    
}

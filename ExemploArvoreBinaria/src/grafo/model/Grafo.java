package grafo.model;

public class Grafo<T> {

    private final int tamanhoMaximo;
    private final int[][] matrizAdjacencia;
    private final Object[] vertices;
    private int numVertices;


    public Grafo(int maxVertices) {
        this.tamanhoMaximo = maxVertices;
        this.matrizAdjacencia = new int[maxVertices][maxVertices];
        this.vertices = new Object[maxVertices];
        this.numVertices = 0;
        
    }



    public void adicionarAresta(T origemDado, T destinoDado, int peso) {
        if (peso <= 0) {

            throw new IllegalArgumentException("Peso deve ser positivo.");
        }
        
        int indiceOrigem = getOuAdicionarIndice(origemDado);
        int indiceDestino = getOuAdicionarIndice(destinoDado);
        
        matrizAdjacencia[indiceOrigem][indiceDestino] = peso;
    }


    private int getOuAdicionarIndice(T dado) {
        
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(dado)) {
                return i;
            }
        }
        

        if (numVertices >= tamanhoMaximo) {
            throw new RuntimeException("Tamanho máximo do grafo excedido: " + tamanhoMaximo);
        }
        
        vertices[numVertices] = dado;
        int novoIndice = numVertices;
        numVertices++;
        return novoIndice;
    }
    

    public int getNumVertices() {
        return this.numVertices;
    }
    
    public int getPeso(int indiceOrigem, int indiceDestino) {
        return this.matrizAdjacencia[indiceOrigem][indiceDestino];
    }
    

    @SuppressWarnings("unchecked")
    public T getDado(int indice) {
        if (indice < 0 || indice >= numVertices) {
            return null;
        }
        return (T) this.vertices[indice];
    }
    

    public int getIndice(T dado) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(dado)) {
                return i;
            }
        }
        return -1;
    }
}
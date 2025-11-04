package grafo.model;

public record Aresta<T>(Vertice<T> destino, int peso) {
    public Aresta {
        if (peso < 0) {
            throw new IllegalArgumentException("O peso da aresta não pode ser negativo para o Dijkstra.");
        }
    }
}

package grafo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Grafo<T> {

    private final Map<Vertice<T>, List<Aresta<T>>> listaAdjacencia = new HashMap<>();
    
    private final Map<T, Vertice<T>> vertices = new HashMap<>();


    public void adicionarAresta(T origemDado, T destinoDado, int peso) {

        Vertice<T> origem = vertices.computeIfAbsent(origemDado, Vertice::new);
        

        Vertice<T> destino = vertices.computeIfAbsent(destinoDado, Vertice::new);

        listaAdjacencia.computeIfAbsent(origem, k -> new ArrayList<>()).add(new Aresta<>(destino, peso));

        listaAdjacencia.computeIfAbsent(destino, k -> new ArrayList<>());
    }

    public List<Aresta<T>> getArestas(Vertice<T> vertice) {
        return listaAdjacencia.getOrDefault(vertice, Collections.emptyList());
    }

    public Vertice<T> getVertice(T dado) {
        return vertices.get(dado);
    }
    

    public Collection<Vertice<T>> getVertices() {
        return Collections.unmodifiableCollection(vertices.values());
    }
}
package grafo.algoritm;

import grafo.model.Vertice;
import java.util.Map;

public record ResultadoDijkstra<T>(
        Map<Vertice<T>, Integer> distancias,
        Map<Vertice<T>, Vertice<T>> predecessores) {
}
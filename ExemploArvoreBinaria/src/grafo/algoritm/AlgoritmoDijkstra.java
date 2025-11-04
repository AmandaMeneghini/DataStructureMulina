package grafo.algoritm;

import grafo.model.Aresta;
import grafo.model.Grafo;
import grafo.model.Vertice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class AlgoritmoDijkstra<T> {

    public ResultadoDijkstra<T> encontrarCaminhosMaisCurtos(Grafo<T> grafo, Vertice<T> origem) {
        
        Map<Vertice<T>, Integer> distancias = new HashMap<>();
        PriorityQueue<Vertice<T>> filaPrioridade = new PriorityQueue<>(
            Comparator.comparingInt(distancias::get)
        );

        Map<Vertice<T>, Vertice<T>> predecessores = new HashMap<>();
        
        for (Vertice<T> vertice : grafo.getVertices()) {
            distancias.put(vertice, Integer.MAX_VALUE);
            predecessores.put(vertice, null);
        }
        
        distancias.put(origem, 0);
        filaPrioridade.add(origem);

        while (!filaPrioridade.isEmpty()) {

            Vertice<T> u = filaPrioridade.poll();

            for (Aresta<T> aresta : grafo.getArestas(u)) {
                Vertice<T> v = aresta.destino();
                int pesoAresta = aresta.peso();
                
                int distAteU = distancias.get(u);
                
                if (distAteU == Integer.MAX_VALUE) {
                    continue;
                }

                int novaDist = distAteU + pesoAresta;

                if (novaDist < distancias.get(v)) {

                    distancias.put(v, novaDist);

                    predecessores.put(v, u);
                    
                    filaPrioridade.remove(v);
                    filaPrioridade.add(v);
                }
            }
        }
        
        return new ResultadoDijkstra<>(distancias, predecessores);
    }
}
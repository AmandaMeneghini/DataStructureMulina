package grafo.algoritm;

import grafo.model.Grafo;


public class AlgoritmoDijkstra<T> {


    private static final int INFINITO = Integer.MAX_VALUE;

    public ResultadoDijkstra encontrarCaminhosMaisCurtos(Grafo<T> grafo, T origemDado) {
        
        int numVertices = grafo.getNumVertices();
        int indiceOrigem = grafo.getIndice(origemDado);

        if (indiceOrigem == -1) {
            throw new IllegalArgumentException("Vértice de origem não encontrado no grafo.");
        }


        int[] distancias = new int[numVertices];
        int[] predecessores = new int[numVertices];
        boolean[] visitados = new boolean[numVertices];


        for (int i = 0; i < numVertices; i++) {
            distancias[i] = INFINITO;
            predecessores[i] = -1;
        }
        

        distancias[indiceOrigem] = 0;


        for (int count = 0; count < numVertices; count++) {
            

            int u = encontrarMenorDistanciaNaoVisitado(distancias, visitados, numVertices);


            if (u == -1) {
                break;
            }


            visitados[u] = true;


            for (int v = 0; v < numVertices; v++) {
                
                int pesoAresta = grafo.getPeso(u, v);
                

                if (pesoAresta > 0 && !visitados[v] && distancias[u] != INFINITO) {

                    int novaDist = distancias[u] + pesoAresta;

                    if (novaDist < distancias[v]) {

                        distancias[v] = novaDist;
                        predecessores[v] = u;
                    }
                }
            }
        }
        
        return new ResultadoDijkstra(distancias, predecessores);
    }

    private int encontrarMenorDistanciaNaoVisitado(int[] distancias, boolean[] visitados, int numVertices) {
        int menorDistancia = INFINITO;
        int indiceMenor = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!visitados[v] && distancias[v] <= menorDistancia) {
                menorDistancia = distancias[v];
                indiceMenor = v;
            }
        }
        
        return indiceMenor;
    }
}
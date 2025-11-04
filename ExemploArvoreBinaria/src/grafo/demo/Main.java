package grafo.demo;

import grafo.algoritm.AlgoritmoDijkstra;
import grafo.algoritm.ResultadoDijkstra;
import grafo.model.Grafo;


public class Main {


    private static final int TAMANHO_MAX_GRAFO = 10;

    public static void main(String[] args) {
        System.out.println("--- Exemplo 1: Grafo (Início: 'c', Fim: 'e') (Versão Matriz) ---");
        rodarGrafo1();

        System.out.println("\n\n--- Exemplo 2: Grafo (Início: 'a', Fim: 'h') (Versão Matriz) ---");
        rodarGrafo2();
    }

    private static void rodarGrafo1() {

        Grafo<String> grafo1 = new Grafo<>(TAMANHO_MAX_GRAFO);
        

        grafo1.adicionarAresta("a", "b", 2);
        grafo1.adicionarAresta("b", "e", 5);
        grafo1.adicionarAresta("c", "a", 1);
        grafo1.adicionarAresta("c", "f", 5);
        grafo1.adicionarAresta("c", "b", 4);
        grafo1.adicionarAresta("c", "d", 3);
        grafo1.adicionarAresta("e", "d", 1);
        grafo1.adicionarAresta("f", "e", 2);
        grafo1.adicionarAresta("f", "f", 2);

        String origemNome = "c";
        String destinoNome = "e";

        AlgoritmoDijkstra<String> dijkstra = new AlgoritmoDijkstra<>();
        ResultadoDijkstra resultado = dijkstra.encontrarCaminhosMaisCurtos(grafo1, origemNome);
                
        System.out.println("Calculando caminhos mais curtos a partir de: " + origemNome);
        imprimirResultados(grafo1, resultado, destinoNome);
    }

    private static void rodarGrafo2() {
        Grafo<String> grafo2 = new Grafo<>(TAMANHO_MAX_GRAFO);

        grafo2.adicionarAresta("a", "c", 1);
        grafo2.adicionarAresta("a", "d", 4);
        grafo2.adicionarAresta("a", "b", 2);
        grafo2.adicionarAresta("a", "h", 10);
        grafo2.adicionarAresta("b", "a", 2);
        grafo2.adicionarAresta("b", "f", 4);
        grafo2.adicionarAresta("b", "h", 9);
        grafo2.adicionarAresta("c", "a", 1);
        grafo2.adicionarAresta("c", "g", 1);
        grafo2.adicionarAresta("c", "d", 2);
        grafo2.adicionarAresta("d", "a", 4);
        grafo2.adicionarAresta("d", "c", 2);
        grafo2.adicionarAresta("d", "e", 3);
        grafo2.adicionarAresta("e", "d", 3);
        grafo2.adicionarAresta("e", "f", 1);
        grafo2.adicionarAresta("e", "g", 3);
        grafo2.adicionarAresta("e", "h", 7);
        grafo2.adicionarAresta("f", "b", 4);
        grafo2.adicionarAresta("f", "g", 9);
        grafo2.adicionarAresta("f", "e", 1);
        grafo2.adicionarAresta("g", "f", 9);
        grafo2.adicionarAresta("g", "c", 1);
        grafo2.adicionarAresta("g", "e", 3);
        grafo2.adicionarAresta("h", "a", 10);
        grafo2.adicionarAresta("h", "e", 7);
        grafo2.adicionarAresta("h", "b", 9);

        String origemNome = "a";
        String destinoNome = "h";

        AlgoritmoDijkstra<String> dijkstra = new AlgoritmoDijkstra<>();
        ResultadoDijkstra resultado = dijkstra.encontrarCaminhosMaisCurtos(grafo2, origemNome);
        
        System.out.println("Calculando caminhos mais curtos a partir de: " + origemNome);
        imprimirResultados(grafo2, resultado, destinoNome);
    }

    private static <T> void imprimirResultados(Grafo<T> grafo, ResultadoDijkstra resultado, T destinoDado) {
        
        int[] distancias = resultado.distancias();
        int[] predecessores = resultado.predecessores();
        
        System.out.println("\nDistância mínima para todos os vértices:");
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            T dado = grafo.getDado(i);
            int dist = distancias[i];
            String distStr = (dist == Integer.MAX_VALUE) ? "Inalcançável" : dist + "";
            System.out.println("  - " + dado + ": " + distStr);
        }

        System.out.println("\nCaminho mais curto para '" + destinoDado + "':");

        int indiceDestino = grafo.getIndice(destinoDado);
        if (indiceDestino == -1) {
            System.out.println("  Destino não encontrado no grafo.");
            return;
        }
        
        if (distancias[indiceDestino] == Integer.MAX_VALUE) {
            System.out.println("  Nenhum caminho encontrado.");
            return;
        }

        String caminho = "";
        int indiceAtual = indiceDestino;
        
        while (indiceAtual != -1) {
            String nomeVertice = grafo.getDado(indiceAtual).toString();
            if (caminho.isEmpty()) {
                caminho = nomeVertice;
            } else {
                caminho = nomeVertice + " -> " + caminho;
            }
            indiceAtual = predecessores[indiceAtual];
        }

        System.out.println("  " + caminho + " (Custo Total: " + distancias[indiceDestino] + ")");
    }
}
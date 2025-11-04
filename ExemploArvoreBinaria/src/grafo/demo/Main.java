package grafo.demo;

import grafo.algoritm.AlgoritmoDijkstra;
import grafo.algoritm.ResultadoDijkstra;
import grafo.model.Grafo;
import grafo.model.Vertice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Exemplo 1: Grafo (Início: 'c', Fim: 'e') ---");
        rodarGrafo1();

        System.out.println("\n\n--- Exemplo 2: Grafo (Início: 'a', Fim: 'h') ---");
        rodarGrafo2();
    }

    private static void rodarGrafo1() {
        Grafo<String> grafo1 = new Grafo<>();

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

        Vertice<String> origem = grafo1.getVertice(origemNome);
        Vertice<String> destino = grafo1.getVertice(destinoNome);

        AlgoritmoDijkstra<String> dijkstra = new AlgoritmoDijkstra<>();
        ResultadoDijkstra<String> resultado = dijkstra.encontrarCaminhosMaisCurtos(grafo1, origem);

        System.out.println("Calculando caminhos mais curtos a partir de: " + origemNome);
        imprimirResultados(resultado, destino);
    }

    private static void rodarGrafo2() {
        Grafo<String> grafo2 = new Grafo<>();

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

        Vertice<String> origem = grafo2.getVertice(origemNome);
        Vertice<String> destino = grafo2.getVertice(destinoNome);

        AlgoritmoDijkstra<String> dijkstra = new AlgoritmoDijkstra<>();
        ResultadoDijkstra<String> resultado = dijkstra.encontrarCaminhosMaisCurtos(grafo2, origem);

        System.out.println("Calculando caminhos mais curtos a partir de: " + origemNome);
        imprimirResultados(resultado, destino);
    }

    private static <T> void imprimirResultados(ResultadoDijkstra<T> resultado, Vertice<T> destinoEspecifico) {
        Map<Vertice<T>, Integer> distancias = resultado.distancias();
        Map<Vertice<T>, Vertice<T>> predecessores = resultado.predecessores();

        System.out.println("\nDistância mínima para todos os vértices:");
        distancias.forEach((vertice, distancia) -> {
            String distStr = (distancia == Integer.MAX_VALUE) ? "Inalcançável" : distancia + "";
            System.out.println("  - " + vertice.dado() + ": " + distStr);
        });

        System.out.println("\nCaminho mais curto para '" + destinoEspecifico.dado() + "':");
        List<Vertice<T>> caminho = new ArrayList<>();
        Vertice<T> passo = destinoEspecifico;

        if (distancias.get(passo) == Integer.MAX_VALUE) {
            System.out.println("  Nenhum caminho encontrado.");
            return;
        }

        if (distancias.get(destinoEspecifico) == 0) {
            System.out.println("  " + destinoEspecifico.dado() + " (Custo: 0)");
            return;
        }

        while (passo != null) {
            caminho.add(passo);
            passo = predecessores.get(passo);
        }
        Collections.reverse(caminho);


        StringBuilder caminhoStr = new StringBuilder();
        for (int i = 0; i < caminho.size(); i++) {
            caminhoStr.append(caminho.get(i).dado());
            if (i < caminho.size() - 1) {
                caminhoStr.append(" -> ");
            }
        }
        caminhoStr.append(" (Custo Total: ").append(distancias.get(destinoEspecifico)).append(")");
        System.out.println("  " + caminhoStr.toString());
    }
}
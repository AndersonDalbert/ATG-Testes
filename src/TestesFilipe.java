/**
 * Author: Filipe Mendonça
 * 04/06/2018
 */

import controller.Controller;
import graph.Graph;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

import static org.junit.Assert.fail;

public class TestesFilipe {

    public TestesFilipe() {

    }

    public void generateGraph(int nVertices, int nEdges) {

        int currentVertices = 0;
        int currentEdges = 0;

        String output = String.valueOf(nEdges) + "\n";
        Random rand = new Random();

        nEdges = Math.min(nEdges, (nVertices * (nVertices - 1)) / 2);

        HashSet<String> edges = new HashSet<>();

        while (edges.size() != nEdges) {

            String v1 = String.valueOf(rand.nextInt(nVertices) + 1);
            String v2 = String.valueOf(rand.nextInt(nVertices) + 1);

            if (v1.equals(v2)) {
                continue;
            }

            String edge = v1 + " " + v2;
            output += edge + "\n";

            edges.add(edge);

        }

        BufferedWriter out = null;

        try {

            out = new BufferedWriter(new FileWriter("testReadGraph.txt"));
            out.write(output);
            out.close();

        } catch (IOException e) {
            System.out.println("Exception ");
        }


    }

    public void generateWeightedGraph(int nVertices, int nEdges) {

        int currentVertices = 0;
        int currentEdges = 0;

        String output = String.valueOf(nEdges) + "\n";
        Random rand = new Random();

        nEdges = Math.min(nEdges, (nVertices * (nVertices - 1)) / 2);

        HashSet<String> edges = new HashSet<>();

        while (edges.size() != nEdges) {

            String v1 = String.valueOf(rand.nextInt(nVertices) + 1);
            String v2 = String.valueOf(rand.nextInt(nVertices) + 1);
            String v3 = String.valueOf(rand.nextDouble());

            if (v1.equals(v2)) {
                continue;
            }

            String edge = v1 + " " + v2 + " " + v3;
            output += edge + "\n";

            edges.add(edge);

        }

        BufferedWriter out = null;

        try {

            out = new BufferedWriter(new FileWriter("testReadWeightedGraph.txt"));
            out.write(output);
            out.close();

        } catch (IOException e) {
            System.out.println("Exception ");
        }


    }

    @Test
    public void readGraph01() {

        generateGraph(10, 23);

        try {

            Controller ctrl = new Controller();
            Graph g = ctrl.readGraph("testReadGraph.txt");

        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void readGraph02() {

        generateGraph(3, 2);

        try {

            Controller ctrl = new Controller();
            Graph g = ctrl.readGraph("testReadGraph.txt");

        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void readGraph03() {

        String simpleGraph = "1" + "\n" + "1 2";

        BufferedWriter out = null;

        try {

            out = new BufferedWriter(new FileWriter("simpleGraph.txt"));
            out.write(simpleGraph);
            out.close();

        } catch (IOException e) {
            System.out.println("Exception ");
        }

        try {

            Controller ctrl = new Controller();
            Graph g = ctrl.readGraph("simpleGraph.txt");


        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void readWeigthedGraph01() {

        generateWeightedGraph(5, 12);

        try {

            Controller ctrl = new Controller();
            Graph g = ctrl.readGraph("testReadWeithedGraph.txt");


        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void readWeigthedGraph02() {

        generateWeightedGraph(3, 2);

        try {

            Controller ctrl = new Controller();
            Graph g = ctrl.readGraph("testReadWeithedGraph.txt");


        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void readWeigthedGraph03() {

        String simpleGraph = "1" + "\n" + "1 2 4.2";

        BufferedWriter out = null;

        try {

            out = new BufferedWriter(new FileWriter("simpleWeightedGraph.txt"));
            out.write(simpleGraph);
            out.close();

        } catch (IOException e) {
            System.out.println("Exception ");
        }

        try {

            Controller ctrl = new Controller();
            Graph g = ctrl.readGraph("simpleWeightedGraph.txt");


        } catch (Exception e) {
            fail();
        }

    }
}

/**
 *
 * Nota: 0
 *
 * Foram criados testes para leitura dos grafos a partir de um arquivo de texto e nenhum obteve sucesso.
 * Biblioteca foi incapaz de ler um grafo com apenas uma aresta, o que impossibilita a realização dos demais testes.
 *
 *
 *
 *
 *
 */

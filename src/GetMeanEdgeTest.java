
import static org.junit.Assert.*;

import org.junit.Test;

import graph.Graph;
import graph.WeightedGraph;

/**
 * Classe de testes para verificar a corretude do método getMeanEdge,
 * utilizando diversos tipos de grafos.
 * Nota sugerida: 4.3 - funciona para apenas alguns casos de teste
 * 
 * @author Anderson Dalbert
 * 
 *
 */
public class GetMeanEdgeTest {

	/**
	 * Verifica se o grau de um grafo vazio é zero.
	 */
	@Test
	public void testGrafoVazio() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		Graph graph = new Graph(1, verticesOrigem, verticesDestino);
		
		assertEquals(0.0, graph.getMeanEdge(), 0.001);
	}

	/**
	 * Verifica se o grau de um grafo nulo é zero.
	 */
	@Test
	public void testGrafoNulo() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		Graph graph = new Graph(0, verticesOrigem, verticesDestino);
		
		assertEquals(0.0, graph.getMeanEdge(), 0.001);
	}
	
	/**
	 * Verifica se o grau de um grafo caminho é calculado corretamente.
	 */
	@Test
	public void testGrafoCaminho() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {2, 3};
		Graph graph = new Graph(0, verticesOrigem, verticesDestino);
		
		assertEquals( (4.0/3.0), graph.getMeanEdge(), 0.001);
	}
	
	/**
	 * O grau de um grafo completo deve ser igual ao nº de vertices - 1
	 */
	@Test
	public void testGrafoCompleto() {
		Integer[] verticesOrigem = new Integer[] {1, 1, 2};
		Integer[] verticesDestino = new Integer[] {2, 3, 3};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertEquals(2.0, graph.getMeanEdge(), 0.001);
	}
	
	/**
	 * Cada loop deve contar 2 pontos para o grau de cada vértice
	 */
	@Test
	public void testGrafoComLoop() {
		Integer[] verticesOrigem = new Integer[] {1};
		Integer[] verticesDestino = new Integer[] {1};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertEquals(2.0, graph.getMeanEdge(), 0.001);
	
	}
	
	/**
	 * Testa a corretude em casos de grafos que são desconexos
	 */
	@Test
	public void testGrafoDesconexo() {
		Integer[] verticesOrigem = new Integer[] {1, 3};
		Integer[] verticesDestino = new Integer[] {2, 4};
		Graph graph = new Graph(4, verticesOrigem, verticesDestino);
		
		assertEquals(1.0, graph.getMeanEdge(), 0.001);
	}
	
	/**
	 * Verifica se a função funciona também para grafos com pesos.
	 */
	@Test
	public void testGrafoComPeso() {
		Integer[] verticesOrigem = new Integer[] {1};
		Integer[] verticesDestino = new Integer[] {2};
		Double[] arrayPesos = new Double[] {1.0, -2.5};
		WeightedGraph graph = new WeightedGraph(2, verticesOrigem, verticesDestino, arrayPesos);
				
		assertEquals(1.0, graph.getMeanEdge(), 0.001);
	
	}
	
}

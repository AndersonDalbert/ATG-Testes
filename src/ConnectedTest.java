
import static org.junit.Assert.*;

import org.junit.Test;

import graph.Graph;

/**
 * Essa classe de testes testa o método connected() da biblioteca.
 * 
 * @author Anderson Dalbert
 *
 */
public class ConnectedTest {


	@Test
	public void testGrafoCaminho() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {2, 3};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}
	
	@Test
	public void testGrafoCompleto() {
		Integer[] verticesOrigem = new Integer[] {1, 1, 2, 2, 3, 3};
		Integer[] verticesDestino = new Integer[] {2, 3, 1, 3, 1, 2};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}

	@Test
	public void testGrafoCiclo() {
		Integer[] verticesOrigem = new Integer[] {1, 2, 3};
		Integer[] verticesDestino = new Integer[] {2, 3, 1};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}
	
	@Test
	public void testGrafoComUmVertice() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		Graph graph = new Graph(1, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}
	
	@Test
	public void testGrafoComLoop() {
		Integer[] verticesOrigem = new Integer[] {1};
		Integer[] verticesDestino = new Integer[] {1};
		Graph graph = new Graph(1, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}
	
	/**
	 * Um grafo nulo deve ser considerado conexo, pois só seria desconexo caso existissem vértices que não e
	 */
	@Test
	public void testGrafoNulo() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		Graph graph = new Graph(0, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}
	
	
	/**
	 * Um grafo vazio com mais de um vértice deve ser desconexo, pois por definição não possui arestas.
	 */
	@Test
	public void testGrafoVazio() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertFalse(graph.connected());
	}
	
	/**
	 * Um grafo com k vertices precisa ter ao menos k-1 arestas para poder ser
	 * um candidato a grafo conexo. Esse teste considera um grafo que não possui
	 * sequer esse número mínimo de arestas.
	 */
	@Test
	public void testGrafoDesconexoComQtdInsuficienteDeArestas() {
		Integer[] verticesOrigem = new Integer[] {1};
		Integer[] verticesDestino = new Integer[] {2};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertFalse(graph.connected());
	}
	
	/**
	 * Esse teste considera um grafo que possui a quantidade mínima de arestas
	 * para ser um grafo conexo, mas que mesmo assim não satisfaz a condição de conexidade
	 * por ter um vértice soltos.
	 */
	@Test
	public void testGrafoDesconexoComQtdSuficienteDeArestas() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {2, 1};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertFalse(graph.connected());
	}
	

}

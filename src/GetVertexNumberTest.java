
import static org.junit.Assert.*;

import org.junit.Test;

import graph.Graph;
import graph.WeightedGraph;

/**
 * Essa classe de testes verifica a corretude do método getQtdVertices(), equivalente
 * ao solicitado "getVertexNumber" mas com nomenclatura em português, por escolha do grupo
 * sendo avaliado.
 * Nota sugerida: 10 - passa em todos os testes
 * 
 * @author Anderson Dalbert
 *
 */
public class GetVertexNumberTest {

	/**
	 * Testa a quantidade de vértices de um grafo sem vértices, que deve ser zero.
	 */
	@Test
	public void testGrafoNulo() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		Graph graph = new Graph(0, verticesOrigem, verticesDestino);
		
		assertEquals(0, graph.getQtdVertices());
	}
	
	/**
	 * Testa a quantidade de vértices de um grafo com um vértice, que deve ser um.
	 */
	@Test
	public void testGrafoComUmVertice() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		Graph graph = new Graph(1, verticesOrigem, verticesDestino);
		
		assertEquals(1, graph.getQtdVertices());
	}
	
	/**
	 * A quantidade de vértices deve ser independente do número de arestas, logo,
	 * testamos um grafo vazio.
	 */
	@Test
	public void testGrafoVazio() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		
		Graph graph = new Graph(5, verticesOrigem, verticesDestino);
		
		assertEquals(5, graph.getQtdVertices());
	}
	
	/**
	 * Utiliza um grafo com o maior inteiro positivo possível e verifica se a qtd de vértices
	 * é igual.
	 */
	@Test
	public void testGrafoComMuitosVertices() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		
		Graph graph = new Graph(2147483647, verticesOrigem, verticesDestino);
		
		assertEquals(2147483647, graph.getQtdVertices());
	}
	
	/**
	 * A quantidade de vértices (v) deve ser maior que a quantidade de arestas (a), 
	 * mesmo quando v > a.
	 */
	@Test
	public void testGrafoComMaisVerticesQueArestas() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {1, 3};
		
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertEquals(3, graph.getQtdVertices());
	}
	
	/**
	 * A quantidade de vértices (v) deve ser maior que a quantidade de arestas (a), 
	 * mesmo quando v < a.
	 */
	@Test
	public void testGrafoComMaisArestasQueVertices() {
		Integer[] verticesOrigem = new Integer[] {1, 2, 1};
		Integer[] verticesDestino = new Integer[] {1, 2, 1};
		
		Graph graph = new Graph(2, verticesOrigem, verticesDestino);
		
		assertEquals(2, graph.getQtdVertices());
	}
	
	/**
	 * A quantidade de vértices (v) deve ser maior que a quantidade de arestas (a), 
	 * mesmo quando v = a.
	 */
	@Test
	public void testGrafoComMesmaQtdDeArestasEVertices() {
		Integer[] verticesOrigem = new Integer[] {1, 2, 3};
		Integer[] verticesDestino = new Integer[] {2, 3, 1};
		
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertEquals(3, graph.getQtdVertices());
	}
	
	/**
	 * Vértices de grafos com pesos devem ser contabilizados da mesma forma que grafos normais
	 */
	@Test
	public void testGrafoComPesos() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {2, 3};
		Double[] arrayPesos = new Double[] {-1.0, -2.5};
		WeightedGraph graph = new WeightedGraph(3, verticesOrigem, verticesDestino, arrayPesos);
				
		assertEquals(3, graph.getQtdVertices());
	}
}

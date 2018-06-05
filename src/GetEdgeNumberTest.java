
import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;

import graph.Graph;
import graph.WeightedGraph;

/**
 * Classe de testes para verificar a corretude do método getEdgeNumberTest (ou getQtdArestas,
 * de acordo com a escolha do grupo). 
 * Nota sugerida: 10 - funciona para todos os casos de teste
 * 
 * @author Anderson Dalbert
 * 
 *
 */
public class GetEdgeNumberTest {

	/**
	 * Testa a quantidade de arestas de um grafo sem arestas e com um vértice, que deve 
	 * ser zero.
	 */
	@Test
	public void testGrafoSemArestasComVertice() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		Graph graph = new Graph(1, verticesOrigem, verticesDestino);
		
		assertEquals(0, graph.getQtdArestas());
	}
	
	/**
	 * Testa a quantidade de arestas de um grafo sem arestas e sem vértices, que deve 
	 * ser zero.
	 */
	@Test
	public void testGrafoSemArestasSemVertice() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		Graph graph = new Graph(0, verticesOrigem, verticesDestino);
		
		assertEquals(0, graph.getQtdArestas());
	}
	
	/**
	 * Verifica se a quantidade de arestas de um grafo caminho é válida.
	 */
	@Test
	public void testGrafoCaminho() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {2, 3};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertEquals(2, graph.getQtdArestas());
	}
	
	/**
	 * Verifica se a quantidade de arestas de um grafo com loop é válida.
	 */
	@Test
	public void testGrafoComLoop() {
		Integer[] verticesOrigem = new Integer[] {1};
		Integer[] verticesDestino = new Integer[] {1};
		Graph graph = new Graph(1, verticesOrigem, verticesDestino);
		
		assertEquals(1, graph.getQtdArestas());
	}
	
	/**
	 * Verifica se a quantidade de arestas de um grafo com arestas paralelas é válida.
	 */
	@Test
	public void testGrafoComArestasParalelas() {
		Integer[] verticesOrigem = new Integer[] {1, 2, 3};
		Integer[] verticesDestino = new Integer[] {2, 1, 2};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertEquals(3, graph.getQtdArestas());
	}
	
	/**
	 * Verifica se a quantidade de arestas de um grafo desconexo é válida.
	 */
	@Test
	public void testGrafoDesconexo() {
		Integer[] verticesOrigem = new Integer[] {1, 3};
		Integer[] verticesDestino = new Integer[] {2, 4};
		Graph graph = new Graph(4, verticesOrigem, verticesDestino);
		
		assertEquals(2, graph.getQtdArestas());
	}
	
	/**
	 * Verifica se a quantidade de arestas de um grafo com 2 ^ 7 arestas é válida.
	 */
	@Test
	public void testGrafoComMuitasArestas() {
		int[] arrayOrigem = IntStream.rangeClosed(1, 10000000).toArray();
		Integer[] verticesOrigem = IntStream.of( arrayOrigem ).boxed().toArray( Integer[]::new );
		
		int[] arrayDestino = IntStream.rangeClosed(2, 10000001).toArray();
		Integer[] verticesDestino = IntStream.of( arrayDestino ).boxed().toArray( Integer[]::new );
		
		Graph graph = new Graph(10000000, verticesOrigem, verticesDestino);
		
		
		assertEquals(10000000, graph.getQtdArestas());
	}
	
	/**
	 * Verifica se a quantidade de arestas de um grafo com 2 ^ 7 arestas é válida.
	 */
	@Test
	public void testGrafoComPesos() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {2, 3};
		Double[] arrayPesos = new Double[] {-1.0, -2.5};
		WeightedGraph graph = new WeightedGraph(3, verticesOrigem, verticesDestino, arrayPesos);
		
		
		assertEquals(2, graph.getQtdArestas());
	}
	
	
	
}

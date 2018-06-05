
import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;

import graph.Graph;
import graph.WeightedGraph;

/**
 * Essa classe de testes verifica a corretude do método connected() da biblioteca do grupo
 * que está sendo avaliado.
 * Nota sugerida: 4 - Falha em todos os testes de grafos desconexos e falha para entradas grandes
 * de grafos conexos.
 * @author Anderson Dalbert
 *
 */
public class ConnectedTest {


	/**
	 * Um grafo caminho deve ser conexo
	 */
	@Test
	public void testGrafoCaminho() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {2, 3};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}
	
	/**
	 * Um grafo completo deve ser conexo
	 */
	@Test
	public void testGrafoCompleto() {
		Integer[] verticesOrigem = new Integer[] {1, 1, 2, 2, 3, 3};
		Integer[] verticesDestino = new Integer[] {2, 3, 1, 3, 1, 2};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}

	/**
	 * Um grafo ciclo deve ser conexo
	 */
	@Test
	public void testGrafoCiclo() {
		Integer[] verticesOrigem = new Integer[] {1, 2, 3};
		Integer[] verticesDestino = new Integer[] {2, 3, 1};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}
	
	/**
	 * Se o grafo tem apenas um vértice ele é conexo, pois não se pode encontrar
	 * um contra-exemplo para a regra de conexidade.
	 */
	@Test
	public void testGrafoComUmVertice() {
		Integer[] verticesOrigem = new Integer[] {};
		Integer[] verticesDestino = new Integer[] {};
		Graph graph = new Graph(1, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}
	
	/**
	 * Um grafo k-1 com loop também é conexo
	 */
	@Test
	public void testGrafComUmVerticeoComLoop() {
		Integer[] verticesOrigem = new Integer[] {1};
		Integer[] verticesDestino = new Integer[] {1};
		Graph graph = new Graph(1, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}

	/**
	 * Um grafo com n vértices com loop também é conexo
	 */
	@Test
	public void testGrafComMaisDeUmVerticeoComLoop() {
		Integer[] verticesOrigem = new Integer[] {1, 2, 3};
		Integer[] verticesDestino = new Integer[] {2, 3, 3};
		Graph graph = new Graph(3, verticesOrigem, verticesDestino);
		
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
	
	/**
	 * Esse teste considera um grafo com pesos simples e verifica sua conexidade.
	 */
	@Test
	public void testGrafoComPesos() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {2, 3};
		Double[] arrayPesos = new Double[] {1.0, 2.5};
		WeightedGraph graph = new WeightedGraph(3, verticesOrigem, verticesDestino, arrayPesos);
		
		assertTrue(graph.connected());
	}
	
	/**
	 * Esse teste considera um grafo com pesos simples e verifica sua não-conexidade.
	 */
	@Test
	public void testGrafoDesconexoComPesos() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {2, 3};
		Double[] arrayPesos = new Double[] {1.0, 2.5};
		WeightedGraph graph = new WeightedGraph(4, verticesOrigem, verticesDestino, arrayPesos);
		
		assertFalse(graph.connected());
	}
	
	/**
	 * Esse teste considera um grafo com pesos simples, incluindo pesos negativos, e verifica sua 
	 * conexidade.
	 */
	@Test
	public void testGrafoComPesosNegativos() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {2, 3};
		Double[] arrayPesos = new Double[] {-1.0, -2.5};
		WeightedGraph graph = new WeightedGraph(3, verticesOrigem, verticesDestino, arrayPesos);
		
		assertTrue(graph.connected());
	}
	
	/**
	 * Esse teste considera um grafo com pesos simples, incluindo pesos negativos, e verifica sua 
	 * não-conexidade.
	 */
	@Test
	public void testGrafoDesconexoComPesosNegativos() {
		Integer[] verticesOrigem = new Integer[] {1, 2};
		Integer[] verticesDestino = new Integer[] {2, 3};
		Double[] arrayPesos = new Double[] {-1.0, -2.5};
		WeightedGraph graph = new WeightedGraph(4, verticesOrigem, verticesDestino, arrayPesos);
		
		assertFalse(graph.connected());
	}
	
	
	
	
	/**
	 * Popula um grafo com 1000 vértices que é conexo e verifica se a função permanece correta
	 * para esse caso.
	 */
	@Test
	public void testGrafoGrande() {
		int[] arrayOrigem = IntStream.rangeClosed(1, 1000).toArray();
		Integer[] verticesOrigem = IntStream.of( arrayOrigem ).boxed().toArray( Integer[]::new );
		
		int[] arrayDestino = IntStream.rangeClosed(2, 1000).toArray();
		Integer[] verticesDestino = IntStream.of( arrayDestino ).boxed().toArray( Integer[]::new );
		
		Graph graph = new Graph(1000, verticesOrigem, verticesDestino);
		
		assertTrue(graph.connected());
	}
	
	/**
	 * Popula um grafo com 1000 vértices que é desconexo e verifica se a função permanece correta
	 * para esse caso.
	 */
	@Test
	public void testGrafoDesconexoGrande() {
		int[] arrayOrigem = IntStream.rangeClosed(1, 1000).toArray();
		Integer[] verticesOrigem = IntStream.of( arrayOrigem ).boxed().toArray( Integer[]::new );
		
		int[] arrayDestino = IntStream.rangeClosed(2, 1000).toArray();
		Integer[] verticesDestino = IntStream.of( arrayDestino ).boxed().toArray( Integer[]::new );
		
		Graph graph = new Graph(1001, verticesOrigem, verticesDestino);
		
		assertFalse(graph.connected());
	}
	
	/**
	 * Popula um grafo com 10 ** 7 vértices que é conexo e verifica se a função permanece correta
	 * para esse caso.
	 */
	@Test
	public void testGrafoGigante() {
		int[] arrayOrigem = IntStream.rangeClosed(1, 10000000).toArray();
		Integer[] verticesOrigem = IntStream.of( arrayOrigem ).boxed().toArray( Integer[]::new );
		
		int[] arrayDestino = IntStream.rangeClosed(2, 10000000).toArray();
		Integer[] verticesDestino = IntStream.of( arrayDestino ).boxed().toArray( Integer[]::new );
		
		Graph graph = new Graph(10000000, verticesOrigem, verticesDestino);
		
		assertFalse(graph.connected());
	}
	
	/**
	 * Popula um grafo com 10 ** 7 vértices que é desconexo e verifica se a função permanece correta
	 * para esse caso.
	 */
	@Test
	public void testGrafoDesconexoGigante() {
		int[] arrayOrigem = IntStream.rangeClosed(1, 10000000).toArray();
		Integer[] verticesOrigem = IntStream.of( arrayOrigem ).boxed().toArray( Integer[]::new );
		
		int[] arrayDestino = IntStream.rangeClosed(2, 10000000).toArray();
		Integer[] verticesDestino = IntStream.of( arrayDestino ).boxed().toArray( Integer[]::new );
		
		Graph graph = new Graph(10000001, verticesOrigem, verticesDestino);
		
		assertFalse(graph.connected());
	}
	
	
}

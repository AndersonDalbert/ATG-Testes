import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;
import graph.Graph;

/**
 * Classe de testes do método DFS. 
 * 
 * @author matheusar
 *
 */
public class DFSTest {

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDFSGrafoTrivial() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1 };
		Graph g1 = new Graph(1, verticesOrigem, null);
		Assert.assertEquals(g1.DFS(1), ("1"));

	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDFSGrafoSimples() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1 };
		Integer[] verticesDestino = new Integer[] { 2 };
		Graph g1 = new Graph(2, verticesOrigem, verticesDestino);
		Assert.assertEquals(g1.DFS(1), ("2 1"));

	}

	/**
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDFSGrafoBifurcado() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1, 2, 3, 4, 4 };
		Integer[] verticesDestino = new Integer[] { 2, 3, 4, 5, 6 };
		Graph g = new Graph(6, verticesOrigem, verticesDestino);
		Assert.assertEquals(g.DFS(1),
				("6 5 4 3 2 1"));
	}

	/**
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDFSGrafoEstrela() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1, 1, 1, 1 };
		Integer[] verticesDestino = new Integer[] { 2, 3, 4, 5 };
		Graph g = new Graph(5, verticesOrigem, verticesDestino);
		Assert.assertEquals(g.DFS(1), ("5 4 3 2 1"));
	}

	/**
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDFSGrafoDesconexo() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1, 4 };
		Integer[] verticesDestino = new Integer[] { 2, 6 };
		Graph g = new Graph(5, verticesOrigem, verticesDestino);
		Assert.assertEquals(g.DFS(1), ("2 1"));

	}

}

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import graph.Graph;

public class GraphRepresentationTest {


	/**
	 * Teste para representação por matriz de adjacência
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRepresentacaoAM() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1, 2, 3, 4, 4, 5 };
		
		Integer[] verticesDestino = new Integer[] { 2, 4, 4, 3, 1, 2 };
		Integer[] verticesDestino2 = new Integer[] { 2, 4, 4, 3, 1, 3 };
		
		Integer[] verticesDestino3 = new Integer[] { 2, 4, 4, 3, 1, 4 };
		Graph g1 = new Graph(5, verticesOrigem, verticesDestino);
		Graph g2 = new Graph(5, verticesOrigem, verticesDestino2);
		Graph g3 = new Graph(5, verticesOrigem, verticesDestino3);
		
		
		Assert.assertEquals(g1.graphRepresentationAM(), ("  1 2 3 4 5 \n" +
                "1 0 1 0 1 0 \n" +
                "2 1 0 0 1 1 \n" +
                "3 0 0 0 1 0 \n" +
                "4 1 1 1 0 0 \n" +
                "5 0 1 0 0 0 "));

		Assert.assertEquals(g1.graphRepresentationAM(), ("  1 2 3 4 5 \n" +
                "1 0 1 0 1 0 \n" +
                "2 1 0 0 1 1 \n" +
                "3 0 0 0 1 0 \n" +
                "4 1 1 1 0 0 \n" +
                "5 0 1 0 0 0 "));
		
		
		Assert.assertEquals(g2.graphRepresentationAM(), ("  "
				+ "1 2 3 4 5 \n" +
                "1 0 1 0 1 0 \n" +
                "2 1 0 0 1 1 \n" +
                "3 0 0 0 1 0 \n" +
                "4 1 1 1 0 0 \n" +
                "5 0 0 1 0 0 "));
		Assert.assertEquals(g2.graphRepresentationAL(), ("  "
				+ "1 2 3 4 5 \n" +
                "1 0 1 0 1 0 \n" +
                "2 1 0 0 1 1 \n" +
                "3 0 0 0 1 0 \n" +
                "4 1 1 1 0 0 \n" +
                "5 0 0 1 0 0 "));
		Assert.assertEquals(g3.graphRepresentationAM(), ("  1 2 3 4 5 \n" +
                "1 0 1 0 1 0 \n" +
                "2 1 0 0 1 1 \n" +
                "3 0 0 0 1 0 \n" +
                "4 1 1 1 0 0 \n" +
                "5 0 0 0 1 0 "));
	}
	/**
	 * Teste para representação por lista de adjacência
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRepresentacaoAL() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1, 2, 3, 4, 5 };
		Integer[] verticesDestino = new Integer[] { 2, 4, 4, 1, 2 };
		Integer[] verticesDestino2 = new Integer[] { 2, 4, 4, 1, 3 };
		Graph g1 = new Graph(5, verticesOrigem, verticesDestino);
		Graph g2 = new Graph(5, verticesOrigem, verticesDestino2);
		Assert.assertEquals(g1.graphRepresentationAL(), ("\n1 - 2 4\n" +
                "2 - 1 4 5\n" +
                "3 - 4\n" +
                "4 - 1 2 3\n" +
                "5 - 2"));
		Assert.assertEquals(g2.graphRepresentationAL(), ("\n1 - 2 4\n" +
                "2 - 1 4 5\n" +
                "3 - 4\n" +
                "4 - 1 2 3\n" +
                "5 - 3"));

	}
}
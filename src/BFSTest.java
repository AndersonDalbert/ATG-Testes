import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;
import graph.Graph;

/**
 * Classe de testes do método BFS. O método implementado apresentou alguns
 * problemas quanto a filiação dos nós. Ao que parece, o método interpreta a BFS
 * como sendo de uma árvore binária, e não como sendo em um grafo que pode ter
 * multiplos filhos. Esses erros verificam-se ao criar um grafo de topologia
 * estrela, por exemplo.
 * 
 * @author matheusar
 *
 */
public class BFSTest {

	/**
	 * Grafo trivial não é criado.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBFSGrafoTrivial() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1 };
		Graph g1 = new Graph(1, verticesOrigem, null);
		Assert.assertEquals(g1.BFS(1), ("1 - 0 -\n"));

	}
	
	/**
	 * Testa um grafo simples com 2 vertices
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBFSGrafoSimples() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1 };
		Integer[] verticesDestino = new Integer[] { 2 };
		Graph g1 = new Graph(2, verticesOrigem, verticesDestino);
		Assert.assertEquals(g1.BFS(1), ("1 - 0 -\n2 - 1 1\n"));

	}

	/**
	 * 
	 * Grafos com bifurcações também não apresentaram comportamento esperado.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBFSGrafoBifurcado() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1, 2, 3, 4, 4 };
		Integer[] verticesDestino = new Integer[] { 2, 3, 4, 5, 6 };
		Graph g = new Graph(6, verticesOrigem, verticesDestino);
		Assert.assertEquals(g.BFS(1),
				("1 - 0 -\n" + "2 - 1 1\n" + "3 - 2 2\n" + "4 - 3 3\n" + "5 - 4 4\n" + "6 - 4 4\n"));
	}

	/**
	 * todos os vertices filhos deveriam ter como pai o 1 e serem todos de nivel 1,
	 * já que a topologia é estrela. Mas isto não se verifica na BFS implementada.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBFSGrafoEstrela() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1, 1, 1, 1 };
		Integer[] verticesDestino = new Integer[] { 2, 3, 4, 5 };
		Graph g = new Graph(5, verticesOrigem, verticesDestino);
		Assert.assertEquals(g.BFS(1), ("1 - 0 -\n" + "2 - 1 1\n" + "3 - 1 1\n" + "4 - 1 1\n" + "5 - 1 1\n"));
	}

	/**
	 * BFS do Grafo desconexo não é criada.A BFS deveria ser apresentada(mas já que os vertices 4 e 6 não podem ser
	 * acessados por nenhum caminho, logo, não deveriam estar presentes na BFS).
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBFSGrafoDesconexo() throws Exception {
		Integer[] verticesOrigem = new Integer[] { 1, 4 };
		Integer[] verticesDestino = new Integer[] { 2, 6 };
		Graph g = new Graph(5, verticesOrigem, verticesDestino);
		Assert.assertEquals(g.BFS(1), ("1 - 0 -\n" + "2 - 1 1\n"));

	}

}

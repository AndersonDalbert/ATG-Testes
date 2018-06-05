import static org.junit.Assert.*;

import org.junit.Test;

import controller.Controller;
import graph.Graph;

public class MstTest {

	@Test
    public void testMst() {

		Controller ctrl;
		Graph g;
        try {

            ctrl = new Controller();
            g = ctrl.readGraph("testReadGraph.txt");
            
        } catch (Exception e) {
            fail();
        }

        //o metodo Mst não existe e não pode ser inicializado
    }
	
	

}

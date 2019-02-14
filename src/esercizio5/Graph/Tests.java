package Graph;

import org.junit.Before;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertTrue;

public class Tests {
    private static final Charset ENCODING = StandardCharsets.UTF_8;
    private DirectedGraph grafo1;
    private UndirectedGraph grafo2;

    @Before
    public void create() throws Exception {
        grafo1 = new DirectedGraph();
        grafo2 = new UndirectedGraph();
    }

    @Test
    public void testAddVertex() {
        grafo1.addVertex(1);
        grafo1.addVertex(2);
        grafo1.addVertex(3);
        assertTrue(grafo1.getAdjacencyList().containsKey(1)
                && grafo1.getAdjacencyList().containsKey(2)
                && grafo1.getAdjacencyList().containsKey(3));
    }

    @Test
    public void testAddEdgeDirectedGraph() {
        grafo1.addVertex(1);
        grafo1.addVertex(2);
        grafo1.addEdge(1, 2, 3.0);
        assertTrue(grafo1.containsEdge(1, 2)
                && grafo1.weight() == 3.0);
    }

    @Test
    public void testAddEdgeUndirectedGraph() {
        grafo2.addVertex(1);
        grafo2.addVertex(2);
        grafo2.addEdge(1, 2, 5.0);
        assertTrue(grafo2.containsEdge(1, 2)
                && grafo2.containsEdge(2, 1)
                && grafo2.weight() == 5.0);
    }

    @Test
    public void testMSTKruskal() {
        grafo2.addVertex(1);
        grafo2.addVertex(2);
        grafo2.addVertex(3);
        grafo2.addEdge(1, 2, 5.0);
        grafo2.addEdge(3, 2, 5.0);
        grafo2.addEdge(1, 3, 5.0);
        MSTKruskal<Integer> kruskal = new MSTKruskal<Integer>(grafo2);
        assertTrue(kruskal.getWeight() == 10.0);
    }


}


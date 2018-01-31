package luke.nai.project.astar;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author LukaszDrapala
 */
public class DataFromInternet2Test {

    private final Node<String> gd = new Node("Gd", 546);
    private final Node<String> sz = new Node("Sz", 600);
    private final Node<String> ol = new Node("Ol", 468);
    private final Node<String> by = new Node("By", 408);
    private final Node<String> wa = new Node("Wa", 282);
    private final Node<String> bi = new Node("Bi", 470);
    private final Node<String> po = new Node("Po", 378);
    private final Node<String> zg = new Node("Zg", 409);
    private final Node<String> lo = new Node("Lo", 217);
    private final Node<String> wr = new Node("Wr", 254);
    private final Node<String> lu = new Node("Lu", 259);
    private final Node<String> ki = new Node("Ki", 115);
    private final Node<String> ka = new Node("Ka", 75);
    private final Node<String> kr = new Node("Kr", 0);

    @Test
    public void dataFromInternet() throws Exception {

        Graph<String> graph = new Graph<>();
        graph.addEdge(new Edge(gd, sz, 362));
        graph.addEdge(new Edge(gd, by, 165));
        graph.addEdge(new Edge(gd, ol, 170));
        graph.addEdge(new Edge(ol, wa, 212));
        graph.addEdge(new Edge(by, wa, 270));
        graph.addEdge(new Edge(by, lo, 227));
        graph.addEdge(new Edge(sz, po, 235));
        graph.addEdge(new Edge(sz, zg, 217));
        graph.addEdge(new Edge(po, zg, 152));
        graph.addEdge(new Edge(po, wr, 186));
        graph.addEdge(new Edge(po, lo, 203));
        graph.addEdge(new Edge(wa, bi, 470));
        graph.addEdge(new Edge(wa, lu, 166));
        graph.addEdge(new Edge(wa, ki, 178));
        graph.addEdge(new Edge(wa, lo, 137));
        graph.addEdge(new Edge(lo, wr, 209));
        graph.addEdge(new Edge(wr, ka, 195));
        graph.addEdge(new Edge(lo, ka, 193));
        graph.addEdge(new Edge(ka, kr, 80));
        graph.addEdge(new Edge(ki, kr, 116));
        AStarAlgorithm<String> aStarAlgorithm = new AStarAlgorithm<>(graph, gd, kr);
        Path result = aStarAlgorithm.execute();
        Path expected = getExpected();
        Assert.assertEquals(result, expected);
    }

    private Path getExpected() {
        Path path = new Path(gd, new Graph<>());
        path.addNode(by);
        path.addNode(lo);
        path.addNode(ka);
        path.addNode(kr);
        return path;
    }

}

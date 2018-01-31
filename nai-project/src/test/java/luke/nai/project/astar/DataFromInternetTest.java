package luke.nai.project.astar;


import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author LukaszDrapala
 */
public class DataFromInternetTest {

    private final Node arad = new Node("Arad", 366);
    private final Node zerind = new Node("Zerind", 374);
    private final Node oradea = new Node("Oradea", 380);
    private final Node sibiu = new Node("Sibiu", 253);
    private final Node fagaras = new Node("Fagaras", 178);
    private final Node rimnicu = new Node("Rimnicu Vilcea", 193);
    private final Node pitesti = new Node("Pitesti", 98);
    private final Node timisoara = new Node("Timisoara", 329);
    private final Node lugoj = new Node("Lugoj", 244);
    private final Node mehadia = new Node("Mehadia", 241);
    private final Node drobeta = new Node("Drobeta", 242);
    private final Node craiova = new Node("Craiova", 160);
    private final Node bucharest = new Node("Bucharest", 0);
    private final Node giurgiu = new Node("Giurgiu", 77);

    @Test
    public void dataFromInternet() throws Exception {
        Graph<String> graph = new Graph<>();
        graph.addEdge(new Edge<>(arad, zerind, 75));
        graph.addEdge(new Edge<>(arad, sibiu, 140));
        graph.addEdge(new Edge<>(arad, timisoara, 118));
        graph.addEdge(new Edge<>(zerind, arad, 75));
        graph.addEdge(new Edge<>(oradea, zerind, 71));
        graph.addEdge(new Edge<>(oradea, sibiu, 151));
        graph.addEdge(new Edge<>(sibiu, fagaras, 99));
        graph.addEdge(new Edge<>(sibiu, rimnicu, 80));
        graph.addEdge(new Edge<>(fagaras, bucharest, 211));
        graph.addEdge(new Edge<>(rimnicu, pitesti, 97));
        graph.addEdge(new Edge<>(rimnicu, craiova, 146));
        graph.addEdge(new Edge<>(pitesti, bucharest, 101));
        graph.addEdge(new Edge<>(pitesti, craiova, 138));
        graph.addEdge(new Edge<>(timisoara, lugoj, 111));
        graph.addEdge(new Edge<>(lugoj, mehadia, 70));
        graph.addEdge(new Edge<>(mehadia, drobeta, 75));
        graph.addEdge(new Edge<>(drobeta, craiova, 120));
        graph.addEdge(new Edge<>(bucharest, giurgiu, 90));
        AStarAlgorithm<String> aStarAlgorithm = new AStarAlgorithm<>(graph, arad, bucharest);
        Path result = aStarAlgorithm.execute();
        Path expected = getExpected();
        Assert.assertEquals(result, expected);
    }

    private Path getExpected() {
        Path path = new Path(arad, new Graph<>());
        path.addNode(sibiu);
        path.addNode(rimnicu);
        path.addNode(pitesti);
        path.addNode(bucharest);
        return path;
    }

}

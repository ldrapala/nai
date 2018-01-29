package luke.nai.project.astar;

/**
 *
 * @author LukaszDrapala
 */
public class Test {

//    public static void main(String[] args) throws Exception {
//        Graph<String> graph = new Graph<>();
//        Node<String> gd = new Node("Gd", 546);
//        Node<String> sz = new Node("Sz", 600);
//        Node<String> ol = new Node("Ol", 468);
//        Node<String> by = new Node("By", 408);
//        Node<String> wa = new Node("Wa", 282);
//        Node<String> bi = new Node("Bi", 470);
//        Node<String> po = new Node("Po", 378);
//        Node<String> zg = new Node("Zg", 409);
//        Node<String> lo = new Node("Lo", 217);
//        Node<String> wr = new Node("Wr", 254);
//        Node<String> lu = new Node("Lu", 259);
//        Node<String> ki = new Node("Ki", 115);
//        Node<String> ka = new Node("Ka", 75);
//        Node<String> kr = new Node("Kr", 0);
//        graph.addEdge(new Edge(gd, sz, 362));
//        graph.addEdge(new Edge(gd, by, 165));
//        graph.addEdge(new Edge(gd, ol, 170));
//        graph.addEdge(new Edge(ol, wa, 212));
//        graph.addEdge(new Edge(by, wa, 270));
//        graph.addEdge(new Edge(by, lo, 227));
//        graph.addEdge(new Edge(sz, po, 235));
//        graph.addEdge(new Edge(sz, zg, 217));
//        graph.addEdge(new Edge(po, zg, 152));
//        graph.addEdge(new Edge(po, wr, 186));
//        graph.addEdge(new Edge(po, lo, 203));
//        graph.addEdge(new Edge(wa, bi, 470));
//        graph.addEdge(new Edge(wa, lu, 166));
//        graph.addEdge(new Edge(wa, ki, 178));
//        graph.addEdge(new Edge(wa, lo, 137));
//        graph.addEdge(new Edge(lo, wr, 209));
//        graph.addEdge(new Edge(wr, ka, 195));
//        graph.addEdge(new Edge(lo, ka, 193));
//        graph.addEdge(new Edge(ka, kr, 80));
//        graph.addEdge(new Edge(ki, kr, 116));
//        AStarAlgorithm<String> aStarAlgorithm = new AStarAlgorithm<>(graph, gd, kr);
//        Path path = aStarAlgorithm.execute();
//        System.out.println("PATH: "+path);
//    }
    public static void main(String[] args) throws Exception {
        Graph<String> graph = new Graph<>();
        Node n1 = new Node("Arad", 366);
        Node n2 = new Node("Zerind", 374);
        Node n3 = new Node("Oradea", 380);
        Node n4 = new Node("Sibiu", 253);
        Node n5 = new Node("Fagaras", 178);
        Node n6 = new Node("Rimnicu Vilcea", 193);
        Node n7 = new Node("Pitesti", 98);
        Node n8 = new Node("Timisoara", 329);
        Node n9 = new Node("Lugoj", 244);
        Node n10 = new Node("Mehadia", 241);
        Node n11 = new Node("Drobeta", 242);
        Node n12 = new Node("Craiova", 160);
        Node n13 = new Node("Bucharest", 0);
        Node n14 = new Node("Giurgiu", 77);
        graph.addEdge(new Edge<>(n1, n2, 75));
        graph.addEdge(new Edge<>(n1, n4, 140));
        graph.addEdge(new Edge<>(n1, n8, 118));
        graph.addEdge(new Edge<>(n2, n1, 75));
        graph.addEdge(new Edge<>(n3, n2, 71));
        graph.addEdge(new Edge<>(n3, n4, 151));
        graph.addEdge(new Edge<>(n4, n5, 99));
        graph.addEdge(new Edge<>(n4, n6, 80));
        graph.addEdge(new Edge<>(n5, n13, 211));
        graph.addEdge(new Edge<>(n6, n7, 97));
        graph.addEdge(new Edge<>(n6, n12, 146));
        graph.addEdge(new Edge<>(n7, n13, 101));
        graph.addEdge(new Edge<>(n7, n12, 138));
        graph.addEdge(new Edge<>(n8, n9, 111));
        graph.addEdge(new Edge<>(n9, n10, 70));
        graph.addEdge(new Edge<>(n10, n11, 75));
        graph.addEdge(new Edge<>(n11, n12, 120));
        graph.addEdge(new Edge<>(n13, n14, 90));
        AStarAlgorithm<String> aStarAlgorithm = new AStarAlgorithm<>(graph, n1, n13);
        Path execute = aStarAlgorithm.execute();
        System.out.println("Path:" + execute);
    }
}

package GraphUsage;

import Graph.MSTKruskal;
import Graph.UndirectedGraph;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GraphUsage {
    private static final Charset ENCODING = StandardCharsets.UTF_8;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) throw new Exception("Please enter file path.");
        else System.out.println("Reading from: " + args[0]);
        UndirectedGraph grafo = new UndirectedGraph();
        System.out.println("Working on dataset...");
        loadGraph(args[0], grafo);
        MSTKruskal kruskal = new MSTKruskal(grafo);
        infoGraph(grafo, kruskal);
    }

    public static void loadGraph(String filepath, UndirectedGraph grafo) throws Exception {
        System.out.println("LOADING DATA FROM FILE...");
        Path inputFilePath = Paths.get(filepath);
        BufferedReader fileInputReader = Files.newBufferedReader(inputFilePath, ENCODING);
        String line = null;
        String[] lineElements = new String[3];
        while ((line = fileInputReader.readLine()) != null) {
            lineElements = line.split(",");
            grafo.addVertex(lineElements[0]);
            grafo.addVertex(lineElements[1]);
            grafo.addEdge(lineElements[0], lineElements[1], Double.parseDouble(lineElements[2]));
        }
    }

    public static void infoGraph(UndirectedGraph grafo, MSTKruskal kruskal) {
        System.out.println("Peso (Km): " + kruskal.getWeight() / 1000);
        System.out.println("Vertici: " + kruskal.getVertexNumber());
        System.out.println("Archi: " + kruskal.getEdgeNumber());
    }

}


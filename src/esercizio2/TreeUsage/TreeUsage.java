package TreeUsage;

import Tree.Node;
import Tree.Tree;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TreeUsage {
    private static final Charset ENCODING = StandardCharsets.UTF_8;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) throw new Exception("Please enter file path.");
        else System.out.println("Reading from: " + args[0]);
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        System.out.println("Working on dataset 1...");
        loadTree(args[0], tree1);
        infoTree(tree1);
        System.out.println();
        System.out.println("Working on dataset 2...");
        loadTree(args[1], tree2);
        infoTree(tree2);
    }

    public static void loadTree(String filepath, Tree tree) throws Exception {
        System.out.println("LOADING DATA FROM FILE...");
        Path inputFilePath = Paths.get(filepath);
        try (BufferedReader fileInputReader =
                     Files.newBufferedReader(inputFilePath, ENCODING)) {
            String line = fileInputReader.readLine();
            while (line != null) {
                String[] lineElements = line.split(",");
                if (tree.getRoot() == null)
                    tree.setRoot(new Node(lineElements[0]));
                for (int i = 1; i < lineElements.length; i++) {
                    tree.add(new Node<String>(lineElements[i]), lineElements[0]);
                }
                line = fileInputReader.readLine();
            }
        }
    }

    public static void infoTree(Tree tree) {
        System.out.println("Size: " + tree.size());
        System.out.println("Max grade: " + tree.maxGrade());
        System.out.println("Depth: " + tree.depth());
        System.out.println("Is Binary: " + tree.isBin());
    }


}

import java.util.Scanner;
import java.util.stream.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class MWST {
    public static void main(String args[]) {

        try {
            // IO
            Scanner input = new Scanner(new File(args[0]));
            PrintWriter output = new PrintWriter(new File(args[1]));
            int vertexCount = Integer.parseInt(input.nextLine());
            int edgeCount = Integer.parseInt(input.nextLine());
            Edge[] edges = new Edge[edgeCount];
            int ind = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] tokens = line.split(" ");
                if (tokens.length == 3) {
                    edges[ind] = new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Float.parseFloat(tokens[2]), ind+1);
                }
                ind++;
            }

            // Sort edges by ascending weight
            Arrays.sort(edges, (a, b) -> Float.compare(a.getWeight(), b.getWeight()));

            // Kruskal's Algorithm
            ArrayList<Edge> F = new ArrayList<Edge>();
            DisjointSet forest = new DisjointSet(vertexCount);
            for (int i = 0; i < edges.length; i++) {
                if (forest.findSet(edges[i].getVertex1() - 1) != forest.findSet(edges[i].getVertex2() - 1)) {
                    F.add(edges[i]);
                    forest.unionSet(edges[i].getVertex1() - 1, edges[i].getVertex2() - 1);
                }
            }
            
            // Formatting
            float totalWeight = 0;
            for (int i = 0; i < F.size(); i++) {
                totalWeight += F.get(i).getWeight();
                output.printf("%4d: ", F.get(i).getIndex());
                output.printf("(%d, %d) ", F.get(i).getVertex1(), F.get(i).getVertex2());
                output.printf("%.1f", F.get(i).getWeight());
                output.println();

            }
            output.printf("Total Weight = %.2f", totalWeight);
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
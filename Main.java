import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    
    public static void buildMatrix(Scanner sc, int[][] matrix){
        int col = 1;
        while(sc.hasNext()){
            int origin = sc.nextInt();
            int destiny = sc.nextInt();

            //writing the predecessors and successors in their proper lines
            matrix[origin][col] = (-1);
            matrix[destiny][col] = 1;
            
            col++;
        }
    }

    public static int maxOutDegree(int totalVertex, int totalEdges, int[][] matrix){
        //array where each position representes one vertex
        int[] vertexDegree = new int[totalVertex];

        //loop through all values ​​(columns) of each row (vertex)
        for(int line = 1; line < totalVertex; line++){
            int count = 0;
            for(int col = 1; col < totalEdges; col++){
                //checking how many edges are coming out of the vertex (line)
                if(matrix[line][col] == -1) count++;
            }
            //saving the amount of edges that are coming out of this vertex (line)
            vertexDegree[line] = count;
        }

        //check wich vertex has the most edges coming out of it
        int max = 0;
        int vertex = 1;
        for(int i = 1; i < totalVertex; i++){
            if(vertexDegree[i] > max) {
                max = vertexDegree[i];
                vertex = i;
            }
        }

        //print the results
        System.out.println("Vértice com maior grau de saída - (" + vertex + "), de grau " + max);

        return vertex;
    }
    
    public static ArrayList<Integer> successors(int vertex, int totalVertex, int totalEdges, int[][] matrix){
        ArrayList<Integer> edges = new ArrayList<>();

        for(int col = 1; col < totalEdges; col++){
            if(matrix[vertex][col] == -1){
                edges.add(col);
            }
        }

        ArrayList<Integer> successors = new ArrayList<>();
        for(int i : edges){
            for(int line = 1; line < totalVertex; line++){
                if(matrix[line][i] == 1){
                    successors.add(line);
                    break;
                }
            }
        }

        System.out.println("Lista de sucessores - " + successors.toString());

        return successors;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        //ask which file is going to be used
        System.out.println("Selecione o arquivo:");
        System.out.println("1 - 'graph-test-100.txt'");
        System.out.println("2 - 'graph-test-50000.txt'");
        int option = sc.nextInt();
        System.out.println();

        sc.close();

        //select the correct file
        if(option == 1){
            sc = new Scanner(new File("graph-test-100.txt"));

            //initialize the matrix
            int totalVertex = sc.nextInt() + 1;
            int totalEdges = sc.nextInt() + 1;
            int[][] matrix = new int[totalVertex][totalEdges];

            buildMatrix(sc, matrix);
            /*
            for(int line = 1; line < totalVertex; line++){
                for(int col = 1; col < totalEdges; col++){
                    System.out.print(matrix[line][col] + " _ ");
                }
                System.out.println();
            }
            */

            int maxOutDegreeVertex = maxOutDegree(totalVertex, totalEdges, matrix);
            successors(maxOutDegreeVertex, totalVertex, totalEdges, matrix);

            System.err.println("=============================================================================================================");

            sc.close();
        } else{
            sc = new Scanner(new File("graph-test-50000.txt"));

                //initialize the matrix
                int totalVertex = sc.nextInt() + 1;
                int totalEdges = sc.nextInt() + 1;
                int[][] matrix = new int[totalVertex][totalEdges];

                buildMatrix(sc, matrix);

                sc.close();
        } 
    }
}
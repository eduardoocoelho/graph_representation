import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Graph Representation
 * 
 * @author Eduardo O. Coelho
 */

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

        //checking wich vertex has the most edges coming out of it
        int max = 0;
        int vertex = 1;
        for(int i = 1; i < totalVertex; i++){
            if(vertexDegree[i] > max) {
                max = vertexDegree[i];
                vertex = i;
            }
        }

        //printing the results
        System.out.println("Vértice com maior grau de saída - (" + vertex + "), de grau " + max);

        return vertex;
    }
    
    public static void successors(int vertex, int totalVertex, int totalEdges, int[][] matrix){
        ArrayList<Integer> edges = new ArrayList<>();

        //loop through all values ​​(columns) of the vertex passed by parameter
        for(int col = 1; col < totalEdges; col++){
            //if the value is '-1', that matrix column is an edge of that vertex
            if(matrix[vertex][col] == -1){
                //saving every edge of the vertex 
                edges.add(col);
            }
        }

        ArrayList<Integer> successors = new ArrayList<>();
        //loop through the edges of the vertex
        for(int i : edges){
            //loop through all rows (vertex)
            for(int line = 1; line < totalVertex; line++){
                //if the row has the value '1' with the column it is a successor
                if(matrix[line][i] == 1){
                    //saving every successor
                    successors.add(line);
                    break;
                }
            }
        }

        //printing the results
        System.out.println("Lista de sucessores do vértice (" + vertex + ") - " + successors.toString());
    }

    public static int maxInDegree(int totalVertex, int totalEdges, int[][] matrix){
        //array where each position representes one vertex
        int[] vertexDegree = new int[totalVertex];

        //loop through all values ​​(columns) of each row (vertex)
        for(int line = 1; line < totalVertex; line++){
            int count = 0;
            for(int col = 1; col < totalEdges; col++){
                //checking how many edges are coming in the vertex (line)
                if(matrix[line][col] == 1) count++;
            }
            //saving the amount of edges that are coming in this vertex (line)
            vertexDegree[line] = count;
        }

        //checking wich vertex has the most edges coming in it
        int max = 0;
        int vertex = 1;
        for(int i = 1; i < totalVertex; i++){
            if(vertexDegree[i] > max) {
                max = vertexDegree[i];
                vertex = i;
            }
        }

        //printing the results
        System.out.println("Vértice com maior grau de entrada - (" + vertex + "), de grau " + max);

        return vertex;
    }

    public static void predecessors(int vertex, int totalVertex, int totalEdges, int[][] matrix){
        ArrayList<Integer> edges = new ArrayList<>();

        //loop through all values ​​(columns) of the vertex passed by parameter
        for(int col = 1; col < totalEdges; col++){
            //if the value is '1', that matrix column is an edge of that vertex
            if(matrix[vertex][col] == 1){
                //saving every edge of the vertex 
                edges.add(col);
            }
        }

        ArrayList<Integer> predecessors = new ArrayList<>();
        //loop through the edges of the vertex
        for(int i : edges){
            //loop through all rows (vertex)
            for(int line = 1; line < totalVertex; line++){
                //if the row has the value '1' with the column it is a successor
                if(matrix[line][i] == -1){
                    //saving every successor
                    predecessors.add(line);
                    break;
                }
            }
        }

        //printing the results
        System.out.println("Lista de predecessores do vértice (" + vertex + ") - " + predecessors.toString());
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        //ask which file is going to be used
        System.out.println("Qual o nome do arquivo que será utilizado?");
        String file = sc.nextLine();
        System.out.println();

        sc.close();

        //select the correct file
        sc = new Scanner(new File(file));

        //initialize the matrix
        int totalVertex = sc.nextInt() + 1;
        int totalEdges = sc.nextInt() + 1;
        int[][] matrix = new int[totalVertex][totalEdges];

        buildMatrix(sc, matrix);

        int maxOutDegreeVertex = maxOutDegree(totalVertex, totalEdges, matrix);
        successors(maxOutDegreeVertex, totalVertex, totalEdges, matrix);
        System.out.println("============================================================================================================================");
        int maxInDegreeVertex = maxInDegree(totalVertex, totalEdges, matrix);
        predecessors(maxInDegreeVertex, totalVertex, totalEdges, matrix);

        sc.close();
        
    }
}
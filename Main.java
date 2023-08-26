import java.io.File;
import java.util.Scanner;

public class Main{
    
    public static void buildMatrix(Scanner sc, int[][] matrix){
        int col = 1;
        while(sc.hasNext()){
            int vertex = sc.nextInt();
            int edges = sc.nextInt();

            //writing the predecessors and successors in their proper lines
            matrix[vertex][col] = (-1);
            matrix[edges][col] = 1;
            
            col++;
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        //ask which file is going to be used
        System.out.println("Selecione o arquivo:");
        System.out.println("1 - 'graph-test-100.txt'");
        System.out.println("2 - 'graph-test-50000.txt'");
        int option = sc.nextInt();

        sc.close();

        //select the correct file
        if(option == 1){
            sc = new Scanner(new File("graph-test-100.txt"));

            //initialize the matrix
            int totalVertex = sc.nextInt() + 1;
            int totalEdges = sc.nextInt() + 1;
            int[][] matrix = new int[totalVertex][totalEdges];

            buildMatrix(sc, matrix);

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
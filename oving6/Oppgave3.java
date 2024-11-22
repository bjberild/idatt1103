package oving6;

public class Oppgave3 {
    public static void printMatrix(int matrix[][]){
        String utskrift;
        for (int i = 0; i < matrix.length; i++){
            utskrift = "";
	        for (int j = 0; j < matrix[i].length; j++){
                utskrift += matrix[i][j] + " ";
	        }
            System.out.println(utskrift);
        }
	}
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{3,2,1}};
        int[][] matrix2 = {{1,2},{3,3},{2,1}};
		Matrise matrise = new Matrise(matrix);

        printMatrix(matrise.addere(matrix));

        printMatrix(matrise.multiplisere(matrix2));

        printMatrix(matrise.tranposere());
    }
}

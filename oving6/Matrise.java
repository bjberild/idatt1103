package oving6;

public final class Matrise {
    private int rows;
    private int columns;
    private int[][] matrix;

    public Matrise(int[][] matrix){
        this.matrix = matrix;
        this.rows = matrix.length;
        this.columns = matrix[0].length;
    }

    public int[][] addere(int[][] matrix){
        if (this.rows == matrix.length && this.columns == matrix[0].length) {
            int[][] newMatrix = new int[this.rows][this.columns];
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    newMatrix[i][j] = this.matrix[i][j] + matrix[i][j];
                }
            }
            return newMatrix;
        }
        else{
            return null;
        }
    }

    public int[][] multiplisere(int[][] matrix){
        int[][] newMatrix = new int[this.rows][matrix[0].length];
        if (this.columns == matrix.length) {
            for (int i = 0; i < newMatrix.length; i++) {
                for (int j = 0; j < newMatrix[0].length; j++) {
                    for (int k = 0; k < matrix.length; k++) {
                        newMatrix[i][j] += this.matrix[i][k] * matrix[k][j];
                    }
                }
            }
        }
        return newMatrix;
    }

    public int[][] tranposere(){
        int[][] newMatrix = new int[columns][rows];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
import java.util.*;

// The main method must be in a class named "Main".
class J1_06 {
    public static void main(String[] args) {

        float[][] matrix1 = new float[5][4];
        float[][] matrix2 = new float[4][6];
        float[][] matrix_res = new float[5][6];

        Scanner scanner = new Scanner(System.in);

        for(int i=0; i<5; i++){

            for(int j=0; j<4; j++){
                
                matrix1[i][j] = scanner.nextFloat();
            }
        }

        for(int i=0; i<4; i++){

            for(int j=0; j<6; j++){
                
                matrix2[i][j] = scanner.nextFloat();
            }
        }
        
        
        //A54 * B46 = C56
        for(int i=0; i<5; i++){

            for(int j=0; j<6; j++){
                
                for(int k=0; k<4; k++){
                    
                    matrix_res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                
                System.out.printf("%.2f ", matrix_res[i][j]);
            }
            
            System.out.println();
        }

        scanner.close();
    }
}

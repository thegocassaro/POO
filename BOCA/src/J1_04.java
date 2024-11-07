import java.util.Scanner;
import java.util.Vector;

public class J1_04 {
    
    public static void main(String[] args) {
        
        Scanner scannerObj = new Scanner(System.in);
        Vector<Integer> v = new Vector<>(); //capacidade padrão de 10

        for(int i=0; i<10; i++){

            v.add(scannerObj.nextInt());
        }

        int x = scannerObj.nextInt();

        scannerObj.close();

        verificaMaiorGapVetorInt(v);
        verificaOrdenaçãoVetorInt(v);
        verificaGrandezaRelativaX(v, x);
    }

    public static void verificaMaiorGapVetorInt(Vector<Integer> v){

        int idx1 = 0, idx2 = 1;
        int currentGap = 0;
        int biggestGap = v.get(1) - v.get(0);
        if(biggestGap < 0) biggestGap *= -1;

        for(int i=0; i<(v.size() - 1); i++){

            currentGap = v.get(i+1) - v.get(i);
            if(currentGap < 0) currentGap *= -1;

            if(currentGap > biggestGap){

                biggestGap = currentGap;
                idx1 = i;
                idx2 = i+1;
            }
        }

        System.out.print(idx1 + " " + idx2 + " ");
        /*
         * tomar cuidado pois se fizer print(int + int) ele vai na verdade imprimir a soma dos dois,
         * nao eh nem os dois concatenados, puro perigo
         */
    }

    public static void verificaOrdenaçãoVetorInt(Vector<Integer> v){

        int state = -1;
        int prevState = -1;
        int prevFlag = 0;

        for(int i=0; i<(v.size() - 1); i++){

            if      (v.get(i+1) > v.get(i)) state = 1;
            else if (v.get(i+1) < v.get(i)) state = 0;
            else continue;

            if(prevFlag == 1 && prevState != state){
                System.out.print("Nao ordenado ");
                return;
            } 

            prevState = state;

            prevFlag = 1;
        }

        if(state == 1) System.out.print("Crescente ");
        else if(state == 0) System.out.print("Decrescente ");
        else System.out.print("Indefinido "); //caso todos os numeros sejam iguais
    }

    public static void verificaGrandezaRelativaX(Vector<Integer> v, int x){

        int bigger = 0;
        int smaller = 0;
        int equal = 0;

        for(int i=0; i<v.size(); i++){

            if(v.get(i) > x) bigger++;
            else if(v.get(i) < x) smaller++;
            else equal++;
        }

        System.out.print(bigger + " " + smaller + " " + equal);
    }
}

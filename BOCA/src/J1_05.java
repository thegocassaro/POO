import java.util.Scanner;
import java.util.Vector;

public class J1_05 {
    
    public static void main(String[] args) {
        
        Vector<Integer> v = new Vector<>();
        Scanner scannerObj = new Scanner(System.in);

        for(int i=0; i<10; i++){

            v.add(scannerObj.nextInt()); 
        }

        scannerObj.close();

        int dif = v.get(1) - v.get(0);
        int prevDif = dif;

        for(int i=1; i<(v.size() - 1); i++){

            dif = v.get(i+1) - v.get(i);

            if(prevDif != dif){
                System.out.print("Nao");
                return;
            }

            prevDif = dif;
        }

        System.out.print("Sim " + v.getFirst() + " " + dif);
    }
}

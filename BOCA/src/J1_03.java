import java.util.Scanner;

public class J1_03 {
    
    public static void main(String[] args) {
        
        Scanner scannerObj = new Scanner(System.in);
        
        int firstNum = scannerObj.nextInt();
        int secondNum = scannerObj.nextInt();

        scannerObj.close();

        System.out.println(MDC(firstNum, secondNum));
    }

    static int MDC(int x, int y){

        if      (x > y) return MDC(x - y, y);
        else if (y > x) return MDC(y - x, x);

        return x;
    }
}

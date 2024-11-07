public class J1_01 {
    public static void main(String[] args) throws Exception {
        
        //S1
        double numerador = 1;
        double denominador = 1;
        double result = 0;

        for(int i=0; i<50; i++){

            result = result + (numerador / denominador);
            numerador = numerador + 2;
            denominador++;
        }

        System.out.println("S1 = " + result);

        //S2
        numerador = 2;
        denominador = 50;
        result = 0;

        for(int i=0; i<50; i++){

            numerador = 2;

            for(int j=0; j<i; j++) 
                numerador = numerador * 2;

            result = result + (numerador / denominador);
            denominador--;

        }
        
        System.out.println("S2 = " + result);

        //S3
        numerador = 1;
        denominador = 1;
        result = 0;

        for(int i=0; i<10; i++){

            if((numerador % 2) == 0) result = result - (numerador / denominador);
            else result = result + (numerador / denominador);

            numerador++;
            denominador = numerador * numerador;
        }

        System.out.println("S3 = " + result);
    }
}

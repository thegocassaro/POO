public class J1_02 {
    
    public static void main(String[] args) throws Exception {

        int firstHalf = 0;
        int secondHalf = 0;

        for(int num=1001; num<9999; num++){

            firstHalf = num / 100;
            secondHalf = num % 100;

            int sum = firstHalf + secondHalf;

            if ( (sum * sum) == num ){

                System.out.println(num);
            }
        }
    }
}

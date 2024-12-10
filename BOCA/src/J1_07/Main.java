import java.util.Scanner;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Ponto ponto1 = new Ponto();
        Ponto ponto2 = new Ponto();
        Ponto ponto3 = new Ponto();
        Triangulo triangulo = new Triangulo();
        
        ponto1.registraPonto(scanner.nextFloat(), scanner.nextFloat());
        ponto2.registraPonto(scanner.nextFloat(), scanner.nextFloat());
        ponto3.registraPonto(scanner.nextFloat(), scanner.nextFloat());
        
        triangulo.registraTriangulo(ponto1, ponto2, ponto3);
        
        double perimetro = triangulo.perimetro();

        System.out.printf("%.5f\n", perimetro);
        
        scanner.close();
    }
}

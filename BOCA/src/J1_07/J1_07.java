//Essa bosta funciona normalmente sem precisar de declarar um package, pois
//o java na hora de compilar assume que esse diretorio (src/J1_07) eh o padrao pra facilitar
//o processo. Entao como eu so quero compilar essa main separado do resto dos 
//codigos, tudo bem, so nao sei ainda pq o vscode nao reclama aqui mas reclama no J1_08.

import java.util.Scanner;

class J1_07 {
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

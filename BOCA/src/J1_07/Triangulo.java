public class Triangulo{
    
    Ponto p1, p2, p3;

    public void registraTriangulo(Ponto p1, Ponto p2, Ponto p3){

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

    }
    
    public double perimetro(){
        
        return this.p1.distanciaEntrePontos(this.p2) + this.p2.distanciaEntrePontos(this.p3) + this.p3.distanciaEntrePontos(this.p1);
        
    }
}
import java.lang.Math; 

public class Ponto{
    
    float x;
    float y;
    
    public void registraPonto(float x, float y){
        
        this.x = x;
        this.y = y;
    }
    
    public double distanciaEntrePontos(Ponto p2){
        
        double dist = Math.pow((this.x - p2.x), 2) + Math.pow((this.y - p2.y), 2);
        
        dist = Math.sqrt(dist);
        
        return dist;
    }
    
    
}
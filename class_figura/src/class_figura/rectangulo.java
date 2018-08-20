
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_figura;

/**
 *
 * @author Toshiba
 */
public class rectangulo extends figura{
     private double area;
    private double perimetro;
   
    
    public rectangulo(double base,double altura){
        
        super(((base*altura)),((2*base)+(2*altura)));
        
    }
    
    public void setArea(double base,double altura){
        this.area=(base*altura);
        setArea(this.area);
    }
    
    public void setPerimetro(double base,double altura){
        this.perimetro=(2*base)+(2*altura);
        setPerimetro(this.perimetro);
    }
    
    @Override
    public double DimeArea(){
        return getArea();
    }
    
    @Override
    public double DimePerimetro(){
        return getPerimetro();
    }
    
}

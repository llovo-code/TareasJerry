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
public class triangulo extends figura{
    private double area;
    private double perimetro;
   
    
    public triangulo(double base,double altura, double lado1,double lado2, double lado3){
        //area= 
        //perimetro=;
        super(((base*altura)/2),(lado1+lado2+lado3));
        
    }
    
    public void setArea(double base,double altura){
        this.area=(base*altura)/2;
        setArea(this.area);
    }
    
    public void setPerimetro(double lado1,double lado2 , double lado3){
        this.perimetro=lado1+lado2+lado3;
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

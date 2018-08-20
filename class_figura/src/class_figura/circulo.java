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
public class circulo extends figura {
    
    public circulo(double radio){
        super((Math.PI*(radio*radio)),(2*Math.PI*radio));
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

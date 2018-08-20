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
public class cuadro extends figura{
    
   
    public cuadro(double lado){
        super(Math.pow(lado,2),(4*lado));
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

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
public abstract class figura {
    private double area;
    private double perimetro;
    
    public figura(){}
    public figura(double area,double perimetro){
        this.area=area;
        this.perimetro=perimetro;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
    
    abstract public double DimeArea();
    abstract public double DimePerimetro();
    
}

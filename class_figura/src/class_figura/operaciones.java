/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_figura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 *
 * @author Toshiba
 */
public class operaciones  {
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    DecimalFormat fs = new DecimalFormat("#.00");
public operaciones(){}

public void menu(){
    System.out.println(" AREAS Y PERIMETROS\n1- CUADRO\n2-RECTANGULO\n3-TRIANGULO\n4-CIRCULO\n5-SALIR");
    System.out.println("#Seleccione una OPCION");
}
public void Selecion_menu(int op, boolean ft)throws IOException{
   
    switch(op){
        case 1:{
            this.cuadro();
            break;
        }
        case 2:{
           this.rectangulo();
            break;
        }
        case 3:{
             this.triangulo();
            break;
        }
        case 4:{
            this.circulo();
            break;
        }
        case 5:{
            ft=true;
            break;
        }
        default:{
            System.out.println("back");
            break;
        }
            
    }
}
public void triangulo()throws IOException{
    System.out.println("Digite la base del triangulo");
    double base = Double.parseDouble(leer.readLine());
    System.out.println("Digite la altura del triangulo");
    double altura = Double.parseDouble(leer.readLine());
    System.out.println("Digite la altura del lado 1");
    double lado1 = Double.parseDouble(leer.readLine());
    System.out.println("Digite la altura del lado 2");
    double lado2 = Double.parseDouble(leer.readLine());
    System.out.println("Digite la altura del lado 3");
    double lado3 = Double.parseDouble(leer.readLine());
    triangulo cuadro = new triangulo(base,altura,lado1,lado2,lado3);
    System.out.println("EL Area es :"+fs.format(cuadro.DimeArea()));
    System.out.println("El Perimetro es: "+fs.format(cuadro.DimePerimetro()));
}

public void rectangulo()throws IOException{
    System.out.println("Digite la base del Rectangulo");
    double base = Double.parseDouble(leer.readLine());
    System.out.println("Digite la altura del Rectangulo");
    double altura = Double.parseDouble(leer.readLine());
    rectangulo rectangulo = new rectangulo(base,altura);
    System.out.println("El area es: "+fs.format(rectangulo.DimeArea()));
    System.out.println("El Perimetros es: "+fs.format(rectangulo.DimePerimetro()));
    
}

public void cuadro ()throws  IOException{
    System.out.println("Digite la longitud de los lados del cuadro ");
    double lado = Double.parseDouble(leer.readLine());
    cuadro cuadro = new cuadro(lado);
    System.out.println("El area es :"+fs.format(cuadro.DimeArea()));
    System.out.println("El Perimetro es : "+fs.format(cuadro.DimePerimetro()));
}

public void circulo()throws IOException{
    System.out.println("Digite el radio de el Circulo");
    double radio= Double.parseDouble(leer.readLine());
    circulo circulo = new circulo(radio);
    System.out.println("El area es : "+fs.format(circulo.DimeArea()));
    System.out.println("El Perimetro es : "+fs.format(circulo.DimePerimetro()));
}
}

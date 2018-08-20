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
public class Class_figura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException{
      BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    DecimalFormat fs = new DecimalFormat("#.00");
    
    operaciones gestiones = new operaciones();
    int op;
    boolean ft;
    do{
        ft=false;
        gestiones.menu();
     op= Integer.parseInt(leer.readLine());
    
    gestiones.Selecion_menu(op,ft);}while(ft!=true);
    }
    
}

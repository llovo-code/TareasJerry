/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import Gestiones.Gestiones;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Toshiba
 */
public class RandomAccesFile {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Gestiones Gestiones = new Gestiones();
        try {
           // boolean inout =false,flag=false;
            int opc,opc1;
            do{
            Gestiones.menu();
            opc= Integer.parseInt(in.readLine());
            Gestiones.SwitchMenu(opc);
            }while(opc>=1 && opc <=6);
        } catch (Exception e) {
            System.out.println("Error al procesar el programa "+e);
        }
    }
    
}

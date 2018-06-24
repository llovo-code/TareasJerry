/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coleciones;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author kevin
 */
public class colecciones {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
       System.out.println("Bienvenido al programa ADMINISTRADOR DE ALUMNOS \n"
		+ "El programa permite: \n"
		+ "\tA.- Registrar los alumnos de la clase \n"
		+ "\tB.- Mostrar todos los alumnos \n"
		+ "\tC.- Mostrar un alumno \n"
		+ "\tD.- Modificar un alumno \n"
		+ "\tE.- Borrar un alumno \n-------\n\n");
       
       boolean repetir = true;
       int CantidadElementoInicial=0,Posicion_dato=0;
       int aux =1;
       Gestiones gestion = new Gestiones();
        System.out.println("¿Con cuantos elemetos desea iniciar el programa?");
        CantidadElementoInicial=entrada.nextInt();
        List<Directorio> ListElements = new ArrayList<Directorio>(CantidadElementoInicial);
        for(int i=0;i<CantidadElementoInicial;i++){
            ListElements.add(gestion.addElements());
        }
        do{
            gestion.seemenu();
            switch(entrada.nextInt()){
                case 1: 
                    ListElements.add(gestion.addElements());
                    break;
                case 2:
                    for(Directorio element: ListElements){
                        System.out.println(element.toString());
                        System.out.println("- - - - - - - - - - - - - - - - - - - ");
                    }
                break;
                case 3: 
                    System.out.println("¿Que Alumno desea mostrar?");
                    aux =1;
                    for (Directorio element: ListElements){
                        System.out.println(aux+".- "+element.getNombre());
                        aux++;
                    }
                Posicion_dato=entrada.nextInt();
                    System.out.println(gestion.GiveElements(ListElements, Posicion_dato));
            break;
                case 4 :
                     System.out.println("¿Que Alumno desea modificar?");
             aux =1;
                    for (Directorio element: ListElements){
                        System.out.println(aux+".- "+element.getNombre());
                        aux++;
                    }
                Posicion_dato=entrada.nextInt();
                    gestion.ModifiElements(ListElements, Posicion_dato);
               break;
                case 5:
                    System.out.println("¿Que Alumno desea eliminar?");
             aux =1;
                    for (Directorio element: ListElements){
                        System.out.println(aux+".- "+element.getNombre());
                        aux++;
                    }
                Posicion_dato=entrada.nextInt();
                    gestion.DeleteElements(ListElements, Posicion_dato);
                    break;
                default:
                    repetir=false;
                    break;
            
        }
    }while(repetir);
        System.out.println("- - - - - Thanks for use this Application - - - - -");
    }
}

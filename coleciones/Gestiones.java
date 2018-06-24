/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coleciones;

import java.util.List;
import java.util.Scanner;


/**
 *
 * @author kevin
 */
public class Gestiones {
    Scanner entrada= new Scanner(System.in);
    
    /*Este metodo se encarga mas que todo de mostrar en pantalla un menu
    solicitando al usuario selecione cualquiera de sus opciones para poder 
    trabajar con las colecciones */
    public void seemenu(){
       System.out.println("\n------\nElija la opción que desea: \n"
                                           + "1.- Añadir alumnos \n"
		+ "2.- Mostrar todos los alumnos \n"
		+ "3.- Mostrar un alumno \n"
		+ "4.- Modificar un alumno \n"
		+ "5.- Borrar un alumno \n"
		+ "OTRO NÚMERO --> Salir");
	}
    /*Muestra en pantalla un menu para poder hacer modificaciones a las colecciones y a sus atributos
    y retorna el valor para el cual se hara a la modificacion */
    public int MenuEditar(){
        int eleccion =0 ;
        do{
            System.out.println("\\n------\\nElija que desea editar: \\n\"\n" +
"\t1.- Nombre \n" +
"\t2.- Carnet \n" +
"\t3.- Carrera \n"+
"\t4.- Grupo \n");
            eleccion = entrada.nextInt();
            
        }while(eleccion <0 || eleccion >4);
        return eleccion;
    }
    
    /*Con este metodo add un elemento a la coleccion en este caso llamada directorio
    y  retorna el nuevo elemento add a la coleccion*/
    public Directorio addElements(){
        System.out.println("Introduzca el Nombre");
        String name = entrada.nextLine();
        System.out.println("Introduzca El Nª de Carnet");
        String carnet = entrada.nextLine();
        System.out.println("Introduzca el Grupo");
        String grupo =entrada.nextLine();
        System.out.println("Ingrese la Carrera que Cursa");
        String carrera=entrada.nextLine();
        Directorio Alumnos = new Directorio(name,carnet,grupo,carrera);
        return Alumnos;
    }
    
    
    /*Con este metodo comprobamos que se ha introducido un elemento(Directorio) valido
    y existente en la coleccion 
    @ListDirectorio         coleccion(array  ) de los elementos existentes
    @posicion_dato         Posicion del objeto Directorio, introducido por el usuario en la coleccion
    @return                     bololean que indica si el elemeto exite o no */
    public boolean AgendaNoVacia(List <Directorio> ListElements,int posicion_dato){
        boolean elemento_exist=false;
        if (ListElements.size()<posicion_dato){
            elemento_exist=true;}
        
            return elemento_exist;
    }
    
    /*
    Este metodo Obtiene un objeto(Directorio) indicado por la posicion que ocupa en la coleccion
    @ListDirectorio         Coleccion (array) de los elementos existentes
     @posicion_dato         Posicion del objeto Directorio, introducido por el usuario en la coleccion
    @return                     devuelve un Objeto elemento indicado por el usuario
    */ 
    public Directorio GiveElements(List<Directorio> ListElements,int posicion_dato){
    //Llama al metodo AgendaNoVacia. si no es valido la posicion no se continua
        while(this.AgendaNoVacia(ListElements, posicion_dato)){
            System.out.println("La posición elegida no existe. \n"
                               + "Por favor, introduzca otra");
// se solicita una nueva posicion.
            posicion_dato=entrada.nextInt();
            
        }
        return ListElements.get(posicion_dato-1);
    }
    //Con este metodo borramos el elemento del directorio
    public void DeleteElements(List<Directorio> ListElements,int posicion_dato){
  ListElements.remove(this.GiveElements(ListElements, posicion_dato));
        System.out.println("Registro Eliminado Correctamente");
    }
    
    public void ModifiElements (List<Directorio> ListElements,int posicion_dato){
  this.GiveElements(ListElements, posicion_dato);
   
   switch(this.MenuEditar()){
        case 1:
                         System.out.println("Introduzca el Nuevo nombre");
                         entrada.nextLine();
                         String name= entrada.nextLine();
                          this.GiveElements(ListElements, posicion_dato).setNombre(name);
                          break;
        case 2:
                        System.out.println("Introduzca el nuevo Carnet");
                         entrada.nextLine();
                         String carnet= entrada.nextLine();
                         this.GiveElements(ListElements, posicion_dato).setCarnet(carnet);
                         break;
        case 3:
                         System.out.println("Introduzca el nuevo Grupo");
                          entrada.nextLine();
                         String grupo= entrada.nextLine();
                          this.GiveElements(ListElements, posicion_dato).setGrupo(grupo);
                          break;
        case 4:
                         System.out.println("Ingrese la carrera a modificar");
                          entrada.nextLine();
                         String carrera= entrada.nextLine();
                         this.GiveElements(ListElements, posicion_dato).setCarrera(carrera);
                          break;
        default: 
                         break;
           
   }
   System.out.println("Modificacion Realizada Satisfactoriamente");
    }
    }



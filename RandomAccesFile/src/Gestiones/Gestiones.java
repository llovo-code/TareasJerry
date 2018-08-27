/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestiones;
import clases.Alumno;
import implement.AlumnoDaoImplem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Toshiba
 */
public class Gestiones{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public Gestiones(){}
    public  void menu(){
        System.out.println("GESTION DE RESGISTRO");
        System.out.println("1 - AÑADIR ALUMNO\n"
                + "2 - ACTUALIZAR ALUMNO\n"
                + "3 - BORRAR ALUMNO\n"
                + "4 - BUSCAR ALUMNO\n"
                + "5 - SALIR\n"
                + "OPCION: ");
    }
    
    private void SubMenuByFind(){
        System.out.println("1 - BUSCAR POR NOMBRE\n"
                + "2 - BUSCAR POR APELLIDO\n"
                + "3 - BUSCAR POR EDAD\n"
                + "4 - BUSCAR POR DEPARTAMENTO\n"
                + "OPCION: ");
      
    }
    public void  SwitchMenu(int pos)throws IOException,ParseException{
        
      switch(pos){
          case 1:{
              anadirAlumno();
              break;
          }
          case 2:{
              ActualizaAlumno();
              break;
          }
          case 3:{
              DeleteAlumno();
              break;
          }
          case 4:{
              break;
          }
          case 5:{
              break;
          }
          default:{
              
          }
              
      }  
      //return pos;
    }
    private void anadirAlumno()throws IOException,ParseException{
        try{System.out.println("Ingrese el Nombre:  ");
        String name = in.readLine();
        System.out.println("Ingrese el Apellido:  ");
        String lastname = in.readLine();
        System.out.println("Ingrese la edad: ");
        int age = Integer.parseInt(in.readLine());
        System.out.println("Ingrese el grado universitario sea $M$,$T$");
        String grado = in.readLine();
        long date = Calendar.getInstance().getTime().getTime();
        int country = MenuCountry();
        AlumnoDaoImplem dao = new AlumnoDaoImplem();
        dao.save(new Alumno(name,lastname,age,date,grado,Alumno.LIST_COUNTRY.values()[country-1]));
        }catch(Exception e){
            System.out.println("No se pudo guardar "+e);
        }
        
        
    }
    private int MenuCountry()throws IOException,ParseException{
        int country=0;
        System.out.println("Selecciones Su Departamento");
        do{
        System.out.println("1 - Chinandega\n"
                + "2 - Leon\n"
                + "3 - Managua\n"
                + "4 - Masaya\n"
                + "5 - Granada\n"
                + "6 - Rivas\n"
                +"OPCION: ");
        country = Integer.parseInt(in.readLine());
        }while(country < 1 || country >6);
        return country;
    }
    
    private void ActualizaAlumno()throws IOException, ParseException{
        AlumnoDaoImplem  dao = new AlumnoDaoImplem();
        List<Alumno> alumn = dao.findall();
        printMessage();
      for(Alumno e: alumn){
          printData(e);
      }
        System.out.println("Introduce el ID del Alumno a Actualizar");
        int id = Integer.parseInt(in.readLine());
        System.out.println("\nActualizar Alumno por\n"
                + "\n"
                + "1 - Nombre\n"
                + "2 - Apellido\n"
                + "3 - Edad\n"
                + "4 - Fecha\n"
                + "5 - Departamento\n"
                + "6 - TODO\n"
                + "OPCION: ");
        int opc = Integer.parseInt(in.readLine());
        in.readLine();
        switchActulizar(opc,id);
        
    }
    private void switchActulizar(int opc, int id)throws IOException, ParseException{
        AlumnoDaoImplem dao = new AlumnoDaoImplem();
        Alumno alumn = dao.findById(id);
         System.out.println(" :V ");
        switch(opc){
            
            case 1:{
                System.out.println("Digite el nombre: ");
                String name = in.readLine();
                alumn.setName(name);
                dao.uptade(alumn);
                break;
            }
            case 2:{
                System.out.println("Digite el Apellido: ");
                String lastname = in.readLine();
                alumn.setLastName(lastname);
                dao.uptade(alumn);
                break;
            }
            case 3:{
                System.out.println("Digite La edad: ");
                int age = Integer.parseInt(in.readLine());
                alumn.setAge(age);
                dao.uptade(alumn);
                break;
            }
            case 4:{
                System.out.println("Digite el Dia: ");
                int day  = Integer.parseInt(in.readLine());
                System.out.println("Digite el Numero de mes: ");
                int mes = Integer.parseInt(in.readLine());
                //mes = mes-1;
                System.out.println("Digite el Anio: ");
                int year = Integer.parseInt(in.readLine());
                String fecha = day+"/"+mes+"/"+year;
                SimpleDateFormat format = new SimpleDateFormat("d/m/y");
                
                Date date = (Date)format.parse(fecha);
                long DATE = date.getTime();
                alumn.setDate(DATE);
                dao.uptade(alumn);/*Este metodo recibe un parametro
                                       de tipo lng
                                        como convierto ese Date a long*/
                break;
            }
            case 5:{
                int country = MenuCountry();
                alumn.setCountry(Alumno.LIST_COUNTRY.values()[country]);
                dao.uptade(alumn);
                break;
            }
            case 6:{
                System.out.println("Digite el nombre: ");
                String name = in.readLine();
                alumn.setName(name);
                System.out.println("Digite el Apellido: ");
                String lastname = in.readLine();
                alumn.setLastName(lastname);
                 System.out.println("Digite La edad: ");
                int age = Integer.parseInt(in.readLine());
                alumn.setAge(age);
                System.out.println("Digite el Dia: ");
                int day  = Integer.parseInt(in.readLine());
                System.out.println("Digite el Numero de mes: ");
                int mes = Integer.parseInt(in.readLine());
                //mes = mes-1;
                System.out.println("Digite el Anio: ");
                int year = Integer.parseInt(in.readLine());
                String fecha = day+"/"+mes+"/"+year;
                SimpleDateFormat format = new SimpleDateFormat("d/m/y");
                
                Date date = (Date)format.parse(fecha);
                long DATE = date.getTime();
                alumn.setDate(DATE);
                int country = MenuCountry();
                alumn.setCountry(Alumno.LIST_COUNTRY.values()[country]);
                dao.uptade(alumn);
                break;
            }
            default:{
                
            }
        }
        
        
    }
    
    private static void printData(Alumno e){
        SimpleDateFormat format = new SimpleDateFormat("d/M/y");
        System.out.format("%5d %20s %20s %20d %20s %20s %20s\n",
                e.getId(),e.getName(),e.getLastName(),e.getAge(),e.getGrado(),
                format.format(new Date(e.getDate())),
                e.getCountry().toString());
    }
    private static void printMessage(){
        System.out.format("%5s %20s %20s %20s %20s %20s %20s\n",
                "ID","NAME","LAST_NAME","AGE","GRADO","DATE",
                "COUNTRY");
    }
    
    private void DeleteAlumno()throws IOException{
        AlumnoDaoImplem dao = new AlumnoDaoImplem();
        List<Alumno> alumn = dao.findall();
        Alumno Alumn = new Alumno();
        printMessage(); 
        alumn.forEach((e) -> {
            printData(e);
        });
        System.out.println("Indique el Id del Alumno a borrar: ");
        
        int id = Integer.parseInt(in.readLine());
        if(Alumn.getId()==id){
            dao.delete(Alumn);
        }
        
    }
}


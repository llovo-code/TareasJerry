/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coleciones;

/**
 *
 * @author kevin
 */
public class Directorio {
    private String Nombre;
    private String carnet;
    private String grupo;
    private String carrera;
public Directorio(){  }
public Directorio(String Nombre,String carnet, String grupo, String carrera){
    this.Nombre=Nombre;
    this.carnet=carnet;
    this.grupo=grupo;
    this.carrera=carrera;
    
}
public String toString() {
return	"Nombre: \t"+this.Nombre+"\n"+
	"Carnet:  \t"+this.carnet+"\n"+
                      "Carrera:\t"+this.carrera+"\n"+
	"Grupo: \t\t"+this.grupo+"\n";
	}
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getCarnet() {
        return carnet;
    }
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
    public String getGrupo() {
        return grupo;
    }
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public String getCarrera(){
        return carrera;
    }
    public void setCarrera(String carrera){
        this.carrera=carrera;
    }
    
}

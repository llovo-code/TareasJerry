/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import clases.Alumno;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Toshiba
 */
public interface AlumnoDao extends IDao<Alumno>{
    Alumno findById(int id)throws IOException;
    List<Alumno> findByName(String name)throws IOException;
    List<Alumno> findByLastName(String LastName)throws IOException;
    List<Alumno> finByCountry(Alumno.LIST_COUNTRY country)throws IOException;
}

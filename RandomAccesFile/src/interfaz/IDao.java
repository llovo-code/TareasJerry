/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Toshiba
 * @param <T>
 */
public interface IDao <T> {
    void save (T t) throws IOException;
    boolean uptade(T t)throws IOException;
    boolean delete(T t )throws IOException;
    List<T>findall()throws IOException;
}

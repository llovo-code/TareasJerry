/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;
import java.io.RandomAccessFile;
import clases.Alumno;
import interfaz.AlumnoDao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Toshiba
 */
public class AlumnoDaoImplem implements AlumnoDao{
private RandomAccessFile raf;
private File file;
private String filename;

public AlumnoDaoImplem(){
    
}
private void openRAF()throws FileNotFoundException,IOException{
    filename= "Alumno.dat";
    file = new File(filename);
    if(!file.exists()){
        raf = new RandomAccessFile(file,"rw");
        raf.seek(0);
        raf.writeInt(0);
        raf.writeInt(0);
    }else{
        raf = new RandomAccessFile(file,"rw");
        
    }
}

private void closeRAF()throws IOException{
if(raf!=null){
    raf.close();
}
}

private String LimistString(String text,int capacidad){
    StringBuilder builder;
    if(text ==null){
        builder = new StringBuilder(capacidad);
    }else{
        builder = new StringBuilder(text);
        builder.setLength(capacidad);
    }
    return builder.toString();
}

    @Override
    public Alumno findById(int id) throws IOException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       openRAF();
       raf.seek(0);
       int n = raf.readInt();
       if(n==0){return null;}
       
     int index = BinarySearchRecursive(id, 1, n);
       
     if(index <= (-1)){return null;}
       long pos = 8+69*index;
     System.out.println(pos);
     raf.seek(pos);
     Alumno Alum =new Alumno();
      System.out.println(index);
       
     Alum.setId(raf.readInt());
     Alum.setName(raf.readUTF().replace('\0', ' ').trim());
     Alum.setLastName(raf.readUTF().replace('\0', ' ').trim());
     Alum.setAge(raf.readInt());
     Alum.setGrado(raf.readUTF().replace('\0', ' ').trim());
     Alum.setDate(raf.readLong());
     Alum.setCountry(
           Alumno.LIST_COUNTRY.values()[raf.readInt()]);
    // raf.seek(0);
        System.out.println(":v");
     closeRAF();
     return Alum;
    }
    
    private int BinarySearchRecursive(int key , int low, int high)throws IOException{
        int middle = (low+high)/2;
        if(high<low){
            return -1;
        }
        long pos = 8 + 69*middle;
        raf.seek(pos);
        int id = raf.readInt();
        if(key ==id){
            return middle;
        }else if(key < id){
            return BinarySearchRecursive(key, low, middle-1);
        }else{
            return BinarySearchRecursive(key, middle+1, high);
        }
    }

    @Override
    public List<Alumno> findByName(String name) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> findByLastName(String LastName) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> finByCountry(Alumno.LIST_COUNTRY country) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void save(Alumno t) throws IOException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    openRAF();
    raf.seek(0);
    int n = raf.readInt();
    int k = raf.readInt(); 
    long pos = 8+ 69*n;
    
    raf.seek(pos);
    raf.writeInt(++k);
    raf.writeUTF(LimistString(t.getName(), 10));
    raf.writeUTF(LimistString(t.getLastName(), 10));
    raf.writeInt(t.getAge());
    raf.writeLong(t.getDate());
    raf.writeUTF(LimistString(t.getGrado(), 3));
    raf.writeInt(t.getCountry().ordinal());
    
    raf.seek(0);
    raf.writeInt(++n);
    raf.writeInt(k);
    closeRAF();
            
    }

    @Override
    public boolean uptade(Alumno t) throws IOException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    boolean flag = false;
    openRAF();
    raf.seek(0);
    int n = raf.readInt();
    if(n<=0){return flag;}
    int index = BinarySearchRecursive(t.getId(), 0, n-1);
    if(index<= -1){return flag; }
    long pos = 12+ 69*index;
    raf.seek(pos);
    raf.writeUTF(LimistString(t.getName(), 10));
    raf.writeUTF(LimistString(t.getLastName(), 10));
    raf.writeInt(t.getAge());
    raf.writeLong(t.getDate());
    raf.writeUTF(LimistString(t.getGrado(), 3));
    raf.writeInt(t.getCountry().ordinal());
    flag =true;
    raf.seek(0);
    closeRAF();
    return flag;
    }

    @Override
    public boolean delete(Alumno t) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    List<Alumno> list = getAll();
    List<Alumno> temp = rebuild(list ,t);
    raf.seek(0);
    int n = raf.readInt();
    int k = raf.readInt();
    if(list !=temp){
        file.delete();
        raf=null;
        openRAF();
        if(raf!=null && file.exists() && temp!=null){
            raf.seek(0);
            raf.writeInt(--n);
                raf.writeInt(k);
                int i=0;
                for (Alumno x:
                     temp) {
                    long pos=8+69*i;
                    raf.seek(pos);
                    raf.writeInt(x.getId());
                    raf.writeUTF(LimistString(x.getName(), 10));
                    raf.writeUTF(LimistString(x.getName(), 10));
                    raf.writeInt(x.getAge());
                    raf.writeLong(x.getDate());
                    raf.writeUTF(LimistString(x.getGrado(), 3));
                    raf.writeLong(x.getCountry().ordinal());
                    i++;
                    raf.seek(0);
                }
                 raf.seek(0);
            closeRAF();
            return true;
        }
         raf.seek(0);
        closeRAF();
        return false;
    }
    return false;
    }

    @Override
    public List<Alumno> findall() throws IOException {
    return getAll();
    }
    
    private List<Alumno> getAll()throws IOException{
        List<Alumno> alumnos = new ArrayList<>();
        openRAF();
        raf.seek(0);
        int n = raf.readInt();
       for( int i = 0 ; i < n ; i++) {
            long pos = 8 + (69*i);
            raf.seek(pos);
            Alumno Alum =new Alumno();
    
            Alum.setId(raf.readInt());
            Alum.setName(raf.readUTF().replace('\0', ' ').trim());
            Alum.setLastName(raf.readUTF().replace('\0', ' ').trim());
            Alum.setAge(raf.readInt());
            Alum.setDate(raf.readLong());
            Alum.setGrado(raf.readUTF().replace('\0', ' ').trim());
            Alum.setCountry(
                Alumno.LIST_COUNTRY.values()[raf.readInt()]);
            alumnos.add(Alum);
       } 
      raf.seek(0);
       closeRAF();
     return alumnos;
     
    }
    
    private List<Alumno> rebuild(List<Alumno> list,Alumno t){
        List<Alumno> temp = new ArrayList<>();
        for(Alumno x: list){
            if(!x.equals(t)){
                 temp.add(x);
            }
            
        }
        return temp;           

    }
}

package store;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class File {
    private RandomAccessFile file;

    public File(String fileName){
        try {
            file = new RandomAccessFile(fileName, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeInt(int num){
        try {
            file.writeInt(num);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeFloat(float num){
        try {
            file.writeFloat(num);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeString(String string){
        try {
            file.writeBytes(string);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int readInt(){
        try {
            return file.readInt();
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public float readFloat(){
        try {
            return file.readFloat();
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public String readString(int n){
        try {
            byte Bytes[] = new byte[n];
            file.read(Bytes);
            return new String(Bytes);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void lastRecord(){
        try {
            file.seek(file.length());
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void seekRecord(long registryNum){
        try {
            file.seek(registryNum);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public long fileLength(){
        try {
            return file.length();
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Run {
   
    
    //The gui is provided so we can pass our updating values through
    GUIOVERWRITE gui;
    
      //The done button is recreated from our PlayPanel so that we can draw information from it
    private JButton done;
    
    //The MainMethod starting the game
    public static void main(String[] args){
        new Run();
    }
    
    //The empty Game constructor instates a new GUI that passes the variables needed for initializing
    public Run(){
        gui = new GUIOVERWRITE(this);
      }
    
    
}
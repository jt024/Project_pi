/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.awt.AWTException;
import java.io.IOException;
import java.io.*;
/**
 *
 * @author Trevi
 */
public class Connection {
    
    private static final String  USERNAME = "pi";
    private static final String PASSWORD = "raspberry";
    
//    String s = "src\\putty.exe -ssh -l "+USERNAME+" -pw "+PASSWORD+" "+host+"";   
    // -ssh -l "+USERNAME+" -pw "+PASSWORD+" "+host+"
    
    public static void connectSSH(String host) throws IOException, InterruptedException, AWTException{
        String s = "putty\\putty.exe -ssh -l "+USERNAME+" -pw "+PASSWORD+" "+host+"";
        Runtime r = Runtime.getRuntime();
        Process p;
        try{
        p = r.exec(s);
        Thread.sleep(3000);
        System.out.println("worked");
        } catch(IOException | InterruptedException ioE){
            System.out.println(ioE);
        }
        Thread.sleep(2000);
        
    }
    
    
    public static void sendFile(String host) throws InterruptedException, IOException{
        try {
            String command = "putty\\pscp.exe -ssh -l "+USERNAME+" -pw "+PASSWORD+" "+host+" "
                    + "presentation\\Dictionary.txt pi@retropie:/RetroPie/Dictionary.txt";
            // plink [options] [user@]host [command]
            Runtime r = Runtime.getRuntime ();
            Process p = r.exec (command);



            InputStream std = p.getInputStream ();
            OutputStream out = p.getOutputStream ();
            InputStream err = p.getErrorStream ();
//
//            out.write ("mkdir test\n".getBytes ());
            System.out.println("Sent mkdir");
//            out.flush ();
            
            Thread.sleep (1000);
            
//            int value = 0;
            
//            if (std.available () > 0) {
//                System.out.println ("STD:");
//                value = std.read ();
//                System.out.print ((char) value);
//
//                while (std.available () > 0) {
//                    value = std.read ();
//                    System.out.print ((char) value);
//                }
//            }
//            if (err.available () > 0) {
//                System.out.println ("ERR:");
//                value = err.read ();
//                System.out.print ((char) value);
//
//                while (err.available () > 0) {
//                    value = err.read ();
//                    System.out.print ((char) value);
//                }
//            }
            
            p.destroy ();
            
            
//            String s = "src\\putty\\pscp.exe src\\presentation\\Dictionary.txt pi@"+host+":passwordTest/";

        
        } catch(IOException | InterruptedException e){
            
        }
    
    }
    
 
   
    
    
    
    
   // pscp.exe" file.txt pi@your_pi:Desktop/ 
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touch;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket; 
import java.io.OutputStream;
import java.util.ArrayList;
        
/**
 *
 * @author Common
 */
public class BackgroundTask{
//    static String ipaddress = "192.168.43.21";
    static String ipaddress = "192.168.1.222";
    
    Socket s;
    PrintWriter dos;
    
    protected String doInBackground(String b)
    {
        try{
            s = new Socket(ipaddress,8081); 
            boolean so = s.isConnected();
            System.out.println(so);
            OutputStream os = s.getOutputStream();
            DataOutputStream out = new DataOutputStream(os);

            System.out.println("Writing to Android");
            out.writeUTF(b);
            out.flush();
            out.close();
                s.close();
        } catch(IOException io){
            io.printStackTrace();
        } 
        return null;
    }
}

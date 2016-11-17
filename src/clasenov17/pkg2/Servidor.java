/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasenov17.pkg2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class Servidor {
    public static void main(String[] args) {
        
        try{
        //1.Establecer servidor
        ServerSocket servidor= new ServerSocket(8000);
        
        //2.Aceptar conexión
        
        Socket cliente = servidor.accept();
        System.out.println("Se conectó un cliente");
        
        //3. Abrir IO
        InputStream flujoEntrada= cliente.getInputStream();
        OutputStream flujoSalida= cliente.getOutputStream();
        
        //Usar decoradores convertir bytes en texto
        BufferedReader entrada= new BufferedReader(new InputStreamReader(flujoEntrada));
        PrintWriter salida= new PrintWriter(flujoSalida,true);
        String mensaje=" ";
        while(true){
            mensaje= entrada.readLine();
            salida.println("ECO "+ mensaje);        
        }
        //entrada.close();
        //salida.close();
        
        }catch (IOException ex){
            Logger.getLogger(Servidor.class.getName());
        }
    }
}

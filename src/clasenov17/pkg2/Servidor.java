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
        System.out.println("SERVIDOR");
        try{
        //1.Establecer servidor
        ServerSocket servidor= new ServerSocket(8000);
        
        //2.Aceptar conexión
        System.out.println("Esperando Conexiones...");
        Socket cliente = servidor.accept();
        System.out.println("Se conectó un cliente");
        
        //3. Abrir IO
        InputStream flujoEntrada= cliente.getInputStream();
        OutputStream flujoSalida= cliente.getOutputStream();
        
        //Usar decoradores convertir bytes en texto
        BufferedReader entrada= new BufferedReader(new InputStreamReader(flujoEntrada));
        PrintWriter salida= new PrintWriter(flujoSalida,true);
        
        BufferedReader datosUsuario= new BufferedReader(new InputStreamReader(System.in));
        
        String mensaje=" ";
        String mensajeEnviar=" ";
        while(true){
            mensaje= entrada.readLine();
            System.out.println(mensaje);
            System.out.println("Enviar: ");
            mensajeEnviar= datosUsuario.readLine();
            salida.println(mensajeEnviar);
        }
        //entrada.close();
        //salida.close();
        
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}

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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class Cliente {
    public static void main(String[] args) {
        try{
            System.out.println("CLIENTE");
            //Establecer comunicación con servidor
            Socket cliente = new Socket("localhost",8000); //localhost igual que 127.0.0.1 
            //Socket cliente = new Socket("127.0.0.1",8000);
            //Socket cliente = new Socket("10.203.2.125",8000); //IP de otro pc
            
            
            //3. Abrir IO //Copiado del código del servidor
            InputStream flujoEntrada= cliente.getInputStream();
            OutputStream flujoSalida= cliente.getOutputStream();
        
            //Usar decoradores convertir bytes en texto
            BufferedReader entrada= new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter salida= new PrintWriter(flujoSalida,true);
            
            //Flujo para capturar datos del teclado
            BufferedReader datosUsuario= new BufferedReader(new InputStreamReader(System.in));
            
            String mensajeAEnviar=" ";
            String mensajeRecibir=" ";
            while(true){
                System.out.println("Enviar: ");
                mensajeAEnviar= datosUsuario.readLine();
                salida.println(mensajeAEnviar);
                System.out.println("Recibe: ");
                mensajeRecibir= entrada.readLine();
                System.out.println(mensajeRecibir);
            }
            //entrada.close();
            //salida.close();
            
            
        
        }catch (IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    }
}

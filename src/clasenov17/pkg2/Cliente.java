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

/**
 *
 * @author Estudiante
 */
public class Cliente {
    public static void main(String[] args) {
        try{
            //Establecer comunicación con servidor
            Socket cliente = new Socket("localhost",8000);
            
            //3. Abrir IO //Copiado del código del servidor
            InputStream flujoEntrada= cliente.getInputStream();
            OutputStream flujoSalida= cliente.getOutputStream();
        
            //Usar decoradores convertir bytes en texto
            BufferedReader entrada= new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter salida= new PrintWriter(flujoSalida,true);
            
            //Flujo para capturar datos del teclado
            BufferedReader datosUsuario= new BufferedReader(new InputStreamReader(System.in));
            
            String mensajeAEnviar="";
            String mensajeRecibir="";
            while(true){
                System.out.println("Enviar: ");
                mensajeAEnviar= datosUsuario.readLine();
                salida.println(mensajeAEnviar);
                mensajeRecibir= entrada.readLine();
                System.out.println(mensajeRecibir);
            
            }
            
            
        
        }catch (IOException ex){
        
        }
        
    
    
    
    }
}

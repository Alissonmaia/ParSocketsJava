package socketdemoserver;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Alisson
 */
public class SocketDemoServer {
    public static void main(String[] args) {
     //try e catch port 10.000 
        try {
        //Server Socket port de comunicação com client
        ServerSocket ss = new ServerSocket (10000);
        while (true) {
            //Esperando conexão do cliente 
            Socket s = ss.accept ();
            //canais de entrada/saída buffered trás os dados da área de rede para aplicação 
            BufferedInputStream bis = new BufferedInputStream (s.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream (s.getOutputStream ());
            
            //Operação da conexão com cliente
            while (true) {
                
                //ler os dados e retornar um inteiro
                int ch = bis.read (); 
                //imprimir coerção do inteiro para caratere
                System.out.println("recebido no servidor " + (char) ch); 
                //Escrever devolta para o cliente
                bos.write ((byte)ch);  
                //empurrar os dados para cliente
                bos.flush();  
                
            }
        }// sempre rodando
        
        } catch (Exception e) {
            
            //Imprimir StackTrace 
            e.printStackTrace();
        }
    }
}
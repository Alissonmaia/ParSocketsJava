package socketdemoclient;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;

/**
 *
 * @author Alisson
 */
public class SocketDemoClient {
    
    public static void main(String[] args) {
     // try e catch port 10.000
     
     try { 
        //Abertura de conexão com servidor com classe Socket
        //endpoint e port 
        Socket s = new Socket ("localhost", 10000);
        
        //canais de entrada/saída buffered trás os dados da area de rede para aplicação 
        BufferedInputStream bis = new BufferedInputStream (s.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream (s.getOutputStream());
        //Escrever uma String no Socket
        String str = "service request!";
        
        //Sempre enviando uma requisição 
        while (true) {
            //array que coleta os caracteres da String 
            for (int i = 0; i <str.length(); i++) {
            //byte coleta o caractere no indice I
            byte b = (byte) str.charAt (i);
            //Escrever byte no socket 
            bos.write (b);
            //Empurrar para servidor 
            bos.flush ();
            //ler caracteres com coerção para char retornado pelo servidor
            char ch =  (char) bis.read ();
            //imprimir reposta do servidor 
            System.out.println("recebido no cliente " + ch);
          }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}

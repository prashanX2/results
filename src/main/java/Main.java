import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by prashan on 11/27/15.
 */
public class Main {

    public static void main(String[] args) {
        try {

            String clientSentence;
            String capitalizedSentence;
            final ServerSocket serverSocket = new ServerSocket(22222);
            System.out.println("Result Server started on main: " + serverSocket.getInetAddress() + "@" + serverSocket.getLocalPort());
            //final DatagramSocket serverSocket = new DatagramSocket(44444);



            while(true)
            {

                Socket connectionSocket = serverSocket.accept();

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                clientSentence = inFromClient.readLine();
                System.out.println("Received: " + clientSentence);
                capitalizedSentence = clientSentence.toUpperCase() + '\n';

                outToClient.writeBytes(capitalizedSentence);



                System.out.println("sent to");
            }


        }catch(Exception ex)
        {
            System.out.println(ex.toString());

        }






    }
}

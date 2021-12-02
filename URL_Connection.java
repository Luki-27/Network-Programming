import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class URL_Connection {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter an URL : ");
        String url = cin.nextLine();
        accessWebsite(url);
    }

    private static void accessWebsite(String url) {
        BufferedReader bufferedReader = null;
        try {
            URL my_url= new URL(url);
            URLConnection urlConnection = my_url.openConnection();
            InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
            bufferedReader = new BufferedReader(isr);
            String line;
            PrintWriter writer = new PrintWriter("url.html");
            while ((line = bufferedReader.readLine())!= null){
                writer.print(line+"\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("\nCannot access URL");
            e.printStackTrace();
            System.exit(1);
        } finally {
            System.out.println("\nClosing the Connection");
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}

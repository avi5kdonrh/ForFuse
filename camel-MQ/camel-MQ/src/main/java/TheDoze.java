import java.net.HttpURLConnection;
import java.net.URL;

public class TheDoze {
    public static void main(String[] args) throws Exception{
      
        HttpURLConnection con = (HttpURLConnection)new URL("http://www.google.co.in/").openConnection();
        System.out.println(con.getInputStream().available());
    }
}
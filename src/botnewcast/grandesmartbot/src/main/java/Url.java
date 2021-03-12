import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Url {
    public Url() throws IOException {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) throws IOException {
        try {
            // "http://data.fixer.io/api/latest?access_key=387e8f0d0aba82bb93e316ef9d889e86"

            String a = "http://data.fixer.io/api/latest?access_key=387e8f0d0aba82bb93e316ef9d889e86&baseJPY&symbols=GBP,JPY,EUR,RUB,KZT";

            URL url = new URL(a);

            URLConnection uc = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));

            String str;

            while ((str = br.readLine()) != null) {
                System.out.println(str+ LocalDateTime.now().format(DateTimeFormatter.ofPattern(" Сейчас " + "HH"+" час."+":"+" mm"+" мин.")));

            }
            br.close();

            System.out.println("OK");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Url {
    public Url() throws IOException {
    }

    public static String getRates(String message, Model model) throws IOException {
        try {
            // "http://data.fixer.io/api/latest?access_key=387e8f0d0aba82bb93e316ef9d889e86&base=USD&symbols=GBP,JPY,EUR"
            //  http://data.fixer.io/latest?access_key=387e8f0d0aba82bb93e316ef9d889e86&callback=MY_FUNCTION&symbols=GBP,JPY,EUR,RUB"

            String a = "http://data.fixer.io/api/latest?access_key=387e8f0d0aba82bb93e316ef9d889e86&base=USD&symbols=GBP,JPY,EUR";
            URL url = new URL(a);

            Scanner in = new Scanner((InputStream) url.getContent());
            String result = "";
            while (in.hasNext()) {
                result += in.nextLine();
            }

            JSONObject object = new JSONObject(result);
            model.setRates(object.getDouble("rates"));

            JSONObject base = object.getJSONObject("base");
            model.setBase(base.getDouble("base"));


            JSONArray getArray = object.getJSONArray("fixer");
            for (int i = 0; i < getArray.length(); i++) {
                JSONObject obj = getArray.getJSONObject(i);

            }
            return "Курс: " + model.getRates() + "\n";

        } finally {

        }
    }
}         /*URLConnection uc = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));

            String str;

            while ((str = br.readLine()) != null) {
                System.out.printf("РЕСУРС: FIXER.IO  %s%s%n", str, LocalDateTime.now().format(DateTimeFormatter.ofPattern(" Сейчас " + "HH" + " час." + ":" + " mm" + " мин.")));

            }
            br.close();

            System.out.println("OK");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public String toString() {
        return "Url{}";*/



import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Climat {
    public static String getWeather(String message, Pattern pattern) throws IOException {//d934a6dc84c5578a6352162d25ccc620
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + message + "&units=metric&appid=d934a6dc84c5578a6352162d25ccc620");
        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object = new JSONObject(result);
        pattern.setName(object.getString("name"));

        JSONObject main = object.getJSONObject("main");
        pattern.setTemp(main.getDouble("temp"));
        pattern.setHumidity(main.getDouble("humidity"));

        JSONArray getArray = object.getJSONArray("weather");
        for (int i = 0; i < getArray.length(); i++) {
            JSONObject obj = getArray.getJSONObject(i);
            pattern.setIcon((String) obj.get("icon"));
            pattern.setMain((String) obj.get("main"));
        }

        return "City: " + pattern.getName() + "\n" +
                "Temperature: " + pattern.getTemp() + "C" + "\n" +
                "Humidity: " + pattern.getHumidity() + "%" + "\n" +
                "Main: " + pattern.getMain() + "\n" +
                "http://openweathermap.org/img/w/" + pattern.getIcon() + ".png";
    }
}
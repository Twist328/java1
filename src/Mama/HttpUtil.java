package Mama;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUtil {

    public static void main(String[] args) {//http://data.fixer.io/api/ latest? access_key = 387e8f0d0aba82bb93e316ef9d889e86
//https://api.fixer.io/latest?symbols  //"http://data.fixer.io/api/latest?access_key=387e8f0d0aba82bb93e316ef9d889e86&format=1"
// http : //data.fixer.io/api/ latest ? access_key = API_KEY
//     & base = USD
//     & symbols = GBP , JPY , EUR
        String url = "http://data.fixer.io/api/latest?access_key=387e8f0d0aba82bb93e316ef9d889e86";
//api.coingate.com/v2/rates/merchant/EUR/RUB

        String result = HttpUtil.sendRequest(url, null, null);
        System.out.println("Result: " + result);
    }

    /**
     * @param url     - required
     * @param headers - nullable
     * @param request - nullable
     */
    public static String sendRequest(String url, Map<String, String> headers, String request) {
        String result = null;
        HttpURLConnection urlConnection = null;
        try {
            URL requestUrl = new URL(url);
            urlConnection = (HttpURLConnection) requestUrl.openConnection();
            urlConnection.setReadTimeout(20000);
            urlConnection.setConnectTimeout(20000);
            urlConnection.setRequestMethod("GET");

            if (request != null) {
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");
                DataOutputStream outputStream = new DataOutputStream(urlConnection.getOutputStream());
                outputStream.writeBytes(request);
                outputStream.flush();
                outputStream.close();
            }

            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    urlConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            int status = urlConnection.getResponseCode();
            System.out.println("status code:" + status);

            if (status == HttpURLConnection.HTTP_OK) {
                result = getStringFromStream(urlConnection.getInputStream());
            }
        } catch (Exception e) {
            System.out.println("sendRequest failed");
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return result;
    }

    private static String getStringFromStream(InputStream inputStream) throws IOException {
        final int BUFFER_SIZE = 4096;
        ByteArrayOutputStream resultStream = new ByteArrayOutputStream(BUFFER_SIZE);
        byte[] buffer = new byte[BUFFER_SIZE];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            resultStream.write(buffer, 0, length);
        }
        return resultStream.toString("UTF-8");



   /* Gson gson = new Gson();
    StructurePB currency = gson.fromJson(result, StructurePB.class);
    if (currency.getExchangeRate().size() == 0) {
        System.out.println("Upon this date information about the course of currencies is absent, check the correctness of the input.");
    } else {
        for (int i = 0; i < currency.getExchangeRate().size(); i++) {
            if (currency.getExchangeRate().get(i).getCurrency().equals("USD")) {
                System.out.println("The dollar exchange rate for this date is: " + String.valueOf(currency.getExchangeRate().get(i).getSaleRateNB()) + " grn");
            }
        }*/
    }

    @Override
    public String toString() {
        return "HttpUtil{\"base\":\"USD\",\"EUR\":\",\"GBP\":\",\"JPY\":\"}";
    }
}

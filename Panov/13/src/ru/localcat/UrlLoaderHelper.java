package ru.localcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlLoaderHelper {

    public static UrlContentDTO getContentByUrl(String url) throws MalformedURLException {
        URL urlLoader = new URL(url);
        StringBuilder content = new StringBuilder();
        try ( InputStream inputStream = urlLoader.openStream()){

            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new UrlContentDTO(content.toString().length(), content.toString());
    }
}

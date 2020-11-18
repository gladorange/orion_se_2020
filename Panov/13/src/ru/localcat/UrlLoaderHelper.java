package ru.localcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlLoaderHelper {
    private static URL urlLoader;

    public synchronized static UrlContentDTO getContentByUrl(String url) throws MalformedURLException {
        urlLoader = new URL(url);
        StringBuilder content = new StringBuilder();
        InputStream inputStream = null;
        try{
            inputStream = urlLoader.openStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
/*        finally {
            inputStream.close();
        }*/

        return new UrlContentDTO(content.toString().length(), content.toString());
    }
}

package src.main.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class SpotifyClient {
    private static final String CREDENTIALS_FILE_PATH = "spotify.properties";

    public static Properties loadCredentials() throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(CREDENTIALS_FILE_PATH);
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }

    public static void autenticar() throws IOException {
        Properties credentials = loadCredentials();

        // Obter as credenciais do Spotify
        String clientId = credentials.getProperty("spotify.client.id");
        String clientSecret = credentials.getProperty("spotify.client.secret");

        // Autenticar na API
    }


}

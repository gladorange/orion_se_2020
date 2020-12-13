import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataBaseConfig {

    private String connection;
    private String login;
    private String password;

    public DataBaseConfig() {
    }

    public void getProperties() throws IOException {
        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            Properties property = new Properties();
            property.load(input);
            this.connection = property.getProperty("connection");
            this.login = property.getProperty("login");
            this.password = property.getProperty("password");
        }
    }

    public String getConnection() {
        return connection;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

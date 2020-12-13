import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        new DataBaseTable().create();
        new DataBaseData().insert();
        new DataBaseAnalyst().getAnalytics();
    }
}

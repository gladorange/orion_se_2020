import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTable {

    public DataBaseTable() {
    }

    public void create() throws SQLException, IOException {
        DataBaseConfig config = new DataBaseConfig();
        config.getProperties();
        try (Connection connection = DriverManager.getConnection(config.getConnection(), config.getLogin(), config.getPassword())) {
            Statement statement = connection.createStatement();
            deleteTablesIfExists(statement);
            createTables(statement);
            addConstraint(statement);
        }
    }

    private void deleteTablesIfExists(Statement statement) throws SQLException {
        statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
        statement.executeUpdate("DROP TABLE IF EXISTS player");
        statement.executeUpdate("DROP TABLE IF EXISTS team");
        statement.executeUpdate("DROP TABLE IF EXISTS goal");
        statement.executeUpdate("DROP TABLE IF EXISTS match_result_type");
        statement.executeUpdate("DROP TABLE IF EXISTS soccer_match");
        statement.executeUpdate("DROP TABLE IF EXISTS period_type");
        statement.executeUpdate("DROP TABLE IF EXISTS soccer_period");
        statement.executeUpdate("DROP TABLE IF EXISTS championship");
        statement.executeUpdate("DROP TABLE IF EXISTS championship_match");
        statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
    }

    public void createTables(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE player (player_id INT NOT NULL AUTO_INCREMENT, player_name VARCHAR(255) NOT NULL, team_id INT NOT NULL, PRIMARY KEY (player_id))");
        statement.executeUpdate("CREATE TABLE team (team_id INT NOT NULL AUTO_INCREMENT, team_name VARCHAR(255) NOT NULL, team_url VARCHAR(255) NOT NULL, PRIMARY KEY (team_id))");
        statement.executeUpdate("CREATE TABLE goal (goal_id INT NOT NULL AUTO_INCREMENT, player_id INT NOT NULL, `goal_time` DATETIME NOT NULL, period_id INT NOT NULL, PRIMARY KEY (goal_id))");
        statement.executeUpdate("CREATE TABLE match_result_type (match_result_type_id INT NOT NULL AUTO_INCREMENT, match_result_type_name VARCHAR(255) NOT NULL, PRIMARY KEY (match_result_type_id))");
        statement.executeUpdate("CREATE TABLE soccer_match (match_id INT NOT NULL AUTO_INCREMENT, first_team_id INT NOT NULL, second_team_id INT NOT NULL, match_result_type_id INT NOT NULL, PRIMARY KEY (match_id))");
        statement.executeUpdate("CREATE TABLE period_type (period_type_id INT NOT NULL AUTO_INCREMENT, period_type_name VARCHAR(255) NOT NULL, PRIMARY KEY (period_type_id))");
        statement.executeUpdate("CREATE TABLE soccer_period (period_id INT NOT NULL AUTO_INCREMENT, period_type_id INT NOT NULL, main_time INT NOT NULL, extra_time INT NOT NULL, match_id INT NOT NULL, PRIMARY KEY (period_id))");
        statement.executeUpdate("CREATE TABLE championship (championship_id INT NOT NULL AUTO_INCREMENT, championship_name VARCHAR(255) NOT NULL, PRIMARY KEY (championship_id))");
        statement.executeUpdate("CREATE TABLE championship_match (championship_id INT NOT NULL, match_id INT NOT NULL);");
    }

    public void addConstraint(Statement statement) throws SQLException {
        statement.executeUpdate("ALTER TABLE player ADD CONSTRAINT player_fk0 FOREIGN KEY (team_id) REFERENCES team(team_id)");
        statement.executeUpdate("ALTER TABLE goal ADD CONSTRAINT goal_fk0 FOREIGN KEY (player_id) REFERENCES player(player_id)");
        statement.executeUpdate("ALTER TABLE goal ADD CONSTRAINT goal_fk1 FOREIGN KEY (period_id) REFERENCES soccer_period(period_id)");
        statement.executeUpdate("ALTER TABLE soccer_match ADD CONSTRAINT match_fk0 FOREIGN KEY (first_team_id) REFERENCES team(team_id)");
        statement.executeUpdate("ALTER TABLE soccer_match ADD CONSTRAINT match_fk1 FOREIGN KEY (second_team_id) REFERENCES team(team_id)");
        statement.executeUpdate("ALTER TABLE soccer_period ADD CONSTRAINT period_fk0 FOREIGN KEY (period_type_id) REFERENCES period_type(period_type_id)");
        statement.executeUpdate("ALTER TABLE soccer_period ADD CONSTRAINT period_fk1 FOREIGN KEY (match_id) REFERENCES soccer_match(match_id)");
        statement.executeUpdate("ALTER TABLE championship_match ADD CONSTRAINT championship_match_fk0 FOREIGN KEY (championship_id) REFERENCES championship(championship_id)");
        statement.executeUpdate("ALTER TABLE championship_match ADD CONSTRAINT championship_match_fk1 FOREIGN KEY (match_id) REFERENCES soccer_match(match_id)");
    }
}

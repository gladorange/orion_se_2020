import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DataBaseData {

    public DataBaseData() {
    }

    public void insert() throws SQLException, IOException {
        DataBaseConfig config = new DataBaseConfig();
        config.getProperties();
        try (Connection connection = DriverManager.getConnection(config.getConnection(), config.getLogin(), config.getPassword())) {
            Statement statement = connection.createStatement();
            insertTeamData(statement);
            insertPlayerData(statement);
            insertMatchResultTypeData(statement);
            insertMatchData(statement);
            insertPeriodTypeData(statement);
            insertPeriodData(statement);
            insertGoalData(statement);
            insertChampionshipData(statement);
            insertChampionshipMatchData(statement);
        }
    }

    private void insertTeamData(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO team (team_name, team_url) VALUES('Hobbits', 'hobbits.ru');");
        statement.executeUpdate("INSERT INTO team (team_name, team_url) VALUES('Elves', 'elves.ru');");
        statement.executeUpdate("INSERT INTO team (team_name, team_url) VALUES('Fate', 'fate.ru');");
    }

    private void insertPlayerData(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Олег', 1);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Алексей', 1);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Андрей', 1);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Илья', 1);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Кирилл', 1);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Алфи', 2);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Аарон', 2);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Адам', 2);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Алекс', 2);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Бен', 2);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Арчер', 3);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Сейбер', 3);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Лансер', 3) ");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Райдер', 3);");
        statement.executeUpdate("INSERT INTO player (player_name, team_id) VALUES('Кастер', 3);");
    }


    private void insertMatchResultTypeData(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO match_result_type (match_result_type_name) VALUES ('Победила первая команда');");
        statement.executeUpdate("INSERT INTO match_result_type (match_result_type_name) VALUES ('Победила вторая команда');");
        statement.executeUpdate("INSERT INTO match_result_type (match_result_type_name) VALUES ('Ничья');");
    }

    private void insertMatchData(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO soccer_match (first_team_id, second_team_id, match_result_type_id) VALUES(1, 2, 3);");
        statement.executeUpdate("INSERT INTO soccer_match (first_team_id, second_team_id, match_result_type_id) VALUES(3, 1, 1);");
        statement.executeUpdate("INSERT INTO soccer_match (first_team_id, second_team_id, match_result_type_id) VALUES(3, 2, 1);");
    }

    private void insertPeriodTypeData(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO period_type (period_type_name) VALUES ('Первый тайм');");
        statement.executeUpdate("INSERT INTO period_type (period_type_name) VALUES ('Второй тайм');");
        statement.executeUpdate("INSERT INTO period_type (period_type_name) VALUES ('Первый дополнительный тайм');");
        statement.executeUpdate("INSERT INTO period_type (period_type_name) VALUES ('Второй дополнительный тайм');");
    }

    private void insertPeriodData(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO soccer_period (period_type_id, main_time, extra_time, match_id) VALUES (1, 45, 10, 1);");
        statement.executeUpdate("INSERT INTO soccer_period (period_type_id, main_time, extra_time, match_id) VALUES (2, 45, 5, 3);");
        statement.executeUpdate("INSERT INTO soccer_period (period_type_id, main_time, extra_time, match_id) VALUES (1, 45, 7, 3);");
    }

    private void insertGoalData(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO goal (player_id, goal_time, period_id) VALUES (1, '" + LocalDateTime.of(LocalDate.of(1999, 12, 1), LocalTime.of(12, 4)) + "', 1);");
        statement.executeUpdate("INSERT INTO goal (player_id, goal_time, period_id) VALUES (1, '" + LocalDateTime.of(LocalDate.of(1999, 12, 1), LocalTime.of(11, 55)) + "', 2);");
        statement.executeUpdate("INSERT INTO goal (player_id, goal_time, period_id) VALUES (3, '" + LocalDateTime.of(LocalDate.of(1999, 12, 3), LocalTime.of(14, 15)) + "', 2);");
        statement.executeUpdate("INSERT INTO goal (player_id, goal_time, period_id) VALUES (3, '" + LocalDateTime.of(LocalDate.of(1999, 12, 3), LocalTime.of(12, 15)) + "', 3);");
        statement.executeUpdate("INSERT INTO goal (player_id, goal_time, period_id) VALUES (12, '" + LocalDateTime.of(LocalDate.of(1999, 12, 1), LocalTime.of(12, 2)) + "', 1);");
    }

    private void insertChampionshipData(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO championship (championship_name) VALUES ('Dream League');");
        statement.executeUpdate("INSERT INTO championship (championship_name) VALUES ('International');");
    }

    private void insertChampionshipMatchData(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO championship_match (championship_id, match_id) VALUES (1, 1);");
        statement.executeUpdate("INSERT INTO championship_match (championship_id, match_id) VALUES (1, 2);");
        statement.executeUpdate("INSERT INTO championship_match (championship_id, match_id) VALUES (2, 3);");
    }
}

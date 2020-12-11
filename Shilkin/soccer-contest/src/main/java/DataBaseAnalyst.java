import java.io.IOException;
import java.sql.*;

public class DataBaseAnalyst {

    public DataBaseAnalyst() {
    }

    public void getAnalytics() throws IOException, SQLException {
        DataBaseConfig config = new DataBaseConfig();
        config.getProperties();
        try (Connection connection = DriverManager.getConnection(config.getConnection(), config.getLogin(), config.getPassword())) {
            Statement statement = connection.createStatement();
            getPlayersWhichScoredTheMostGoalsInAllChampionships(statement);
            getPlayersWhichScoredTheMostGoalsInOneMatch(statement);
            getPlayersWhichScoredTheMostGoalsInOneChampionship(statement);
            getMatchWithHighestNumberOfGoalsScored(statement);
            getTheLongestMatch(statement);
            getTheTeamWhichScoredFewestGoals(statement);
            championshipStatistics(statement);
            ChampionshipsInWhichAtLeastTenGoalsWereScored(statement);
        }
    }

    private void getPlayersWhichScoredTheMostGoalsInAllChampionships(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("""
                SELECT goal.player_id, COUNT(goal.player_id) AS num
                FROM goal
                JOIN player ON player.player_id = goal.player_id
                GROUP BY player_id
                HAVING num = (
                SELECT COUNT(player_id) AS total 
                FROM goal 
                GROUP BY player_id 
                ORDER BY total DESC 
                LIMIT 1
                )
                """);
        System.out.println("Игроки, которые забили больше всего голов во всех чемпионатах:");
        while (resultSet.next()) {
            System.out.println("ID игрока: " + resultSet.getString(1) + ", количество забитых голов: " + resultSet.getString(2));
        }
        System.out.println();
    }

    private void getPlayersWhichScoredTheMostGoalsInOneMatch(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("""
                SELECT g.player_id, COUNT(g.player_id)
                FROM goal g
                         LEFT JOIN soccer_period p ON p.period_id = g.period_id
                         LEFT JOIN soccer_match m ON m.match_id = p.period_id
                GROUP BY g.player_id, m.match_id
                ORDER BY COUNT(g.player_id) DESC
                LIMIT 1
                """);
        System.out.println("Игроки, которые забили больше всего голов в одном матче:");
        while (resultSet.next()) {
            System.out.println("ID игрока: " + resultSet.getString(1) + ", количество забитых голов:" + resultSet.getString(2));
        }
        System.out.println();
    }

    private void getPlayersWhichScoredTheMostGoalsInOneChampionship(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("""
                SELECT g.player_id, COUNT(g.player_id)
                FROM goal g
                         LEFT JOIN soccer_period p ON p.period_id = g.period_id
                         LEFT JOIN soccer_match m ON m.match_id = p.period_id
                         LEFT JOIN championship_match cm ON m.match_id = cm.match_id
                GROUP BY g.player_id, m.match_id, cm.championship_id
                ORDER BY COUNT(g.player_id) DESC
                LIMIT 1
                """);
        System.out.println("Игроки, которые забили больше всего голов в одном Чемпионате:");
        while (resultSet.next()) {
            System.out.println("ID игрока: " + resultSet.getString(1) + ", количество забитых голов:" + resultSet.getString(2));
        }
        System.out.println();
    }

    private void getMatchWithHighestNumberOfGoalsScored(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("""
                SELECT m.match_id, COUNT(g.goal_id)
                FROM goal g
                         LEFT JOIN soccer_period p ON p.period_id = g.period_id
                         LEFT JOIN soccer_match m ON m.match_id = p.period_id
                GROUP BY g.player_id, m.match_id
                ORDER BY COUNT(g.goal_id) DESC
                LIMIT 1
                """);
        System.out.println("Самый продолжительный матч: ");
        while (resultSet.next()) {
            System.out.println("ID матча: " + resultSet.getString(1) + ", количество голов: " + resultSet.getString(2));
        }
        System.out.println();
    }

    private void getTheLongestMatch(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("""
                SELECT m.match_id, SUM(p.main_time + p.extra_time)
                       FROM soccer_period p
                                LEFT JOIN soccer_match m ON m.match_id = p.period_id
                       GROUP BY m.match_id
                       ORDER BY SUM(p.main_time + p.extra_time) DESC
                       LIMIT 1
                """);
        System.out.println("матч, с самым большим количеством забитых голов");
        while (resultSet.next()) {
            System.out.println("ID матча: " + resultSet.getString(1) + ", количество минут: " + resultSet.getString(2));
        }
        System.out.println();
    }

    private void getTheTeamWhichScoredFewestGoals(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("""
                SELECT p.team_id, COUNT(g.goal_id)
                FROM player p
                         LEFT JOIN goal g ON g.player_id = p.player_id
                GROUP BY p.team_id
                ORDER BY COUNT(g.goal_id)
                LIMIT 1
                """);
        System.out.println("команда, игроки которой забили меньше всего голов");
        while (resultSet.next()) {
            System.out.println("ID команды: " + resultSet.getString(1) + ", количество голов: " + resultSet.getString(2));
        }
        System.out.println();
    }

    private void championshipStatistics(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("""
                SELECT c.championship_name, COUNT(g.player_id)
                FROM goal g
                         LEFT JOIN soccer_period p ON p.period_id = g.period_id
                         LEFT JOIN soccer_match m ON m.match_id = p.period_id
                         LEFT JOIN championship_match cm ON m.match_id = cm.match_id
                         LEFT JOIN championship c ON cm.championship_id = c.championship_id
                GROUP BY c.championship_name
                ORDER BY COUNT(g.player_id) DESC
                """);
        System.out.println("Статистика по чемпионатам: ");
        while (resultSet.next()) {
            System.out.println("Название чемпионата: " + resultSet.getString(1) + ", количество голов: " + resultSet.getString(2));
        }
        System.out.println();
    }

    private void ChampionshipsInWhichAtLeastTenGoalsWereScored(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("""
                SELECT c.championship_name, COUNT(g.goal_id)
                FROM goal g
                         LEFT JOIN soccer_period p ON p.period_id = g.period_id
                         LEFT JOIN soccer_match m ON m.match_id = p.period_id
                         LEFT JOIN championship_match cm ON m.match_id = cm.match_id
                         LEFT JOIN championship c ON cm.championship_id = c.championship_id
                GROUP BY c.championship_name
                HAVING COUNT(g.goal_id) >= 10
                ORDER BY COUNT(g.goal_id) DESC
                """);
        System.out.println("Чемпионаты, в которых было забито 10 или больше голов: ");
        while (resultSet.next()) {
            System.out.println("Название чемпионата: " + resultSet.getString(1) + ", количество голов: " + resultSet.getString(2));
        }
        System.out.println();
    }
}

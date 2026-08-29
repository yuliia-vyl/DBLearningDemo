package chapter7;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AstronautPostgresDAL {

    private static PostgresConn postgres;

    protected record AstronautMission(
            String missionName, String startDate,
            String endDate, String astronautName ) {};

    public AstronautPostgresDAL(String url, String username, String password) {

        postgres = new PostgresConn(url, username, password);
    }

    public List<String> getGeminiRoster() {
        return getGeminiRoster(20);
    }

    public List<String> getGeminiRoster(int limit) {
        List<String> returnVal = new ArrayList<>();

        String astronautSQL = "SELECT name FROM astronauts LIMIT " + limit;

        try {
            Statement pgStatement = postgres.getConn().createStatement();
            ResultSet geminiAstronauts = pgStatement.executeQuery(astronautSQL);

            while (geminiAstronauts.next()) {
                returnVal.add(geminiAstronauts.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return returnVal;
    }
}

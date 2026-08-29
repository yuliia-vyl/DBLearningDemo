package chapter7;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class GeminiAstronautsRDBMS {

    public static void Main(String[] args) {
        String url = System.getenv("POSTGRES_URL");
        String username = System.getenv("POSTGRES_USER");
        String password = System.getenv("POSTGRES_PASSWORD");

        AstronautPostgresDAL astronautDAL = new AstronautPostgresDAL(url, username, password);

        System.out.println("Project Gemini Astronauts:");
    }
}

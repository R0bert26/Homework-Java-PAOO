import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Config {

    private static Config instance;
    private String color;
    private int weight;
    private boolean isLoaded = false;
    private static final String CONFIG_PATH = "config.json";

    private Config() {
    }

    public static synchronized Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    private void loadConfig() {
        if (!isLoaded) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(CONFIG_PATH)));
                JSONObject json = new JSONObject(content);
                this.color = json.getString("color");
                this.weight = json.getInt("weight");
                isLoaded = true;
            } catch (IOException e) {
                throw new RuntimeException("Eroare la citirea fișierului de configurare: " + e.getMessage());
            }
        }
    }

    public String getColor() {
        loadConfig();
        return color;
    }

    public int getWeight() {
        loadConfig();
        return weight;
    }
}

package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Helper {
    private static Dotenv dotenv;

    // load sekali saat pertama kali dipanggil
    public static Dotenv loadEnv() {
        if (dotenv == null) {
            dotenv = Dotenv.configure()
                           .filename(".env")   // .env.staging / .env.production
                           .load();
            System.out.println("✅ Loaded environment: ");
        }
        return dotenv;
    }

    public static String get(String key) {
        return loadEnv().get(key);
    }
}

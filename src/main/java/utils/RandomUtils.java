package utils;

import com.mifmif.common.regex.Generex;

public class RandomUtils {
    /**
     * Generate a random string based on the given regex.
     * Example: "[a-zA-Z0-9]{8}" generates an 8-character alphanumeric string.
     */
    public static String getRandomString(String regex) {
        Generex generex = new Generex(regex);
        return generex.random();
    }

    /**
     * Convenience method for random alphanumeric string of given length.
     */
    public static String getRandomAlphanumeric(int length) {
        return getRandomString("[a-zA-Z0-9]{" + length + "}");
    }

    /**
     * Convenience method for random numeric string of given length.
     */
    public static String getRandomNumeric(int length) {
        return getRandomString("[0-9]{" + length + "}");
    }
}

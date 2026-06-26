package com.epa.empAuthlogin;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtil {

    public static String hash(String password) {
        try {
            // Use standard SHA-256 algorithm for hashing
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Encode the resulting byte array into a readable string format
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error executing password hash algorithm", e);
        }
    }
}

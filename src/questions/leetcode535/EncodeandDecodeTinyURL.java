package questions.leetcode535;

import java.util.HashMap;
import java.util.Random;

public class EncodeandDecodeTinyURL {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rand = new Random();
    HashMap<String, String> hashmap = new HashMap<>();

    private String keyGen(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<6; i++){
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = keyGen();
        while (hashmap.containsKey(key))
            key = keyGen();
        hashmap.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hashmap.get(shortUrl);
    }

}

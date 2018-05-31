package encode_and_decode_tinyurl;

import java.util.*;

// https://leetcode.com/problems/encode-and-decode-tinyurl/description/
public class Codec {

    private final Random rnd = new Random();
    private final Map<String, String> long2short = new HashMap<>();
    private final Map<String, String> short2long = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = long2short.get(longUrl);
        if (shortUrl == null) {
            while(shortUrl == null || short2long.containsKey(shortUrl)) {
                shortUrl = shortify(longUrl);
            }
            long2short.put(longUrl, shortUrl);
            short2long.put(shortUrl, longUrl);
        }
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return short2long.get(shortUrl);
    }

    private String shortify(String longUrl) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<6; i++) {
            sb.append('a' + rnd.nextInt(26));
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

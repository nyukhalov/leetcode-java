package unique_email_addresses;

import java.util.*;

// https://leetcode.com/problems/unique-email-addresses/
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqEmails = getUniqEmails(emails);
        return uniqEmails.size();
    }

    private Set<String> getUniqEmails(String[] emails) {
        Set<String> uniqEmails = new HashSet<>();
        for (String email: emails) {
            uniqEmails.add(normalize(email));
        }
        return uniqEmails;
    }

    private String normalize(String email) {
        String[] tokens = email.split("@");
        String normLocal = tokens[0].replaceAll("\\.|\\+.*", "");
        return normLocal + tokens[1];
    }
}

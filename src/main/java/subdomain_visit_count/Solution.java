package subdomain_visit_count;

import java.util.*;

// https://leetcode.com/problems/subdomain-visit-count/description/
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> subdomain2visits = new HashMap<>();
        for (String cpd: cpdomains) {
            String[] parts = cpd.split(" ");
            int visits = Integer.parseInt(parts[0]);
            String[] domains = parseSubdomains(parts[1].split("\\."));
            for (String d: domains) {
                int curVisits = subdomain2visits.getOrDefault(d, 0);
                subdomain2visits.put(d, curVisits + visits);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e: subdomain2visits.entrySet()) {
            result.add(e.getValue() + " " + e.getKey());
        }
        return result;
    }

    private String[] parseSubdomains(String[] sds) {
        String[] res = new String[sds.length];
        String acc = null;
        for (int i=sds.length-1; i>=0; i--) {
            if (acc == null) acc = sds[i];
            else acc = sds[i] + "." + acc;
            res[i] = acc;
        }
        return res;
    }
}

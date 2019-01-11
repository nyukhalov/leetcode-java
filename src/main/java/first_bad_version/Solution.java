package first_bad_version;

// https://leetcode.com/problems/first-bad-version/
class VersionControl {
    protected boolean isBadVersion(int v) {
        return true;
    }
}
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int be = 1;
        int en = n;
        int lastBad = n;
        while(be <= en) {
            int mid = be + (en - be) / 2;
            if (isBadVersion(mid)) {
                lastBad = mid;
                en = mid - 1;
            } else {
                be = mid + 1;
            }
        }
        return lastBad;
    }
}

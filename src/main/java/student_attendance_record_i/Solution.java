package student_attendance_record_i;

// https://leetcode.com/problems/student-attendance-record-i/description/
class Solution {
    public boolean checkRecord(String s) {
        int aCnt = 0;
        int lCnt = 0;
        for (char c: s.toCharArray()) {
            if (c == 'L') lCnt++;
            else {
                lCnt = 0;
                if (c == 'A') aCnt++;
            }

            if (aCnt > 1 || lCnt > 2) return false;
        }
        return true;
    }
}

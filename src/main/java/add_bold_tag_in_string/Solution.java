package add_bold_tag_in_string;

import java.util.*;

// https://leetcode.com/problems/add-bold-tag-in-string/
class Solution {
    class Selection {
        int be;
        int en;
        public Selection(int be, int en) {
            this.be = be;
            this.en = en;
        }
    }

    private final Comparator<Selection> comparator = new Comparator<Selection>() {
        public int compare(Selection o1, Selection o2) {
            return Integer.compare(o1.be, o2.be);
        }
    };

    public String addBoldTag(String s, String[] dict) {
        List<Selection> selections = new ArrayList<>();
        for(String d: dict) {
            selections.addAll(findSelections(s, d));
        }
        selections = mergeSelections(selections);
        return wrapInBoldTag(s, selections);
    }

    private List<Selection> findSelections(String s, String d) {
        List<Selection> ret = new ArrayList<>();
        int offset = 0;
        while((offset = s.indexOf(d, offset)) != -1) {
            ret.add(new Selection(offset, offset + d.length() - 1));
            offset += 1;
        }
        return ret;
    }

    private List<Selection> mergeSelections(List<Selection> selections) {
        Collections.sort(selections, comparator);
        List<Selection> ret = new ArrayList<>();
        for (Selection s: selections) {
            if (ret.isEmpty()) {
                ret.add(s);
            } else {
                Selection last = ret.get(ret.size() - 1);
                if (s.be - 1 <= last.en) {
                    last.en = Math.max(last.en, s.en);
                } else {
                    ret.add(s);
                }
            }
        }
        return ret;
    }

    private String wrapInBoldTag(String s, List<Selection> selections) {
        StringBuilder sb = new StringBuilder();
        int offset = 0;
        for (Selection sel: selections) {
            if (offset < sel.be) {
                sb.append(s.substring(offset, sel.be));
            }
            sb.append("<b>");
            sb.append(s.substring(sel.be, sel.en + 1));
            sb.append("</b>");
            offset = sel.en + 1;
        }
        if (offset < s.length()) {
            sb.append(s.substring(offset));
        }
        return sb.toString();
    }
}

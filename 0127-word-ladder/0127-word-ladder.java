class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int lvl = 1;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                char[] cur = q.poll().toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char temp = cur[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cur[j] = c;
                        String next = new String(cur);
                        if (set.contains(next)) {
                            if (next.equals(endWord))
                                return lvl + 1;
                            q.add(next);
                            set.remove(next);
                        }
                    }
                    cur[j] = temp;
                }
            }
            lvl++;
        }
        return 0;

    }
}

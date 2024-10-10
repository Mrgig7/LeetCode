class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> currWords = new HashSet<>(), targetWords = new HashSet<>();
        currWords.add(beginWord);
        targetWords.add(endWord);

        int steps = 1;
        while(!currWords.isEmpty()) {
            Set<String> newWords = new HashSet<>();
            for (String oldWord: currWords) {
                for (int i = 0; i < oldWord.length(); i++) {
                    char[] baseWord = oldWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        baseWord[i] = c;
                        String newWord = String.valueOf(baseWord);
                        if (targetWords.contains(newWord)) {
                            return steps + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            newWords.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }

            if (newWords.size() < targetWords.size()) {
                currWords = newWords;
            }
            else {
                currWords = targetWords;
                targetWords = newWords;
            }
            steps++;
            System.out.println(steps);
        }
        return 0;
    }
}

public class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        TreeMap<Pair, Boolean> map = new TreeMap<>((a, b) -> {
            if (a.first != b.first) {
                return Integer.compare(a.first, b.first);
            }
            return Integer.compare(a.second, b.second);
        });

        for (int i = 0; i < n; i++) {
            map.put(new Pair(nums[i], i), true);
        }

        long ans = 0;

        for (Map.Entry<Pair, Boolean> entry : map.entrySet()) {
            Pair pair = entry.getKey();
            int index = pair.second;
            if (entry.getValue()) {
                ans += pair.first;
                entry.setValue(false);

                if (index - 1 >= 0) {
                    Pair prev = new Pair(nums[index - 1], index - 1);
                    if (map.containsKey(prev) && map.get(prev)) {
                        map.put(prev, false);
                    }
                }
                if (index + 1 < n) {
                    Pair next = new Pair(nums[index + 1], index + 1);
                    if (map.containsKey(next) && map.get(next)) {
                        map.put(next, false);
                    }
                }
            }
        }

        return ans;
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
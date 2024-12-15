class Solution {
    long getSum(int[] nums) {
        long sum = 0;
        for (int n : nums)
            sum += n;
        return sum;
    }

    boolean check(Map<Long, Pair<Integer, Integer>> mp, long val, int pivot, boolean flag) {
        if (flag) {
            return mp.get(val).getValue() >= pivot;
        } else {
            return mp.get(val).getKey() < pivot;
        }
    }

    public int waysToPartition(int[] nums, int k) {
        Map<Long, Pair<Integer, Integer>> mp = new HashMap<>();
        Map<Long, Pair<Integer, Integer>> cnt = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long n = nums[i];
            mp.putIfAbsent(n, new Pair<>(i, 0));
            mp.get(n).setValue(i);
        }

        long totSum = getSum(nums);
        long left = nums[0];
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            long right = totSum - left;
            if (left == right) {
                ans++;
            } else {
                long diff = left - right;
                long num = k - diff;

                if (mp.containsKey(num) && check(mp, num, i, true)) {
                    Pair<Integer, Integer> p = cnt.getOrDefault(num, new Pair<>(0, 0));
                    p.setValue(p.getValue() + 1);
                    cnt.put(num, p);
                }

                diff = right - left;
                num = k - diff;

                if (mp.containsKey(num) && check(mp, num, i, false)) {
                    Pair<Integer, Integer> p = cnt.getOrDefault(num, new Pair<>(0, 0));
                    p.setKey(p.getKey() + 1);
                    cnt.put(num, p);
                }
            }

            left += nums[i];
            Pair<Integer, Integer> p = cnt.getOrDefault((long) nums[i], new Pair<>(0, 0));
            p.setKey(Math.max(p.getKey(), p.getValue()));
            cnt.put((long) nums[i], p);
        }

        int maxi = Integer.MIN_VALUE;
        for (Map.Entry<Long, Pair<Integer, Integer>> e : cnt.entrySet()) {
            maxi = Math.max(maxi, Math.max(e.getValue().getKey(), e.getValue().getValue()));
        }

        return Math.max(maxi, ans);
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

class RandomizedSet {
    private List<Integer> li;
    private Map<Integer, Integer> mp;

    public RandomizedSet() {
        li = new ArrayList<>();
        mp = new HashMap<>();
    }

    public boolean insert(int val) {
        if (mp.containsKey(val)) return false;

        mp.put(val, li.size());
        li.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!mp.containsKey(val)) return false;

        int idx = mp.get(val);
        int le = li.get(li.size() - 1);
        li.set(idx, le);
        mp.put(le, idx);
        mp.remove(val);
        li.remove(li.size() - 1);
        return true;
    }

    public int getRandom() {
        int randomIdx = (int) (Math.random() * li.size());
        return li.get(randomIdx);
    }
}
class MyCircularDeque {
    private int head, t, si, n;
    private final int[] a;
    public MyCircularDeque(int k) {
        a = new int[k];
        n = a.length;
        t = 1;
    }

    public boolean insertFront(int x) {
        if (si == n) return false;
        a[head = ++head % n] = x;
        si++;
        return true;
    }
    
    public boolean insertLast(int x) {
        if (si == n) return false;
        a[t = (--t + n) % n] = x;
        si++;
        return true;
    }
    
    public boolean deleteFront() {
        if (si == 0) return false;
        head = (--head + n) % n;
        si--;
        return true;
    }
    
    public boolean deleteLast() {
        if (si == 0) return false;
        t = ++t % n;
        si--;
        return true;
    }
    
    public int getFront() {
        return si == 0 ? -1 : a[head];
    }
    
    public int getRear() {
        return si == 0 ? -1 : a[t];
    }
    
    public boolean isEmpty() {
        return si == 0;
    }
    
    public boolean isFull() {
        return si == a.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
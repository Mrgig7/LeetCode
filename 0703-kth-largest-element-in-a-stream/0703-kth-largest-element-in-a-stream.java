
public class KthLargest {
  private PriorityQueue<Integer> mp;
  private int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    mp = new PriorityQueue<>(k);
    
    for (int num : nums) {
      add(num);
    }
  }
  
  public int add(int val) {
    if (mp.size() < k) {
      mp.offer(val);
    } else if (val > mp.peek()) {
      mp.poll();
      mp.offer(val);
    }
    return mp.peek();
  }
}

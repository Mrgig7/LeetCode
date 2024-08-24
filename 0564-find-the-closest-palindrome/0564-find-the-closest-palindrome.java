class Solution {
  public String nearestPalindromic(String n) {
    final long[] pal = getpal(n);
    return Math.abs(pal[0] - Long.parseLong(n)) <=
            Math.abs(pal[1] - Long.parseLong(n))
        ? String.valueOf(pal[0])
        : String.valueOf(pal[1]);
  }
  
  private long[] getpal(final String s) {
    final long num = Long.parseLong(s);
    final int n = s.length();
    long[] pal = new long[2];
    final String h = s.substring(0, (n + 1) / 2);
    final String revh = new StringBuilder(h.substring(0, n / 2)).reverse().toString();
    final long can = Long.parseLong(h + revh);

    if (can < num)
      pal[0] = can;
    else {
      final String ph = String.valueOf(Long.parseLong(h) - 1);
      final String rph =
          new StringBuilder(ph.substring(0, Math.min(ph.length(), n / 2)))
              .reverse()
              .toString();
      if (n % 2 == 0 && Long.parseLong(ph) == 0)
        pal[0] = 9;
      else if (n % 2 == 0 && ph.equals("9"))
        pal[0] = Long.parseLong(ph + '9' + rph);
      else
        pal[0] = Long.parseLong(ph + rph);
    }

    if (can > num)
      pal[1] = can;
    else {
      final String nh = String.valueOf(Long.parseLong(h) + 1);
      final String rnh =
          new StringBuilder(nh.substring(0, n / 2)).reverse().toString();
      pal[1] = Long.parseLong(nh + rnh);
    }

    return pal;
  }
}
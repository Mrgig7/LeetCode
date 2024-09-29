class AllOne {
    Bucket mi;
    Bucket ma;
    Bucket ze;

    Map<String, Bucket> cm = new HashMap<>();

    public AllOne() {
        ze = new Bucket(0);
        mi = ze;
        ma = ze;
    }

    public void inc(String key) {
        mt(key);
    }

    private void mt(String key) {
        Bucket cb = cm.getOrDefault(key, ze);
        Bucket nb = cb.gni();

        rf(cb, key);
        at(nb, key);
    }

    private void at(Bucket b, String key) {
        if (b == ze) return;

        cm.put(key, b);

        b.ad(key);
        if (b.pr == ma) {
            ma = b;
        }
    }

    private void rf(Bucket b, String key) {
        if (b == ze) return;

        cm.remove(key);

        b.rm(key);
        if (b.ie()) {
            rm(b);
        }
    }

    public void dec(String key) {
        mp(key);
    }

    private void mp(String key) {
        Bucket cb = cm.get(key);
        Bucket pb = cb.gdp();

        rf(cb, key);
        at(pb, key);
    }

    private void rm(Bucket b) {
        if (b == ze)
            return;
        b.pr.nx = b.nx;
        if (b.nx != null)
            b.nx.pr = b.pr;

        if (b == ma)
            ma = b.pr;

        b.nx = null;
        b.pr = null;
    }

    public String getMaxKey() {
        if (ie()) return "";
        return ma.mb.iterator().next();
    }

    private boolean ie() {
        return mi == ma;
    }

    public String getMinKey() {
        if (ie()) return "";
        return mi.nx.mb.iterator().next();
    }
}

class Bucket {
    final int ct;
    final Set<String> mb;
    Bucket pr;
    Bucket nx;

    Bucket(int ct) {
        this.ct = ct;
        this.mb = new HashSet<>();
        pr = null;
        nx = null;
    }

    public Bucket gni() {
        if (!hin()) {
            Bucket nn = new Bucket(this.ct + 1);
            ia(nn);
        }
        return this.nx;
    }

    private void ia(Bucket b) {
        b.nx = this.nx;
        if (this.nx != null) {
            this.nx.pr = b;
        }
        this.nx = b;
        b.pr = this;
    }

    private boolean hin() {
        return this.nx != null && this.nx.ct == (this.ct + 1);
    }

    public void ad(String m) {
        this.mb.add(m);
    }

    public void rm(String m) {
        this.mb.remove(m);
    }

    public boolean ie() {
        return this.mb.isEmpty();
    }

    public Bucket gdp() {
        if (!hdp()) {
            Bucket np = new Bucket(this.ct - 1);
            ib(np);
        }
        return this.pr;
    }

    private void ib(Bucket b) {
        b.pr = this.pr;
        if (this.pr != null) {
            this.pr.nx = b;
        }
        this.pr = b;
        b.nx = this;
    }

    private boolean hdp() {
        return this.pr != null && this.pr.ct == (this.ct - 1);
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
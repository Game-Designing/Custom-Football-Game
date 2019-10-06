package p019d.p143b.p144a.p146b;

/* renamed from: d.b.a.b.N */
class C6970N implements C7024s {

    /* renamed from: a */
    final /* synthetic */ C6950D f12921a;

    C6970N(C6950D d) {
        this.f12921a = d;
    }

    /* renamed from: a */
    public void mo22553a() {
        if (this.f12921a.f12854R == null) {
            return;
        }
        if (this.f12921a.mo22505l()) {
            this.f12921a.f12854R.setProgress((int) ((((float) this.f12921a.f12844H.getCurrentPosition()) / ((float) this.f12921a.f12844H.getDuration())) * ((float) this.f12921a.f12863g.mo23266H())));
            return;
        }
        this.f12921a.f12854R.setVisibility(8);
    }

    /* renamed from: b */
    public boolean mo22554b() {
        return this.f12921a.mo22505l();
    }
}

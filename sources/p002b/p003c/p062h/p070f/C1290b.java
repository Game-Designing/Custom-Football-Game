package p002b.p003c.p062h.p070f;

/* renamed from: b.c.h.f.b */
/* compiled from: BatchingListUpdateCallback */
public class C1290b implements C1298e {

    /* renamed from: a */
    final C1298e f4098a;

    /* renamed from: b */
    int f4099b = 0;

    /* renamed from: c */
    int f4100c = -1;

    /* renamed from: d */
    int f4101d = -1;

    /* renamed from: e */
    Object f4102e = null;

    public C1290b(C1298e callback) {
        this.f4098a = callback;
    }

    /* renamed from: a */
    public void mo9215a() {
        int i = this.f4099b;
        if (i != 0) {
            if (i == 1) {
                this.f4098a.mo9211a(this.f4100c, this.f4101d);
            } else if (i == 2) {
                this.f4098a.mo9213b(this.f4100c, this.f4101d);
            } else if (i == 3) {
                this.f4098a.mo9212a(this.f4100c, this.f4101d, this.f4102e);
            }
            this.f4102e = null;
            this.f4099b = 0;
        }
    }

    /* renamed from: a */
    public void mo9211a(int position, int count) {
        if (this.f4099b == 1) {
            int i = this.f4100c;
            if (position >= i) {
                int i2 = this.f4101d;
                if (position <= i + i2) {
                    this.f4101d = i2 + count;
                    this.f4100c = Math.min(position, i);
                    return;
                }
            }
        }
        mo9215a();
        this.f4100c = position;
        this.f4101d = count;
        this.f4099b = 1;
    }

    /* renamed from: b */
    public void mo9213b(int position, int count) {
        if (this.f4099b == 2) {
            int i = this.f4100c;
            if (i >= position && i <= position + count) {
                this.f4101d += count;
                this.f4100c = position;
                return;
            }
        }
        mo9215a();
        this.f4100c = position;
        this.f4101d = count;
        this.f4099b = 2;
    }

    /* renamed from: c */
    public void mo9214c(int fromPosition, int toPosition) {
        mo9215a();
        this.f4098a.mo9214c(fromPosition, toPosition);
    }

    /* renamed from: a */
    public void mo9212a(int position, int count, Object payload) {
        if (this.f4099b == 3) {
            int i = this.f4100c;
            int i2 = this.f4101d;
            if (position <= i + i2 && position + count >= i && this.f4102e == payload) {
                int previousEnd = i2 + i;
                this.f4100c = Math.min(position, i);
                this.f4101d = Math.max(previousEnd, position + count) - this.f4100c;
                return;
            }
        }
        mo9215a();
        this.f4100c = position;
        this.f4101d = count;
        this.f4102e = payload;
        this.f4099b = 3;
    }
}

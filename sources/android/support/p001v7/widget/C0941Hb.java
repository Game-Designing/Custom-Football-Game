package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0975f.C0978c;
import android.support.p001v7.widget.RecyclerView.C1000w;
import p002b.p003c.p053g.p061f.C1253b;
import p002b.p003c.p053g.p061f.C1259h;
import p002b.p003c.p053g.p061f.C1269m;
import p002b.p003c.p053g.p061f.C1270n;

/* renamed from: android.support.v7.widget.Hb */
/* compiled from: ViewInfoStore */
class C0941Hb {

    /* renamed from: a */
    final C1253b<C1000w, C0942a> f2998a = new C1253b<>();

    /* renamed from: b */
    final C1259h<C1000w> f2999b = new C1259h<>();

    /* renamed from: android.support.v7.widget.Hb$a */
    /* compiled from: ViewInfoStore */
    static class C0942a {

        /* renamed from: a */
        static C1269m<C0942a> f3000a = new C1270n(20);

        /* renamed from: b */
        int f3001b;

        /* renamed from: c */
        C0978c f3002c;

        /* renamed from: d */
        C0978c f3003d;

        private C0942a() {
        }

        /* renamed from: b */
        static C0942a m4528b() {
            C0942a record = (C0942a) f3000a.mo9148a();
            return record == null ? new C0942a() : record;
        }

        /* renamed from: a */
        static void m4527a(C0942a record) {
            record.f3001b = 0;
            record.f3002c = null;
            record.f3003d = null;
            f3000a.mo9149a(record);
        }

        /* renamed from: a */
        static void m4526a() {
            do {
            } while (f3000a.mo9148a() != null);
        }
    }

    /* renamed from: android.support.v7.widget.Hb$b */
    /* compiled from: ViewInfoStore */
    interface C0943b {
        /* renamed from: a */
        void mo7213a(C1000w wVar);

        /* renamed from: a */
        void mo7214a(C1000w wVar, C0978c cVar, C0978c cVar2);

        /* renamed from: b */
        void mo7215b(C1000w wVar, C0978c cVar, C0978c cVar2);

        /* renamed from: c */
        void mo7216c(C1000w wVar, C0978c cVar, C0978c cVar2);
    }

    C0941Hb() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7310a() {
        this.f2998a.clear();
        this.f2999b.mo9054a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo7318c(C1000w holder, C0978c info) {
        C0942a record = (C0942a) this.f2998a.get(holder);
        if (record == null) {
            record = C0942a.m4528b();
            this.f2998a.put(holder, record);
        }
        record.f3002c = info;
        record.f3001b |= 4;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo7317b(C1000w holder) {
        C0942a record = (C0942a) this.f2998a.get(holder);
        return (record == null || (record.f3001b & 1) == 0) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C0978c mo7322f(C1000w vh) {
        return m4509a(vh, 4);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C0978c mo7321e(C1000w vh) {
        return m4509a(vh, 8);
    }

    /* renamed from: a */
    private C0978c m4509a(C1000w vh, int flag) {
        C0978c info;
        int index = this.f2998a.mo9151a((Object) vh);
        if (index < 0) {
            return null;
        }
        C0942a record = (C0942a) this.f2998a.mo9162d(index);
        if (record != null) {
            int i = record.f3001b;
            if ((i & flag) != 0) {
                record.f3001b = (flag ^ -1) & i;
                if (flag == 4) {
                    info = record.f3002c;
                } else if (flag == 8) {
                    info = record.f3003d;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((record.f3001b & 12) == 0) {
                    this.f2998a.mo9158c(index);
                    C0942a.m4527a(record);
                }
                return info;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7311a(long key, C1000w holder) {
        this.f2999b.mo9063c(key, holder);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7314a(C1000w holder, C0978c info) {
        C0942a record = (C0942a) this.f2998a.get(holder);
        if (record == null) {
            record = C0942a.m4528b();
            this.f2998a.put(holder, record);
        }
        record.f3001b |= 2;
        record.f3002c = info;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo7319c(C1000w viewHolder) {
        C0942a record = (C0942a) this.f2998a.get(viewHolder);
        return (record == null || (record.f3001b & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1000w mo7309a(long key) {
        return (C1000w) this.f2999b.mo9058b(key);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7316b(C1000w holder, C0978c info) {
        C0942a record = (C0942a) this.f2998a.get(holder);
        if (record == null) {
            record = C0942a.m4528b();
            this.f2998a.put(holder, record);
        }
        record.f3003d = info;
        record.f3001b |= 8;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7313a(C1000w holder) {
        C0942a record = (C0942a) this.f2998a.get(holder);
        if (record == null) {
            record = C0942a.m4528b();
            this.f2998a.put(holder, record);
        }
        record.f3001b |= 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo7323g(C1000w holder) {
        C0942a record = (C0942a) this.f2998a.get(holder);
        if (record != null) {
            record.f3001b &= -2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7312a(C0943b callback) {
        for (int index = this.f2998a.size() - 1; index >= 0; index--) {
            C1000w viewHolder = (C1000w) this.f2998a.mo9157b(index);
            C0942a record = (C0942a) this.f2998a.mo9158c(index);
            int i = record.f3001b;
            if ((i & 3) == 3) {
                callback.mo7213a(viewHolder);
            } else if ((i & 1) != 0) {
                C0978c cVar = record.f3002c;
                if (cVar == null) {
                    callback.mo7213a(viewHolder);
                } else {
                    callback.mo7215b(viewHolder, cVar, record.f3003d);
                }
            } else if ((i & 14) == 14) {
                callback.mo7214a(viewHolder, record.f3002c, record.f3003d);
            } else if ((i & 12) == 12) {
                callback.mo7216c(viewHolder, record.f3002c, record.f3003d);
            } else if ((i & 4) != 0) {
                callback.mo7215b(viewHolder, record.f3002c, null);
            } else if ((i & 8) != 0) {
                callback.mo7214a(viewHolder, record.f3002c, record.f3003d);
            }
            C0942a.m4527a(record);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo7324h(C1000w holder) {
        int i = this.f2999b.mo9057b() - 1;
        while (true) {
            if (i < 0) {
                break;
            } else if (holder == this.f2999b.mo9062c(i)) {
                this.f2999b.mo9060b(i);
                break;
            } else {
                i--;
            }
        }
        C0942a info = (C0942a) this.f2998a.remove(holder);
        if (info != null) {
            C0942a.m4527a(info);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7315b() {
        C0942a.m4526a();
    }

    /* renamed from: d */
    public void mo7320d(C1000w viewHolder) {
        mo7323g(viewHolder);
    }
}

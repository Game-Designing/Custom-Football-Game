package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C1000w;
import java.util.ArrayList;
import java.util.List;
import p002b.p003c.p053g.p061f.C1269m;
import p002b.p003c.p053g.p061f.C1270n;

/* renamed from: android.support.v7.widget.j */
/* compiled from: AdapterHelper */
class C1068j implements C1136a {

    /* renamed from: a */
    private C1269m<C1070b> f3531a;

    /* renamed from: b */
    final ArrayList<C1070b> f3532b;

    /* renamed from: c */
    final ArrayList<C1070b> f3533c;

    /* renamed from: d */
    final C1069a f3534d;

    /* renamed from: e */
    Runnable f3535e;

    /* renamed from: f */
    final boolean f3536f;

    /* renamed from: g */
    final C1135ya f3537g;

    /* renamed from: h */
    private int f3538h;

    /* renamed from: android.support.v7.widget.j$a */
    /* compiled from: AdapterHelper */
    interface C1069a {
        /* renamed from: a */
        C1000w mo7300a(int i);

        /* renamed from: a */
        void mo7301a(int i, int i2);

        /* renamed from: a */
        void mo7302a(int i, int i2, Object obj);

        /* renamed from: a */
        void mo7303a(C1070b bVar);

        /* renamed from: b */
        void mo7304b(int i, int i2);

        /* renamed from: b */
        void mo7305b(C1070b bVar);

        /* renamed from: c */
        void mo7306c(int i, int i2);

        /* renamed from: d */
        void mo7308d(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.j$b */
    /* compiled from: AdapterHelper */
    static class C1070b {

        /* renamed from: a */
        int f3539a;

        /* renamed from: b */
        int f3540b;

        /* renamed from: c */
        Object f3541c;

        /* renamed from: d */
        int f3542d;

        C1070b(int cmd, int positionStart, int itemCount, Object payload) {
            this.f3539a = cmd;
            this.f3540b = positionStart;
            this.f3542d = itemCount;
            this.f3541c = payload;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo8484a() {
            int i = this.f3539a;
            if (i == 1) {
                return "add";
            }
            if (i == 2) {
                return "rm";
            }
            if (i == 4) {
                return "up";
            }
            if (i != 8) {
                return "??";
            }
            return "mv";
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            sb.append(mo8484a());
            sb.append(",s:");
            sb.append(this.f3540b);
            sb.append("c:");
            sb.append(this.f3542d);
            sb.append(",p:");
            sb.append(this.f3541c);
            sb.append("]");
            return sb.toString();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            C1070b op = (C1070b) o;
            int i = this.f3539a;
            if (i != op.f3539a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f3542d - this.f3540b) == 1 && this.f3542d == op.f3540b && this.f3540b == op.f3542d) {
                return true;
            }
            if (this.f3542d != op.f3542d || this.f3540b != op.f3540b) {
                return false;
            }
            Object obj = this.f3541c;
            if (obj != null) {
                if (!obj.equals(op.f3541c)) {
                    return false;
                }
            } else if (op.f3541c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f3539a * 31) + this.f3540b) * 31) + this.f3542d;
        }
    }

    C1068j(C1069a callback) {
        this(callback, false);
    }

    C1068j(C1069a callback, boolean disableRecycler) {
        this.f3531a = new C1270n(30);
        this.f3532b = new ArrayList<>();
        this.f3533c = new ArrayList<>();
        this.f3538h = 0;
        this.f3534d = callback;
        this.f3536f = disableRecycler;
        this.f3537g = new C1135ya(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo8483f() {
        mo8472a((List<C1070b>) this.f3532b);
        mo8472a((List<C1070b>) this.f3533c);
        this.f3538h = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8482e() {
        this.f3537g.mo8734a(this.f3532b);
        int count = this.f3532b.size();
        for (int i = 0; i < count; i++) {
            C1070b op = (C1070b) this.f3532b.get(i);
            int i2 = op.f3539a;
            if (i2 == 1) {
                m5276b(op);
            } else if (i2 == 2) {
                m5279d(op);
            } else if (i2 == 4) {
                m5281e(op);
            } else if (i2 == 8) {
                m5277c(op);
            }
            Runnable runnable = this.f3535e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f3532b.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8469a() {
        int count = this.f3533c.size();
        for (int i = 0; i < count; i++) {
            this.f3534d.mo7303a((C1070b) this.f3533c.get(i));
        }
        mo8472a((List<C1070b>) this.f3533c);
        this.f3538h = 0;
    }

    /* renamed from: c */
    private void m5277c(C1070b op) {
        m5283g(op);
    }

    /* renamed from: d */
    private void m5279d(C1070b op) {
        int tmpStart = op.f3540b;
        int tmpCount = 0;
        int tmpEnd = op.f3540b + op.f3542d;
        int type = -1;
        int position = op.f3540b;
        while (position < tmpEnd) {
            boolean typeChanged = false;
            if (this.f3534d.mo7300a(position) != null || m5280d(position)) {
                if (type == 0) {
                    m5282f(mo8468a(2, tmpStart, tmpCount, null));
                    typeChanged = true;
                }
                type = 1;
            } else {
                if (type == 1) {
                    m5283g(mo8468a(2, tmpStart, tmpCount, null));
                    typeChanged = true;
                }
                type = 0;
            }
            if (typeChanged) {
                position -= tmpCount;
                tmpEnd -= tmpCount;
                tmpCount = 1;
            } else {
                tmpCount++;
            }
            position++;
        }
        if (tmpCount != op.f3542d) {
            mo8470a(op);
            op = mo8468a(2, tmpStart, tmpCount, null);
        }
        if (type == 0) {
            m5282f(op);
        } else {
            m5283g(op);
        }
    }

    /* renamed from: e */
    private void m5281e(C1070b op) {
        int tmpStart = op.f3540b;
        int tmpCount = 0;
        int tmpEnd = op.f3540b + op.f3542d;
        int type = -1;
        for (int position = op.f3540b; position < tmpEnd; position++) {
            if (this.f3534d.mo7300a(position) != null || m5280d(position)) {
                if (type == 0) {
                    m5282f(mo8468a(4, tmpStart, tmpCount, op.f3541c));
                    tmpCount = 0;
                    tmpStart = position;
                }
                type = 1;
            } else {
                if (type == 1) {
                    m5283g(mo8468a(4, tmpStart, tmpCount, op.f3541c));
                    tmpCount = 0;
                    tmpStart = position;
                }
                type = 0;
            }
            tmpCount++;
        }
        if (tmpCount != op.f3542d) {
            Object payload = op.f3541c;
            mo8470a(op);
            op = mo8468a(4, tmpStart, tmpCount, payload);
        }
        if (type == 0) {
            m5282f(op);
        } else {
            m5283g(op);
        }
    }

    /* renamed from: f */
    private void m5282f(C1070b op) {
        int positionMultiplier;
        int i = op.f3539a;
        if (i == 1 || i == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int tmpStart = m5278d(op.f3540b, i);
        int tmpCnt = 1;
        int offsetPositionForPartial = op.f3540b;
        int i2 = op.f3539a;
        if (i2 == 2) {
            positionMultiplier = 0;
        } else if (i2 == 4) {
            positionMultiplier = 1;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("op should be remove or update.");
            sb.append(op);
            throw new IllegalArgumentException(sb.toString());
        }
        for (int p = 1; p < op.f3542d; p++) {
            int updatedPos = m5278d(op.f3540b + (positionMultiplier * p), op.f3539a);
            boolean continuous = false;
            int i3 = op.f3539a;
            boolean z = false;
            if (i3 == 2) {
                if (updatedPos == tmpStart) {
                    z = true;
                }
                continuous = z;
            } else if (i3 == 4) {
                if (updatedPos == tmpStart + 1) {
                    z = true;
                }
                continuous = z;
            }
            if (continuous) {
                tmpCnt++;
            } else {
                C1070b tmp = mo8468a(op.f3539a, tmpStart, tmpCnt, op.f3541c);
                mo8471a(tmp, offsetPositionForPartial);
                mo8470a(tmp);
                if (op.f3539a == 4) {
                    offsetPositionForPartial += tmpCnt;
                }
                tmpStart = updatedPos;
                tmpCnt = 1;
            }
        }
        Object payload = op.f3541c;
        mo8470a(op);
        if (tmpCnt > 0) {
            C1070b tmp2 = mo8468a(op.f3539a, tmpStart, tmpCnt, payload);
            mo8471a(tmp2, offsetPositionForPartial);
            mo8470a(tmp2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8471a(C1070b op, int offsetStart) {
        this.f3534d.mo7305b(op);
        int i = op.f3539a;
        if (i == 2) {
            this.f3534d.mo7308d(offsetStart, op.f3542d);
        } else if (i == 4) {
            this.f3534d.mo7302a(offsetStart, op.f3542d, op.f3541c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* renamed from: d */
    private int m5278d(int pos, int cmd) {
        int end;
        int start;
        for (int i = this.f3533c.size() - 1; i >= 0; i--) {
            C1070b postponed = (C1070b) this.f3533c.get(i);
            int i2 = postponed.f3539a;
            if (i2 == 8) {
                if (postponed.f3540b < postponed.f3542d) {
                    start = postponed.f3540b;
                    end = postponed.f3542d;
                } else {
                    start = postponed.f3542d;
                    end = postponed.f3540b;
                }
                if (pos < start || pos > end) {
                    int i3 = postponed.f3540b;
                    if (pos < i3) {
                        if (cmd == 1) {
                            postponed.f3540b = i3 + 1;
                            postponed.f3542d++;
                        } else if (cmd == 2) {
                            postponed.f3540b = i3 - 1;
                            postponed.f3542d--;
                        }
                    }
                } else {
                    int i4 = postponed.f3540b;
                    if (start == i4) {
                        if (cmd == 1) {
                            postponed.f3542d++;
                        } else if (cmd == 2) {
                            postponed.f3542d--;
                        }
                        pos++;
                    } else {
                        if (cmd == 1) {
                            postponed.f3540b = i4 + 1;
                        } else if (cmd == 2) {
                            postponed.f3540b = i4 - 1;
                        }
                        pos--;
                    }
                }
            } else {
                int i5 = postponed.f3540b;
                if (i5 <= pos) {
                    if (i2 == 1) {
                        pos -= postponed.f3542d;
                    } else if (i2 == 2) {
                        pos += postponed.f3542d;
                    }
                } else if (cmd == 1) {
                    postponed.f3540b = i5 + 1;
                } else if (cmd == 2) {
                    postponed.f3540b = i5 - 1;
                }
            }
        }
        for (int i6 = this.f3533c.size() - 1; i6 >= 0; i6--) {
            C1070b op = (C1070b) this.f3533c.get(i6);
            if (op.f3539a == 8) {
                int i7 = op.f3542d;
                if (i7 == op.f3540b || i7 < 0) {
                    this.f3533c.remove(i6);
                    mo8470a(op);
                }
            } else if (op.f3542d <= 0) {
                this.f3533c.remove(i6);
                mo8470a(op);
            }
        }
        return pos;
    }

    /* renamed from: d */
    private boolean m5280d(int position) {
        int count = this.f3533c.size();
        for (int i = 0; i < count; i++) {
            C1070b op = (C1070b) this.f3533c.get(i);
            int i2 = op.f3539a;
            if (i2 == 8) {
                if (mo8467a(op.f3542d, i + 1) == position) {
                    return true;
                }
            } else if (i2 == 1) {
                int end = op.f3540b + op.f3542d;
                for (int pos = op.f3540b; pos < end; pos++) {
                    if (mo8467a(pos, i + 1) == position) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m5276b(C1070b op) {
        m5283g(op);
    }

    /* renamed from: g */
    private void m5283g(C1070b op) {
        this.f3533c.add(op);
        int i = op.f3539a;
        if (i == 1) {
            this.f3534d.mo7306c(op.f3540b, op.f3542d);
        } else if (i == 2) {
            this.f3534d.mo7304b(op.f3540b, op.f3542d);
        } else if (i == 4) {
            this.f3534d.mo7302a(op.f3540b, op.f3542d, op.f3541c);
        } else if (i == 8) {
            this.f3534d.mo7301a(op.f3540b, op.f3542d);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown update op type for ");
            sb.append(op);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo8478c() {
        return this.f3532b.size() > 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo8479c(int updateTypes) {
        return (this.f3538h & updateTypes) != 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo8475b(int position) {
        return mo8467a(position, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo8467a(int position, int firstPostponedItem) {
        int count = this.f3533c.size();
        for (int i = firstPostponedItem; i < count; i++) {
            C1070b op = (C1070b) this.f3533c.get(i);
            int i2 = op.f3539a;
            if (i2 == 8) {
                int i3 = op.f3540b;
                if (i3 == position) {
                    position = op.f3542d;
                } else {
                    if (i3 < position) {
                        position--;
                    }
                    if (op.f3542d <= position) {
                        position++;
                    }
                }
            } else {
                int i4 = op.f3540b;
                if (i4 > position) {
                    continue;
                } else if (i2 == 2) {
                    int i5 = op.f3542d;
                    if (position < i4 + i5) {
                        return -1;
                    }
                    position -= i5;
                } else if (i2 == 1) {
                    position += op.f3542d;
                }
            }
        }
        return position;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8474a(int positionStart, int itemCount, Object payload) {
        boolean z = false;
        if (itemCount < 1) {
            return false;
        }
        this.f3532b.add(mo8468a(4, positionStart, itemCount, payload));
        this.f3538h |= 4;
        if (this.f3532b.size() == 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo8477b(int positionStart, int itemCount) {
        boolean z = false;
        if (itemCount < 1) {
            return false;
        }
        this.f3532b.add(mo8468a(1, positionStart, itemCount, null));
        this.f3538h |= 1;
        if (this.f3532b.size() == 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo8480c(int positionStart, int itemCount) {
        boolean z = false;
        if (itemCount < 1) {
            return false;
        }
        this.f3532b.add(mo8468a(2, positionStart, itemCount, null));
        this.f3538h |= 2;
        if (this.f3532b.size() == 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8473a(int from, int to, int itemCount) {
        boolean z = false;
        if (from == to) {
            return false;
        }
        if (itemCount == 1) {
            this.f3532b.add(mo8468a(8, from, to, null));
            this.f3538h |= 8;
            if (this.f3532b.size() == 1) {
                z = true;
            }
            return z;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8476b() {
        mo8469a();
        int count = this.f3532b.size();
        for (int i = 0; i < count; i++) {
            C1070b op = (C1070b) this.f3532b.get(i);
            int i2 = op.f3539a;
            if (i2 == 1) {
                this.f3534d.mo7303a(op);
                this.f3534d.mo7306c(op.f3540b, op.f3542d);
            } else if (i2 == 2) {
                this.f3534d.mo7303a(op);
                this.f3534d.mo7308d(op.f3540b, op.f3542d);
            } else if (i2 == 4) {
                this.f3534d.mo7303a(op);
                this.f3534d.mo7302a(op.f3540b, op.f3542d, op.f3541c);
            } else if (i2 == 8) {
                this.f3534d.mo7303a(op);
                this.f3534d.mo7301a(op.f3540b, op.f3542d);
            }
            Runnable runnable = this.f3535e;
            if (runnable != null) {
                runnable.run();
            }
        }
        mo8472a((List<C1070b>) this.f3532b);
        this.f3538h = 0;
    }

    /* renamed from: a */
    public int mo8466a(int position) {
        int size = this.f3532b.size();
        for (int i = 0; i < size; i++) {
            C1070b op = (C1070b) this.f3532b.get(i);
            int i2 = op.f3539a;
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = op.f3540b;
                    if (i3 <= position) {
                        int i4 = op.f3542d;
                        if (i3 + i4 > position) {
                            return -1;
                        }
                        position -= i4;
                    } else {
                        continue;
                    }
                } else if (i2 == 8) {
                    int i5 = op.f3540b;
                    if (i5 == position) {
                        position = op.f3542d;
                    } else {
                        if (i5 < position) {
                            position--;
                        }
                        if (op.f3542d <= position) {
                            position++;
                        }
                    }
                }
            } else if (op.f3540b <= position) {
                position += op.f3542d;
            }
        }
        return position;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo8481d() {
        return !this.f3533c.isEmpty() && !this.f3532b.isEmpty();
    }

    /* renamed from: a */
    public C1070b mo8468a(int cmd, int positionStart, int itemCount, Object payload) {
        C1070b op = (C1070b) this.f3531a.mo9148a();
        if (op == null) {
            return new C1070b(cmd, positionStart, itemCount, payload);
        }
        op.f3539a = cmd;
        op.f3540b = positionStart;
        op.f3542d = itemCount;
        op.f3541c = payload;
        return op;
    }

    /* renamed from: a */
    public void mo8470a(C1070b op) {
        if (!this.f3536f) {
            op.f3541c = null;
            this.f3531a.mo9149a(op);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8472a(List<C1070b> ops) {
        int count = ops.size();
        for (int i = 0; i < count; i++) {
            mo8470a((C1070b) ops.get(i));
        }
        ops.clear();
    }
}

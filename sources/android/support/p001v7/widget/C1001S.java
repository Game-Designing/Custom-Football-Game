package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.S */
/* compiled from: ChildHelper */
class C1001S {

    /* renamed from: a */
    final C1003b f3241a;

    /* renamed from: b */
    final C1002a f3242b = new C1002a();

    /* renamed from: c */
    final List<View> f3243c = new ArrayList();

    /* renamed from: android.support.v7.widget.S$a */
    /* compiled from: ChildHelper */
    static class C1002a {

        /* renamed from: a */
        long f3244a = 0;

        /* renamed from: b */
        C1002a f3245b;

        C1002a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo8022e(int index) {
            if (index >= 64) {
                m4976b();
                this.f3245b.mo8022e(index - 64);
                return;
            }
            this.f3244a |= 1 << index;
        }

        /* renamed from: b */
        private void m4976b() {
            if (this.f3245b == null) {
                this.f3245b = new C1002a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8017a(int index) {
            if (index >= 64) {
                C1002a aVar = this.f3245b;
                if (aVar != null) {
                    aVar.mo8017a(index - 64);
                    return;
                }
                return;
            }
            this.f3244a &= (1 << index) ^ -1;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo8020c(int index) {
            if (index >= 64) {
                m4976b();
                return this.f3245b.mo8020c(index - 64);
            }
            return (this.f3244a & (1 << index)) != 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8016a() {
            this.f3244a = 0;
            C1002a aVar = this.f3245b;
            if (aVar != null) {
                aVar.mo8016a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8018a(int index, boolean value) {
            if (index >= 64) {
                m4976b();
                this.f3245b.mo8018a(index - 64, value);
                return;
            }
            boolean lastBit = (this.f3244a & Long.MIN_VALUE) != 0;
            long mask = (1 << index) - 1;
            long j = this.f3244a;
            this.f3244a = (j & mask) | ((j & (-1 ^ mask)) << 1);
            if (value) {
                mo8022e(index);
            } else {
                mo8017a(index);
            }
            if (lastBit || this.f3245b != null) {
                m4976b();
                this.f3245b.mo8018a(0, lastBit);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public boolean mo8021d(int index) {
            if (index >= 64) {
                m4976b();
                return this.f3245b.mo8021d(index - 64);
            }
            long mask = 1 << index;
            boolean value = (this.f3244a & mask) != 0;
            this.f3244a &= mask ^ -1;
            long mask2 = mask - 1;
            long j = this.f3244a;
            this.f3244a = (j & mask2) | Long.rotateRight(j & (-1 ^ mask2), 1);
            C1002a aVar = this.f3245b;
            if (aVar != null) {
                if (aVar.mo8020c(0)) {
                    mo8022e(63);
                }
                this.f3245b.mo8021d(0);
            }
            return value;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo8019b(int index) {
            C1002a aVar = this.f3245b;
            if (aVar == null) {
                if (index >= 64) {
                    return Long.bitCount(this.f3244a);
                }
                return Long.bitCount(this.f3244a & ((1 << index) - 1));
            } else if (index < 64) {
                return Long.bitCount(this.f3244a & ((1 << index) - 1));
            } else {
                return aVar.mo8019b(index - 64) + Long.bitCount(this.f3244a);
            }
        }

        public String toString() {
            if (this.f3245b == null) {
                return Long.toBinaryString(this.f3244a);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3245b.toString());
            sb.append("xx");
            sb.append(Long.toBinaryString(this.f3244a));
            return sb.toString();
        }
    }

    /* renamed from: android.support.v7.widget.S$b */
    /* compiled from: ChildHelper */
    interface C1003b {
        /* renamed from: a */
        int mo7222a();

        /* renamed from: a */
        View mo7223a(int i);

        /* renamed from: a */
        void mo7224a(View view);

        /* renamed from: a */
        void mo7225a(View view, int i);

        /* renamed from: a */
        void mo7226a(View view, int i, LayoutParams layoutParams);

        /* renamed from: b */
        C1000w mo7227b(View view);

        /* renamed from: b */
        void mo7228b();

        /* renamed from: b */
        void mo7229b(int i);

        /* renamed from: c */
        int mo7230c(View view);

        /* renamed from: c */
        void mo7231c(int i);

        /* renamed from: d */
        void mo7232d(View view);
    }

    C1001S(C1003b callback) {
        this.f3241a = callback;
    }

    /* renamed from: g */
    private void m4957g(View child) {
        this.f3243c.add(child);
        this.f3241a.mo7224a(child);
    }

    /* renamed from: h */
    private boolean m4958h(View child) {
        if (!this.f3243c.remove(child)) {
            return false;
        }
        this.f3241a.mo7232d(child);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8003a(View child, boolean hidden) {
        mo8002a(child, -1, hidden);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8002a(View child, int index, boolean hidden) {
        int offset;
        if (index < 0) {
            offset = this.f3241a.mo7222a();
        } else {
            offset = m4956f(index);
        }
        this.f3242b.mo8018a(offset, hidden);
        if (hidden) {
            m4957g(child);
        }
        this.f3241a.mo7225a(child, offset);
    }

    /* renamed from: f */
    private int m4956f(int index) {
        if (index < 0) {
            return -1;
        }
        int limit = this.f3241a.mo7222a();
        int offset = index;
        while (offset < limit) {
            int diff = index - (offset - this.f3242b.mo8019b(offset));
            if (diff == 0) {
                while (this.f3242b.mo8020c(offset)) {
                    offset++;
                }
                return offset;
            }
            offset += diff;
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8011d(View view) {
        int index = this.f3241a.mo7230c(view);
        if (index >= 0) {
            if (this.f3242b.mo8021d(index)) {
                m4958h(view);
            }
            this.f3241a.mo7231c(index);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8012e(int index) {
        int offset = m4956f(index);
        View view = this.f3241a.mo7223a(offset);
        if (view != null) {
            if (this.f3242b.mo8021d(offset)) {
                m4958h(view);
            }
            this.f3241a.mo7231c(offset);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public View mo8007c(int index) {
        return this.f3241a.mo7223a(m4956f(index));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8008c() {
        this.f3242b.mo8016a();
        for (int i = this.f3243c.size() - 1; i >= 0; i--) {
            this.f3241a.mo7232d((View) this.f3243c.get(i));
            this.f3243c.remove(i);
        }
        this.f3241a.mo7228b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public View mo8006b(int position) {
        int count = this.f3243c.size();
        for (int i = 0; i < count; i++) {
            View view = (View) this.f3243c.get(i);
            C1000w holder = this.f3241a.mo7227b(view);
            if (holder.getLayoutPosition() == position && !holder.isInvalid() && !holder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8001a(View child, int index, LayoutParams layoutParams, boolean hidden) {
        int offset;
        if (index < 0) {
            offset = this.f3241a.mo7222a();
        } else {
            offset = m4956f(index);
        }
        this.f3242b.mo8018a(offset, hidden);
        if (hidden) {
            m4957g(child);
        }
        this.f3241a.mo7226a(child, offset, layoutParams);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo7998a() {
        return this.f3241a.mo7222a() - this.f3243c.size();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo8004b() {
        return this.f3241a.mo7222a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public View mo8010d(int index) {
        return this.f3241a.mo7223a(index);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7999a(int index) {
        int offset = m4956f(index);
        this.f3242b.mo8021d(offset);
        this.f3241a.mo7229b(offset);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo8005b(View child) {
        int index = this.f3241a.mo7230c(child);
        if (index != -1 && !this.f3242b.mo8020c(index)) {
            return index - this.f3242b.mo8019b(index);
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo8009c(View view) {
        return this.f3243c.contains(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8000a(View view) {
        int offset = this.f3241a.mo7230c(view);
        if (offset >= 0) {
            this.f3242b.mo8022e(offset);
            m4957g(view);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("view is not a child, cannot hide ");
        sb.append(view);
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo8014f(View view) {
        int offset = this.f3241a.mo7230c(view);
        if (offset < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("view is not a child, cannot hide ");
            sb.append(view);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f3242b.mo8020c(offset)) {
            this.f3242b.mo8017a(offset);
            m4958h(view);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("trying to unhide a view that was not hidden");
            sb2.append(view);
            throw new RuntimeException(sb2.toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3242b.toString());
        sb.append(", hidden list:");
        sb.append(this.f3243c.size());
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo8013e(View view) {
        int index = this.f3241a.mo7230c(view);
        if (index == -1) {
            m4958h(view);
            return true;
        } else if (!this.f3242b.mo8020c(index)) {
            return false;
        } else {
            this.f3242b.mo8021d(index);
            m4958h(view);
            this.f3241a.mo7231c(index);
            return true;
        }
    }
}

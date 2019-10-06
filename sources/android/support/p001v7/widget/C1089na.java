package android.support.p001v7.widget;

import android.support.p000v4.p037os.C0574d;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0981i.C0982a;
import android.support.p001v7.widget.RecyclerView.C0991p;
import android.support.p001v7.widget.RecyclerView.C1000w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: android.support.v7.widget.na */
/* compiled from: GapWorker */
final class C1089na implements Runnable {

    /* renamed from: a */
    static final ThreadLocal<C1089na> f3620a = new ThreadLocal<>();

    /* renamed from: b */
    static Comparator<C1091b> f3621b = new C1086ma();

    /* renamed from: c */
    ArrayList<RecyclerView> f3622c = new ArrayList<>();

    /* renamed from: d */
    long f3623d;

    /* renamed from: e */
    long f3624e;

    /* renamed from: f */
    private ArrayList<C1091b> f3625f = new ArrayList<>();

    /* renamed from: android.support.v7.widget.na$a */
    /* compiled from: GapWorker */
    static class C1090a implements C0982a {

        /* renamed from: a */
        int f3626a;

        /* renamed from: b */
        int f3627b;

        /* renamed from: c */
        int[] f3628c;

        /* renamed from: d */
        int f3629d;

        C1090a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo8550b(int dx, int dy) {
            this.f3626a = dx;
            this.f3627b = dy;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8548a(RecyclerView view, boolean nested) {
            this.f3629d = 0;
            int[] iArr = this.f3628c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            C0981i layout = view.f3166w;
            if (view.f3164v != null && layout != null && layout.isItemPrefetchEnabled()) {
                if (nested) {
                    if (!view.f3148n.mo8478c()) {
                        layout.collectInitialPrefetchPositions(view.f3164v.getItemCount(), this);
                    }
                } else if (!view.mo7628l()) {
                    layout.collectAdjacentPrefetchPositions(this.f3626a, this.f3627b, view.f3157ra, this);
                }
                int i = this.f3629d;
                if (i > layout.mPrefetchMaxCountObserved) {
                    layout.mPrefetchMaxCountObserved = i;
                    layout.mPrefetchMaxObservedInInitialPrefetch = nested;
                    view.f3144l.mo7921j();
                }
            }
        }

        /* renamed from: a */
        public void mo7863a(int layoutPosition, int pixelDistance) {
            if (layoutPosition < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (pixelDistance >= 0) {
                int storagePosition = this.f3629d * 2;
                int[] iArr = this.f3628c;
                if (iArr == null) {
                    this.f3628c = new int[4];
                    Arrays.fill(this.f3628c, -1);
                } else if (storagePosition >= iArr.length) {
                    int[] oldArray = this.f3628c;
                    this.f3628c = new int[(storagePosition * 2)];
                    System.arraycopy(oldArray, 0, this.f3628c, 0, oldArray.length);
                }
                int[] oldArray2 = this.f3628c;
                oldArray2[storagePosition] = layoutPosition;
                oldArray2[storagePosition + 1] = pixelDistance;
                this.f3629d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo8549a(int position) {
            if (this.f3628c != null) {
                int count = this.f3629d * 2;
                for (int i = 0; i < count; i += 2) {
                    if (this.f3628c[i] == position) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8547a() {
            int[] iArr = this.f3628c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3629d = 0;
        }
    }

    /* renamed from: android.support.v7.widget.na$b */
    /* compiled from: GapWorker */
    static class C1091b {

        /* renamed from: a */
        public boolean f3630a;

        /* renamed from: b */
        public int f3631b;

        /* renamed from: c */
        public int f3632c;

        /* renamed from: d */
        public RecyclerView f3633d;

        /* renamed from: e */
        public int f3634e;

        C1091b() {
        }

        /* renamed from: a */
        public void mo8551a() {
            this.f3630a = false;
            this.f3631b = 0;
            this.f3632c = 0;
            this.f3633d = null;
            this.f3634e = 0;
        }
    }

    C1089na() {
    }

    /* renamed from: a */
    public void mo8543a(RecyclerView recyclerView) {
        this.f3622c.add(recyclerView);
    }

    /* renamed from: b */
    public void mo8545b(RecyclerView recyclerView) {
        boolean remove = this.f3622c.remove(recyclerView);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8544a(RecyclerView recyclerView, int prefetchDx, int prefetchDy) {
        if (recyclerView.isAttachedToWindow() && this.f3623d == 0) {
            this.f3623d = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f3155qa.mo8550b(prefetchDx, prefetchDy);
    }

    /* renamed from: a */
    private void m5384a() {
        C1091b task;
        int viewCount = this.f3622c.size();
        int totalTaskCount = 0;
        for (int i = 0; i < viewCount; i++) {
            RecyclerView view = (RecyclerView) this.f3622c.get(i);
            if (view.getWindowVisibility() == 0) {
                view.f3155qa.mo8548a(view, false);
                totalTaskCount += view.f3155qa.f3629d;
            }
        }
        this.f3625f.ensureCapacity(totalTaskCount);
        int totalTaskIndex = 0;
        for (int i2 = 0; i2 < viewCount; i2++) {
            RecyclerView view2 = (RecyclerView) this.f3622c.get(i2);
            if (view2.getWindowVisibility() == 0) {
                C1090a prefetchRegistry = view2.f3155qa;
                int viewVelocity = Math.abs(prefetchRegistry.f3626a) + Math.abs(prefetchRegistry.f3627b);
                for (int j = 0; j < prefetchRegistry.f3629d * 2; j += 2) {
                    if (totalTaskIndex >= this.f3625f.size()) {
                        task = new C1091b();
                        this.f3625f.add(task);
                    } else {
                        task = (C1091b) this.f3625f.get(totalTaskIndex);
                    }
                    int distanceToItem = prefetchRegistry.f3628c[j + 1];
                    task.f3630a = distanceToItem <= viewVelocity;
                    task.f3631b = viewVelocity;
                    task.f3632c = distanceToItem;
                    task.f3633d = view2;
                    task.f3634e = prefetchRegistry.f3628c[j];
                    totalTaskIndex++;
                }
            }
        }
        Collections.sort(this.f3625f, f3621b);
    }

    /* renamed from: a */
    static boolean m5387a(RecyclerView view, int position) {
        int childCount = view.f3150o.mo8004b();
        for (int i = 0; i < childCount; i++) {
            C1000w holder = RecyclerView.m4736j(view.f3150o.mo8010d(i));
            if (holder.mPosition == position && !holder.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private C1000w m5383a(RecyclerView view, int position, long deadlineNs) {
        if (m5387a(view, position)) {
            return null;
        }
        C0991p recycler = view.f3144l;
        try {
            view.mo7678t();
            C1000w holder = recycler.mo7889a(position, false, deadlineNs);
            if (holder != null) {
                try {
                    if (!holder.isBound() || holder.isInvalid()) {
                        recycler.mo7898a(holder, false);
                    } else {
                        recycler.mo7905b(holder.itemView);
                    }
                } catch (Throwable th) {
                    th = th;
                    view.mo7536a(false);
                    throw th;
                }
            }
            view.mo7536a(false);
            return holder;
        } catch (Throwable th2) {
            th = th2;
            view.mo7536a(false);
            throw th;
        }
    }

    /* renamed from: a */
    private void m5385a(RecyclerView innerView, long deadlineNs) {
        if (innerView != null) {
            if (innerView.f3122N && innerView.f3150o.mo8004b() != 0) {
                innerView.mo7681w();
            }
            C1090a innerPrefetchRegistry = innerView.f3155qa;
            innerPrefetchRegistry.mo8548a(innerView, true);
            if (innerPrefetchRegistry.f3629d != 0) {
                try {
                    C0574d.m2755a("RV Nested Prefetch");
                    innerView.f3157ra.mo7947a(innerView.f3164v);
                    for (int i = 0; i < innerPrefetchRegistry.f3629d * 2; i += 2) {
                        m5383a(innerView, innerPrefetchRegistry.f3628c[i], deadlineNs);
                    }
                } finally {
                    C0574d.m2754a();
                }
            }
        }
    }

    /* renamed from: a */
    private void m5386a(C1091b task, long deadlineNs) {
        C1000w holder = m5383a(task.f3633d, task.f3634e, task.f3630a ? Long.MAX_VALUE : deadlineNs);
        if (holder != null && holder.mNestedRecyclerView != null && holder.isBound() && !holder.isInvalid()) {
            m5385a((RecyclerView) holder.mNestedRecyclerView.get(), deadlineNs);
        }
    }

    /* renamed from: b */
    private void m5388b(long deadlineNs) {
        int i = 0;
        while (i < this.f3625f.size()) {
            C1091b task = (C1091b) this.f3625f.get(i);
            if (task.f3633d != null) {
                m5386a(task, deadlineNs);
                task.mo8551a();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8542a(long deadlineNs) {
        m5384a();
        m5388b(deadlineNs);
    }

    public void run() {
        try {
            C0574d.m2755a("RV Prefetch");
            if (!this.f3622c.isEmpty()) {
                int size = this.f3622c.size();
                long latestFrameVsyncMs = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView view = (RecyclerView) this.f3622c.get(i);
                    if (view.getWindowVisibility() == 0) {
                        latestFrameVsyncMs = Math.max(view.getDrawingTime(), latestFrameVsyncMs);
                    }
                }
                if (latestFrameVsyncMs == 0) {
                    this.f3623d = 0;
                    C0574d.m2754a();
                    return;
                }
                mo8542a(TimeUnit.MILLISECONDS.toNanos(latestFrameVsyncMs) + this.f3624e);
                this.f3623d = 0;
                C0574d.m2754a();
            }
        } finally {
            this.f3623d = 0;
            C0574d.m2754a();
        }
    }
}

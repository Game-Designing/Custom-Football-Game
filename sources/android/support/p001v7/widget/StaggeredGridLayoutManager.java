package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.view.p038a.C0604b;
import android.support.p000v4.view.p038a.C0604b.C0606b;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0981i.C0982a;
import android.support.p001v7.widget.RecyclerView.C0981i.C0983b;
import android.support.p001v7.widget.RecyclerView.C0984j;
import android.support.p001v7.widget.RecyclerView.C0991p;
import android.support.p001v7.widget.RecyclerView.C0994s.C0996b;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* renamed from: android.support.v7.widget.StaggeredGridLayoutManager */
public class StaggeredGridLayoutManager extends C0981i implements C0996b {

    /* renamed from: a */
    private int f3278a = -1;

    /* renamed from: b */
    C1015c[] f3279b;

    /* renamed from: c */
    C0916Ba f3280c;

    /* renamed from: d */
    C0916Ba f3281d;

    /* renamed from: e */
    private int f3282e;

    /* renamed from: f */
    private int f3283f;

    /* renamed from: g */
    private final C1094oa f3284g;

    /* renamed from: h */
    boolean f3285h = false;

    /* renamed from: i */
    boolean f3286i = false;

    /* renamed from: j */
    private BitSet f3287j;

    /* renamed from: k */
    int f3288k = -1;

    /* renamed from: l */
    int f3289l = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: m */
    LazySpanLookup f3290m = new LazySpanLookup();

    /* renamed from: n */
    private int f3291n = 2;

    /* renamed from: o */
    private boolean f3292o;

    /* renamed from: p */
    private boolean f3293p;

    /* renamed from: q */
    private SavedState f3294q;

    /* renamed from: r */
    private int f3295r;

    /* renamed from: s */
    private final Rect f3296s = new Rect();

    /* renamed from: t */
    private final C1013a f3297t = new C1013a();

    /* renamed from: u */
    private boolean f3298u = false;

    /* renamed from: v */
    private boolean f3299v = true;

    /* renamed from: w */
    private int[] f3300w;

    /* renamed from: x */
    private final Runnable f3301x = new C1067ib(this);

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup */
    static class LazySpanLookup {

        /* renamed from: a */
        int[] f3302a;

        /* renamed from: b */
        List<FullSpanItem> f3303b;

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem */
        static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new C1074jb();

            /* renamed from: a */
            int f3304a;

            /* renamed from: b */
            int f3305b;

            /* renamed from: c */
            int[] f3306c;

            /* renamed from: d */
            boolean f3307d;

            FullSpanItem(Parcel in) {
                this.f3304a = in.readInt();
                this.f3305b = in.readInt();
                boolean z = true;
                if (in.readInt() != 1) {
                    z = false;
                }
                this.f3307d = z;
                int spanCount = in.readInt();
                if (spanCount > 0) {
                    this.f3306c = new int[spanCount];
                    in.readIntArray(this.f3306c);
                }
            }

            FullSpanItem() {
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public int mo8148a(int spanIndex) {
                int[] iArr = this.f3306c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[spanIndex];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.f3304a);
                dest.writeInt(this.f3305b);
                dest.writeInt(this.f3307d ? 1 : 0);
                int[] iArr = this.f3306c;
                if (iArr == null || iArr.length <= 0) {
                    dest.writeInt(0);
                    return;
                }
                dest.writeInt(iArr.length);
                dest.writeIntArray(this.f3306c);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("FullSpanItem{mPosition=");
                sb.append(this.f3304a);
                sb.append(", mGapDir=");
                sb.append(this.f3305b);
                sb.append(", mHasUnwantedGapAfter=");
                sb.append(this.f3307d);
                sb.append(", mGapPerSpan=");
                sb.append(Arrays.toString(this.f3306c));
                sb.append('}');
                return sb.toString();
            }
        }

        LazySpanLookup() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo8142b(int position) {
            List<FullSpanItem> list = this.f3303b;
            if (list != null) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (((FullSpanItem) this.f3303b.get(i)).f3304a >= position) {
                        this.f3303b.remove(i);
                    }
                }
            }
            return mo8146e(position);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public int mo8146e(int position) {
            int[] iArr = this.f3302a;
            if (iArr == null || position >= iArr.length) {
                return -1;
            }
            int endPosition = m5062g(position);
            if (endPosition == -1) {
                int[] iArr2 = this.f3302a;
                Arrays.fill(iArr2, position, iArr2.length, -1);
                return this.f3302a.length;
            }
            Arrays.fill(this.f3302a, position, endPosition + 1, -1);
            return endPosition + 1;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public int mo8145d(int position) {
            int[] iArr = this.f3302a;
            if (iArr == null || position >= iArr.length) {
                return -1;
            }
            return iArr[position];
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8140a(int position, C1015c span) {
            mo8138a(position);
            this.f3302a[position] = span.f3331e;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public int mo8147f(int position) {
            int len = this.f3302a.length;
            while (len <= position) {
                len *= 2;
            }
            return len;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8138a(int position) {
            int[] iArr = this.f3302a;
            if (iArr == null) {
                this.f3302a = new int[(Math.max(position, 10) + 1)];
                Arrays.fill(this.f3302a, -1);
            } else if (position >= iArr.length) {
                int[] old = this.f3302a;
                this.f3302a = new int[mo8147f(position)];
                System.arraycopy(old, 0, this.f3302a, 0, old.length);
                int[] iArr2 = this.f3302a;
                Arrays.fill(iArr2, old.length, iArr2.length, -1);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8137a() {
            int[] iArr = this.f3302a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3303b = null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo8143b(int positionStart, int itemCount) {
            int[] iArr = this.f3302a;
            if (iArr != null && positionStart < iArr.length) {
                mo8138a(positionStart + itemCount);
                int[] iArr2 = this.f3302a;
                System.arraycopy(iArr2, positionStart + itemCount, iArr2, positionStart, (iArr2.length - positionStart) - itemCount);
                int[] iArr3 = this.f3302a;
                Arrays.fill(iArr3, iArr3.length - itemCount, iArr3.length, -1);
                m5061d(positionStart, itemCount);
            }
        }

        /* renamed from: d */
        private void m5061d(int positionStart, int itemCount) {
            List<FullSpanItem> list = this.f3303b;
            if (list != null) {
                int end = positionStart + itemCount;
                for (int i = list.size() - 1; i >= 0; i--) {
                    FullSpanItem fsi = (FullSpanItem) this.f3303b.get(i);
                    int i2 = fsi.f3304a;
                    if (i2 >= positionStart) {
                        if (i2 < end) {
                            this.f3303b.remove(i);
                        } else {
                            fsi.f3304a = i2 - itemCount;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8139a(int positionStart, int itemCount) {
            int[] iArr = this.f3302a;
            if (iArr != null && positionStart < iArr.length) {
                mo8138a(positionStart + itemCount);
                int[] iArr2 = this.f3302a;
                System.arraycopy(iArr2, positionStart, iArr2, positionStart + itemCount, (iArr2.length - positionStart) - itemCount);
                Arrays.fill(this.f3302a, positionStart, positionStart + itemCount, -1);
                m5060c(positionStart, itemCount);
            }
        }

        /* renamed from: c */
        private void m5060c(int positionStart, int itemCount) {
            List<FullSpanItem> list = this.f3303b;
            if (list != null) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    FullSpanItem fsi = (FullSpanItem) this.f3303b.get(i);
                    int i2 = fsi.f3304a;
                    if (i2 >= positionStart) {
                        fsi.f3304a = i2 + itemCount;
                    }
                }
            }
        }

        /* renamed from: g */
        private int m5062g(int position) {
            if (this.f3303b == null) {
                return -1;
            }
            FullSpanItem item = mo8144c(position);
            if (item != null) {
                this.f3303b.remove(item);
            }
            int nextFsiIndex = -1;
            int count = this.f3303b.size();
            int i = 0;
            while (true) {
                if (i >= count) {
                    break;
                } else if (((FullSpanItem) this.f3303b.get(i)).f3304a >= position) {
                    nextFsiIndex = i;
                    break;
                } else {
                    i++;
                }
            }
            if (nextFsiIndex == -1) {
                return -1;
            }
            FullSpanItem fsi = (FullSpanItem) this.f3303b.get(nextFsiIndex);
            this.f3303b.remove(nextFsiIndex);
            return fsi.f3304a;
        }

        /* renamed from: a */
        public void mo8141a(FullSpanItem fullSpanItem) {
            if (this.f3303b == null) {
                this.f3303b = new ArrayList();
            }
            int size = this.f3303b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem other = (FullSpanItem) this.f3303b.get(i);
                if (other.f3304a == fullSpanItem.f3304a) {
                    this.f3303b.remove(i);
                }
                if (other.f3304a >= fullSpanItem.f3304a) {
                    this.f3303b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f3303b.add(fullSpanItem);
        }

        /* renamed from: c */
        public FullSpanItem mo8144c(int position) {
            List<FullSpanItem> list = this.f3303b;
            if (list == null) {
                return null;
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                FullSpanItem fsi = (FullSpanItem) this.f3303b.get(i);
                if (fsi.f3304a == position) {
                    return fsi;
                }
            }
            return null;
        }

        /* renamed from: a */
        public FullSpanItem mo8136a(int minPos, int maxPos, int gapDir, boolean hasUnwantedGapAfter) {
            List<FullSpanItem> list = this.f3303b;
            if (list == null) {
                return null;
            }
            int limit = list.size();
            for (int i = 0; i < limit; i++) {
                FullSpanItem fsi = (FullSpanItem) this.f3303b.get(i);
                int i2 = fsi.f3304a;
                if (i2 >= maxPos) {
                    return null;
                }
                if (i2 >= minPos && (gapDir == 0 || fsi.f3305b == gapDir || (hasUnwantedGapAfter && fsi.f3307d))) {
                    return fsi;
                }
            }
            return null;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$SavedState */
    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C1078kb();

        /* renamed from: a */
        int f3308a;

        /* renamed from: b */
        int f3309b;

        /* renamed from: c */
        int f3310c;

        /* renamed from: d */
        int[] f3311d;

        /* renamed from: e */
        int f3312e;

        /* renamed from: f */
        int[] f3313f;

        /* renamed from: g */
        List<FullSpanItem> f3314g;

        /* renamed from: h */
        boolean f3315h;

        /* renamed from: i */
        boolean f3316i;

        /* renamed from: j */
        boolean f3317j;

        public SavedState() {
        }

        SavedState(Parcel in) {
            this.f3308a = in.readInt();
            this.f3309b = in.readInt();
            this.f3310c = in.readInt();
            int i = this.f3310c;
            if (i > 0) {
                this.f3311d = new int[i];
                in.readIntArray(this.f3311d);
            }
            this.f3312e = in.readInt();
            int i2 = this.f3312e;
            if (i2 > 0) {
                this.f3313f = new int[i2];
                in.readIntArray(this.f3313f);
            }
            boolean z = false;
            this.f3315h = in.readInt() == 1;
            this.f3316i = in.readInt() == 1;
            if (in.readInt() == 1) {
                z = true;
            }
            this.f3317j = z;
            this.f3314g = in.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState other) {
            this.f3310c = other.f3310c;
            this.f3308a = other.f3308a;
            this.f3309b = other.f3309b;
            this.f3311d = other.f3311d;
            this.f3312e = other.f3312e;
            this.f3313f = other.f3313f;
            this.f3315h = other.f3315h;
            this.f3316i = other.f3316i;
            this.f3317j = other.f3317j;
            this.f3314g = other.f3314g;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo8153b() {
            this.f3311d = null;
            this.f3310c = 0;
            this.f3312e = 0;
            this.f3313f = null;
            this.f3314g = null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8152a() {
            this.f3311d = null;
            this.f3310c = 0;
            this.f3308a = -1;
            this.f3309b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.f3308a);
            dest.writeInt(this.f3309b);
            dest.writeInt(this.f3310c);
            if (this.f3310c > 0) {
                dest.writeIntArray(this.f3311d);
            }
            dest.writeInt(this.f3312e);
            if (this.f3312e > 0) {
                dest.writeIntArray(this.f3313f);
            }
            dest.writeInt(this.f3315h ? 1 : 0);
            dest.writeInt(this.f3316i ? 1 : 0);
            dest.writeInt(this.f3317j ? 1 : 0);
            dest.writeList(this.f3314g);
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$a */
    class C1013a {

        /* renamed from: a */
        int f3318a;

        /* renamed from: b */
        int f3319b;

        /* renamed from: c */
        boolean f3320c;

        /* renamed from: d */
        boolean f3321d;

        /* renamed from: e */
        boolean f3322e;

        /* renamed from: f */
        int[] f3323f;

        C1013a() {
            mo8159b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo8159b() {
            this.f3318a = -1;
            this.f3319b = LinearLayoutManager.INVALID_OFFSET;
            this.f3320c = false;
            this.f3321d = false;
            this.f3322e = false;
            int[] iArr = this.f3323f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8158a(C1015c[] spans) {
            int spanCount = spans.length;
            int[] iArr = this.f3323f;
            if (iArr == null || iArr.length < spanCount) {
                this.f3323f = new int[StaggeredGridLayoutManager.this.f3279b.length];
            }
            for (int i = 0; i < spanCount; i++) {
                this.f3323f[i] = spans[i].mo8169b((int) LinearLayoutManager.INVALID_OFFSET);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8156a() {
            int i;
            if (this.f3320c) {
                i = StaggeredGridLayoutManager.this.f3280c.mo6969b();
            } else {
                i = StaggeredGridLayoutManager.this.f3280c.mo6977f();
            }
            this.f3319b = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8157a(int addedDistance) {
            if (this.f3320c) {
                this.f3319b = StaggeredGridLayoutManager.this.f3280c.mo6969b() - addedDistance;
            } else {
                this.f3319b = StaggeredGridLayoutManager.this.f3280c.mo6977f() + addedDistance;
            }
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$b */
    public static class C1014b extends C0984j {

        /* renamed from: e */
        C1015c f3325e;

        /* renamed from: f */
        boolean f3326f;

        public C1014b(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public C1014b(int width, int height) {
            super(width, height);
        }

        public C1014b(MarginLayoutParams source) {
            super(source);
        }

        public C1014b(LayoutParams source) {
            super(source);
        }

        /* renamed from: f */
        public boolean mo8161f() {
            return this.f3326f;
        }

        /* renamed from: e */
        public final int mo8160e() {
            C1015c cVar = this.f3325e;
            if (cVar == null) {
                return -1;
            }
            return cVar.f3331e;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$c */
    class C1015c {

        /* renamed from: a */
        ArrayList<View> f3327a = new ArrayList<>();

        /* renamed from: b */
        int f3328b = LinearLayoutManager.INVALID_OFFSET;

        /* renamed from: c */
        int f3329c = LinearLayoutManager.INVALID_OFFSET;

        /* renamed from: d */
        int f3330d = 0;

        /* renamed from: e */
        final int f3331e;

        C1015c(int index) {
            this.f3331e = index;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo8169b(int def) {
            int i = this.f3328b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            if (this.f3327a.size() == 0) {
                return def;
            }
            mo8171b();
            return this.f3328b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo8171b() {
            View startView = (View) this.f3327a.get(0);
            C1014b lp = mo8170b(startView);
            this.f3328b = StaggeredGridLayoutManager.this.f3280c.mo6974d(startView);
            if (lp.f3326f) {
                FullSpanItem fsi = StaggeredGridLayoutManager.this.f3290m.mo8144c(lp.mo7864a());
                if (fsi != null && fsi.f3305b == -1) {
                    this.f3328b -= fsi.mo8148a(this.f3331e);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public int mo8180h() {
            int i = this.f3328b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            mo8171b();
            return this.f3328b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo8162a(int def) {
            int i = this.f3329c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            if (this.f3327a.size() == 0) {
                return def;
            }
            mo8166a();
            return this.f3329c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8166a() {
            ArrayList<View> arrayList = this.f3327a;
            View endView = (View) arrayList.get(arrayList.size() - 1);
            C1014b lp = mo8170b(endView);
            this.f3329c = StaggeredGridLayoutManager.this.f3280c.mo6967a(endView);
            if (lp.f3326f) {
                FullSpanItem fsi = StaggeredGridLayoutManager.this.f3290m.mo8144c(lp.mo7864a());
                if (fsi != null && fsi.f3305b == 1) {
                    this.f3329c += fsi.mo8148a(this.f3331e);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public int mo8179g() {
            int i = this.f3329c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            mo8166a();
            return this.f3329c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo8174c(View view) {
            C1014b lp = mo8170b(view);
            lp.f3325e = this;
            this.f3327a.add(0, view);
            this.f3328b = LinearLayoutManager.INVALID_OFFSET;
            if (this.f3327a.size() == 1) {
                this.f3329c = LinearLayoutManager.INVALID_OFFSET;
            }
            if (lp.mo7866c() || lp.mo7865b()) {
                this.f3330d += StaggeredGridLayoutManager.this.f3280c.mo6970b(view);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8167a(View view) {
            C1014b lp = mo8170b(view);
            lp.f3325e = this;
            this.f3327a.add(view);
            this.f3329c = LinearLayoutManager.INVALID_OFFSET;
            if (this.f3327a.size() == 1) {
                this.f3328b = LinearLayoutManager.INVALID_OFFSET;
            }
            if (lp.mo7866c() || lp.mo7865b()) {
                this.f3330d += StaggeredGridLayoutManager.this.f3280c.mo6970b(view);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8168a(boolean reverseLayout, int offset) {
            int reference;
            if (reverseLayout) {
                reference = mo8162a((int) LinearLayoutManager.INVALID_OFFSET);
            } else {
                reference = mo8169b((int) LinearLayoutManager.INVALID_OFFSET);
            }
            mo8172c();
            if (reference != Integer.MIN_VALUE) {
                if ((!reverseLayout || reference >= StaggeredGridLayoutManager.this.f3280c.mo6969b()) && (reverseLayout || reference <= StaggeredGridLayoutManager.this.f3280c.mo6977f())) {
                    if (offset != Integer.MIN_VALUE) {
                        reference += offset;
                    }
                    this.f3329c = reference;
                    this.f3328b = reference;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo8172c() {
            this.f3327a.clear();
            mo8181i();
            this.f3330d = 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: i */
        public void mo8181i() {
            this.f3328b = LinearLayoutManager.INVALID_OFFSET;
            this.f3329c = LinearLayoutManager.INVALID_OFFSET;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo8176d(int line) {
            this.f3328b = line;
            this.f3329c = line;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: j */
        public void mo8182j() {
            int size = this.f3327a.size();
            View end = (View) this.f3327a.remove(size - 1);
            C1014b lp = mo8170b(end);
            lp.f3325e = null;
            if (lp.mo7866c() || lp.mo7865b()) {
                this.f3330d -= StaggeredGridLayoutManager.this.f3280c.mo6970b(end);
            }
            if (size == 1) {
                this.f3328b = LinearLayoutManager.INVALID_OFFSET;
            }
            this.f3329c = LinearLayoutManager.INVALID_OFFSET;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: k */
        public void mo8183k() {
            View start = (View) this.f3327a.remove(0);
            C1014b lp = mo8170b(start);
            lp.f3325e = null;
            if (this.f3327a.size() == 0) {
                this.f3329c = LinearLayoutManager.INVALID_OFFSET;
            }
            if (lp.mo7866c() || lp.mo7865b()) {
                this.f3330d -= StaggeredGridLayoutManager.this.f3280c.mo6970b(start);
            }
            this.f3328b = LinearLayoutManager.INVALID_OFFSET;
        }

        /* renamed from: f */
        public int mo8178f() {
            return this.f3330d;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1014b mo8170b(View view) {
            return (C1014b) view.getLayoutParams();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo8173c(int dt) {
            int i = this.f3328b;
            if (i != Integer.MIN_VALUE) {
                this.f3328b = i + dt;
            }
            int i2 = this.f3329c;
            if (i2 != Integer.MIN_VALUE) {
                this.f3329c = i2 + dt;
            }
        }

        /* renamed from: d */
        public int mo8175d() {
            if (StaggeredGridLayoutManager.this.f3285h) {
                return mo8163a(this.f3327a.size() - 1, -1, true);
            }
            return mo8163a(0, this.f3327a.size(), true);
        }

        /* renamed from: e */
        public int mo8177e() {
            if (StaggeredGridLayoutManager.this.f3285h) {
                return mo8163a(0, this.f3327a.size(), true);
            }
            return mo8163a(this.f3327a.size() - 1, -1, true);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo8164a(int fromIndex, int toIndex, boolean completelyVisible, boolean acceptCompletelyVisible, boolean acceptEndPointInclusion) {
            int i = toIndex;
            int start = StaggeredGridLayoutManager.this.f3280c.mo6977f();
            int end = StaggeredGridLayoutManager.this.f3280c.mo6969b();
            int next = i > fromIndex ? 1 : -1;
            for (int i2 = fromIndex; i2 != i; i2 += next) {
                View child = (View) this.f3327a.get(i2);
                int childStart = StaggeredGridLayoutManager.this.f3280c.mo6974d(child);
                int childEnd = StaggeredGridLayoutManager.this.f3280c.mo6967a(child);
                boolean childEndInclusion = false;
                boolean childStartInclusion = !acceptEndPointInclusion ? childStart < end : childStart <= end;
                if (!acceptEndPointInclusion ? childEnd > start : childEnd >= start) {
                    childEndInclusion = true;
                }
                if (childStartInclusion && childEndInclusion) {
                    if (!completelyVisible || !acceptCompletelyVisible) {
                        if (acceptCompletelyVisible) {
                            return StaggeredGridLayoutManager.this.getPosition(child);
                        }
                        if (childStart < start || childEnd > end) {
                            return StaggeredGridLayoutManager.this.getPosition(child);
                        }
                    } else if (childStart >= start && childEnd <= end) {
                        return StaggeredGridLayoutManager.this.getPosition(child);
                    }
                }
            }
            return -1;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo8163a(int fromIndex, int toIndex, boolean acceptEndPointInclusion) {
            return mo8164a(fromIndex, toIndex, false, false, acceptEndPointInclusion);
        }

        /* renamed from: a */
        public View mo8165a(int referenceChildPosition, int layoutDir) {
            View candidate = null;
            if (layoutDir != -1) {
                for (int i = this.f3327a.size() - 1; i >= 0; i--) {
                    View view = (View) this.f3327a.get(i);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f3285h && staggeredGridLayoutManager.getPosition(view) >= referenceChildPosition) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f3285h && staggeredGridLayoutManager2.getPosition(view) <= referenceChildPosition) || !view.hasFocusable()) {
                        break;
                    }
                    candidate = view;
                }
            } else {
                int limit = this.f3327a.size();
                for (int i2 = 0; i2 < limit; i2++) {
                    View view2 = (View) this.f3327a.get(i2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f3285h && staggeredGridLayoutManager3.getPosition(view2) <= referenceChildPosition) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f3285h && staggeredGridLayoutManager4.getPosition(view2) >= referenceChildPosition) || !view2.hasFocusable()) {
                        break;
                    }
                    candidate = view2;
                }
            }
            return candidate;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        C0983b properties = C0981i.getProperties(context, attrs, defStyleAttr, defStyleRes);
        setOrientation(properties.f3186a);
        setSpanCount(properties.f3187b);
        setReverseLayout(properties.f3188c);
        this.f3284g = new C1094oa();
        m5041i();
    }

    public StaggeredGridLayoutManager(int spanCount, int orientation) {
        this.f3282e = orientation;
        setSpanCount(spanCount);
        this.f3284g = new C1094oa();
        m5041i();
    }

    public boolean isAutoMeasureEnabled() {
        return this.f3291n != 0;
    }

    /* renamed from: i */
    private void m5041i() {
        this.f3280c = C0916Ba.m4403a(this, this.f3282e);
        this.f3281d = C0916Ba.m4403a(this, 1 - this.f3282e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo8125c() {
        int maxPos;
        int minPos;
        if (getChildCount() == 0 || this.f3291n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f3286i) {
            minPos = mo8128f();
            maxPos = mo8127e();
        } else {
            minPos = mo8127e();
            maxPos = mo8128f();
        }
        if (minPos == 0 && mo8129g() != null) {
            this.f3290m.mo8137a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.f3298u) {
            return false;
        } else {
            int invalidGapDir = this.f3286i ? -1 : 1;
            FullSpanItem invalidFsi = this.f3290m.mo8136a(minPos, maxPos + 1, invalidGapDir, true);
            if (invalidFsi == null) {
                this.f3298u = false;
                this.f3290m.mo8142b(maxPos + 1);
                return false;
            }
            FullSpanItem validFsi = this.f3290m.mo8136a(minPos, invalidFsi.f3304a, invalidGapDir * -1, true);
            if (validFsi == null) {
                this.f3290m.mo8142b(invalidFsi.f3304a);
            } else {
                this.f3290m.mo8142b(validFsi.f3304a + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public void onScrollStateChanged(int state) {
        if (state == 0) {
            mo8125c();
        }
    }

    public void onDetachedFromWindow(RecyclerView view, C0991p recycler) {
        removeCallbacks(this.f3301x);
        for (int i = 0; i < this.f3278a; i++) {
            this.f3279b[i].mo8172c();
        }
        view.requestLayout();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public View mo8129g() {
        int childLimit;
        int firstChildIndex;
        int endChildIndex = getChildCount() - 1;
        BitSet mSpansToCheck = new BitSet(this.f3278a);
        mSpansToCheck.set(0, this.f3278a, true);
        int nextChildDiff = -1;
        int preferredSpanDir = (this.f3282e != 1 || !isLayoutRTL()) ? -1 : 1;
        if (this.f3286i) {
            firstChildIndex = endChildIndex;
            childLimit = 0 - 1;
        } else {
            firstChildIndex = 0;
            childLimit = endChildIndex + 1;
        }
        if (firstChildIndex < childLimit) {
            nextChildDiff = 1;
        }
        for (int i = firstChildIndex; i != childLimit; i += nextChildDiff) {
            View child = getChildAt(i);
            C1014b lp = (C1014b) child.getLayoutParams();
            if (mSpansToCheck.get(lp.f3325e.f3331e)) {
                if (m5025a(lp.f3325e)) {
                    return child;
                }
                mSpansToCheck.clear(lp.f3325e.f3331e);
            }
            if (!lp.f3326f && i + nextChildDiff != childLimit) {
                View nextChild = getChildAt(i + nextChildDiff);
                boolean compareSpans = false;
                if (this.f3286i) {
                    int myEnd = this.f3280c.mo6967a(child);
                    int nextEnd = this.f3280c.mo6967a(nextChild);
                    if (myEnd < nextEnd) {
                        return child;
                    }
                    if (myEnd == nextEnd) {
                        compareSpans = true;
                    }
                } else {
                    int myStart = this.f3280c.mo6974d(child);
                    int nextStart = this.f3280c.mo6974d(nextChild);
                    if (myStart > nextStart) {
                        return child;
                    }
                    if (myStart == nextStart) {
                        compareSpans = true;
                    }
                }
                if (compareSpans) {
                    if ((lp.f3325e.f3331e - ((C1014b) nextChild.getLayoutParams()).f3325e.f3331e < 0) != (preferredSpanDir < 0)) {
                        return child;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m5025a(C1015c span) {
        if (this.f3286i) {
            if (span.mo8179g() < this.f3280c.mo6969b()) {
                ArrayList<View> arrayList = span.f3327a;
                return !span.mo8170b((View) arrayList.get(arrayList.size() - 1)).f3326f;
            }
        } else if (span.mo8180h() > this.f3280c.mo6977f()) {
            return !span.mo8170b((View) span.f3327a.get(0)).f3326f;
        }
        return false;
    }

    public void setSpanCount(int spanCount) {
        assertNotInLayoutOrScroll(null);
        if (spanCount != this.f3278a) {
            mo8130h();
            this.f3278a = spanCount;
            this.f3287j = new BitSet(this.f3278a);
            this.f3279b = new C1015c[this.f3278a];
            for (int i = 0; i < this.f3278a; i++) {
                this.f3279b[i] = new C1015c(i);
            }
            requestLayout();
        }
    }

    public void setOrientation(int orientation) {
        if (orientation == 0 || orientation == 1) {
            assertNotInLayoutOrScroll(null);
            if (orientation != this.f3282e) {
                this.f3282e = orientation;
                C0916Ba tmp = this.f3280c;
                this.f3280c = this.f3281d;
                this.f3281d = tmp;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean reverseLayout) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.f3294q;
        if (!(savedState == null || savedState.f3315h == reverseLayout)) {
            savedState.f3315h = reverseLayout;
        }
        this.f3285h = reverseLayout;
        requestLayout();
    }

    public void assertNotInLayoutOrScroll(String message) {
        if (this.f3294q == null) {
            super.assertNotInLayoutOrScroll(message);
        }
    }

    /* renamed from: h */
    public void mo8130h() {
        this.f3290m.mo8137a();
        requestLayout();
    }

    private void resolveShouldLayoutReverse() {
        if (this.f3282e == 1 || !isLayoutRTL()) {
            this.f3286i = this.f3285h;
        } else {
            this.f3286i = !this.f3285h;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public void setMeasuredDimension(Rect childrenBounds, int wSpec, int hSpec) {
        int width;
        int usedHeight;
        int horizontalPadding = getPaddingLeft() + getPaddingRight();
        int verticalPadding = getPaddingTop() + getPaddingBottom();
        if (this.f3282e == 1) {
            width = C0981i.chooseSize(hSpec, childrenBounds.height() + verticalPadding, getMinimumHeight());
            usedHeight = C0981i.chooseSize(wSpec, (this.f3283f * this.f3278a) + horizontalPadding, getMinimumWidth());
        } else {
            int chooseSize = C0981i.chooseSize(wSpec, childrenBounds.width() + horizontalPadding, getMinimumWidth());
            width = C0981i.chooseSize(hSpec, (this.f3283f * this.f3278a) + verticalPadding, getMinimumHeight());
            usedHeight = chooseSize;
        }
        setMeasuredDimension(usedHeight, width);
    }

    public void onLayoutChildren(C0991p recycler, C0997t state) {
        m5033c(recycler, state, true);
    }

    /* renamed from: c */
    private void m5033c(C0991p recycler, C0997t state, boolean shouldCheckForGaps) {
        C1013a anchorInfo = this.f3297t;
        if (!(this.f3294q == null && this.f3288k == -1) && state.mo7945a() == 0) {
            removeAndRecycleAllViews(recycler);
            anchorInfo.mo8159b();
            return;
        }
        boolean needToCheckForGaps = true;
        boolean recalculateAnchor = (anchorInfo.f3322e && this.f3288k == -1 && this.f3294q == null) ? false : true;
        if (recalculateAnchor) {
            anchorInfo.mo8159b();
            if (this.f3294q != null) {
                m5020a(anchorInfo);
            } else {
                resolveShouldLayoutReverse();
                anchorInfo.f3320c = this.f3286i;
            }
            mo8123b(state, anchorInfo);
            anchorInfo.f3322e = true;
        }
        if (this.f3294q == null && this.f3288k == -1 && !(anchorInfo.f3320c == this.f3292o && isLayoutRTL() == this.f3293p)) {
            this.f3290m.mo8137a();
            anchorInfo.f3321d = true;
        }
        if (getChildCount() > 0) {
            SavedState savedState = this.f3294q;
            if (savedState == null || savedState.f3310c < 1) {
                if (anchorInfo.f3321d) {
                    for (int i = 0; i < this.f3278a; i++) {
                        this.f3279b[i].mo8172c();
                        int i2 = anchorInfo.f3319b;
                        if (i2 != Integer.MIN_VALUE) {
                            this.f3279b[i].mo8176d(i2);
                        }
                    }
                } else if (recalculateAnchor || this.f3297t.f3323f == null) {
                    for (int i3 = 0; i3 < this.f3278a; i3++) {
                        this.f3279b[i3].mo8168a(this.f3286i, anchorInfo.f3319b);
                    }
                    this.f3297t.mo8158a(this.f3279b);
                } else {
                    for (int i4 = 0; i4 < this.f3278a; i4++) {
                        C1015c span = this.f3279b[i4];
                        span.mo8172c();
                        span.mo8176d(this.f3297t.f3323f[i4]);
                    }
                }
            }
        }
        detachAndScrapAttachedViews(recycler);
        this.f3284g.f3651a = false;
        this.f3298u = false;
        mo8118a(this.f3281d.mo6979g());
        m5028b(anchorInfo.f3318a, state);
        if (anchorInfo.f3320c) {
            m5045l(-1);
            m5013a(recycler, this.f3284g, state);
            m5045l(1);
            C1094oa oaVar = this.f3284g;
            oaVar.f3653c = anchorInfo.f3318a + oaVar.f3654d;
            m5013a(recycler, oaVar, state);
        } else {
            m5045l(1);
            m5013a(recycler, this.f3284g, state);
            m5045l(-1);
            C1094oa oaVar2 = this.f3284g;
            oaVar2.f3653c = anchorInfo.f3318a + oaVar2.f3654d;
            m5013a(recycler, oaVar2, state);
        }
        m5043j();
        if (getChildCount() > 0) {
            if (this.f3286i) {
                m5018a(recycler, state, true);
                m5030b(recycler, state, false);
            } else {
                m5030b(recycler, state, true);
                m5018a(recycler, state, false);
            }
        }
        boolean hasGaps = false;
        if (shouldCheckForGaps && !state.mo7950d()) {
            if (this.f3291n == 0 || getChildCount() <= 0 || (!this.f3298u && mo8129g() == null)) {
                needToCheckForGaps = false;
            }
            if (needToCheckForGaps) {
                removeCallbacks(this.f3301x);
                if (mo8125c()) {
                    hasGaps = true;
                }
            }
        }
        if (state.mo7950d()) {
            this.f3297t.mo8159b();
        }
        this.f3292o = anchorInfo.f3320c;
        this.f3293p = isLayoutRTL();
        if (hasGaps) {
            this.f3297t.mo8159b();
            m5033c(recycler, state, false);
        }
    }

    public void onLayoutCompleted(C0997t state) {
        super.onLayoutCompleted(state);
        this.f3288k = -1;
        this.f3289l = LinearLayoutManager.INVALID_OFFSET;
        this.f3294q = null;
        this.f3297t.mo8159b();
    }

    /* renamed from: j */
    private void m5043j() {
        if (this.f3281d.mo6973d() != 1073741824) {
            float maxSize = 0.0f;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                float size = (float) this.f3281d.mo6970b(child);
                if (size >= maxSize) {
                    if (((C1014b) child.getLayoutParams()).mo8161f()) {
                        size = (1.0f * size) / ((float) this.f3278a);
                    }
                    maxSize = Math.max(maxSize, size);
                }
            }
            int before = this.f3283f;
            int desired = Math.round(((float) this.f3278a) * maxSize);
            if (this.f3281d.mo6973d() == Integer.MIN_VALUE) {
                desired = Math.min(desired, this.f3281d.mo6979g());
            }
            mo8118a(desired);
            if (this.f3283f != before) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View child2 = getChildAt(i2);
                    C1014b lp = (C1014b) child2.getLayoutParams();
                    if (!lp.f3326f) {
                        if (!isLayoutRTL() || this.f3282e != 1) {
                            int i3 = lp.f3325e.f3331e;
                            int newOffset = this.f3283f * i3;
                            int prevOffset = i3 * before;
                            if (this.f3282e == 1) {
                                child2.offsetLeftAndRight(newOffset - prevOffset);
                            } else {
                                child2.offsetTopAndBottom(newOffset - prevOffset);
                            }
                        } else {
                            int i4 = this.f3278a;
                            int i5 = i4 - 1;
                            int i6 = lp.f3325e.f3331e;
                            child2.offsetLeftAndRight(((-(i5 - i6)) * this.f3283f) - ((-((i4 - 1) - i6)) * before));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m5020a(C1013a anchorInfo) {
        SavedState savedState = this.f3294q;
        int i = savedState.f3310c;
        if (i > 0) {
            if (i == this.f3278a) {
                for (int i2 = 0; i2 < this.f3278a; i2++) {
                    this.f3279b[i2].mo8172c();
                    SavedState savedState2 = this.f3294q;
                    int line = savedState2.f3311d[i2];
                    if (line != Integer.MIN_VALUE) {
                        if (savedState2.f3316i) {
                            line += this.f3280c.mo6969b();
                        } else {
                            line += this.f3280c.mo6977f();
                        }
                    }
                    this.f3279b[i2].mo8176d(line);
                }
            } else {
                savedState.mo8153b();
                SavedState savedState3 = this.f3294q;
                savedState3.f3308a = savedState3.f3309b;
            }
        }
        SavedState savedState4 = this.f3294q;
        this.f3293p = savedState4.f3317j;
        setReverseLayout(savedState4.f3315h);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.f3294q;
        int i3 = savedState5.f3308a;
        if (i3 != -1) {
            this.f3288k = i3;
            anchorInfo.f3320c = savedState5.f3316i;
        } else {
            anchorInfo.f3320c = this.f3286i;
        }
        SavedState savedState6 = this.f3294q;
        if (savedState6.f3312e > 1) {
            LazySpanLookup lazySpanLookup = this.f3290m;
            lazySpanLookup.f3302a = savedState6.f3313f;
            lazySpanLookup.f3303b = savedState6.f3314g;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8123b(C0997t state, C1013a anchorInfo) {
        if (!mo8121a(state, anchorInfo) && !m5034c(state, anchorInfo)) {
            anchorInfo.mo8156a();
            anchorInfo.f3318a = 0;
        }
    }

    /* renamed from: c */
    private boolean m5034c(C0997t state, C1013a anchorInfo) {
        int i;
        if (this.f3292o) {
            i = m5037f(state.mo7945a());
        } else {
            i = m5036e(state.mo7945a());
        }
        anchorInfo.f3318a = i;
        anchorInfo.f3319b = LinearLayoutManager.INVALID_OFFSET;
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8121a(C0997t state, C1013a anchorInfo) {
        int i;
        int i2;
        boolean z = false;
        if (!state.mo7950d()) {
            int i3 = this.f3288k;
            if (i3 != -1) {
                if (i3 < 0 || i3 >= state.mo7945a()) {
                    this.f3288k = -1;
                    this.f3289l = LinearLayoutManager.INVALID_OFFSET;
                    return false;
                }
                SavedState savedState = this.f3294q;
                if (savedState == null || savedState.f3308a == -1 || savedState.f3310c < 1) {
                    View child = findViewByPosition(this.f3288k);
                    if (child != null) {
                        if (this.f3286i) {
                            i = mo8128f();
                        } else {
                            i = mo8127e();
                        }
                        anchorInfo.f3318a = i;
                        if (this.f3289l != Integer.MIN_VALUE) {
                            if (anchorInfo.f3320c) {
                                anchorInfo.f3319b = (this.f3280c.mo6969b() - this.f3289l) - this.f3280c.mo6967a(child);
                            } else {
                                anchorInfo.f3319b = (this.f3280c.mo6977f() + this.f3289l) - this.f3280c.mo6974d(child);
                            }
                            return true;
                        } else if (this.f3280c.mo6970b(child) > this.f3280c.mo6979g()) {
                            if (anchorInfo.f3320c) {
                                i2 = this.f3280c.mo6969b();
                            } else {
                                i2 = this.f3280c.mo6977f();
                            }
                            anchorInfo.f3319b = i2;
                            return true;
                        } else {
                            int startGap = this.f3280c.mo6974d(child) - this.f3280c.mo6977f();
                            if (startGap < 0) {
                                anchorInfo.f3319b = -startGap;
                                return true;
                            }
                            int endGap = this.f3280c.mo6969b() - this.f3280c.mo6967a(child);
                            if (endGap < 0) {
                                anchorInfo.f3319b = endGap;
                                return true;
                            }
                            anchorInfo.f3319b = LinearLayoutManager.INVALID_OFFSET;
                        }
                    } else {
                        anchorInfo.f3318a = this.f3288k;
                        int i4 = this.f3289l;
                        if (i4 == Integer.MIN_VALUE) {
                            if (m5026b(anchorInfo.f3318a) == 1) {
                                z = true;
                            }
                            anchorInfo.f3320c = z;
                            anchorInfo.mo8156a();
                        } else {
                            anchorInfo.mo8157a(i4);
                        }
                        anchorInfo.f3321d = true;
                    }
                } else {
                    anchorInfo.f3319b = LinearLayoutManager.INVALID_OFFSET;
                    anchorInfo.f3318a = this.f3288k;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8118a(int totalSpace) {
        this.f3283f = totalSpace / this.f3278a;
        this.f3295r = MeasureSpec.makeMeasureSpec(totalSpace, this.f3281d.mo6973d());
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f3294q == null;
    }

    public int computeHorizontalScrollOffset(C0997t state) {
        return computeScrollOffset(state);
    }

    private int computeScrollOffset(C0997t state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0968Qa.m4696a(state, this.f3280c, mo8122b(!this.f3299v), mo8117a(!this.f3299v), this, this.f3299v, this.f3286i);
    }

    public int computeVerticalScrollOffset(C0997t state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollExtent(C0997t state) {
        return computeScrollExtent(state);
    }

    private int computeScrollExtent(C0997t state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0968Qa.m4695a(state, this.f3280c, mo8122b(!this.f3299v), mo8117a(!this.f3299v), this, this.f3299v);
    }

    public int computeVerticalScrollExtent(C0997t state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollRange(C0997t state) {
        return computeScrollRange(state);
    }

    private int computeScrollRange(C0997t state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0968Qa.m4697b(state, this.f3280c, mo8122b(!this.f3299v), mo8117a(!this.f3299v), this, this.f3299v);
    }

    public int computeVerticalScrollRange(C0997t state) {
        return computeScrollRange(state);
    }

    /* renamed from: a */
    private void m5024a(View child, C1014b lp, boolean alreadyMeasured) {
        if (lp.f3326f) {
            if (this.f3282e == 1) {
                measureChildWithDecorationsAndMargin(child, this.f3295r, C0981i.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), lp.height, true), alreadyMeasured);
            } else {
                measureChildWithDecorationsAndMargin(child, C0981i.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), lp.width, true), this.f3295r, alreadyMeasured);
            }
        } else if (this.f3282e == 1) {
            measureChildWithDecorationsAndMargin(child, C0981i.getChildMeasureSpec(this.f3283f, getWidthMode(), 0, lp.width, false), C0981i.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), lp.height, true), alreadyMeasured);
        } else {
            measureChildWithDecorationsAndMargin(child, C0981i.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), lp.width, true), C0981i.getChildMeasureSpec(this.f3283f, getHeightMode(), 0, lp.height, false), alreadyMeasured);
        }
    }

    private void measureChildWithDecorationsAndMargin(View child, int widthSpec, int heightSpec, boolean alreadyMeasured) {
        boolean measure;
        calculateItemDecorationsForChild(child, this.f3296s);
        C1014b lp = (C1014b) child.getLayoutParams();
        int i = lp.leftMargin;
        Rect rect = this.f3296s;
        int widthSpec2 = m5027b(widthSpec, i + rect.left, lp.rightMargin + rect.right);
        int i2 = lp.topMargin;
        Rect rect2 = this.f3296s;
        int heightSpec2 = m5027b(heightSpec, i2 + rect2.top, lp.bottomMargin + rect2.bottom);
        if (alreadyMeasured) {
            measure = shouldReMeasureChild(child, widthSpec2, heightSpec2, lp);
        } else {
            measure = shouldMeasureChild(child, widthSpec2, heightSpec2, lp);
        }
        if (measure) {
            child.measure(widthSpec2, heightSpec2);
        }
    }

    /* renamed from: b */
    private int m5027b(int spec, int startInset, int endInset) {
        if (startInset == 0 && endInset == 0) {
            return spec;
        }
        int mode = MeasureSpec.getMode(spec);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(spec) - startInset) - endInset), mode);
        }
        return spec;
    }

    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            this.f3294q = (SavedState) state;
            requestLayout();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Parcelable onSaveInstanceState() {
        /*
            r4 = this;
            android.support.v7.widget.StaggeredGridLayoutManager$SavedState r0 = r4.f3294q
            if (r0 == 0) goto L_0x000a
            android.support.v7.widget.StaggeredGridLayoutManager$SavedState r1 = new android.support.v7.widget.StaggeredGridLayoutManager$SavedState
            r1.<init>(r0)
            return r1
        L_0x000a:
            android.support.v7.widget.StaggeredGridLayoutManager$SavedState r0 = new android.support.v7.widget.StaggeredGridLayoutManager$SavedState
            r0.<init>()
            boolean r1 = r4.f3285h
            r0.f3315h = r1
            boolean r1 = r4.f3292o
            r0.f3316i = r1
            boolean r1 = r4.f3293p
            r0.f3317j = r1
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r1 = r4.f3290m
            r2 = 0
            if (r1 == 0) goto L_0x0030
            int[] r3 = r1.f3302a
            if (r3 == 0) goto L_0x0030
            r0.f3313f = r3
            int[] r3 = r0.f3313f
            int r3 = r3.length
            r0.f3312e = r3
            java.util.List<android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r1 = r1.f3303b
            r0.f3314g = r1
            goto L_0x0032
        L_0x0030:
            r0.f3312e = r2
        L_0x0032:
            int r1 = r4.getChildCount()
            if (r1 <= 0) goto L_0x008b
            boolean r1 = r4.f3292o
            if (r1 == 0) goto L_0x0041
            int r1 = r4.mo8128f()
            goto L_0x0045
        L_0x0041:
            int r1 = r4.mo8127e()
        L_0x0045:
            r0.f3308a = r1
            int r1 = r4.mo8126d()
            r0.f3309b = r1
            int r1 = r4.f3278a
            r0.f3310c = r1
            int[] r1 = new int[r1]
            r0.f3311d = r1
            r1 = 0
        L_0x0056:
            int r2 = r4.f3278a
            if (r1 >= r2) goto L_0x008a
            boolean r2 = r4.f3292o
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == 0) goto L_0x0072
            android.support.v7.widget.StaggeredGridLayoutManager$c[] r2 = r4.f3279b
            r2 = r2[r1]
            int r2 = r2.mo8162a(r3)
            if (r2 == r3) goto L_0x0083
            android.support.v7.widget.Ba r3 = r4.f3280c
            int r3 = r3.mo6969b()
            int r2 = r2 - r3
            goto L_0x0083
        L_0x0072:
            android.support.v7.widget.StaggeredGridLayoutManager$c[] r2 = r4.f3279b
            r2 = r2[r1]
            int r2 = r2.mo8169b(r3)
            if (r2 == r3) goto L_0x0083
            android.support.v7.widget.Ba r3 = r4.f3280c
            int r3 = r3.mo6977f()
            int r2 = r2 - r3
        L_0x0083:
            int[] r3 = r0.f3311d
            r3[r1] = r2
            int r1 = r1 + 1
            goto L_0x0056
        L_0x008a:
            goto L_0x0092
        L_0x008b:
            r1 = -1
            r0.f3308a = r1
            r0.f3309b = r1
            r0.f3310c = r2
        L_0x0092:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.StaggeredGridLayoutManager.onSaveInstanceState():android.os.Parcelable");
    }

    public void onInitializeAccessibilityNodeInfoForItem(C0991p recycler, C0997t state, View host, C0604b info) {
        LayoutParams lp = host.getLayoutParams();
        if (!(lp instanceof C1014b)) {
            super.onInitializeAccessibilityNodeInfoForItem(host, info);
            return;
        }
        C1014b sglp = (C1014b) lp;
        if (this.f3282e == 0) {
            info.mo5588b((Object) C0606b.m2844a(sglp.mo8160e(), sglp.f3326f ? this.f3278a : 1, -1, -1, sglp.f3326f, false));
        } else {
            info.mo5588b((Object) C0606b.m2844a(-1, -1, sglp.mo8160e(), sglp.f3326f ? this.f3278a : 1, sglp.f3326f, false));
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        if (getChildCount() > 0) {
            View start = mo8122b(false);
            View end = mo8117a(false);
            if (start != null && end != null) {
                int startPos = getPosition(start);
                int endPos = getPosition(end);
                if (startPos < endPos) {
                    event.setFromIndex(startPos);
                    event.setToIndex(endPos);
                } else {
                    event.setFromIndex(endPos);
                    event.setToIndex(startPos);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo8126d() {
        View first;
        if (this.f3286i) {
            first = mo8117a(true);
        } else {
            first = mo8122b(true);
        }
        if (first == null) {
            return -1;
        }
        return getPosition(first);
    }

    public int getRowCountForAccessibility(C0991p recycler, C0997t state) {
        if (this.f3282e == 0) {
            return this.f3278a;
        }
        return super.getRowCountForAccessibility(recycler, state);
    }

    public int getColumnCountForAccessibility(C0991p recycler, C0997t state) {
        if (this.f3282e == 1) {
            return this.f3278a;
        }
        return super.getColumnCountForAccessibility(recycler, state);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public View mo8122b(boolean fullyVisible) {
        int boundsStart = this.f3280c.mo6977f();
        int boundsEnd = this.f3280c.mo6969b();
        int limit = getChildCount();
        View partiallyVisible = null;
        for (int i = 0; i < limit; i++) {
            View child = getChildAt(i);
            int childStart = this.f3280c.mo6974d(child);
            if (this.f3280c.mo6967a(child) > boundsStart && childStart < boundsEnd) {
                if (childStart >= boundsStart || !fullyVisible) {
                    return child;
                }
                if (partiallyVisible == null) {
                    partiallyVisible = child;
                }
            }
        }
        return partiallyVisible;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo8117a(boolean fullyVisible) {
        int boundsStart = this.f3280c.mo6977f();
        int boundsEnd = this.f3280c.mo6969b();
        View partiallyVisible = null;
        for (int i = getChildCount() - 1; i >= 0; i--) {
            View child = getChildAt(i);
            int childStart = this.f3280c.mo6974d(child);
            int childEnd = this.f3280c.mo6967a(child);
            if (childEnd > boundsStart && childStart < boundsEnd) {
                if (childEnd <= boundsEnd || !fullyVisible) {
                    return child;
                }
                if (partiallyVisible == null) {
                    partiallyVisible = child;
                }
            }
        }
        return partiallyVisible;
    }

    /* renamed from: a */
    private void m5018a(C0991p recycler, C0997t state, boolean canOffsetChildren) {
        int maxEndLine = m5038g(LinearLayoutManager.INVALID_OFFSET);
        if (maxEndLine != Integer.MIN_VALUE) {
            int gap = this.f3280c.mo6969b() - maxEndLine;
            if (gap > 0) {
                int gap2 = gap - (-scrollBy(-gap, recycler, state));
                if (canOffsetChildren && gap2 > 0) {
                    this.f3280c.mo6968a(gap2);
                }
            }
        }
    }

    /* renamed from: b */
    private void m5030b(C0991p recycler, C0997t state, boolean canOffsetChildren) {
        int minStartLine = m5042j(MoPubClientPositioning.NO_REPEAT);
        if (minStartLine != Integer.MAX_VALUE) {
            int gap = minStartLine - this.f3280c.mo6977f();
            if (gap > 0) {
                int gap2 = gap - scrollBy(gap, recycler, state);
                if (canOffsetChildren && gap2 > 0) {
                    this.f3280c.mo6968a(-gap2);
                }
            }
        }
    }

    /* renamed from: b */
    private void m5028b(int anchorPosition, C0997t state) {
        C1094oa oaVar = this.f3284g;
        boolean z = false;
        oaVar.f3652b = 0;
        oaVar.f3653c = anchorPosition;
        int startExtra = 0;
        int endExtra = 0;
        if (isSmoothScrolling()) {
            int targetPos = state.mo7948b();
            if (targetPos != -1) {
                if (this.f3286i == (targetPos < anchorPosition)) {
                    endExtra = this.f3280c.mo6979g();
                } else {
                    startExtra = this.f3280c.mo6979g();
                }
            }
        }
        if (getClipToPadding()) {
            this.f3284g.f3656f = this.f3280c.mo6977f() - startExtra;
            this.f3284g.f3657g = this.f3280c.mo6969b() + endExtra;
        } else {
            this.f3284g.f3657g = this.f3280c.mo6966a() + endExtra;
            this.f3284g.f3656f = -startExtra;
        }
        C1094oa oaVar2 = this.f3284g;
        oaVar2.f3658h = false;
        oaVar2.f3651a = true;
        if (this.f3280c.mo6973d() == 0 && this.f3280c.mo6966a() == 0) {
            z = true;
        }
        oaVar2.f3659i = z;
    }

    /* renamed from: l */
    private void m5045l(int direction) {
        C1094oa oaVar = this.f3284g;
        oaVar.f3655e = direction;
        int i = 1;
        if (this.f3286i != (direction == -1)) {
            i = -1;
        }
        oaVar.f3654d = i;
    }

    public void offsetChildrenHorizontal(int dx) {
        super.offsetChildrenHorizontal(dx);
        for (int i = 0; i < this.f3278a; i++) {
            this.f3279b[i].mo8173c(dx);
        }
    }

    public void offsetChildrenVertical(int dy) {
        super.offsetChildrenVertical(dy);
        for (int i = 0; i < this.f3278a; i++) {
            this.f3279b[i].mo8173c(dy);
        }
    }

    public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        m5016a(positionStart, itemCount, 2);
    }

    public void onItemsAdded(RecyclerView recyclerView, int positionStart, int itemCount) {
        m5016a(positionStart, itemCount, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f3290m.mo8137a();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int from, int to, int itemCount) {
        m5016a(from, to, 8);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
        m5016a(positionStart, itemCount, 4);
    }

    /* renamed from: a */
    private void m5016a(int positionStart, int itemCountOrToPosition, int cmd) {
        int affectedRangeStart;
        int affectedRangeEnd;
        int minPosition = this.f3286i ? mo8128f() : mo8127e();
        if (cmd != 8) {
            affectedRangeStart = positionStart;
            affectedRangeEnd = positionStart + itemCountOrToPosition;
        } else if (positionStart < itemCountOrToPosition) {
            affectedRangeEnd = itemCountOrToPosition + 1;
            affectedRangeStart = positionStart;
        } else {
            affectedRangeEnd = positionStart + 1;
            affectedRangeStart = itemCountOrToPosition;
        }
        this.f3290m.mo8146e(affectedRangeStart);
        if (cmd == 1) {
            this.f3290m.mo8139a(positionStart, itemCountOrToPosition);
        } else if (cmd == 2) {
            this.f3290m.mo8143b(positionStart, itemCountOrToPosition);
        } else if (cmd == 8) {
            this.f3290m.mo8143b(positionStart, 1);
            this.f3290m.mo8139a(itemCountOrToPosition, 1);
        }
        if (affectedRangeEnd > minPosition) {
            if (affectedRangeStart <= (this.f3286i ? mo8127e() : mo8128f())) {
                requestLayout();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v1, types: [boolean, int]
      assigns: []
      uses: [boolean, int, ?[int, short, byte, char]]
      mth insns count: 239
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m5013a(android.support.p001v7.widget.RecyclerView.C0991p r23, android.support.p001v7.widget.C1094oa r24, android.support.p001v7.widget.RecyclerView.C0997t r25) {
        /*
            r22 = this;
            r6 = r22
            r7 = r23
            r8 = r24
            java.util.BitSet r0 = r6.f3287j
            int r1 = r6.f3278a
            r9 = 0
            r10 = 1
            r0.set(r9, r1, r10)
            android.support.v7.widget.oa r0 = r6.f3284g
            boolean r0 = r0.f3659i
            if (r0 == 0) goto L_0x0022
            int r0 = r8.f3655e
            if (r0 != r10) goto L_0x001e
            r0 = 2147483647(0x7fffffff, float:NaN)
            r11 = r0
            goto L_0x0033
        L_0x001e:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r11 = r0
            goto L_0x0033
        L_0x0022:
            int r0 = r8.f3655e
            if (r0 != r10) goto L_0x002d
            int r0 = r8.f3657g
            int r1 = r8.f3652b
            int r0 = r0 + r1
            r11 = r0
            goto L_0x0033
        L_0x002d:
            int r0 = r8.f3656f
            int r1 = r8.f3652b
            int r0 = r0 - r1
            r11 = r0
        L_0x0033:
            int r0 = r8.f3655e
            r6.m5015a(r0, r11)
            boolean r0 = r6.f3286i
            if (r0 == 0) goto L_0x0043
            android.support.v7.widget.Ba r0 = r6.f3280c
            int r0 = r0.mo6969b()
            goto L_0x0049
        L_0x0043:
            android.support.v7.widget.Ba r0 = r6.f3280c
            int r0 = r0.mo6977f()
        L_0x0049:
            r12 = r0
            r0 = 0
            r13 = r0
        L_0x004c:
            boolean r0 = r24.mo8561a(r25)
            r1 = -1
            if (r0 == 0) goto L_0x01f5
            android.support.v7.widget.oa r0 = r6.f3284g
            boolean r0 = r0.f3659i
            if (r0 != 0) goto L_0x0065
            java.util.BitSet r0 = r6.f3287j
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0062
            goto L_0x0065
        L_0x0062:
            r2 = 0
            goto L_0x01f6
        L_0x0065:
            android.view.View r14 = r8.mo8560a(r7)
            android.view.ViewGroup$LayoutParams r0 = r14.getLayoutParams()
            r15 = r0
            android.support.v7.widget.StaggeredGridLayoutManager$b r15 = (android.support.p001v7.widget.StaggeredGridLayoutManager.C1014b) r15
            int r5 = r15.mo7864a()
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r0 = r6.f3290m
            int r4 = r0.mo8145d(r5)
            if (r4 != r1) goto L_0x007e
            r0 = 1
            goto L_0x007f
        L_0x007e:
            r0 = 0
        L_0x007f:
            r16 = r0
            if (r16 == 0) goto L_0x0097
            boolean r0 = r15.f3326f
            if (r0 == 0) goto L_0x008c
            android.support.v7.widget.StaggeredGridLayoutManager$c[] r0 = r6.f3279b
            r0 = r0[r9]
            goto L_0x0090
        L_0x008c:
            android.support.v7.widget.StaggeredGridLayoutManager$c r0 = r6.m5014a(r8)
        L_0x0090:
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r2 = r6.f3290m
            r2.mo8140a(r5, r0)
            r3 = r0
            goto L_0x009c
        L_0x0097:
            android.support.v7.widget.StaggeredGridLayoutManager$c[] r0 = r6.f3279b
            r0 = r0[r4]
            r3 = r0
        L_0x009c:
            r15.f3325e = r3
            int r0 = r8.f3655e
            if (r0 != r10) goto L_0x00a6
            r6.addView(r14)
            goto L_0x00a9
        L_0x00a6:
            r6.addView(r14, r9)
        L_0x00a9:
            r6.m5024a(r14, r15, r9)
            int r0 = r8.f3655e
            if (r0 != r10) goto L_0x00dc
            boolean r0 = r15.f3326f
            if (r0 == 0) goto L_0x00b9
            int r0 = r6.m5038g(r12)
            goto L_0x00bd
        L_0x00b9:
            int r0 = r3.mo8162a(r12)
        L_0x00bd:
            android.support.v7.widget.Ba r2 = r6.f3280c
            int r2 = r2.mo6970b(r14)
            int r2 = r2 + r0
            if (r16 == 0) goto L_0x00d8
            boolean r9 = r15.f3326f
            if (r9 == 0) goto L_0x00d8
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r9 = r6.m5032c(r0)
            r9.f3305b = r1
            r9.f3304a = r5
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r1 = r6.f3290m
            r1.mo8141a(r9)
        L_0x00d8:
            r9 = r0
            r18 = r2
            goto L_0x0108
        L_0x00dc:
            boolean r0 = r15.f3326f
            if (r0 == 0) goto L_0x00e5
            int r0 = r6.m5042j(r12)
            goto L_0x00e9
        L_0x00e5:
            int r0 = r3.mo8169b(r12)
        L_0x00e9:
            android.support.v7.widget.Ba r1 = r6.f3280c
            int r1 = r1.mo6970b(r14)
            int r1 = r0 - r1
            if (r16 == 0) goto L_0x0105
            boolean r2 = r15.f3326f
            if (r2 == 0) goto L_0x0105
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r2 = r6.m5035d(r0)
            r2.f3305b = r10
            r2.f3304a = r5
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f3290m
            r9.mo8141a(r2)
        L_0x0105:
            r18 = r0
            r9 = r1
        L_0x0108:
            boolean r0 = r15.f3326f
            if (r0 == 0) goto L_0x0133
            int r0 = r8.f3654d
            r1 = -1
            if (r0 != r1) goto L_0x0133
            if (r16 == 0) goto L_0x0116
            r6.f3298u = r10
            goto L_0x0133
        L_0x0116:
            int r0 = r8.f3655e
            if (r0 != r10) goto L_0x0120
            boolean r0 = r22.mo8120a()
            r0 = r0 ^ r10
            goto L_0x0125
        L_0x0120:
            boolean r0 = r22.mo8124b()
            r0 = r0 ^ r10
        L_0x0125:
            if (r0 == 0) goto L_0x0133
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r1 = r6.f3290m
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r1 = r1.mo8144c(r5)
            if (r1 == 0) goto L_0x0131
            r1.f3307d = r10
        L_0x0131:
            r6.f3298u = r10
        L_0x0133:
            r6.m5023a(r14, r15, r8)
            boolean r0 = r22.isLayoutRTL()
            if (r0 == 0) goto L_0x016a
            int r0 = r6.f3282e
            if (r0 != r10) goto L_0x016a
            boolean r0 = r15.f3326f
            if (r0 == 0) goto L_0x014b
            android.support.v7.widget.Ba r0 = r6.f3281d
            int r0 = r0.mo6969b()
            goto L_0x015c
        L_0x014b:
            android.support.v7.widget.Ba r0 = r6.f3281d
            int r0 = r0.mo6969b()
            int r1 = r6.f3278a
            int r1 = r1 - r10
            int r2 = r3.f3331e
            int r1 = r1 - r2
            int r2 = r6.f3283f
            int r1 = r1 * r2
            int r0 = r0 - r1
        L_0x015c:
            android.support.v7.widget.Ba r1 = r6.f3281d
            int r1 = r1.mo6970b(r14)
            int r1 = r0 - r1
            r19 = r0
            r17 = r1
            goto L_0x018e
        L_0x016a:
            boolean r0 = r15.f3326f
            if (r0 == 0) goto L_0x0175
            android.support.v7.widget.Ba r0 = r6.f3281d
            int r0 = r0.mo6977f()
            goto L_0x0182
        L_0x0175:
            int r0 = r3.f3331e
            int r1 = r6.f3283f
            int r0 = r0 * r1
            android.support.v7.widget.Ba r1 = r6.f3281d
            int r1 = r1.mo6977f()
            int r0 = r0 + r1
        L_0x0182:
            android.support.v7.widget.Ba r1 = r6.f3281d
            int r1 = r1.mo6970b(r14)
            int r1 = r1 + r0
            r17 = r0
            r19 = r1
        L_0x018e:
            int r0 = r6.f3282e
            if (r0 != r10) goto L_0x01a5
            r0 = r22
            r1 = r14
            r2 = r17
            r10 = r3
            r3 = r9
            r20 = r4
            r4 = r19
            r21 = r5
            r5 = r18
            r0.layoutDecoratedWithMargins(r1, r2, r3, r4, r5)
            goto L_0x01b7
        L_0x01a5:
            r10 = r3
            r20 = r4
            r21 = r5
            r0 = r22
            r1 = r14
            r2 = r9
            r3 = r17
            r4 = r18
            r5 = r19
            r0.layoutDecoratedWithMargins(r1, r2, r3, r4, r5)
        L_0x01b7:
            boolean r0 = r15.f3326f
            if (r0 == 0) goto L_0x01c3
            android.support.v7.widget.oa r0 = r6.f3284g
            int r0 = r0.f3655e
            r6.m5015a(r0, r11)
            goto L_0x01ca
        L_0x01c3:
            android.support.v7.widget.oa r0 = r6.f3284g
            int r0 = r0.f3655e
            r6.m5021a(r10, r0, r11)
        L_0x01ca:
            android.support.v7.widget.oa r0 = r6.f3284g
            r6.m5019a(r7, r0)
            android.support.v7.widget.oa r0 = r6.f3284g
            boolean r0 = r0.f3658h
            if (r0 == 0) goto L_0x01ef
            boolean r0 = r14.hasFocusable()
            if (r0 == 0) goto L_0x01ef
            boolean r0 = r15.f3326f
            if (r0 == 0) goto L_0x01e6
            java.util.BitSet r0 = r6.f3287j
            r0.clear()
            r2 = 0
            goto L_0x01f0
        L_0x01e6:
            java.util.BitSet r0 = r6.f3287j
            int r1 = r10.f3331e
            r2 = 0
            r0.set(r1, r2)
            goto L_0x01f0
        L_0x01ef:
            r2 = 0
        L_0x01f0:
            r13 = 1
            r9 = 0
            r10 = 1
            goto L_0x004c
        L_0x01f5:
            r2 = 0
        L_0x01f6:
            if (r13 != 0) goto L_0x01fd
            android.support.v7.widget.oa r0 = r6.f3284g
            r6.m5019a(r7, r0)
        L_0x01fd:
            android.support.v7.widget.oa r0 = r6.f3284g
            int r0 = r0.f3655e
            r1 = -1
            if (r0 != r1) goto L_0x0216
            android.support.v7.widget.Ba r0 = r6.f3280c
            int r0 = r0.mo6977f()
            int r0 = r6.m5042j(r0)
            android.support.v7.widget.Ba r1 = r6.f3280c
            int r1 = r1.mo6977f()
            int r1 = r1 - r0
            goto L_0x0228
        L_0x0216:
            android.support.v7.widget.Ba r0 = r6.f3280c
            int r0 = r0.mo6969b()
            int r0 = r6.m5038g(r0)
            android.support.v7.widget.Ba r1 = r6.f3280c
            int r1 = r1.mo6969b()
            int r1 = r0 - r1
        L_0x0228:
            if (r1 <= 0) goto L_0x0231
            int r0 = r8.f3652b
            int r9 = java.lang.Math.min(r0, r1)
            r2 = r9
        L_0x0231:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.StaggeredGridLayoutManager.m5013a(android.support.v7.widget.RecyclerView$p, android.support.v7.widget.oa, android.support.v7.widget.RecyclerView$t):int");
    }

    /* renamed from: c */
    private FullSpanItem m5032c(int newItemTop) {
        FullSpanItem fsi = new FullSpanItem();
        fsi.f3306c = new int[this.f3278a];
        for (int i = 0; i < this.f3278a; i++) {
            fsi.f3306c[i] = newItemTop - this.f3279b[i].mo8162a(newItemTop);
        }
        return fsi;
    }

    /* renamed from: d */
    private FullSpanItem m5035d(int newItemBottom) {
        FullSpanItem fsi = new FullSpanItem();
        fsi.f3306c = new int[this.f3278a];
        for (int i = 0; i < this.f3278a; i++) {
            fsi.f3306c[i] = this.f3279b[i].mo8169b(newItemBottom) - newItemBottom;
        }
        return fsi;
    }

    /* renamed from: a */
    private void m5023a(View view, C1014b lp, C1094oa layoutState) {
        if (layoutState.f3655e == 1) {
            if (lp.f3326f) {
                m5022a(view);
            } else {
                lp.f3325e.mo8167a(view);
            }
        } else if (lp.f3326f) {
            m5031b(view);
        } else {
            lp.f3325e.mo8174c(view);
        }
    }

    /* renamed from: a */
    private void m5019a(C0991p recycler, C1094oa layoutState) {
        int line;
        int line2;
        if (layoutState.f3651a && !layoutState.f3659i) {
            if (layoutState.f3652b == 0) {
                if (layoutState.f3655e == -1) {
                    m5017a(recycler, layoutState.f3657g);
                } else {
                    m5029b(recycler, layoutState.f3656f);
                }
            } else if (layoutState.f3655e == -1) {
                int i = layoutState.f3656f;
                int scrolled = i - m5039h(i);
                if (scrolled < 0) {
                    line2 = layoutState.f3657g;
                } else {
                    line2 = layoutState.f3657g - Math.min(scrolled, layoutState.f3652b);
                }
                m5017a(recycler, line2);
            } else {
                int scrolled2 = m5040i(layoutState.f3657g) - layoutState.f3657g;
                if (scrolled2 < 0) {
                    line = layoutState.f3656f;
                } else {
                    line = layoutState.f3656f + Math.min(scrolled2, layoutState.f3652b);
                }
                m5029b(recycler, line);
            }
        }
    }

    /* renamed from: a */
    private void m5022a(View view) {
        for (int i = this.f3278a - 1; i >= 0; i--) {
            this.f3279b[i].mo8167a(view);
        }
    }

    /* renamed from: b */
    private void m5031b(View view) {
        for (int i = this.f3278a - 1; i >= 0; i--) {
            this.f3279b[i].mo8174c(view);
        }
    }

    /* renamed from: a */
    private void m5015a(int layoutDir, int targetLine) {
        for (int i = 0; i < this.f3278a; i++) {
            if (!this.f3279b[i].f3327a.isEmpty()) {
                m5021a(this.f3279b[i], layoutDir, targetLine);
            }
        }
    }

    /* renamed from: a */
    private void m5021a(C1015c span, int layoutDir, int targetLine) {
        int deletedSize = span.mo8178f();
        if (layoutDir == -1) {
            if (span.mo8180h() + deletedSize <= targetLine) {
                this.f3287j.set(span.f3331e, false);
            }
        } else if (span.mo8179g() - deletedSize >= targetLine) {
            this.f3287j.set(span.f3331e, false);
        }
    }

    /* renamed from: h */
    private int m5039h(int def) {
        int maxStart = this.f3279b[0].mo8169b(def);
        for (int i = 1; i < this.f3278a; i++) {
            int spanStart = this.f3279b[i].mo8169b(def);
            if (spanStart > maxStart) {
                maxStart = spanStart;
            }
        }
        return maxStart;
    }

    /* renamed from: j */
    private int m5042j(int def) {
        int minStart = this.f3279b[0].mo8169b(def);
        for (int i = 1; i < this.f3278a; i++) {
            int spanStart = this.f3279b[i].mo8169b(def);
            if (spanStart < minStart) {
                minStart = spanStart;
            }
        }
        return minStart;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8120a() {
        int end = this.f3279b[0].mo8162a((int) LinearLayoutManager.INVALID_OFFSET);
        for (int i = 1; i < this.f3278a; i++) {
            if (this.f3279b[i].mo8162a((int) LinearLayoutManager.INVALID_OFFSET) != end) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo8124b() {
        int start = this.f3279b[0].mo8169b((int) LinearLayoutManager.INVALID_OFFSET);
        for (int i = 1; i < this.f3278a; i++) {
            if (this.f3279b[i].mo8169b((int) LinearLayoutManager.INVALID_OFFSET) != start) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    private int m5038g(int def) {
        int maxEnd = this.f3279b[0].mo8162a(def);
        for (int i = 1; i < this.f3278a; i++) {
            int spanEnd = this.f3279b[i].mo8162a(def);
            if (spanEnd > maxEnd) {
                maxEnd = spanEnd;
            }
        }
        return maxEnd;
    }

    /* renamed from: i */
    private int m5040i(int def) {
        int minEnd = this.f3279b[0].mo8162a(def);
        for (int i = 1; i < this.f3278a; i++) {
            int spanEnd = this.f3279b[i].mo8162a(def);
            if (spanEnd < minEnd) {
                minEnd = spanEnd;
            }
        }
        return minEnd;
    }

    /* renamed from: b */
    private void m5029b(C0991p recycler, int line) {
        while (getChildCount() > 0) {
            View child = getChildAt(0);
            if (this.f3280c.mo6967a(child) <= line && this.f3280c.mo6976e(child) <= line) {
                C1014b lp = (C1014b) child.getLayoutParams();
                if (lp.f3326f) {
                    int j = 0;
                    while (j < this.f3278a) {
                        if (this.f3279b[j].f3327a.size() != 1) {
                            j++;
                        } else {
                            return;
                        }
                    }
                    for (int j2 = 0; j2 < this.f3278a; j2++) {
                        this.f3279b[j2].mo8183k();
                    }
                } else if (lp.f3325e.f3327a.size() != 1) {
                    lp.f3325e.mo8183k();
                } else {
                    return;
                }
                removeAndRecycleView(child, recycler);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m5017a(C0991p recycler, int line) {
        int i = getChildCount() - 1;
        while (i >= 0) {
            View child = getChildAt(i);
            if (this.f3280c.mo6974d(child) >= line && this.f3280c.mo6978f(child) >= line) {
                C1014b lp = (C1014b) child.getLayoutParams();
                if (lp.f3326f) {
                    int j = 0;
                    while (j < this.f3278a) {
                        if (this.f3279b[j].f3327a.size() != 1) {
                            j++;
                        } else {
                            return;
                        }
                    }
                    for (int j2 = 0; j2 < this.f3278a; j2++) {
                        this.f3279b[j2].mo8182j();
                    }
                } else if (lp.f3325e.f3327a.size() != 1) {
                    lp.f3325e.mo8182j();
                } else {
                    return;
                }
                removeAndRecycleView(child, recycler);
                i--;
            } else {
                return;
            }
        }
    }

    /* renamed from: k */
    private boolean m5044k(int layoutDir) {
        boolean z = true;
        if (this.f3282e == 0) {
            if ((layoutDir == -1) == this.f3286i) {
                z = false;
            }
            return z;
        }
        if (((layoutDir == -1) == this.f3286i) != isLayoutRTL()) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private C1015c m5014a(C1094oa layoutState) {
        int diff;
        int endIndex;
        int startIndex;
        if (m5044k(layoutState.f3655e)) {
            startIndex = this.f3278a - 1;
            endIndex = -1;
            diff = -1;
        } else {
            startIndex = 0;
            endIndex = this.f3278a;
            diff = 1;
        }
        if (layoutState.f3655e == 1) {
            C1015c min = null;
            int minLine = MoPubClientPositioning.NO_REPEAT;
            int defaultLine = this.f3280c.mo6977f();
            for (int i = startIndex; i != endIndex; i += diff) {
                C1015c other = this.f3279b[i];
                int otherLine = other.mo8162a(defaultLine);
                if (otherLine < minLine) {
                    min = other;
                    minLine = otherLine;
                }
            }
            return min;
        }
        C1015c max = null;
        int maxLine = LinearLayoutManager.INVALID_OFFSET;
        int defaultLine2 = this.f3280c.mo6969b();
        for (int i2 = startIndex; i2 != endIndex; i2 += diff) {
            C1015c other2 = this.f3279b[i2];
            int otherLine2 = other2.mo8169b(defaultLine2);
            if (otherLine2 > maxLine) {
                max = other2;
                maxLine = otherLine2;
            }
        }
        return max;
    }

    public boolean canScrollVertically() {
        return this.f3282e == 1;
    }

    public boolean canScrollHorizontally() {
        return this.f3282e == 0;
    }

    public int scrollHorizontallyBy(int dx, C0991p recycler, C0997t state) {
        return scrollBy(dx, recycler, state);
    }

    public int scrollVerticallyBy(int dy, C0991p recycler, C0997t state) {
        return scrollBy(dy, recycler, state);
    }

    /* renamed from: b */
    private int m5026b(int position) {
        int i = -1;
        if (getChildCount() == 0) {
            if (this.f3286i) {
                i = 1;
            }
            return i;
        }
        if ((position < mo8127e()) == this.f3286i) {
            i = 1;
        }
        return i;
    }

    public PointF computeScrollVectorForPosition(int targetPosition) {
        int direction = m5026b(targetPosition);
        PointF outVector = new PointF();
        if (direction == 0) {
            return null;
        }
        if (this.f3282e == 0) {
            outVector.x = (float) direction;
            outVector.y = 0.0f;
        } else {
            outVector.x = 0.0f;
            outVector.y = (float) direction;
        }
        return outVector;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, C0997t state, int position) {
        C1108ra scroller = new C1108ra(recyclerView.getContext());
        scroller.setTargetPosition(position);
        startSmoothScroll(scroller);
    }

    public void scrollToPosition(int position) {
        SavedState savedState = this.f3294q;
        if (!(savedState == null || savedState.f3308a == position)) {
            savedState.mo8152a();
        }
        this.f3288k = position;
        this.f3289l = LinearLayoutManager.INVALID_OFFSET;
        requestLayout();
    }

    public void collectAdjacentPrefetchPositions(int dx, int dy, C0997t state, C0982a layoutPrefetchRegistry) {
        int distance;
        int delta = this.f3282e == 0 ? dx : dy;
        if (getChildCount() != 0 && delta != 0) {
            mo8119a(delta, state);
            int[] iArr = this.f3300w;
            if (iArr == null || iArr.length < this.f3278a) {
                this.f3300w = new int[this.f3278a];
            }
            int itemPrefetchCount = 0;
            for (int i = 0; i < this.f3278a; i++) {
                C1094oa oaVar = this.f3284g;
                if (oaVar.f3654d == -1) {
                    int i2 = oaVar.f3656f;
                    distance = i2 - this.f3279b[i].mo8169b(i2);
                } else {
                    distance = this.f3279b[i].mo8162a(oaVar.f3657g) - this.f3284g.f3657g;
                }
                if (distance >= 0) {
                    this.f3300w[itemPrefetchCount] = distance;
                    itemPrefetchCount++;
                }
            }
            Arrays.sort(this.f3300w, 0, itemPrefetchCount);
            for (int i3 = 0; i3 < itemPrefetchCount && this.f3284g.mo8561a(state); i3++) {
                layoutPrefetchRegistry.mo7863a(this.f3284g.f3653c, this.f3300w[i3]);
                C1094oa oaVar2 = this.f3284g;
                oaVar2.f3653c += oaVar2.f3654d;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8119a(int delta, C0997t state) {
        int referenceChildPosition;
        int layoutDir;
        if (delta > 0) {
            layoutDir = 1;
            referenceChildPosition = mo8128f();
        } else {
            layoutDir = -1;
            referenceChildPosition = mo8127e();
        }
        this.f3284g.f3651a = true;
        m5028b(referenceChildPosition, state);
        m5045l(layoutDir);
        C1094oa oaVar = this.f3284g;
        oaVar.f3653c = oaVar.f3654d + referenceChildPosition;
        oaVar.f3652b = Math.abs(delta);
    }

    /* access modifiers changed from: 0000 */
    public int scrollBy(int dt, C0991p recycler, C0997t state) {
        int totalScroll;
        if (getChildCount() == 0 || dt == 0) {
            return 0;
        }
        mo8119a(dt, state);
        int consumed = m5013a(recycler, this.f3284g, state);
        if (this.f3284g.f3652b < consumed) {
            totalScroll = dt;
        } else if (dt < 0) {
            totalScroll = -consumed;
        } else {
            totalScroll = consumed;
        }
        this.f3280c.mo6968a(-totalScroll);
        this.f3292o = this.f3286i;
        C1094oa oaVar = this.f3284g;
        oaVar.f3652b = 0;
        m5019a(recycler, oaVar);
        return totalScroll;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public int mo8128f() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public int mo8127e() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    /* renamed from: e */
    private int m5036e(int itemCount) {
        int limit = getChildCount();
        for (int i = 0; i < limit; i++) {
            int position = getPosition(getChildAt(i));
            if (position >= 0 && position < itemCount) {
                return position;
            }
        }
        return 0;
    }

    /* renamed from: f */
    private int m5037f(int itemCount) {
        for (int i = getChildCount() - 1; i >= 0; i--) {
            int position = getPosition(getChildAt(i));
            if (position >= 0 && position < itemCount) {
                return position;
            }
        }
        return 0;
    }

    public C0984j generateDefaultLayoutParams() {
        if (this.f3282e == 0) {
            return new C1014b(-2, -1);
        }
        return new C1014b(-1, -2);
    }

    public C0984j generateLayoutParams(Context c, AttributeSet attrs) {
        return new C1014b(c, attrs);
    }

    public C0984j generateLayoutParams(LayoutParams lp) {
        if (lp instanceof MarginLayoutParams) {
            return new C1014b((MarginLayoutParams) lp);
        }
        return new C1014b(lp);
    }

    public boolean checkLayoutParams(C0984j lp) {
        return lp instanceof C1014b;
    }

    public View onFocusSearchFailed(View focused, int direction, C0991p recycler, C0997t state) {
        int referenceChildPosition;
        int i;
        int i2;
        int i3;
        if (getChildCount() == 0) {
            return null;
        }
        View directChild = findContainingItemView(focused);
        if (directChild == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int layoutDir = convertFocusDirectionToLayoutDirection(direction);
        if (layoutDir == Integer.MIN_VALUE) {
            return null;
        }
        C1014b prevFocusLayoutParams = (C1014b) directChild.getLayoutParams();
        boolean prevFocusFullSpan = prevFocusLayoutParams.f3326f;
        C1015c prevFocusSpan = prevFocusLayoutParams.f3325e;
        if (layoutDir == 1) {
            referenceChildPosition = mo8128f();
        } else {
            referenceChildPosition = mo8127e();
        }
        m5028b(referenceChildPosition, state);
        m5045l(layoutDir);
        C1094oa oaVar = this.f3284g;
        oaVar.f3653c = oaVar.f3654d + referenceChildPosition;
        oaVar.f3652b = (int) (((float) this.f3280c.mo6979g()) * 0.33333334f);
        C1094oa oaVar2 = this.f3284g;
        oaVar2.f3658h = true;
        boolean z = false;
        oaVar2.f3651a = false;
        m5013a(recycler, oaVar2, state);
        this.f3292o = this.f3286i;
        if (!prevFocusFullSpan) {
            View view = prevFocusSpan.mo8165a(referenceChildPosition, layoutDir);
            if (!(view == null || view == directChild)) {
                return view;
            }
        }
        if (m5044k(layoutDir)) {
            for (int i4 = this.f3278a - 1; i4 >= 0; i4--) {
                View view2 = this.f3279b[i4].mo8165a(referenceChildPosition, layoutDir);
                if (view2 != null && view2 != directChild) {
                    return view2;
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f3278a; i5++) {
                View view3 = this.f3279b[i5].mo8165a(referenceChildPosition, layoutDir);
                if (view3 != null && view3 != directChild) {
                    return view3;
                }
            }
        }
        if ((this.f3285h ^ 1) == (layoutDir == -1 ? 1 : 0)) {
            z = true;
        }
        boolean shouldSearchFromStart = z;
        if (!prevFocusFullSpan) {
            if (shouldSearchFromStart) {
                i3 = prevFocusSpan.mo8175d();
            } else {
                i3 = prevFocusSpan.mo8177e();
            }
            View unfocusableCandidate = findViewByPosition(i3);
            if (!(unfocusableCandidate == null || unfocusableCandidate == directChild)) {
                return unfocusableCandidate;
            }
        }
        if (m5044k(layoutDir)) {
            for (int i6 = this.f3278a - 1; i6 >= 0; i6--) {
                if (i6 != prevFocusSpan.f3331e) {
                    if (shouldSearchFromStart) {
                        i2 = this.f3279b[i6].mo8175d();
                    } else {
                        i2 = this.f3279b[i6].mo8177e();
                    }
                    View unfocusableCandidate2 = findViewByPosition(i2);
                    if (unfocusableCandidate2 != null && unfocusableCandidate2 != directChild) {
                        return unfocusableCandidate2;
                    }
                    View view4 = unfocusableCandidate2;
                }
            }
        } else {
            for (int i7 = 0; i7 < this.f3278a; i7++) {
                if (shouldSearchFromStart) {
                    i = this.f3279b[i7].mo8175d();
                } else {
                    i = this.f3279b[i7].mo8177e();
                }
                View unfocusableCandidate3 = findViewByPosition(i);
                if (unfocusableCandidate3 != null && unfocusableCandidate3 != directChild) {
                    return unfocusableCandidate3;
                }
            }
        }
        return null;
    }

    private int convertFocusDirectionToLayoutDirection(int focusDirection) {
        int i = -1;
        int i2 = 1;
        if (focusDirection != 1) {
            if (focusDirection != 2) {
                if (focusDirection == 17) {
                    if (this.f3282e != 0) {
                        i = LinearLayoutManager.INVALID_OFFSET;
                    }
                    return i;
                } else if (focusDirection == 33) {
                    if (this.f3282e != 1) {
                        i = LinearLayoutManager.INVALID_OFFSET;
                    }
                    return i;
                } else if (focusDirection == 66) {
                    if (this.f3282e != 0) {
                        i2 = LinearLayoutManager.INVALID_OFFSET;
                    }
                    return i2;
                } else if (focusDirection != 130) {
                    return LinearLayoutManager.INVALID_OFFSET;
                } else {
                    if (this.f3282e != 1) {
                        i2 = LinearLayoutManager.INVALID_OFFSET;
                    }
                    return i2;
                }
            } else if (this.f3282e != 1 && isLayoutRTL()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.f3282e != 1 && isLayoutRTL()) {
            return 1;
        } else {
            return -1;
        }
    }
}

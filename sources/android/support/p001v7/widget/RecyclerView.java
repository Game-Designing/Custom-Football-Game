package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.p000v4.p037os.C0574d;
import android.support.p000v4.view.AbsSavedState;
import android.support.p000v4.view.C0616c;
import android.support.p000v4.view.C0634k;
import android.support.p000v4.view.C0635l;
import android.support.p000v4.view.C0637n;
import android.support.p000v4.view.C0644u;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.view.C0658y;
import android.support.p000v4.view.p038a.C0603a;
import android.support.p000v4.view.p038a.C0604b;
import android.support.p000v4.view.p038a.C0604b.C0605a;
import android.support.p000v4.view.p038a.C0604b.C0606b;
import android.support.p000v4.widget.C0706m;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p002b.p003c.p053g.p061f.C1272p;
import p002b.p003c.p062h.p068d.C1286a;
import p002b.p003c.p062h.p068d.C1287b;

/* renamed from: android.support.v7.widget.RecyclerView */
public class RecyclerView extends ViewGroup implements C0644u, C0635l {

    /* renamed from: a */
    private static final int[] f3091a = {16843830};

    /* renamed from: b */
    private static final int[] f3092b = {16842987};

    /* renamed from: c */
    static final boolean f3093c;

    /* renamed from: d */
    static final boolean f3094d = (VERSION.SDK_INT >= 23);

    /* renamed from: e */
    static final boolean f3095e = (VERSION.SDK_INT >= 16);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final boolean f3096f = (VERSION.SDK_INT >= 21);

    /* renamed from: g */
    private static final boolean f3097g = (VERSION.SDK_INT <= 15);

    /* renamed from: h */
    private static final boolean f3098h = (VERSION.SDK_INT <= 15);

    /* renamed from: i */
    private static final Class<?>[] f3099i;

    /* renamed from: j */
    static final Interpolator f3100j = new C0926Ea();

    /* renamed from: A */
    private C0987m f3101A;

    /* renamed from: Aa */
    private final int[] f3102Aa;

    /* renamed from: B */
    boolean f3103B;

    /* renamed from: Ba */
    private C0637n f3104Ba;

    /* renamed from: C */
    boolean f3105C;

    /* renamed from: Ca */
    private final int[] f3106Ca;

    /* renamed from: D */
    boolean f3107D;
    /* access modifiers changed from: private */

    /* renamed from: Da */
    public final int[] f3108Da;

    /* renamed from: E */
    boolean f3109E;

    /* renamed from: Ea */
    private final int[] f3110Ea;

    /* renamed from: F */
    private int f3111F;

    /* renamed from: Fa */
    final List<C1000w> f3112Fa;

    /* renamed from: G */
    boolean f3113G;

    /* renamed from: Ga */
    private Runnable f3114Ga;

    /* renamed from: H */
    boolean f3115H;

    /* renamed from: Ha */
    private final C0943b f3116Ha;

    /* renamed from: I */
    private boolean f3117I;

    /* renamed from: J */
    private int f3118J;

    /* renamed from: K */
    boolean f3119K;

    /* renamed from: L */
    private final AccessibilityManager f3120L;

    /* renamed from: M */
    private List<C0985k> f3121M;

    /* renamed from: N */
    boolean f3122N;

    /* renamed from: O */
    boolean f3123O;

    /* renamed from: P */
    private int f3124P;

    /* renamed from: Q */
    private int f3125Q;

    /* renamed from: R */
    private C0974e f3126R;

    /* renamed from: S */
    private EdgeEffect f3127S;

    /* renamed from: T */
    private EdgeEffect f3128T;

    /* renamed from: U */
    private EdgeEffect f3129U;

    /* renamed from: V */
    private EdgeEffect f3130V;

    /* renamed from: W */
    C0975f f3131W;

    /* renamed from: aa */
    private int f3132aa;

    /* renamed from: ba */
    private int f3133ba;

    /* renamed from: ca */
    private VelocityTracker f3134ca;

    /* renamed from: da */
    private int f3135da;

    /* renamed from: ea */
    private int f3136ea;

    /* renamed from: fa */
    private int f3137fa;

    /* renamed from: ga */
    private int f3138ga;

    /* renamed from: ha */
    private int f3139ha;

    /* renamed from: ia */
    private C0986l f3140ia;

    /* renamed from: ja */
    private final int f3141ja;

    /* renamed from: k */
    private final C0993r f3142k;

    /* renamed from: ka */
    private final int f3143ka;

    /* renamed from: l */
    final C0991p f3144l;

    /* renamed from: la */
    private float f3145la;

    /* renamed from: m */
    private SavedState f3146m;

    /* renamed from: ma */
    private float f3147ma;

    /* renamed from: n */
    C1068j f3148n;

    /* renamed from: na */
    private boolean f3149na;

    /* renamed from: o */
    C1001S f3150o;

    /* renamed from: oa */
    final C0999v f3151oa;

    /* renamed from: p */
    final C0941Hb f3152p;

    /* renamed from: pa */
    C1089na f3153pa;

    /* renamed from: q */
    boolean f3154q;

    /* renamed from: qa */
    C1090a f3155qa;

    /* renamed from: r */
    final Runnable f3156r;

    /* renamed from: ra */
    final C0997t f3157ra;

    /* renamed from: s */
    final Rect f3158s;

    /* renamed from: sa */
    private C0988n f3159sa;

    /* renamed from: t */
    private final Rect f3160t;

    /* renamed from: ta */
    private List<C0988n> f3161ta;

    /* renamed from: u */
    final RectF f3162u;

    /* renamed from: ua */
    boolean f3163ua;

    /* renamed from: v */
    C0970a f3164v;

    /* renamed from: va */
    boolean f3165va;

    /* renamed from: w */
    C0981i f3166w;

    /* renamed from: wa */
    private C0977b f3167wa;

    /* renamed from: x */
    C0992q f3168x;

    /* renamed from: xa */
    boolean f3169xa;

    /* renamed from: y */
    final ArrayList<C0980h> f3170y;

    /* renamed from: ya */
    C0953La f3171ya;

    /* renamed from: z */
    private final ArrayList<C0987m> f3172z;

    /* renamed from: za */
    private C0973d f3173za;

    /* renamed from: android.support.v7.widget.RecyclerView$SavedState */
    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C0951Ka();

        /* renamed from: c */
        Parcelable f3174c;

        SavedState(Parcel in, ClassLoader loader) {
            ClassLoader classLoader;
            super(in, loader);
            if (loader != null) {
                classLoader = loader;
            } else {
                classLoader = C0981i.class.getClassLoader();
            }
            this.f3174c = in.readParcelable(classLoader);
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeParcelable(this.f3174c, 0);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7685a(SavedState other) {
            this.f3174c = other.f3174c;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$a */
    public static abstract class C0970a<VH extends C1000w> {
        private boolean mHasStableIds = false;
        private final C0971b mObservable = new C0971b();

        public abstract int getItemCount();

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onBindViewHolder(VH holder, int position, List<Object> list) {
            onBindViewHolder(holder, position);
        }

        public final VH createViewHolder(ViewGroup parent, int viewType) {
            try {
                C0574d.m2755a("RV CreateView");
                VH holder = onCreateViewHolder(parent, viewType);
                if (holder.itemView.getParent() == null) {
                    holder.mItemViewType = viewType;
                    return holder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                C0574d.m2754a();
            }
        }

        public final void bindViewHolder(VH holder, int position) {
            holder.mPosition = position;
            if (hasStableIds()) {
                holder.mItemId = getItemId(position);
            }
            holder.setFlags(1, 519);
            C0574d.m2755a("RV OnBindView");
            onBindViewHolder(holder, position, holder.getUnmodifiedPayloads());
            holder.clearPayload();
            LayoutParams layoutParams = holder.itemView.getLayoutParams();
            if (layoutParams instanceof C0984j) {
                ((C0984j) layoutParams).f3192c = true;
            }
            C0574d.m2754a();
        }

        public int getItemViewType(int position) {
            return 0;
        }

        public void setHasStableIds(boolean hasStableIds) {
            if (!hasObservers()) {
                this.mHasStableIds = hasStableIds;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public long getItemId(int position) {
            return -1;
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public void onViewRecycled(VH vh) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public final boolean hasObservers() {
            return this.mObservable.mo7712a();
        }

        public void registerAdapterDataObserver(C0972c observer) {
            this.mObservable.registerObserver(observer);
        }

        public void unregisterAdapterDataObserver(C0972c observer) {
            this.mObservable.unregisterObserver(observer);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public final void notifyDataSetChanged() {
            this.mObservable.mo7713b();
        }

        public final void notifyItemChanged(int position) {
            this.mObservable.mo7714b(position, 1);
        }

        public final void notifyItemChanged(int position, Object payload) {
            this.mObservable.mo7711a(position, 1, payload);
        }

        public final void notifyItemRangeChanged(int positionStart, int itemCount) {
            this.mObservable.mo7714b(positionStart, itemCount);
        }

        public final void notifyItemRangeChanged(int positionStart, int itemCount, Object payload) {
            this.mObservable.mo7711a(positionStart, itemCount, payload);
        }

        public final void notifyItemInserted(int position) {
            this.mObservable.mo7715c(position, 1);
        }

        public final void notifyItemMoved(int fromPosition, int toPosition) {
            this.mObservable.mo7710a(fromPosition, toPosition);
        }

        public final void notifyItemRangeInserted(int positionStart, int itemCount) {
            this.mObservable.mo7715c(positionStart, itemCount);
        }

        public final void notifyItemRemoved(int position) {
            this.mObservable.mo7716d(position, 1);
        }

        public final void notifyItemRangeRemoved(int positionStart, int itemCount) {
            this.mObservable.mo7716d(positionStart, itemCount);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$b */
    static class C0971b extends Observable<C0972c> {
        C0971b() {
        }

        /* renamed from: a */
        public boolean mo7712a() {
            return !this.mObservers.isEmpty();
        }

        /* renamed from: b */
        public void mo7713b() {
            for (int i = this.mObservers.size() - 1; i >= 0; i--) {
                ((C0972c) this.mObservers.get(i)).onChanged();
            }
        }

        /* renamed from: b */
        public void mo7714b(int positionStart, int itemCount) {
            mo7711a(positionStart, itemCount, null);
        }

        /* renamed from: a */
        public void mo7711a(int positionStart, int itemCount, Object payload) {
            for (int i = this.mObservers.size() - 1; i >= 0; i--) {
                ((C0972c) this.mObservers.get(i)).onItemRangeChanged(positionStart, itemCount, payload);
            }
        }

        /* renamed from: c */
        public void mo7715c(int positionStart, int itemCount) {
            for (int i = this.mObservers.size() - 1; i >= 0; i--) {
                ((C0972c) this.mObservers.get(i)).onItemRangeInserted(positionStart, itemCount);
            }
        }

        /* renamed from: d */
        public void mo7716d(int positionStart, int itemCount) {
            for (int i = this.mObservers.size() - 1; i >= 0; i--) {
                ((C0972c) this.mObservers.get(i)).onItemRangeRemoved(positionStart, itemCount);
            }
        }

        /* renamed from: a */
        public void mo7710a(int fromPosition, int toPosition) {
            for (int i = this.mObservers.size() - 1; i >= 0; i--) {
                ((C0972c) this.mObservers.get(i)).onItemRangeMoved(fromPosition, toPosition, 1);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$c */
    public static abstract class C0972c {
        public void onChanged() {
        }

        public void onItemRangeChanged(int positionStart, int itemCount) {
        }

        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            onItemRangeChanged(positionStart, itemCount);
        }

        public void onItemRangeInserted(int positionStart, int itemCount) {
        }

        public void onItemRangeRemoved(int positionStart, int itemCount) {
        }

        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$d */
    public interface C0973d {
        /* renamed from: a */
        int mo7717a(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$e */
    public static class C0974e {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public EdgeEffect mo7718a(RecyclerView view, int direction) {
            return new EdgeEffect(view.getContext());
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$f */
    public static abstract class C0975f {

        /* renamed from: a */
        private C0977b f3175a = null;

        /* renamed from: b */
        private ArrayList<C0976a> f3176b = new ArrayList<>();

        /* renamed from: c */
        private long f3177c = 120;

        /* renamed from: d */
        private long f3178d = 120;

        /* renamed from: e */
        private long f3179e = 250;

        /* renamed from: f */
        private long f3180f = 250;

        /* renamed from: android.support.v7.widget.RecyclerView$f$a */
        public interface C0976a {
            /* renamed from: a */
            void mo7741a();
        }

        /* renamed from: android.support.v7.widget.RecyclerView$f$b */
        interface C0977b {
            /* renamed from: a */
            void mo7742a(C1000w wVar);
        }

        /* renamed from: android.support.v7.widget.RecyclerView$f$c */
        public static class C0978c {

            /* renamed from: a */
            public int f3181a;

            /* renamed from: b */
            public int f3182b;

            /* renamed from: c */
            public int f3183c;

            /* renamed from: d */
            public int f3184d;

            /* renamed from: a */
            public C0978c mo7743a(C1000w holder) {
                mo7744a(holder, 0);
                return this;
            }

            /* renamed from: a */
            public C0978c mo7744a(C1000w holder, int flags) {
                View view = holder.itemView;
                this.f3181a = view.getLeft();
                this.f3182b = view.getTop();
                this.f3183c = view.getRight();
                this.f3184d = view.getBottom();
                return this;
            }
        }

        /* renamed from: a */
        public abstract boolean mo7724a(C1000w wVar, C0978c cVar, C0978c cVar2);

        /* renamed from: a */
        public abstract boolean mo7725a(C1000w wVar, C1000w wVar2, C0978c cVar, C0978c cVar2);

        /* renamed from: b */
        public abstract void mo7727b();

        /* renamed from: b */
        public abstract boolean mo7728b(C1000w wVar);

        /* renamed from: b */
        public abstract boolean mo7729b(C1000w wVar, C0978c cVar, C0978c cVar2);

        /* renamed from: c */
        public abstract boolean mo7732c(C1000w wVar, C0978c cVar, C0978c cVar2);

        /* renamed from: d */
        public abstract void mo7734d(C1000w wVar);

        /* renamed from: g */
        public abstract boolean mo7738g();

        /* renamed from: i */
        public abstract void mo7740i();

        /* renamed from: e */
        public long mo7735e() {
            return this.f3179e;
        }

        /* renamed from: c */
        public long mo7730c() {
            return this.f3177c;
        }

        /* renamed from: f */
        public long mo7737f() {
            return this.f3178d;
        }

        /* renamed from: d */
        public long mo7733d() {
            return this.f3180f;
        }

        /* renamed from: a */
        public void mo7722a(long changeDuration) {
            this.f3180f = changeDuration;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7723a(C0977b listener) {
            this.f3175a = listener;
        }

        /* renamed from: a */
        public C0978c mo7720a(C0997t state, C1000w viewHolder, int changeFlags, List<Object> list) {
            C0978c h = mo7739h();
            h.mo7743a(viewHolder);
            return h;
        }

        /* renamed from: a */
        public C0978c mo7719a(C0997t state, C1000w viewHolder) {
            C0978c h = mo7739h();
            h.mo7743a(viewHolder);
            return h;
        }

        /* renamed from: a */
        static int m4838a(C1000w viewHolder) {
            int flags = viewHolder.mFlags & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((flags & 4) == 0) {
                int oldPos = viewHolder.getOldPosition();
                int pos = viewHolder.getAdapterPosition();
                if (!(oldPos == -1 || pos == -1 || oldPos == pos)) {
                    flags |= Opcodes.ACC_STRICT;
                }
            }
            return flags;
        }

        /* renamed from: c */
        public final void mo7731c(C1000w viewHolder) {
            mo7736e(viewHolder);
            C0977b bVar = this.f3175a;
            if (bVar != null) {
                bVar.mo7742a(viewHolder);
            }
        }

        /* renamed from: e */
        public void mo7736e(C1000w viewHolder) {
        }

        /* renamed from: a */
        public boolean mo7726a(C1000w viewHolder, List<Object> list) {
            return mo7728b(viewHolder);
        }

        /* renamed from: a */
        public final void mo7721a() {
            int count = this.f3176b.size();
            for (int i = 0; i < count; i++) {
                ((C0976a) this.f3176b.get(i)).mo7741a();
            }
            this.f3176b.clear();
        }

        /* renamed from: h */
        public C0978c mo7739h() {
            return new C0978c();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$g */
    private class C0979g implements C0977b {
        C0979g() {
        }

        /* renamed from: a */
        public void mo7742a(C1000w item) {
            item.setIsRecyclable(true);
            if (item.mShadowedHolder != null && item.mShadowingHolder == null) {
                item.mShadowedHolder = null;
            }
            item.mShadowingHolder = null;
            if (!item.shouldBeKeptAsChild() && !RecyclerView.this.mo7632n(item.itemView) && item.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(item.itemView, false);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$h */
    public static abstract class C0980h {
        public void onDraw(Canvas c, RecyclerView parent, C0997t state) {
            onDraw(c, parent);
        }

        @Deprecated
        public void onDraw(Canvas c, RecyclerView parent) {
        }

        public void onDrawOver(Canvas c, RecyclerView parent, C0997t state) {
            onDrawOver(c, parent);
        }

        @Deprecated
        public void onDrawOver(Canvas c, RecyclerView parent) {
        }

        @Deprecated
        public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
            outRect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, C0997t state) {
            getItemOffsets(outRect, ((C0984j) view.getLayoutParams()).mo7864a(), parent);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$i */
    public static abstract class C0981i {
        boolean mAutoMeasure = false;
        C1001S mChildHelper;
        private int mHeight;
        private int mHeightMode;
        C0933Gb mHorizontalBoundCheck = new C0933Gb(this.mHorizontalBoundCheckCallback);
        private final C0935b mHorizontalBoundCheckCallback = new C0945Ia(this);
        boolean mIsAttachedToWindow = false;
        private boolean mItemPrefetchEnabled = true;
        private boolean mMeasurementCacheEnabled = true;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations = false;
        C0994s mSmoothScroller;
        C0933Gb mVerticalBoundCheck = new C0933Gb(this.mVerticalBoundCheckCallback);
        private final C0935b mVerticalBoundCheckCallback = new C0948Ja(this);
        private int mWidth;
        private int mWidthMode;

        /* renamed from: android.support.v7.widget.RecyclerView$i$a */
        public interface C0982a {
            /* renamed from: a */
            void mo7863a(int i, int i2);
        }

        /* renamed from: android.support.v7.widget.RecyclerView$i$b */
        public static class C0983b {

            /* renamed from: a */
            public int f3186a;

            /* renamed from: b */
            public int f3187b;

            /* renamed from: c */
            public boolean f3188c;

            /* renamed from: d */
            public boolean f3189d;
        }

        public abstract C0984j generateDefaultLayoutParams();

        /* access modifiers changed from: 0000 */
        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.f3150o;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        /* access modifiers changed from: 0000 */
        public void setMeasureSpecs(int wSpec, int hSpec) {
            this.mWidth = MeasureSpec.getSize(wSpec);
            this.mWidthMode = MeasureSpec.getMode(wSpec);
            if (this.mWidthMode == 0 && !RecyclerView.f3094d) {
                this.mWidth = 0;
            }
            this.mHeight = MeasureSpec.getSize(hSpec);
            this.mHeightMode = MeasureSpec.getMode(hSpec);
            if (this.mHeightMode == 0 && !RecyclerView.f3094d) {
                this.mHeight = 0;
            }
        }

        /* access modifiers changed from: 0000 */
        public void setMeasuredDimensionFromChildren(int widthSpec, int heightSpec) {
            int count = getChildCount();
            if (count == 0) {
                this.mRecyclerView.mo7558c(widthSpec, heightSpec);
                return;
            }
            int minX = MoPubClientPositioning.NO_REPEAT;
            int minY = MoPubClientPositioning.NO_REPEAT;
            int maxX = LinearLayoutManager.INVALID_OFFSET;
            int maxY = LinearLayoutManager.INVALID_OFFSET;
            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                Rect bounds = this.mRecyclerView.f3158s;
                getDecoratedBoundsWithMargins(child, bounds);
                if (bounds.left < minX) {
                    minX = bounds.left;
                }
                if (bounds.right > maxX) {
                    maxX = bounds.right;
                }
                if (bounds.top < minY) {
                    minY = bounds.top;
                }
                if (bounds.bottom > maxY) {
                    maxY = bounds.bottom;
                }
            }
            this.mRecyclerView.f3158s.set(minX, minY, maxX, maxY);
            setMeasuredDimension(this.mRecyclerView.f3158s, widthSpec, heightSpec);
        }

        public void setMeasuredDimension(Rect childrenBounds, int wSpec, int hSpec) {
            setMeasuredDimension(chooseSize(wSpec, childrenBounds.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(hSpec, childrenBounds.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String message) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.mo7535a(message);
            }
        }

        public static int chooseSize(int spec, int desired, int min) {
            int mode = MeasureSpec.getMode(spec);
            int size = MeasureSpec.getSize(spec);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(size, Math.max(desired, min));
            }
            if (mode != 1073741824) {
                return Math.max(desired, min);
            }
            return size;
        }

        public void assertNotInLayoutOrScroll(String message) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.mo7552b(message);
            }
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean enabled) {
            this.mAutoMeasure = enabled;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public final void setItemPrefetchEnabled(boolean enabled) {
            if (enabled != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = enabled;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.f3144l.mo7921j();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public void collectAdjacentPrefetchPositions(int dx, int dy, C0997t state, C0982a layoutPrefetchRegistry) {
        }

        public void collectInitialPrefetchPositions(int adapterItemCount, C0982a layoutPrefetchRegistry) {
        }

        /* access modifiers changed from: 0000 */
        public void dispatchAttachedToWindow(RecyclerView view) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(view);
        }

        /* access modifiers changed from: 0000 */
        public void dispatchDetachedFromWindow(RecyclerView view, C0991p recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(view, recycler);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(Runnable action) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                C0646w.m2958a((View) recyclerView, action);
            }
        }

        public boolean removeCallbacks(Runnable action) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(action);
            }
            return false;
        }

        public void onAttachedToWindow(RecyclerView view) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView view) {
        }

        public void onDetachedFromWindow(RecyclerView view, C0991p recycler) {
            onDetachedFromWindow(view);
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.f3154q;
        }

        public void onLayoutChildren(C0991p recycler, C0997t state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(C0997t state) {
        }

        public boolean checkLayoutParams(C0984j lp) {
            return lp != null;
        }

        public C0984j generateLayoutParams(LayoutParams lp) {
            if (lp instanceof C0984j) {
                return new C0984j((C0984j) lp);
            }
            if (lp instanceof MarginLayoutParams) {
                return new C0984j((MarginLayoutParams) lp);
            }
            return new C0984j(lp);
        }

        public C0984j generateLayoutParams(Context c, AttributeSet attrs) {
            return new C0984j(c, attrs);
        }

        public int scrollHorizontallyBy(int dx, C0991p recycler, C0997t state) {
            return 0;
        }

        public int scrollVerticallyBy(int dy, C0991p recycler, C0997t state) {
            return 0;
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public void scrollToPosition(int position) {
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, C0997t state, int position) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(C0994s smoothScroller) {
            C0994s sVar = this.mSmoothScroller;
            if (!(sVar == null || smoothScroller == sVar || !sVar.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            this.mSmoothScroller.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            C0994s sVar = this.mSmoothScroller;
            return sVar != null && sVar.isRunning();
        }

        public int getLayoutDirection() {
            return C0646w.m2974h(this.mRecyclerView);
        }

        public void endAnimation(View view) {
            C0975f fVar = this.mRecyclerView.f3131W;
            if (fVar != null) {
                fVar.mo7734d(RecyclerView.m4736j(view));
            }
        }

        public void addDisappearingView(View child) {
            addDisappearingView(child, -1);
        }

        public void addDisappearingView(View child, int index) {
            addViewInt(child, index, true);
        }

        public void addView(View child) {
            addView(child, -1);
        }

        public void addView(View child, int index) {
            addViewInt(child, index, false);
        }

        private void addViewInt(View child, int index, boolean disappearing) {
            C1000w holder = RecyclerView.m4736j(child);
            if (disappearing || holder.isRemoved()) {
                this.mRecyclerView.f3152p.mo7313a(holder);
            } else {
                this.mRecyclerView.f3152p.mo7323g(holder);
            }
            C0984j lp = (C0984j) child.getLayoutParams();
            if (holder.wasReturnedFromScrap() || holder.isScrap()) {
                if (holder.isScrap()) {
                    holder.unScrap();
                } else {
                    holder.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.mo8001a(child, index, child.getLayoutParams(), false);
            } else if (child.getParent() == this.mRecyclerView) {
                int currentIndex = this.mChildHelper.mo8005b(child);
                if (index == -1) {
                    index = this.mChildHelper.mo7998a();
                }
                if (currentIndex == -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sb.append(this.mRecyclerView.indexOfChild(child));
                    sb.append(this.mRecyclerView.mo7625k());
                    throw new IllegalStateException(sb.toString());
                } else if (currentIndex != index) {
                    this.mRecyclerView.f3166w.moveView(currentIndex, index);
                }
            } else {
                this.mChildHelper.mo8002a(child, index, false);
                lp.f3192c = true;
                C0994s sVar = this.mSmoothScroller;
                if (sVar != null && sVar.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(child);
                }
            }
            if (lp.f3193d) {
                holder.itemView.invalidate();
                lp.f3193d = false;
            }
        }

        public void removeView(View child) {
            this.mChildHelper.mo8011d(child);
        }

        public void removeViewAt(int index) {
            if (getChildAt(index) != null) {
                this.mChildHelper.mo8012e(index);
            }
        }

        public void removeAllViews() {
            for (int i = getChildCount() - 1; i >= 0; i--) {
                this.mChildHelper.mo8012e(i);
            }
        }

        public int getBaseline() {
            return -1;
        }

        public int getPosition(View view) {
            return ((C0984j) view.getLayoutParams()).mo7864a();
        }

        public int getItemViewType(View view) {
            return RecyclerView.m4736j(view).getItemViewType();
        }

        public View findContainingItemView(View view) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return null;
            }
            View found = recyclerView.mo7556c(view);
            if (found != null && !this.mChildHelper.mo8009c(found)) {
                return found;
            }
            return null;
        }

        public View findViewByPosition(int position) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                C1000w vh = RecyclerView.m4736j(child);
                if (vh != null && vh.getLayoutPosition() == position && !vh.shouldIgnore() && (this.mRecyclerView.f3157ra.mo7950d() || !vh.isRemoved())) {
                    return child;
                }
            }
            return null;
        }

        public void detachView(View child) {
            int ind = this.mChildHelper.mo8005b(child);
            if (ind >= 0) {
                detachViewInternal(ind, child);
            }
        }

        public void detachViewAt(int index) {
            detachViewInternal(index, getChildAt(index));
        }

        private void detachViewInternal(int index, View view) {
            this.mChildHelper.mo7999a(index);
        }

        public void attachView(View child, int index, C0984j lp) {
            C1000w vh = RecyclerView.m4736j(child);
            if (vh.isRemoved()) {
                this.mRecyclerView.f3152p.mo7313a(vh);
            } else {
                this.mRecyclerView.f3152p.mo7323g(vh);
            }
            this.mChildHelper.mo8001a(child, index, lp, vh.isRemoved());
        }

        public void attachView(View child, int index) {
            attachView(child, index, (C0984j) child.getLayoutParams());
        }

        public void attachView(View child) {
            attachView(child, -1);
        }

        public void removeDetachedView(View child) {
            this.mRecyclerView.removeDetachedView(child, false);
        }

        public void moveView(int fromIndex, int toIndex) {
            View view = getChildAt(fromIndex);
            if (view != null) {
                detachViewAt(fromIndex);
                attachView(view, toIndex);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot move a child from non-existing index:");
            sb.append(fromIndex);
            sb.append(this.mRecyclerView.toString());
            throw new IllegalArgumentException(sb.toString());
        }

        public void detachAndScrapView(View child, C0991p recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.mo8005b(child), child);
        }

        public void detachAndScrapViewAt(int index, C0991p recycler) {
            scrapOrRecycleView(recycler, index, getChildAt(index));
        }

        public void removeAndRecycleView(View child, C0991p recycler) {
            removeView(child);
            recycler.mo7905b(child);
        }

        public void removeAndRecycleViewAt(int index, C0991p recycler) {
            View view = getChildAt(index);
            removeViewAt(index);
            recycler.mo7905b(view);
        }

        public int getChildCount() {
            C1001S s = this.mChildHelper;
            if (s != null) {
                return s.mo7998a();
            }
            return 0;
        }

        public View getChildAt(int index) {
            C1001S s = this.mChildHelper;
            if (s != null) {
                return s.mo8007c(index);
            }
            return null;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return C0646w.m2978l(recyclerView);
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return C0646w.m2977k(recyclerView);
            }
            return 0;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public View getFocusedChild() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return null;
            }
            View focused = recyclerView.getFocusedChild();
            if (focused == null || this.mChildHelper.mo8009c(focused)) {
                return null;
            }
            return focused;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            C0970a a = recyclerView != null ? recyclerView.getAdapter() : null;
            if (a != null) {
                return a.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int dx) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.mo7585f(dx);
            }
        }

        public void offsetChildrenVertical(int dy) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.mo7590g(dy);
            }
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                StringBuilder sb = new StringBuilder();
                sb.append("View should be fully attached to be ignored");
                sb.append(this.mRecyclerView.mo7625k());
                throw new IllegalArgumentException(sb.toString());
            }
            C1000w vh = RecyclerView.m4736j(view);
            vh.addFlags(128);
            this.mRecyclerView.f3152p.mo7324h(vh);
        }

        public void stopIgnoringView(View view) {
            C1000w vh = RecyclerView.m4736j(view);
            vh.stopIgnoring();
            vh.resetInternal();
            vh.addFlags(4);
        }

        public void detachAndScrapAttachedViews(C0991p recycler) {
            for (int i = getChildCount() - 1; i >= 0; i--) {
                scrapOrRecycleView(recycler, i, getChildAt(i));
            }
        }

        private void scrapOrRecycleView(C0991p recycler, int index, View view) {
            C1000w viewHolder = RecyclerView.m4736j(view);
            if (!viewHolder.shouldIgnore()) {
                if (!viewHolder.isInvalid() || viewHolder.isRemoved() || this.mRecyclerView.f3164v.hasStableIds()) {
                    detachViewAt(index);
                    recycler.mo7910c(view);
                    this.mRecyclerView.f3152p.mo7320d(viewHolder);
                } else {
                    removeViewAt(index);
                    recycler.mo7904b(viewHolder);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void removeAndRecycleScrapInt(C0991p recycler) {
            int scrapCount = recycler.mo7914e();
            for (int i = scrapCount - 1; i >= 0; i--) {
                View scrap = recycler.mo7906c(i);
                C1000w vh = RecyclerView.m4736j(scrap);
                if (!vh.shouldIgnore()) {
                    vh.setIsRecyclable(false);
                    if (vh.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(scrap, false);
                    }
                    C0975f fVar = this.mRecyclerView.f3131W;
                    if (fVar != null) {
                        fVar.mo7734d(vh);
                    }
                    vh.setIsRecyclable(true);
                    recycler.mo7899a(scrap);
                }
            }
            recycler.mo7907c();
            if (scrapCount > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void measureChild(View child, int widthUsed, int heightUsed) {
            C0984j lp = (C0984j) child.getLayoutParams();
            Rect insets = this.mRecyclerView.mo7624k(child);
            int heightUsed2 = heightUsed + insets.top + insets.bottom;
            int widthSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + widthUsed + insets.left + insets.right, lp.width, canScrollHorizontally());
            int heightSpec = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + heightUsed2, lp.height, canScrollVertically());
            if (shouldMeasureChild(child, widthSpec, heightSpec, lp)) {
                child.measure(widthSpec, heightSpec);
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean shouldReMeasureChild(View child, int widthSpec, int heightSpec, C0984j lp) {
            return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(child.getMeasuredWidth(), widthSpec, lp.width) || !isMeasurementUpToDate(child.getMeasuredHeight(), heightSpec, lp.height);
        }

        /* access modifiers changed from: 0000 */
        public boolean shouldMeasureChild(View child, int widthSpec, int heightSpec, C0984j lp) {
            return child.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(child.getWidth(), widthSpec, lp.width) || !isMeasurementUpToDate(child.getHeight(), heightSpec, lp.height);
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean measurementCacheEnabled) {
            this.mMeasurementCacheEnabled = measurementCacheEnabled;
        }

        private static boolean isMeasurementUpToDate(int childSize, int spec, int dimension) {
            int specMode = MeasureSpec.getMode(spec);
            int specSize = MeasureSpec.getSize(spec);
            boolean z = false;
            if (dimension > 0 && childSize != dimension) {
                return false;
            }
            if (specMode == Integer.MIN_VALUE) {
                if (specSize >= childSize) {
                    z = true;
                }
                return z;
            } else if (specMode == 0) {
                return true;
            } else {
                if (specMode != 1073741824) {
                    return false;
                }
                if (specSize == childSize) {
                    z = true;
                }
                return z;
            }
        }

        public void measureChildWithMargins(View child, int widthUsed, int heightUsed) {
            C0984j lp = (C0984j) child.getLayoutParams();
            Rect insets = this.mRecyclerView.mo7624k(child);
            int heightUsed2 = heightUsed + insets.top + insets.bottom;
            int widthSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin + widthUsed + insets.left + insets.right, lp.width, canScrollHorizontally());
            int heightSpec = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + lp.topMargin + lp.bottomMargin + heightUsed2, lp.height, canScrollVertically());
            if (shouldMeasureChild(child, widthSpec, heightSpec, lp)) {
                child.measure(widthSpec, heightSpec);
            }
        }

        @Deprecated
        public static int getChildMeasureSpec(int parentSize, int padding, int childDimension, boolean canScroll) {
            int size = Math.max(0, parentSize - padding);
            int resultSize = 0;
            int resultMode = 0;
            if (canScroll) {
                if (childDimension >= 0) {
                    resultSize = childDimension;
                    resultMode = 1073741824;
                } else {
                    resultSize = 0;
                    resultMode = 0;
                }
            } else if (childDimension >= 0) {
                resultSize = childDimension;
                resultMode = 1073741824;
            } else if (childDimension == -1) {
                resultSize = size;
                resultMode = 1073741824;
            } else if (childDimension == -2) {
                resultSize = size;
                resultMode = LinearLayoutManager.INVALID_OFFSET;
            }
            return MeasureSpec.makeMeasureSpec(resultSize, resultMode);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
            if (r8 != 1073741824) goto L_0x0043;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r7, int r8, int r9, int r10, boolean r11) {
            /*
                int r0 = r7 - r9
                r1 = 0
                int r0 = java.lang.Math.max(r1, r0)
                r1 = 0
                r2 = 0
                r3 = 1073741824(0x40000000, float:2.0)
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                r5 = -2
                r6 = -1
                if (r11 == 0) goto L_0x002c
                if (r10 < 0) goto L_0x0017
                r1 = r10
                r2 = 1073741824(0x40000000, float:2.0)
                goto L_0x0043
            L_0x0017:
                if (r10 != r6) goto L_0x0027
                if (r8 == r4) goto L_0x0023
                if (r8 == 0) goto L_0x0020
                if (r8 == r3) goto L_0x0023
                goto L_0x0026
            L_0x0020:
                r1 = 0
                r2 = 0
                goto L_0x0026
            L_0x0023:
                r1 = r0
                r2 = r8
            L_0x0026:
                goto L_0x0043
            L_0x0027:
                if (r10 != r5) goto L_0x0043
                r1 = 0
                r2 = 0
                goto L_0x0043
            L_0x002c:
                if (r10 < 0) goto L_0x0032
                r1 = r10
                r2 = 1073741824(0x40000000, float:2.0)
                goto L_0x0043
            L_0x0032:
                if (r10 != r6) goto L_0x0037
                r1 = r0
                r2 = r8
                goto L_0x0043
            L_0x0037:
                if (r10 != r5) goto L_0x0043
                r1 = r0
                if (r8 == r4) goto L_0x0041
                if (r8 != r3) goto L_0x003f
                goto L_0x0041
            L_0x003f:
                r2 = 0
                goto L_0x0043
            L_0x0041:
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
            L_0x0043:
                int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.RecyclerView.C0981i.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public int getDecoratedMeasuredWidth(View child) {
            Rect insets = ((C0984j) child.getLayoutParams()).f3191b;
            return child.getMeasuredWidth() + insets.left + insets.right;
        }

        public int getDecoratedMeasuredHeight(View child) {
            Rect insets = ((C0984j) child.getLayoutParams()).f3191b;
            return child.getMeasuredHeight() + insets.top + insets.bottom;
        }

        public void layoutDecorated(View child, int left, int top, int right, int bottom) {
            Rect insets = ((C0984j) child.getLayoutParams()).f3191b;
            child.layout(insets.left + left, insets.top + top, right - insets.right, bottom - insets.bottom);
        }

        public void layoutDecoratedWithMargins(View child, int left, int top, int right, int bottom) {
            C0984j lp = (C0984j) child.getLayoutParams();
            Rect insets = lp.f3191b;
            child.layout(insets.left + left + lp.leftMargin, insets.top + top + lp.topMargin, (right - insets.right) - lp.rightMargin, (bottom - insets.bottom) - lp.bottomMargin);
        }

        public void getTransformedBoundingBox(View child, boolean includeDecorInsets, Rect out) {
            if (includeDecorInsets) {
                Rect insets = ((C0984j) child.getLayoutParams()).f3191b;
                out.set(-insets.left, -insets.top, child.getWidth() + insets.right, child.getHeight() + insets.bottom);
            } else {
                out.set(0, 0, child.getWidth(), child.getHeight());
            }
            if (this.mRecyclerView != null) {
                Matrix childMatrix = child.getMatrix();
                if (childMatrix != null && !childMatrix.isIdentity()) {
                    RectF tempRectF = this.mRecyclerView.f3162u;
                    tempRectF.set(out);
                    childMatrix.mapRect(tempRectF);
                    out.set((int) Math.floor((double) tempRectF.left), (int) Math.floor((double) tempRectF.top), (int) Math.ceil((double) tempRectF.right), (int) Math.ceil((double) tempRectF.bottom));
                }
            }
            out.offset(child.getLeft(), child.getTop());
        }

        public void getDecoratedBoundsWithMargins(View view, Rect outBounds) {
            RecyclerView.m4723a(view, outBounds);
        }

        public int getDecoratedLeft(View child) {
            return child.getLeft() - getLeftDecorationWidth(child);
        }

        public int getDecoratedTop(View child) {
            return child.getTop() - getTopDecorationHeight(child);
        }

        public int getDecoratedRight(View child) {
            return child.getRight() + getRightDecorationWidth(child);
        }

        public int getDecoratedBottom(View child) {
            return child.getBottom() + getBottomDecorationHeight(child);
        }

        public void calculateItemDecorationsForChild(View child, Rect outRect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                outRect.set(0, 0, 0, 0);
            } else {
                outRect.set(recyclerView.mo7624k(child));
            }
        }

        public int getTopDecorationHeight(View child) {
            return ((C0984j) child.getLayoutParams()).f3191b.top;
        }

        public int getBottomDecorationHeight(View child) {
            return ((C0984j) child.getLayoutParams()).f3191b.bottom;
        }

        public int getLeftDecorationWidth(View child) {
            return ((C0984j) child.getLayoutParams()).f3191b.left;
        }

        public int getRightDecorationWidth(View child) {
            return ((C0984j) child.getLayoutParams()).f3191b.right;
        }

        public View onFocusSearchFailed(View focused, int direction, C0991p recycler, C0997t state) {
            return null;
        }

        public View onInterceptFocusSearch(View focused, int direction) {
            return null;
        }

        private int[] getChildRectangleOnScreenScrollAmount(RecyclerView parent, View child, Rect rect, boolean immediate) {
            int dx;
            int dy;
            Rect rect2 = rect;
            int[] out = new int[2];
            int parentLeft = getPaddingLeft();
            int parentTop = getPaddingTop();
            int parentRight = getWidth() - getPaddingRight();
            int parentBottom = getHeight() - getPaddingBottom();
            int childLeft = (child.getLeft() + rect2.left) - child.getScrollX();
            int childTop = (child.getTop() + rect2.top) - child.getScrollY();
            int childRight = rect.width() + childLeft;
            int childBottom = rect.height() + childTop;
            int offScreenLeft = Math.min(0, childLeft - parentLeft);
            int offScreenTop = Math.min(0, childTop - parentTop);
            int offScreenRight = Math.max(0, childRight - parentRight);
            int offScreenBottom = Math.max(0, childBottom - parentBottom);
            if (getLayoutDirection() == 1) {
                if (offScreenRight != 0) {
                    dx = offScreenRight;
                } else {
                    dx = Math.max(offScreenLeft, childRight - parentRight);
                }
            } else if (offScreenLeft != 0) {
                dx = offScreenLeft;
            } else {
                dx = Math.min(childLeft - parentLeft, offScreenRight);
            }
            if (offScreenTop != 0) {
                dy = offScreenTop;
            } else {
                dy = Math.min(childTop - parentTop, offScreenBottom);
            }
            out[0] = dx;
            out[1] = dy;
            return out;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView parent, View child, Rect rect, boolean immediate) {
            return requestChildRectangleOnScreen(parent, child, rect, immediate, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView parent, View child, Rect rect, boolean immediate, boolean focusedChildVisible) {
            int[] scrollAmount = getChildRectangleOnScreenScrollAmount(parent, child, rect, immediate);
            int dx = scrollAmount[0];
            int dy = scrollAmount[1];
            if ((focusedChildVisible && !isFocusedChildVisibleAfterScrolling(parent, dx, dy)) || (dx == 0 && dy == 0)) {
                return false;
            }
            if (immediate) {
                parent.scrollBy(dx, dy);
            } else {
                parent.mo7619i(dx, dy);
            }
            return true;
        }

        public boolean isViewPartiallyVisible(View child, boolean completelyVisible, boolean acceptEndPointInclusion) {
            boolean z = true;
            boolean isViewFullyVisible = this.mHorizontalBoundCheck.mo7234a(child, 24579) && this.mVerticalBoundCheck.mo7234a(child, 24579);
            if (completelyVisible) {
                return isViewFullyVisible;
            }
            if (isViewFullyVisible) {
                z = false;
            }
            return z;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView parent, int dx, int dy) {
            View focusedChild = parent.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int parentLeft = getPaddingLeft();
            int parentTop = getPaddingTop();
            int parentRight = getWidth() - getPaddingRight();
            int parentBottom = getHeight() - getPaddingBottom();
            Rect bounds = this.mRecyclerView.f3158s;
            getDecoratedBoundsWithMargins(focusedChild, bounds);
            if (bounds.left - dx >= parentRight || bounds.right - dx <= parentLeft || bounds.top - dy >= parentBottom || bounds.bottom - dy <= parentTop) {
                return false;
            }
            return true;
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView parent, View child, View focused) {
            return isSmoothScrolling() || parent.mo7647q();
        }

        public boolean onRequestChildFocus(RecyclerView parent, C0997t state, View child, View focused) {
            return onRequestChildFocus(parent, child, focused);
        }

        public void onAdapterChanged(C0970a oldAdapter, C0970a newAdapter) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int direction, int focusableMode) {
            return false;
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsAdded(RecyclerView recyclerView, int positionStart, int itemCount) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
            onItemsUpdated(recyclerView, positionStart, itemCount);
        }

        public void onItemsMoved(RecyclerView recyclerView, int from, int to, int itemCount) {
        }

        public int computeHorizontalScrollExtent(C0997t state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(C0997t state) {
            return 0;
        }

        public int computeHorizontalScrollRange(C0997t state) {
            return 0;
        }

        public int computeVerticalScrollExtent(C0997t state) {
            return 0;
        }

        public int computeVerticalScrollOffset(C0997t state) {
            return 0;
        }

        public int computeVerticalScrollRange(C0997t state) {
            return 0;
        }

        public void onMeasure(C0991p recycler, C0997t state, int widthSpec, int heightSpec) {
            this.mRecyclerView.mo7558c(widthSpec, heightSpec);
        }

        public void setMeasuredDimension(int widthSize, int heightSize) {
            this.mRecyclerView.setMeasuredDimension(widthSize, heightSize);
        }

        public int getMinimumWidth() {
            return C0646w.m2976j(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return C0646w.m2975i(this.mRecyclerView);
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable state) {
        }

        /* access modifiers changed from: 0000 */
        public void stopSmoothScroller() {
            C0994s sVar = this.mSmoothScroller;
            if (sVar != null) {
                sVar.stop();
            }
        }

        /* access modifiers changed from: private */
        public void onSmoothScrollerStopped(C0994s smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public void onScrollStateChanged(int state) {
        }

        public void removeAndRecycleAllViews(C0991p recycler) {
            for (int i = getChildCount() - 1; i >= 0; i--) {
                if (!RecyclerView.m4736j(getChildAt(i)).shouldIgnore()) {
                    removeAndRecycleViewAt(i, recycler);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void onInitializeAccessibilityNodeInfo(C0604b info) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.f3144l, recyclerView.f3157ra, info);
        }

        public void onInitializeAccessibilityNodeInfo(C0991p recycler, C0997t state, C0604b info) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                info.mo5579a((int) Opcodes.ACC_ANNOTATION);
                info.mo5594d(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                info.mo5579a((int) Opcodes.ACC_SYNTHETIC);
                info.mo5594d(true);
            }
            info.mo5583a((Object) C0605a.m2843a(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.f3144l, recyclerView.f3157ra, event);
        }

        public void onInitializeAccessibilityEvent(C0991p recycler, C0997t state, AccessibilityEvent event) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && event != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z = false;
                }
                event.setScrollable(z);
                C0970a aVar = this.mRecyclerView.f3164v;
                if (aVar != null) {
                    event.setItemCount(aVar.getItemCount());
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void onInitializeAccessibilityNodeInfoForItem(View host, C0604b info) {
            C1000w vh = RecyclerView.m4736j(host);
            if (vh != null && !vh.isRemoved() && !this.mChildHelper.mo8009c(vh.itemView)) {
                RecyclerView recyclerView = this.mRecyclerView;
                onInitializeAccessibilityNodeInfoForItem(recyclerView.f3144l, recyclerView.f3157ra, host, info);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(C0991p recycler, C0997t state, View host, C0604b info) {
            info.mo5588b((Object) C0606b.m2844a(canScrollVertically() ? getPosition(host) : 0, 1, canScrollHorizontally() ? getPosition(host) : 0, 1, false, false));
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int getSelectionModeForAccessibility(C0991p recycler, C0997t state) {
            return 0;
        }

        public int getRowCountForAccessibility(C0991p recycler, C0997t state) {
            RecyclerView recyclerView = this.mRecyclerView;
            int i = 1;
            if (recyclerView == null || recyclerView.f3164v == null) {
                return 1;
            }
            if (canScrollVertically()) {
                i = this.mRecyclerView.f3164v.getItemCount();
            }
            return i;
        }

        public int getColumnCountForAccessibility(C0991p recycler, C0997t state) {
            RecyclerView recyclerView = this.mRecyclerView;
            int i = 1;
            if (recyclerView == null || recyclerView.f3164v == null) {
                return 1;
            }
            if (canScrollHorizontally()) {
                i = this.mRecyclerView.f3164v.getItemCount();
            }
            return i;
        }

        public boolean isLayoutHierarchical(C0991p recycler, C0997t state) {
            return false;
        }

        /* access modifiers changed from: 0000 */
        public boolean performAccessibilityAction(int action, Bundle args) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.f3144l, recyclerView.f3157ra, action, args);
        }

        public boolean performAccessibilityAction(C0991p recycler, C0997t state, int action, Bundle args) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            int vScroll = 0;
            int hScroll = 0;
            if (action == 4096) {
                if (recyclerView.canScrollVertically(1)) {
                    vScroll = (getHeight() - getPaddingTop()) - getPaddingBottom();
                }
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    hScroll = (getWidth() - getPaddingLeft()) - getPaddingRight();
                }
            } else if (action == 8192) {
                if (recyclerView.canScrollVertically(-1)) {
                    vScroll = -((getHeight() - getPaddingTop()) - getPaddingBottom());
                }
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    hScroll = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                }
            }
            if (vScroll == 0 && hScroll == 0) {
                return false;
            }
            this.mRecyclerView.scrollBy(hScroll, vScroll);
            return true;
        }

        /* access modifiers changed from: 0000 */
        public boolean performAccessibilityActionForItem(View view, int action, Bundle args) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.f3144l, recyclerView.f3157ra, view, action, args);
        }

        public boolean performAccessibilityActionForItem(C0991p recycler, C0997t state, View view, int action, Bundle args) {
            return false;
        }

        public static C0983b getProperties(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            C0983b properties = new C0983b();
            TypedArray a = context.obtainStyledAttributes(attrs, C1287b.RecyclerView, defStyleAttr, defStyleRes);
            properties.f3186a = a.getInt(C1287b.RecyclerView_android_orientation, 1);
            properties.f3187b = a.getInt(C1287b.RecyclerView_spanCount, 1);
            properties.f3188c = a.getBoolean(C1287b.RecyclerView_reverseLayout, false);
            properties.f3189d = a.getBoolean(C1287b.RecyclerView_stackFromEnd, false);
            a.recycle();
            return properties;
        }

        /* access modifiers changed from: 0000 */
        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* access modifiers changed from: 0000 */
        public boolean shouldMeasureTwice() {
            return false;
        }

        /* access modifiers changed from: 0000 */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams lp = getChildAt(i).getLayoutParams();
                if (lp.width < 0 && lp.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$j */
    public static class C0984j extends MarginLayoutParams {

        /* renamed from: a */
        C1000w f3190a;

        /* renamed from: b */
        final Rect f3191b = new Rect();

        /* renamed from: c */
        boolean f3192c = true;

        /* renamed from: d */
        boolean f3193d = false;

        public C0984j(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public C0984j(int width, int height) {
            super(width, height);
        }

        public C0984j(MarginLayoutParams source) {
            super(source);
        }

        public C0984j(LayoutParams source) {
            super(source);
        }

        public C0984j(C0984j source) {
            super(source);
        }

        /* renamed from: d */
        public boolean mo7867d() {
            return this.f3190a.isInvalid();
        }

        /* renamed from: c */
        public boolean mo7866c() {
            return this.f3190a.isRemoved();
        }

        /* renamed from: b */
        public boolean mo7865b() {
            return this.f3190a.isUpdated();
        }

        /* renamed from: a */
        public int mo7864a() {
            return this.f3190a.getLayoutPosition();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$k */
    public interface C0985k {
        /* renamed from: a */
        void mo7868a(View view);

        /* renamed from: b */
        void mo7869b(View view);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$l */
    public static abstract class C0986l {
        public abstract boolean onFling(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$m */
    public interface C0987m {
        /* renamed from: a */
        void mo7871a(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: a */
        void mo7872a(boolean z);

        /* renamed from: b */
        boolean mo7873b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$n */
    public static abstract class C0988n {
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$o */
    public static class C0989o {

        /* renamed from: a */
        SparseArray<C0990a> f3194a = new SparseArray<>();

        /* renamed from: b */
        private int f3195b = 0;

        /* renamed from: android.support.v7.widget.RecyclerView$o$a */
        static class C0990a {

            /* renamed from: a */
            final ArrayList<C1000w> f3196a = new ArrayList<>();

            /* renamed from: b */
            int f3197b = 5;

            /* renamed from: c */
            long f3198c = 0;

            /* renamed from: d */
            long f3199d = 0;

            C0990a() {
            }
        }

        /* renamed from: a */
        public void mo7878a() {
            for (int i = 0; i < this.f3194a.size(); i++) {
                ((C0990a) this.f3194a.valueAt(i)).f3196a.clear();
            }
        }

        /* renamed from: a */
        public C1000w mo7877a(int viewType) {
            C0990a scrapData = (C0990a) this.f3194a.get(viewType);
            if (scrapData == null || scrapData.f3196a.isEmpty()) {
                return null;
            }
            ArrayList<C1000w> arrayList = scrapData.f3196a;
            return (C1000w) arrayList.remove(arrayList.size() - 1);
        }

        /* renamed from: a */
        public void mo7882a(C1000w scrap) {
            int viewType = scrap.getItemViewType();
            ArrayList<C1000w> arrayList = m4876b(viewType).f3196a;
            if (((C0990a) this.f3194a.get(viewType)).f3197b > arrayList.size()) {
                scrap.resetInternal();
                arrayList.add(scrap);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public long mo7876a(long oldAverage, long newValue) {
            if (oldAverage == 0) {
                return newValue;
            }
            return ((oldAverage / 4) * 3) + (newValue / 4);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo7885b(int viewType, long createTimeNs) {
            C0990a scrapData = m4876b(viewType);
            scrapData.f3198c = mo7876a(scrapData.f3198c, createTimeNs);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7879a(int viewType, long bindTimeNs) {
            C0990a scrapData = m4876b(viewType);
            scrapData.f3199d = mo7876a(scrapData.f3199d, bindTimeNs);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo7886b(int viewType, long approxCurrentNs, long deadlineNs) {
            long expectedDurationNs = m4876b(viewType).f3198c;
            return expectedDurationNs == 0 || approxCurrentNs + expectedDurationNs < deadlineNs;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo7883a(int viewType, long approxCurrentNs, long deadlineNs) {
            long expectedDurationNs = m4876b(viewType).f3199d;
            return expectedDurationNs == 0 || approxCurrentNs + expectedDurationNs < deadlineNs;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7880a(C0970a adapter) {
            this.f3195b++;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo7884b() {
            this.f3195b--;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7881a(C0970a oldAdapter, C0970a newAdapter, boolean compatibleWithPrevious) {
            if (oldAdapter != null) {
                mo7884b();
            }
            if (!compatibleWithPrevious && this.f3195b == 0) {
                mo7878a();
            }
            if (newAdapter != null) {
                mo7880a(newAdapter);
            }
        }

        /* renamed from: b */
        private C0990a m4876b(int viewType) {
            C0990a scrapData = (C0990a) this.f3194a.get(viewType);
            if (scrapData != null) {
                return scrapData;
            }
            C0990a scrapData2 = new C0990a();
            this.f3194a.put(viewType, scrapData2);
            return scrapData2;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$p */
    public final class C0991p {

        /* renamed from: a */
        final ArrayList<C1000w> f3200a = new ArrayList<>();

        /* renamed from: b */
        ArrayList<C1000w> f3201b = null;

        /* renamed from: c */
        final ArrayList<C1000w> f3202c = new ArrayList<>();

        /* renamed from: d */
        private final List<C1000w> f3203d = Collections.unmodifiableList(this.f3200a);

        /* renamed from: e */
        private int f3204e = 2;

        /* renamed from: f */
        int f3205f = 2;

        /* renamed from: g */
        C0989o f3206g;

        /* renamed from: h */
        private C0998u f3207h;

        public C0991p() {
        }

        /* renamed from: a */
        public void mo7891a() {
            this.f3200a.clear();
            mo7920i();
        }

        /* renamed from: f */
        public void mo7917f(int viewCount) {
            this.f3204e = viewCount;
            mo7921j();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: j */
        public void mo7921j() {
            C0981i iVar = RecyclerView.this.f3166w;
            this.f3205f = this.f3204e + (iVar != null ? iVar.mPrefetchMaxCountObserved : 0);
            for (int i = this.f3202c.size() - 1; i >= 0 && this.f3202c.size() > this.f3205f; i--) {
                mo7915e(i);
            }
        }

        /* renamed from: f */
        public List<C1000w> mo7916f() {
            return this.f3203d;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public boolean mo7913d(C1000w holder) {
            if (holder.isRemoved()) {
                return RecyclerView.this.f3157ra.mo7950d();
            }
            int i = holder.mPosition;
            if (i < 0 || i >= RecyclerView.this.f3164v.getItemCount()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Inconsistency detected. Invalid view holder adapter position");
                sb.append(holder);
                sb.append(RecyclerView.this.mo7625k());
                throw new IndexOutOfBoundsException(sb.toString());
            }
            boolean z = false;
            if (!RecyclerView.this.f3157ra.mo7950d() && RecyclerView.this.f3164v.getItemViewType(holder.mPosition) != holder.getItemViewType()) {
                return false;
            }
            if (!RecyclerView.this.f3164v.hasStableIds()) {
                return true;
            }
            if (holder.getItemId() == RecyclerView.this.f3164v.getItemId(holder.mPosition)) {
                z = true;
            }
            return z;
        }

        /* renamed from: a */
        private boolean m4889a(C1000w holder, int offsetPosition, int position, long deadlineNs) {
            holder.mOwnerRecyclerView = RecyclerView.this;
            int viewType = holder.getItemViewType();
            long startBindNs = RecyclerView.this.getNanoTime();
            if (deadlineNs != Long.MAX_VALUE && !this.f3206g.mo7883a(viewType, startBindNs, deadlineNs)) {
                return false;
            }
            RecyclerView.this.f3164v.bindViewHolder(holder, offsetPosition);
            this.f3206g.mo7879a(holder.getItemViewType(), RecyclerView.this.getNanoTime() - startBindNs);
            m4890e(holder);
            if (RecyclerView.this.f3157ra.mo7950d()) {
                holder.mPreLayoutPosition = position;
            }
            return true;
        }

        /* renamed from: a */
        public int mo7887a(int position) {
            if (position < 0 || position >= RecyclerView.this.f3157ra.mo7945a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("invalid position ");
                sb.append(position);
                sb.append(". State ");
                sb.append("item count is ");
                sb.append(RecyclerView.this.f3157ra.mo7945a());
                sb.append(RecyclerView.this.mo7625k());
                throw new IndexOutOfBoundsException(sb.toString());
            } else if (!RecyclerView.this.f3157ra.mo7950d()) {
                return position;
            } else {
                return RecyclerView.this.f3148n.mo8475b(position);
            }
        }

        /* renamed from: d */
        public View mo7912d(int position) {
            return mo7901b(position, false);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public View mo7901b(int position, boolean dryRun) {
            return mo7889a(position, dryRun, Long.MAX_VALUE).itemView;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1000w mo7889a(int position, boolean dryRun, long deadlineNs) {
            C1000w holder;
            boolean fromScrapOrHiddenOrCache;
            C0984j rvLayoutParams;
            int i = position;
            boolean z = dryRun;
            if (i < 0 || i >= RecyclerView.this.f3157ra.mo7945a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid item position ");
                sb.append(i);
                sb.append("(");
                sb.append(i);
                sb.append("). Item count:");
                sb.append(RecyclerView.this.f3157ra.mo7945a());
                sb.append(RecyclerView.this.mo7625k());
                throw new IndexOutOfBoundsException(sb.toString());
            }
            boolean fromScrapOrHiddenOrCache2 = false;
            C1000w holder2 = null;
            boolean z2 = true;
            if (RecyclerView.this.f3157ra.mo7950d()) {
                holder2 = mo7900b(position);
                fromScrapOrHiddenOrCache2 = holder2 != null;
            }
            if (holder2 == null) {
                holder2 = mo7888a(position, dryRun);
                if (holder2 != null) {
                    if (!mo7913d(holder2)) {
                        if (!z) {
                            holder2.addFlags(4);
                            if (holder2.isScrap()) {
                                RecyclerView.this.removeDetachedView(holder2.itemView, false);
                                holder2.unScrap();
                            } else if (holder2.wasReturnedFromScrap()) {
                                holder2.clearReturnedFromScrapFlag();
                            }
                            mo7904b(holder2);
                        }
                        holder2 = null;
                    } else {
                        fromScrapOrHiddenOrCache2 = true;
                    }
                }
            }
            if (holder2 == null) {
                int offsetPosition = RecyclerView.this.f3148n.mo8475b(i);
                if (offsetPosition < 0 || offsetPosition >= RecyclerView.this.f3164v.getItemCount()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Inconsistency detected. Invalid item position ");
                    sb2.append(i);
                    sb2.append("(offset:");
                    sb2.append(offsetPosition);
                    sb2.append(").");
                    sb2.append("state:");
                    sb2.append(RecyclerView.this.f3157ra.mo7945a());
                    sb2.append(RecyclerView.this.mo7625k());
                    throw new IndexOutOfBoundsException(sb2.toString());
                }
                int type = RecyclerView.this.f3164v.getItemViewType(offsetPosition);
                if (RecyclerView.this.f3164v.hasStableIds()) {
                    holder2 = mo7890a(RecyclerView.this.f3164v.getItemId(offsetPosition), type, z);
                    if (holder2 != null) {
                        holder2.mPosition = offsetPosition;
                        fromScrapOrHiddenOrCache2 = true;
                    }
                }
                if (holder2 == null) {
                    C0998u uVar = this.f3207h;
                    if (uVar != null) {
                        View view = uVar.mo7953a(this, i, type);
                        if (view != null) {
                            holder2 = RecyclerView.this.mo7616i(view);
                            if (holder2 == null) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                sb3.append(RecyclerView.this.mo7625k());
                                throw new IllegalArgumentException(sb3.toString());
                            } else if (holder2.shouldIgnore()) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                sb4.append(RecyclerView.this.mo7625k());
                                throw new IllegalArgumentException(sb4.toString());
                            }
                        }
                    }
                }
                if (holder2 == null) {
                    holder2 = mo7911d().mo7877a(type);
                    if (holder2 != null) {
                        holder2.resetInternal();
                        if (RecyclerView.f3093c) {
                            m4891f(holder2);
                        }
                    }
                }
                if (holder2 == null) {
                    long start = RecyclerView.this.getNanoTime();
                    if (deadlineNs != Long.MAX_VALUE && !this.f3206g.mo7886b(type, start, deadlineNs)) {
                        return null;
                    }
                    RecyclerView recyclerView = RecyclerView.this;
                    C1000w holder3 = recyclerView.f3164v.createViewHolder(recyclerView, type);
                    if (RecyclerView.f3096f) {
                        RecyclerView innerView = RecyclerView.m4734e(holder3.itemView);
                        if (innerView != null) {
                            holder3.mNestedRecyclerView = new WeakReference<>(innerView);
                        }
                    }
                    this.f3206g.mo7885b(type, RecyclerView.this.getNanoTime() - start);
                    fromScrapOrHiddenOrCache = fromScrapOrHiddenOrCache2;
                    holder = holder3;
                } else {
                    fromScrapOrHiddenOrCache = fromScrapOrHiddenOrCache2;
                    holder = holder2;
                }
            } else {
                fromScrapOrHiddenOrCache = fromScrapOrHiddenOrCache2;
                holder = holder2;
            }
            if (fromScrapOrHiddenOrCache && !RecyclerView.this.f3157ra.mo7950d() && holder.hasAnyOfTheFlags(Opcodes.ACC_ANNOTATION)) {
                holder.setFlags(0, Opcodes.ACC_ANNOTATION);
                if (RecyclerView.this.f3157ra.f3227k) {
                    int changeFlags = C0975f.m4838a(holder) | Opcodes.ACC_SYNTHETIC;
                    RecyclerView recyclerView2 = RecyclerView.this;
                    RecyclerView.this.mo7532a(holder, recyclerView2.f3131W.mo7720a(recyclerView2.f3157ra, holder, changeFlags, holder.getUnmodifiedPayloads()));
                }
            }
            boolean bound = false;
            if (RecyclerView.this.f3157ra.mo7950d() && holder.isBound()) {
                holder.mPreLayoutPosition = i;
            } else if (!holder.isBound() || holder.needsUpdate() || holder.isInvalid()) {
                bound = m4889a(holder, RecyclerView.this.f3148n.mo8475b(i), position, deadlineNs);
            }
            LayoutParams lp = holder.itemView.getLayoutParams();
            if (lp == null) {
                rvLayoutParams = (C0984j) RecyclerView.this.generateDefaultLayoutParams();
                holder.itemView.setLayoutParams(rvLayoutParams);
            } else if (!RecyclerView.this.checkLayoutParams(lp)) {
                rvLayoutParams = (C0984j) RecyclerView.this.generateLayoutParams(lp);
                holder.itemView.setLayoutParams(rvLayoutParams);
            } else {
                rvLayoutParams = (C0984j) lp;
            }
            rvLayoutParams.f3190a = holder;
            if (!fromScrapOrHiddenOrCache || !bound) {
                z2 = false;
            }
            rvLayoutParams.f3193d = z2;
            return holder;
        }

        /* renamed from: e */
        private void m4890e(C1000w holder) {
            if (RecyclerView.this.mo7646p()) {
                View itemView = holder.itemView;
                if (C0646w.m2973g(itemView) == 0) {
                    C0646w.m2970d(itemView, 1);
                }
                if (!C0646w.m2982p(itemView)) {
                    holder.addFlags(Opcodes.ACC_ENUM);
                    C0646w.m2955a(itemView, RecyclerView.this.f3171ya.mo6282b());
                }
            }
        }

        /* renamed from: f */
        private void m4891f(C1000w holder) {
            View view = holder.itemView;
            if (view instanceof ViewGroup) {
                m4888a((ViewGroup) view, false);
            }
        }

        /* renamed from: a */
        private void m4888a(ViewGroup viewGroup, boolean invalidateThis) {
            for (int i = viewGroup.getChildCount() - 1; i >= 0; i--) {
                View view = viewGroup.getChildAt(i);
                if (view instanceof ViewGroup) {
                    m4888a((ViewGroup) view, true);
                }
            }
            if (invalidateThis) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        /* renamed from: b */
        public void mo7905b(View view) {
            C1000w holder = RecyclerView.m4736j(view);
            if (holder.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (holder.isScrap()) {
                holder.unScrap();
            } else if (holder.wasReturnedFromScrap()) {
                holder.clearReturnedFromScrapFlag();
            }
            mo7904b(holder);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: i */
        public void mo7920i() {
            for (int i = this.f3202c.size() - 1; i >= 0; i--) {
                mo7915e(i);
            }
            this.f3202c.clear();
            if (RecyclerView.f3096f) {
                RecyclerView.this.f3155qa.mo8547a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo7915e(int cachedViewIndex) {
            mo7898a((C1000w) this.f3202c.get(cachedViewIndex), true);
            this.f3202c.remove(cachedViewIndex);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo7904b(C1000w holder) {
            boolean z = false;
            if (holder.isScrap() || holder.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(holder.isScrap());
                sb.append(" isAttached:");
                if (holder.itemView.getParent() != null) {
                    z = true;
                }
                sb.append(z);
                sb.append(RecyclerView.this.mo7625k());
                throw new IllegalArgumentException(sb.toString());
            } else if (holder.isTmpDetached()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb2.append(holder);
                sb2.append(RecyclerView.this.mo7625k());
                throw new IllegalArgumentException(sb2.toString());
            } else if (!holder.shouldIgnore()) {
                boolean transientStatePreventsRecycling = holder.doesTransientStatePreventRecycling();
                C0970a aVar = RecyclerView.this.f3164v;
                boolean cached = false;
                boolean recycled = false;
                if ((aVar != null && transientStatePreventsRecycling && aVar.onFailedToRecycleView(holder)) || holder.isRecyclable()) {
                    if (this.f3205f > 0 && !holder.hasAnyOfTheFlags(526)) {
                        int cachedViewSize = this.f3202c.size();
                        if (cachedViewSize >= this.f3205f && cachedViewSize > 0) {
                            mo7915e(0);
                            cachedViewSize--;
                        }
                        int targetCacheIndex = cachedViewSize;
                        if (RecyclerView.f3096f && cachedViewSize > 0 && !RecyclerView.this.f3155qa.mo8549a(holder.mPosition)) {
                            int cacheIndex = cachedViewSize - 1;
                            while (cacheIndex >= 0) {
                                if (!RecyclerView.this.f3155qa.mo8549a(((C1000w) this.f3202c.get(cacheIndex)).mPosition)) {
                                    break;
                                }
                                cacheIndex--;
                            }
                            targetCacheIndex = cacheIndex + 1;
                        }
                        this.f3202c.add(targetCacheIndex, holder);
                        cached = true;
                    }
                    if (!cached) {
                        mo7898a(holder, true);
                        recycled = true;
                    }
                }
                RecyclerView.this.f3152p.mo7324h(holder);
                if (!cached && !recycled && transientStatePreventsRecycling) {
                    holder.mOwnerRecyclerView = null;
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                sb3.append(RecyclerView.this.mo7625k());
                throw new IllegalArgumentException(sb3.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7898a(C1000w holder, boolean dispatchRecycled) {
            RecyclerView.m4730b(holder);
            if (holder.hasAnyOfTheFlags(Opcodes.ACC_ENUM)) {
                holder.setFlags(0, Opcodes.ACC_ENUM);
                C0646w.m2955a(holder.itemView, (C0616c) null);
            }
            if (dispatchRecycled) {
                mo7897a(holder);
            }
            holder.mOwnerRecyclerView = null;
            mo7911d().mo7882a(holder);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7899a(View view) {
            C1000w holder = RecyclerView.m4736j(view);
            holder.mScrapContainer = null;
            holder.mInChangeScrap = false;
            holder.clearReturnedFromScrapFlag();
            mo7904b(holder);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo7910c(View view) {
            C1000w holder = RecyclerView.m4736j(view);
            if (!holder.hasAnyOfTheFlags(12) && holder.isUpdated() && !RecyclerView.this.mo7540a(holder)) {
                if (this.f3201b == null) {
                    this.f3201b = new ArrayList<>();
                }
                holder.setScrapContainer(this, true);
                this.f3201b.add(holder);
            } else if (!holder.isInvalid() || holder.isRemoved() || RecyclerView.this.f3164v.hasStableIds()) {
                holder.setScrapContainer(this, false);
                this.f3200a.add(holder);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                sb.append(RecyclerView.this.mo7625k());
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo7909c(C1000w holder) {
            if (holder.mInChangeScrap) {
                this.f3201b.remove(holder);
            } else {
                this.f3200a.remove(holder);
            }
            holder.mScrapContainer = null;
            holder.mInChangeScrap = false;
            holder.clearReturnedFromScrapFlag();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public int mo7914e() {
            return this.f3200a.size();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public View mo7906c(int index) {
            return ((C1000w) this.f3200a.get(index)).itemView;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo7907c() {
            this.f3200a.clear();
            ArrayList<C1000w> arrayList = this.f3201b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1000w mo7900b(int position) {
            ArrayList<C1000w> arrayList = this.f3201b;
            if (arrayList != null) {
                int size = arrayList.size();
                int changedScrapSize = size;
                if (size != 0) {
                    int i = 0;
                    while (i < changedScrapSize) {
                        C1000w holder = (C1000w) this.f3201b.get(i);
                        if (holder.wasReturnedFromScrap() || holder.getLayoutPosition() != position) {
                            i++;
                        } else {
                            holder.addFlags(32);
                            return holder;
                        }
                    }
                    if (RecyclerView.this.f3164v.hasStableIds()) {
                        int offsetPosition = RecyclerView.this.f3148n.mo8475b(position);
                        if (offsetPosition > 0 && offsetPosition < RecyclerView.this.f3164v.getItemCount()) {
                            long id = RecyclerView.this.f3164v.getItemId(offsetPosition);
                            int i2 = 0;
                            while (i2 < changedScrapSize) {
                                C1000w holder2 = (C1000w) this.f3201b.get(i2);
                                if (holder2.wasReturnedFromScrap() || holder2.getItemId() != id) {
                                    i2++;
                                } else {
                                    holder2.addFlags(32);
                                    return holder2;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1000w mo7888a(int position, boolean dryRun) {
            int scrapCount = this.f3200a.size();
            int i = 0;
            while (i < scrapCount) {
                C1000w holder = (C1000w) this.f3200a.get(i);
                if (holder.wasReturnedFromScrap() || holder.getLayoutPosition() != position || holder.isInvalid() || (!RecyclerView.this.f3157ra.f3224h && holder.isRemoved())) {
                    i++;
                } else {
                    holder.addFlags(32);
                    return holder;
                }
            }
            if (!dryRun) {
                View view = RecyclerView.this.f3150o.mo8006b(position);
                if (view != null) {
                    C1000w vh = RecyclerView.m4736j(view);
                    RecyclerView.this.f3150o.mo8014f(view);
                    int layoutIndex = RecyclerView.this.f3150o.mo8005b(view);
                    if (layoutIndex != -1) {
                        RecyclerView.this.f3150o.mo7999a(layoutIndex);
                        mo7910c(view);
                        vh.addFlags(8224);
                        return vh;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("layout index should not be -1 after unhiding a view:");
                    sb.append(vh);
                    sb.append(RecyclerView.this.mo7625k());
                    throw new IllegalStateException(sb.toString());
                }
            }
            int cacheSize = this.f3202c.size();
            int i2 = 0;
            while (i2 < cacheSize) {
                C1000w holder2 = (C1000w) this.f3202c.get(i2);
                if (holder2.isInvalid() || holder2.getLayoutPosition() != position) {
                    i2++;
                } else {
                    if (!dryRun) {
                        this.f3202c.remove(i2);
                    }
                    return holder2;
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1000w mo7890a(long id, int type, boolean dryRun) {
            for (int i = this.f3200a.size() - 1; i >= 0; i--) {
                C1000w holder = (C1000w) this.f3200a.get(i);
                if (holder.getItemId() == id && !holder.wasReturnedFromScrap()) {
                    if (type == holder.getItemViewType()) {
                        holder.addFlags(32);
                        if (holder.isRemoved() && !RecyclerView.this.f3157ra.mo7950d()) {
                            holder.setFlags(2, 14);
                        }
                        return holder;
                    } else if (!dryRun) {
                        this.f3200a.remove(i);
                        RecyclerView.this.removeDetachedView(holder.itemView, false);
                        mo7899a(holder.itemView);
                    }
                }
            }
            for (int i2 = this.f3202c.size() - 1; i2 >= 0; i2--) {
                C1000w holder2 = (C1000w) this.f3202c.get(i2);
                if (holder2.getItemId() == id) {
                    if (type == holder2.getItemViewType()) {
                        if (!dryRun) {
                            this.f3202c.remove(i2);
                        }
                        return holder2;
                    } else if (!dryRun) {
                        mo7915e(i2);
                        return null;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7897a(C1000w holder) {
            C0992q qVar = RecyclerView.this.f3168x;
            if (qVar != null) {
                qVar.mo7922a(holder);
            }
            C0970a aVar = RecyclerView.this.f3164v;
            if (aVar != null) {
                aVar.onViewRecycled(holder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3157ra != null) {
                recyclerView.f3152p.mo7324h(holder);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7894a(C0970a oldAdapter, C0970a newAdapter, boolean compatibleWithPrevious) {
            mo7891a();
            mo7911d().mo7881a(oldAdapter, newAdapter, compatibleWithPrevious);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo7903b(int from, int to) {
            int inBetweenOffset;
            int end;
            int start;
            if (from < to) {
                start = from;
                end = to;
                inBetweenOffset = -1;
            } else {
                start = to;
                end = from;
                inBetweenOffset = 1;
            }
            int cachedCount = this.f3202c.size();
            for (int i = 0; i < cachedCount; i++) {
                C1000w holder = (C1000w) this.f3202c.get(i);
                if (holder != null) {
                    int i2 = holder.mPosition;
                    if (i2 >= start && i2 <= end) {
                        if (i2 == from) {
                            holder.offsetPosition(to - from, false);
                        } else {
                            holder.offsetPosition(inBetweenOffset, false);
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7892a(int insertedAt, int count) {
            int cachedCount = this.f3202c.size();
            for (int i = 0; i < cachedCount; i++) {
                C1000w holder = (C1000w) this.f3202c.get(i);
                if (holder != null && holder.mPosition >= insertedAt) {
                    holder.offsetPosition(count, true);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7893a(int removedFrom, int count, boolean applyToPreLayout) {
            int removedEnd = removedFrom + count;
            for (int i = this.f3202c.size() - 1; i >= 0; i--) {
                C1000w holder = (C1000w) this.f3202c.get(i);
                if (holder != null) {
                    int i2 = holder.mPosition;
                    if (i2 >= removedEnd) {
                        holder.offsetPosition(-count, applyToPreLayout);
                    } else if (i2 >= removedFrom) {
                        holder.addFlags(8);
                        mo7915e(i);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7896a(C0998u extension) {
            this.f3207h = extension;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7895a(C0989o pool) {
            C0989o oVar = this.f3206g;
            if (oVar != null) {
                oVar.mo7884b();
            }
            this.f3206g = pool;
            if (pool != null) {
                this.f3206g.mo7880a(RecyclerView.this.getAdapter());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public C0989o mo7911d() {
            if (this.f3206g == null) {
                this.f3206g = new C0989o();
            }
            return this.f3206g;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo7908c(int positionStart, int itemCount) {
            int positionEnd = positionStart + itemCount;
            for (int i = this.f3202c.size() - 1; i >= 0; i--) {
                C1000w holder = (C1000w) this.f3202c.get(i);
                if (holder != null) {
                    int pos = holder.mPosition;
                    if (pos >= positionStart && pos < positionEnd) {
                        holder.addFlags(2);
                        mo7915e(i);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public void mo7919h() {
            int cachedCount = this.f3202c.size();
            for (int i = 0; i < cachedCount; i++) {
                C1000w holder = (C1000w) this.f3202c.get(i);
                if (holder != null) {
                    holder.addFlags(6);
                    holder.addChangePayload(null);
                }
            }
            C0970a aVar = RecyclerView.this.f3164v;
            if (aVar == null || !aVar.hasStableIds()) {
                mo7920i();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo7902b() {
            int cachedCount = this.f3202c.size();
            for (int i = 0; i < cachedCount; i++) {
                ((C1000w) this.f3202c.get(i)).clearOldPosition();
            }
            int scrapCount = this.f3200a.size();
            for (int i2 = 0; i2 < scrapCount; i2++) {
                ((C1000w) this.f3200a.get(i2)).clearOldPosition();
            }
            ArrayList<C1000w> arrayList = this.f3201b;
            if (arrayList != null) {
                int changedScrapCount = arrayList.size();
                for (int i3 = 0; i3 < changedScrapCount; i3++) {
                    ((C1000w) this.f3201b.get(i3)).clearOldPosition();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public void mo7918g() {
            int cachedCount = this.f3202c.size();
            for (int i = 0; i < cachedCount; i++) {
                C0984j layoutParams = (C0984j) ((C1000w) this.f3202c.get(i)).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f3192c = true;
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$q */
    public interface C0992q {
        /* renamed from: a */
        void mo7922a(C1000w wVar);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$r */
    private class C0993r extends C0972c {
        C0993r() {
        }

        public void onChanged() {
            RecyclerView.this.mo7552b((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3157ra.f3223g = true;
            recyclerView.mo7553b(true);
            if (!RecyclerView.this.f3148n.mo8478c()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            RecyclerView.this.mo7552b((String) null);
            if (RecyclerView.this.f3148n.mo8474a(positionStart, itemCount, payload)) {
                mo7923a();
            }
        }

        public void onItemRangeInserted(int positionStart, int itemCount) {
            RecyclerView.this.mo7552b((String) null);
            if (RecyclerView.this.f3148n.mo8477b(positionStart, itemCount)) {
                mo7923a();
            }
        }

        public void onItemRangeRemoved(int positionStart, int itemCount) {
            RecyclerView.this.mo7552b((String) null);
            if (RecyclerView.this.f3148n.mo8480c(positionStart, itemCount)) {
                mo7923a();
            }
        }

        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            RecyclerView.this.mo7552b((String) null);
            if (RecyclerView.this.f3148n.mo8473a(fromPosition, toPosition, itemCount)) {
                mo7923a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7923a() {
            if (RecyclerView.f3095e) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f3105C && recyclerView.f3103B) {
                    C0646w.m2958a((View) recyclerView, recyclerView.f3156r);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.f3119K = true;
            recyclerView2.requestLayout();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$s */
    public static abstract class C0994s {
        private C0981i mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final C0995a mRecyclingAction = new C0995a(0, 0);
        private boolean mRunning;
        private int mTargetPosition = -1;
        private View mTargetView;

        /* renamed from: android.support.v7.widget.RecyclerView$s$a */
        public static class C0995a {

            /* renamed from: a */
            private int f3210a;

            /* renamed from: b */
            private int f3211b;

            /* renamed from: c */
            private int f3212c;

            /* renamed from: d */
            private int f3213d;

            /* renamed from: e */
            private Interpolator f3214e;

            /* renamed from: f */
            private boolean f3215f;

            /* renamed from: g */
            private int f3216g;

            public C0995a(int dx, int dy) {
                this(dx, dy, LinearLayoutManager.INVALID_OFFSET, null);
            }

            public C0995a(int dx, int dy, int duration, Interpolator interpolator) {
                this.f3213d = -1;
                this.f3215f = false;
                this.f3216g = 0;
                this.f3210a = dx;
                this.f3211b = dy;
                this.f3212c = duration;
                this.f3214e = interpolator;
            }

            /* renamed from: a */
            public void mo7941a(int targetPosition) {
                this.f3213d = targetPosition;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public boolean mo7944a() {
                return this.f3213d >= 0;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo7943a(RecyclerView recyclerView) {
                if (this.f3213d >= 0) {
                    int position = this.f3213d;
                    this.f3213d = -1;
                    recyclerView.mo7581e(position);
                    this.f3215f = false;
                    return;
                }
                if (this.f3215f != 0) {
                    m4929b();
                    Interpolator interpolator = this.f3214e;
                    if (interpolator == null) {
                        int i = this.f3212c;
                        if (i == Integer.MIN_VALUE) {
                            recyclerView.f3151oa.mo7961b(this.f3210a, this.f3211b);
                        } else {
                            recyclerView.f3151oa.mo7956a(this.f3210a, this.f3211b, i);
                        }
                    } else {
                        recyclerView.f3151oa.mo7958a(this.f3210a, this.f3211b, this.f3212c, interpolator);
                    }
                    this.f3216g++;
                    if (this.f3216g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f3215f = false;
                } else {
                    this.f3216g = 0;
                }
            }

            /* renamed from: b */
            private void m4929b() {
                if (this.f3214e != null && this.f3212c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f3212c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* renamed from: a */
            public void mo7942a(int dx, int dy, int duration, Interpolator interpolator) {
                this.f3210a = dx;
                this.f3211b = dy;
                this.f3212c = duration;
                this.f3214e = interpolator;
                this.f3215f = true;
            }
        }

        /* renamed from: android.support.v7.widget.RecyclerView$s$b */
        public interface C0996b {
            PointF computeScrollVectorForPosition(int i);
        }

        /* access modifiers changed from: protected */
        public abstract void onSeekTargetStep(int i, int i2, C0997t tVar, C0995a aVar);

        /* access modifiers changed from: protected */
        public abstract void onStart();

        /* access modifiers changed from: protected */
        public abstract void onStop();

        /* access modifiers changed from: protected */
        public abstract void onTargetFound(View view, C0997t tVar, C0995a aVar);

        /* access modifiers changed from: 0000 */
        public void start(RecyclerView recyclerView, C0981i layoutManager) {
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            int i = this.mTargetPosition;
            if (i != -1) {
                this.mRecyclerView.f3157ra.f3217a = i;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.f3151oa.mo7954a();
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public void setTargetPosition(int targetPosition) {
            this.mTargetPosition = targetPosition;
        }

        public C0981i getLayoutManager() {
            return this.mLayoutManager;
        }

        /* access modifiers changed from: protected */
        public final void stop() {
            if (this.mRunning) {
                onStop();
                this.mRecyclerView.f3157ra.f3217a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mRunning = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        /* access modifiers changed from: private */
        public void onAnimation(int dx, int dy) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (!this.mRunning || this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.f3157ra, this.mRecyclingAction);
                    this.mRecyclingAction.mo7943a(recyclerView);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(dx, dy, recyclerView.f3157ra, this.mRecyclingAction);
                boolean hadJumpTarget = this.mRecyclingAction.mo7944a();
                this.mRecyclingAction.mo7943a(recyclerView);
                if (!hadJumpTarget) {
                    return;
                }
                if (this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.f3151oa.mo7954a();
                    return;
                }
                stop();
            }
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.mo7588g(view);
        }

        public int getChildCount() {
            return this.mRecyclerView.f3166w.getChildCount();
        }

        public View findViewByPosition(int position) {
            return this.mRecyclerView.f3166w.findViewByPosition(position);
        }

        @Deprecated
        public void instantScrollToPosition(int position) {
            this.mRecyclerView.mo7618i(position);
        }

        /* access modifiers changed from: protected */
        public void onChildAttachedToWindow(View child) {
            if (getChildPosition(child) == getTargetPosition()) {
                this.mTargetView = child;
            }
        }

        /* access modifiers changed from: protected */
        public void normalize(PointF scrollVector) {
            float f = scrollVector.x;
            float f2 = f * f;
            float f3 = scrollVector.y;
            float magnitude = (float) Math.sqrt((double) (f2 + (f3 * f3)));
            scrollVector.x /= magnitude;
            scrollVector.y /= magnitude;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$t */
    public static class C0997t {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f3217a = -1;

        /* renamed from: b */
        private SparseArray<Object> f3218b;

        /* renamed from: c */
        int f3219c = 0;

        /* renamed from: d */
        int f3220d = 0;

        /* renamed from: e */
        int f3221e = 1;

        /* renamed from: f */
        int f3222f = 0;

        /* renamed from: g */
        boolean f3223g = false;

        /* renamed from: h */
        boolean f3224h = false;

        /* renamed from: i */
        boolean f3225i = false;

        /* renamed from: j */
        boolean f3226j = false;

        /* renamed from: k */
        boolean f3227k = false;

        /* renamed from: l */
        boolean f3228l = false;

        /* renamed from: m */
        int f3229m;

        /* renamed from: n */
        long f3230n;

        /* renamed from: o */
        int f3231o;

        /* renamed from: p */
        int f3232p;

        /* renamed from: q */
        int f3233q;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7946a(int accepted) {
            if ((this.f3221e & accepted) == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Layout state should be one of ");
                sb.append(Integer.toBinaryString(accepted));
                sb.append(" but it is ");
                sb.append(Integer.toBinaryString(this.f3221e));
                throw new IllegalStateException(sb.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7947a(C0970a adapter) {
            this.f3221e = 1;
            this.f3222f = adapter.getItemCount();
            this.f3224h = false;
            this.f3225i = false;
            this.f3226j = false;
        }

        /* renamed from: d */
        public boolean mo7950d() {
            return this.f3224h;
        }

        /* renamed from: e */
        public boolean mo7951e() {
            return this.f3228l;
        }

        /* renamed from: b */
        public int mo7948b() {
            return this.f3217a;
        }

        /* renamed from: c */
        public boolean mo7949c() {
            return this.f3217a != -1;
        }

        /* renamed from: a */
        public int mo7945a() {
            return this.f3224h ? this.f3219c - this.f3220d : this.f3222f;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("State{mTargetPosition=");
            sb.append(this.f3217a);
            sb.append(", mData=");
            sb.append(this.f3218b);
            sb.append(", mItemCount=");
            sb.append(this.f3222f);
            sb.append(", mIsMeasuring=");
            sb.append(this.f3226j);
            sb.append(", mPreviousLayoutItemCount=");
            sb.append(this.f3219c);
            sb.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            sb.append(this.f3220d);
            sb.append(", mStructureChanged=");
            sb.append(this.f3223g);
            sb.append(", mInPreLayout=");
            sb.append(this.f3224h);
            sb.append(", mRunSimpleAnimations=");
            sb.append(this.f3227k);
            sb.append(", mRunPredictiveAnimations=");
            sb.append(this.f3228l);
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$u */
    public static abstract class C0998u {
        /* renamed from: a */
        public abstract View mo7953a(C0991p pVar, int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$v */
    class C0999v implements Runnable {

        /* renamed from: a */
        private int f3234a;

        /* renamed from: b */
        private int f3235b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public OverScroller f3236c;

        /* renamed from: d */
        Interpolator f3237d = RecyclerView.f3100j;

        /* renamed from: e */
        private boolean f3238e = false;

        /* renamed from: f */
        private boolean f3239f = false;

        C0999v() {
            this.f3236c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.f3100j);
        }

        public void run() {
            int overscrollY;
            int overscrollX;
            int adapterSize;
            int velX;
            int velY;
            if (RecyclerView.this.f3166w == null) {
                mo7960b();
                return;
            }
            m4946c();
            RecyclerView.this.mo7569d();
            OverScroller scroller = this.f3236c;
            C0994s smoothScroller = RecyclerView.this.f3166w.mSmoothScroller;
            if (scroller.computeScrollOffset()) {
                int[] scrollConsumed = RecyclerView.this.f3108Da;
                int x = scroller.getCurrX();
                int y = scroller.getCurrY();
                int dx = x - this.f3234a;
                int dy = y - this.f3235b;
                int hresult = 0;
                int vresult = 0;
                this.f3234a = x;
                this.f3235b = y;
                int overscrollX2 = 0;
                int overscrollY2 = 0;
                if (RecyclerView.this.mo7539a(dx, dy, scrollConsumed, (int[]) null, 1)) {
                    dx -= scrollConsumed[0];
                    dy -= scrollConsumed[1];
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f3164v != null) {
                    recyclerView.mo7684z();
                    RecyclerView.this.mo7678t();
                    C0574d.m2755a("RV Scroll");
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.mo7531a(recyclerView2.f3157ra);
                    if (dx != 0) {
                        RecyclerView recyclerView3 = RecyclerView.this;
                        hresult = recyclerView3.f3166w.scrollHorizontallyBy(dx, recyclerView3.f3144l, recyclerView3.f3157ra);
                        overscrollX2 = dx - hresult;
                    }
                    if (dy != 0) {
                        RecyclerView recyclerView4 = RecyclerView.this;
                        vresult = recyclerView4.f3166w.scrollVerticallyBy(dy, recyclerView4.f3144l, recyclerView4.f3157ra);
                        overscrollY2 = dy - vresult;
                    }
                    C0574d.m2754a();
                    RecyclerView.this.mo7682x();
                    RecyclerView.this.mo7679u();
                    RecyclerView.this.mo7559c(false);
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int adapterSize2 = RecyclerView.this.f3157ra.mo7945a();
                        if (adapterSize2 == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= adapterSize2) {
                            smoothScroller.setTargetPosition(adapterSize2 - 1);
                            smoothScroller.onAnimation(dx - overscrollX2, dy - overscrollY2);
                        } else {
                            smoothScroller.onAnimation(dx - overscrollX2, dy - overscrollY2);
                        }
                    }
                    adapterSize = vresult;
                    overscrollX = overscrollX2;
                    overscrollY = overscrollY2;
                } else {
                    adapterSize = 0;
                    overscrollX = 0;
                    overscrollY = 0;
                }
                if (!RecyclerView.this.f3170y.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.mo7546b(dx, dy);
                }
                if (RecyclerView.this.mo7537a(hresult, adapterSize, overscrollX, overscrollY, (int[]) null, 1)) {
                } else if (overscrollX == 0 && overscrollY == 0) {
                    int[] iArr = scrollConsumed;
                } else {
                    int vel = (int) scroller.getCurrVelocity();
                    if (overscrollX != x) {
                        velX = overscrollX < 0 ? -vel : overscrollX > 0 ? vel : 0;
                    } else {
                        velX = 0;
                    }
                    if (overscrollY != y) {
                        velY = overscrollY < 0 ? -vel : overscrollY > 0 ? vel : 0;
                    } else {
                        velY = 0;
                    }
                    int[] iArr2 = scrollConsumed;
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        RecyclerView.this.mo7522a(velX, velY);
                    }
                    if ((velX != 0 || overscrollX == x || scroller.getFinalX() == 0) && (velY != 0 || overscrollY == y || scroller.getFinalY() == 0)) {
                        scroller.abortAnimation();
                    }
                }
                if (!(hresult == 0 && adapterSize == 0)) {
                    RecyclerView.this.mo7570d(hresult, adapterSize);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean fullyConsumedAny = (dx == 0 && dy == 0) || (dx != 0 && RecyclerView.this.f3166w.canScrollHorizontally() && hresult == dx) || (dy != 0 && RecyclerView.this.f3166w.canScrollVertically() && adapterSize == dy);
                if (scroller.isFinished() || (!fullyConsumedAny && !RecyclerView.this.mo7571d(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.f3096f) {
                        RecyclerView.this.f3155qa.mo8547a();
                    }
                    RecyclerView.this.mo7626k(1);
                } else {
                    mo7954a();
                    RecyclerView recyclerView5 = RecyclerView.this;
                    C1089na naVar = recyclerView5.f3153pa;
                    if (naVar != null) {
                        naVar.mo8544a(recyclerView5, dx, dy);
                    }
                }
            }
            if (smoothScroller != null) {
                if (smoothScroller.isPendingInitialRun()) {
                    smoothScroller.onAnimation(0, 0);
                }
                if (!this.f3239f) {
                    smoothScroller.stop();
                }
            }
            m4947d();
        }

        /* renamed from: c */
        private void m4946c() {
            this.f3239f = false;
            this.f3238e = true;
        }

        /* renamed from: d */
        private void m4947d() {
            this.f3238e = false;
            if (this.f3239f) {
                mo7954a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7954a() {
            if (this.f3238e) {
                this.f3239f = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            C0646w.m2958a((View) RecyclerView.this, (Runnable) this);
        }

        /* renamed from: a */
        public void mo7955a(int velocityX, int velocityY) {
            RecyclerView.this.setScrollState(2);
            this.f3235b = 0;
            this.f3234a = 0;
            this.f3236c.fling(0, 0, velocityX, velocityY, LinearLayoutManager.INVALID_OFFSET, MoPubClientPositioning.NO_REPEAT, LinearLayoutManager.INVALID_OFFSET, MoPubClientPositioning.NO_REPEAT);
            mo7954a();
        }

        /* renamed from: b */
        public void mo7961b(int dx, int dy) {
            mo7957a(dx, dy, 0, 0);
        }

        /* renamed from: a */
        public void mo7957a(int dx, int dy, int vx, int vy) {
            mo7956a(dx, dy, m4945b(dx, dy, vx, vy));
        }

        /* renamed from: a */
        private float m4943a(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        /* renamed from: b */
        private int m4945b(int dx, int dy, int vx, int vy) {
            int duration;
            int absDx = Math.abs(dx);
            int absDy = Math.abs(dy);
            boolean horizontal = absDx > absDy;
            int velocity = (int) Math.sqrt((double) ((vx * vx) + (vy * vy)));
            int delta = (int) Math.sqrt((double) ((dx * dx) + (dy * dy)));
            int containerSize = horizontal ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int halfContainerSize = containerSize / 2;
            float distance = ((float) halfContainerSize) + (((float) halfContainerSize) * m4943a(Math.min(1.0f, (((float) delta) * 1.0f) / ((float) containerSize))));
            if (velocity > 0) {
                duration = Math.round(Math.abs(distance / ((float) velocity)) * 1000.0f) * 4;
            } else {
                duration = (int) (((((float) (horizontal ? absDx : absDy)) / ((float) containerSize)) + 1.0f) * 300.0f);
            }
            return Math.min(duration, 2000);
        }

        /* renamed from: a */
        public void mo7956a(int dx, int dy, int duration) {
            mo7958a(dx, dy, duration, RecyclerView.f3100j);
        }

        /* renamed from: a */
        public void mo7959a(int dx, int dy, Interpolator interpolator) {
            mo7958a(dx, dy, m4945b(dx, dy, 0, 0), interpolator == null ? RecyclerView.f3100j : interpolator);
        }

        /* renamed from: a */
        public void mo7958a(int dx, int dy, int duration, Interpolator interpolator) {
            if (this.f3237d != interpolator) {
                this.f3237d = interpolator;
                this.f3236c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f3235b = 0;
            this.f3234a = 0;
            this.f3236c.startScroll(0, 0, dx, dy, duration);
            if (VERSION.SDK_INT < 23) {
                this.f3236c.computeScrollOffset();
            }
            mo7954a();
        }

        /* renamed from: b */
        public void mo7960b() {
            RecyclerView.this.removeCallbacks(this);
            this.f3236c.abortAnimation();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$w */
    public static abstract class C1000w {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_SET_A11Y_ITEM_DELEGATE = 16384;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        /* access modifiers changed from: private */
        public int mFlags;
        /* access modifiers changed from: private */
        public boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        /* access modifiers changed from: private */
        public C0991p mScrapContainer = null;
        C1000w mShadowedHolder = null;
        C1000w mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public C1000w(View itemView2) {
            if (itemView2 != null) {
                this.itemView = itemView2;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* access modifiers changed from: 0000 */
        public void flagRemovedAndOffsetPosition(int mNewPosition, int offset, boolean applyToPreLayout) {
            addFlags(8);
            offsetPosition(offset, applyToPreLayout);
            this.mPosition = mNewPosition;
        }

        /* access modifiers changed from: 0000 */
        public void offsetPosition(int offset, boolean applyToPreLayout) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (applyToPreLayout) {
                this.mPreLayoutPosition += offset;
            }
            this.mPosition += offset;
            if (this.itemView.getLayoutParams() != null) {
                ((C0984j) this.itemView.getLayoutParams()).f3192c = true;
            }
        }

        /* access modifiers changed from: 0000 */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: 0000 */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.mo7554c(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        /* access modifiers changed from: 0000 */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: 0000 */
        public void unScrap() {
            this.mScrapContainer.mo7909c(this);
        }

        /* access modifiers changed from: 0000 */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        /* access modifiers changed from: 0000 */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: 0000 */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: 0000 */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        /* access modifiers changed from: 0000 */
        public void setScrapContainer(C0991p recycler, boolean isChangeScrap) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = isChangeScrap;
        }

        /* access modifiers changed from: 0000 */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean hasAnyOfTheFlags(int flags) {
            return (this.mFlags & flags) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        /* access modifiers changed from: 0000 */
        public void setFlags(int flags, int mask) {
            this.mFlags = (this.mFlags & (mask ^ -1)) | (flags & mask);
        }

        /* access modifiers changed from: 0000 */
        public void addFlags(int flags) {
            this.mFlags |= flags;
        }

        /* access modifiers changed from: 0000 */
        public void addChangePayload(Object payload) {
            if (payload == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(payload);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        /* access modifiers changed from: 0000 */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: 0000 */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: 0000 */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.m4730b(this);
        }

        /* access modifiers changed from: private */
        public void onEnteredHiddenState(RecyclerView parent) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = C0646w.m2973g(this.itemView);
            }
            parent.mo7541a(this, 4);
        }

        /* access modifiers changed from: private */
        public void onLeftHiddenState(RecyclerView parent) {
            parent.mo7541a(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewHolder{");
            sb.append(Integer.toHexString(hashCode()));
            sb.append(" position=");
            sb.append(this.mPosition);
            sb.append(" id=");
            sb.append(this.mItemId);
            sb.append(", oldPos=");
            sb.append(this.mOldPosition);
            sb.append(", pLpos:");
            sb.append(this.mPreLayoutPosition);
            StringBuilder sb2 = new StringBuilder(sb.toString());
            if (isScrap()) {
                sb2.append(" scrap ");
                sb2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb2.append(" invalid");
            }
            if (!isBound()) {
                sb2.append(" unbound");
            }
            if (needsUpdate()) {
                sb2.append(" update");
            }
            if (isRemoved()) {
                sb2.append(" removed");
            }
            if (shouldIgnore()) {
                sb2.append(" ignored");
            }
            if (isTmpDetached()) {
                sb2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" not recyclable(");
                sb3.append(this.mIsRecyclableCount);
                sb3.append(")");
                sb2.append(sb3.toString());
            }
            if (isAdapterPositionUnknown()) {
                sb2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        public final void setIsRecyclable(boolean recyclable) {
            this.mIsRecyclableCount = recyclable ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            int i = this.mIsRecyclableCount;
            if (i < 0) {
                this.mIsRecyclableCount = 0;
                StringBuilder sb = new StringBuilder();
                sb.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                sb.append(this);
                Log.e("View", sb.toString());
            } else if (!recyclable && i == 1) {
                this.mFlags |= 16;
            } else if (recyclable && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !C0646w.m2985s(this.itemView);
        }

        /* access modifiers changed from: private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && C0646w.m2985s(this.itemView);
        }

        /* access modifiers changed from: 0000 */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        f3093c = i == 18 || i == 19 || i == 20;
        Class cls = Integer.TYPE;
        f3099i = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecyclerView(Context context, AttributeSet attrs, int defStyle) {
        Context context2 = context;
        AttributeSet attributeSet = attrs;
        int i = defStyle;
        super(context, attrs, defStyle);
        this.f3142k = new C0993r();
        this.f3144l = new C0991p();
        this.f3152p = new C0941Hb();
        this.f3156r = new C0919Ca(this);
        this.f3158s = new Rect();
        this.f3160t = new Rect();
        this.f3162u = new RectF();
        this.f3170y = new ArrayList<>();
        this.f3172z = new ArrayList<>();
        this.f3111F = 0;
        this.f3122N = false;
        this.f3123O = false;
        this.f3124P = 0;
        this.f3125Q = 0;
        this.f3126R = new C0974e();
        this.f3131W = new C1047da();
        this.f3132aa = 0;
        this.f3133ba = -1;
        this.f3145la = Float.MIN_VALUE;
        this.f3147ma = Float.MIN_VALUE;
        this.f3149na = true;
        this.f3151oa = new C0999v();
        this.f3155qa = f3096f ? new C1090a() : null;
        this.f3157ra = new C0997t();
        this.f3163ua = false;
        this.f3165va = false;
        this.f3167wa = new C0979g();
        this.f3169xa = false;
        this.f3102Aa = new int[2];
        this.f3106Ca = new int[2];
        this.f3108Da = new int[2];
        this.f3110Ea = new int[2];
        this.f3112Fa = new ArrayList();
        this.f3114Ga = new C0923Da(this);
        this.f3116Ha = new C0929Fa(this);
        if (attributeSet != null) {
            TypedArray a = context2.obtainStyledAttributes(attributeSet, f3092b, i, 0);
            this.f3154q = a.getBoolean(0, true);
            a.recycle();
        } else {
            this.f3154q = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration vc = ViewConfiguration.get(context);
        this.f3139ha = vc.getScaledTouchSlop();
        this.f3145la = C0658y.m3093a(vc, context2);
        this.f3147ma = C0658y.m3094b(vc, context2);
        this.f3141ja = vc.getScaledMinimumFlingVelocity();
        this.f3143ka = vc.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f3131W.mo7723a(this.f3167wa);
        mo7629m();
        m4705I();
        if (C0646w.m2973g(this) == 0) {
            C0646w.m2970d(this, 1);
        }
        this.f3120L = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new C0953La(this));
        boolean nestedScrollingEnabled = true;
        if (attributeSet != null) {
            TypedArray a2 = context2.obtainStyledAttributes(attributeSet, C1287b.RecyclerView, i, 0);
            String layoutManagerName = a2.getString(C1287b.RecyclerView_layoutManager);
            int descendantFocusability = a2.getInt(C1287b.RecyclerView_android_descendantFocusability, -1);
            if (descendantFocusability == -1) {
                setDescendantFocusability(Opcodes.ASM4);
            }
            this.f3107D = a2.getBoolean(C1287b.RecyclerView_fastScrollEnabled, false);
            if (this.f3107D) {
                mo7526a((StateListDrawable) a2.getDrawable(C1287b.RecyclerView_fastScrollVerticalThumbDrawable), a2.getDrawable(C1287b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) a2.getDrawable(C1287b.RecyclerView_fastScrollHorizontalThumbDrawable), a2.getDrawable(C1287b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            a2.recycle();
            int i2 = descendantFocusability;
            m4717a(context, layoutManagerName, attrs, defStyle, 0);
            if (VERSION.SDK_INT >= 21) {
                TypedArray a3 = context2.obtainStyledAttributes(attributeSet, f3091a, i, 0);
                boolean nestedScrollingEnabled2 = a3.getBoolean(0, true);
                a3.recycle();
                nestedScrollingEnabled = nestedScrollingEnabled2;
            }
        } else {
            setDescendantFocusability(Opcodes.ASM4);
        }
        setNestedScrollingEnabled(nestedScrollingEnabled);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public String mo7625k() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(super.toString());
        sb.append(", adapter:");
        sb.append(this.f3164v);
        sb.append(", layout:");
        sb.append(this.f3166w);
        sb.append(", context:");
        sb.append(getContext());
        return sb.toString();
    }

    public C0953La getCompatAccessibilityDelegate() {
        return this.f3171ya;
    }

    public void setAccessibilityDelegateCompat(C0953La accessibilityDelegate) {
        this.f3171ya = accessibilityDelegate;
        C0646w.m2955a((View) this, (C0616c) this.f3171ya);
    }

    /* renamed from: a */
    private void m4717a(Context context, String className, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        ClassLoader classLoader;
        Constructor<? extends LayoutManager> constructor;
        String str = ": Could not instantiate the LayoutManager: ";
        if (className != null) {
            String className2 = className.trim();
            if (!className2.isEmpty()) {
                String className3 = m4714a(context, className2);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends LayoutManager> layoutManagerClass = classLoader.loadClass(className3).asSubclass(C0981i.class);
                    Object[] constructorArgs = null;
                    try {
                        constructorArgs = new Object[]{context, attrs, Integer.valueOf(defStyleAttr), Integer.valueOf(defStyleRes)};
                        constructor = layoutManagerClass.getConstructor(f3099i);
                    } catch (NoSuchMethodException e) {
                        constructor = layoutManagerClass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((C0981i) constructor.newInstance(constructorArgs));
                } catch (NoSuchMethodException e1) {
                    e1.initCause(e);
                    StringBuilder sb = new StringBuilder();
                    sb.append(attrs.getPositionDescription());
                    sb.append(": Error creating LayoutManager ");
                    sb.append(className3);
                    throw new IllegalStateException(sb.toString(), e1);
                } catch (ClassNotFoundException e2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(attrs.getPositionDescription());
                    sb2.append(": Unable to find LayoutManager ");
                    sb2.append(className3);
                    throw new IllegalStateException(sb2.toString(), e2);
                } catch (InvocationTargetException e3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(attrs.getPositionDescription());
                    sb3.append(str);
                    sb3.append(className3);
                    throw new IllegalStateException(sb3.toString(), e3);
                } catch (InstantiationException e4) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(attrs.getPositionDescription());
                    sb4.append(str);
                    sb4.append(className3);
                    throw new IllegalStateException(sb4.toString(), e4);
                } catch (IllegalAccessException e5) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(attrs.getPositionDescription());
                    sb5.append(": Cannot access non-public constructor ");
                    sb5.append(className3);
                    throw new IllegalStateException(sb5.toString(), e5);
                } catch (ClassCastException e6) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(attrs.getPositionDescription());
                    sb6.append(": Class is not a LayoutManager ");
                    sb6.append(className3);
                    throw new IllegalStateException(sb6.toString(), e6);
                }
            }
        }
    }

    /* renamed from: a */
    private String m4714a(Context context, String className) {
        if (className.charAt(0) == '.') {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(className);
            return sb.toString();
        } else if (className.contains(".")) {
            return className;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(RecyclerView.class.getPackage().getName());
            sb2.append('.');
            sb2.append(className);
            return sb2.toString();
        }
    }

    /* renamed from: I */
    private void m4705I() {
        this.f3150o = new C1001S(new C0932Ga(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public void mo7629m() {
        this.f3148n = new C1068j(new C0940Ha(this));
    }

    public void setHasFixedSize(boolean hasFixedSize) {
        this.f3105C = hasFixedSize;
    }

    public void setClipToPadding(boolean clipToPadding) {
        if (clipToPadding != this.f3154q) {
            mo7631n();
        }
        this.f3154q = clipToPadding;
        super.setClipToPadding(clipToPadding);
        if (this.f3109E) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.f3154q;
    }

    public void setScrollingTouchSlop(int slopConstant) {
        ViewConfiguration vc = ViewConfiguration.get(getContext());
        if (slopConstant != 0) {
            if (slopConstant != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("setScrollingTouchSlop(): bad argument constant ");
                sb.append(slopConstant);
                sb.append("; using default value");
                Log.w("RecyclerView", sb.toString());
            } else {
                this.f3139ha = vc.getScaledPagingTouchSlop();
                return;
            }
        }
        this.f3139ha = vc.getScaledTouchSlop();
    }

    public void setAdapter(C0970a adapter) {
        setLayoutFrozen(false);
        m4718a(adapter, false, true);
        mo7553b(false);
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: w */
    public void mo7681w() {
        C0975f fVar = this.f3131W;
        if (fVar != null) {
            fVar.mo7727b();
        }
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            iVar.removeAndRecycleAllViews(this.f3144l);
            this.f3166w.removeAndRecycleScrapInt(this.f3144l);
        }
        this.f3144l.mo7891a();
    }

    /* renamed from: a */
    private void m4718a(C0970a adapter, boolean compatibleWithPrevious, boolean removeAndRecycleViews) {
        C0970a aVar = this.f3164v;
        if (aVar != null) {
            aVar.unregisterAdapterDataObserver(this.f3142k);
            this.f3164v.onDetachedFromRecyclerView(this);
        }
        if (!compatibleWithPrevious || removeAndRecycleViews) {
            mo7681w();
        }
        this.f3148n.mo8483f();
        C0970a oldAdapter = this.f3164v;
        this.f3164v = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f3142k);
            adapter.onAttachedToRecyclerView(this);
        }
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            iVar.onAdapterChanged(oldAdapter, this.f3164v);
        }
        this.f3144l.mo7894a(oldAdapter, this.f3164v, compatibleWithPrevious);
        this.f3157ra.f3223g = true;
    }

    public C0970a getAdapter() {
        return this.f3164v;
    }

    public void setRecyclerListener(C0992q listener) {
        this.f3168x = listener;
    }

    public int getBaseline() {
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            return iVar.getBaseline();
        }
        return super.getBaseline();
    }

    public void setLayoutManager(C0981i layout) {
        if (layout != this.f3166w) {
            mo7518A();
            if (this.f3166w != null) {
                C0975f fVar = this.f3131W;
                if (fVar != null) {
                    fVar.mo7727b();
                }
                this.f3166w.removeAndRecycleAllViews(this.f3144l);
                this.f3166w.removeAndRecycleScrapInt(this.f3144l);
                this.f3144l.mo7891a();
                if (this.f3103B) {
                    this.f3166w.dispatchDetachedFromWindow(this, this.f3144l);
                }
                this.f3166w.setRecyclerView(null);
                this.f3166w = null;
            } else {
                this.f3144l.mo7891a();
            }
            this.f3150o.mo8008c();
            this.f3166w = layout;
            if (layout != null) {
                if (layout.mRecyclerView == null) {
                    this.f3166w.setRecyclerView(this);
                    if (this.f3103B) {
                        this.f3166w.dispatchAttachedToWindow(this);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LayoutManager ");
                    sb.append(layout);
                    sb.append(" is already attached to a RecyclerView:");
                    sb.append(layout.mRecyclerView.mo7625k());
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            this.f3144l.mo7921j();
            requestLayout();
        }
    }

    public void setOnFlingListener(C0986l onFlingListener) {
        this.f3140ia = onFlingListener;
    }

    public C0986l getOnFlingListener() {
        return this.f3140ia;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState state = new SavedState(super.onSaveInstanceState());
        SavedState savedState = this.f3146m;
        if (savedState != null) {
            state.mo7685a(savedState);
        } else {
            C0981i iVar = this.f3166w;
            if (iVar != null) {
                state.f3174c = iVar.onSaveInstanceState();
            } else {
                state.f3174c = null;
            }
        }
        return state;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        this.f3146m = (SavedState) state;
        super.onRestoreInstanceState(this.f3146m.mo5452a());
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            Parcelable parcelable = this.f3146m.f3174c;
            if (parcelable != null) {
                iVar.onRestoreInstanceState(parcelable);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    /* renamed from: e */
    private void m4735e(C1000w viewHolder) {
        View view = viewHolder.itemView;
        boolean alreadyParented = view.getParent() == this;
        this.f3144l.mo7909c(mo7616i(view));
        if (viewHolder.isTmpDetached()) {
            this.f3150o.mo8001a(view, -1, view.getLayoutParams(), true);
        } else if (!alreadyParented) {
            this.f3150o.mo8003a(view, true);
        } else {
            this.f3150o.mo8000a(view);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public boolean mo7632n(View view) {
        mo7684z();
        boolean removed = this.f3150o.mo8013e(view);
        if (removed) {
            C1000w viewHolder = m4736j(view);
            this.f3144l.mo7909c(viewHolder);
            this.f3144l.mo7904b(viewHolder);
        }
        mo7559c(!removed);
        return removed;
    }

    public C0981i getLayoutManager() {
        return this.f3166w;
    }

    public C0989o getRecycledViewPool() {
        return this.f3144l.mo7911d();
    }

    public void setRecycledViewPool(C0989o pool) {
        this.f3144l.mo7895a(pool);
    }

    public void setViewCacheExtension(C0998u extension) {
        this.f3144l.mo7896a(extension);
    }

    public void setItemViewCacheSize(int size) {
        this.f3144l.mo7917f(size);
    }

    public int getScrollState() {
        return this.f3132aa;
    }

    /* access modifiers changed from: 0000 */
    public void setScrollState(int state) {
        if (state != this.f3132aa) {
            this.f3132aa = state;
            if (state != 2) {
                m4713Q();
            }
            mo7521a(state);
        }
    }

    /* renamed from: a */
    public void mo7528a(C0980h decor, int index) {
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f3170y.isEmpty()) {
            setWillNotDraw(false);
        }
        if (index < 0) {
            this.f3170y.add(decor);
        } else {
            this.f3170y.add(index, decor);
        }
        mo7648r();
        requestLayout();
    }

    /* renamed from: a */
    public void mo7527a(C0980h decor) {
        mo7528a(decor, -1);
    }

    public int getItemDecorationCount() {
        return this.f3170y.size();
    }

    /* renamed from: b */
    public void mo7547b(C0980h decor) {
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.f3170y.remove(decor);
        if (this.f3170y.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        mo7648r();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C0973d childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.f3173za) {
            this.f3173za = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(this.f3173za != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(C0988n listener) {
        this.f3159sa = listener;
    }

    /* renamed from: a */
    public void mo7530a(C0988n listener) {
        if (this.f3161ta == null) {
            this.f3161ta = new ArrayList();
        }
        this.f3161ta.add(listener);
    }

    /* renamed from: b */
    public void mo7549b(C0988n listener) {
        List<C0988n> list = this.f3161ta;
        if (list != null) {
            list.remove(listener);
        }
    }

    /* renamed from: c */
    public void mo7557c() {
        List<C0988n> list = this.f3161ta;
        if (list != null) {
            list.clear();
        }
    }

    /* renamed from: i */
    public void mo7618i(int position) {
        if (!this.f3115H) {
            mo7518A();
            C0981i iVar = this.f3166w;
            if (iVar == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            iVar.scrollToPosition(position);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo7581e(int position) {
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            iVar.scrollToPosition(position);
            awakenScrollBars();
        }
    }

    /* renamed from: j */
    public void mo7622j(int position) {
        if (!this.f3115H) {
            C0981i iVar = this.f3166w;
            if (iVar == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                iVar.smoothScrollToPosition(this, this.f3157ra, position);
            }
        }
    }

    public void scrollTo(int x, int y) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int x, int y) {
        C0981i iVar = this.f3166w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f3115H) {
            boolean canScrollHorizontal = iVar.canScrollHorizontally();
            boolean canScrollVertical = this.f3166w.canScrollVertically();
            if (canScrollHorizontal || canScrollVertical) {
                int i = 0;
                int i2 = canScrollHorizontal ? x : 0;
                if (canScrollVertical) {
                    i = y;
                }
                mo7538a(i2, i, (MotionEvent) null);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo7569d() {
        String str = "RV FullInvalidate";
        if (!this.f3109E || this.f3122N) {
            C0574d.m2755a(str);
            mo7580e();
            C0574d.m2754a();
        } else if (this.f3148n.mo8478c()) {
            if (this.f3148n.mo8479c(4) && !this.f3148n.mo8479c(11)) {
                C0574d.m2755a("RV PartialInvalidate");
                mo7684z();
                mo7678t();
                this.f3148n.mo8482e();
                if (!this.f3113G) {
                    if (m4704H()) {
                        mo7580e();
                    } else {
                        this.f3148n.mo8469a();
                    }
                }
                mo7559c(true);
                mo7679u();
                C0574d.m2754a();
            } else if (this.f3148n.mo8478c()) {
                C0574d.m2755a(str);
                mo7580e();
                C0574d.m2754a();
            }
        }
    }

    /* renamed from: H */
    private boolean m4704H() {
        int childCount = this.f3150o.mo7998a();
        for (int i = 0; i < childCount; i++) {
            C1000w holder = m4736j(this.f3150o.mo8007c(i));
            if (holder != null && !holder.shouldIgnore() && holder.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7538a(int x, int y, MotionEvent ev) {
        int consumedY;
        int consumedX;
        int unconsumedY;
        int unconsumedX;
        int i = x;
        int i2 = y;
        MotionEvent motionEvent = ev;
        int unconsumedX2 = 0;
        int unconsumedY2 = 0;
        int consumedX2 = 0;
        int consumedY2 = 0;
        mo7569d();
        if (this.f3164v != null) {
            mo7684z();
            mo7678t();
            C0574d.m2755a("RV Scroll");
            mo7531a(this.f3157ra);
            if (i != 0) {
                consumedX2 = this.f3166w.scrollHorizontallyBy(i, this.f3144l, this.f3157ra);
                unconsumedX2 = i - consumedX2;
            }
            if (i2 != 0) {
                consumedY2 = this.f3166w.scrollVerticallyBy(i2, this.f3144l, this.f3157ra);
                unconsumedY2 = i2 - consumedY2;
            }
            C0574d.m2754a();
            mo7682x();
            mo7679u();
            mo7559c(false);
            unconsumedX = unconsumedX2;
            unconsumedY = unconsumedY2;
            consumedX = consumedX2;
            consumedY = consumedY2;
        } else {
            unconsumedX = 0;
            unconsumedY = 0;
            consumedX = 0;
            consumedY = 0;
        }
        if (!this.f3170y.isEmpty()) {
            invalidate();
        }
        if (mo7537a(consumedX, consumedY, unconsumedX, unconsumedY, this.f3106Ca, 0)) {
            int i3 = this.f3137fa;
            int[] iArr = this.f3106Ca;
            this.f3137fa = i3 - iArr[0];
            this.f3138ga -= iArr[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
            }
            int[] iArr2 = this.f3110Ea;
            int i4 = iArr2[0];
            int[] iArr3 = this.f3106Ca;
            iArr2[0] = i4 + iArr3[0];
            iArr2[1] = iArr2[1] + iArr3[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !C0634k.m2915a(motionEvent, 8194)) {
                m4715a(ev.getX(), (float) unconsumedX, ev.getY(), (float) unconsumedY);
            }
            mo7546b(x, y);
        }
        if (!(consumedX == 0 && consumedY == 0)) {
            mo7570d(consumedX, consumedY);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (consumedX == 0 && consumedY == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        C0981i iVar = this.f3166w;
        int i = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.canScrollHorizontally()) {
            i = this.f3166w.computeHorizontalScrollOffset(this.f3157ra);
        }
        return i;
    }

    public int computeHorizontalScrollExtent() {
        C0981i iVar = this.f3166w;
        int i = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.canScrollHorizontally()) {
            i = this.f3166w.computeHorizontalScrollExtent(this.f3157ra);
        }
        return i;
    }

    public int computeHorizontalScrollRange() {
        C0981i iVar = this.f3166w;
        int i = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.canScrollHorizontally()) {
            i = this.f3166w.computeHorizontalScrollRange(this.f3157ra);
        }
        return i;
    }

    public int computeVerticalScrollOffset() {
        C0981i iVar = this.f3166w;
        int i = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.canScrollVertically()) {
            i = this.f3166w.computeVerticalScrollOffset(this.f3157ra);
        }
        return i;
    }

    public int computeVerticalScrollExtent() {
        C0981i iVar = this.f3166w;
        int i = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.canScrollVertically()) {
            i = this.f3166w.computeVerticalScrollExtent(this.f3157ra);
        }
        return i;
    }

    public int computeVerticalScrollRange() {
        C0981i iVar = this.f3166w;
        int i = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.canScrollVertically()) {
            i = this.f3166w.computeVerticalScrollRange(this.f3157ra);
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: z */
    public void mo7684z() {
        this.f3111F++;
        if (this.f3111F == 1 && !this.f3115H) {
            this.f3113G = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo7559c(boolean performLayoutChildren) {
        if (this.f3111F < 1) {
            this.f3111F = 1;
        }
        if (!performLayoutChildren && !this.f3115H) {
            this.f3113G = false;
        }
        if (this.f3111F == 1) {
            if (performLayoutChildren && this.f3113G && !this.f3115H && this.f3166w != null && this.f3164v != null) {
                mo7580e();
            }
            if (!this.f3115H) {
                this.f3113G = false;
            }
        }
        this.f3111F--;
    }

    public void setLayoutFrozen(boolean frozen) {
        if (frozen != this.f3115H) {
            mo7552b("Do not setLayoutFrozen in layout or scroll");
            if (!frozen) {
                this.f3115H = false;
                if (!(!this.f3113G || this.f3166w == null || this.f3164v == null)) {
                    requestLayout();
                }
                this.f3113G = false;
                return;
            }
            long now = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0));
            this.f3115H = true;
            this.f3117I = true;
            mo7518A();
        }
    }

    /* renamed from: i */
    public void mo7619i(int dx, int dy) {
        mo7523a(dx, dy, (Interpolator) null);
    }

    /* renamed from: a */
    public void mo7523a(int dx, int dy, Interpolator interpolator) {
        C0981i iVar = this.f3166w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f3115H) {
            if (!iVar.canScrollHorizontally()) {
                dx = 0;
            }
            if (!this.f3166w.canScrollVertically()) {
                dy = 0;
            }
            if (!(dx == 0 && dy == 0)) {
                this.f3151oa.mo7959a(dx, dy, interpolator);
            }
        }
    }

    /* renamed from: e */
    public boolean mo7582e(int velocityX, int velocityY) {
        C0981i iVar = this.f3166w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f3115H) {
            return false;
        } else {
            boolean canScrollHorizontal = iVar.canScrollHorizontally();
            boolean canScrollVertical = this.f3166w.canScrollVertically();
            if (!canScrollHorizontal || Math.abs(velocityX) < this.f3141ja) {
                velocityX = 0;
            }
            if (!canScrollVertical || Math.abs(velocityY) < this.f3141ja) {
                velocityY = 0;
            }
            if (!(velocityX == 0 && velocityY == 0) && !dispatchNestedPreFling((float) velocityX, (float) velocityY)) {
                boolean canScroll = canScrollHorizontal || canScrollVertical;
                dispatchNestedFling((float) velocityX, (float) velocityY, canScroll);
                C0986l lVar = this.f3140ia;
                if (lVar != null && lVar.onFling(velocityX, velocityY)) {
                    return true;
                }
                if (canScroll) {
                    int nestedScrollAxis = 0;
                    if (canScrollHorizontal) {
                        nestedScrollAxis = 0 | 1;
                    }
                    if (canScrollVertical) {
                        nestedScrollAxis |= 2;
                    }
                    mo7623j(nestedScrollAxis, 1);
                    int i = this.f3143ka;
                    int velocityX2 = Math.max(-i, Math.min(velocityX, i));
                    int i2 = this.f3143ka;
                    this.f3151oa.mo7955a(velocityX2, Math.max(-i2, Math.min(velocityY, i2)));
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: A */
    public void mo7518A() {
        setScrollState(0);
        m4713Q();
    }

    /* renamed from: Q */
    private void m4713Q() {
        this.f3151oa.mo7960b();
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            iVar.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.f3141ja;
    }

    public int getMaxFlingVelocity() {
        return this.f3143ka;
    }

    /* renamed from: a */
    private void m4715a(float x, float overscrollX, float y, float overscrollY) {
        boolean invalidate = false;
        if (overscrollX < 0.0f) {
            mo7612h();
            C0706m.m3330a(this.f3127S, (-overscrollX) / ((float) getWidth()), 1.0f - (y / ((float) getHeight())));
            invalidate = true;
        } else if (overscrollX > 0.0f) {
            mo7617i();
            C0706m.m3330a(this.f3129U, overscrollX / ((float) getWidth()), y / ((float) getHeight()));
            invalidate = true;
        }
        if (overscrollY < 0.0f) {
            mo7621j();
            C0706m.m3330a(this.f3128T, (-overscrollY) / ((float) getHeight()), x / ((float) getWidth()));
            invalidate = true;
        } else if (overscrollY > 0.0f) {
            mo7589g();
            C0706m.m3330a(this.f3130V, overscrollY / ((float) getHeight()), 1.0f - (x / ((float) getWidth())));
            invalidate = true;
        }
        if (invalidate || overscrollX != 0.0f || overscrollY != 0.0f) {
            C0646w.m2990x(this);
        }
    }

    /* renamed from: M */
    private void m4709M() {
        boolean needsInvalidate = false;
        EdgeEffect edgeEffect = this.f3127S;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            needsInvalidate = this.f3127S.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f3128T;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            needsInvalidate |= this.f3128T.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3129U;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            needsInvalidate |= this.f3129U.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3130V;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            needsInvalidate |= this.f3130V.isFinished();
        }
        if (needsInvalidate) {
            C0646w.m2990x(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7546b(int dx, int dy) {
        boolean needsInvalidate = false;
        EdgeEffect edgeEffect = this.f3127S;
        if (edgeEffect != null && !edgeEffect.isFinished() && dx > 0) {
            this.f3127S.onRelease();
            needsInvalidate = this.f3127S.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f3129U;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && dx < 0) {
            this.f3129U.onRelease();
            needsInvalidate |= this.f3129U.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3128T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && dy > 0) {
            this.f3128T.onRelease();
            needsInvalidate |= this.f3128T.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3130V;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && dy < 0) {
            this.f3130V.onRelease();
            needsInvalidate |= this.f3130V.isFinished();
        }
        if (needsInvalidate) {
            C0646w.m2990x(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7522a(int velocityX, int velocityY) {
        if (velocityX < 0) {
            mo7612h();
            this.f3127S.onAbsorb(-velocityX);
        } else if (velocityX > 0) {
            mo7617i();
            this.f3129U.onAbsorb(velocityX);
        }
        if (velocityY < 0) {
            mo7621j();
            this.f3128T.onAbsorb(-velocityY);
        } else if (velocityY > 0) {
            mo7589g();
            this.f3130V.onAbsorb(velocityY);
        }
        if (velocityX != 0 || velocityY != 0) {
            C0646w.m2990x(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo7612h() {
        if (this.f3127S == null) {
            this.f3127S = this.f3126R.mo7718a(this, 0);
            if (this.f3154q) {
                this.f3127S.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f3127S.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo7617i() {
        if (this.f3129U == null) {
            this.f3129U = this.f3126R.mo7718a(this, 2);
            if (this.f3154q) {
                this.f3129U.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f3129U.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo7621j() {
        if (this.f3128T == null) {
            this.f3128T = this.f3126R.mo7718a(this, 1);
            if (this.f3154q) {
                this.f3128T.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f3128T.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo7589g() {
        if (this.f3130V == null) {
            this.f3130V = this.f3126R.mo7718a(this, 3);
            if (this.f3154q) {
                this.f3130V.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f3130V.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public void mo7631n() {
        this.f3130V = null;
        this.f3128T = null;
        this.f3129U = null;
        this.f3127S = null;
    }

    public void setEdgeEffectFactory(C0974e edgeEffectFactory) {
        C1272p.m5959a(edgeEffectFactory);
        this.f3126R = edgeEffectFactory;
        mo7631n();
    }

    public C0974e getEdgeEffectFactory() {
        return this.f3126R;
    }

    public View focusSearch(View focused, int direction) {
        View result;
        View view;
        View result2 = this.f3166w.onInterceptFocusSearch(focused, direction);
        if (result2 != null) {
            return result2;
        }
        boolean z = true;
        boolean canRunFocusFailure = this.f3164v != null && this.f3166w != null && !mo7647q() && !this.f3115H;
        FocusFinder ff = FocusFinder.getInstance();
        if (!canRunFocusFailure || !(direction == 2 || direction == 1)) {
            result = ff.findNextFocus(this, focused, direction);
            if (result == null && canRunFocusFailure) {
                mo7569d();
                if (mo7556c(focused) == null) {
                    return null;
                }
                mo7684z();
                result = this.f3166w.onFocusSearchFailed(focused, direction, this.f3144l, this.f3157ra);
                mo7559c(false);
            }
        } else {
            boolean needsFocusFailureLayout = false;
            if (this.f3166w.canScrollVertically()) {
                int absDir = direction == 2 ? Opcodes.IXOR : 33;
                needsFocusFailureLayout = ff.findNextFocus(this, focused, absDir) == null;
                if (f3097g) {
                    direction = absDir;
                }
            }
            if (!needsFocusFailureLayout && this.f3166w.canScrollHorizontally()) {
                int absDir2 = (direction == 2) ^ (this.f3166w.getLayoutDirection() == 1) ? 66 : 17;
                if (ff.findNextFocus(this, focused, absDir2) != null) {
                    z = false;
                }
                needsFocusFailureLayout = z;
                if (f3097g) {
                    direction = absDir2;
                }
            }
            if (needsFocusFailureLayout) {
                mo7569d();
                if (mo7556c(focused) == null) {
                    return null;
                }
                mo7684z();
                this.f3166w.onFocusSearchFailed(focused, direction, this.f3144l, this.f3157ra);
                mo7559c(false);
            }
            result = ff.findNextFocus(this, focused, direction);
        }
        if (result == null || result.hasFocusable()) {
            if (m4728a(focused, result, direction)) {
                view = result;
            } else {
                view = super.focusSearch(focused, direction);
            }
            return view;
        } else if (getFocusedChild() == null) {
            return super.focusSearch(focused, direction);
        } else {
            m4724a(result, (View) null);
            return focused;
        }
    }

    /* renamed from: a */
    private boolean m4728a(View focused, View next, int direction) {
        boolean z = false;
        if (next == null || next == this || mo7556c(next) == null) {
            return false;
        }
        if (focused == null || mo7556c(focused) == null) {
            return true;
        }
        this.f3158s.set(0, 0, focused.getWidth(), focused.getHeight());
        this.f3160t.set(0, 0, next.getWidth(), next.getHeight());
        offsetDescendantRectToMyCoords(focused, this.f3158s);
        offsetDescendantRectToMyCoords(next, this.f3160t);
        int rtl = this.f3166w.getLayoutDirection() == 1 ? -1 : 1;
        int rightness = 0;
        Rect rect = this.f3158s;
        int i = rect.left;
        int i2 = this.f3160t.left;
        if ((i < i2 || rect.right <= i2) && this.f3158s.right < this.f3160t.right) {
            rightness = 1;
        } else {
            Rect rect2 = this.f3158s;
            int i3 = rect2.right;
            int i4 = this.f3160t.right;
            if ((i3 > i4 || rect2.left >= i4) && this.f3158s.left > this.f3160t.left) {
                rightness = -1;
            }
        }
        int downness = 0;
        Rect rect3 = this.f3158s;
        int i5 = rect3.top;
        int i6 = this.f3160t.top;
        if ((i5 < i6 || rect3.bottom <= i6) && this.f3158s.bottom < this.f3160t.bottom) {
            downness = 1;
        } else {
            Rect rect4 = this.f3158s;
            int i7 = rect4.bottom;
            int i8 = this.f3160t.bottom;
            if ((i7 > i8 || rect4.top >= i8) && this.f3158s.top > this.f3160t.top) {
                downness = -1;
            }
        }
        if (direction == 1) {
            if (downness < 0 || (downness == 0 && rightness * rtl <= 0)) {
                z = true;
            }
            return z;
        } else if (direction == 2) {
            if (downness > 0 || (downness == 0 && rightness * rtl >= 0)) {
                z = true;
            }
            return z;
        } else if (direction == 17) {
            if (rightness < 0) {
                z = true;
            }
            return z;
        } else if (direction == 33) {
            if (downness < 0) {
                z = true;
            }
            return z;
        } else if (direction == 66) {
            if (rightness > 0) {
                z = true;
            }
            return z;
        } else if (direction == 130) {
            if (downness > 0) {
                z = true;
            }
            return z;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid direction: ");
            sb.append(direction);
            sb.append(mo7625k());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void requestChildFocus(View child, View focused) {
        if (!this.f3166w.onRequestChildFocus(this, this.f3157ra, child, focused) && focused != null) {
            m4724a(child, focused);
        }
        super.requestChildFocus(child, focused);
    }

    /* renamed from: a */
    private void m4724a(View child, View focused) {
        View rectView = focused != null ? focused : child;
        this.f3158s.set(0, 0, rectView.getWidth(), rectView.getHeight());
        LayoutParams focusedLayoutParams = rectView.getLayoutParams();
        if (focusedLayoutParams instanceof C0984j) {
            C0984j lp = (C0984j) focusedLayoutParams;
            if (!lp.f3192c) {
                Rect insets = lp.f3191b;
                Rect rect = this.f3158s;
                rect.left -= insets.left;
                rect.right += insets.right;
                rect.top -= insets.top;
                rect.bottom += insets.bottom;
            }
        }
        if (focused != null) {
            offsetDescendantRectToMyCoords(focused, this.f3158s);
            offsetRectIntoDescendantCoords(child, this.f3158s);
        }
        this.f3166w.requestChildRectangleOnScreen(this, child, this.f3158s, !this.f3109E, focused == null);
    }

    public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {
        return this.f3166w.requestChildRectangleOnScreen(this, child, rect, immediate);
    }

    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        C0981i iVar = this.f3166w;
        if (iVar == null || !iVar.onAddFocusables(this, views, direction, focusableMode)) {
            super.addFocusables(views, direction, focusableMode);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        if (mo7647q()) {
            return false;
        }
        return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3124P = 0;
        boolean z = true;
        this.f3103B = true;
        if (!this.f3109E || isLayoutRequested()) {
            z = false;
        }
        this.f3109E = z;
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            iVar.dispatchAttachedToWindow(this);
        }
        this.f3169xa = false;
        if (f3096f) {
            this.f3153pa = (C1089na) C1089na.f3620a.get();
            if (this.f3153pa == null) {
                this.f3153pa = new C1089na();
                Display display = C0646w.m2971e(this);
                float refreshRate = 60.0f;
                if (!isInEditMode() && display != null) {
                    float displayRefreshRate = display.getRefreshRate();
                    if (displayRefreshRate >= 30.0f) {
                        refreshRate = displayRefreshRate;
                    }
                }
                C1089na naVar = this.f3153pa;
                naVar.f3624e = (long) (1.0E9f / refreshRate);
                C1089na.f3620a.set(naVar);
            }
            this.f3153pa.mo8543a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0975f fVar = this.f3131W;
        if (fVar != null) {
            fVar.mo7727b();
        }
        mo7518A();
        this.f3103B = false;
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            iVar.dispatchDetachedFromWindow(this, this.f3144l);
        }
        this.f3112Fa.clear();
        removeCallbacks(this.f3114Ga);
        this.f3152p.mo7315b();
        if (f3096f) {
            C1089na naVar = this.f3153pa;
            if (naVar != null) {
                naVar.mo8545b(this);
                this.f3153pa = null;
            }
        }
    }

    public boolean isAttachedToWindow() {
        return this.f3103B;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7535a(String message) {
        if (mo7647q()) {
            return;
        }
        if (message == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            sb.append(mo7625k());
            throw new IllegalStateException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(message);
        sb2.append(mo7625k());
        throw new IllegalStateException(sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7552b(String message) {
        if (mo7647q()) {
            if (message == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
                sb.append(mo7625k());
                throw new IllegalStateException(sb.toString());
            }
            throw new IllegalStateException(message);
        } else if (this.f3125Q > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(mo7625k());
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(sb2.toString()));
        }
    }

    /* renamed from: a */
    public void mo7529a(C0987m listener) {
        this.f3172z.add(listener);
    }

    /* renamed from: b */
    public void mo7548b(C0987m listener) {
        this.f3172z.remove(listener);
        if (this.f3101A == listener) {
            this.f3101A = null;
        }
    }

    /* renamed from: b */
    private boolean m4732b(MotionEvent e) {
        int action = e.getAction();
        if (action == 3 || action == 0) {
            this.f3101A = null;
        }
        int listenerCount = this.f3172z.size();
        int i = 0;
        while (i < listenerCount) {
            C0987m listener = (C0987m) this.f3172z.get(i);
            if (!listener.mo7873b(this, e) || action == 3) {
                i++;
            } else {
                this.f3101A = listener;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m4727a(MotionEvent e) {
        int action = e.getAction();
        C0987m mVar = this.f3101A;
        if (mVar != null) {
            if (action == 0) {
                this.f3101A = null;
            } else {
                mVar.mo7871a(this, e);
                if (action == 3 || action == 1) {
                    this.f3101A = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int listenerCount = this.f3172z.size();
            for (int i = 0; i < listenerCount; i++) {
                C0987m listener = (C0987m) this.f3172z.get(i);
                if (listener.mo7873b(this, e)) {
                    this.f3101A = listener;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent e) {
        boolean z = false;
        if (this.f3115H) {
            return false;
        }
        if (m4732b(e)) {
            m4698B();
            return true;
        }
        C0981i iVar = this.f3166w;
        if (iVar == null) {
            return false;
        }
        boolean canScrollHorizontally = iVar.canScrollHorizontally();
        boolean canScrollVertically = this.f3166w.canScrollVertically();
        if (this.f3134ca == null) {
            this.f3134ca = VelocityTracker.obtain();
        }
        this.f3134ca.addMovement(e);
        int action = e.getActionMasked();
        int actionIndex = e.getActionIndex();
        if (action == 0) {
            if (this.f3117I) {
                this.f3117I = false;
            }
            this.f3133ba = e.getPointerId(0);
            int x = (int) (e.getX() + 0.5f);
            this.f3137fa = x;
            this.f3135da = x;
            int y = (int) (e.getY() + 0.5f);
            this.f3138ga = y;
            this.f3136ea = y;
            if (this.f3132aa == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.f3110Ea;
            iArr[1] = 0;
            iArr[0] = 0;
            int nestedScrollAxis = 0;
            if (canScrollHorizontally) {
                nestedScrollAxis = 0 | 1;
            }
            if (canScrollVertically) {
                nestedScrollAxis |= 2;
            }
            mo7623j(nestedScrollAxis, 0);
        } else if (action == 1) {
            this.f3134ca.clear();
            mo7626k(0);
        } else if (action == 2) {
            int index = e.findPointerIndex(this.f3133ba);
            if (index < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error processing scroll; pointer index for id ");
                sb.append(this.f3133ba);
                sb.append(" not found. Did any MotionEvents get skipped?");
                Log.e("RecyclerView", sb.toString());
                return false;
            }
            int x2 = (int) (e.getX(index) + 0.5f);
            int y2 = (int) (e.getY(index) + 0.5f);
            if (this.f3132aa != 1) {
                int dx = x2 - this.f3135da;
                int dy = y2 - this.f3136ea;
                boolean startScroll = false;
                if (canScrollHorizontally && Math.abs(dx) > this.f3139ha) {
                    this.f3137fa = x2;
                    startScroll = true;
                }
                if (canScrollVertically && Math.abs(dy) > this.f3139ha) {
                    this.f3138ga = y2;
                    startScroll = true;
                }
                if (startScroll) {
                    setScrollState(1);
                }
            }
        } else if (action == 3) {
            m4698B();
        } else if (action == 5) {
            this.f3133ba = e.getPointerId(actionIndex);
            int x3 = (int) (e.getX(actionIndex) + 0.5f);
            this.f3137fa = x3;
            this.f3135da = x3;
            int y3 = (int) (e.getY(actionIndex) + 0.5f);
            this.f3138ga = y3;
            this.f3136ea = y3;
        } else if (action == 6) {
            m4733c(e);
        }
        if (this.f3132aa == 1) {
            z = true;
        }
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        int listenerCount = this.f3172z.size();
        for (int i = 0; i < listenerCount; i++) {
            ((C0987m) this.f3172z.get(i)).mo7872a(disallowIntercept);
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    public boolean onTouchEvent(MotionEvent e) {
        int dy;
        int dx;
        int dy2;
        int dx2;
        MotionEvent motionEvent = e;
        int i = 0;
        if (this.f3115H || this.f3117I) {
            return false;
        }
        if (m4727a(e)) {
            m4698B();
            return true;
        }
        C0981i iVar = this.f3166w;
        if (iVar == null) {
            return false;
        }
        boolean canScrollHorizontally = iVar.canScrollHorizontally();
        boolean canScrollVertically = this.f3166w.canScrollVertically();
        if (this.f3134ca == null) {
            this.f3134ca = VelocityTracker.obtain();
        }
        boolean eventAddedToVelocityTracker = false;
        MotionEvent vtev = MotionEvent.obtain(e);
        int action = e.getActionMasked();
        int actionIndex = e.getActionIndex();
        if (action == 0) {
            int[] iArr = this.f3110Ea;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.f3110Ea;
        vtev.offsetLocation((float) iArr2[0], (float) iArr2[1]);
        if (action == 0) {
            this.f3133ba = motionEvent.getPointerId(0);
            int x = (int) (e.getX() + 0.5f);
            this.f3137fa = x;
            this.f3135da = x;
            int y = (int) (e.getY() + 0.5f);
            this.f3138ga = y;
            this.f3136ea = y;
            int nestedScrollAxis = 0;
            if (canScrollHorizontally) {
                nestedScrollAxis = 0 | 1;
            }
            if (canScrollVertically) {
                nestedScrollAxis |= 2;
            }
            mo7623j(nestedScrollAxis, 0);
        } else if (action == 1) {
            this.f3134ca.addMovement(vtev);
            eventAddedToVelocityTracker = true;
            this.f3134ca.computeCurrentVelocity(1000, (float) this.f3143ka);
            float xvel = canScrollHorizontally ? -this.f3134ca.getXVelocity(this.f3133ba) : 0.0f;
            float yvel = canScrollVertically ? -this.f3134ca.getYVelocity(this.f3133ba) : 0.0f;
            if ((xvel == 0.0f && yvel == 0.0f) || !mo7582e((int) xvel, (int) yvel)) {
                setScrollState(0);
            }
            m4711O();
        } else if (action == 2) {
            int index = motionEvent.findPointerIndex(this.f3133ba);
            if (index < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error processing scroll; pointer index for id ");
                sb.append(this.f3133ba);
                sb.append(" not found. Did any MotionEvents get skipped?");
                Log.e("RecyclerView", sb.toString());
                return false;
            }
            int x2 = (int) (motionEvent.getX(index) + 0.5f);
            int y2 = (int) (motionEvent.getY(index) + 0.5f);
            int dx3 = this.f3137fa - x2;
            int dy3 = this.f3138ga - y2;
            int y3 = y2;
            int x3 = x2;
            int i2 = index;
            if (mo7539a(dx3, dy3, this.f3108Da, this.f3106Ca, 0)) {
                int[] iArr3 = this.f3108Da;
                dx3 -= iArr3[0];
                dy3 -= iArr3[1];
                int[] iArr4 = this.f3106Ca;
                vtev.offsetLocation((float) iArr4[0], (float) iArr4[1]);
                int[] iArr5 = this.f3110Ea;
                int i3 = iArr5[0];
                int[] iArr6 = this.f3106Ca;
                iArr5[0] = i3 + iArr6[0];
                iArr5[1] = iArr5[1] + iArr6[1];
            }
            if (this.f3132aa != 1) {
                boolean startScroll = false;
                if (canScrollHorizontally) {
                    int abs = Math.abs(dx);
                    int i4 = this.f3139ha;
                    if (abs > i4) {
                        if (dx > 0) {
                            dx -= i4;
                        } else {
                            dx += i4;
                        }
                        startScroll = true;
                    }
                }
                if (canScrollVertically) {
                    int abs2 = Math.abs(dy);
                    int i5 = this.f3139ha;
                    if (abs2 > i5) {
                        if (dy > 0) {
                            dy -= i5;
                        } else {
                            dy += i5;
                        }
                        startScroll = true;
                    }
                }
                if (startScroll) {
                    setScrollState(1);
                }
                dx2 = dx;
                dy2 = dy;
            } else {
                dx2 = dx;
                dy2 = dy;
            }
            if (this.f3132aa == 1) {
                int[] iArr7 = this.f3106Ca;
                this.f3137fa = x3 - iArr7[0];
                this.f3138ga = y3 - iArr7[1];
                int i6 = canScrollHorizontally ? dx2 : 0;
                if (canScrollVertically) {
                    i = dy2;
                }
                if (mo7538a(i6, i, vtev)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (!(this.f3153pa == null || (dx2 == 0 && dy2 == 0))) {
                    this.f3153pa.mo8544a(this, dx2, dy2);
                }
            }
        } else if (action == 3) {
            m4698B();
        } else if (action == 5) {
            this.f3133ba = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f3137fa = x4;
            this.f3135da = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f3138ga = y4;
            this.f3136ea = y4;
        } else if (action == 6) {
            m4733c(e);
        }
        if (!eventAddedToVelocityTracker) {
            this.f3134ca.addMovement(vtev);
        }
        vtev.recycle();
        return true;
    }

    /* renamed from: O */
    private void m4711O() {
        VelocityTracker velocityTracker = this.f3134ca;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        mo7626k(0);
        m4709M();
    }

    /* renamed from: B */
    private void m4698B() {
        m4711O();
        setScrollState(0);
    }

    /* renamed from: c */
    private void m4733c(MotionEvent e) {
        int actionIndex = e.getActionIndex();
        if (e.getPointerId(actionIndex) == this.f3133ba) {
            int newIndex = actionIndex == 0 ? 1 : 0;
            this.f3133ba = e.getPointerId(newIndex);
            int x = (int) (e.getX(newIndex) + 0.5f);
            this.f3137fa = x;
            this.f3135da = x;
            int y = (int) (e.getY(newIndex) + 0.5f);
            this.f3138ga = y;
            this.f3136ea = y;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent event) {
        float hScroll;
        float vScroll;
        if (this.f3166w != null && !this.f3115H && event.getAction() == 8) {
            if ((event.getSource() & 2) != 0) {
                if (this.f3166w.canScrollVertically()) {
                    vScroll = -event.getAxisValue(9);
                } else {
                    vScroll = 0.0f;
                }
                if (this.f3166w.canScrollHorizontally()) {
                    hScroll = event.getAxisValue(10);
                } else {
                    hScroll = 0.0f;
                }
            } else if ((event.getSource() & 4194304) != 0) {
                float axisScroll = event.getAxisValue(26);
                if (this.f3166w.canScrollVertically()) {
                    vScroll = -axisScroll;
                    hScroll = 0.0f;
                } else if (this.f3166w.canScrollHorizontally()) {
                    float f = axisScroll;
                    vScroll = 0.0f;
                    hScroll = f;
                } else {
                    hScroll = 0.0f;
                    vScroll = 0.0f;
                }
            } else {
                vScroll = 0.0f;
                hScroll = 0.0f;
            }
            if (!(vScroll == 0.0f && hScroll == 0.0f)) {
                mo7538a((int) (this.f3145la * hScroll), (int) (this.f3147ma * vScroll), event);
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthSpec, int heightSpec) {
        C0981i iVar = this.f3166w;
        if (iVar == null) {
            mo7558c(widthSpec, heightSpec);
            return;
        }
        boolean measureSpecModeIsExactly = false;
        if (iVar.isAutoMeasureEnabled()) {
            int widthMode = MeasureSpec.getMode(widthSpec);
            int heightMode = MeasureSpec.getMode(heightSpec);
            this.f3166w.onMeasure(this.f3144l, this.f3157ra, widthSpec, heightSpec);
            if (widthMode == 1073741824 && heightMode == 1073741824) {
                measureSpecModeIsExactly = true;
            }
            if (!measureSpecModeIsExactly && this.f3164v != null) {
                if (this.f3157ra.f3221e == 1) {
                    m4700D();
                }
                this.f3166w.setMeasureSpecs(widthSpec, heightSpec);
                this.f3157ra.f3226j = true;
                m4701E();
                this.f3166w.setMeasuredDimensionFromChildren(widthSpec, heightSpec);
                if (this.f3166w.shouldMeasureTwice()) {
                    this.f3166w.setMeasureSpecs(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f3157ra.f3226j = true;
                    m4701E();
                    this.f3166w.setMeasuredDimensionFromChildren(widthSpec, heightSpec);
                }
            }
        } else if (this.f3105C != 0) {
            this.f3166w.onMeasure(this.f3144l, this.f3157ra, widthSpec, heightSpec);
        } else {
            if (this.f3119K) {
                mo7684z();
                mo7678t();
                m4707K();
                mo7679u();
                C0997t tVar = this.f3157ra;
                if (tVar.f3228l) {
                    tVar.f3224h = true;
                } else {
                    this.f3148n.mo8476b();
                    this.f3157ra.f3224h = false;
                }
                this.f3119K = false;
                mo7559c(false);
            } else if (this.f3157ra.f3228l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            C0970a aVar = this.f3164v;
            if (aVar != null) {
                this.f3157ra.f3222f = aVar.getItemCount();
            } else {
                this.f3157ra.f3222f = 0;
            }
            mo7684z();
            this.f3166w.onMeasure(this.f3144l, this.f3157ra, widthSpec, heightSpec);
            mo7559c(false);
            this.f3157ra.f3224h = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo7558c(int widthSpec, int heightSpec) {
        setMeasuredDimension(C0981i.chooseSize(widthSpec, getPaddingLeft() + getPaddingRight(), C0646w.m2976j(this)), C0981i.chooseSize(heightSpec, getPaddingTop() + getPaddingBottom(), C0646w.m2975i(this)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            mo7631n();
        }
    }

    public void setItemAnimator(C0975f animator) {
        C0975f fVar = this.f3131W;
        if (fVar != null) {
            fVar.mo7727b();
            this.f3131W.mo7723a((C0977b) null);
        }
        this.f3131W = animator;
        C0975f fVar2 = this.f3131W;
        if (fVar2 != null) {
            fVar2.mo7723a(this.f3167wa);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public void mo7678t() {
        this.f3124P++;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public void mo7679u() {
        mo7536a(true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7536a(boolean enableChangeEvents) {
        this.f3124P--;
        if (this.f3124P < 1) {
            this.f3124P = 0;
            if (enableChangeEvents) {
                m4699C();
                mo7584f();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public boolean mo7646p() {
        AccessibilityManager accessibilityManager = this.f3120L;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    /* renamed from: C */
    private void m4699C() {
        int flags = this.f3118J;
        this.f3118J = 0;
        if (flags != 0 && mo7646p()) {
            AccessibilityEvent event = AccessibilityEvent.obtain();
            event.setEventType(Opcodes.ACC_STRICT);
            C0603a.m2809a(event, flags);
            sendAccessibilityEventUnchecked(event);
        }
    }

    /* renamed from: q */
    public boolean mo7647q() {
        return this.f3124P > 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7542a(AccessibilityEvent event) {
        if (!mo7647q()) {
            return false;
        }
        int type = 0;
        if (event != null) {
            type = C0603a.m2808a(event);
        }
        if (type == 0) {
            type = 0;
        }
        this.f3118J |= type;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        if (!mo7542a(event)) {
            super.sendAccessibilityEventUnchecked(event);
        }
    }

    public C0975f getItemAnimator() {
        return this.f3131W;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: v */
    public void mo7680v() {
        if (!this.f3169xa && this.f3103B) {
            C0646w.m2958a((View) this, this.f3114Ga);
            this.f3169xa = true;
        }
    }

    /* renamed from: J */
    private boolean m4706J() {
        return this.f3131W != null && this.f3166w.supportsPredictiveItemAnimations();
    }

    /* renamed from: K */
    private void m4707K() {
        if (this.f3122N) {
            this.f3148n.mo8483f();
            if (this.f3123O) {
                this.f3166w.onItemsChanged(this);
            }
        }
        if (m4706J()) {
            this.f3148n.mo8482e();
        } else {
            this.f3148n.mo8476b();
        }
        boolean z = false;
        boolean animationTypeSupported = this.f3163ua || this.f3165va;
        this.f3157ra.f3227k = this.f3109E && this.f3131W != null && (this.f3122N || animationTypeSupported || this.f3166w.mRequestedSimpleAnimations) && (!this.f3122N || this.f3164v.hasStableIds());
        C0997t tVar = this.f3157ra;
        if (tVar.f3227k && animationTypeSupported && !this.f3122N && m4706J()) {
            z = true;
        }
        tVar.f3228l = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo7580e() {
        String str = "RecyclerView";
        if (this.f3164v == null) {
            Log.e(str, "No adapter attached; skipping layout");
        } else if (this.f3166w == null) {
            Log.e(str, "No layout manager attached; skipping layout");
        } else {
            C0997t tVar = this.f3157ra;
            tVar.f3226j = false;
            if (tVar.f3221e == 1) {
                m4700D();
                this.f3166w.setExactMeasureSpecsFrom(this);
                m4701E();
            } else if (!this.f3148n.mo8481d() && this.f3166w.getWidth() == getWidth() && this.f3166w.getHeight() == getHeight()) {
                this.f3166w.setExactMeasureSpecsFrom(this);
            } else {
                this.f3166w.setExactMeasureSpecsFrom(this);
                m4701E();
            }
            m4702F();
        }
    }

    /* renamed from: P */
    private void m4712P() {
        int i;
        View child = null;
        if (this.f3149na && hasFocus() && this.f3164v != null) {
            child = getFocusedChild();
        }
        C1000w focusedVh = child == null ? null : mo7568d(child);
        if (focusedVh == null) {
            m4710N();
            return;
        }
        this.f3157ra.f3230n = this.f3164v.hasStableIds() ? focusedVh.getItemId() : -1;
        C0997t tVar = this.f3157ra;
        if (this.f3122N) {
            i = -1;
        } else if (focusedVh.isRemoved()) {
            i = focusedVh.mOldPosition;
        } else {
            i = focusedVh.getAdapterPosition();
        }
        tVar.f3229m = i;
        this.f3157ra.f3231o = m4738o(focusedVh.itemView);
    }

    /* renamed from: N */
    private void m4710N() {
        C0997t tVar = this.f3157ra;
        tVar.f3230n = -1;
        tVar.f3229m = -1;
        tVar.f3231o = -1;
    }

    /* renamed from: G */
    private View m4703G() {
        int startFocusSearchIndex = this.f3157ra.f3229m;
        if (startFocusSearchIndex == -1) {
            startFocusSearchIndex = 0;
        }
        int itemCount = this.f3157ra.mo7945a();
        int i = startFocusSearchIndex;
        while (i < itemCount) {
            C1000w nextFocus = mo7544b(i);
            if (nextFocus == null) {
                break;
            } else if (nextFocus.itemView.hasFocusable()) {
                return nextFocus.itemView;
            } else {
                i++;
            }
        }
        for (int i2 = Math.min(itemCount, startFocusSearchIndex) - 1; i2 >= 0; i2--) {
            C1000w nextFocus2 = mo7544b(i2);
            if (nextFocus2 == null) {
                return null;
            }
            if (nextFocus2.itemView.hasFocusable()) {
                return nextFocus2.itemView;
            }
        }
        return null;
    }

    /* renamed from: L */
    private void m4708L() {
        if (this.f3149na && this.f3164v != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
            if (!isFocused()) {
                View focusedChild = getFocusedChild();
                if (!f3098h || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                    if (!this.f3150o.mo8009c(focusedChild)) {
                        return;
                    }
                } else if (this.f3150o.mo7998a() == 0) {
                    requestFocus();
                    return;
                }
            }
            C1000w focusTarget = null;
            if (this.f3157ra.f3230n != -1 && this.f3164v.hasStableIds()) {
                focusTarget = mo7520a(this.f3157ra.f3230n);
            }
            View viewToFocus = null;
            if (focusTarget != null && !this.f3150o.mo8009c(focusTarget.itemView) && focusTarget.itemView.hasFocusable()) {
                viewToFocus = focusTarget.itemView;
            } else if (this.f3150o.mo7998a() > 0) {
                viewToFocus = m4703G();
            }
            if (viewToFocus != null) {
                int i = this.f3157ra.f3231o;
                if (((long) i) != -1) {
                    View child = viewToFocus.findViewById(i);
                    if (child != null && child.isFocusable()) {
                        viewToFocus = child;
                    }
                }
                viewToFocus.requestFocus();
            }
        }
    }

    /* renamed from: o */
    private int m4738o(View view) {
        int lastKnownId = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                lastKnownId = view.getId();
            }
        }
        return lastKnownId;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo7531a(C0997t state) {
        if (getScrollState() == 2) {
            OverScroller scroller = this.f3151oa.f3236c;
            state.f3232p = scroller.getFinalX() - scroller.getCurrX();
            state.f3233q = scroller.getFinalY() - scroller.getCurrY();
            return;
        }
        state.f3232p = 0;
        state.f3233q = 0;
    }

    /* renamed from: D */
    private void m4700D() {
        boolean z = true;
        this.f3157ra.mo7946a(1);
        mo7531a(this.f3157ra);
        this.f3157ra.f3226j = false;
        mo7684z();
        this.f3152p.mo7310a();
        mo7678t();
        m4707K();
        m4712P();
        C0997t tVar = this.f3157ra;
        if (!tVar.f3227k || !this.f3165va) {
            z = false;
        }
        tVar.f3225i = z;
        this.f3165va = false;
        this.f3163ua = false;
        C0997t tVar2 = this.f3157ra;
        tVar2.f3224h = tVar2.f3228l;
        tVar2.f3222f = this.f3164v.getItemCount();
        m4725a(this.f3102Aa);
        if (this.f3157ra.f3227k) {
            int count = this.f3150o.mo7998a();
            for (int i = 0; i < count; i++) {
                C1000w holder = m4736j(this.f3150o.mo8007c(i));
                if (!holder.shouldIgnore() && (!holder.isInvalid() || this.f3164v.hasStableIds())) {
                    this.f3152p.mo7318c(holder, this.f3131W.mo7720a(this.f3157ra, holder, C0975f.m4838a(holder), holder.getUnmodifiedPayloads()));
                    if (this.f3157ra.f3225i && holder.isUpdated() && !holder.isRemoved() && !holder.shouldIgnore() && !holder.isInvalid()) {
                        this.f3152p.mo7311a(mo7567d(holder), holder);
                    }
                }
            }
        }
        if (this.f3157ra.f3228l) {
            mo7683y();
            C0997t tVar3 = this.f3157ra;
            boolean didStructureChange = tVar3.f3223g;
            tVar3.f3223g = false;
            this.f3166w.onLayoutChildren(this.f3144l, tVar3);
            this.f3157ra.f3223g = didStructureChange;
            for (int i2 = 0; i2 < this.f3150o.mo7998a(); i2++) {
                C1000w viewHolder = m4736j(this.f3150o.mo8007c(i2));
                if (!viewHolder.shouldIgnore() && !this.f3152p.mo7319c(viewHolder)) {
                    int flags = C0975f.m4838a(viewHolder);
                    boolean wasHidden = viewHolder.hasAnyOfTheFlags(Opcodes.ACC_ANNOTATION);
                    if (!wasHidden) {
                        flags |= Opcodes.ACC_SYNTHETIC;
                    }
                    C0978c animationInfo = this.f3131W.mo7720a(this.f3157ra, viewHolder, flags, viewHolder.getUnmodifiedPayloads());
                    if (wasHidden) {
                        mo7532a(viewHolder, animationInfo);
                    } else {
                        this.f3152p.mo7314a(viewHolder, animationInfo);
                    }
                }
            }
            mo7545b();
        } else {
            mo7545b();
        }
        mo7679u();
        mo7559c(false);
        this.f3157ra.f3221e = 2;
    }

    /* renamed from: E */
    private void m4701E() {
        mo7684z();
        mo7678t();
        this.f3157ra.mo7946a(6);
        this.f3148n.mo8476b();
        this.f3157ra.f3222f = this.f3164v.getItemCount();
        C0997t tVar = this.f3157ra;
        tVar.f3220d = 0;
        tVar.f3224h = false;
        this.f3166w.onLayoutChildren(this.f3144l, tVar);
        C0997t tVar2 = this.f3157ra;
        tVar2.f3223g = false;
        this.f3146m = null;
        tVar2.f3227k = tVar2.f3227k && this.f3131W != null;
        this.f3157ra.f3221e = 4;
        mo7679u();
        mo7559c(false);
    }

    /* renamed from: F */
    private void m4702F() {
        this.f3157ra.mo7946a(4);
        mo7684z();
        mo7678t();
        C0997t tVar = this.f3157ra;
        tVar.f3221e = 1;
        if (tVar.f3227k) {
            for (int i = this.f3150o.mo7998a() - 1; i >= 0; i--) {
                C1000w holder = m4736j(this.f3150o.mo8007c(i));
                if (!holder.shouldIgnore()) {
                    long key = mo7567d(holder);
                    C0978c animationInfo = this.f3131W.mo7719a(this.f3157ra, holder);
                    C1000w oldChangeViewHolder = this.f3152p.mo7309a(key);
                    if (oldChangeViewHolder == null || oldChangeViewHolder.shouldIgnore()) {
                        this.f3152p.mo7316b(holder, animationInfo);
                    } else {
                        boolean oldDisappearing = this.f3152p.mo7317b(oldChangeViewHolder);
                        boolean newDisappearing = this.f3152p.mo7317b(holder);
                        if (!oldDisappearing || oldChangeViewHolder != holder) {
                            C0978c preInfo = this.f3152p.mo7322f(oldChangeViewHolder);
                            this.f3152p.mo7316b(holder, animationInfo);
                            C0978c postInfo = this.f3152p.mo7321e(holder);
                            if (preInfo == null) {
                                m4716a(key, holder, oldChangeViewHolder);
                            } else {
                                m4719a(oldChangeViewHolder, holder, preInfo, postInfo, oldDisappearing, newDisappearing);
                            }
                        } else {
                            this.f3152p.mo7316b(holder, animationInfo);
                        }
                    }
                }
            }
            this.f3152p.mo7312a(this.f3116Ha);
        }
        this.f3166w.removeAndRecycleScrapInt(this.f3144l);
        C0997t tVar2 = this.f3157ra;
        tVar2.f3219c = tVar2.f3222f;
        this.f3122N = false;
        this.f3123O = false;
        tVar2.f3227k = false;
        tVar2.f3228l = false;
        this.f3166w.mRequestedSimpleAnimations = false;
        ArrayList<C1000w> arrayList = this.f3144l.f3201b;
        if (arrayList != null) {
            arrayList.clear();
        }
        C0981i iVar = this.f3166w;
        if (iVar.mPrefetchMaxObservedInInitialPrefetch) {
            iVar.mPrefetchMaxCountObserved = 0;
            iVar.mPrefetchMaxObservedInInitialPrefetch = false;
            this.f3144l.mo7921j();
        }
        this.f3166w.onLayoutCompleted(this.f3157ra);
        mo7679u();
        mo7559c(false);
        this.f3152p.mo7310a();
        int[] iArr = this.f3102Aa;
        if (m4737k(iArr[0], iArr[1])) {
            mo7570d(0, 0);
        }
        m4708L();
        m4710N();
    }

    /* renamed from: a */
    private void m4716a(long key, C1000w holder, C1000w oldChangeViewHolder) {
        int childCount = this.f3150o.mo7998a();
        for (int i = 0; i < childCount; i++) {
            C1000w other = m4736j(this.f3150o.mo8007c(i));
            if (other != holder && mo7567d(other) == key) {
                C0970a aVar = this.f3164v;
                String str = " \n View Holder 2:";
                if (aVar == null || !aVar.hasStableIds()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                    sb.append(other);
                    sb.append(str);
                    sb.append(holder);
                    sb.append(mo7625k());
                    throw new IllegalStateException(sb.toString());
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                sb2.append(other);
                sb2.append(str);
                sb2.append(holder);
                sb2.append(mo7625k());
                throw new IllegalStateException(sb2.toString());
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        sb3.append(oldChangeViewHolder);
        sb3.append(" cannot be found but it is necessary for ");
        sb3.append(holder);
        sb3.append(mo7625k());
        Log.e("RecyclerView", sb3.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7532a(C1000w viewHolder, C0978c animationInfo) {
        viewHolder.setFlags(0, Opcodes.ACC_ANNOTATION);
        if (this.f3157ra.f3225i && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.f3152p.mo7311a(mo7567d(viewHolder), viewHolder);
        }
        this.f3152p.mo7318c(viewHolder, animationInfo);
    }

    /* renamed from: a */
    private void m4725a(int[] into) {
        int count = this.f3150o.mo7998a();
        if (count == 0) {
            into[0] = -1;
            into[1] = -1;
            return;
        }
        int minPositionPreLayout = MoPubClientPositioning.NO_REPEAT;
        int maxPositionPreLayout = LinearLayoutManager.INVALID_OFFSET;
        for (int i = 0; i < count; i++) {
            C1000w holder = m4736j(this.f3150o.mo8007c(i));
            if (!holder.shouldIgnore()) {
                int pos = holder.getLayoutPosition();
                if (pos < minPositionPreLayout) {
                    minPositionPreLayout = pos;
                }
                if (pos > maxPositionPreLayout) {
                    maxPositionPreLayout = pos;
                }
            }
        }
        into[0] = minPositionPreLayout;
        into[1] = maxPositionPreLayout;
    }

    /* renamed from: k */
    private boolean m4737k(int minPositionPreLayout, int maxPositionPreLayout) {
        m4725a(this.f3102Aa);
        int[] iArr = this.f3102Aa;
        return (iArr[0] == minPositionPreLayout && iArr[1] == maxPositionPreLayout) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View child, boolean animate) {
        C1000w vh = m4736j(child);
        if (vh != null) {
            if (vh.isTmpDetached()) {
                vh.clearTmpDetachFlag();
            } else if (!vh.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(vh);
                sb.append(mo7625k());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        child.clearAnimation();
        mo7551b(child);
        super.removeDetachedView(child, animate);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public long mo7567d(C1000w holder) {
        return this.f3164v.hasStableIds() ? holder.getItemId() : (long) holder.mPosition;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7533a(C1000w itemHolder, C0978c preLayoutInfo, C0978c postLayoutInfo) {
        itemHolder.setIsRecyclable(false);
        if (this.f3131W.mo7724a(itemHolder, preLayoutInfo, postLayoutInfo)) {
            mo7680v();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7550b(C1000w holder, C0978c preLayoutInfo, C0978c postLayoutInfo) {
        m4735e(holder);
        holder.setIsRecyclable(false);
        if (this.f3131W.mo7729b(holder, preLayoutInfo, postLayoutInfo)) {
            mo7680v();
        }
    }

    /* renamed from: a */
    private void m4719a(C1000w oldHolder, C1000w newHolder, C0978c preInfo, C0978c postInfo, boolean oldHolderDisappearing, boolean newHolderDisappearing) {
        oldHolder.setIsRecyclable(false);
        if (oldHolderDisappearing) {
            m4735e(oldHolder);
        }
        if (oldHolder != newHolder) {
            if (newHolderDisappearing) {
                m4735e(newHolder);
            }
            oldHolder.mShadowedHolder = newHolder;
            m4735e(oldHolder);
            this.f3144l.mo7909c(oldHolder);
            newHolder.setIsRecyclable(false);
            newHolder.mShadowingHolder = oldHolder;
        }
        if (this.f3131W.mo7725a(oldHolder, newHolder, preInfo, postInfo)) {
            mo7680v();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        C0574d.m2755a("RV OnLayout");
        mo7580e();
        C0574d.m2754a();
        this.f3109E = true;
    }

    public void requestLayout() {
        if (this.f3111F != 0 || this.f3115H) {
            this.f3113G = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public void mo7648r() {
        int childCount = this.f3150o.mo8004b();
        for (int i = 0; i < childCount; i++) {
            ((C0984j) this.f3150o.mo8010d(i).getLayoutParams()).f3192c = true;
        }
        this.f3144l.mo7918g();
    }

    public void draw(Canvas c) {
        super.draw(c);
        int count = this.f3170y.size();
        for (int i = 0; i < count; i++) {
            ((C0980h) this.f3170y.get(i)).onDrawOver(c, this, this.f3157ra);
        }
        boolean needsInvalidate = false;
        EdgeEffect edgeEffect = this.f3127S;
        boolean z = true;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int restore = c.save();
            int padding = this.f3154q ? getPaddingBottom() : 0;
            c.rotate(270.0f);
            c.translate((float) ((-getHeight()) + padding), 0.0f);
            EdgeEffect edgeEffect2 = this.f3127S;
            needsInvalidate = edgeEffect2 != null && edgeEffect2.draw(c);
            c.restoreToCount(restore);
        }
        EdgeEffect edgeEffect3 = this.f3128T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int restore2 = c.save();
            if (this.f3154q) {
                c.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f3128T;
            needsInvalidate |= edgeEffect4 != null && edgeEffect4.draw(c);
            c.restoreToCount(restore2);
        }
        EdgeEffect edgeEffect5 = this.f3129U;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int restore3 = c.save();
            int width = getWidth();
            int padding2 = this.f3154q ? getPaddingTop() : 0;
            c.rotate(90.0f);
            c.translate((float) (-padding2), (float) (-width));
            EdgeEffect edgeEffect6 = this.f3129U;
            needsInvalidate |= edgeEffect6 != null && edgeEffect6.draw(c);
            c.restoreToCount(restore3);
        }
        EdgeEffect edgeEffect7 = this.f3130V;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int restore4 = c.save();
            c.rotate(180.0f);
            if (this.f3154q) {
                c.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                c.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.f3130V;
            if (edgeEffect8 == null || !edgeEffect8.draw(c)) {
                z = false;
            }
            needsInvalidate |= z;
            c.restoreToCount(restore4);
        }
        if (!needsInvalidate && this.f3131W != null && this.f3170y.size() > 0 && this.f3131W.mo7738g()) {
            needsInvalidate = true;
        }
        if (needsInvalidate) {
            C0646w.m2990x(this);
        }
    }

    public void onDraw(Canvas c) {
        super.onDraw(c);
        int count = this.f3170y.size();
        for (int i = 0; i < count; i++) {
            ((C0980h) this.f3170y.get(i)).onDraw(c, this, this.f3157ra);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams p) {
        return (p instanceof C0984j) && this.f3166w.checkLayoutParams((C0984j) p);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            return iVar.generateDefaultLayoutParams();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(mo7625k());
        throw new IllegalStateException(sb.toString());
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            return iVar.generateLayoutParams(getContext(), attrs);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(mo7625k());
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams p) {
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            return iVar.generateLayoutParams(p);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(mo7625k());
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: y */
    public void mo7683y() {
        int childCount = this.f3150o.mo8004b();
        for (int i = 0; i < childCount; i++) {
            C1000w holder = m4736j(this.f3150o.mo8010d(i));
            if (!holder.shouldIgnore()) {
                holder.saveOldPosition();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7545b() {
        int childCount = this.f3150o.mo8004b();
        for (int i = 0; i < childCount; i++) {
            C1000w holder = m4736j(this.f3150o.mo8010d(i));
            if (!holder.shouldIgnore()) {
                holder.clearOldPosition();
            }
        }
        this.f3144l.mo7902b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo7591g(int from, int to) {
        int inBetweenOffset;
        int end;
        int start;
        int childCount = this.f3150o.mo8004b();
        if (from < to) {
            start = from;
            end = to;
            inBetweenOffset = -1;
        } else {
            start = to;
            end = from;
            inBetweenOffset = 1;
        }
        for (int i = 0; i < childCount; i++) {
            C1000w holder = m4736j(this.f3150o.mo8010d(i));
            if (holder != null) {
                int i2 = holder.mPosition;
                if (i2 >= start && i2 <= end) {
                    if (i2 == from) {
                        holder.offsetPosition(to - from, false);
                    } else {
                        holder.offsetPosition(inBetweenOffset, false);
                    }
                    this.f3157ra.f3223g = true;
                }
            }
        }
        this.f3144l.mo7903b(from, to);
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo7586f(int positionStart, int itemCount) {
        int childCount = this.f3150o.mo8004b();
        for (int i = 0; i < childCount; i++) {
            C1000w holder = m4736j(this.f3150o.mo8010d(i));
            if (holder != null && !holder.shouldIgnore() && holder.mPosition >= positionStart) {
                holder.offsetPosition(itemCount, false);
                this.f3157ra.f3223g = true;
            }
        }
        this.f3144l.mo7892a(positionStart, itemCount);
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7525a(int positionStart, int itemCount, boolean applyToPreLayout) {
        int positionEnd = positionStart + itemCount;
        int childCount = this.f3150o.mo8004b();
        for (int i = 0; i < childCount; i++) {
            C1000w holder = m4736j(this.f3150o.mo8010d(i));
            if (holder != null && !holder.shouldIgnore()) {
                int i2 = holder.mPosition;
                if (i2 >= positionEnd) {
                    holder.offsetPosition(-itemCount, applyToPreLayout);
                    this.f3157ra.f3223g = true;
                } else if (i2 >= positionStart) {
                    holder.flagRemovedAndOffsetPosition(positionStart - 1, -itemCount, applyToPreLayout);
                    this.f3157ra.f3223g = true;
                }
            }
        }
        this.f3144l.mo7893a(positionStart, itemCount, applyToPreLayout);
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7524a(int positionStart, int itemCount, Object payload) {
        int childCount = this.f3150o.mo8004b();
        int positionEnd = positionStart + itemCount;
        for (int i = 0; i < childCount; i++) {
            View child = this.f3150o.mo8010d(i);
            C1000w holder = m4736j(child);
            if (holder != null && !holder.shouldIgnore()) {
                int i2 = holder.mPosition;
                if (i2 >= positionStart && i2 < positionEnd) {
                    holder.addFlags(2);
                    holder.addChangePayload(payload);
                    ((C0984j) child.getLayoutParams()).f3192c = true;
                }
            }
        }
        this.f3144l.mo7908c(positionStart, itemCount);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7540a(C1000w viewHolder) {
        C0975f fVar = this.f3131W;
        return fVar == null || fVar.mo7726a(viewHolder, viewHolder.getUnmodifiedPayloads());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7553b(boolean dispatchItemsChanged) {
        this.f3123O |= dispatchItemsChanged;
        this.f3122N = true;
        mo7654s();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public void mo7654s() {
        int childCount = this.f3150o.mo8004b();
        for (int i = 0; i < childCount; i++) {
            C1000w holder = m4736j(this.f3150o.mo8010d(i));
            if (holder != null && !holder.shouldIgnore()) {
                holder.addFlags(6);
            }
        }
        mo7648r();
        this.f3144l.mo7919h();
    }

    /* renamed from: o */
    public void mo7633o() {
        if (this.f3170y.size() != 0) {
            C0981i iVar = this.f3166w;
            if (iVar != null) {
                iVar.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            mo7648r();
            requestLayout();
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f3149na;
    }

    public void setPreserveFocusAfterLayout(boolean preserveFocusAfterLayout) {
        this.f3149na = preserveFocusAfterLayout;
    }

    /* renamed from: i */
    public C1000w mo7616i(View child) {
        ViewParent parent = child.getParent();
        if (parent == null || parent == this) {
            return m4736j(child);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(child);
        sb.append(" is not a direct child of ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: c */
    public View mo7556c(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* renamed from: d */
    public C1000w mo7568d(View view) {
        View itemView = mo7556c(view);
        if (itemView == null) {
            return null;
        }
        return mo7616i(itemView);
    }

    /* renamed from: j */
    static C1000w m4736j(View child) {
        if (child == null) {
            return null;
        }
        return ((C0984j) child.getLayoutParams()).f3190a;
    }

    @Deprecated
    /* renamed from: h */
    public int mo7611h(View child) {
        return mo7583f(child);
    }

    /* renamed from: f */
    public int mo7583f(View child) {
        C1000w holder = m4736j(child);
        if (holder != null) {
            return holder.getAdapterPosition();
        }
        return -1;
    }

    /* renamed from: g */
    public int mo7588g(View child) {
        C1000w holder = m4736j(child);
        if (holder != null) {
            return holder.getLayoutPosition();
        }
        return -1;
    }

    /* renamed from: c */
    public C1000w mo7555c(int position) {
        return mo7519a(position, false);
    }

    /* renamed from: b */
    public C1000w mo7544b(int position) {
        if (this.f3122N) {
            return null;
        }
        int childCount = this.f3150o.mo8004b();
        C1000w hidden = null;
        for (int i = 0; i < childCount; i++) {
            C1000w holder = m4736j(this.f3150o.mo8010d(i));
            if (holder != null && !holder.isRemoved() && mo7554c(holder) == position) {
                if (!this.f3150o.mo8009c(holder.itemView)) {
                    return holder;
                }
                hidden = holder;
            }
        }
        return hidden;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1000w mo7519a(int position, boolean checkNewPosition) {
        int childCount = this.f3150o.mo8004b();
        C1000w hidden = null;
        for (int i = 0; i < childCount; i++) {
            C1000w holder = m4736j(this.f3150o.mo8010d(i));
            if (holder != null && !holder.isRemoved()) {
                if (checkNewPosition) {
                    if (holder.mPosition != position) {
                        continue;
                    }
                } else if (holder.getLayoutPosition() != position) {
                    continue;
                }
                if (!this.f3150o.mo8009c(holder.itemView)) {
                    return holder;
                }
                hidden = holder;
            }
        }
        return hidden;
    }

    /* renamed from: a */
    public C1000w mo7520a(long id) {
        C0970a aVar = this.f3164v;
        if (aVar == null || !aVar.hasStableIds()) {
            return null;
        }
        int childCount = this.f3150o.mo8004b();
        C1000w hidden = null;
        for (int i = 0; i < childCount; i++) {
            C1000w holder = m4736j(this.f3150o.mo8010d(i));
            if (holder != null && !holder.isRemoved() && holder.getItemId() == id) {
                if (!this.f3150o.mo8009c(holder.itemView)) {
                    return holder;
                }
                hidden = holder;
            }
        }
        return hidden;
    }

    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        return super.drawChild(canvas, child, drawingTime);
    }

    /* renamed from: g */
    public void mo7590g(int dy) {
        int childCount = this.f3150o.mo7998a();
        for (int i = 0; i < childCount; i++) {
            this.f3150o.mo8007c(i).offsetTopAndBottom(dy);
        }
    }

    /* renamed from: l */
    public void mo7627l(View child) {
    }

    /* renamed from: m */
    public void mo7630m(View child) {
    }

    /* renamed from: f */
    public void mo7585f(int dx) {
        int childCount = this.f3150o.mo7998a();
        for (int i = 0; i < childCount; i++) {
            this.f3150o.mo8007c(i).offsetLeftAndRight(dx);
        }
    }

    /* renamed from: a */
    static void m4723a(View view, Rect outBounds) {
        C0984j lp = (C0984j) view.getLayoutParams();
        Rect insets = lp.f3191b;
        outBounds.set((view.getLeft() - insets.left) - lp.leftMargin, (view.getTop() - insets.top) - lp.topMargin, view.getRight() + insets.right + lp.rightMargin, view.getBottom() + insets.bottom + lp.bottomMargin);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public Rect mo7624k(View child) {
        C0984j lp = (C0984j) child.getLayoutParams();
        if (!lp.f3192c) {
            return lp.f3191b;
        }
        if (this.f3157ra.mo7950d() && (lp.mo7865b() || lp.mo7867d())) {
            return lp.f3191b;
        }
        Rect insets = lp.f3191b;
        insets.set(0, 0, 0, 0);
        int decorCount = this.f3170y.size();
        for (int i = 0; i < decorCount; i++) {
            this.f3158s.set(0, 0, 0, 0);
            ((C0980h) this.f3170y.get(i)).getItemOffsets(this.f3158s, child, this, this.f3157ra);
            int i2 = insets.left;
            Rect rect = this.f3158s;
            insets.left = i2 + rect.left;
            insets.top += rect.top;
            insets.right += rect.right;
            insets.bottom += rect.bottom;
        }
        lp.f3192c = false;
        return insets;
    }

    /* renamed from: h */
    public void mo7614h(int dx, int dy) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo7570d(int hresult, int vresult) {
        this.f3125Q++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        mo7614h(hresult, vresult);
        C0988n nVar = this.f3159sa;
        if (nVar != null) {
            nVar.onScrolled(this, hresult, vresult);
        }
        List<C0988n> list = this.f3161ta;
        if (list != null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                ((C0988n) this.f3161ta.get(i)).onScrolled(this, hresult, vresult);
            }
        }
        this.f3125Q--;
    }

    /* renamed from: h */
    public void mo7613h(int state) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7521a(int state) {
        C0981i iVar = this.f3166w;
        if (iVar != null) {
            iVar.onScrollStateChanged(state);
        }
        mo7613h(state);
        C0988n nVar = this.f3159sa;
        if (nVar != null) {
            nVar.onScrollStateChanged(this, state);
        }
        List<C0988n> list = this.f3161ta;
        if (list != null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                ((C0988n) this.f3161ta.get(i)).onScrollStateChanged(this, state);
            }
        }
    }

    /* renamed from: l */
    public boolean mo7628l() {
        return !this.f3109E || this.f3122N || this.f3148n.mo8478c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: x */
    public void mo7682x() {
        int count = this.f3150o.mo7998a();
        for (int i = 0; i < count; i++) {
            View view = this.f3150o.mo8007c(i);
            C1000w holder = mo7616i(view);
            if (holder != null) {
                C1000w wVar = holder.mShadowingHolder;
                if (wVar != null) {
                    View shadowingView = wVar.itemView;
                    int left = view.getLeft();
                    int top = view.getTop();
                    if (left != shadowingView.getLeft() || top != shadowingView.getTop()) {
                        shadowingView.layout(left, top, shadowingView.getWidth() + left, shadowingView.getHeight() + top);
                    }
                }
            }
        }
    }

    /* renamed from: e */
    static RecyclerView m4734e(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup parent = (ViewGroup) view;
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            RecyclerView descendant = m4734e(parent.getChildAt(i));
            if (descendant != null) {
                return descendant;
            }
        }
        return null;
    }

    /* renamed from: b */
    static void m4730b(C1000w holder) {
        WeakReference<RecyclerView> weakReference = holder.mNestedRecyclerView;
        if (weakReference != null) {
            View item = (View) weakReference.get();
            while (item != null) {
                if (item != holder.itemView) {
                    ViewParent parent = item.getParent();
                    if (parent instanceof View) {
                        item = (View) parent;
                    } else {
                        item = null;
                    }
                } else {
                    return;
                }
            }
            holder.mNestedRecyclerView = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public long getNanoTime() {
        if (f3096f) {
            return System.nanoTime();
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7551b(View child) {
        C1000w viewHolder = m4736j(child);
        mo7630m(child);
        C0970a aVar = this.f3164v;
        if (!(aVar == null || viewHolder == null)) {
            aVar.onViewDetachedFromWindow(viewHolder);
        }
        List<C0985k> list = this.f3121M;
        if (list != null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                ((C0985k) this.f3121M.get(i)).mo7868a(child);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7534a(View child) {
        C1000w viewHolder = m4736j(child);
        mo7627l(child);
        C0970a aVar = this.f3164v;
        if (!(aVar == null || viewHolder == null)) {
            aVar.onViewAttachedToWindow(viewHolder);
        }
        List<C0985k> list = this.f3121M;
        if (list != null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                ((C0985k) this.f3121M.get(i)).mo7869b(child);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7541a(C1000w viewHolder, int importantForAccessibility) {
        if (mo7647q()) {
            viewHolder.mPendingAccessibilityState = importantForAccessibility;
            this.f3112Fa.add(viewHolder);
            return false;
        }
        C0646w.m2970d(viewHolder.itemView, importantForAccessibility);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo7584f() {
        for (int i = this.f3112Fa.size() - 1; i >= 0; i--) {
            C1000w viewHolder = (C1000w) this.f3112Fa.get(i);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore()) {
                int state = viewHolder.mPendingAccessibilityState;
                if (state != -1) {
                    C0646w.m2970d(viewHolder.itemView, state);
                    viewHolder.mPendingAccessibilityState = -1;
                }
            }
        }
        this.f3112Fa.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo7554c(C1000w viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        return this.f3148n.mo8466a(viewHolder.mPosition);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7526a(StateListDrawable verticalThumbDrawable, Drawable verticalTrackDrawable, StateListDrawable horizontalThumbDrawable, Drawable horizontalTrackDrawable) {
        if (verticalThumbDrawable == null || verticalTrackDrawable == null || horizontalThumbDrawable == null || horizontalTrackDrawable == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to set fast scroller without both required drawables.");
            sb.append(mo7625k());
            throw new IllegalArgumentException(sb.toString());
        }
        Resources resources = getContext().getResources();
        new C1071ja(this, verticalThumbDrawable, verticalTrackDrawable, horizontalThumbDrawable, horizontalTrackDrawable, resources.getDimensionPixelSize(C1286a.fastscroll_default_thickness), resources.getDimensionPixelSize(C1286a.fastscroll_minimum_range), resources.getDimensionPixelOffset(C1286a.fastscroll_margin));
    }

    public void setNestedScrollingEnabled(boolean enabled) {
        getScrollingChildHelper().mo5669a(enabled);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().mo5679b();
    }

    public boolean startNestedScroll(int axes) {
        return getScrollingChildHelper().mo5680b(axes);
    }

    /* renamed from: j */
    public boolean mo7623j(int axes, int type) {
        return getScrollingChildHelper().mo5674a(axes, type);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().mo5681c();
    }

    /* renamed from: k */
    public void mo7626k(int type) {
        getScrollingChildHelper().mo5682c(type);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().mo5670a();
    }

    /* renamed from: d */
    public boolean mo7571d(int type) {
        return getScrollingChildHelper().mo5673a(type);
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return getScrollingChildHelper().mo5675a(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    /* renamed from: a */
    public boolean mo7537a(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        return getScrollingChildHelper().mo5676a(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return getScrollingChildHelper().mo5677a(dx, dy, consumed, offsetInWindow);
    }

    /* renamed from: a */
    public boolean mo7539a(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        return getScrollingChildHelper().mo5678a(dx, dy, consumed, offsetInWindow, type);
    }

    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return getScrollingChildHelper().mo5672a(velocityX, velocityY, consumed);
    }

    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return getScrollingChildHelper().mo5671a(velocityX, velocityY);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int childCount, int i) {
        C0973d dVar = this.f3173za;
        if (dVar == null) {
            return super.getChildDrawingOrder(childCount, i);
        }
        return dVar.mo7717a(childCount, i);
    }

    private C0637n getScrollingChildHelper() {
        if (this.f3104Ba == null) {
            this.f3104Ba = new C0637n(this);
        }
        return this.f3104Ba;
    }
}

package android.support.p000v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.C0165s;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.p000v4.app.C0486t.C0487a;
import android.support.p000v4.app.C0486t.C0488b;
import android.support.p000v4.app.C0486t.C0489c;
import android.support.p000v4.app.Fragment.SavedState;
import android.support.p000v4.view.C0646w;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p002b.p003c.p053g.p061f.C1255d;
import p002b.p003c.p053g.p061f.C1257f;
import p002b.p003c.p053g.p061f.C1258g;
import p002b.p003c.p053g.p061f.C1268l;

/* renamed from: android.support.v4.app.A */
/* compiled from: FragmentManager */
final class C0409A extends C0486t implements Factory2 {

    /* renamed from: a */
    static boolean f1337a = false;

    /* renamed from: b */
    static Field f1338b = null;

    /* renamed from: c */
    static final Interpolator f1339c = new DecelerateInterpolator(2.5f);

    /* renamed from: d */
    static final Interpolator f1340d = new DecelerateInterpolator(1.5f);

    /* renamed from: e */
    static final Interpolator f1341e = new AccelerateInterpolator(2.5f);

    /* renamed from: f */
    static final Interpolator f1342f = new AccelerateInterpolator(1.5f);

    /* renamed from: A */
    String f1343A;

    /* renamed from: B */
    boolean f1344B;

    /* renamed from: C */
    ArrayList<C0467f> f1345C;

    /* renamed from: D */
    ArrayList<Boolean> f1346D;

    /* renamed from: E */
    ArrayList<Fragment> f1347E;

    /* renamed from: F */
    Bundle f1348F = null;

    /* renamed from: G */
    SparseArray<Parcelable> f1349G = null;

    /* renamed from: H */
    ArrayList<C0418i> f1350H;

    /* renamed from: I */
    C0419B f1351I;

    /* renamed from: J */
    Runnable f1352J = new C0490u(this);

    /* renamed from: g */
    ArrayList<C0416g> f1353g;

    /* renamed from: h */
    boolean f1354h;

    /* renamed from: i */
    int f1355i = 0;

    /* renamed from: j */
    final ArrayList<Fragment> f1356j = new ArrayList<>();

    /* renamed from: k */
    SparseArray<Fragment> f1357k;

    /* renamed from: l */
    ArrayList<C0467f> f1358l;

    /* renamed from: m */
    ArrayList<Fragment> f1359m;

    /* renamed from: n */
    ArrayList<C0467f> f1360n;

    /* renamed from: o */
    ArrayList<Integer> f1361o;

    /* renamed from: p */
    ArrayList<C0489c> f1362p;

    /* renamed from: q */
    private final CopyOnWriteArrayList<C1268l<C0488b, Boolean>> f1363q = new CopyOnWriteArrayList<>();

    /* renamed from: r */
    int f1364r = 0;

    /* renamed from: s */
    C0485s f1365s;

    /* renamed from: t */
    C0483q f1366t;

    /* renamed from: u */
    Fragment f1367u;

    /* renamed from: v */
    Fragment f1368v;

    /* renamed from: w */
    boolean f1369w;

    /* renamed from: x */
    boolean f1370x;

    /* renamed from: y */
    boolean f1371y;

    /* renamed from: z */
    boolean f1372z;

    /* renamed from: android.support.v4.app.A$a */
    /* compiled from: FragmentManager */
    private static class C0410a extends C0411b {

        /* renamed from: b */
        View f1373b;

        C0410a(View v, AnimationListener listener) {
            super(listener, null);
            this.f1373b = v;
        }

        public void onAnimationEnd(Animation animation) {
            if (C0646w.m2986t(this.f1373b) || VERSION.SDK_INT >= 24) {
                this.f1373b.post(new C0495z(this));
            } else {
                this.f1373b.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* renamed from: android.support.v4.app.A$b */
    /* compiled from: FragmentManager */
    private static class C0411b implements AnimationListener {

        /* renamed from: a */
        private final AnimationListener f1374a;

        /* synthetic */ C0411b(AnimationListener x0, C0490u x1) {
            this(x0);
        }

        private C0411b(AnimationListener wrapped) {
            this.f1374a = wrapped;
        }

        public void onAnimationStart(Animation animation) {
            AnimationListener animationListener = this.f1374a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            AnimationListener animationListener = this.f1374a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            AnimationListener animationListener = this.f1374a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }
    }

    /* renamed from: android.support.v4.app.A$c */
    /* compiled from: FragmentManager */
    private static class C0412c {

        /* renamed from: a */
        public final Animation f1375a;

        /* renamed from: b */
        public final Animator f1376b;

        /* synthetic */ C0412c(Animator x0, C0490u x1) {
            this(x0);
        }

        /* synthetic */ C0412c(Animation x0, C0490u x1) {
            this(x0);
        }

        private C0412c(Animation animation) {
            this.f1375a = animation;
            this.f1376b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        private C0412c(Animator animator) {
            this.f1375a = null;
            this.f1376b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: android.support.v4.app.A$d */
    /* compiled from: FragmentManager */
    private static class C0413d extends AnimatorListenerAdapter {

        /* renamed from: a */
        View f1377a;

        C0413d(View v) {
            this.f1377a = v;
        }

        public void onAnimationStart(Animator animation) {
            this.f1377a.setLayerType(2, null);
        }

        public void onAnimationEnd(Animator animation) {
            this.f1377a.setLayerType(0, null);
            animation.removeListener(this);
        }
    }

    /* renamed from: android.support.v4.app.A$e */
    /* compiled from: FragmentManager */
    private static class C0414e extends AnimationSet implements Runnable {

        /* renamed from: a */
        private final ViewGroup f1378a;

        /* renamed from: b */
        private final View f1379b;

        /* renamed from: c */
        private boolean f1380c;

        /* renamed from: d */
        private boolean f1381d;

        C0414e(Animation animation, ViewGroup parent, View child) {
            super(false);
            this.f1378a = parent;
            this.f1379b = child;
            addAnimation(animation);
        }

        public boolean getTransformation(long currentTime, Transformation t) {
            if (this.f1380c) {
                return !this.f1381d;
            }
            if (!super.getTransformation(currentTime, t)) {
                this.f1380c = true;
                C0464da.m2363a(this.f1378a, this);
            }
            return true;
        }

        public boolean getTransformation(long currentTime, Transformation outTransformation, float scale) {
            if (this.f1380c) {
                return !this.f1381d;
            }
            if (!super.getTransformation(currentTime, outTransformation, scale)) {
                this.f1380c = true;
                C0464da.m2363a(this.f1378a, this);
            }
            return true;
        }

        public void run() {
            this.f1378a.endViewTransition(this.f1379b);
            this.f1381d = true;
        }
    }

    /* renamed from: android.support.v4.app.A$f */
    /* compiled from: FragmentManager */
    static class C0415f {

        /* renamed from: a */
        public static final int[] f1382a = {16842755, 16842960, 16842961};
    }

    /* renamed from: android.support.v4.app.A$g */
    /* compiled from: FragmentManager */
    interface C0416g {
        /* renamed from: a */
        boolean mo5002a(ArrayList<C0467f> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* renamed from: android.support.v4.app.A$h */
    /* compiled from: FragmentManager */
    private class C0417h implements C0416g {

        /* renamed from: a */
        final String f1383a;

        /* renamed from: b */
        final int f1384b;

        /* renamed from: c */
        final int f1385c;

        C0417h(String name, int id, int flags) {
            this.f1383a = name;
            this.f1384b = id;
            this.f1385c = flags;
        }

        /* renamed from: a */
        public boolean mo5002a(ArrayList<C0467f> records, ArrayList<Boolean> isRecordPop) {
            Fragment fragment = C0409A.this.f1368v;
            if (fragment != null && this.f1384b < 0 && this.f1383a == null) {
                C0486t childManager = fragment.peekChildFragmentManager();
                if (childManager != null && childManager.mo4961g()) {
                    return false;
                }
            }
            return C0409A.this.mo4930a(records, isRecordPop, this.f1383a, this.f1384b, this.f1385c);
        }
    }

    /* renamed from: android.support.v4.app.A$i */
    /* compiled from: FragmentManager */
    static class C0418i implements C0006b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final boolean f1387a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final C0467f f1388b;

        /* renamed from: c */
        private int f1389c;

        C0418i(C0467f record, boolean isBack) {
            this.f1387a = isBack;
            this.f1388b = record;
        }

        /* renamed from: b */
        public void mo166b() {
            this.f1389c--;
            if (this.f1389c == 0) {
                this.f1388b.f1575a.m2041G();
            }
        }

        /* renamed from: a */
        public void mo165a() {
            this.f1389c++;
        }

        /* renamed from: e */
        public boolean mo5005e() {
            return this.f1389c == 0;
        }

        /* renamed from: d */
        public void mo5004d() {
            boolean z = false;
            boolean canceled = this.f1389c > 0;
            C0409A manager = this.f1388b.f1575a;
            int numAdded = manager.f1356j.size();
            for (int i = 0; i < numAdded; i++) {
                Fragment fragment = (Fragment) manager.f1356j.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (canceled && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            C0467f fVar = this.f1388b;
            C0409A a = fVar.f1575a;
            boolean z2 = this.f1387a;
            if (!canceled) {
                z = true;
            }
            a.m2050a(fVar, z2, z, true);
        }

        /* renamed from: c */
        public void mo5003c() {
            C0467f fVar = this.f1388b;
            fVar.f1575a.m2050a(fVar, this.f1387a, false, false);
        }
    }

    C0409A() {
    }

    /* renamed from: a */
    static boolean m2056a(C0412c anim) {
        Animation animation = anim.f1375a;
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return m2055a(anim.f1376b);
        }
        List<Animation> anims = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < anims.size(); i++) {
            if (anims.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m2055a(Animator anim) {
        if (anim == null) {
            return false;
        }
        if (anim instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) anim).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (anim instanceof AnimatorSet) {
            List<Animator> animList = ((AnimatorSet) anim).getChildAnimations();
            for (int i = 0; i < animList.size(); i++) {
                if (m2055a((Animator) animList.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m2057a(View v, C0412c anim) {
        boolean z = false;
        if (v == null || anim == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 19 && v.getLayerType() == 0 && C0646w.m2984r(v) && m2056a(anim)) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private void m2052a(RuntimeException ex) {
        String str = "FragmentManager";
        Log.e(str, ex.getMessage());
        Log.e(str, "Activity state:");
        PrintWriter pw = new PrintWriter(new C1258g(str));
        C0485s sVar = this.f1365s;
        String str2 = "Failed dumping state";
        String str3 = "  ";
        if (sVar != null) {
            try {
                sVar.mo226a(str3, (FileDescriptor) null, pw, new String[0]);
            } catch (Exception e) {
                Log.e(str, str2, e);
            }
        } else {
            try {
                mo4925a(str3, (FileDescriptor) null, pw, new String[0]);
            } catch (Exception e2) {
                Log.e(str, str2, e2);
            }
        }
        throw ex;
    }

    /* renamed from: a */
    public C0424G mo4909a() {
        return new C0467f(this);
    }

    /* renamed from: b */
    public boolean mo4940b() {
        boolean updates = mo4985s();
        m2040F();
        return updates;
    }

    /* renamed from: f */
    public void mo4956f() {
        mo4916a((C0416g) new C0417h(null, -1, 0), false);
    }

    /* renamed from: g */
    public boolean mo4961g() {
        m2037C();
        return m2058a((String) null, -1, 0);
    }

    /* renamed from: a */
    public boolean mo4929a(String name, int flags) {
        m2037C();
        return m2058a(name, -1, flags);
    }

    /* renamed from: a */
    public void mo4910a(int id, int flags) {
        if (id >= 0) {
            mo4916a((C0416g) new C0417h(null, id, flags), false);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bad id: ");
        sb.append(id);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private boolean m2058a(String name, int id, int flags) {
        mo4985s();
        m2065c(true);
        Fragment fragment = this.f1368v;
        if (fragment != null && id < 0 && name == null) {
            C0486t childManager = fragment.peekChildFragmentManager();
            if (childManager != null && childManager.mo4961g()) {
                return true;
            }
        }
        boolean executePop = mo4930a(this.f1345C, this.f1346D, name, id, flags);
        if (executePop) {
            this.f1354h = true;
            try {
                m2064c(this.f1345C, this.f1346D);
            } finally {
                m2038D();
            }
        }
        mo4984r();
        m2036B();
        return executePop;
    }

    /* renamed from: c */
    public int mo4943c() {
        ArrayList<C0467f> arrayList = this.f1358l;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* renamed from: b */
    public C0487a mo4933b(int index) {
        return (C0487a) this.f1358l.get(index);
    }

    /* renamed from: a */
    public void mo4914a(Bundle bundle, String key, Fragment fragment) {
        int i = fragment.mIndex;
        if (i >= 0) {
            bundle.putInt(key, i);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(fragment);
        sb.append(" is not currently in the FragmentManager");
        m2052a((RuntimeException) new IllegalStateException(sb.toString()));
        throw null;
    }

    /* renamed from: a */
    public Fragment mo4907a(Bundle bundle, String key) {
        int index = bundle.getInt(key, -1);
        if (index == -1) {
            return null;
        }
        Fragment f = (Fragment) this.f1357k.get(index);
        if (f != null) {
            return f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment no longer exists for key ");
        sb.append(key);
        sb.append(": index ");
        sb.append(index);
        m2052a((RuntimeException) new IllegalStateException(sb.toString()));
        throw null;
    }

    /* renamed from: d */
    public List<Fragment> mo4948d() {
        List<Fragment> list;
        if (this.f1356j.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f1356j) {
            list = (List) this.f1356j.clone();
        }
        return list;
    }

    /* renamed from: a */
    public SavedState mo4905a(Fragment fragment) {
        SavedState savedState = null;
        if (fragment.mIndex < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragment);
            sb.append(" is not currently in the FragmentManager");
            m2052a((RuntimeException) new IllegalStateException(sb.toString()));
            throw null;
        } else if (fragment.mState <= 0) {
            return null;
        } else {
            Bundle result = mo4973m(fragment);
            if (result != null) {
                savedState = new SavedState(result);
            }
            return savedState;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C1257f.m5913a(fragment, sb);
        } else {
            C1257f.m5913a(this.f1365s, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo4925a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append("    ");
        String innerPrefix = sb.toString();
        SparseArray<Fragment> sparseArray = this.f1357k;
        if (sparseArray != null) {
            int N = sparseArray.size();
            if (N > 0) {
                writer.print(prefix);
                writer.print("Active Fragments in ");
                writer.print(Integer.toHexString(System.identityHashCode(this)));
                writer.println(":");
                for (int i = 0; i < N; i++) {
                    Fragment f = (Fragment) this.f1357k.valueAt(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(f);
                    if (f != null) {
                        f.dump(innerPrefix, fd, writer, args);
                    }
                }
            }
        }
        int N2 = this.f1356j.size();
        if (N2 > 0) {
            writer.print(prefix);
            writer.println("Added Fragments:");
            for (int i2 = 0; i2 < N2; i2++) {
                Fragment f2 = (Fragment) this.f1356j.get(i2);
                writer.print(prefix);
                writer.print("  #");
                writer.print(i2);
                writer.print(": ");
                writer.println(f2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.f1359m;
        if (arrayList != null) {
            int N3 = arrayList.size();
            if (N3 > 0) {
                writer.print(prefix);
                writer.println("Fragments Created Menus:");
                for (int i3 = 0; i3 < N3; i3++) {
                    Fragment f3 = (Fragment) this.f1359m.get(i3);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i3);
                    writer.print(": ");
                    writer.println(f3.toString());
                }
            }
        }
        ArrayList<C0467f> arrayList2 = this.f1358l;
        if (arrayList2 != null) {
            int N4 = arrayList2.size();
            if (N4 > 0) {
                writer.print(prefix);
                writer.println("Back Stack:");
                for (int i4 = 0; i4 < N4; i4++) {
                    C0467f bs = (C0467f) this.f1358l.get(i4);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i4);
                    writer.print(": ");
                    writer.println(bs.toString());
                    bs.mo5151a(innerPrefix, fd, writer, args);
                }
            }
        }
        synchronized (this) {
            if (this.f1360n != null) {
                int N5 = this.f1360n.size();
                if (N5 > 0) {
                    writer.print(prefix);
                    writer.println("Back Stack Indices:");
                    for (int i5 = 0; i5 < N5; i5++) {
                        C0467f bs2 = (C0467f) this.f1360n.get(i5);
                        writer.print(prefix);
                        writer.print("  #");
                        writer.print(i5);
                        writer.print(": ");
                        writer.println(bs2);
                    }
                }
            }
            if (this.f1361o != null && this.f1361o.size() > 0) {
                writer.print(prefix);
                writer.print("mAvailBackStackIndices: ");
                writer.println(Arrays.toString(this.f1361o.toArray()));
            }
        }
        ArrayList<C0416g> arrayList3 = this.f1353g;
        if (arrayList3 != null) {
            int N6 = arrayList3.size();
            if (N6 > 0) {
                writer.print(prefix);
                writer.println("Pending Actions:");
                for (int i6 = 0; i6 < N6; i6++) {
                    C0416g r = (C0416g) this.f1353g.get(i6);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i6);
                    writer.print(": ");
                    writer.println(r);
                }
            }
        }
        writer.print(prefix);
        writer.println("FragmentManager misc state:");
        writer.print(prefix);
        writer.print("  mHost=");
        writer.println(this.f1365s);
        writer.print(prefix);
        writer.print("  mContainer=");
        writer.println(this.f1366t);
        if (this.f1367u != null) {
            writer.print(prefix);
            writer.print("  mParent=");
            writer.println(this.f1367u);
        }
        writer.print(prefix);
        writer.print("  mCurState=");
        writer.print(this.f1364r);
        writer.print(" mStateSaved=");
        writer.print(this.f1370x);
        writer.print(" mStopped=");
        writer.print(this.f1371y);
        writer.print(" mDestroyed=");
        writer.println(this.f1372z);
        if (this.f1369w) {
            writer.print(prefix);
            writer.print("  mNeedMenuInvalidate=");
            writer.println(this.f1369w);
        }
        if (this.f1343A != null) {
            writer.print(prefix);
            writer.print("  mNoTransactionsBecause=");
            writer.println(this.f1343A);
        }
    }

    /* renamed from: a */
    static C0412c m2044a(Context context, float startScale, float endScale, float startAlpha, float endAlpha) {
        AnimationSet set = new AnimationSet(false);
        ScaleAnimation scale = new ScaleAnimation(startScale, endScale, startScale, endScale, 1, 0.5f, 1, 0.5f);
        scale.setInterpolator(f1339c);
        scale.setDuration(220);
        set.addAnimation(scale);
        AlphaAnimation alpha = new AlphaAnimation(startAlpha, endAlpha);
        alpha.setInterpolator(f1340d);
        alpha.setDuration(220);
        set.addAnimation(alpha);
        return new C0412c((Animation) set, (C0490u) null);
    }

    /* renamed from: a */
    static C0412c m2043a(Context context, float start, float end) {
        AlphaAnimation anim = new AlphaAnimation(start, end);
        anim.setInterpolator(f1340d);
        anim.setDuration(220);
        return new C0412c((Animation) anim, (C0490u) null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0412c mo4904a(Fragment fragment, int transit, boolean enter, int transitionStyle) {
        int nextAnim = fragment.getNextAnim();
        Animation animation = fragment.onCreateAnimation(transit, enter, nextAnim);
        if (animation != null) {
            return new C0412c(animation, (C0490u) null);
        }
        Animator animator = fragment.onCreateAnimator(transit, enter, nextAnim);
        if (animator != null) {
            return new C0412c(animator, (C0490u) null);
        }
        if (nextAnim != 0) {
            boolean isAnim = "anim".equals(this.f1365s.mo5227c().getResources().getResourceTypeName(nextAnim));
            boolean successfulLoad = false;
            if (isAnim) {
                try {
                    Animation animation2 = AnimationUtils.loadAnimation(this.f1365s.mo5227c(), nextAnim);
                    if (animation2 != null) {
                        return new C0412c(animation2, (C0490u) null);
                    }
                    successfulLoad = true;
                } catch (NotFoundException e) {
                    throw e;
                } catch (RuntimeException e2) {
                }
            }
            if (!successfulLoad) {
                try {
                    Animator animator2 = AnimatorInflater.loadAnimator(this.f1365s.mo5227c(), nextAnim);
                    if (animator2 != null) {
                        return new C0412c(animator2, (C0490u) null);
                    }
                } catch (RuntimeException e3) {
                    if (!isAnim) {
                        Animation animation3 = AnimationUtils.loadAnimation(this.f1365s.mo5227c(), nextAnim);
                        if (animation3 != null) {
                            return new C0412c(animation3, (C0490u) null);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (transit == 0) {
            return null;
        }
        int styleIndex = m2059b(transit, enter);
        if (styleIndex < 0) {
            return null;
        }
        switch (styleIndex) {
            case 1:
                return m2044a(this.f1365s.mo5227c(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return m2044a(this.f1365s.mo5227c(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return m2044a(this.f1365s.mo5227c(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return m2044a(this.f1365s.mo5227c(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return m2043a(this.f1365s.mo5227c(), 0.0f, 1.0f);
            case 6:
                return m2043a(this.f1365s.mo5227c(), 1.0f, 0.0f);
            default:
                if (transitionStyle == 0 && this.f1365s.mo233i()) {
                    transitionStyle = this.f1365s.mo232h();
                }
                return transitionStyle == 0 ? null : null;
        }
    }

    /* renamed from: k */
    public void mo4970k(Fragment f) {
        if (f.mDeferStart) {
            if (this.f1354h) {
                this.f1344B = true;
                return;
            }
            f.mDeferStart = false;
            mo4917a(f, this.f1364r, 0, 0, false);
        }
    }

    /* renamed from: b */
    private static void m2060b(View v, C0412c anim) {
        if (!(v == null || anim == null || !m2057a(v, anim))) {
            Animator animator = anim.f1376b;
            if (animator != null) {
                animator.addListener(new C0413d(v));
            } else {
                AnimationListener originalListener = m2045a(anim.f1375a);
                v.setLayerType(2, null);
                anim.f1375a.setAnimationListener(new C0410a(v, originalListener));
            }
        }
    }

    /* renamed from: a */
    private static AnimationListener m2045a(Animation animation) {
        String str = "FragmentManager";
        try {
            if (f1338b == null) {
                f1338b = Animation.class.getDeclaredField("mListener");
                f1338b.setAccessible(true);
            }
            return (AnimationListener) f1338b.get(animation);
        } catch (NoSuchFieldException e) {
            Log.e(str, "No field with the name mListener is found in Animation class", e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.e(str, "Cannot access Animation's mListener field", e2);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo4952d(int state) {
        return this.f1364r >= state;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0073, code lost:
        if (r1 != 4) goto L_0x02e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02c7  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4917a(android.support.p000v4.app.Fragment r18, int r19, int r20, int r21, boolean r22) {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            boolean r0 = r8.mAdded
            r9 = 1
            if (r0 == 0) goto L_0x0011
            boolean r0 = r8.mDetached
            if (r0 == 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0 = r19
            goto L_0x0016
        L_0x0011:
            r0 = r19
            if (r0 <= r9) goto L_0x0016
            r0 = 1
        L_0x0016:
            boolean r1 = r8.mRemoving
            if (r1 == 0) goto L_0x002a
            int r1 = r8.mState
            if (r0 <= r1) goto L_0x002a
            if (r1 != 0) goto L_0x0028
            boolean r1 = r18.isInBackStack()
            if (r1 == 0) goto L_0x0028
            r0 = 1
            goto L_0x002a
        L_0x0028:
            int r0 = r8.mState
        L_0x002a:
            boolean r1 = r8.mDeferStart
            r10 = 4
            r11 = 3
            if (r1 == 0) goto L_0x0037
            int r1 = r8.mState
            if (r1 >= r10) goto L_0x0037
            if (r0 <= r11) goto L_0x0037
            r0 = 3
        L_0x0037:
            int r1 = r8.mState
            r12 = 2
            java.lang.String r13 = "FragmentManager"
            r14 = 0
            r15 = 0
            if (r1 > r0) goto L_0x02ef
            boolean r1 = r8.mFromLayout
            if (r1 == 0) goto L_0x0049
            boolean r1 = r8.mInLayout
            if (r1 != 0) goto L_0x0049
            return
        L_0x0049:
            android.view.View r1 = r18.getAnimatingAway()
            if (r1 != 0) goto L_0x0055
            android.animation.Animator r1 = r18.getAnimator()
            if (r1 == 0) goto L_0x0069
        L_0x0055:
            r8.setAnimatingAway(r14)
            r8.setAnimator(r14)
            int r3 = r18.getStateAfterAnimating()
            r4 = 0
            r5 = 0
            r6 = 1
            r1 = r17
            r2 = r18
            r1.mo4917a(r2, r3, r4, r5, r6)
        L_0x0069:
            int r1 = r8.mState
            if (r1 == 0) goto L_0x0077
            if (r1 == r9) goto L_0x01a9
            if (r1 == r12) goto L_0x02a0
            if (r1 == r11) goto L_0x02a4
            if (r1 == r10) goto L_0x02c4
            goto L_0x02e9
        L_0x0077:
            if (r0 <= 0) goto L_0x01a9
            boolean r1 = f1337a
            if (r1 == 0) goto L_0x0091
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto CREATED: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r13, r1)
        L_0x0091:
            android.os.Bundle r1 = r8.mSavedFragmentState
            if (r1 == 0) goto L_0x00e4
            android.support.v4.app.s r2 = r7.f1365s
            android.content.Context r2 = r2.mo5227c()
            java.lang.ClassLoader r2 = r2.getClassLoader()
            r1.setClassLoader(r2)
            android.os.Bundle r1 = r8.mSavedFragmentState
            java.lang.String r2 = "android:view_state"
            android.util.SparseArray r1 = r1.getSparseParcelableArray(r2)
            r8.mSavedViewState = r1
            android.os.Bundle r1 = r8.mSavedFragmentState
            java.lang.String r2 = "android:target_state"
            android.support.v4.app.Fragment r1 = r7.mo4907a(r1, r2)
            r8.mTarget = r1
            android.support.v4.app.Fragment r1 = r8.mTarget
            if (r1 == 0) goto L_0x00c4
            android.os.Bundle r1 = r8.mSavedFragmentState
            java.lang.String r2 = "android:target_req_state"
            int r1 = r1.getInt(r2, r15)
            r8.mTargetRequestCode = r1
        L_0x00c4:
            java.lang.Boolean r1 = r8.mSavedUserVisibleHint
            if (r1 == 0) goto L_0x00d1
            boolean r1 = r1.booleanValue()
            r8.mUserVisibleHint = r1
            r8.mSavedUserVisibleHint = r14
            goto L_0x00db
        L_0x00d1:
            android.os.Bundle r1 = r8.mSavedFragmentState
            java.lang.String r2 = "android:user_visible_hint"
            boolean r1 = r1.getBoolean(r2, r9)
            r8.mUserVisibleHint = r1
        L_0x00db:
            boolean r1 = r8.mUserVisibleHint
            if (r1 != 0) goto L_0x00e4
            r8.mDeferStart = r9
            if (r0 <= r11) goto L_0x00e4
            r0 = 3
        L_0x00e4:
            android.support.v4.app.s r1 = r7.f1365s
            r8.mHost = r1
            android.support.v4.app.Fragment r2 = r7.f1367u
            r8.mParentFragment = r2
            if (r2 == 0) goto L_0x00f1
            android.support.v4.app.A r1 = r2.mChildFragmentManager
            goto L_0x00f5
        L_0x00f1:
            android.support.v4.app.A r1 = r1.mo5228d()
        L_0x00f5:
            r8.mFragmentManager = r1
            android.support.v4.app.Fragment r1 = r8.mTarget
            java.lang.String r6 = "Fragment "
            if (r1 == 0) goto L_0x0142
            android.util.SparseArray<android.support.v4.app.Fragment> r2 = r7.f1357k
            int r1 = r1.mIndex
            java.lang.Object r1 = r2.get(r1)
            android.support.v4.app.Fragment r2 = r8.mTarget
            if (r1 != r2) goto L_0x011d
            int r1 = r2.mState
            if (r1 >= r9) goto L_0x011b
            r3 = 1
            r4 = 0
            r5 = 0
            r16 = 1
            r1 = r17
            r10 = r6
            r6 = r16
            r1.mo4917a(r2, r3, r4, r5, r6)
            goto L_0x0143
        L_0x011b:
            r10 = r6
            goto L_0x0143
        L_0x011d:
            r10 = r6
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            r2.append(r8)
            java.lang.String r3 = " declared target fragment "
            r2.append(r3)
            android.support.v4.app.Fragment r3 = r8.mTarget
            r2.append(r3)
            java.lang.String r3 = " that does not belong to this FragmentManager!"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0142:
            r10 = r6
        L_0x0143:
            android.support.v4.app.s r1 = r7.f1365s
            android.content.Context r1 = r1.mo5227c()
            r7.mo4936b(r8, r1, r15)
            r8.mCalled = r15
            android.support.v4.app.s r1 = r7.f1365s
            android.content.Context r1 = r1.mo5227c()
            r8.onAttach(r1)
            boolean r1 = r8.mCalled
            if (r1 == 0) goto L_0x018f
            android.support.v4.app.Fragment r1 = r8.mParentFragment
            if (r1 != 0) goto L_0x0165
            android.support.v4.app.s r1 = r7.f1365s
            r1.mo222a(r8)
            goto L_0x0168
        L_0x0165:
            r1.onAttachFragment(r8)
        L_0x0168:
            android.support.v4.app.s r1 = r7.f1365s
            android.content.Context r1 = r1.mo5227c()
            r7.mo4918a(r8, r1, r15)
            boolean r1 = r8.mIsCreated
            if (r1 != 0) goto L_0x0185
            android.os.Bundle r1 = r8.mSavedFragmentState
            r7.mo4946c(r8, r1, r15)
            android.os.Bundle r1 = r8.mSavedFragmentState
            r8.performCreate(r1)
            android.os.Bundle r1 = r8.mSavedFragmentState
            r7.mo4937b(r8, r1, r15)
            goto L_0x018c
        L_0x0185:
            android.os.Bundle r1 = r8.mSavedFragmentState
            r8.restoreChildFragmentState(r1)
            r8.mState = r9
        L_0x018c:
            r8.mRetaining = r15
            goto L_0x01a9
        L_0x018f:
            android.support.v4.app.ga r1 = new android.support.v4.app.ga
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            r2.append(r8)
            java.lang.String r3 = " did not call through to super.onAttach()"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01a9:
            r17.mo4953e(r18)
            if (r0 <= r9) goto L_0x02a0
            boolean r1 = f1337a
            if (r1 == 0) goto L_0x01c6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto ACTIVITY_CREATED: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r13, r1)
        L_0x01c6:
            boolean r1 = r8.mFromLayout
            if (r1 != 0) goto L_0x028b
            r1 = 0
            int r2 = r8.mContainerId
            if (r2 == 0) goto L_0x023f
            r3 = -1
            if (r2 == r3) goto L_0x0220
            android.support.v4.app.q r3 = r7.f1366t
            android.view.View r2 = r3.mo221a(r2)
            r1 = r2
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            if (r1 != 0) goto L_0x023f
            boolean r2 = r8.mRestored
            if (r2 == 0) goto L_0x01e2
            goto L_0x023f
        L_0x01e2:
            android.content.res.Resources r0 = r18.getResources()     // Catch:{ NotFoundException -> 0x01ed }
            int r1 = r8.mContainerId     // Catch:{ NotFoundException -> 0x01ed }
            java.lang.String r0 = r0.getResourceName(r1)     // Catch:{ NotFoundException -> 0x01ed }
            goto L_0x01f0
        L_0x01ed:
            r0 = move-exception
            java.lang.String r0 = "unknown"
        L_0x01f0:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "No view found for id 0x"
            r2.append(r3)
            int r3 = r8.mContainerId
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r3 = " ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") for fragment "
            r2.append(r0)
            r2.append(r8)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            r7.m2052a(r1)
            throw r14
        L_0x0220:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r7.m2052a(r0)
            throw r14
        L_0x023f:
            r8.mContainer = r1
            android.os.Bundle r2 = r8.mSavedFragmentState
            android.view.LayoutInflater r2 = r8.performGetLayoutInflater(r2)
            android.os.Bundle r3 = r8.mSavedFragmentState
            android.view.View r2 = r8.performCreateView(r2, r1, r3)
            r8.mView = r2
            android.view.View r2 = r8.mView
            if (r2 == 0) goto L_0x0289
            r8.mInnerView = r2
            r2.setSaveFromParentEnabled(r15)
            if (r1 == 0) goto L_0x025f
            android.view.View r2 = r8.mView
            r1.addView(r2)
        L_0x025f:
            boolean r2 = r8.mHidden
            if (r2 == 0) goto L_0x026a
            android.view.View r2 = r8.mView
            r3 = 8
            r2.setVisibility(r3)
        L_0x026a:
            android.view.View r2 = r8.mView
            android.os.Bundle r3 = r8.mSavedFragmentState
            r8.onViewCreated(r2, r3)
            android.view.View r2 = r8.mView
            android.os.Bundle r3 = r8.mSavedFragmentState
            r7.mo4920a(r8, r2, r3, r15)
            android.view.View r2 = r8.mView
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x0285
            android.view.ViewGroup r2 = r8.mContainer
            if (r2 == 0) goto L_0x0285
            goto L_0x0286
        L_0x0285:
            r9 = 0
        L_0x0286:
            r8.mIsNewlyAdded = r9
            goto L_0x028b
        L_0x0289:
            r8.mInnerView = r14
        L_0x028b:
            android.os.Bundle r1 = r8.mSavedFragmentState
            r8.performActivityCreated(r1)
            android.os.Bundle r1 = r8.mSavedFragmentState
            r7.mo4919a(r8, r1, r15)
            android.view.View r1 = r8.mView
            if (r1 == 0) goto L_0x029e
            android.os.Bundle r1 = r8.mSavedFragmentState
            r8.restoreViewState(r1)
        L_0x029e:
            r8.mSavedFragmentState = r14
        L_0x02a0:
            if (r0 <= r12) goto L_0x02a4
            r8.mState = r11
        L_0x02a4:
            if (r0 <= r11) goto L_0x02c4
            boolean r1 = f1337a
            if (r1 == 0) goto L_0x02be
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto STARTED: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r13, r1)
        L_0x02be:
            r18.performStart()
            r7.mo4958f(r8, r15)
        L_0x02c4:
            r1 = 4
            if (r0 <= r1) goto L_0x02e9
            boolean r1 = f1337a
            if (r1 == 0) goto L_0x02df
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto RESUMED: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r13, r1)
        L_0x02df:
            r18.performResume()
            r7.mo4954e(r8, r15)
            r8.mSavedFragmentState = r14
            r8.mSavedViewState = r14
        L_0x02e9:
            r2 = r20
            r4 = r21
            goto L_0x046d
        L_0x02ef:
            if (r1 <= r0) goto L_0x0469
            if (r1 == r9) goto L_0x03ef
            if (r1 == r12) goto L_0x0361
            if (r1 == r11) goto L_0x0344
            r2 = 4
            if (r1 == r2) goto L_0x0323
            r2 = 5
            if (r1 == r2) goto L_0x0303
            r2 = r20
            r4 = r21
            goto L_0x046d
        L_0x0303:
            if (r0 >= r2) goto L_0x0323
            boolean r1 = f1337a
            if (r1 == 0) goto L_0x031d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom RESUMED: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r13, r1)
        L_0x031d:
            r18.performPause()
            r7.mo4951d(r8, r15)
        L_0x0323:
            r1 = 4
            if (r0 >= r1) goto L_0x0344
            boolean r1 = f1337a
            if (r1 == 0) goto L_0x033e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom STARTED: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r13, r1)
        L_0x033e:
            r18.performStop()
            r7.mo4960g(r8, r15)
        L_0x0344:
            if (r0 >= r11) goto L_0x0361
            boolean r1 = f1337a
            if (r1 == 0) goto L_0x035e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom STOPPED: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r13, r1)
        L_0x035e:
            r18.performReallyStop()
        L_0x0361:
            if (r0 >= r12) goto L_0x03ea
            boolean r1 = f1337a
            if (r1 == 0) goto L_0x037b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom ACTIVITY_CREATED: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r13, r1)
        L_0x037b:
            android.view.View r1 = r8.mView
            if (r1 == 0) goto L_0x038e
            android.support.v4.app.s r1 = r7.f1365s
            boolean r1 = r1.mo229b(r8)
            if (r1 == 0) goto L_0x038e
            android.util.SparseArray<android.os.Parcelable> r1 = r8.mSavedViewState
            if (r1 != 0) goto L_0x038e
            r17.mo4976n(r18)
        L_0x038e:
            r18.performDestroyView()
            r7.mo4964h(r8, r15)
            android.view.View r1 = r8.mView
            if (r1 == 0) goto L_0x03dd
            android.view.ViewGroup r2 = r8.mContainer
            if (r2 == 0) goto L_0x03dd
            r2.endViewTransition(r1)
            android.view.View r1 = r8.mView
            r1.clearAnimation()
            r1 = 0
            int r2 = r7.f1364r
            r3 = 0
            if (r2 <= 0) goto L_0x03ca
            boolean r2 = r7.f1372z
            if (r2 != 0) goto L_0x03ca
            android.view.View r2 = r8.mView
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x03c5
            float r2 = r8.mPostponedAlpha
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x03c5
            r2 = r20
            r4 = r21
            android.support.v4.app.A$c r1 = r7.mo4904a(r8, r2, r15, r4)
            goto L_0x03ce
        L_0x03c5:
            r2 = r20
            r4 = r21
            goto L_0x03ce
        L_0x03ca:
            r2 = r20
            r4 = r21
        L_0x03ce:
            r8.mPostponedAlpha = r3
            if (r1 == 0) goto L_0x03d5
            r7.m2049a(r8, r1, r0)
        L_0x03d5:
            android.view.ViewGroup r3 = r8.mContainer
            android.view.View r5 = r8.mView
            r3.removeView(r5)
            goto L_0x03e1
        L_0x03dd:
            r2 = r20
            r4 = r21
        L_0x03e1:
            r8.mContainer = r14
            r8.mView = r14
            r8.mInnerView = r14
            r8.mInLayout = r15
            goto L_0x03f3
        L_0x03ea:
            r2 = r20
            r4 = r21
            goto L_0x03f3
        L_0x03ef:
            r2 = r20
            r4 = r21
        L_0x03f3:
            if (r0 >= r9) goto L_0x046d
            boolean r1 = r7.f1372z
            if (r1 == 0) goto L_0x041b
            android.view.View r1 = r18.getAnimatingAway()
            if (r1 == 0) goto L_0x040a
            android.view.View r1 = r18.getAnimatingAway()
            r8.setAnimatingAway(r14)
            r1.clearAnimation()
            goto L_0x041b
        L_0x040a:
            android.animation.Animator r1 = r18.getAnimator()
            if (r1 == 0) goto L_0x041b
            android.animation.Animator r1 = r18.getAnimator()
            r8.setAnimator(r14)
            r1.cancel()
        L_0x041b:
            android.view.View r1 = r18.getAnimatingAway()
            if (r1 != 0) goto L_0x0464
            android.animation.Animator r1 = r18.getAnimator()
            if (r1 == 0) goto L_0x0428
            goto L_0x0464
        L_0x0428:
            boolean r1 = f1337a
            if (r1 == 0) goto L_0x0440
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "movefrom CREATED: "
            r1.append(r3)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r13, r1)
        L_0x0440:
            boolean r1 = r8.mRetaining
            if (r1 != 0) goto L_0x044b
            r18.performDestroy()
            r7.mo4938b(r8, r15)
            goto L_0x044d
        L_0x044b:
            r8.mState = r15
        L_0x044d:
            r18.performDetach()
            r7.mo4947c(r8, r15)
            if (r22 != 0) goto L_0x046d
            boolean r1 = r8.mRetaining
            if (r1 != 0) goto L_0x045d
            r17.mo4963h(r18)
            goto L_0x046d
        L_0x045d:
            r8.mHost = r14
            r8.mParentFragment = r14
            r8.mFragmentManager = r14
            goto L_0x046d
        L_0x0464:
            r8.setStateAfterAnimating(r0)
            r0 = 1
            goto L_0x046d
        L_0x0469:
            r2 = r20
            r4 = r21
        L_0x046d:
            int r1 = r8.mState
            if (r1 == r0) goto L_0x049e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "moveToState: Fragment state for "
            r1.append(r3)
            r1.append(r8)
            java.lang.String r3 = " not updated inline; "
            r1.append(r3)
            java.lang.String r3 = "expected state "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r3 = " found "
            r1.append(r3)
            int r3 = r8.mState
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r13, r1)
            r8.mState = r0
        L_0x049e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.C0409A.mo4917a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    /* renamed from: a */
    private void m2049a(Fragment fragment, C0412c anim, int newState) {
        View viewToAnimate = fragment.mView;
        ViewGroup container = fragment.mContainer;
        container.startViewTransition(viewToAnimate);
        fragment.setStateAfterAnimating(newState);
        Animation animation = anim.f1375a;
        if (animation != null) {
            Animation animation2 = new C0414e(animation, container, viewToAnimate);
            fragment.setAnimatingAway(fragment.mView);
            animation2.setAnimationListener(new C0492w(this, m2045a(animation2), container, fragment));
            m2060b(viewToAnimate, anim);
            fragment.mView.startAnimation(animation2);
            return;
        }
        Animator animator = anim.f1376b;
        fragment.setAnimator(anim.f1376b);
        animator.addListener(new C0493x(this, container, viewToAnimate, fragment));
        animator.setTarget(fragment.mView);
        m2060b(fragment.mView, anim);
        animator.start();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo4968j(Fragment f) {
        mo4917a(f, this.f1364r, 0, 0, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo4953e(Fragment f) {
        if (f.mFromLayout && !f.mPerformedCreateView) {
            f.mView = f.performCreateView(f.performGetLayoutInflater(f.mSavedFragmentState), null, f.mSavedFragmentState);
            View view = f.mView;
            if (view != null) {
                f.mInnerView = view;
                view.setSaveFromParentEnabled(false);
                if (f.mHidden) {
                    f.mView.setVisibility(8);
                }
                f.onViewCreated(f.mView, f.mSavedFragmentState);
                mo4920a(f, f.mView, f.mSavedFragmentState, false);
                return;
            }
            f.mInnerView = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4945c(Fragment fragment) {
        if (fragment.mView != null) {
            C0412c anim = mo4904a(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (anim != null) {
                Animator animator = anim.f1376b;
                if (animator != null) {
                    animator.setTarget(fragment.mView);
                    if (!fragment.mHidden) {
                        fragment.mView.setVisibility(0);
                    } else if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    } else {
                        ViewGroup container = fragment.mContainer;
                        View animatingView = fragment.mView;
                        container.startViewTransition(animatingView);
                        anim.f1376b.addListener(new C0494y(this, container, animatingView, fragment));
                    }
                    m2060b(fragment.mView, anim);
                    anim.f1376b.start();
                }
            }
            if (anim != null) {
                m2060b(fragment.mView, anim);
                fragment.mView.startAnimation(anim.f1375a);
                anim.f1375a.start();
            }
            fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
            if (fragment.isHideReplaced()) {
                fragment.setHideReplaced(false);
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.f1369w = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo4966i(Fragment f) {
        if (f != null) {
            int nextState = this.f1364r;
            if (f.mRemoving) {
                if (f.isInBackStack()) {
                    nextState = Math.min(nextState, 1);
                } else {
                    nextState = Math.min(nextState, 0);
                }
            }
            mo4917a(f, nextState, f.getNextTransition(), f.getNextTransitionStyle(), false);
            if (f.mView != null) {
                Fragment underFragment = m2068q(f);
                if (underFragment != null) {
                    View underView = underFragment.mView;
                    ViewGroup container = f.mContainer;
                    int underIndex = container.indexOfChild(underView);
                    int viewIndex = container.indexOfChild(f.mView);
                    if (viewIndex < underIndex) {
                        container.removeViewAt(viewIndex);
                        container.addView(f.mView, underIndex);
                    }
                }
                if (f.mIsNewlyAdded && f.mContainer != null) {
                    float f2 = f.mPostponedAlpha;
                    if (f2 > 0.0f) {
                        f.mView.setAlpha(f2);
                    }
                    f.mPostponedAlpha = 0.0f;
                    f.mIsNewlyAdded = false;
                    C0412c anim = mo4904a(f, f.getNextTransition(), true, f.getNextTransitionStyle());
                    if (anim != null) {
                        m2060b(f.mView, anim);
                        Animation animation = anim.f1375a;
                        if (animation != null) {
                            f.mView.startAnimation(animation);
                        } else {
                            anim.f1376b.setTarget(f.mView);
                            anim.f1376b.start();
                        }
                    }
                }
            }
            if (f.mHiddenChanged) {
                mo4945c(f);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4912a(int newState, boolean always) {
        if (this.f1365s == null && newState != 0) {
            throw new IllegalStateException("No activity");
        } else if (always || newState != this.f1364r) {
            this.f1364r = newState;
            if (this.f1357k != null) {
                int numAdded = this.f1356j.size();
                for (int i = 0; i < numAdded; i++) {
                    mo4966i((Fragment) this.f1356j.get(i));
                }
                int numActive = this.f1357k.size();
                for (int i2 = 0; i2 < numActive; i2++) {
                    Fragment f = (Fragment) this.f1357k.valueAt(i2);
                    if (f != null && ((f.mRemoving || f.mDetached) && !f.mIsNewlyAdded)) {
                        mo4966i(f);
                    }
                }
                mo4903A();
                if (this.f1369w) {
                    C0485s sVar = this.f1365s;
                    if (sVar != null && this.f1364r == 5) {
                        sVar.mo234j();
                        this.f1369w = false;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: A */
    public void mo4903A() {
        if (this.f1357k != null) {
            for (int i = 0; i < this.f1357k.size(); i++) {
                Fragment f = (Fragment) this.f1357k.valueAt(i);
                if (f != null) {
                    mo4970k(f);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo4959g(Fragment f) {
        if (f.mIndex < 0) {
            int i = this.f1355i;
            this.f1355i = i + 1;
            f.setIndex(i, this.f1367u);
            if (this.f1357k == null) {
                this.f1357k = new SparseArray<>();
            }
            this.f1357k.put(f.mIndex, f);
            if (f1337a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Allocated fragment index ");
                sb.append(f);
                Log.v("FragmentManager", sb.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo4963h(Fragment f) {
        if (f.mIndex >= 0) {
            if (f1337a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Freeing fragment index ");
                sb.append(f);
                Log.v("FragmentManager", sb.toString());
            }
            this.f1357k.put(f.mIndex, null);
            f.initState();
        }
    }

    /* renamed from: a */
    public void mo4921a(Fragment fragment, boolean moveToStateNow) {
        if (f1337a) {
            StringBuilder sb = new StringBuilder();
            sb.append("add: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        mo4959g(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (!this.f1356j.contains(fragment)) {
            synchronized (this.f1356j) {
                this.f1356j.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f1369w = true;
            }
            if (moveToStateNow) {
                mo4968j(fragment);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Fragment already added: ");
        sb2.append(fragment);
        throw new IllegalStateException(sb2.toString());
    }

    /* renamed from: l */
    public void mo4972l(Fragment fragment) {
        if (f1337a) {
            StringBuilder sb = new StringBuilder();
            sb.append("remove: ");
            sb.append(fragment);
            sb.append(" nesting=");
            sb.append(fragment.mBackStackNesting);
            Log.v("FragmentManager", sb.toString());
        }
        boolean inactive = !fragment.isInBackStack();
        if (!fragment.mDetached || inactive) {
            synchronized (this.f1356j) {
                this.f1356j.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f1369w = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    /* renamed from: f */
    public void mo4957f(Fragment fragment) {
        if (f1337a) {
            StringBuilder sb = new StringBuilder();
            sb.append("hide: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        }
    }

    /* renamed from: p */
    public void mo4982p(Fragment fragment) {
        if (f1337a) {
            StringBuilder sb = new StringBuilder();
            sb.append("show: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* renamed from: d */
    public void mo4949d(Fragment fragment) {
        if (f1337a) {
            StringBuilder sb = new StringBuilder();
            sb.append("detach: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (f1337a) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("remove from detach: ");
                    sb2.append(fragment);
                    Log.v("FragmentManager", sb2.toString());
                }
                synchronized (this.f1356j) {
                    this.f1356j.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f1369w = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    /* renamed from: b */
    public void mo4935b(Fragment fragment) {
        if (f1337a) {
            StringBuilder sb = new StringBuilder();
            sb.append("attach: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (!this.f1356j.contains(fragment)) {
                if (f1337a) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("add from attach: ");
                    sb2.append(fragment);
                    Log.v("FragmentManager", sb2.toString());
                }
                synchronized (this.f1356j) {
                    this.f1356j.add(fragment);
                }
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f1369w = true;
                    return;
                }
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Fragment already added: ");
            sb3.append(fragment);
            throw new IllegalStateException(sb3.toString());
        }
    }

    /* renamed from: a */
    public Fragment mo4906a(int id) {
        for (int i = this.f1356j.size() - 1; i >= 0; i--) {
            Fragment f = (Fragment) this.f1356j.get(i);
            if (f != null && f.mFragmentId == id) {
                return f;
            }
        }
        SparseArray<Fragment> sparseArray = this.f1357k;
        if (sparseArray != null) {
            for (int i2 = sparseArray.size() - 1; i2 >= 0; i2--) {
                Fragment f2 = (Fragment) this.f1357k.valueAt(i2);
                if (f2 != null && f2.mFragmentId == id) {
                    return f2;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public Fragment mo4908a(String tag) {
        if (tag != null) {
            for (int i = this.f1356j.size() - 1; i >= 0; i--) {
                Fragment f = (Fragment) this.f1356j.get(i);
                if (f != null && tag.equals(f.mTag)) {
                    return f;
                }
            }
        }
        SparseArray<Fragment> sparseArray = this.f1357k;
        if (!(sparseArray == null || tag == null)) {
            for (int i2 = sparseArray.size() - 1; i2 >= 0; i2--) {
                Fragment f2 = (Fragment) this.f1357k.valueAt(i2);
                if (f2 != null && tag.equals(f2.mTag)) {
                    return f2;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public Fragment mo4932b(String who) {
        SparseArray<Fragment> sparseArray = this.f1357k;
        if (!(sparseArray == null || who == null)) {
            for (int i = sparseArray.size() - 1; i >= 0; i--) {
                Fragment f = (Fragment) this.f1357k.valueAt(i);
                if (f != null) {
                    Fragment findFragmentByWho = f.findFragmentByWho(who);
                    Fragment f2 = findFragmentByWho;
                    if (findFragmentByWho != null) {
                        return f2;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: C */
    private void m2037C() {
        if (mo4955e()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f1343A != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can not perform this action inside of ");
            sb.append(this.f1343A);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: e */
    public boolean mo4955e() {
        return this.f1370x || this.f1371y;
    }

    /* renamed from: a */
    public void mo4916a(C0416g action, boolean allowStateLoss) {
        if (!allowStateLoss) {
            m2037C();
        }
        synchronized (this) {
            if (!this.f1372z) {
                if (this.f1365s != null) {
                    if (this.f1353g == null) {
                        this.f1353g = new ArrayList<>();
                    }
                    this.f1353g.add(action);
                    m2041G();
                    return;
                }
            }
            if (!allowStateLoss) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m2041G() {
        synchronized (this) {
            boolean pendingReady = false;
            boolean postponeReady = this.f1350H != null && !this.f1350H.isEmpty();
            if (this.f1353g != null && this.f1353g.size() == 1) {
                pendingReady = true;
            }
            if (postponeReady || pendingReady) {
                this.f1365s.mo5229e().removeCallbacks(this.f1352J);
                this.f1365s.mo5229e().post(this.f1352J);
            }
        }
    }

    /* renamed from: b */
    public int mo4931b(C0467f bse) {
        synchronized (this) {
            if (this.f1361o != null) {
                if (this.f1361o.size() > 0) {
                    int index = ((Integer) this.f1361o.remove(this.f1361o.size() - 1)).intValue();
                    if (f1337a) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Adding back stack index ");
                        sb.append(index);
                        sb.append(" with ");
                        sb.append(bse);
                        Log.v("FragmentManager", sb.toString());
                    }
                    this.f1360n.set(index, bse);
                    return index;
                }
            }
            if (this.f1360n == null) {
                this.f1360n = new ArrayList<>();
            }
            int index2 = this.f1360n.size();
            if (f1337a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting back stack index ");
                sb2.append(index2);
                sb2.append(" to ");
                sb2.append(bse);
                Log.v("FragmentManager", sb2.toString());
            }
            this.f1360n.add(bse);
            return index2;
        }
    }

    /* renamed from: a */
    public void mo4911a(int index, C0467f bse) {
        synchronized (this) {
            if (this.f1360n == null) {
                this.f1360n = new ArrayList<>();
            }
            int N = this.f1360n.size();
            if (index < N) {
                if (f1337a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Setting back stack index ");
                    sb.append(index);
                    sb.append(" to ");
                    sb.append(bse);
                    Log.v("FragmentManager", sb.toString());
                }
                this.f1360n.set(index, bse);
            } else {
                while (N < index) {
                    this.f1360n.add(null);
                    if (this.f1361o == null) {
                        this.f1361o = new ArrayList<>();
                    }
                    if (f1337a) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Adding available back stack index ");
                        sb2.append(N);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    this.f1361o.add(Integer.valueOf(N));
                    N++;
                }
                if (f1337a) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Adding back stack index ");
                    sb3.append(index);
                    sb3.append(" with ");
                    sb3.append(bse);
                    Log.v("FragmentManager", sb3.toString());
                }
                this.f1360n.add(bse);
            }
        }
    }

    /* renamed from: c */
    public void mo4944c(int index) {
        synchronized (this) {
            this.f1360n.set(index, null);
            if (this.f1361o == null) {
                this.f1361o = new ArrayList<>();
            }
            if (f1337a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Freeing back stack index ");
                sb.append(index);
                Log.v("FragmentManager", sb.toString());
            }
            this.f1361o.add(Integer.valueOf(index));
        }
    }

    /* renamed from: c */
    private void m2065c(boolean allowStateLoss) {
        if (this.f1354h) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f1365s == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.f1365s.mo5229e().getLooper()) {
            if (!allowStateLoss) {
                m2037C();
            }
            if (this.f1345C == null) {
                this.f1345C = new ArrayList<>();
                this.f1346D = new ArrayList<>();
            }
            this.f1354h = true;
            try {
                m2053a(null, null);
            } finally {
                this.f1354h = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* renamed from: b */
    public void mo4934b(C0416g action, boolean allowStateLoss) {
        if (!allowStateLoss || (this.f1365s != null && !this.f1372z)) {
            m2065c(allowStateLoss);
            if (action.mo5002a(this.f1345C, this.f1346D)) {
                this.f1354h = true;
                try {
                    m2064c(this.f1345C, this.f1346D);
                } finally {
                    m2038D();
                }
            }
            mo4984r();
            m2036B();
        }
    }

    /* renamed from: D */
    private void m2038D() {
        this.f1354h = false;
        this.f1346D.clear();
        this.f1345C.clear();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: s */
    public boolean mo4985s() {
        m2065c(true);
        boolean didSomething = false;
        while (m2063b(this.f1345C, this.f1346D)) {
            this.f1354h = true;
            try {
                m2064c(this.f1345C, this.f1346D);
                m2038D();
                didSomething = true;
            } catch (Throwable th) {
                m2038D();
                throw th;
            }
        }
        mo4984r();
        m2036B();
        return didSomething;
    }

    /* renamed from: a */
    private void m2053a(ArrayList<C0467f> records, ArrayList<Boolean> isRecordPop) {
        ArrayList<C0418i> arrayList = this.f1350H;
        int numPostponed = arrayList == null ? 0 : arrayList.size();
        int i = 0;
        while (i < numPostponed) {
            C0418i listener = (C0418i) this.f1350H.get(i);
            if (records != null && !listener.f1387a) {
                int index = records.indexOf(listener.f1388b);
                if (index != -1 && ((Boolean) isRecordPop.get(index)).booleanValue()) {
                    listener.mo5003c();
                    i++;
                }
            }
            if (listener.mo5005e() != 0 || (records != null && listener.f1388b.mo5153a(records, 0, records.size()))) {
                this.f1350H.remove(i);
                i--;
                numPostponed--;
                if (records != null && !listener.f1387a) {
                    int indexOf = records.indexOf(listener.f1388b);
                    int index2 = indexOf;
                    if (indexOf != -1 && ((Boolean) isRecordPop.get(index2)).booleanValue()) {
                        listener.mo5003c();
                    }
                }
                listener.mo5004d();
            }
            i++;
        }
    }

    /* renamed from: c */
    private void m2064c(ArrayList<C0467f> records, ArrayList<Boolean> isRecordPop) {
        if (records != null && !records.isEmpty()) {
            if (isRecordPop == null || records.size() != isRecordPop.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            m2053a(records, isRecordPop);
            int numRecords = records.size();
            int startIndex = 0;
            int recordNum = 0;
            while (recordNum < numRecords) {
                if (!((C0467f) records.get(recordNum)).f1594t) {
                    if (startIndex != recordNum) {
                        m2062b(records, isRecordPop, startIndex, recordNum);
                    }
                    int reorderingEnd = recordNum + 1;
                    if (((Boolean) isRecordPop.get(recordNum)).booleanValue()) {
                        while (reorderingEnd < numRecords && ((Boolean) isRecordPop.get(reorderingEnd)).booleanValue() && !((C0467f) records.get(reorderingEnd)).f1594t) {
                            reorderingEnd++;
                        }
                    }
                    m2062b(records, isRecordPop, recordNum, reorderingEnd);
                    startIndex = reorderingEnd;
                    recordNum = reorderingEnd - 1;
                }
                recordNum++;
            }
            if (startIndex != numRecords) {
                m2062b(records, isRecordPop, startIndex, numRecords);
            }
        }
    }

    /* renamed from: b */
    private void m2062b(ArrayList<C0467f> records, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex) {
        ArrayList<C0467f> arrayList = records;
        ArrayList<Boolean> arrayList2 = isRecordPop;
        int i = startIndex;
        int i2 = endIndex;
        boolean allowReordering = ((C0467f) arrayList.get(i)).f1594t;
        ArrayList<Fragment> arrayList3 = this.f1347E;
        if (arrayList3 == null) {
            this.f1347E = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.f1347E.addAll(this.f1356j);
        int recordNum = startIndex;
        boolean addToBackStack = false;
        Fragment oldPrimaryNav = mo4988u();
        while (true) {
            boolean z = true;
            if (recordNum >= i2) {
                break;
            }
            C0467f record = (C0467f) arrayList.get(recordNum);
            if (!((Boolean) arrayList2.get(recordNum)).booleanValue()) {
                oldPrimaryNav = record.mo5147a(this.f1347E, oldPrimaryNav);
            } else {
                oldPrimaryNav = record.mo5154b(this.f1347E, oldPrimaryNav);
            }
            if (!addToBackStack && !record.f1583i) {
                z = false;
            }
            addToBackStack = z;
            recordNum++;
        }
        this.f1347E.clear();
        if (!allowReordering) {
            C0429L.m2198a(this, records, isRecordPop, startIndex, endIndex, false);
        }
        m2054a(records, isRecordPop, startIndex, endIndex);
        int postponeIndex = endIndex;
        if (allowReordering) {
            C1255d dVar = new C1255d();
            m2051a(dVar);
            C1255d dVar2 = dVar;
            int postponeIndex2 = m2042a(records, isRecordPop, startIndex, endIndex, dVar);
            m2061b(dVar2);
            postponeIndex = postponeIndex2;
        }
        if (postponeIndex != i && allowReordering) {
            C0429L.m2198a(this, records, isRecordPop, startIndex, postponeIndex, true);
            mo4912a(this.f1364r, true);
        }
        for (int recordNum2 = startIndex; recordNum2 < i2; recordNum2++) {
            C0467f record2 = (C0467f) arrayList.get(recordNum2);
            if (((Boolean) arrayList2.get(recordNum2)).booleanValue()) {
                int i3 = record2.f1587m;
                if (i3 >= 0) {
                    mo4944c(i3);
                    record2.f1587m = -1;
                }
            }
            record2.mo5161h();
        }
        if (addToBackStack) {
            mo4990w();
        }
    }

    /* renamed from: b */
    private void m2061b(C1255d<Fragment> fragments) {
        int numAdded = fragments.size();
        for (int i = 0; i < numAdded; i++) {
            Fragment fragment = (Fragment) fragments.mo9039i(i);
            if (!fragment.mAdded) {
                View view = fragment.getView();
                fragment.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    /* renamed from: a */
    private int m2042a(ArrayList<C0467f> records, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex, C1255d<Fragment> added) {
        int postponeIndex = endIndex;
        for (int i = endIndex - 1; i >= startIndex; i--) {
            C0467f record = (C0467f) records.get(i);
            boolean isPop = ((Boolean) isRecordPop.get(i)).booleanValue();
            if (record.mo5159g() && !record.mo5153a(records, i + 1, endIndex)) {
                if (this.f1350H == null) {
                    this.f1350H = new ArrayList<>();
                }
                C0418i listener = new C0418i(record, isPop);
                this.f1350H.add(listener);
                record.mo5149a((C0006b) listener);
                if (isPop) {
                    record.mo5158f();
                } else {
                    record.mo5155b(false);
                }
                postponeIndex--;
                if (i != postponeIndex) {
                    records.remove(i);
                    records.add(postponeIndex, record);
                }
                m2051a(added);
            }
        }
        return postponeIndex;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2050a(C0467f record, boolean isPop, boolean runTransitions, boolean moveToState) {
        if (isPop) {
            record.mo5155b(moveToState);
        } else {
            record.mo5158f();
        }
        ArrayList<BackStackRecord> records = new ArrayList<>(1);
        ArrayList arrayList = new ArrayList(1);
        records.add(record);
        arrayList.add(Boolean.valueOf(isPop));
        if (runTransitions) {
            C0429L.m2198a(this, records, arrayList, 0, 1, true);
        }
        if (moveToState) {
            mo4912a(this.f1364r, true);
        }
        SparseArray<Fragment> sparseArray = this.f1357k;
        if (sparseArray != null) {
            int numActive = sparseArray.size();
            for (int i = 0; i < numActive; i++) {
                Fragment fragment = (Fragment) this.f1357k.valueAt(i);
                if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && record.mo5156b(fragment.mContainerId)) {
                    float f = fragment.mPostponedAlpha;
                    if (f > 0.0f) {
                        fragment.mView.setAlpha(f);
                    }
                    if (moveToState) {
                        fragment.mPostponedAlpha = 0.0f;
                    } else {
                        fragment.mPostponedAlpha = -1.0f;
                        fragment.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    /* renamed from: q */
    private Fragment m2068q(Fragment f) {
        ViewGroup container = f.mContainer;
        View view = f.mView;
        if (container == null || view == null) {
            return null;
        }
        for (int i = this.f1356j.indexOf(f) - 1; i >= 0; i--) {
            Fragment underFragment = (Fragment) this.f1356j.get(i);
            if (underFragment.mContainer == container && underFragment.mView != null) {
                return underFragment;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m2054a(ArrayList<C0467f> records, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            C0467f record = (C0467f) records.get(i);
            boolean moveToState = true;
            if (((Boolean) isRecordPop.get(i)).booleanValue()) {
                record.mo5148a(-1);
                if (i != endIndex - 1) {
                    moveToState = false;
                }
                record.mo5155b(moveToState);
            } else {
                record.mo5148a(1);
                record.mo5158f();
            }
        }
    }

    /* renamed from: a */
    private void m2051a(C1255d<Fragment> added) {
        int i = this.f1364r;
        if (i >= 1) {
            int state = Math.min(i, 4);
            int numAdded = this.f1356j.size();
            for (int i2 = 0; i2 < numAdded; i2++) {
                Fragment fragment = (Fragment) this.f1356j.get(i2);
                if (fragment.mState < state) {
                    mo4917a(fragment, state, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        added.add(fragment);
                    }
                }
            }
        }
    }

    /* renamed from: F */
    private void m2040F() {
        if (this.f1350H != null) {
            while (!this.f1350H.isEmpty()) {
                ((C0418i) this.f1350H.remove(0)).mo5004d();
            }
        }
    }

    /* renamed from: E */
    private void m2039E() {
        SparseArray<Fragment> sparseArray = this.f1357k;
        int numFragments = sparseArray == null ? 0 : sparseArray.size();
        for (int i = 0; i < numFragments; i++) {
            Fragment fragment = (Fragment) this.f1357k.valueAt(i);
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    View animatingAway = fragment.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragment.setAnimatingAway(null);
                    mo4917a(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m2063b(ArrayList<C0467f> records, ArrayList<Boolean> isPop) {
        boolean didSomething = false;
        synchronized (this) {
            if (this.f1353g != null) {
                if (this.f1353g.size() != 0) {
                    for (int i = 0; i < this.f1353g.size(); i++) {
                        didSomething |= ((C0416g) this.f1353g.get(i)).mo5002a(records, isPop);
                    }
                    this.f1353g.clear();
                    this.f1365s.mo5229e().removeCallbacks(this.f1352J);
                    return didSomething;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public void mo4984r() {
        if (this.f1344B) {
            this.f1344B = false;
            mo4903A();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: w */
    public void mo4990w() {
        if (this.f1362p != null) {
            for (int i = 0; i < this.f1362p.size(); i++) {
                ((C0489c) this.f1362p.get(i)).onBackStackChanged();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4922a(C0467f state) {
        if (this.f1358l == null) {
            this.f1358l = new ArrayList<>();
        }
        this.f1358l.add(state);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo4930a(ArrayList<C0467f> records, ArrayList<Boolean> isRecordPop, String name, int id, int flags) {
        ArrayList<C0467f> arrayList = this.f1358l;
        if (arrayList == null) {
            return false;
        }
        if (name == null && id < 0 && (flags & 1) == 0) {
            int last = arrayList.size() - 1;
            if (last < 0) {
                return false;
            }
            records.add(this.f1358l.remove(last));
            isRecordPop.add(Boolean.valueOf(true));
        } else {
            int index = -1;
            if (name != null || id >= 0) {
                int index2 = this.f1358l.size() - 1;
                while (index >= 0) {
                    C0467f bss = (C0467f) this.f1358l.get(index);
                    if ((name != null && name.equals(bss.getName())) || (id >= 0 && id == bss.f1587m)) {
                        break;
                    }
                    index2 = index - 1;
                }
                if (index < 0) {
                    return false;
                }
                if ((flags & 1) != 0) {
                    index--;
                    while (index >= 0) {
                        C0467f bss2 = (C0467f) this.f1358l.get(index);
                        if ((name == null || !name.equals(bss2.getName())) && (id < 0 || id != bss2.f1587m)) {
                            break;
                        }
                        index--;
                    }
                }
            }
            if (index == this.f1358l.size() - 1) {
                return false;
            }
            for (int i = this.f1358l.size() - 1; i > index; i--) {
                records.add(this.f1358l.remove(i));
                isRecordPop.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: x */
    public C0419B mo4991x() {
        m2048a(this.f1351I);
        return this.f1351I;
    }

    /* renamed from: a */
    private static void m2048a(C0419B nonConfig) {
        if (nonConfig != null) {
            List<Fragment> fragments = nonConfig.mo5007b();
            if (fragments != null) {
                for (Fragment fragment : fragments) {
                    fragment.mRetaining = true;
                }
            }
            List<FragmentManagerNonConfig> children = nonConfig.mo5006a();
            if (children != null) {
                Iterator it = children.iterator();
                while (it.hasNext()) {
                    m2048a((C0419B) it.next());
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: z */
    public void mo4993z() {
        C0419B child;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        if (this.f1357k != null) {
            for (int i = 0; i < this.f1357k.size(); i++) {
                Fragment f = (Fragment) this.f1357k.valueAt(i);
                if (f != null) {
                    if (f.mRetainInstance) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(f);
                        Fragment fragment = f.mTarget;
                        f.mTargetIndex = fragment != null ? fragment.mIndex : -1;
                        if (f1337a) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("retainNonConfig: keeping retained ");
                            sb.append(f);
                            Log.v("FragmentManager", sb.toString());
                        }
                    }
                    C0409A a = f.mChildFragmentManager;
                    if (a != null) {
                        a.mo4993z();
                        child = f.mChildFragmentManager.f1351I;
                    } else {
                        child = f.mChildNonConfig;
                    }
                    if (arrayList2 == null && child != null) {
                        arrayList2 = new ArrayList(this.f1357k.size());
                        for (int j = 0; j < i; j++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(child);
                    }
                    if (arrayList3 == null && f.mViewModelStore != null) {
                        arrayList3 = new ArrayList(this.f1357k.size());
                        for (int j2 = 0; j2 < i; j2++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(f.mViewModelStore);
                    }
                }
            }
        }
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            this.f1351I = null;
        } else {
            this.f1351I = new C0419B(arrayList, arrayList2, arrayList3);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public void mo4976n(Fragment f) {
        if (f.mInnerView != null) {
            SparseArray<Parcelable> sparseArray = this.f1349G;
            if (sparseArray == null) {
                this.f1349G = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            f.mInnerView.saveHierarchyState(this.f1349G);
            if (this.f1349G.size() > 0) {
                f.mSavedViewState = this.f1349G;
                this.f1349G = null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public Bundle mo4973m(Fragment f) {
        Bundle result = null;
        if (this.f1348F == null) {
            this.f1348F = new Bundle();
        }
        f.performSaveInstanceState(this.f1348F);
        mo4950d(f, this.f1348F, false);
        if (!this.f1348F.isEmpty()) {
            result = this.f1348F;
            this.f1348F = null;
        }
        if (f.mView != null) {
            mo4976n(f);
        }
        if (f.mSavedViewState != null) {
            if (result == null) {
                result = new Bundle();
            }
            result.putSparseParcelableArray("android:view_state", f.mSavedViewState);
        }
        if (!f.mUserVisibleHint) {
            if (result == null) {
                result = new Bundle();
            }
            result.putBoolean("android:user_visible_hint", f.mUserVisibleHint);
        }
        return result;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: y */
    public Parcelable mo4992y() {
        m2040F();
        m2039E();
        mo4985s();
        this.f1370x = true;
        this.f1351I = null;
        SparseArray<Fragment> sparseArray = this.f1357k;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        int N = this.f1357k.size();
        FragmentState[] active = new FragmentState[N];
        boolean haveFragments = false;
        int i = 0;
        while (true) {
            String str = " has cleared index: ";
            String str2 = "Failure saving state: active ";
            String str3 = ": ";
            String str4 = "FragmentManager";
            if (i < N) {
                Fragment f = (Fragment) this.f1357k.valueAt(i);
                if (f != null) {
                    if (f.mIndex >= 0) {
                        haveFragments = true;
                        FragmentState fs = new FragmentState(f);
                        active[i] = fs;
                        if (f.mState <= 0 || fs.f1420k != null) {
                            fs.f1420k = f.mSavedFragmentState;
                        } else {
                            fs.f1420k = mo4973m(f);
                            Fragment fragment = f.mTarget;
                            if (fragment != null) {
                                if (fragment.mIndex >= 0) {
                                    if (fs.f1420k == null) {
                                        fs.f1420k = new Bundle();
                                    }
                                    mo4914a(fs.f1420k, "android:target_state", f.mTarget);
                                    int i2 = f.mTargetRequestCode;
                                    if (i2 != 0) {
                                        fs.f1420k.putInt("android:target_req_state", i2);
                                    }
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Failure saving state: ");
                                    sb.append(f);
                                    sb.append(" has target not in fragment manager: ");
                                    sb.append(f.mTarget);
                                    m2052a((RuntimeException) new IllegalStateException(sb.toString()));
                                    throw null;
                                }
                            }
                        }
                        if (f1337a) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Saved state of ");
                            sb2.append(f);
                            sb2.append(str3);
                            sb2.append(fs.f1420k);
                            Log.v(str4, sb2.toString());
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(f);
                        sb3.append(str);
                        sb3.append(f.mIndex);
                        m2052a((RuntimeException) new IllegalStateException(sb3.toString()));
                        throw null;
                    }
                }
                i++;
            } else if (!haveFragments) {
                if (f1337a) {
                    Log.v(str4, "saveAllState: no fragments!");
                }
                return null;
            } else {
                int[] added = null;
                BackStackState[] backStack = null;
                int N2 = this.f1356j.size();
                if (N2 > 0) {
                    added = new int[N2];
                    int i3 = 0;
                    while (i3 < N2) {
                        added[i3] = ((Fragment) this.f1356j.get(i3)).mIndex;
                        if (added[i3] >= 0) {
                            if (f1337a) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("saveAllState: adding fragment #");
                                sb4.append(i3);
                                sb4.append(str3);
                                sb4.append(this.f1356j.get(i3));
                                Log.v(str4, sb4.toString());
                            }
                            i3++;
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(str2);
                            sb5.append(this.f1356j.get(i3));
                            sb5.append(str);
                            sb5.append(added[i3]);
                            m2052a((RuntimeException) new IllegalStateException(sb5.toString()));
                            throw null;
                        }
                    }
                }
                ArrayList<C0467f> arrayList = this.f1358l;
                if (arrayList != null) {
                    int N3 = arrayList.size();
                    if (N3 > 0) {
                        backStack = new BackStackState[N3];
                        for (int i4 = 0; i4 < N3; i4++) {
                            backStack[i4] = new BackStackState((C0467f) this.f1358l.get(i4));
                            if (f1337a) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("saveAllState: adding back stack #");
                                sb6.append(i4);
                                sb6.append(str3);
                                sb6.append(this.f1358l.get(i4));
                                Log.v(str4, sb6.toString());
                            }
                        }
                    }
                }
                FragmentManagerState fms = new FragmentManagerState();
                fms.f1405a = active;
                fms.f1406b = added;
                fms.f1407c = backStack;
                Fragment fragment2 = this.f1368v;
                if (fragment2 != null) {
                    fms.f1408d = fragment2.mIndex;
                }
                fms.f1409e = this.f1355i;
                mo4993z();
                return fms;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4915a(Parcelable state, C0419B nonConfig) {
        List list;
        List list2;
        C0165s viewModelStore;
        if (state != null) {
            FragmentManagerState fms = (FragmentManagerState) state;
            if (fms.f1405a != null) {
                if (nonConfig != null) {
                    List<Fragment> nonConfigFragments = nonConfig.mo5007b();
                    List<FragmentManagerNonConfig> childNonConfigs = nonConfig.mo5006a();
                    List<ViewModelStore> viewModelStores = nonConfig.mo5008c();
                    int count = nonConfigFragments != null ? nonConfigFragments.size() : 0;
                    int i = 0;
                    while (i < count) {
                        Fragment f = (Fragment) nonConfigFragments.get(i);
                        if (f1337a) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("restoreAllState: re-attaching retained ");
                            sb.append(f);
                            Log.v("FragmentManager", sb.toString());
                        }
                        int index = 0;
                        while (true) {
                            FragmentState[] fragmentStateArr = fms.f1405a;
                            if (index >= fragmentStateArr.length || fragmentStateArr[index].f1411b == f.mIndex) {
                                FragmentState[] fragmentStateArr2 = fms.f1405a;
                            } else {
                                index++;
                            }
                        }
                        FragmentState[] fragmentStateArr22 = fms.f1405a;
                        if (index != fragmentStateArr22.length) {
                            FragmentState fs = fragmentStateArr22[index];
                            fs.f1421l = f;
                            f.mSavedViewState = null;
                            f.mBackStackNesting = 0;
                            f.mInLayout = false;
                            f.mAdded = false;
                            f.mTarget = null;
                            Bundle bundle = fs.f1420k;
                            if (bundle != null) {
                                bundle.setClassLoader(this.f1365s.mo5227c().getClassLoader());
                                f.mSavedViewState = fs.f1420k.getSparseParcelableArray("android:view_state");
                                f.mSavedFragmentState = fs.f1420k;
                            }
                            i++;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Could not find active fragment with index ");
                            sb2.append(f.mIndex);
                            m2052a((RuntimeException) new IllegalStateException(sb2.toString()));
                            throw null;
                        }
                    }
                    list = viewModelStores;
                    list2 = childNonConfigs;
                } else {
                    list = null;
                    list2 = null;
                }
                this.f1357k = new SparseArray<>(fms.f1405a.length);
                int i2 = 0;
                while (true) {
                    FragmentState[] fragmentStateArr3 = fms.f1405a;
                    if (i2 >= fragmentStateArr3.length) {
                        break;
                    }
                    FragmentState fs2 = fragmentStateArr3[i2];
                    if (fs2 != null) {
                        C0419B childNonConfig = null;
                        if (list2 != null && i2 < list2.size()) {
                            childNonConfig = (C0419B) list2.get(i2);
                        }
                        if (list == null || i2 >= list.size()) {
                            viewModelStore = null;
                        } else {
                            viewModelStore = (C0165s) list.get(i2);
                        }
                        Fragment f2 = fs2.mo5029a(this.f1365s, this.f1366t, this.f1367u, childNonConfig, viewModelStore);
                        if (f1337a) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("restoreAllState: active #");
                            sb3.append(i2);
                            sb3.append(": ");
                            sb3.append(f2);
                            Log.v("FragmentManager", sb3.toString());
                        }
                        this.f1357k.put(f2.mIndex, f2);
                        fs2.f1421l = null;
                    }
                    i2++;
                }
                if (nonConfig != null) {
                    List<Fragment> nonConfigFragments2 = nonConfig.mo5007b();
                    int count2 = nonConfigFragments2 != null ? nonConfigFragments2.size() : 0;
                    for (int i3 = 0; i3 < count2; i3++) {
                        Fragment f3 = (Fragment) nonConfigFragments2.get(i3);
                        int i4 = f3.mTargetIndex;
                        if (i4 >= 0) {
                            f3.mTarget = (Fragment) this.f1357k.get(i4);
                            if (f3.mTarget == null) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Re-attaching retained fragment ");
                                sb4.append(f3);
                                sb4.append(" target no longer exists: ");
                                sb4.append(f3.mTargetIndex);
                                Log.w("FragmentManager", sb4.toString());
                            }
                        }
                    }
                }
                this.f1356j.clear();
                if (fms.f1406b != null) {
                    int i5 = 0;
                    while (true) {
                        int[] iArr = fms.f1406b;
                        if (i5 >= iArr.length) {
                            break;
                        }
                        Fragment f4 = (Fragment) this.f1357k.get(iArr[i5]);
                        if (f4 != null) {
                            f4.mAdded = true;
                            if (f1337a) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("restoreAllState: added #");
                                sb5.append(i5);
                                sb5.append(": ");
                                sb5.append(f4);
                                Log.v("FragmentManager", sb5.toString());
                            }
                            if (!this.f1356j.contains(f4)) {
                                synchronized (this.f1356j) {
                                    this.f1356j.add(f4);
                                }
                                i5++;
                            } else {
                                throw new IllegalStateException("Already added!");
                            }
                        } else {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("No instantiated fragment for index #");
                            sb6.append(fms.f1406b[i5]);
                            m2052a((RuntimeException) new IllegalStateException(sb6.toString()));
                            throw null;
                        }
                    }
                }
                BackStackState[] backStackStateArr = fms.f1407c;
                if (backStackStateArr != null) {
                    this.f1358l = new ArrayList<>(backStackStateArr.length);
                    int i6 = 0;
                    while (true) {
                        BackStackState[] backStackStateArr2 = fms.f1407c;
                        if (i6 >= backStackStateArr2.length) {
                            break;
                        }
                        C0467f bse = backStackStateArr2[i6].mo5009a(this);
                        if (f1337a) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("restoreAllState: back stack #");
                            sb7.append(i6);
                            sb7.append(" (index ");
                            sb7.append(bse.f1587m);
                            sb7.append("): ");
                            sb7.append(bse);
                            Log.v("FragmentManager", sb7.toString());
                            PrintWriter pw = new PrintWriter(new C1258g("FragmentManager"));
                            bse.mo5152a("  ", pw, false);
                            pw.close();
                        }
                        this.f1358l.add(bse);
                        int i7 = bse.f1587m;
                        if (i7 >= 0) {
                            mo4911a(i7, bse);
                        }
                        i6++;
                    }
                } else {
                    this.f1358l = null;
                }
                int i8 = fms.f1408d;
                if (i8 >= 0) {
                    this.f1368v = (Fragment) this.f1357k.get(i8);
                }
                this.f1355i = fms.f1409e;
            }
        }
    }

    /* renamed from: B */
    private void m2036B() {
        SparseArray<Fragment> sparseArray = this.f1357k;
        if (sparseArray != null) {
            for (int i = sparseArray.size() - 1; i >= 0; i--) {
                if (this.f1357k.valueAt(i) == null) {
                    SparseArray<Fragment> sparseArray2 = this.f1357k;
                    sparseArray2.delete(sparseArray2.keyAt(i));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4923a(C0485s host, C0483q container, Fragment parent) {
        if (this.f1365s == null) {
            this.f1365s = host;
            this.f1366t = container;
            this.f1367u = parent;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    /* renamed from: v */
    public void mo4989v() {
        this.f1351I = null;
        this.f1370x = false;
        this.f1371y = false;
        int addedCount = this.f1356j.size();
        for (int i = 0; i < addedCount; i++) {
            Fragment fragment = (Fragment) this.f1356j.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    /* renamed from: i */
    public void mo4965i() {
        this.f1370x = false;
        this.f1371y = false;
        m2067f(1);
    }

    /* renamed from: h */
    public void mo4962h() {
        this.f1370x = false;
        this.f1371y = false;
        m2067f(2);
    }

    /* renamed from: p */
    public void mo4981p() {
        this.f1370x = false;
        this.f1371y = false;
        m2067f(4);
    }

    /* renamed from: o */
    public void mo4977o() {
        this.f1370x = false;
        this.f1371y = false;
        m2067f(5);
    }

    /* renamed from: m */
    public void mo4974m() {
        m2067f(4);
    }

    /* renamed from: q */
    public void mo4983q() {
        this.f1371y = true;
        m2067f(3);
    }

    /* renamed from: n */
    public void mo4975n() {
        m2067f(2);
    }

    /* renamed from: k */
    public void mo4969k() {
        m2067f(1);
    }

    /* renamed from: j */
    public void mo4967j() {
        this.f1372z = true;
        mo4985s();
        m2067f(0);
        this.f1365s = null;
        this.f1366t = null;
        this.f1367u = null;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: f */
    private void m2067f(int nextState) {
        try {
            this.f1354h = true;
            mo4912a(nextState, false);
            this.f1354h = false;
            mo4985s();
        } catch (Throwable th) {
            this.f1354h = false;
            throw th;
        }
    }

    /* renamed from: a */
    public void mo4926a(boolean isInMultiWindowMode) {
        for (int i = this.f1356j.size() - 1; i >= 0; i--) {
            Fragment f = (Fragment) this.f1356j.get(i);
            if (f != null) {
                f.performMultiWindowModeChanged(isInMultiWindowMode);
            }
        }
    }

    /* renamed from: b */
    public void mo4939b(boolean isInPictureInPictureMode) {
        for (int i = this.f1356j.size() - 1; i >= 0; i--) {
            Fragment f = (Fragment) this.f1356j.get(i);
            if (f != null) {
                f.performPictureInPictureModeChanged(isInPictureInPictureMode);
            }
        }
    }

    /* renamed from: a */
    public void mo4913a(Configuration newConfig) {
        for (int i = 0; i < this.f1356j.size(); i++) {
            Fragment f = (Fragment) this.f1356j.get(i);
            if (f != null) {
                f.performConfigurationChanged(newConfig);
            }
        }
    }

    /* renamed from: l */
    public void mo4971l() {
        for (int i = 0; i < this.f1356j.size(); i++) {
            Fragment f = (Fragment) this.f1356j.get(i);
            if (f != null) {
                f.performLowMemory();
            }
        }
    }

    /* renamed from: a */
    public boolean mo4927a(Menu menu, MenuInflater inflater) {
        if (this.f1364r < 1) {
            return false;
        }
        boolean show = false;
        ArrayList<Fragment> newMenus = null;
        for (int i = 0; i < this.f1356j.size(); i++) {
            Fragment f = (Fragment) this.f1356j.get(i);
            if (f != null && f.performCreateOptionsMenu(menu, inflater)) {
                show = true;
                if (newMenus == null) {
                    newMenus = new ArrayList<>();
                }
                newMenus.add(f);
            }
        }
        if (this.f1359m != null) {
            for (int i2 = 0; i2 < this.f1359m.size(); i2++) {
                Fragment f2 = (Fragment) this.f1359m.get(i2);
                if (newMenus == null || !newMenus.contains(f2)) {
                    f2.onDestroyOptionsMenu();
                }
            }
        }
        this.f1359m = newMenus;
        return show;
    }

    /* renamed from: b */
    public boolean mo4941b(Menu menu) {
        if (this.f1364r < 1) {
            return false;
        }
        boolean show = false;
        for (int i = 0; i < this.f1356j.size(); i++) {
            Fragment f = (Fragment) this.f1356j.get(i);
            if (f != null && f.performPrepareOptionsMenu(menu)) {
                show = true;
            }
        }
        return show;
    }

    /* renamed from: b */
    public boolean mo4942b(MenuItem item) {
        if (this.f1364r < 1) {
            return false;
        }
        for (int i = 0; i < this.f1356j.size(); i++) {
            Fragment f = (Fragment) this.f1356j.get(i);
            if (f != null && f.performOptionsItemSelected(item)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo4928a(MenuItem item) {
        if (this.f1364r < 1) {
            return false;
        }
        for (int i = 0; i < this.f1356j.size(); i++) {
            Fragment f = (Fragment) this.f1356j.get(i);
            if (f != null && f.performContextItemSelected(item)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo4924a(Menu menu) {
        if (this.f1364r >= 1) {
            for (int i = 0; i < this.f1356j.size(); i++) {
                Fragment f = (Fragment) this.f1356j.get(i);
                if (f != null) {
                    f.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* renamed from: o */
    public void mo4978o(Fragment f) {
        if (f == null || (this.f1357k.get(f.mIndex) == f && (f.mHost == null || f.getFragmentManager() == this))) {
            this.f1368v = f;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(f);
        sb.append(" is not an active fragment of FragmentManager ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: u */
    public Fragment mo4988u() {
        return this.f1368v;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4936b(Fragment f, Context context, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4936b(f, context, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5235b((C0486t) this, f, context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4918a(Fragment f, Context context, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4918a(f, context, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5231a((C0486t) this, f, context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4946c(Fragment f, Bundle savedInstanceState, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4946c(f, savedInstanceState, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5238c(this, f, savedInstanceState);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4937b(Fragment f, Bundle savedInstanceState, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4937b(f, savedInstanceState, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5236b((C0486t) this, f, savedInstanceState);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4919a(Fragment f, Bundle savedInstanceState, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4919a(f, savedInstanceState, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5232a((C0486t) this, f, savedInstanceState);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4920a(Fragment f, View v, Bundle savedInstanceState, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4920a(f, v, savedInstanceState, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5233a(this, f, v, savedInstanceState);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo4958f(Fragment f, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4958f(f, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5241e(this, f);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo4954e(Fragment f, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4954e(f, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5239d(this, f);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo4951d(Fragment f, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4951d(f, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5237c(this, f);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo4960g(Fragment f, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4960g(f, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5242f(this, f);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo4950d(Fragment f, Bundle outState, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4950d(f, outState, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5240d(this, f, outState);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo4964h(Fragment f, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4964h(f, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5243g(this, f);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4938b(Fragment f, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4938b(f, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5230a(this, f);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4947c(Fragment f, boolean onlyRecursive) {
        Fragment fragment = this.f1367u;
        if (fragment != null) {
            C0486t parentManager = fragment.getFragmentManager();
            if (parentManager instanceof C0409A) {
                ((C0409A) parentManager).mo4947c(f, true);
            }
        }
        Iterator it = this.f1363q.iterator();
        while (it.hasNext()) {
            Pair<FragmentLifecycleCallbacks, Boolean> p = (C1268l) it.next();
            if (!onlyRecursive || ((Boolean) p.f4070b).booleanValue()) {
                ((C0488b) p.f4069a).mo5234b(this, f);
            }
        }
    }

    /* renamed from: e */
    public static int m2066e(int transit) {
        if (transit == 4097) {
            return 8194;
        }
        if (transit == 4099) {
            return 4099;
        }
        if (transit != 8194) {
            return 0;
        }
        return 4097;
    }

    /* renamed from: b */
    public static int m2059b(int transit, boolean enter) {
        if (transit == 4097) {
            return enter ? 1 : 2;
        } else if (transit == 4099) {
            return enter ? 5 : 6;
        } else if (transit != 8194) {
            return -1;
        } else {
            return enter ? 3 : 4;
        }
    }

    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        String fname;
        Fragment fragment;
        Context context2 = context;
        AttributeSet attributeSet = attrs;
        if (!"fragment".equals(name)) {
            return null;
        }
        String fname2 = attributeSet.getAttributeValue(null, "class");
        TypedArray a = context2.obtainStyledAttributes(attributeSet, C0415f.f1382a);
        int i = 0;
        if (fname2 == null) {
            fname = a.getString(0);
        } else {
            fname = fname2;
        }
        int id = a.getResourceId(1, -1);
        String tag = a.getString(2);
        a.recycle();
        if (!Fragment.isSupportFragmentClass(this.f1365s.mo5227c(), fname)) {
            return null;
        }
        if (parent != null) {
            i = parent.getId();
        }
        int containerId = i;
        if (containerId == -1 && id == -1 && tag == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(attrs.getPositionDescription());
            sb.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            sb.append(fname);
            throw new IllegalArgumentException(sb.toString());
        }
        Fragment fragment2 = id != -1 ? mo4906a(id) : null;
        if (fragment2 == null && tag != null) {
            fragment2 = mo4908a(tag);
        }
        if (fragment2 == null && containerId != -1) {
            fragment2 = mo4906a(containerId);
        }
        if (f1337a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCreateView: id=0x");
            sb2.append(Integer.toHexString(id));
            sb2.append(" fname=");
            sb2.append(fname);
            sb2.append(" existing=");
            sb2.append(fragment2);
            Log.v("FragmentManager", sb2.toString());
        }
        if (fragment2 == null) {
            Fragment fragment3 = this.f1366t.mo5196a(context2, fname, null);
            fragment3.mFromLayout = true;
            fragment3.mFragmentId = id != 0 ? id : containerId;
            fragment3.mContainerId = containerId;
            fragment3.mTag = tag;
            fragment3.mInLayout = true;
            fragment3.mFragmentManager = this;
            C0485s sVar = this.f1365s;
            fragment3.mHost = sVar;
            fragment3.onInflate(sVar.mo5227c(), attributeSet, fragment3.mSavedFragmentState);
            mo4921a(fragment3, true);
            fragment = fragment3;
        } else if (!fragment2.mInLayout) {
            fragment2.mInLayout = true;
            C0485s sVar2 = this.f1365s;
            fragment2.mHost = sVar2;
            if (!fragment2.mRetaining) {
                fragment2.onInflate(sVar2.mo5227c(), attributeSet, fragment2.mSavedFragmentState);
            }
            fragment = fragment2;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(attrs.getPositionDescription());
            sb3.append(": Duplicate id 0x");
            sb3.append(Integer.toHexString(id));
            sb3.append(", tag ");
            sb3.append(tag);
            sb3.append(", or parent id 0x");
            sb3.append(Integer.toHexString(containerId));
            sb3.append(" with another fragment for ");
            sb3.append(fname);
            throw new IllegalArgumentException(sb3.toString());
        }
        if (this.f1364r >= 1 || !fragment.mFromLayout) {
            mo4968j(fragment);
        } else {
            mo4917a(fragment, 1, 0, 0, false);
        }
        View view = fragment.mView;
        if (view != null) {
            if (id != 0) {
                view.setId(id);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(tag);
            }
            return fragment.mView;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Fragment ");
        sb4.append(fname);
        sb4.append(" did not create a view.");
        throw new IllegalStateException(sb4.toString());
    }

    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return onCreateView(null, name, context, attrs);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public Factory2 mo4986t() {
        return this;
    }
}

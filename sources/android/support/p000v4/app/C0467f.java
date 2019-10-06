package android.support.p000v4.app;

import android.support.p000v4.app.C0486t.C0487a;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import p002b.p003c.p053g.p061f.C1258g;

/* renamed from: android.support.v4.app.f */
/* compiled from: BackStackRecord */
final class C0467f extends C0424G implements C0487a, C0416g {

    /* renamed from: a */
    final C0409A f1575a;

    /* renamed from: b */
    ArrayList<C0468a> f1576b = new ArrayList<>();

    /* renamed from: c */
    int f1577c;

    /* renamed from: d */
    int f1578d;

    /* renamed from: e */
    int f1579e;

    /* renamed from: f */
    int f1580f;

    /* renamed from: g */
    int f1581g;

    /* renamed from: h */
    int f1582h;

    /* renamed from: i */
    boolean f1583i;

    /* renamed from: j */
    boolean f1584j = true;

    /* renamed from: k */
    String f1585k;

    /* renamed from: l */
    boolean f1586l;

    /* renamed from: m */
    int f1587m = -1;

    /* renamed from: n */
    int f1588n;

    /* renamed from: o */
    CharSequence f1589o;

    /* renamed from: p */
    int f1590p;

    /* renamed from: q */
    CharSequence f1591q;

    /* renamed from: r */
    ArrayList<String> f1592r;

    /* renamed from: s */
    ArrayList<String> f1593s;

    /* renamed from: t */
    boolean f1594t = false;

    /* renamed from: u */
    ArrayList<Runnable> f1595u;

    /* renamed from: android.support.v4.app.f$a */
    /* compiled from: BackStackRecord */
    static final class C0468a {

        /* renamed from: a */
        int f1596a;

        /* renamed from: b */
        Fragment f1597b;

        /* renamed from: c */
        int f1598c;

        /* renamed from: d */
        int f1599d;

        /* renamed from: e */
        int f1600e;

        /* renamed from: f */
        int f1601f;

        C0468a() {
        }

        C0468a(int cmd, Fragment fragment) {
            this.f1596a = cmd;
            this.f1597b = fragment;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1587m >= 0) {
            sb.append(" #");
            sb.append(this.f1587m);
        }
        if (this.f1585k != null) {
            sb.append(" ");
            sb.append(this.f1585k);
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo5151a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        mo5152a(prefix, writer, true);
    }

    /* renamed from: a */
    public void mo5152a(String prefix, PrintWriter writer, boolean full) {
        String cmdStr;
        if (full) {
            writer.print(prefix);
            writer.print("mName=");
            writer.print(this.f1585k);
            writer.print(" mIndex=");
            writer.print(this.f1587m);
            writer.print(" mCommitted=");
            writer.println(this.f1586l);
            if (this.f1581g != 0) {
                writer.print(prefix);
                writer.print("mTransition=#");
                writer.print(Integer.toHexString(this.f1581g));
                writer.print(" mTransitionStyle=#");
                writer.println(Integer.toHexString(this.f1582h));
            }
            if (!(this.f1577c == 0 && this.f1578d == 0)) {
                writer.print(prefix);
                writer.print("mEnterAnim=#");
                writer.print(Integer.toHexString(this.f1577c));
                writer.print(" mExitAnim=#");
                writer.println(Integer.toHexString(this.f1578d));
            }
            if (!(this.f1579e == 0 && this.f1580f == 0)) {
                writer.print(prefix);
                writer.print("mPopEnterAnim=#");
                writer.print(Integer.toHexString(this.f1579e));
                writer.print(" mPopExitAnim=#");
                writer.println(Integer.toHexString(this.f1580f));
            }
            if (!(this.f1588n == 0 && this.f1589o == null)) {
                writer.print(prefix);
                writer.print("mBreadCrumbTitleRes=#");
                writer.print(Integer.toHexString(this.f1588n));
                writer.print(" mBreadCrumbTitleText=");
                writer.println(this.f1589o);
            }
            if (!(this.f1590p == 0 && this.f1591q == null)) {
                writer.print(prefix);
                writer.print("mBreadCrumbShortTitleRes=#");
                writer.print(Integer.toHexString(this.f1590p));
                writer.print(" mBreadCrumbShortTitleText=");
                writer.println(this.f1591q);
            }
        }
        if (!this.f1576b.isEmpty()) {
            writer.print(prefix);
            writer.println("Operations:");
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            sb.append("    ");
            String sb2 = sb.toString();
            int numOps = this.f1576b.size();
            for (int opNum = 0; opNum < numOps; opNum++) {
                C0468a op = (C0468a) this.f1576b.get(opNum);
                switch (op.f1596a) {
                    case 0:
                        cmdStr = "NULL";
                        break;
                    case 1:
                        cmdStr = "ADD";
                        break;
                    case 2:
                        cmdStr = "REPLACE";
                        break;
                    case 3:
                        cmdStr = "REMOVE";
                        break;
                    case 4:
                        cmdStr = "HIDE";
                        break;
                    case 5:
                        cmdStr = "SHOW";
                        break;
                    case 6:
                        cmdStr = "DETACH";
                        break;
                    case 7:
                        cmdStr = "ATTACH";
                        break;
                    case 8:
                        cmdStr = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        cmdStr = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("cmd=");
                        sb3.append(op.f1596a);
                        cmdStr = sb3.toString();
                        break;
                }
                writer.print(prefix);
                writer.print("  Op #");
                writer.print(opNum);
                writer.print(": ");
                writer.print(cmdStr);
                writer.print(" ");
                writer.println(op.f1597b);
                if (full) {
                    if (!(op.f1598c == 0 && op.f1599d == 0)) {
                        writer.print(prefix);
                        writer.print("enterAnim=#");
                        writer.print(Integer.toHexString(op.f1598c));
                        writer.print(" exitAnim=#");
                        writer.println(Integer.toHexString(op.f1599d));
                    }
                    if (op.f1600e != 0 || op.f1601f != 0) {
                        writer.print(prefix);
                        writer.print("popEnterAnim=#");
                        writer.print(Integer.toHexString(op.f1600e));
                        writer.print(" popExitAnim=#");
                        writer.println(Integer.toHexString(op.f1601f));
                    }
                }
            }
        }
    }

    public C0467f(C0409A manager) {
        this.f1575a = manager;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5150a(C0468a op) {
        this.f1576b.add(op);
        op.f1598c = this.f1577c;
        op.f1599d = this.f1578d;
        op.f1600e = this.f1579e;
        op.f1601f = this.f1580f;
    }

    /* renamed from: a */
    public C0424G mo5037a(Fragment fragment, String tag) {
        m2370a(0, fragment, tag, 1);
        return this;
    }

    /* renamed from: a */
    public C0424G mo5034a(int containerViewId, Fragment fragment) {
        m2370a(containerViewId, fragment, (String) null, 1);
        return this;
    }

    /* renamed from: a */
    public C0424G mo5035a(int containerViewId, Fragment fragment, String tag) {
        m2370a(containerViewId, fragment, tag, 1);
        return this;
    }

    /* renamed from: a */
    private void m2370a(int containerViewId, Fragment fragment, String tag, int opcmd) {
        Class fragmentClass = fragment.getClass();
        int modifiers = fragmentClass.getModifiers();
        if (fragmentClass.isAnonymousClass() || !Modifier.isPublic(modifiers) || (fragmentClass.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragmentClass.getCanonicalName());
            sb.append(" must be a public static class to be  properly recreated from");
            sb.append(" instance state.");
            throw new IllegalStateException(sb.toString());
        }
        fragment.mFragmentManager = this.f1575a;
        String str = " now ";
        String str2 = ": was ";
        if (tag != null) {
            String str3 = fragment.mTag;
            if (str3 == null || tag.equals(str3)) {
                fragment.mTag = tag;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't change tag of fragment ");
                sb2.append(fragment);
                sb2.append(str2);
                sb2.append(fragment.mTag);
                sb2.append(str);
                sb2.append(tag);
                throw new IllegalStateException(sb2.toString());
            }
        }
        if (containerViewId != 0) {
            if (containerViewId != -1) {
                int i = fragment.mFragmentId;
                if (i == 0 || i == containerViewId) {
                    fragment.mFragmentId = containerViewId;
                    fragment.mContainerId = containerViewId;
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Can't change container ID of fragment ");
                    sb3.append(fragment);
                    sb3.append(str2);
                    sb3.append(fragment.mFragmentId);
                    sb3.append(str);
                    sb3.append(containerViewId);
                    throw new IllegalStateException(sb3.toString());
                }
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Can't add fragment ");
                sb4.append(fragment);
                sb4.append(" with tag ");
                sb4.append(tag);
                sb4.append(" to container view with no id");
                throw new IllegalArgumentException(sb4.toString());
            }
        }
        mo5150a(new C0468a(opcmd, fragment));
    }

    /* renamed from: b */
    public C0424G mo5040b(int containerViewId, Fragment fragment) {
        mo5041b(containerViewId, fragment, null);
        return this;
    }

    /* renamed from: b */
    public C0424G mo5041b(int containerViewId, Fragment fragment, String tag) {
        if (containerViewId != 0) {
            m2370a(containerViewId, fragment, tag, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    /* renamed from: c */
    public C0424G mo5043c(Fragment fragment) {
        mo5150a(new C0468a(3, fragment));
        return this;
    }

    /* renamed from: b */
    public C0424G mo5042b(Fragment fragment) {
        mo5150a(new C0468a(6, fragment));
        return this;
    }

    /* renamed from: a */
    public C0424G mo5036a(Fragment fragment) {
        mo5150a(new C0468a(7, fragment));
        return this;
    }

    /* renamed from: a */
    public C0424G mo5033a(int enter, int exit, int popEnter, int popExit) {
        this.f1577c = enter;
        this.f1578d = exit;
        this.f1579e = popEnter;
        this.f1580f = popExit;
        return this;
    }

    /* renamed from: a */
    public C0424G mo5038a(String name) {
        if (this.f1584j) {
            this.f1583i = true;
            this.f1585k = name;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    /* renamed from: e */
    public C0424G mo5157e() {
        if (!this.f1583i) {
            this.f1584j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5148a(int amt) {
        if (this.f1583i) {
            String str = "FragmentManager";
            if (C0409A.f1337a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Bump nesting in ");
                sb.append(this);
                sb.append(" by ");
                sb.append(amt);
                Log.v(str, sb.toString());
            }
            int numOps = this.f1576b.size();
            for (int opNum = 0; opNum < numOps; opNum++) {
                C0468a op = (C0468a) this.f1576b.get(opNum);
                Fragment fragment = op.f1597b;
                if (fragment != null) {
                    fragment.mBackStackNesting += amt;
                    if (C0409A.f1337a) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Bump nesting of ");
                        sb2.append(op.f1597b);
                        sb2.append(" to ");
                        sb2.append(op.f1597b.mBackStackNesting);
                        Log.v(str, sb2.toString());
                    }
                }
            }
        }
    }

    /* renamed from: h */
    public void mo5161h() {
        ArrayList<Runnable> arrayList = this.f1595u;
        if (arrayList != null) {
            int N = arrayList.size();
            for (int i = 0; i < N; i++) {
                ((Runnable) this.f1595u.get(i)).run();
            }
            this.f1595u = null;
        }
    }

    /* renamed from: a */
    public int mo5032a() {
        return mo5146a(false);
    }

    /* renamed from: b */
    public int mo5039b() {
        return mo5146a(true);
    }

    /* renamed from: c */
    public void mo5044c() {
        mo5157e();
        this.f1575a.mo4934b((C0416g) this, false);
    }

    /* renamed from: d */
    public void mo5045d() {
        mo5157e();
        this.f1575a.mo4934b((C0416g) this, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo5146a(boolean allowStateLoss) {
        if (!this.f1586l) {
            if (C0409A.f1337a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Commit: ");
                sb.append(this);
                String str = "FragmentManager";
                Log.v(str, sb.toString());
                PrintWriter pw = new PrintWriter(new C1258g(str));
                mo5151a("  ", (FileDescriptor) null, pw, (String[]) null);
                pw.close();
            }
            this.f1586l = true;
            if (this.f1583i) {
                this.f1587m = this.f1575a.mo4931b(this);
            } else {
                this.f1587m = -1;
            }
            this.f1575a.mo4916a((C0416g) this, allowStateLoss);
            return this.f1587m;
        }
        throw new IllegalStateException("commit already called");
    }

    /* renamed from: a */
    public boolean mo5002a(ArrayList<C0467f> records, ArrayList<Boolean> isRecordPop) {
        if (C0409A.f1337a) {
            StringBuilder sb = new StringBuilder();
            sb.append("Run: ");
            sb.append(this);
            Log.v("FragmentManager", sb.toString());
        }
        records.add(this);
        isRecordPop.add(Boolean.valueOf(false));
        if (this.f1583i) {
            this.f1575a.mo4922a(this);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo5156b(int containerId) {
        int numOps = this.f1576b.size();
        int opNum = 0;
        while (true) {
            int fragContainer = 0;
            if (opNum >= numOps) {
                return false;
            }
            Fragment fragment = ((C0468a) this.f1576b.get(opNum)).f1597b;
            if (fragment != null) {
                fragContainer = fragment.mContainerId;
            }
            if (fragContainer != 0 && fragContainer == containerId) {
                return true;
            }
            opNum++;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo5153a(ArrayList<C0467f> records, int startIndex, int endIndex) {
        if (endIndex == startIndex) {
            return false;
        }
        int numOps = this.f1576b.size();
        int lastContainer = -1;
        for (int opNum = 0; opNum < numOps; opNum++) {
            Fragment fragment = ((C0468a) this.f1576b.get(opNum)).f1597b;
            int container = fragment != null ? fragment.mContainerId : 0;
            if (!(container == 0 || container == lastContainer)) {
                lastContainer = container;
                for (int i = startIndex; i < endIndex; i++) {
                    C0467f record = (C0467f) records.get(i);
                    int numThoseOps = record.f1576b.size();
                    for (int thoseOpIndex = 0; thoseOpIndex < numThoseOps; thoseOpIndex++) {
                        Fragment fragment2 = ((C0468a) record.f1576b.get(thoseOpIndex)).f1597b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == container) {
                            return true;
                        }
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo5158f() {
        int numOps = this.f1576b.size();
        for (int opNum = 0; opNum < numOps; opNum++) {
            C0468a op = (C0468a) this.f1576b.get(opNum);
            Fragment f = op.f1597b;
            if (f != null) {
                f.setNextTransition(this.f1581g, this.f1582h);
            }
            switch (op.f1596a) {
                case 1:
                    f.setNextAnim(op.f1598c);
                    this.f1575a.mo4921a(f, false);
                    break;
                case 3:
                    f.setNextAnim(op.f1599d);
                    this.f1575a.mo4972l(f);
                    break;
                case 4:
                    f.setNextAnim(op.f1599d);
                    this.f1575a.mo4957f(f);
                    break;
                case 5:
                    f.setNextAnim(op.f1598c);
                    this.f1575a.mo4982p(f);
                    break;
                case 6:
                    f.setNextAnim(op.f1599d);
                    this.f1575a.mo4949d(f);
                    break;
                case 7:
                    f.setNextAnim(op.f1598c);
                    this.f1575a.mo4935b(f);
                    break;
                case 8:
                    this.f1575a.mo4978o(f);
                    break;
                case 9:
                    this.f1575a.mo4978o(null);
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown cmd: ");
                    sb.append(op.f1596a);
                    throw new IllegalArgumentException(sb.toString());
            }
            if (!(this.f1594t || op.f1596a == 1 || f == null)) {
                this.f1575a.mo4966i(f);
            }
        }
        if (this.f1594t == 0) {
            C0409A a = this.f1575a;
            a.mo4912a(a.f1364r, true);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo5155b(boolean moveToState) {
        for (int opNum = this.f1576b.size() - 1; opNum >= 0; opNum--) {
            C0468a op = (C0468a) this.f1576b.get(opNum);
            Fragment f = op.f1597b;
            if (f != null) {
                f.setNextTransition(C0409A.m2066e(this.f1581g), this.f1582h);
            }
            switch (op.f1596a) {
                case 1:
                    f.setNextAnim(op.f1601f);
                    this.f1575a.mo4972l(f);
                    break;
                case 3:
                    f.setNextAnim(op.f1600e);
                    this.f1575a.mo4921a(f, false);
                    break;
                case 4:
                    f.setNextAnim(op.f1600e);
                    this.f1575a.mo4982p(f);
                    break;
                case 5:
                    f.setNextAnim(op.f1601f);
                    this.f1575a.mo4957f(f);
                    break;
                case 6:
                    f.setNextAnim(op.f1600e);
                    this.f1575a.mo4935b(f);
                    break;
                case 7:
                    f.setNextAnim(op.f1601f);
                    this.f1575a.mo4949d(f);
                    break;
                case 8:
                    this.f1575a.mo4978o(null);
                    break;
                case 9:
                    this.f1575a.mo4978o(f);
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown cmd: ");
                    sb.append(op.f1596a);
                    throw new IllegalArgumentException(sb.toString());
            }
            if (!(this.f1594t || op.f1596a == 3 || f == null)) {
                this.f1575a.mo4966i(f);
            }
        }
        if (this.f1594t == 0 && moveToState) {
            C0409A a = this.f1575a;
            a.mo4912a(a.f1364r, true);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Fragment mo5147a(ArrayList<Fragment> added, Fragment oldPrimaryNav) {
        int opNum = 0;
        while (opNum < this.f1576b.size()) {
            C0468a op = (C0468a) this.f1576b.get(opNum);
            int i = op.f1596a;
            if (i != 1) {
                if (i == 2) {
                    Fragment f = op.f1597b;
                    int containerId = f.mContainerId;
                    boolean alreadyAdded = false;
                    for (int i2 = added.size() - 1; i2 >= 0; i2--) {
                        Fragment old = (Fragment) added.get(i2);
                        if (old.mContainerId == containerId) {
                            if (old == f) {
                                alreadyAdded = true;
                            } else {
                                if (old == oldPrimaryNav) {
                                    this.f1576b.add(opNum, new C0468a(9, old));
                                    opNum++;
                                    oldPrimaryNav = null;
                                }
                                C0468a removeOp = new C0468a(3, old);
                                removeOp.f1598c = op.f1598c;
                                removeOp.f1600e = op.f1600e;
                                removeOp.f1599d = op.f1599d;
                                removeOp.f1601f = op.f1601f;
                                this.f1576b.add(opNum, removeOp);
                                added.remove(old);
                                opNum++;
                            }
                        }
                    }
                    if (alreadyAdded) {
                        this.f1576b.remove(opNum);
                        opNum--;
                    } else {
                        op.f1596a = 1;
                        added.add(f);
                    }
                } else if (i == 3 || i == 6) {
                    added.remove(op.f1597b);
                    Fragment fragment = op.f1597b;
                    if (fragment == oldPrimaryNav) {
                        this.f1576b.add(opNum, new C0468a(9, fragment));
                        opNum++;
                        oldPrimaryNav = null;
                    }
                } else if (i != 7) {
                    if (i == 8) {
                        this.f1576b.add(opNum, new C0468a(9, oldPrimaryNav));
                        opNum++;
                        oldPrimaryNav = op.f1597b;
                    }
                }
                opNum++;
            }
            added.add(op.f1597b);
            opNum++;
        }
        return oldPrimaryNav;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Fragment mo5154b(ArrayList<Fragment> added, Fragment oldPrimaryNav) {
        for (int opNum = 0; opNum < this.f1576b.size(); opNum++) {
            C0468a op = (C0468a) this.f1576b.get(opNum);
            int i = op.f1596a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            oldPrimaryNav = null;
                            break;
                        case 9:
                            oldPrimaryNav = op.f1597b;
                            break;
                    }
                }
                added.add(op.f1597b);
            }
            added.remove(op.f1597b);
        }
        return oldPrimaryNav;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo5159g() {
        for (int opNum = 0; opNum < this.f1576b.size(); opNum++) {
            if (m2371b((C0468a) this.f1576b.get(opNum))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5149a(C0006b listener) {
        for (int opNum = 0; opNum < this.f1576b.size(); opNum++) {
            C0468a op = (C0468a) this.f1576b.get(opNum);
            if (m2371b(op)) {
                op.f1597b.setOnStartEnterTransitionListener(listener);
            }
        }
    }

    /* renamed from: b */
    private static boolean m2371b(C0468a op) {
        Fragment fragment = op.f1597b;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    public String getName() {
        return this.f1585k;
    }
}

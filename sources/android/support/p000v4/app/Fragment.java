package android.support.p000v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.C0001f;
import android.arch.lifecycle.C0003t;
import android.arch.lifecycle.C0148d;
import android.arch.lifecycle.C0148d.C0000a;
import android.arch.lifecycle.C0152h;
import android.arch.lifecycle.C0165s;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.view.C0624g;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import p002b.p003c.p053g.p061f.C1257f;
import p002b.p003c.p053g.p061f.C1273q;

/* renamed from: android.support.v4.app.Fragment */
public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener, C0001f, C0003t {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    private static final C1273q<String, Class<?>> sClassMap = new C1273q<>();
    boolean mAdded;
    C0005a mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    C0409A mChildFragmentManager;
    C0419B mChildNonConfig;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    C0409A mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    C0485s mHost;
    boolean mInLayout;
    int mIndex = -1;
    View mInnerView;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    LayoutInflater mLayoutInflater;
    C0152h mLifecycleRegistry = new C0152h(this);
    LoaderManagerImpl mLoaderManager;
    boolean mMenuVisible = true;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetaining;
    Bundle mSavedFragmentState;
    Boolean mSavedUserVisibleHint;
    SparseArray<Parcelable> mSavedViewState;
    int mState = 0;
    String mTag;
    Fragment mTarget;
    int mTargetIndex = -1;
    int mTargetRequestCode;
    boolean mUserVisibleHint = true;
    View mView;
    C0165s mViewModelStore;
    String mWho;

    /* renamed from: android.support.v4.app.Fragment$InstantiationException */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String msg, Exception cause) {
            super(msg, cause);
        }
    }

    /* renamed from: android.support.v4.app.Fragment$SavedState */
    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C0481n();

        /* renamed from: a */
        final Bundle f0a;

        SavedState(Bundle state) {
            this.f0a = state;
        }

        SavedState(Parcel in, ClassLoader loader) {
            this.f0a = in.readBundle();
            if (loader != null) {
                Bundle bundle = this.f0a;
                if (bundle != null) {
                    bundle.setClassLoader(loader);
                }
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeBundle(this.f0a);
        }
    }

    /* renamed from: android.support.v4.app.Fragment$a */
    static class C0005a {

        /* renamed from: a */
        View f1a;

        /* renamed from: b */
        Animator f2b;

        /* renamed from: c */
        int f3c;

        /* renamed from: d */
        int f4d;

        /* renamed from: e */
        int f5e;

        /* renamed from: f */
        int f6f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public Object f7g = null;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public Object f8h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public Object f9i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public Object f10j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public Object f11k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public Object f12l;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public Boolean f13m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public Boolean f14n;

        /* renamed from: o */
        C0469fa f15o;

        /* renamed from: p */
        C0469fa f16p;

        /* renamed from: q */
        boolean f17q;

        /* renamed from: r */
        C0006b f18r;

        /* renamed from: s */
        boolean f19s;

        C0005a() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.f8h = obj;
            this.f9i = null;
            this.f10j = obj;
            this.f11k = null;
            this.f12l = obj;
            this.f15o = null;
            this.f16p = null;
        }
    }

    /* renamed from: android.support.v4.app.Fragment$b */
    interface C0006b {
        /* renamed from: a */
        void mo165a();

        /* renamed from: b */
        void mo166b();
    }

    public C0148d getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public C0165s getViewModelStore() {
        if (getContext() != null) {
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new C0165s();
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public static Fragment instantiate(Context context, String fname) {
        return instantiate(context, fname, null);
    }

    public static Fragment instantiate(Context context, String fname, Bundle args) {
        String str = " empty constructor that is public";
        String str2 = ": make sure class name exists, is public, and has an";
        String str3 = "Unable to instantiate fragment ";
        try {
            Class cls = (Class) sClassMap.get(fname);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(fname);
                sClassMap.put(fname, cls);
            }
            Fragment f = (Fragment) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (args != null) {
                args.setClassLoader(f.getClass().getClassLoader());
                f.setArguments(args);
            }
            return f;
        } catch (ClassNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(fname);
            sb.append(str2);
            sb.append(str);
            throw new InstantiationException(sb.toString(), e);
        } catch (InstantiationException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(fname);
            sb2.append(str2);
            sb2.append(str);
            throw new InstantiationException(sb2.toString(), e2);
        } catch (IllegalAccessException e3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(fname);
            sb3.append(str2);
            sb3.append(str);
            throw new InstantiationException(sb3.toString(), e3);
        } catch (NoSuchMethodException e4) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str3);
            sb4.append(fname);
            sb4.append(": could not find Fragment constructor");
            throw new InstantiationException(sb4.toString(), e4);
        } catch (InvocationTargetException e5) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str3);
            sb5.append(fname);
            sb5.append(": calling Fragment constructor caused an exception");
            throw new InstantiationException(sb5.toString(), e5);
        }
    }

    static boolean isSupportFragmentClass(Context context, String fname) {
        try {
            Class cls = (Class) sClassMap.get(fname);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(fname);
                sClassMap.put(fname, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void restoreViewState(Bundle savedInstanceState) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mInnerView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(savedInstanceState);
        if (!this.mCalled) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" did not call through to super.onViewStateRestored()");
            throw new C0472ga(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public final void setIndex(int index, Fragment parent) {
        this.mIndex = index;
        if (parent != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(parent.mWho);
            sb.append(":");
            sb.append(this.mIndex);
            this.mWho = sb.toString();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("android:fragment:");
        sb2.append(this.mIndex);
        this.mWho = sb2.toString();
    }

    /* access modifiers changed from: 0000 */
    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean equals(Object o) {
        return super.equals(o);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        C1257f.m5913a(this, sb);
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final String getTag() {
        return this.mTag;
    }

    public void setArguments(Bundle args) {
        if (this.mIndex < 0 || !isStateSaved()) {
            this.mArguments = args;
            return;
        }
        throw new IllegalStateException("Fragment already active and state has been saved");
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final boolean isStateSaved() {
        C0409A a = this.mFragmentManager;
        if (a == null) {
            return false;
        }
        return a.mo4955e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        if (r0 != null) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setInitialSavedState(android.support.p000v4.app.Fragment.SavedState r3) {
        /*
            r2 = this;
            int r0 = r2.mIndex
            if (r0 >= 0) goto L_0x000f
            if (r3 == 0) goto L_0x000b
            android.os.Bundle r0 = r3.f0a
            if (r0 == 0) goto L_0x000b
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            r2.mSavedFragmentState = r0
            return
        L_0x000f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Fragment already active"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.Fragment.setInitialSavedState(android.support.v4.app.Fragment$SavedState):void");
    }

    public void setTargetFragment(Fragment fragment, int requestCode) {
        C0486t mine = getFragmentManager();
        C0486t theirs = fragment != null ? fragment.getFragmentManager() : null;
        if (mine == null || theirs == null || mine == theirs) {
            Fragment check = fragment;
            while (check != null) {
                if (check != this) {
                    check = check.getTargetFragment();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Setting ");
                    sb.append(fragment);
                    sb.append(" as the target of ");
                    sb.append(this);
                    sb.append(" would create a target cycle");
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            this.mTarget = fragment;
            this.mTargetRequestCode = requestCode;
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Fragment ");
        sb2.append(fragment);
        sb2.append(" must share the same FragmentManager to be set as a target fragment");
        throw new IllegalArgumentException(sb2.toString());
    }

    public final Fragment getTargetFragment() {
        return this.mTarget;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public Context getContext() {
        C0485s sVar = this.mHost;
        if (sVar == null) {
            return null;
        }
        return sVar.mo5227c();
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to a context.");
        throw new IllegalStateException(sb.toString());
    }

    public final C0014p getActivity() {
        C0485s sVar = this.mHost;
        if (sVar == null) {
            return null;
        }
        return (C0014p) sVar.mo5226b();
    }

    public final C0014p requireActivity() {
        C0014p activity = getActivity();
        if (activity != null) {
            return activity;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to an activity.");
        throw new IllegalStateException(sb.toString());
    }

    public final Object getHost() {
        C0485s sVar = this.mHost;
        if (sVar == null) {
            return null;
        }
        return sVar.mo230f();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to a host.");
        throw new IllegalStateException(sb.toString());
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final CharSequence getText(int resId) {
        return getResources().getText(resId);
    }

    public final String getString(int resId) {
        return getResources().getString(resId);
    }

    public final String getString(int resId, Object... formatArgs) {
        return getResources().getString(resId, formatArgs);
    }

    public final C0486t getFragmentManager() {
        return this.mFragmentManager;
    }

    public final C0486t requireFragmentManager() {
        C0486t fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not associated with a fragment manager.");
        throw new IllegalStateException(sb.toString());
    }

    public final C0486t getChildFragmentManager() {
        if (this.mChildFragmentManager == null) {
            instantiateChildFragmentManager();
            int i = this.mState;
            if (i >= 5) {
                this.mChildFragmentManager.mo4977o();
            } else if (i >= 4) {
                this.mChildFragmentManager.mo4981p();
            } else if (i >= 2) {
                this.mChildFragmentManager.mo4962h();
            } else if (i >= 1) {
                this.mChildFragmentManager.mo4965i();
            }
        }
        return this.mChildFragmentManager;
    }

    /* access modifiers changed from: 0000 */
    public C0486t peekChildFragmentManager() {
        return this.mChildFragmentManager;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isResumed() {
        return this.mState >= 5;
    }

    public final boolean isVisible() {
        if (isAdded() && !isHidden()) {
            View view = this.mView;
            if (!(view == null || view.getWindowToken() == null || this.mView.getVisibility() != 0)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public void onHiddenChanged(boolean hidden) {
    }

    public void setRetainInstance(boolean retain) {
        this.mRetainInstance = retain;
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        if (this.mHasMenu != hasMenu) {
            this.mHasMenu = hasMenu;
            if (isAdded() && !isHidden()) {
                this.mHost.mo234j();
            }
        }
    }

    public void setMenuVisibility(boolean menuVisible) {
        if (this.mMenuVisible != menuVisible) {
            this.mMenuVisible = menuVisible;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.mo234j();
            }
        }
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (!this.mUserVisibleHint && isVisibleToUser && this.mState < 4 && this.mFragmentManager != null && isAdded()) {
            this.mFragmentManager.mo4970k(this);
        }
        this.mUserVisibleHint = isVisibleToUser;
        this.mDeferStart = this.mState < 4 && !isVisibleToUser;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(this.mUserVisibleHint);
        }
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public C0442W getLoaderManager() {
        LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
        if (loaderManagerImpl != null) {
            return loaderManagerImpl;
        }
        this.mLoaderManager = new LoaderManagerImpl(this, getViewModelStore());
        return this.mLoaderManager;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(Intent intent, Bundle options) {
        C0485s sVar = this.mHost;
        if (sVar != null) {
            sVar.mo223a(this, intent, -1, options);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode, null);
    }

    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        C0485s sVar = this.mHost;
        if (sVar != null) {
            sVar.mo223a(this, intent, requestCode, options);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }

    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws SendIntentException {
        C0485s sVar = this.mHost;
        if (sVar != null) {
            sVar.mo224a(this, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public final void requestPermissions(String[] permissions, int requestCode) {
        C0485s sVar = this.mHost;
        if (sVar != null) {
            sVar.mo225a(this, permissions, requestCode);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    }

    public boolean shouldShowRequestPermissionRationale(String permission) {
        C0485s sVar = this.mHost;
        if (sVar != null) {
            return sVar.mo228a(permission);
        }
        return false;
    }

    public LayoutInflater onGetLayoutInflater(Bundle savedInstanceState) {
        return getLayoutInflater(savedInstanceState);
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        if (layoutInflater == null) {
            return performGetLayoutInflater(null);
        }
        return layoutInflater;
    }

    /* access modifiers changed from: 0000 */
    public LayoutInflater performGetLayoutInflater(Bundle savedInstanceState) {
        this.mLayoutInflater = onGetLayoutInflater(savedInstanceState);
        return this.mLayoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle savedFragmentState) {
        C0485s sVar = this.mHost;
        if (sVar != null) {
            LayoutInflater result = sVar.mo231g();
            getChildFragmentManager();
            C0409A a = this.mChildFragmentManager;
            a.mo4986t();
            C0624g.m2884b(result, a);
            return result;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        this.mCalled = true;
        C0485s sVar = this.mHost;
        Activity hostActivity = sVar == null ? null : sVar.mo5226b();
        if (hostActivity != null) {
            this.mCalled = false;
            onInflate(hostActivity, attrs, savedInstanceState);
        }
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        this.mCalled = true;
    }

    public void onAttachFragment(Fragment childFragment) {
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        C0485s sVar = this.mHost;
        Activity hostActivity = sVar == null ? null : sVar.mo5226b();
        if (hostActivity != null) {
            this.mCalled = false;
            onAttach(hostActivity);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return null;
    }

    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        return null;
    }

    public void onCreate(Bundle savedInstanceState) {
        this.mCalled = true;
        restoreChildFragmentState(savedInstanceState);
        C0409A a = this.mChildFragmentManager;
        if (a != null && !a.mo4952d(1)) {
            this.mChildFragmentManager.mo4965i();
        }
    }

    /* access modifiers changed from: 0000 */
    public void restoreChildFragmentState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Parcelable p = savedInstanceState.getParcelable("android:support:fragments");
            if (p != null) {
                if (this.mChildFragmentManager == null) {
                    instantiateChildFragmentManager();
                }
                this.mChildFragmentManager.mo4915a(p, this.mChildNonConfig);
                this.mChildNonConfig = null;
                this.mChildFragmentManager.mo4965i();
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
    }

    public View getView() {
        return this.mView;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle outState) {
    }

    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
    }

    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
    }

    public void onConfigurationChanged(Configuration newConfig) {
        this.mCalled = true;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDestroy() {
        this.mCalled = true;
        C0165s sVar = this.mViewModelStore;
        if (sVar != null && !this.mHost.f1618e.f1370x) {
            sVar.mo3773a();
        }
    }

    /* access modifiers changed from: 0000 */
    public void initState() {
        this.mIndex = -1;
        this.mWho = null;
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = null;
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
        this.mRetaining = false;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onDestroyOptionsMenu() {
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        getActivity().onCreateContextMenu(menu, v, menuInfo);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public boolean onContextItemSelected(MenuItem item) {
        return false;
    }

    public void setEnterSharedElementCallback(C0469fa callback) {
        ensureAnimationInfo().f15o = callback;
    }

    public void setExitSharedElementCallback(C0469fa callback) {
        ensureAnimationInfo().f16p = callback;
    }

    public void setEnterTransition(Object transition) {
        ensureAnimationInfo().f7g = transition;
    }

    public Object getEnterTransition() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f7g;
    }

    public void setReturnTransition(Object transition) {
        ensureAnimationInfo().f8h = transition;
    }

    public Object getReturnTransition() {
        Object obj;
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        if (aVar.f8h == USE_DEFAULT_TRANSITION) {
            obj = getEnterTransition();
        } else {
            obj = this.mAnimationInfo.f8h;
        }
        return obj;
    }

    public void setExitTransition(Object transition) {
        ensureAnimationInfo().f9i = transition;
    }

    public Object getExitTransition() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f9i;
    }

    public void setReenterTransition(Object transition) {
        ensureAnimationInfo().f10j = transition;
    }

    public Object getReenterTransition() {
        Object obj;
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        if (aVar.f10j == USE_DEFAULT_TRANSITION) {
            obj = getExitTransition();
        } else {
            obj = this.mAnimationInfo.f10j;
        }
        return obj;
    }

    public void setSharedElementEnterTransition(Object transition) {
        ensureAnimationInfo().f11k = transition;
    }

    public Object getSharedElementEnterTransition() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f11k;
    }

    public void setSharedElementReturnTransition(Object transition) {
        ensureAnimationInfo().f12l = transition;
    }

    public Object getSharedElementReturnTransition() {
        Object obj;
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        if (aVar.f12l == USE_DEFAULT_TRANSITION) {
            obj = getSharedElementEnterTransition();
        } else {
            obj = this.mAnimationInfo.f12l;
        }
        return obj;
    }

    public void setAllowEnterTransitionOverlap(boolean allow) {
        ensureAnimationInfo().f14n = Boolean.valueOf(allow);
    }

    public boolean getAllowEnterTransitionOverlap() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null || aVar.f14n == null) {
            return true;
        }
        return this.mAnimationInfo.f14n.booleanValue();
    }

    public void setAllowReturnTransitionOverlap(boolean allow) {
        ensureAnimationInfo().f13m = Boolean.valueOf(allow);
    }

    public boolean getAllowReturnTransitionOverlap() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null || aVar.f13m == null) {
            return true;
        }
        return this.mAnimationInfo.f13m.booleanValue();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f17q = true;
    }

    public void startPostponedEnterTransition() {
        C0409A a = this.mFragmentManager;
        if (a == null || a.f1365s == null) {
            ensureAnimationInfo().f17q = false;
        } else if (Looper.myLooper() != this.mFragmentManager.f1365s.mo5229e().getLooper()) {
            this.mFragmentManager.f1365s.mo5229e().postAtFrontOfQueue(new C0479l(this));
        } else {
            callStartTransitionListener();
        }
    }

    /* access modifiers changed from: private */
    public void callStartTransitionListener() {
        C0006b listener;
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            listener = null;
        } else {
            aVar.f17q = false;
            C0006b listener2 = aVar.f18r;
            aVar.f18r = null;
            listener = listener2;
        }
        if (listener != null) {
            listener.mo166b();
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.print(prefix);
        writer.print("mFragmentId=#");
        writer.print(Integer.toHexString(this.mFragmentId));
        writer.print(" mContainerId=#");
        writer.print(Integer.toHexString(this.mContainerId));
        writer.print(" mTag=");
        writer.println(this.mTag);
        writer.print(prefix);
        writer.print("mState=");
        writer.print(this.mState);
        writer.print(" mIndex=");
        writer.print(this.mIndex);
        writer.print(" mWho=");
        writer.print(this.mWho);
        writer.print(" mBackStackNesting=");
        writer.println(this.mBackStackNesting);
        writer.print(prefix);
        writer.print("mAdded=");
        writer.print(this.mAdded);
        writer.print(" mRemoving=");
        writer.print(this.mRemoving);
        writer.print(" mFromLayout=");
        writer.print(this.mFromLayout);
        writer.print(" mInLayout=");
        writer.println(this.mInLayout);
        writer.print(prefix);
        writer.print("mHidden=");
        writer.print(this.mHidden);
        writer.print(" mDetached=");
        writer.print(this.mDetached);
        writer.print(" mMenuVisible=");
        writer.print(this.mMenuVisible);
        writer.print(" mHasMenu=");
        writer.println(this.mHasMenu);
        writer.print(prefix);
        writer.print("mRetainInstance=");
        writer.print(this.mRetainInstance);
        writer.print(" mRetaining=");
        writer.print(this.mRetaining);
        writer.print(" mUserVisibleHint=");
        writer.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            writer.print(prefix);
            writer.print("mFragmentManager=");
            writer.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            writer.print(prefix);
            writer.print("mHost=");
            writer.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            writer.print(prefix);
            writer.print("mParentFragment=");
            writer.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            writer.print(prefix);
            writer.print("mArguments=");
            writer.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            writer.print(prefix);
            writer.print("mSavedFragmentState=");
            writer.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            writer.print(prefix);
            writer.print("mSavedViewState=");
            writer.println(this.mSavedViewState);
        }
        if (this.mTarget != null) {
            writer.print(prefix);
            writer.print("mTarget=");
            writer.print(this.mTarget);
            writer.print(" mTargetRequestCode=");
            writer.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            writer.print(prefix);
            writer.print("mNextAnim=");
            writer.println(getNextAnim());
        }
        if (this.mContainer != null) {
            writer.print(prefix);
            writer.print("mContainer=");
            writer.println(this.mContainer);
        }
        if (this.mView != null) {
            writer.print(prefix);
            writer.print("mView=");
            writer.println(this.mView);
        }
        if (this.mInnerView != null) {
            writer.print(prefix);
            writer.print("mInnerView=");
            writer.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            writer.print(prefix);
            writer.print("mAnimatingAway=");
            writer.println(getAnimatingAway());
            writer.print(prefix);
            writer.print("mStateAfterAnimating=");
            writer.println(getStateAfterAnimating());
        }
        String str = "  ";
        if (this.mLoaderManager != null) {
            writer.print(prefix);
            writer.println("Loader Manager:");
            LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            sb.append(str);
            loaderManagerImpl.mo5052a(sb.toString(), fd, writer, args);
        }
        if (this.mChildFragmentManager != null) {
            writer.print(prefix);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Child ");
            sb2.append(this.mChildFragmentManager);
            sb2.append(":");
            writer.println(sb2.toString());
            C0409A a = this.mChildFragmentManager;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(prefix);
            sb3.append(str);
            a.mo4925a(sb3.toString(), fd, writer, args);
        }
    }

    /* access modifiers changed from: 0000 */
    public Fragment findFragmentByWho(String who) {
        if (who.equals(this.mWho)) {
            return this;
        }
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            return a.mo4932b(who);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void instantiateChildFragmentManager() {
        if (this.mHost != null) {
            this.mChildFragmentManager = new C0409A();
            this.mChildFragmentManager.mo4923a(this.mHost, (C0483q) new C0480m(this), this);
            return;
        }
        throw new IllegalStateException("Fragment has not been attached yet.");
    }

    /* access modifiers changed from: 0000 */
    public void performCreate(Bundle savedInstanceState) {
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4989v();
        }
        this.mState = 1;
        this.mCalled = false;
        onCreate(savedInstanceState);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.mo3755b(C0000a.ON_CREATE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onCreate()");
        throw new C0472ga(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public View performCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4989v();
        }
        this.mPerformedCreateView = true;
        return onCreateView(inflater, container, savedInstanceState);
    }

    /* access modifiers changed from: 0000 */
    public void performActivityCreated(Bundle savedInstanceState) {
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4989v();
        }
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(savedInstanceState);
        if (this.mCalled) {
            C0409A a2 = this.mChildFragmentManager;
            if (a2 != null) {
                a2.mo4962h();
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onActivityCreated()");
        throw new C0472ga(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void performStart() {
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4989v();
            this.mChildFragmentManager.mo4985s();
        }
        this.mState = 4;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            C0409A a2 = this.mChildFragmentManager;
            if (a2 != null) {
                a2.mo4981p();
            }
            this.mLifecycleRegistry.mo3755b(C0000a.ON_START);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onStart()");
        throw new C0472ga(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void performResume() {
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4989v();
            this.mChildFragmentManager.mo4985s();
        }
        this.mState = 5;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            C0409A a2 = this.mChildFragmentManager;
            if (a2 != null) {
                a2.mo4977o();
                this.mChildFragmentManager.mo4985s();
            }
            this.mLifecycleRegistry.mo3755b(C0000a.ON_RESUME);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onResume()");
        throw new C0472ga(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void noteStateNotSaved() {
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4989v();
        }
    }

    /* access modifiers changed from: 0000 */
    public void performMultiWindowModeChanged(boolean isInMultiWindowMode) {
        onMultiWindowModeChanged(isInMultiWindowMode);
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4926a(isInMultiWindowMode);
        }
    }

    /* access modifiers changed from: 0000 */
    public void performPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        onPictureInPictureModeChanged(isInPictureInPictureMode);
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4939b(isInPictureInPictureMode);
        }
    }

    /* access modifiers changed from: 0000 */
    public void performConfigurationChanged(Configuration newConfig) {
        onConfigurationChanged(newConfig);
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4913a(newConfig);
        }
    }

    /* access modifiers changed from: 0000 */
    public void performLowMemory() {
        onLowMemory();
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4971l();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean performCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean show = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            show = true;
            onCreateOptionsMenu(menu, inflater);
        }
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            return show | a.mo4927a(menu, inflater);
        }
        return show;
    }

    /* access modifiers changed from: 0000 */
    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean show = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            show = true;
            onPrepareOptionsMenu(menu);
        }
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            return show | a.mo4941b(menu);
        }
        return show;
    }

    /* access modifiers changed from: 0000 */
    public boolean performOptionsItemSelected(MenuItem item) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(item)) {
                return true;
            }
            C0409A a = this.mChildFragmentManager;
            if (a != null && a.mo4942b(item)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public boolean performContextItemSelected(MenuItem item) {
        if (!this.mHidden) {
            if (onContextItemSelected(item)) {
                return true;
            }
            C0409A a = this.mChildFragmentManager;
            if (a != null && a.mo4928a(item)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            C0409A a = this.mChildFragmentManager;
            if (a != null) {
                a.mo4924a(menu);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void performSaveInstanceState(Bundle outState) {
        onSaveInstanceState(outState);
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            Parcelable p = a.mo4992y();
            if (p != null) {
                outState.putParcelable("android:support:fragments", p);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void performPause() {
        this.mLifecycleRegistry.mo3755b(C0000a.ON_PAUSE);
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4974m();
        }
        this.mState = 4;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" did not call through to super.onPause()");
            throw new C0472ga(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void performStop() {
        this.mLifecycleRegistry.mo3755b(C0000a.ON_STOP);
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4983q();
        }
        this.mState = 3;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" did not call through to super.onStop()");
            throw new C0472ga(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void performReallyStop() {
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4975n();
        }
        this.mState = 2;
    }

    /* access modifiers changed from: 0000 */
    public void performDestroyView() {
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4969k();
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
            if (loaderManagerImpl != null) {
                loaderManagerImpl.mo5051a();
            }
            this.mPerformedCreateView = false;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onDestroyView()");
        throw new C0472ga(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void performDestroy() {
        this.mLifecycleRegistry.mo3755b(C0000a.ON_DESTROY);
        C0409A a = this.mChildFragmentManager;
        if (a != null) {
            a.mo4967j();
        }
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            this.mChildFragmentManager = null;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onDestroy()");
        throw new C0472ga(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            C0409A a = this.mChildFragmentManager;
            if (a == null) {
                return;
            }
            if (this.mRetaining) {
                a.mo4967j();
                this.mChildFragmentManager = null;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Child FragmentManager of ");
            sb.append(this);
            sb.append(" was not ");
            sb.append(" destroyed and this fragment is not retaining instance");
            throw new IllegalStateException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Fragment ");
        sb2.append(this);
        sb2.append(" did not call through to super.onDetach()");
        throw new C0472ga(sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    public void setOnStartEnterTransitionListener(C0006b listener) {
        ensureAnimationInfo();
        C0006b bVar = this.mAnimationInfo.f18r;
        if (listener != bVar) {
            if (listener == null || bVar == null) {
                C0005a aVar = this.mAnimationInfo;
                if (aVar.f17q) {
                    aVar.f18r = listener;
                }
                if (listener != null) {
                    listener.mo165a();
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to set a replacement startPostponedEnterTransition on ");
            sb.append(this);
            throw new IllegalStateException(sb.toString());
        }
    }

    private C0005a ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new C0005a();
        }
        return this.mAnimationInfo;
    }

    /* access modifiers changed from: 0000 */
    public int getNextAnim() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f4d;
    }

    /* access modifiers changed from: 0000 */
    public void setNextAnim(int animResourceId) {
        if (this.mAnimationInfo != null || animResourceId != 0) {
            ensureAnimationInfo().f4d = animResourceId;
        }
    }

    /* access modifiers changed from: 0000 */
    public int getNextTransition() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f5e;
    }

    /* access modifiers changed from: 0000 */
    public void setNextTransition(int nextTransition, int nextTransitionStyle) {
        if (this.mAnimationInfo != null || nextTransition != 0 || nextTransitionStyle != 0) {
            ensureAnimationInfo();
            C0005a aVar = this.mAnimationInfo;
            aVar.f5e = nextTransition;
            aVar.f6f = nextTransitionStyle;
        }
    }

    /* access modifiers changed from: 0000 */
    public int getNextTransitionStyle() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f6f;
    }

    /* access modifiers changed from: 0000 */
    public C0469fa getEnterTransitionCallback() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f15o;
    }

    /* access modifiers changed from: 0000 */
    public C0469fa getExitTransitionCallback() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f16p;
    }

    /* access modifiers changed from: 0000 */
    public View getAnimatingAway() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f1a;
    }

    /* access modifiers changed from: 0000 */
    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f1a = view;
    }

    /* access modifiers changed from: 0000 */
    public void setAnimator(Animator animator) {
        ensureAnimationInfo().f2b = animator;
    }

    /* access modifiers changed from: 0000 */
    public Animator getAnimator() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f2b;
    }

    /* access modifiers changed from: 0000 */
    public int getStateAfterAnimating() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f3c;
    }

    /* access modifiers changed from: 0000 */
    public void setStateAfterAnimating(int state) {
        ensureAnimationInfo().f3c = state;
    }

    /* access modifiers changed from: 0000 */
    public boolean isPostponed() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.f17q;
    }

    /* access modifiers changed from: 0000 */
    public boolean isHideReplaced() {
        C0005a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.f19s;
    }

    /* access modifiers changed from: 0000 */
    public void setHideReplaced(boolean replaced) {
        ensureAnimationInfo().f19s = replaced;
    }
}

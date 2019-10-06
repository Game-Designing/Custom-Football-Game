package android.support.p000v4.app;

import android.app.Activity;
import android.arch.lifecycle.C0003t;
import android.arch.lifecycle.C0148d;
import android.arch.lifecycle.C0148d.C0149b;
import android.arch.lifecycle.C0165s;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.p000v4.app.C0453b.C0007a;
import android.support.p000v4.app.C0453b.C0008c;
import android.support.p000v4.app.C0453b.C0454b;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p002b.p003c.p053g.p061f.C1274r;

/* renamed from: android.support.v4.app.p */
/* compiled from: FragmentActivity */
public class C0014p extends C0012i implements C0003t, C0007a, C0008c {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final C0484r mFragments = C0484r.m2425a((C0485s<?>) new C0015a<Object>());
    final Handler mHandler = new C0482o(this);
    C0442W mLoaderManager;
    int mNextCandidateRequestIndex;
    C1274r<String> mPendingFragmentActivityResults;
    boolean mReallyStopped = true;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped = true;
    private C0165s mViewModelStore;

    /* renamed from: android.support.v4.app.p$a */
    /* compiled from: FragmentActivity */
    class C0015a extends C0485s<C0014p> {
        public C0015a() {
            super(C0014p.this);
        }

        /* renamed from: a */
        public void mo226a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            C0014p.this.dump(prefix, fd, writer, args);
        }

        /* renamed from: b */
        public boolean mo229b(Fragment fragment) {
            return !C0014p.this.isFinishing();
        }

        /* renamed from: g */
        public LayoutInflater mo231g() {
            return C0014p.this.getLayoutInflater().cloneInContext(C0014p.this);
        }

        /* renamed from: f */
        public C0014p m28f() {
            return C0014p.this;
        }

        /* renamed from: j */
        public void mo234j() {
            C0014p.this.supportInvalidateOptionsMenu();
        }

        /* renamed from: a */
        public void mo223a(Fragment fragment, Intent intent, int requestCode, Bundle options) {
            C0014p.this.startActivityFromFragment(fragment, intent, requestCode, options);
        }

        /* renamed from: a */
        public void mo224a(Fragment fragment, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws SendIntentException {
            C0014p.this.startIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        }

        /* renamed from: a */
        public void mo225a(Fragment fragment, String[] permissions, int requestCode) {
            C0014p.this.requestPermissionsFromFragment(fragment, permissions, requestCode);
        }

        /* renamed from: a */
        public boolean mo228a(String permission) {
            return C0453b.m2342a((Activity) C0014p.this, permission);
        }

        /* renamed from: i */
        public boolean mo233i() {
            return C0014p.this.getWindow() != null;
        }

        /* renamed from: h */
        public int mo232h() {
            Window w = C0014p.this.getWindow();
            if (w == null) {
                return 0;
            }
            return w.getAttributes().windowAnimations;
        }

        /* renamed from: a */
        public void mo222a(Fragment fragment) {
            C0014p.this.onAttachFragment(fragment);
        }

        /* renamed from: a */
        public View mo221a(int id) {
            return C0014p.this.findViewById(id);
        }

        /* renamed from: a */
        public boolean mo227a() {
            Window w = C0014p.this.getWindow();
            return (w == null || w.peekDecorView() == null) ? false : true;
        }
    }

    /* renamed from: android.support.v4.app.p$b */
    /* compiled from: FragmentActivity */
    static final class C0016b {

        /* renamed from: a */
        Object f21a;

        /* renamed from: b */
        C0165s f22b;

        /* renamed from: c */
        C0419B f23c;

        C0016b() {
        }
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.mFragments.mo5223l();
        int requestIndex = requestCode >> 16;
        if (requestIndex != 0) {
            int requestIndex2 = requestIndex - 1;
            String who = (String) this.mPendingFragmentActivityResults.mo9175b(requestIndex2);
            this.mPendingFragmentActivityResults.mo9181e(requestIndex2);
            String str = TAG;
            if (who == null) {
                Log.w(str, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment targetFragment = this.mFragments.mo5200a(who);
            if (targetFragment == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Activity result no fragment exists for who: ");
                sb.append(who);
                Log.w(str, sb.toString());
            } else {
                targetFragment.onActivityResult(65535 & requestCode, resultCode, data);
            }
            return;
        }
        C0454b delegate = C0453b.m2336a();
        if (delegate == null || !delegate.mo5129a(this, requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onBackPressed() {
        C0486t fragmentManager = this.mFragments.mo5222k();
        boolean isStateSaved = fragmentManager.mo4955e();
        if (!isStateSaved || VERSION.SDK_INT > 25) {
            if (isStateSaved || !fragmentManager.mo4961g()) {
                super.onBackPressed();
            }
        }
    }

    public void supportFinishAfterTransition() {
        C0453b.m2343b(this);
    }

    public void setEnterSharedElementCallback(C0469fa callback) {
        C0453b.m2340a((Activity) this, callback);
    }

    public void setExitSharedElementCallback(C0469fa listener) {
        C0453b.m2344b(this, listener);
    }

    public void supportPostponeEnterTransition() {
        C0453b.m2345c(this);
    }

    public void supportStartPostponedEnterTransition() {
        C0453b.m2346d(this);
    }

    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        this.mFragments.mo5207a(isInMultiWindowMode);
    }

    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        this.mFragments.mo5211b(isInPictureInPictureMode);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mFragments.mo5223l();
        this.mFragments.mo5203a(newConfig);
    }

    public C0165s getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new C0165s();
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public C0148d getLifecycle() {
        return super.getLifecycle();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        C0419B b = null;
        this.mFragments.mo5205a((Fragment) null);
        super.onCreate(savedInstanceState);
        C0016b nc = (C0016b) getLastNonConfigurationInstance();
        if (nc != null) {
            this.mViewModelStore = nc.f22b;
        }
        if (savedInstanceState != null) {
            Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            C0484r rVar = this.mFragments;
            if (nc != null) {
                b = nc.f23c;
            }
            rVar.mo5204a(p, b);
            String str = NEXT_CANDIDATE_REQUEST_INDEX_TAG;
            if (savedInstanceState.containsKey(str)) {
                this.mNextCandidateRequestIndex = savedInstanceState.getInt(str);
                int[] requestCodes = savedInstanceState.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] fragmentWhos = savedInstanceState.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (requestCodes == null || fragmentWhos == null || requestCodes.length != fragmentWhos.length) {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.mPendingFragmentActivityResults = new C1274r<>(requestCodes.length);
                    for (int i = 0; i < requestCodes.length; i++) {
                        this.mPendingFragmentActivityResults.mo9178c(requestCodes[i], fragmentWhos[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new C1274r<>();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.mo5210b();
    }

    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId == 0) {
            return super.onCreatePanelMenu(featureId, menu) | this.mFragments.mo5208a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(featureId, menu);
    }

    /* access modifiers changed from: 0000 */
    public final View dispatchFragmentsOnCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return this.mFragments.mo5201a(parent, name, context, attrs);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        C0165s sVar = this.mViewModelStore;
        if (sVar != null && !this.mRetaining) {
            sVar.mo3773a();
        }
        this.mFragments.mo5214c();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.mo5215d();
    }

    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (super.onMenuItemSelected(featureId, item)) {
            return true;
        }
        if (featureId == 0) {
            return this.mFragments.mo5213b(item);
        }
        if (featureId != 6) {
            return false;
        }
        return this.mFragments.mo5209a(item);
    }

    public void onPanelClosed(int featureId, Menu menu) {
        if (featureId == 0) {
            this.mFragments.mo5206a(menu);
        }
        super.onPanelClosed(featureId, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.mo5216e();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.mo5223l();
    }

    public void onStateNotSaved() {
        this.mFragments.mo5223l();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.mo5221j();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.mo5221j();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragments.mo5218g();
    }

    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (featureId != 0 || menu == null) {
            return super.onPreparePanel(featureId, view, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.mo5212b(menu);
    }

    /* access modifiers changed from: protected */
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object custom = onRetainCustomNonConfigurationInstance();
        C0419B fragments = this.mFragments.mo5224m();
        if (fragments == null && this.mViewModelStore == null && custom == null) {
            return null;
        }
        C0016b nci = new C0016b();
        nci.f21a = custom;
        nci.f22b = this.mViewModelStore;
        nci.f23c = fragments;
        return nci;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        markFragmentsCreated();
        Parcelable p = this.mFragments.mo5225n();
        if (p != null) {
            outState.putParcelable(FRAGMENTS_TAG, p);
        }
        if (this.mPendingFragmentActivityResults.mo9174b() > 0) {
            outState.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] requestCodes = new int[this.mPendingFragmentActivityResults.mo9174b()];
            String[] fragmentWhos = new String[this.mPendingFragmentActivityResults.mo9174b()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.mo9174b(); i++) {
                requestCodes[i] = this.mPendingFragmentActivityResults.mo9180d(i);
                fragmentWhos[i] = (String) this.mPendingFragmentActivityResults.mo9182f(i);
            }
            outState.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, requestCodes);
            outState.putStringArray(REQUEST_FRAGMENT_WHO_TAG, fragmentWhos);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.mo5202a();
        }
        this.mFragments.mo5223l();
        this.mFragments.mo5221j();
        this.mFragments.mo5219h();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.mo5220i();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        C0016b nc = (C0016b) getLastNonConfigurationInstance();
        if (nc != null) {
            return nc.f21a;
        }
        return null;
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        writer.print(prefix);
        writer.print("Local FragmentActivity ");
        writer.print(Integer.toHexString(System.identityHashCode(this)));
        writer.println(" State:");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append("  ");
        String innerPrefix = sb.toString();
        writer.print(innerPrefix);
        writer.print("mCreated=");
        writer.print(this.mCreated);
        writer.print("mResumed=");
        writer.print(this.mResumed);
        writer.print(" mStopped=");
        writer.print(this.mStopped);
        writer.print(" mReallyStopped=");
        writer.println(this.mReallyStopped);
        C0442W w = this.mLoaderManager;
        if (w != null) {
            w.mo5052a(innerPrefix, fd, writer, args);
        }
        this.mFragments.mo5222k().mo4925a(prefix, fd, writer, args);
    }

    /* access modifiers changed from: 0000 */
    public void doReallyStop(boolean retaining) {
        if (!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = retaining;
            this.mHandler.removeMessages(1);
            onReallyStop();
        }
    }

    /* access modifiers changed from: 0000 */
    public void onReallyStop() {
        this.mFragments.mo5217f();
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public C0486t getSupportFragmentManager() {
        return this.mFragments.mo5222k();
    }

    public C0442W getSupportLoaderManager() {
        C0442W w = this.mLoaderManager;
        if (w != null) {
            return w;
        }
        this.mLoaderManager = new LoaderManagerImpl(this, getViewModelStore());
        return this.mLoaderManager;
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        if (!this.mStartedActivityFromFragment && requestCode != -1) {
            C0009h.checkForValidRequestCode(requestCode);
        }
        super.startActivityForResult(intent, requestCode);
    }

    public final void validateRequestPermissionsRequestCode(int requestCode) {
        if (!this.mRequestedPermissionsFromFragment && requestCode != -1) {
            C0009h.checkForValidRequestCode(requestCode);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        this.mFragments.mo5223l();
        int index = (requestCode >> 16) & 65535;
        if (index != 0) {
            int index2 = index - 1;
            String who = (String) this.mPendingFragmentActivityResults.mo9175b(index2);
            this.mPendingFragmentActivityResults.mo9181e(index2);
            String str = TAG;
            if (who == null) {
                Log.w(str, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment frag = this.mFragments.mo5200a(who);
            if (frag == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Activity result no fragment exists for who: ");
                sb.append(who);
                Log.w(str, sb.toString());
            } else {
                frag.onRequestPermissionsResult(65535 & requestCode, permissions, grantResults);
            }
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        startActivityFromFragment(fragment, intent, requestCode, null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, Bundle options) {
        this.mStartedActivityFromFragment = true;
        if (requestCode == -1) {
            try {
                C0453b.m2338a(this, intent, -1, options);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            C0009h.checkForValidRequestCode(requestCode);
            C0453b.m2338a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & requestCode), options);
            this.mStartedActivityFromFragment = false;
        }
    }

    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws SendIntentException {
        int i = requestCode;
        this.mStartedIntentSenderFromFragment = true;
        if (i == -1) {
            try {
                C0453b.m2339a(this, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            C0009h.checkForValidRequestCode(requestCode);
            C0453b.m2339a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & i), fillInIntent, flagsMask, flagsValues, extraFlags, options);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.mo9174b() < MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            while (this.mPendingFragmentActivityResults.mo9177c(this.mNextCandidateRequestIndex) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            }
            int requestIndex = this.mNextCandidateRequestIndex;
            this.mPendingFragmentActivityResults.mo9178c(requestIndex, fragment.mWho);
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            return requestIndex;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    /* access modifiers changed from: 0000 */
    public void requestPermissionsFromFragment(Fragment fragment, String[] permissions, int requestCode) {
        if (requestCode == -1) {
            C0453b.m2341a(this, permissions, requestCode);
            return;
        }
        C0009h.checkForValidRequestCode(requestCode);
        try {
            this.mRequestedPermissionsFromFragment = true;
            C0453b.m2341a(this, permissions, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & requestCode));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), C0149b.CREATED));
    }

    private static boolean markState(C0486t manager, C0149b state) {
        boolean hadNotMarked = false;
        for (Fragment fragment : manager.mo4948d()) {
            if (fragment != null) {
                if (fragment.getLifecycle().mo3750a().mo3753a(C0149b.STARTED)) {
                    fragment.mLifecycleRegistry.mo3754a(state);
                    hadNotMarked = true;
                }
                C0486t childFragmentManager = fragment.peekChildFragmentManager();
                if (childFragmentManager != null) {
                    hadNotMarked |= markState(childFragmentManager, state);
                }
            }
        }
        return hadNotMarked;
    }
}

package android.support.p001v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.app.C0478k;
import android.support.p000v4.app.C0486t;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.preference.C0847y.C0848a;
import android.support.p001v7.preference.C0847y.C0849b;
import android.support.p001v7.preference.C0847y.C0850c;
import android.support.p001v7.preference.DialogPreference.C0801a;
import android.support.p001v7.preference.PreferenceGroup.C0815b;
import android.support.p001v7.preference.internal.AbstractMultiSelectListPreference;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C0972c;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v7.preference.s */
/* compiled from: PreferenceFragmentCompat */
public abstract class C0835s extends Fragment implements C0850c, C0848a, C0849b, C0801a {
    public static final String ARG_PREFERENCE_ROOT = "android.support.v7.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "android.support.v7.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private final C0836a mDividerDecoration = new C0836a(this, null);
    private Handler mHandler = new C0832p(this);
    private boolean mHavePrefs;
    private boolean mInitDone;
    private int mLayoutResId = C0803F.preference_list_fragment;
    /* access modifiers changed from: private */
    public RecyclerView mList;
    private C0847y mPreferenceManager;
    private final Runnable mRequestFocus = new C0833q(this);
    private Runnable mSelectPreferenceRunnable;
    private Context mStyledContext;

    /* renamed from: android.support.v7.preference.s$a */
    /* compiled from: PreferenceFragmentCompat */
    private class C0836a extends C0980h {

        /* renamed from: a */
        private Drawable f2519a;

        /* renamed from: b */
        private int f2520b;

        /* renamed from: c */
        private boolean f2521c;

        private C0836a() {
            this.f2521c = true;
        }

        /* synthetic */ C0836a(C0835s x0, C0832p x1) {
            this();
        }

        public void onDrawOver(Canvas c, RecyclerView parent, C0997t state) {
            if (this.f2519a != null) {
                int childCount = parent.getChildCount();
                int width = parent.getWidth();
                for (int childViewIndex = 0; childViewIndex < childCount; childViewIndex++) {
                    View view = parent.getChildAt(childViewIndex);
                    if (m3946a(view, parent)) {
                        int top = ((int) view.getY()) + view.getHeight();
                        this.f2519a.setBounds(0, top, width, this.f2520b + top);
                        this.f2519a.draw(c);
                    }
                }
            }
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, C0997t state) {
            if (m3946a(view, parent)) {
                outRect.bottom = this.f2520b;
            }
        }

        /* renamed from: a */
        private boolean m3946a(View view, RecyclerView parent) {
            C1000w holder = parent.mo7616i(view);
            boolean z = false;
            if (!((holder instanceof C0796B) && ((C0796B) holder).mo6287i())) {
                return false;
            }
            boolean nextAllowed = this.f2521c;
            int index = parent.indexOfChild(view);
            if (index < parent.getChildCount() - 1) {
                C1000w nextHolder = parent.mo7616i(parent.getChildAt(index + 1));
                if ((nextHolder instanceof C0796B) && ((C0796B) nextHolder).mo6286h()) {
                    z = true;
                }
                nextAllowed = z;
            }
            return nextAllowed;
        }

        /* renamed from: a */
        public void mo6472a(Drawable divider) {
            if (divider != null) {
                this.f2520b = divider.getIntrinsicHeight();
            } else {
                this.f2520b = 0;
            }
            this.f2519a = divider;
            C0835s.this.mList.mo7633o();
        }

        /* renamed from: a */
        public void mo6471a(int dividerHeight) {
            this.f2520b = dividerHeight;
            C0835s.this.mList.mo7633o();
        }

        /* renamed from: b */
        public void mo6473b(boolean allowDividerAfterLastItem) {
            this.f2521c = allowDividerAfterLastItem;
        }
    }

    /* renamed from: android.support.v7.preference.s$b */
    /* compiled from: PreferenceFragmentCompat */
    public interface C0837b {
        /* renamed from: a */
        boolean mo6476a(C0835s sVar, Preference preference);
    }

    /* renamed from: android.support.v7.preference.s$c */
    /* compiled from: PreferenceFragmentCompat */
    public interface C0838c {
        /* renamed from: a */
        boolean mo6477a(C0835s sVar, Preference preference);
    }

    /* renamed from: android.support.v7.preference.s$d */
    /* compiled from: PreferenceFragmentCompat */
    public interface C0839d {
        /* renamed from: a */
        boolean mo6478a(C0835s sVar, PreferenceScreen preferenceScreen);
    }

    /* renamed from: android.support.v7.preference.s$e */
    /* compiled from: PreferenceFragmentCompat */
    private static class C0840e extends C0972c {

        /* renamed from: a */
        private final C0970a f2523a;

        /* renamed from: b */
        private final RecyclerView f2524b;

        /* renamed from: c */
        private final Preference f2525c;

        /* renamed from: d */
        private final String f2526d;

        public C0840e(C0970a adapter, RecyclerView list, Preference preference, String key) {
            this.f2523a = adapter;
            this.f2524b = list;
            this.f2525c = preference;
            this.f2526d = key;
        }

        /* renamed from: a */
        private void m3953a() {
            int position;
            this.f2523a.unregisterAdapterDataObserver(this);
            Preference preference = this.f2525c;
            if (preference != null) {
                position = ((C0815b) this.f2523a).mo6403b(preference);
            } else {
                position = ((C0815b) this.f2523a).mo6402a(this.f2526d);
            }
            if (position != -1) {
                this.f2524b.mo7618i(position);
            }
        }

        public void onChanged() {
            m3953a();
        }

        public void onItemRangeChanged(int positionStart, int itemCount) {
            m3953a();
        }

        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            m3953a();
        }

        public void onItemRangeInserted(int positionStart, int itemCount) {
            m3953a();
        }

        public void onItemRangeRemoved(int positionStart, int itemCount) {
            m3953a();
        }

        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            m3953a();
        }
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public void onCreate(Bundle savedInstanceState) {
        String rootKey;
        super.onCreate(savedInstanceState);
        TypedValue tv = new TypedValue();
        getActivity().getTheme().resolveAttribute(C0797C.preferenceTheme, tv, true);
        int theme = tv.resourceId;
        if (theme != 0) {
            this.mStyledContext = new ContextThemeWrapper(getActivity(), theme);
            this.mPreferenceManager = new C0847y(this.mStyledContext);
            this.mPreferenceManager.mo6510a((C0849b) this);
            if (getArguments() != null) {
                rootKey = getArguments().getString(ARG_PREFERENCE_ROOT);
            } else {
                rootKey = null;
            }
            onCreatePreferences(savedInstanceState, rootKey);
            return;
        }
        throw new IllegalStateException("Must specify preferenceTheme in theme");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TypedArray a = this.mStyledContext.obtainStyledAttributes(null, C0805H.PreferenceFragmentCompat, C0797C.preferenceFragmentCompatStyle, 0);
        this.mLayoutResId = a.getResourceId(C0805H.PreferenceFragmentCompat_android_layout, this.mLayoutResId);
        Drawable divider = a.getDrawable(C0805H.PreferenceFragmentCompat_android_divider);
        int dividerHeight = a.getDimensionPixelSize(C0805H.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean allowDividerAfterLastItem = a.getBoolean(C0805H.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        a.recycle();
        TypedValue tv = new TypedValue();
        getActivity().getTheme().resolveAttribute(C0797C.preferenceTheme, tv, true);
        LayoutInflater themedInflater = inflater.cloneInContext(new ContextThemeWrapper(inflater.getContext(), tv.resourceId));
        View view = themedInflater.inflate(this.mLayoutResId, container, false);
        View rawListContainer = view.findViewById(16908351);
        if (rawListContainer instanceof ViewGroup) {
            ViewGroup listContainer = (ViewGroup) rawListContainer;
            RecyclerView listView = onCreateRecyclerView(themedInflater, listContainer, savedInstanceState);
            if (listView != null) {
                this.mList = listView;
                TypedArray typedArray = a;
                listView.mo7527a((C0980h) this.mDividerDecoration);
                setDivider(divider);
                if (dividerHeight != -1) {
                    setDividerHeight(dividerHeight);
                }
                this.mDividerDecoration.mo6473b(allowDividerAfterLastItem);
                listContainer.addView(this.mList);
                Drawable drawable = divider;
                this.mHandler.post(this.mRequestFocus);
                return view;
            }
            Drawable drawable2 = divider;
            throw new RuntimeException("Could not create RecyclerView");
        }
        Bundle bundle = savedInstanceState;
        TypedArray typedArray2 = a;
        Drawable drawable3 = divider;
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    public void setDivider(Drawable divider) {
        this.mDividerDecoration.mo6472a(divider);
    }

    public void setDividerHeight(int height) {
        this.mDividerDecoration.mo6471a(height);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (this.mHavePrefs) {
            bindPreferences();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            Bundle container = savedInstanceState.getBundle(PREFERENCES_TAG);
            if (container != null) {
                PreferenceScreen preferenceScreen = getPreferenceScreen();
                if (preferenceScreen != null) {
                    preferenceScreen.mo6363c(container);
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        this.mPreferenceManager.mo6511a((C0850c) this);
        this.mPreferenceManager.mo6509a((C0848a) this);
    }

    public void onStop() {
        super.onStop();
        this.mPreferenceManager.mo6511a((C0850c) null);
        this.mPreferenceManager.mo6509a((C0848a) null);
    }

    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            unbindPreferences();
        }
        this.mList = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle container = new Bundle();
            preferenceScreen.mo6368d(container);
            outState.putBundle(PREFERENCES_TAG, container);
        }
    }

    public C0847y getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (this.mPreferenceManager.mo6513a(preferenceScreen) && preferenceScreen != null) {
            onUnbindPreferences();
            this.mHavePrefs = true;
            if (this.mInitDone) {
                postBindPreferences();
            }
        }
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.mo6519g();
    }

    public void addPreferencesFromResource(int preferencesResId) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.mo6507a(this.mStyledContext, preferencesResId, getPreferenceScreen()));
    }

    public void setPreferencesFromResource(int preferencesResId, String key) {
        Object obj;
        requirePreferenceManager();
        PreferenceGroup a = this.mPreferenceManager.mo6507a(this.mStyledContext, preferencesResId, null);
        if (key != null) {
            obj = a.mo6397c((CharSequence) key);
            if (!(obj instanceof PreferenceScreen)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Preference object with key ");
                sb.append(key);
                sb.append(" is not a PreferenceScreen");
                throw new IllegalArgumentException(sb.toString());
            }
        } else {
            obj = a;
        }
        setPreferenceScreen((PreferenceScreen) obj);
    }

    public boolean onPreferenceTreeClick(Preference preference) {
        if (preference.mo6379j() == null) {
            return false;
        }
        boolean handled = false;
        if (getCallbackFragment() instanceof C0838c) {
            handled = ((C0838c) getCallbackFragment()).mo6477a(this, preference);
        }
        if (!handled && (getActivity() instanceof C0838c)) {
            handled = ((C0838c) getActivity()).mo6477a(this, preference);
        }
        return handled;
    }

    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        boolean handled = false;
        if (getCallbackFragment() instanceof C0839d) {
            handled = ((C0839d) getCallbackFragment()).mo6478a(this, preferenceScreen);
        }
        if (!handled && (getActivity() instanceof C0839d)) {
            ((C0839d) getActivity()).mo6478a(this, preferenceScreen);
        }
    }

    public Preference findPreference(CharSequence key) {
        C0847y yVar = this.mPreferenceManager;
        if (yVar == null) {
            return null;
        }
        return yVar.mo6506a(key);
    }

    private void requirePreferenceManager() {
        if (this.mPreferenceManager == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void postBindPreferences() {
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.obtainMessage(1).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    public void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(onCreateAdapter(preferenceScreen));
            preferenceScreen.mo6334J();
        }
        onBindPreferences();
    }

    private void unbindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.mo6335L();
        }
        onUnbindPreferences();
    }

    /* access modifiers changed from: protected */
    public void onBindPreferences() {
    }

    /* access modifiers changed from: protected */
    public void onUnbindPreferences() {
    }

    public final RecyclerView getListView() {
        return this.mList;
    }

    public RecyclerView onCreateRecyclerView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(C0803F.preference_recyclerview, parent, false);
        recyclerView.setLayoutManager(onCreateLayoutManager());
        recyclerView.setAccessibilityDelegateCompat(new C0795A(recyclerView));
        return recyclerView;
    }

    public C0981i onCreateLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    /* access modifiers changed from: protected */
    public C0970a onCreateAdapter(PreferenceScreen preferenceScreen) {
        return new C0844w(preferenceScreen);
    }

    public void onDisplayPreferenceDialog(Preference preference) {
        C0478k f;
        boolean handled = false;
        if (getCallbackFragment() instanceof C0837b) {
            handled = ((C0837b) getCallbackFragment()).mo6476a(this, preference);
        }
        if (!handled && (getActivity() instanceof C0837b)) {
            handled = ((C0837b) getActivity()).mo6476a(this, preference);
        }
        if (!handled) {
            C0486t fragmentManager = getFragmentManager();
            String str = DIALOG_FRAGMENT_TAG;
            if (fragmentManager.mo4908a(str) == null) {
                if (preference instanceof EditTextPreference) {
                    f = C0822f.newInstance(preference.mo6381t());
                } else if (preference instanceof ListPreference) {
                    f = C0825i.newInstance(preference.mo6381t());
                } else if (preference instanceof AbstractMultiSelectListPreference) {
                    f = C0827k.newInstance(preference.mo6381t());
                } else {
                    throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
                }
                f.setTargetFragment(this, 0);
                f.show(getFragmentManager(), str);
            }
        }
    }

    public Fragment getCallbackFragment() {
        return null;
    }

    public void scrollToPreference(String key) {
        scrollToPreferenceInternal(null, key);
    }

    public void scrollToPreference(Preference preference) {
        scrollToPreferenceInternal(preference, null);
    }

    private void scrollToPreferenceInternal(Preference preference, String key) {
        Runnable r = new C0834r(this, preference, key);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = r;
        } else {
            r.run();
        }
    }
}

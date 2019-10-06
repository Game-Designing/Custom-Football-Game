package android.support.p001v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.content.p036a.C0509e;
import android.support.p000v4.view.p038a.C0604b;
import android.support.p001v7.preference.C0847y.C0850c;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: android.support.v7.preference.Preference */
public class Preference implements Comparable<Preference> {

    /* renamed from: A */
    private boolean f2419A;

    /* renamed from: B */
    private boolean f2420B;

    /* renamed from: C */
    private boolean f2421C;

    /* renamed from: D */
    private boolean f2422D;

    /* renamed from: E */
    private boolean f2423E;

    /* renamed from: F */
    private int f2424F;

    /* renamed from: G */
    private int f2425G;

    /* renamed from: H */
    private C0811a f2426H;

    /* renamed from: I */
    private List<Preference> f2427I;

    /* renamed from: J */
    private PreferenceGroup f2428J;

    /* renamed from: K */
    private boolean f2429K;

    /* renamed from: L */
    private boolean f2430L;

    /* renamed from: M */
    private final OnClickListener f2431M;

    /* renamed from: a */
    private Context f2432a;

    /* renamed from: b */
    private C0847y f2433b;

    /* renamed from: c */
    private C0830n f2434c;

    /* renamed from: d */
    private long f2435d;

    /* renamed from: e */
    private boolean f2436e;

    /* renamed from: f */
    private C0812b f2437f;

    /* renamed from: g */
    private C0813c f2438g;

    /* renamed from: h */
    private int f2439h;

    /* renamed from: i */
    private int f2440i;

    /* renamed from: j */
    private CharSequence f2441j;

    /* renamed from: k */
    private CharSequence f2442k;

    /* renamed from: l */
    private int f2443l;

    /* renamed from: m */
    private Drawable f2444m;

    /* renamed from: n */
    private String f2445n;

    /* renamed from: o */
    private Intent f2446o;

    /* renamed from: p */
    private String f2447p;

    /* renamed from: q */
    private Bundle f2448q;

    /* renamed from: r */
    private boolean f2449r;

    /* renamed from: s */
    private boolean f2450s;

    /* renamed from: t */
    private boolean f2451t;

    /* renamed from: u */
    private String f2452u;

    /* renamed from: v */
    private Object f2453v;

    /* renamed from: w */
    private boolean f2454w;

    /* renamed from: x */
    private boolean f2455x;

    /* renamed from: y */
    private boolean f2456y;

    /* renamed from: z */
    private boolean f2457z;

    /* renamed from: android.support.v7.preference.Preference$BaseSavedState */
    public static class BaseSavedState extends AbsSavedState {
        public static final Creator<BaseSavedState> CREATOR = new C0829m();

        public BaseSavedState(Parcel source) {
            super(source);
        }

        public BaseSavedState(Parcelable superState) {
            super(superState);
        }
    }

    /* renamed from: android.support.v7.preference.Preference$a */
    interface C0811a {
        /* renamed from: a */
        void mo6388a(Preference preference);

        /* renamed from: c */
        void mo6389c(Preference preference);

        /* renamed from: d */
        void mo6390d(Preference preference);
    }

    /* renamed from: android.support.v7.preference.Preference$b */
    public interface C0812b {
        /* renamed from: a */
        boolean mo6391a(Preference preference, Object obj);
    }

    /* renamed from: android.support.v7.preference.Preference$c */
    public interface C0813c {
        boolean onPreferenceClick(Preference preference);
    }

    public Preference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.f2439h = MoPubClientPositioning.NO_REPEAT;
        this.f2440i = 0;
        this.f2449r = true;
        this.f2450s = true;
        this.f2451t = true;
        this.f2454w = true;
        this.f2455x = true;
        this.f2456y = true;
        this.f2457z = true;
        this.f2419A = true;
        this.f2421C = true;
        this.f2423E = true;
        this.f2424F = C0803F.preference;
        this.f2431M = new C0828l(this);
        this.f2432a = context;
        TypedArray a = context.obtainStyledAttributes(attrs, C0805H.Preference, defStyleAttr, defStyleRes);
        this.f2443l = C0509e.m2557b(a, C0805H.Preference_icon, C0805H.Preference_android_icon, 0);
        this.f2445n = C0509e.m2560b(a, C0805H.Preference_key, C0805H.Preference_android_key);
        this.f2441j = C0509e.m2562c(a, C0805H.Preference_title, C0805H.Preference_android_title);
        this.f2442k = C0509e.m2562c(a, C0805H.Preference_summary, C0805H.Preference_android_summary);
        this.f2439h = C0509e.m2549a(a, C0805H.Preference_order, C0805H.Preference_android_order, (int) MoPubClientPositioning.NO_REPEAT);
        this.f2447p = C0509e.m2560b(a, C0805H.Preference_fragment, C0805H.Preference_android_fragment);
        this.f2424F = C0509e.m2557b(a, C0805H.Preference_layout, C0805H.Preference_android_layout, C0803F.preference);
        this.f2425G = C0509e.m2557b(a, C0805H.Preference_widgetLayout, C0805H.Preference_android_widgetLayout, 0);
        this.f2449r = C0509e.m2554a(a, C0805H.Preference_enabled, C0805H.Preference_android_enabled, true);
        this.f2450s = C0509e.m2554a(a, C0805H.Preference_selectable, C0805H.Preference_android_selectable, true);
        this.f2451t = C0509e.m2554a(a, C0805H.Preference_persistent, C0805H.Preference_android_persistent, true);
        this.f2452u = C0509e.m2560b(a, C0805H.Preference_dependency, C0805H.Preference_android_dependency);
        int i = C0805H.Preference_allowDividerAbove;
        this.f2457z = C0509e.m2554a(a, i, i, this.f2450s);
        int i2 = C0805H.Preference_allowDividerBelow;
        this.f2419A = C0509e.m2554a(a, i2, i2, this.f2450s);
        if (a.hasValue(C0805H.Preference_defaultValue)) {
            this.f2453v = mo4891a(a, C0805H.Preference_defaultValue);
        } else if (a.hasValue(C0805H.Preference_android_defaultValue)) {
            this.f2453v = mo4891a(a, C0805H.Preference_android_defaultValue);
        }
        this.f2423E = C0509e.m2554a(a, C0805H.Preference_shouldDisableView, C0805H.Preference_android_shouldDisableView, true);
        this.f2420B = a.hasValue(C0805H.Preference_singleLineTitle);
        if (this.f2420B) {
            this.f2421C = C0509e.m2554a(a, C0805H.Preference_singleLineTitle, C0805H.Preference_android_singleLineTitle, true);
        }
        this.f2422D = C0509e.m2554a(a, C0805H.Preference_iconSpaceReserved, C0805H.Preference_android_iconSpaceReserved, false);
        a.recycle();
    }

    public Preference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public Preference(Context context, AttributeSet attrs) {
        this(context, attrs, C0509e.m2548a(context, C0797C.preferenceStyle, 16842894));
    }

    public Preference(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo4891a(TypedArray a, int index) {
        return null;
    }

    /* renamed from: a */
    public void mo6343a(Intent intent) {
        this.f2446o = intent;
    }

    /* renamed from: s */
    public Intent mo6380s() {
        return this.f2446o;
    }

    /* renamed from: j */
    public String mo6379j() {
        return this.f2447p;
    }

    /* renamed from: w */
    public C0830n mo6385w() {
        C0830n nVar = this.f2434c;
        if (nVar != null) {
            return nVar;
        }
        C0847y yVar = this.f2433b;
        if (yVar != null) {
            return yVar.mo6518f();
        }
        return null;
    }

    /* renamed from: g */
    public Bundle mo6375g() {
        if (this.f2448q == null) {
            this.f2448q = new Bundle();
        }
        return this.f2448q;
    }

    /* renamed from: d */
    public void mo6367d(int layoutResId) {
        this.f2424F = layoutResId;
    }

    /* renamed from: u */
    public final int mo6383u() {
        return this.f2424F;
    }

    /* renamed from: B */
    public final int mo6327B() {
        return this.f2425G;
    }

    /* renamed from: a */
    public void mo4896a(C0796B holder) {
        holder.itemView.setOnClickListener(this.f2431M);
        holder.itemView.setId(this.f2440i);
        TextView titleView = (TextView) holder.mo6283a(16908310);
        int i = 8;
        if (titleView != null) {
            CharSequence title = mo6326A();
            if (!TextUtils.isEmpty(title)) {
                titleView.setText(title);
                titleView.setVisibility(0);
                if (this.f2420B) {
                    titleView.setSingleLine(this.f2421C);
                }
            } else {
                titleView.setVisibility(8);
            }
        }
        TextView summaryView = (TextView) holder.mo6283a(16908304);
        if (summaryView != null) {
            CharSequence summary = mo6322z();
            if (!TextUtils.isEmpty(summary)) {
                summaryView.setText(summary);
                summaryView.setVisibility(0);
            } else {
                summaryView.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) holder.mo6283a(16908294);
        if (imageView != null) {
            if (!(this.f2443l == 0 && this.f2444m == null)) {
                if (this.f2444m == null) {
                    this.f2444m = C0510b.m2572c(mo6373f(), this.f2443l);
                }
                Drawable drawable = this.f2444m;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.f2444m != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.f2422D ? 4 : 8);
            }
        }
        View imageFrame = holder.mo6283a(C0802E.icon_frame);
        if (imageFrame == null) {
            imageFrame = holder.mo6283a(16908350);
        }
        if (imageFrame != null) {
            if (this.f2444m != null) {
                imageFrame.setVisibility(0);
            } else {
                if (this.f2422D) {
                    i = 4;
                }
                imageFrame.setVisibility(i);
            }
        }
        if (this.f2423E) {
            m3766a(holder.itemView, mo6329D());
        } else {
            m3766a(holder.itemView, true);
        }
        boolean selectable = mo6331F();
        holder.itemView.setFocusable(selectable);
        holder.itemView.setClickable(selectable);
        holder.mo6284a(this.f2457z);
        holder.mo6285b(this.f2419A);
    }

    /* renamed from: a */
    private void m3766a(View v, boolean enabled) {
        v.setEnabled(enabled);
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            for (int i = vg.getChildCount() - 1; i >= 0; i--) {
                m3766a(vg.getChildAt(i), enabled);
            }
        }
    }

    /* renamed from: e */
    public void mo6371e(int order) {
        if (order != this.f2439h) {
            this.f2439h = order;
            mo6333I();
        }
    }

    /* renamed from: v */
    public int mo6384v() {
        return this.f2439h;
    }

    /* renamed from: b */
    public void mo6358b(CharSequence title) {
        if ((title == null && this.f2441j != null) || (title != null && !title.equals(this.f2441j))) {
            this.f2441j = title;
            mo6302H();
        }
    }

    /* renamed from: f */
    public void mo6374f(int titleResId) {
        mo6358b((CharSequence) this.f2432a.getString(titleResId));
    }

    /* renamed from: A */
    public CharSequence mo6326A() {
        return this.f2441j;
    }

    /* renamed from: a */
    public void mo6344a(Drawable icon) {
        if ((icon == null && this.f2444m != null) || (icon != null && this.f2444m != icon)) {
            this.f2444m = icon;
            this.f2443l = 0;
            mo6302H();
        }
    }

    /* renamed from: c */
    public void mo6362c(int iconResId) {
        mo6344a(C0510b.m2572c(this.f2432a, iconResId));
        this.f2443l = iconResId;
    }

    /* renamed from: z */
    public CharSequence mo6322z() {
        return this.f2442k;
    }

    /* renamed from: a */
    public void mo6318a(CharSequence summary) {
        if ((summary == null && this.f2442k != null) || (summary != null && !summary.equals(this.f2442k))) {
            this.f2442k = summary;
            mo6302H();
        }
    }

    /* renamed from: d */
    public void mo6369d(boolean enabled) {
        if (this.f2449r != enabled) {
            this.f2449r = enabled;
            mo6359b(mo6305P());
            mo6302H();
        }
    }

    /* renamed from: D */
    public boolean mo6329D() {
        return this.f2449r && this.f2454w && this.f2455x;
    }

    /* renamed from: F */
    public boolean mo6331F() {
        return this.f2450s;
    }

    /* renamed from: e */
    public final void mo6372e(boolean visible) {
        if (this.f2456y != visible) {
            this.f2456y = visible;
            C0811a aVar = this.f2426H;
            if (aVar != null) {
                aVar.mo6388a(this);
            }
        }
    }

    /* renamed from: G */
    public final boolean mo6332G() {
        return this.f2456y;
    }

    /* access modifiers changed from: 0000 */
    public long getId() {
        return this.f2435d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: K */
    public void mo6294K() {
    }

    /* renamed from: t */
    public String mo6381t() {
        return this.f2445n;
    }

    /* renamed from: C */
    public boolean mo6328C() {
        return !TextUtils.isEmpty(this.f2445n);
    }

    /* renamed from: E */
    public boolean mo6330E() {
        return this.f2451t;
    }

    /* access modifiers changed from: protected */
    /* renamed from: Q */
    public boolean mo6338Q() {
        return this.f2433b != null && mo6330E() && mo6328C();
    }

    /* renamed from: a */
    public boolean mo6353a(Object newValue) {
        C0812b bVar = this.f2437f;
        return bVar == null || bVar.mo6391a(this, newValue);
    }

    /* renamed from: a */
    public void mo6348a(C0813c onPreferenceClickListener) {
        this.f2438g = onPreferenceClickListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4897a(View view) {
        mo6337O();
    }

    /* renamed from: O */
    public void mo6337O() {
        if (mo6329D()) {
            mo6294K();
            C0813c cVar = this.f2438g;
            if (cVar == null || !cVar.onPreferenceClick(this)) {
                C0847y preferenceManager = mo6386x();
                if (preferenceManager != null) {
                    C0850c listener = preferenceManager.mo6516d();
                    if (listener != null && listener.onPreferenceTreeClick(this)) {
                        return;
                    }
                }
                if (this.f2446o != null) {
                    mo6373f().startActivity(this.f2446o);
                }
            }
        }
    }

    /* renamed from: f */
    public Context mo6373f() {
        return this.f2432a;
    }

    /* renamed from: y */
    public SharedPreferences mo6387y() {
        if (this.f2433b == null || mo6385w() != null) {
            return null;
        }
        return this.f2433b.mo6520h();
    }

    /* renamed from: a */
    public int compareTo(Preference another) {
        int i = this.f2439h;
        int i2 = another.f2439h;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.f2441j;
        CharSequence charSequence2 = another.f2441j;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(another.f2441j.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo6347a(C0811a listener) {
        this.f2426H = listener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public void mo6302H() {
        C0811a aVar = this.f2426H;
        if (aVar != null) {
            aVar.mo6389c(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: I */
    public void mo6333I() {
        C0811a aVar = this.f2426H;
        if (aVar != null) {
            aVar.mo6390d(this);
        }
    }

    /* renamed from: x */
    public C0847y mo6386x() {
        return this.f2433b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6351a(C0847y preferenceManager) {
        this.f2433b = preferenceManager;
        if (!this.f2436e) {
            this.f2435d = preferenceManager.mo6514b();
        }
        mo6295R();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6352a(C0847y preferenceManager, long id) {
        this.f2435d = id;
        this.f2436e = true;
        try {
            mo6351a(preferenceManager);
        } finally {
            this.f2436e = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6350a(PreferenceGroup parentGroup) {
        this.f2428J = parentGroup;
    }

    /* renamed from: J */
    public void mo6334J() {
        mo6296S();
    }

    /* renamed from: L */
    public void mo6335L() {
        mo6297T();
        this.f2429K = true;
    }

    /* renamed from: e */
    public final void mo6370e() {
        this.f2429K = false;
    }

    /* renamed from: S */
    private void mo6296S() {
        if (!TextUtils.isEmpty(this.f2452u)) {
            Preference preference = mo6341a(this.f2452u);
            if (preference != null) {
                preference.mo6396b(this);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Dependency \"");
            sb.append(this.f2452u);
            sb.append("\" not found for preference \"");
            sb.append(this.f2445n);
            sb.append("\" (title: \"");
            sb.append(this.f2441j);
            sb.append("\"");
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: T */
    private void mo6297T() {
        String str = this.f2452u;
        if (str != null) {
            Preference oldDependency = mo6341a(str);
            if (oldDependency != null) {
                oldDependency.mo6398c(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Preference mo6341a(String key) {
        if (!TextUtils.isEmpty(key)) {
            C0847y yVar = this.f2433b;
            if (yVar != null) {
                return yVar.mo6506a((CharSequence) key);
            }
        }
        return null;
    }

    /* renamed from: b */
    private void mo6396b(Preference dependent) {
        if (this.f2427I == null) {
            this.f2427I = new ArrayList();
        }
        this.f2427I.add(dependent);
        dependent.mo6349a(this, mo6305P());
    }

    /* renamed from: c */
    private void mo6398c(Preference dependent) {
        List<Preference> list = this.f2427I;
        if (list != null) {
            list.remove(dependent);
        }
    }

    /* renamed from: b */
    public void mo6359b(boolean disableDependents) {
        List<Preference> dependents = this.f2427I;
        if (dependents != null) {
            int dependentsCount = dependents.size();
            for (int i = 0; i < dependentsCount; i++) {
                ((Preference) dependents.get(i)).mo6349a(this, disableDependents);
            }
        }
    }

    /* renamed from: a */
    public void mo6349a(Preference dependency, boolean disableDependent) {
        if (this.f2454w == disableDependent) {
            this.f2454w = !disableDependent;
            mo6359b(mo6305P());
            mo6302H();
        }
    }

    /* renamed from: b */
    public void mo6357b(Preference parent, boolean disableChild) {
        if (this.f2455x == disableChild) {
            this.f2455x = !disableChild;
            mo6359b(mo6305P());
            mo6302H();
        }
    }

    /* renamed from: P */
    public boolean mo6305P() {
        return !mo6329D();
    }

    public PreferenceGroup getParent() {
        return this.f2428J;
    }

    /* access modifiers changed from: protected */
    /* renamed from: M */
    public void mo6336M() {
        mo6297T();
    }

    /* renamed from: R */
    private void mo6295R() {
        if (mo6385w() != null) {
            mo4893a(true, this.f2453v);
            return;
        }
        if (!mo6338Q() || !mo6387y().contains(this.f2445n)) {
            Object obj = this.f2453v;
            if (obj != null) {
                mo4893a(false, obj);
            }
        } else {
            mo4893a(true, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4893a(boolean restorePersistedValue, Object defaultValue) {
    }

    /* renamed from: a */
    private void m3765a(Editor editor) {
        if (this.f2433b.mo6521i()) {
            editor.apply();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo6364c(String value) {
        if (!mo6338Q()) {
            return false;
        }
        if (TextUtils.equals(value, mo6355b((String) null))) {
            return true;
        }
        C0830n dataStore = mo6385w();
        if (dataStore != null) {
            dataStore.mo6442b(this.f2445n, value);
        } else {
            Editor editor = this.f2433b.mo6505a();
            editor.putString(this.f2445n, value);
            m3765a(editor);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo6355b(String defaultReturnValue) {
        if (!mo6338Q()) {
            return defaultReturnValue;
        }
        C0830n dataStore = mo6385w();
        if (dataStore != null) {
            return dataStore.mo6438a(this.f2445n, defaultReturnValue);
        }
        return this.f2433b.mo6520h().getString(this.f2445n, defaultReturnValue);
    }

    /* renamed from: b */
    public boolean mo6361b(Set<String> values) {
        if (!mo6338Q()) {
            return false;
        }
        if (values.equals(mo6342a(null))) {
            return true;
        }
        C0830n dataStore = mo6385w();
        if (dataStore != null) {
            dataStore.mo6443b(this.f2445n, values);
        } else {
            Editor editor = this.f2433b.mo6505a();
            editor.putStringSet(this.f2445n, values);
            m3765a(editor);
        }
        return true;
    }

    /* renamed from: a */
    public Set<String> mo6342a(Set<String> defaultReturnValue) {
        if (!mo6338Q()) {
            return defaultReturnValue;
        }
        C0830n dataStore = mo6385w();
        if (dataStore != null) {
            return dataStore.mo6439a(this.f2445n, defaultReturnValue);
        }
        return this.f2433b.mo6520h().getStringSet(this.f2445n, defaultReturnValue);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo6360b(int value) {
        if (!mo6338Q()) {
            return false;
        }
        if (value == mo6339a(value ^ -1)) {
            return true;
        }
        C0830n dataStore = mo6385w();
        if (dataStore != null) {
            dataStore.mo6441b(this.f2445n, value);
        } else {
            Editor editor = this.f2433b.mo6505a();
            editor.putInt(this.f2445n, value);
            m3765a(editor);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo6339a(int defaultReturnValue) {
        if (!mo6338Q()) {
            return defaultReturnValue;
        }
        C0830n dataStore = mo6385w();
        if (dataStore != null) {
            return dataStore.mo6437a(this.f2445n, defaultReturnValue);
        }
        return this.f2433b.mo6520h().getInt(this.f2445n, defaultReturnValue);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo6365c(boolean value) {
        if (!mo6338Q()) {
            return false;
        }
        if (value == mo6354a(!value)) {
            return true;
        }
        C0830n dataStore = mo6385w();
        if (dataStore != null) {
            dataStore.mo6444b(this.f2445n, value);
        } else {
            Editor editor = this.f2433b.mo6505a();
            editor.putBoolean(this.f2445n, value);
            m3765a(editor);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6354a(boolean defaultReturnValue) {
        if (!mo6338Q()) {
            return defaultReturnValue;
        }
        C0830n dataStore = mo6385w();
        if (dataStore != null) {
            return dataStore.mo6440a(this.f2445n, defaultReturnValue);
        }
        return this.f2433b.mo6520h().getBoolean(this.f2445n, defaultReturnValue);
    }

    public String toString() {
        return mo6378i().toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public StringBuilder mo6378i() {
        StringBuilder sb = new StringBuilder();
        CharSequence title = mo6326A();
        if (!TextUtils.isEmpty(title)) {
            sb.append(title);
            sb.append(' ');
        }
        CharSequence summary = mo6322z();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    /* renamed from: d */
    public void mo6368d(Bundle container) {
        mo6356b(container);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo6356b(Bundle container) {
        if (mo6328C()) {
            this.f2430L = false;
            Parcelable state = mo4887N();
            if (!this.f2430L) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (state != null) {
                container.putParcelable(this.f2445n, state);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public Parcelable mo4887N() {
        this.f2430L = true;
        return AbsSavedState.EMPTY_STATE;
    }

    /* renamed from: c */
    public void mo6363c(Bundle container) {
        mo6345a(container);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6345a(Bundle container) {
        if (mo6328C()) {
            Parcelable state = container.getParcelable(this.f2445n);
            if (state != null) {
                this.f2430L = false;
                mo4892a(state);
                if (!this.f2430L) {
                    throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4892a(Parcelable state) {
        this.f2430L = true;
        if (state != AbsSavedState.EMPTY_STATE && state != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    /* renamed from: a */
    public void mo6346a(C0604b info) {
    }
}

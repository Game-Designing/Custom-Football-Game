package android.support.p001v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.p000v4.content.p036a.C0509e;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p002b.p003c.p053g.p061f.C1273q;

/* renamed from: android.support.v7.preference.PreferenceGroup */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: N */
    private List<Preference> f2458N;

    /* renamed from: O */
    private boolean f2459O;

    /* renamed from: P */
    private int f2460P;

    /* renamed from: Q */
    private boolean f2461Q;

    /* renamed from: R */
    private int f2462R;

    /* renamed from: S */
    private C0814a f2463S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public final C1273q<String, Long> f2464T;

    /* renamed from: U */
    private final Handler f2465U;

    /* renamed from: V */
    private final Runnable f2466V;

    /* renamed from: android.support.v7.preference.PreferenceGroup$a */
    interface C0814a {
        /* renamed from: a */
        Parcelable mo6289a(Parcelable parcelable);

        /* renamed from: b */
        Parcelable mo6292b(Parcelable parcelable);
    }

    /* renamed from: android.support.v7.preference.PreferenceGroup$b */
    public interface C0815b {
        /* renamed from: a */
        int mo6402a(String str);

        /* renamed from: b */
        int mo6403b(Preference preference);
    }

    public PreferenceGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.f2459O = true;
        this.f2460P = 0;
        this.f2461Q = false;
        this.f2462R = MoPubClientPositioning.NO_REPEAT;
        this.f2464T = new C1273q<>();
        this.f2465U = new Handler();
        this.f2466V = new C0841t(this);
        this.f2458N = new ArrayList();
        TypedArray a = context.obtainStyledAttributes(attrs, C0805H.PreferenceGroup, defStyleAttr, defStyleRes);
        int i = C0805H.PreferenceGroup_orderingFromXml;
        this.f2459O = C0509e.m2554a(a, i, i, true);
        if (a.hasValue(C0805H.PreferenceGroup_initialExpandedChildrenCount)) {
            int i2 = C0805H.PreferenceGroup_initialExpandedChildrenCount;
            this.f2462R = C0509e.m2549a(a, i2, i2, -1);
        }
        a.recycle();
    }

    public PreferenceGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* renamed from: f */
    public void mo6400f(boolean orderingAsAdded) {
        this.f2459O = orderingAsAdded;
    }

    /* renamed from: R */
    public int mo6295R() {
        return this.f2462R;
    }

    /* renamed from: b */
    public void mo6396b(Preference preference) {
        mo6398c(preference);
    }

    /* renamed from: S */
    public int mo6296S() {
        return this.f2458N.size();
    }

    /* renamed from: g */
    public Preference mo6401g(int index) {
        return (Preference) this.f2458N.get(index);
    }

    /* renamed from: c */
    public boolean mo6398c(Preference preference) {
        long id;
        if (this.f2458N.contains(preference)) {
            return true;
        }
        if (preference.mo6384v() == Integer.MAX_VALUE) {
            if (this.f2459O) {
                int i = this.f2460P;
                this.f2460P = i + 1;
                preference.mo6371e(i);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).mo6400f(this.f2459O);
            }
        }
        int insertionIndex = Collections.binarySearch(this.f2458N, preference);
        if (insertionIndex < 0) {
            insertionIndex = (insertionIndex * -1) - 1;
        }
        if (!mo6393d(preference)) {
            return false;
        }
        synchronized (this) {
            this.f2458N.add(insertionIndex, preference);
        }
        C0847y preferenceManager = mo6386x();
        String key = preference.mo6381t();
        if (key == null || !this.f2464T.containsKey(key)) {
            id = preferenceManager.mo6514b();
        } else {
            id = ((Long) this.f2464T.get(key)).longValue();
            this.f2464T.remove(key);
        }
        preference.mo6352a(preferenceManager, id);
        preference.mo6350a(this);
        if (this.f2461Q) {
            preference.mo6334J();
        }
        mo6333I();
        return true;
    }

    /* renamed from: e */
    public boolean mo6399e(Preference preference) {
        boolean returnValue = m3847f(preference);
        mo6333I();
        return returnValue;
    }

    /* renamed from: f */
    private boolean m3847f(Preference preference) {
        boolean success;
        synchronized (this) {
            preference.mo6336M();
            if (preference.getParent() == this) {
                preference.mo6350a((PreferenceGroup) null);
            }
            success = this.f2458N.remove(preference);
            if (success) {
                String key = preference.mo6381t();
                if (key != null) {
                    this.f2464T.put(key, Long.valueOf(preference.getId()));
                    this.f2465U.removeCallbacks(this.f2466V);
                    this.f2465U.post(this.f2466V);
                }
                if (this.f2461Q) {
                    preference.mo6335L();
                }
            }
        }
        return success;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo6393d(Preference preference) {
        preference.mo6357b(this, mo6305P());
        return true;
    }

    /* renamed from: c */
    public Preference mo6397c(CharSequence key) {
        if (TextUtils.equals(mo6381t(), key)) {
            return this;
        }
        int preferenceCount = mo6296S();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = mo6401g(i);
            String curKey = preference.mo6381t();
            if (curKey != null && curKey.equals(key)) {
                return preference;
            }
            if (preference instanceof PreferenceGroup) {
                Preference returnedPreference = ((PreferenceGroup) preference).mo6397c(key);
                if (returnedPreference != null) {
                    return returnedPreference;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: T */
    public boolean mo6297T() {
        return true;
    }

    /* renamed from: J */
    public void mo6334J() {
        super.mo6334J();
        this.f2461Q = true;
        int preferenceCount = mo6296S();
        for (int i = 0; i < preferenceCount; i++) {
            mo6401g(i).mo6334J();
        }
    }

    /* renamed from: L */
    public void mo6335L() {
        super.mo6335L();
        this.f2461Q = false;
        int preferenceCount = mo6296S();
        for (int i = 0; i < preferenceCount; i++) {
            mo6401g(i).mo6335L();
        }
    }

    /* renamed from: b */
    public void mo6359b(boolean disableDependents) {
        super.mo6359b(disableDependents);
        int preferenceCount = mo6296S();
        for (int i = 0; i < preferenceCount; i++) {
            mo6401g(i).mo6357b(this, disableDependents);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: U */
    public void mo6394U() {
        synchronized (this) {
            Collections.sort(this.f2458N);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo6356b(Bundle container) {
        super.mo6356b(container);
        int preferenceCount = mo6296S();
        for (int i = 0; i < preferenceCount; i++) {
            mo6401g(i).mo6356b(container);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6345a(Bundle container) {
        super.mo6345a(container);
        int preferenceCount = mo6296S();
        for (int i = 0; i < preferenceCount; i++) {
            mo6401g(i).mo6345a(container);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public Parcelable mo4887N() {
        Parcelable superState = super.mo4887N();
        C0814a aVar = this.f2463S;
        if (aVar != null) {
            return aVar.mo6289a(superState);
        }
        return superState;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4892a(Parcelable state) {
        C0814a aVar = this.f2463S;
        if (aVar != null) {
            state = aVar.mo6292b(state);
        }
        super.mo4892a(state);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo6395a(C0814a callback) {
        this.f2463S = callback;
    }
}

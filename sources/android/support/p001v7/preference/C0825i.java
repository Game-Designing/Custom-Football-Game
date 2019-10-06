package android.support.p001v7.preference;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.p001v7.app.C0774m.C0775a;
import java.util.ArrayList;
import p005cm.aptoide.p006pt.database.realm.Notification;

/* renamed from: android.support.v7.preference.i */
/* compiled from: ListPreferenceDialogFragmentCompat */
public class C0825i extends C0831o {
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f2497i;

    /* renamed from: j */
    private CharSequence[] f2498j;

    /* renamed from: k */
    private CharSequence[] f2499k;

    public static C0825i newInstance(String key) {
        C0825i fragment = new C0825i();
        Bundle b = new Bundle(1);
        b.putString(Notification.KEY, key);
        fragment.setArguments(b);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            ListPreference preference = m3917d();
            if (preference.mo6315X() == null || preference.mo6317Z() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.f2497i = preference.mo6320d(preference.mo6319aa());
            this.f2498j = preference.mo6315X();
            this.f2499k = preference.mo6317Z();
            return;
        }
        this.f2497i = savedInstanceState.getInt("ListPreferenceDialogFragment.index", 0);
        this.f2498j = m3916a(savedInstanceState, "ListPreferenceDialogFragment.entries");
        this.f2499k = m3916a(savedInstanceState, "ListPreferenceDialogFragment.entryValues");
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ListPreferenceDialogFragment.index", this.f2497i);
        m3915a(outState, "ListPreferenceDialogFragment.entries", this.f2498j);
        m3915a(outState, "ListPreferenceDialogFragment.entryValues", this.f2499k);
    }

    /* renamed from: a */
    private static void m3915a(Bundle out, String key, CharSequence[] entries) {
        ArrayList<String> stored = new ArrayList<>(entries.length);
        for (CharSequence cs : entries) {
            stored.add(cs.toString());
        }
        out.putStringArrayList(key, stored);
    }

    /* renamed from: a */
    private static CharSequence[] m3916a(Bundle in, String key) {
        ArrayList<String> stored = in.getStringArrayList(key);
        if (stored == null) {
            return null;
        }
        return (CharSequence[]) stored.toArray(new CharSequence[stored.size()]);
    }

    /* renamed from: d */
    private ListPreference m3917d() {
        return (ListPreference) mo6446b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6432a(C0775a builder) {
        super.mo6432a(builder);
        builder.mo6229a(this.f2498j, this.f2497i, (OnClickListener) new C0824h(this));
        builder.mo6240c((CharSequence) null, (OnClickListener) null);
    }

    /* renamed from: a */
    public void mo6427a(boolean positiveResult) {
        ListPreference preference = m3917d();
        if (positiveResult) {
            int i = this.f2497i;
            if (i >= 0) {
                String value = this.f2499k[i].toString();
                if (preference.mo6353a((Object) value)) {
                    preference.mo6321e(value);
                }
            }
        }
    }
}

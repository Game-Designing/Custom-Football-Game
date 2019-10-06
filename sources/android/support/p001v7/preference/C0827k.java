package android.support.p001v7.preference;

import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.support.p001v7.app.C0774m.C0775a;
import android.support.p001v7.preference.internal.AbstractMultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import p005cm.aptoide.p006pt.database.realm.Notification;

/* renamed from: android.support.v7.preference.k */
/* compiled from: MultiSelectListPreferenceDialogFragmentCompat */
public class C0827k extends C0831o {
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Set<String> f2501i = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f2502j;

    /* renamed from: k */
    private CharSequence[] f2503k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CharSequence[] f2504l;

    public static C0827k newInstance(String key) {
        C0827k fragment = new C0827k();
        Bundle b = new Bundle(1);
        b.putString(Notification.KEY, key);
        fragment.setArguments(b);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            AbstractMultiSelectListPreference preference = m3928d();
            if (preference.mo4888X() == null || preference.mo4889Y() == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.f2501i.clear();
            this.f2501i.addAll(preference.mo4890Z());
            this.f2502j = false;
            this.f2503k = preference.mo4888X();
            this.f2504l = preference.mo4889Y();
            return;
        }
        this.f2501i.clear();
        this.f2501i.addAll(savedInstanceState.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.f2502j = savedInstanceState.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.f2503k = savedInstanceState.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.f2504l = savedInstanceState.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList(this.f2501i));
        outState.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f2502j);
        outState.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f2503k);
        outState.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f2504l);
    }

    /* renamed from: d */
    private AbstractMultiSelectListPreference m3928d() {
        return (AbstractMultiSelectListPreference) mo6446b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6432a(C0775a builder) {
        super.mo6432a(builder);
        int entryCount = this.f2504l.length;
        boolean[] checkedItems = new boolean[entryCount];
        for (int i = 0; i < entryCount; i++) {
            checkedItems[i] = this.f2501i.contains(this.f2504l[i].toString());
        }
        builder.mo6230a(this.f2503k, checkedItems, (OnMultiChoiceClickListener) new C0826j(this));
    }

    /* renamed from: a */
    public void mo6427a(boolean positiveResult) {
        AbstractMultiSelectListPreference preference = m3928d();
        if (positiveResult && this.f2502j) {
            Set<String> values = this.f2501i;
            if (preference.mo6353a((Object) values)) {
                preference.mo4894c(values);
            }
        }
        this.f2502j = false;
    }
}

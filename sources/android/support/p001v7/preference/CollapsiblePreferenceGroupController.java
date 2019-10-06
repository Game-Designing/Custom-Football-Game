package android.support.p001v7.preference;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p001v7.preference.Preference.BaseSavedState;
import android.support.p001v7.preference.Preference.C0813c;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.preference.CollapsiblePreferenceGroupController */
final class CollapsiblePreferenceGroupController implements C0814a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0844w f2393a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f2394b;

    /* renamed from: c */
    private final Context f2395c;

    /* renamed from: android.support.v7.preference.CollapsiblePreferenceGroupController$SavedState */
    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0819c();

        /* renamed from: a */
        int f2396a;

        SavedState(Parcel source) {
            super(source);
            this.f2396a = source.readInt();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f2396a);
        }

        SavedState(Parcelable superState) {
            super(superState);
        }
    }

    /* renamed from: android.support.v7.preference.CollapsiblePreferenceGroupController$a */
    static class C0799a extends Preference {
        C0799a(Context context, List<Preference> visiblePreferenceList, List<Preference> flattenedPreferenceList) {
            super(context);
            m3725U();
            m3726a(visiblePreferenceList, flattenedPreferenceList);
        }

        /* renamed from: U */
        private void m3725U() {
            mo6367d(C0803F.expand_button);
            mo6362c(C0800D.ic_arrow_down_24dp);
            mo6374f(C0804G.expand_button_title);
            mo6371e(999);
        }

        /* renamed from: a */
        private void m3726a(List<Preference> visiblePreferenceList, List<Preference> flattenedPreferenceList) {
            CharSequence summary = null;
            for (int i = flattenedPreferenceList.indexOf((Preference) visiblePreferenceList.get(visiblePreferenceList.size() - 1)) + 1; i < flattenedPreferenceList.size(); i++) {
                Preference preference = (Preference) flattenedPreferenceList.get(i);
                if (!(preference instanceof PreferenceGroup) && preference.mo6332G()) {
                    CharSequence title = preference.mo6326A();
                    if (!TextUtils.isEmpty(title)) {
                        if (summary == null) {
                            summary = title;
                        } else {
                            summary = mo6373f().getString(C0804G.summary_collapsed_preference_list, new Object[]{summary, title});
                        }
                    }
                }
            }
            mo6318a(summary);
        }

        /* renamed from: a */
        public void mo4896a(C0796B holder) {
            super.mo4896a(holder);
            holder.mo6284a(false);
        }
    }

    CollapsiblePreferenceGroupController(PreferenceGroup preferenceGroup, C0844w preferenceGroupAdapter) {
        this.f2393a = preferenceGroupAdapter;
        this.f2394b = preferenceGroup.mo6295R();
        this.f2395c = preferenceGroup.mo6373f();
        preferenceGroup.mo6395a((C0814a) this);
    }

    /* renamed from: a */
    public List<Preference> mo6290a(List<Preference> flattenedPreferenceList) {
        int visiblePreferenceCount = 0;
        List<Preference> visiblePreferenceList = new ArrayList<>(flattenedPreferenceList.size());
        for (Preference preference : flattenedPreferenceList) {
            if (preference.mo6332G()) {
                if (visiblePreferenceCount < this.f2394b) {
                    visiblePreferenceList.add(preference);
                }
                if (!(preference instanceof PreferenceGroup)) {
                    visiblePreferenceCount++;
                }
            }
        }
        if (m3720a() && visiblePreferenceCount > this.f2394b) {
            visiblePreferenceList.add(m3718a(visiblePreferenceList, flattenedPreferenceList));
        }
        return visiblePreferenceList;
    }

    /* renamed from: a */
    public boolean mo6291a(Preference preference) {
        if (!m3720a()) {
            return false;
        }
        this.f2393a.mo6390d(preference);
        return true;
    }

    /* renamed from: a */
    public Parcelable mo6289a(Parcelable state) {
        SavedState myState = new SavedState(state);
        myState.f2396a = this.f2394b;
        return myState;
    }

    /* renamed from: b */
    public Parcelable mo6292b(Parcelable state) {
        if (state == null || !state.getClass().equals(SavedState.class)) {
            return state;
        }
        SavedState myState = (SavedState) state;
        int restoredMaxToShow = myState.f2396a;
        if (this.f2394b != restoredMaxToShow) {
            this.f2394b = restoredMaxToShow;
            this.f2393a.mo6390d(null);
        }
        return myState.getSuperState();
    }

    /* renamed from: a */
    private C0799a m3718a(List<Preference> visiblePreferenceList, List<Preference> flattenedPreferenceList) {
        C0799a preference = new C0799a(this.f2395c, visiblePreferenceList, flattenedPreferenceList);
        preference.mo6348a((C0813c) new C0818b(this));
        return preference;
    }

    /* renamed from: a */
    private boolean m3720a() {
        return this.f2394b != Integer.MAX_VALUE;
    }
}

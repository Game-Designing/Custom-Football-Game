package android.support.p001v7.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.preference.PreferenceGroup.C0815b;
import android.support.p001v7.widget.RecyclerView.C0970a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import p002b.p003c.p062h.p070f.C1292d;

/* renamed from: android.support.v7.preference.w */
/* compiled from: PreferenceGroupAdapter */
public class C0844w extends C0970a<C0796B> implements C0811a, C0815b {

    /* renamed from: a */
    private PreferenceGroup f2533a;

    /* renamed from: b */
    private List<Preference> f2534b;

    /* renamed from: c */
    private List<Preference> f2535c;

    /* renamed from: d */
    private List<C0845a> f2536d;

    /* renamed from: e */
    private C0845a f2537e;

    /* renamed from: f */
    private Handler f2538f;

    /* renamed from: g */
    private CollapsiblePreferenceGroupController f2539g;

    /* renamed from: h */
    private Runnable f2540h;

    /* renamed from: android.support.v7.preference.w$a */
    /* compiled from: PreferenceGroupAdapter */
    private static class C0845a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f2541a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f2542b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f2543c;

        public C0845a() {
        }

        public C0845a(C0845a other) {
            this.f2541a = other.f2541a;
            this.f2542b = other.f2542b;
            this.f2543c = other.f2543c;
        }

        public boolean equals(Object o) {
            boolean z = false;
            if (!(o instanceof C0845a)) {
                return false;
            }
            C0845a other = (C0845a) o;
            if (this.f2541a == other.f2541a && this.f2542b == other.f2542b && TextUtils.equals(this.f2543c, other.f2543c)) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            return (((((17 * 31) + this.f2541a) * 31) + this.f2542b) * 31) + this.f2543c.hashCode();
        }
    }

    public C0844w(PreferenceGroup preferenceGroup) {
        this(preferenceGroup, new Handler());
    }

    private C0844w(PreferenceGroup preferenceGroup, Handler handler) {
        this.f2537e = new C0845a();
        this.f2540h = new C0842u(this);
        this.f2533a = preferenceGroup;
        this.f2538f = handler;
        this.f2539g = new CollapsiblePreferenceGroupController(preferenceGroup, this);
        this.f2533a.mo6347a((C0811a) this);
        this.f2534b = new ArrayList();
        this.f2535c = new ArrayList();
        this.f2536d = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.f2533a;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).mo6404V());
        } else {
            setHasStableIds(true);
        }
        m3959a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3959a() {
        for (Preference preference : this.f2535c) {
            preference.mo6347a((C0811a) null);
        }
        List<Preference> fullPreferenceList = new ArrayList<>(this.f2535c.size());
        m3961a(fullPreferenceList, this.f2533a);
        List<Preference> visiblePreferenceList = this.f2539g.mo6290a(fullPreferenceList);
        List<Preference> oldVisibleList = this.f2534b;
        this.f2534b = visiblePreferenceList;
        this.f2535c = fullPreferenceList;
        C0847y preferenceManager = this.f2533a.mo6386x();
        if (preferenceManager == null || preferenceManager.mo6517e() == null) {
            notifyDataSetChanged();
        } else {
            C1292d.m6020a(new C0843v(this, oldVisibleList, visiblePreferenceList, preferenceManager.mo6517e())).mo9219a((C0970a) this);
        }
        for (Preference preference2 : fullPreferenceList) {
            preference2.mo6370e();
        }
    }

    /* renamed from: a */
    private void m3961a(List<Preference> preferences, PreferenceGroup group) {
        group.mo6394U();
        int groupSize = group.mo6296S();
        for (int i = 0; i < groupSize; i++) {
            Preference preference = group.mo6401g(i);
            preferences.add(preference);
            m3962e(preference);
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceAsGroup = (PreferenceGroup) preference;
                if (preferenceAsGroup.mo6297T()) {
                    m3961a(preferences, preferenceAsGroup);
                }
            }
            preference.mo6347a((C0811a) this);
        }
    }

    /* renamed from: a */
    private C0845a m3958a(Preference preference, C0845a in) {
        C0845a pl = in != null ? in : new C0845a();
        pl.f2543c = preference.getClass().getName();
        pl.f2541a = preference.mo6383u();
        pl.f2542b = preference.mo6327B();
        return pl;
    }

    /* renamed from: e */
    private void m3962e(Preference preference) {
        C0845a pl = m3958a(preference, (C0845a) null);
        if (!this.f2536d.contains(pl)) {
            this.f2536d.add(pl);
        }
    }

    public int getItemCount() {
        return this.f2534b.size();
    }

    public Preference getItem(int position) {
        if (position < 0 || position >= getItemCount()) {
            return null;
        }
        return (Preference) this.f2534b.get(position);
    }

    public long getItemId(int position) {
        if (!hasStableIds()) {
            return -1;
        }
        return getItem(position).getId();
    }

    /* renamed from: c */
    public void mo6389c(Preference preference) {
        int index = this.f2534b.indexOf(preference);
        if (index != -1) {
            notifyItemChanged(index, preference);
        }
    }

    /* renamed from: d */
    public void mo6390d(Preference preference) {
        this.f2538f.removeCallbacks(this.f2540h);
        this.f2538f.post(this.f2540h);
    }

    /* renamed from: a */
    public void mo6388a(Preference preference) {
        if (this.f2535c.contains(preference) && !this.f2539g.mo6291a(preference)) {
            if (preference.mo6332G()) {
                int previousVisibleIndex = -1;
                for (Preference pref : this.f2535c) {
                    if (preference.equals(pref)) {
                        break;
                    } else if (pref.mo6332G()) {
                        previousVisibleIndex++;
                    }
                }
                this.f2534b.add(previousVisibleIndex + 1, preference);
                notifyItemInserted(previousVisibleIndex + 1);
            } else {
                int listSize = this.f2534b.size();
                int removalIndex = 0;
                while (removalIndex < listSize && !preference.equals(this.f2534b.get(removalIndex))) {
                    removalIndex++;
                }
                this.f2534b.remove(removalIndex);
                notifyItemRemoved(removalIndex);
            }
        }
    }

    public int getItemViewType(int position) {
        this.f2537e = m3958a(getItem(position), this.f2537e);
        int viewType = this.f2536d.indexOf(this.f2537e);
        if (viewType != -1) {
            return viewType;
        }
        int viewType2 = this.f2536d.size();
        this.f2536d.add(new C0845a(this.f2537e));
        return viewType2;
    }

    public C0796B onCreateViewHolder(ViewGroup parent, int viewType) {
        C0845a pl = (C0845a) this.f2536d.get(viewType);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TypedArray a = parent.getContext().obtainStyledAttributes(null, C0805H.BackgroundStyle);
        Drawable background = a.getDrawable(C0805H.BackgroundStyle_android_selectableItemBackground);
        if (background == null) {
            background = C0510b.m2572c(parent.getContext(), 17301602);
        }
        a.recycle();
        View view = inflater.inflate(pl.f2541a, parent, false);
        if (view.getBackground() == null) {
            C0646w.m2954a(view, background);
        }
        ViewGroup widgetFrame = (ViewGroup) view.findViewById(16908312);
        if (widgetFrame != null) {
            if (pl.f2542b != 0) {
                inflater.inflate(pl.f2542b, widgetFrame);
            } else {
                widgetFrame.setVisibility(8);
            }
        }
        return new C0796B(view);
    }

    /* renamed from: a */
    public void onBindViewHolder(C0796B holder, int position) {
        getItem(position).mo4896a(holder);
    }

    /* renamed from: a */
    public int mo6402a(String key) {
        int size = this.f2534b.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(key, ((Preference) this.f2534b.get(i)).mo6381t())) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public int mo6403b(Preference preference) {
        int size = this.f2534b.size();
        for (int i = 0; i < size; i++) {
            Preference candidate = (Preference) this.f2534b.get(i);
            if (candidate != null && candidate.equals(preference)) {
                return i;
            }
        }
        return -1;
    }
}

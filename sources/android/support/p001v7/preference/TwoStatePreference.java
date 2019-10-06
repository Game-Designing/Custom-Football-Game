package android.support.p001v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p001v7.preference.Preference.BaseSavedState;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* renamed from: android.support.v7.preference.TwoStatePreference */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: N */
    private CharSequence f2486N;

    /* renamed from: O */
    private CharSequence f2487O;

    /* renamed from: P */
    protected boolean f2488P;

    /* renamed from: Q */
    private boolean f2489Q;

    /* renamed from: R */
    private boolean f2490R;

    /* renamed from: android.support.v7.preference.TwoStatePreference$SavedState */
    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0810M();

        /* renamed from: a */
        boolean f2491a;

        public SavedState(Parcel source) {
            super(source);
            boolean z = true;
            if (source.readInt() != 1) {
                z = false;
            }
            this.f2491a = z;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f2491a ? 1 : 0);
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public TwoStatePreference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TwoStatePreference(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: K */
    public void mo6294K() {
        super.mo6294K();
        boolean newValue = !mo6295R();
        if (mo6353a((Object) Boolean.valueOf(newValue))) {
            mo6416f(newValue);
        }
    }

    /* renamed from: f */
    public void mo6416f(boolean checked) {
        boolean changed = this.f2488P != checked;
        if (changed || !this.f2489Q) {
            this.f2488P = checked;
            this.f2489Q = true;
            mo6365c(checked);
            if (changed) {
                mo6359b(mo6305P());
                mo6302H();
            }
        }
    }

    /* renamed from: R */
    public boolean mo6295R() {
        return this.f2488P;
    }

    /* renamed from: P */
    public boolean mo6305P() {
        boolean shouldDisable = this.f2490R ? this.f2488P : !this.f2488P;
        if (shouldDisable || super.mo6305P()) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public void mo6415d(CharSequence summary) {
        this.f2486N = summary;
        if (mo6295R()) {
            mo6302H();
        }
    }

    /* renamed from: c */
    public void mo6414c(CharSequence summary) {
        this.f2487O = summary;
        if (!mo6295R()) {
            mo6302H();
        }
    }

    /* renamed from: g */
    public void mo6417g(boolean disableDependentsState) {
        this.f2490R = disableDependentsState;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo4891a(TypedArray a, int index) {
        return Boolean.valueOf(a.getBoolean(index, false));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4893a(boolean restoreValue, Object defaultValue) {
        boolean z;
        if (restoreValue) {
            z = mo6354a(this.f2488P);
        } else {
            z = ((Boolean) defaultValue).booleanValue();
        }
        mo6416f(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo6412b(C0796B holder) {
        mo6413b(holder.mo6283a(16908304));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo6413b(View view) {
        if (view instanceof TextView) {
            TextView summaryView = (TextView) view;
            boolean useDefaultSummary = true;
            if (this.f2488P && !TextUtils.isEmpty(this.f2486N)) {
                summaryView.setText(this.f2486N);
                useDefaultSummary = false;
            } else if (!this.f2488P && !TextUtils.isEmpty(this.f2487O)) {
                summaryView.setText(this.f2487O);
                useDefaultSummary = false;
            }
            if (useDefaultSummary) {
                CharSequence summary = mo6322z();
                if (!TextUtils.isEmpty(summary)) {
                    summaryView.setText(summary);
                    useDefaultSummary = false;
                }
            }
            int newVisibility = 8;
            if (!useDefaultSummary) {
                newVisibility = 0;
            }
            if (newVisibility != summaryView.getVisibility()) {
                summaryView.setVisibility(newVisibility);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public Parcelable mo4887N() {
        Parcelable superState = super.mo4887N();
        if (mo6330E()) {
            return superState;
        }
        SavedState myState = new SavedState(superState);
        myState.f2491a = mo6295R();
        return myState;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4892a(Parcelable state) {
        if (state == null || !state.getClass().equals(SavedState.class)) {
            super.mo4892a(state);
            return;
        }
        SavedState myState = (SavedState) state;
        super.mo4892a(myState.getSuperState());
        mo6416f(myState.f2491a);
    }
}

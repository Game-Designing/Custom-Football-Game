package android.support.p001v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p001v7.preference.Preference.BaseSavedState;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.OnKeyListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/* renamed from: android.support.v7.preference.SeekBarPreference */
public class SeekBarPreference extends Preference {
    /* access modifiers changed from: private */

    /* renamed from: N */
    public int f2468N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public int f2469O;

    /* renamed from: P */
    private int f2470P;

    /* renamed from: Q */
    private int f2471Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public boolean f2472R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public SeekBar f2473S;

    /* renamed from: T */
    private TextView f2474T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public boolean f2475U;

    /* renamed from: V */
    private boolean f2476V;

    /* renamed from: W */
    private OnSeekBarChangeListener f2477W;

    /* renamed from: X */
    private OnKeyListener f2478X;

    /* renamed from: android.support.v7.preference.SeekBarPreference$SavedState */
    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0808K();

        /* renamed from: a */
        int f2479a;

        /* renamed from: b */
        int f2480b;

        /* renamed from: c */
        int f2481c;

        public SavedState(Parcel source) {
            super(source);
            this.f2479a = source.readInt();
            this.f2480b = source.readInt();
            this.f2481c = source.readInt();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f2479a);
            dest.writeInt(this.f2480b);
            dest.writeInt(this.f2481c);
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.f2477W = new C0806I(this);
        this.f2478X = new C0807J(this);
        TypedArray a = context.obtainStyledAttributes(attrs, C0805H.SeekBarPreference, defStyleAttr, defStyleRes);
        this.f2469O = a.getInt(C0805H.SeekBarPreference_min, 0);
        mo6405g(a.getInt(C0805H.SeekBarPreference_android_max, 100));
        mo6406h(a.getInt(C0805H.SeekBarPreference_seekBarIncrement, 0));
        this.f2475U = a.getBoolean(C0805H.SeekBarPreference_adjustable, true);
        this.f2476V = a.getBoolean(C0805H.SeekBarPreference_showSeekBarValue, true);
        a.recycle();
    }

    public SeekBarPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attrs) {
        this(context, attrs, C0797C.seekBarPreferenceStyle);
    }

    /* renamed from: a */
    public void mo4896a(C0796B view) {
        super.mo4896a(view);
        view.itemView.setOnKeyListener(this.f2478X);
        this.f2473S = (SeekBar) view.mo6283a(C0802E.seekbar);
        this.f2474T = (TextView) view.mo6283a(C0802E.seekbar_value);
        if (this.f2476V) {
            this.f2474T.setVisibility(0);
        } else {
            this.f2474T.setVisibility(8);
            this.f2474T = null;
        }
        SeekBar seekBar = this.f2473S;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f2477W);
        this.f2473S.setMax(this.f2470P - this.f2469O);
        int i = this.f2471Q;
        if (i != 0) {
            this.f2473S.setKeyProgressIncrement(i);
        } else {
            this.f2471Q = this.f2473S.getKeyProgressIncrement();
        }
        this.f2473S.setProgress(this.f2468N - this.f2469O);
        TextView textView = this.f2474T;
        if (textView != null) {
            textView.setText(String.valueOf(this.f2468N));
        }
        this.f2473S.setEnabled(mo6329D());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4893a(boolean restoreValue, Object defaultValue) {
        int i;
        if (restoreValue) {
            i = mo6339a(this.f2468N);
        } else {
            i = ((Integer) defaultValue).intValue();
        }
        mo6407i(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo4891a(TypedArray a, int index) {
        return Integer.valueOf(a.getInt(index, 0));
    }

    /* renamed from: g */
    public final void mo6405g(int max) {
        if (max < this.f2469O) {
            max = this.f2469O;
        }
        if (max != this.f2470P) {
            this.f2470P = max;
            mo6302H();
        }
    }

    /* renamed from: h */
    public final void mo6406h(int seekBarIncrement) {
        if (seekBarIncrement != this.f2471Q) {
            this.f2471Q = Math.min(this.f2470P - this.f2469O, Math.abs(seekBarIncrement));
            mo6302H();
        }
    }

    /* renamed from: i */
    public void mo6407i(int seekBarValue) {
        m3874a(seekBarValue, true);
    }

    /* renamed from: a */
    private void m3874a(int seekBarValue, boolean notifyChanged) {
        if (seekBarValue < this.f2469O) {
            seekBarValue = this.f2469O;
        }
        if (seekBarValue > this.f2470P) {
            seekBarValue = this.f2470P;
        }
        if (seekBarValue != this.f2468N) {
            this.f2468N = seekBarValue;
            TextView textView = this.f2474T;
            if (textView != null) {
                textView.setText(String.valueOf(this.f2468N));
            }
            mo6360b(seekBarValue);
            if (notifyChanged) {
                mo6302H();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3876a(SeekBar seekBar) {
        int seekBarValue = this.f2469O + seekBar.getProgress();
        if (seekBarValue == this.f2468N) {
            return;
        }
        if (mo6353a((Object) Integer.valueOf(seekBarValue))) {
            m3874a(seekBarValue, false);
        } else {
            seekBar.setProgress(this.f2468N - this.f2469O);
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
        myState.f2479a = this.f2468N;
        myState.f2480b = this.f2469O;
        myState.f2481c = this.f2470P;
        return myState;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4892a(Parcelable state) {
        if (!state.getClass().equals(SavedState.class)) {
            super.mo4892a(state);
            return;
        }
        SavedState myState = (SavedState) state;
        super.mo4892a(myState.getSuperState());
        this.f2468N = myState.f2479a;
        this.f2469O = myState.f2480b;
        this.f2470P = myState.f2481c;
        mo6302H();
    }
}

package android.support.p001v7.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/* renamed from: android.support.v7.preference.DropDownPreference */
public class DropDownPreference extends ListPreference {

    /* renamed from: Y */
    private final Context f2403Y;

    /* renamed from: Z */
    private final ArrayAdapter f2404Z;

    /* renamed from: aa */
    private Spinner f2405aa;

    /* renamed from: ba */
    private final OnItemSelectedListener f2406ba;

    public DropDownPreference(Context context, AttributeSet attrs) {
        this(context, attrs, C0797C.dropdownPreferenceStyle);
    }

    public DropDownPreference(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
    }

    public DropDownPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.f2406ba = new C0820d(this);
        this.f2403Y = context;
        this.f2404Z = mo6303ba();
        m3735ca();
    }

    /* access modifiers changed from: protected */
    /* renamed from: K */
    public void mo6294K() {
        this.f2405aa.performClick();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ba */
    public ArrayAdapter mo6303ba() {
        return new ArrayAdapter(this.f2403Y, 17367049);
    }

    /* renamed from: ca */
    private void m3735ca() {
        this.f2404Z.clear();
        if (mo6315X() != null) {
            for (CharSequence c : mo6315X()) {
                this.f2404Z.add(c.toString());
            }
        }
    }

    /* renamed from: f */
    public int mo6304f(String value) {
        CharSequence[] entryValues = mo6317Z();
        if (!(value == null || entryValues == null)) {
            for (int i = entryValues.length - 1; i >= 0; i--) {
                if (entryValues[i].equals(value)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public void mo6302H() {
        super.mo6302H();
        this.f2404Z.notifyDataSetChanged();
    }

    /* renamed from: a */
    public void mo4896a(C0796B view) {
        this.f2405aa = (Spinner) view.itemView.findViewById(C0802E.spinner);
        this.f2405aa.setAdapter(this.f2404Z);
        this.f2405aa.setOnItemSelectedListener(this.f2406ba);
        this.f2405aa.setSelection(mo6304f(mo6319aa()));
        super.mo4896a(view);
    }
}

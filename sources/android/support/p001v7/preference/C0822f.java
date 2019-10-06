package android.support.p001v7.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import p005cm.aptoide.p006pt.database.realm.Notification;

/* renamed from: android.support.v7.preference.f */
/* compiled from: EditTextPreferenceDialogFragmentCompat */
public class C0822f extends C0831o {

    /* renamed from: i */
    private EditText f2494i;

    /* renamed from: j */
    private CharSequence f2495j;

    public static C0822f newInstance(String key) {
        C0822f fragment = new C0822f();
        Bundle b = new Bundle(1);
        b.putString(Notification.KEY, key);
        fragment.setArguments(b);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            this.f2495j = m3910d().mo6306X();
        } else {
            this.f2495j = savedInstanceState.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("EditTextPreferenceDialogFragment.text", this.f2495j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6426a(View view) {
        super.mo6426a(view);
        this.f2494i = (EditText) view.findViewById(16908291);
        EditText editText = this.f2494i;
        if (editText != null) {
            editText.setText(this.f2495j);
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    /* renamed from: d */
    private EditTextPreference m3910d() {
        return (EditTextPreference) mo6446b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo6428c() {
        return true;
    }

    /* renamed from: a */
    public void mo6427a(boolean positiveResult) {
        if (positiveResult) {
            String value = this.f2494i.getText().toString();
            if (m3910d().mo6353a((Object) value)) {
                m3910d().mo6307d(value);
            }
        }
    }
}

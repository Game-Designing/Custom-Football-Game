package android.support.p001v7.preference.internal;

import android.content.Context;
import android.support.p001v7.preference.DialogPreference;
import android.util.AttributeSet;
import java.util.Set;

/* renamed from: android.support.v7.preference.internal.AbstractMultiSelectListPreference */
public abstract class AbstractMultiSelectListPreference extends DialogPreference {
    /* renamed from: X */
    public abstract CharSequence[] mo4888X();

    /* renamed from: Y */
    public abstract CharSequence[] mo4889Y();

    /* renamed from: Z */
    public abstract Set<String> mo4890Z();

    /* renamed from: c */
    public abstract void mo4894c(Set<String> set);

    public AbstractMultiSelectListPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public AbstractMultiSelectListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}

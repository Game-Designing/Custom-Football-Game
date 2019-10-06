package android.support.p000v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* renamed from: android.support.v4.app.q */
/* compiled from: FragmentContainer */
public abstract class C0483q {
    /* renamed from: a */
    public abstract View mo221a(int i);

    /* renamed from: a */
    public abstract boolean mo227a();

    /* renamed from: a */
    public Fragment mo5196a(Context context, String className, Bundle arguments) {
        return Fragment.instantiate(context, className, arguments);
    }
}

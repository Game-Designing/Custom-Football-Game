package android.support.p000v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* renamed from: android.support.v4.app.m */
/* compiled from: Fragment */
class C0480m extends C0483q {

    /* renamed from: a */
    final /* synthetic */ Fragment f1611a;

    C0480m(Fragment this$0) {
        this.f1611a = this$0;
    }

    /* renamed from: a */
    public View mo221a(int id) {
        View view = this.f1611a.mView;
        if (view != null) {
            return view.findViewById(id);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    /* renamed from: a */
    public boolean mo227a() {
        return this.f1611a.mView != null;
    }

    /* renamed from: a */
    public Fragment mo5196a(Context context, String className, Bundle arguments) {
        return this.f1611a.mHost.mo5196a(context, className, arguments);
    }
}

package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* renamed from: com.google.android.gms.auth.api.signin.a */
final /* synthetic */ class C8615a implements Comparator {

    /* renamed from: a */
    static final Comparator f19462a = new C8615a();

    private C8615a() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((Scope) obj).mo27412a().compareTo(((Scope) obj2).mo27412a());
    }
}

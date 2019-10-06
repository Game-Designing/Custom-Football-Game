package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.common.util.VisibleForTesting;

public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {

    /* renamed from: j */
    private static final C8613a f19424j = new C8613a(null);
    @VisibleForTesting

    /* renamed from: k */
    private static int f19425k = C8614b.f19426a;

    /* renamed from: com.google.android.gms.auth.api.signin.GoogleSignInClient$a */
    private static class C8613a implements ResultConverter<GoogleSignInResult, GoogleSignInAccount> {
        private C8613a() {
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo27190a(Result result) {
            return ((GoogleSignInResult) result).mo27209a();
        }

        /* synthetic */ C8613a(C8617c cVar) {
            this();
        }
    }

    /* 'enum' access flag removed */
    @VisibleForTesting
    /* renamed from: com.google.android.gms.auth.api.signin.GoogleSignInClient$b */
    static final class C8614b {

        /* renamed from: a */
        public static final int f19426a = 1;

        /* renamed from: b */
        public static final int f19427b = 2;

        /* renamed from: c */
        public static final int f19428c = 3;

        /* renamed from: d */
        public static final int f19429d = 4;

        /* renamed from: e */
        private static final /* synthetic */ int[] f19430e = {f19426a, f19427b, f19428c, f19429d};

        /* renamed from: a */
        public static int[] m20947a() {
            return (int[]) f19430e.clone();
        }
    }
}

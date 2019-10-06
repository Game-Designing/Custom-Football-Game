package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions extends AbstractSafeParcelable implements Optional, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new zad();
    @VisibleForTesting

    /* renamed from: a */
    public static final Scope f19431a = new Scope("profile");
    @VisibleForTesting

    /* renamed from: b */
    public static final Scope f19432b = new Scope("email");
    @VisibleForTesting

    /* renamed from: c */
    public static final Scope f19433c = new Scope("openid");
    @VisibleForTesting

    /* renamed from: d */
    public static final Scope f19434d = new Scope("https://www.googleapis.com/auth/games_lite");
    @VisibleForTesting

    /* renamed from: e */
    public static final Scope f19435e = new Scope("https://www.googleapis.com/auth/games");

    /* renamed from: f */
    public static final GoogleSignInOptions f19436f = new Builder().mo27207c().mo27208d().mo27205a();

    /* renamed from: g */
    public static final GoogleSignInOptions f19437g = new Builder().mo27202a(f19434d, new Scope[0]).mo27205a();

    /* renamed from: h */
    private static Comparator<Scope> f19438h = new C8616b();

    /* renamed from: i */
    private final int f19439i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final ArrayList<Scope> f19440j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Account f19441k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f19442l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final boolean f19443m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final boolean f19444n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f19445o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f19446p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ArrayList<GoogleSignInOptionsExtensionParcelable> f19447q;

    /* renamed from: r */
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> f19448r;

    public static final class Builder {

        /* renamed from: a */
        private Set<Scope> f19449a = new HashSet();

        /* renamed from: b */
        private boolean f19450b;

        /* renamed from: c */
        private boolean f19451c;

        /* renamed from: d */
        private boolean f19452d;

        /* renamed from: e */
        private String f19453e;

        /* renamed from: f */
        private Account f19454f;

        /* renamed from: g */
        private String f19455g;

        /* renamed from: h */
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> f19456h = new HashMap();

        public Builder() {
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            Preconditions.m21857a(googleSignInOptions);
            this.f19449a = new HashSet(googleSignInOptions.f19440j);
            this.f19450b = googleSignInOptions.f19443m;
            this.f19451c = googleSignInOptions.f19444n;
            this.f19452d = googleSignInOptions.f19442l;
            this.f19453e = googleSignInOptions.f19445o;
            this.f19454f = googleSignInOptions.f19441k;
            this.f19455g = googleSignInOptions.f19446p;
            this.f19456h = GoogleSignInOptions.m20951b((List<GoogleSignInOptionsExtensionParcelable>) googleSignInOptions.f19447q);
        }

        /* renamed from: c */
        public final Builder mo27207c() {
            this.f19449a.add(GoogleSignInOptions.f19433c);
            return this;
        }

        /* renamed from: b */
        public final Builder mo27206b() {
            this.f19449a.add(GoogleSignInOptions.f19432b);
            return this;
        }

        /* renamed from: d */
        public final Builder mo27208d() {
            this.f19449a.add(GoogleSignInOptions.f19431a);
            return this;
        }

        /* renamed from: a */
        public final Builder mo27202a(Scope scope, Scope... scopeArr) {
            this.f19449a.add(scope);
            this.f19449a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        /* renamed from: a */
        public final Builder mo27203a(String str) {
            return mo27204a(str, false);
        }

        /* renamed from: a */
        public final Builder mo27204a(String str, boolean z) {
            this.f19450b = true;
            m20968b(str);
            this.f19453e = str;
            this.f19451c = z;
            return this;
        }

        /* renamed from: a */
        public final GoogleSignInOptions mo27205a() {
            if (this.f19449a.contains(GoogleSignInOptions.f19435e) && this.f19449a.contains(GoogleSignInOptions.f19434d)) {
                this.f19449a.remove(GoogleSignInOptions.f19434d);
            }
            if (this.f19452d && (this.f19454f == null || !this.f19449a.isEmpty())) {
                mo27207c();
            }
            GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions(3, new ArrayList(this.f19449a), this.f19454f, this.f19452d, this.f19450b, this.f19451c, this.f19453e, this.f19455g, this.f19456h, null);
            return googleSignInOptions;
        }

        /* renamed from: b */
        private final String m20968b(String str) {
            Preconditions.m21866b(str);
            String str2 = this.f19453e;
            Preconditions.m21864a(str2 == null || str2.equals(str), (Object) "two different server client ids provided");
            return str;
        }
    }

    /* renamed from: a */
    public static GoogleSignInOptions m20948a(String str) throws JSONException {
        Account account;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.optString("accountName", null);
        if (!TextUtils.isEmpty(optString)) {
            account = new Account(optString, "com.google");
        } else {
            account = null;
        }
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions(3, new ArrayList<>(hashSet), account, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), (Map<Integer, GoogleSignInOptionsExtensionParcelable>) new HashMap<Integer,GoogleSignInOptionsExtensionParcelable>());
        return googleSignInOptions;
    }

    @Constructor
    GoogleSignInOptions(@Param(id = 1) int i, @Param(id = 2) ArrayList<Scope> arrayList, @Param(id = 3) Account account, @Param(id = 4) boolean z, @Param(id = 5) boolean z2, @Param(id = 6) boolean z3, @Param(id = 7) String str, @Param(id = 8) String str2, @Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i, arrayList, account, z, z2, z3, str, str2, m20951b((List<GoogleSignInOptionsExtensionParcelable>) arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        this.f19439i = i;
        this.f19440j = arrayList;
        this.f19441k = account;
        this.f19442l = z;
        this.f19443m = z2;
        this.f19444n = z3;
        this.f19445o = str;
        this.f19446p = str2;
        this.f19447q = new ArrayList<>(map.values());
        this.f19448r = map;
    }

    @KeepForSdk
    /* renamed from: d */
    public ArrayList<Scope> mo27193d() {
        return new ArrayList<>(this.f19440j);
    }

    @KeepForSdk
    /* renamed from: a */
    public Account mo27191a() {
        return this.f19441k;
    }

    @KeepForSdk
    /* renamed from: g */
    public boolean mo27197g() {
        return this.f19442l;
    }

    @KeepForSdk
    /* renamed from: h */
    public boolean mo27198h() {
        return this.f19443m;
    }

    @KeepForSdk
    /* renamed from: f */
    public boolean mo27196f() {
        return this.f19444n;
    }

    @KeepForSdk
    /* renamed from: e */
    public String mo27194e() {
        return this.f19445o;
    }

    @KeepForSdk
    /* renamed from: c */
    public ArrayList<GoogleSignInOptionsExtensionParcelable> mo27192c() {
        return this.f19447q;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> m20951b(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.mo27217a()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19439i);
        SafeParcelWriter.m21977c(parcel, 2, mo27193d(), false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) mo27191a(), i, false);
        SafeParcelWriter.m21968a(parcel, 4, mo27197g());
        SafeParcelWriter.m21968a(parcel, 5, mo27198h());
        SafeParcelWriter.m21968a(parcel, 6, mo27196f());
        SafeParcelWriter.m21965a(parcel, 7, mo27194e(), false);
        SafeParcelWriter.m21965a(parcel, 8, this.f19446p, false);
        SafeParcelWriter.m21977c(parcel, 9, mo27192c(), false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r4.mo27191a() == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
        if (r3.f19445o.equals(r4.mo27194e()) != false) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x008a }
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.f19447q     // Catch:{ ClassCastException -> 0x008a }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x008a }
            if (r1 > 0) goto L_0x0089
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.f19447q     // Catch:{ ClassCastException -> 0x008a }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x008a }
            if (r1 <= 0) goto L_0x0018
            goto L_0x0089
        L_0x0018:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f19440j     // Catch:{ ClassCastException -> 0x008a }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x008a }
            java.util.ArrayList r2 = r4.mo27193d()     // Catch:{ ClassCastException -> 0x008a }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x008a }
            if (r1 != r2) goto L_0x0088
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f19440j     // Catch:{ ClassCastException -> 0x008a }
            java.util.ArrayList r2 = r4.mo27193d()     // Catch:{ ClassCastException -> 0x008a }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x008a }
            if (r1 != 0) goto L_0x0035
            goto L_0x0088
        L_0x0035:
            android.accounts.Account r1 = r3.f19441k     // Catch:{ ClassCastException -> 0x008a }
            if (r1 != 0) goto L_0x0040
            android.accounts.Account r1 = r4.mo27191a()     // Catch:{ ClassCastException -> 0x008a }
            if (r1 != 0) goto L_0x0086
        L_0x003f:
            goto L_0x004d
        L_0x0040:
            android.accounts.Account r1 = r3.f19441k     // Catch:{ ClassCastException -> 0x008a }
            android.accounts.Account r2 = r4.mo27191a()     // Catch:{ ClassCastException -> 0x008a }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x008a }
            if (r1 == 0) goto L_0x0086
            goto L_0x003f
        L_0x004d:
            java.lang.String r1 = r3.f19445o     // Catch:{ ClassCastException -> 0x008a }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x008a }
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = r4.mo27194e()     // Catch:{ ClassCastException -> 0x008a }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x008a }
            if (r1 == 0) goto L_0x0086
            goto L_0x006c
        L_0x0060:
            java.lang.String r1 = r3.f19445o     // Catch:{ ClassCastException -> 0x008a }
            java.lang.String r2 = r4.mo27194e()     // Catch:{ ClassCastException -> 0x008a }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x008a }
            if (r1 == 0) goto L_0x0086
        L_0x006c:
            boolean r1 = r3.f19444n     // Catch:{ ClassCastException -> 0x008a }
            boolean r2 = r4.mo27196f()     // Catch:{ ClassCastException -> 0x008a }
            if (r1 != r2) goto L_0x0086
            boolean r1 = r3.f19442l     // Catch:{ ClassCastException -> 0x008a }
            boolean r2 = r4.mo27197g()     // Catch:{ ClassCastException -> 0x008a }
            if (r1 != r2) goto L_0x0086
            boolean r1 = r3.f19443m     // Catch:{ ClassCastException -> 0x008a }
            boolean r4 = r4.mo27198h()     // Catch:{ ClassCastException -> 0x008a }
            if (r1 != r4) goto L_0x0086
            r4 = 1
            return r4
        L_0x0086:
            return r0
        L_0x0088:
            return r0
        L_0x0089:
            return r0
        L_0x008a:
            r4 = move-exception
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f19440j;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((Scope) obj).mo27412a());
        }
        Collections.sort(arrayList);
        return new HashAccumulator().mo27220a((Object) arrayList).mo27220a((Object) this.f19441k).mo27220a((Object) this.f19445o).mo27221a(this.f19444n).mo27221a(this.f19442l).mo27221a(this.f19443m).mo27219a();
    }

    /* renamed from: i */
    public final String mo27200i() {
        return m20959j().toString();
    }

    /* renamed from: j */
    private final JSONObject m20959j() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f19440j, f19438h);
            ArrayList<Scope> arrayList = this.f19440j;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jSONArray.put(((Scope) obj).mo27412a());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f19441k != null) {
                jSONObject.put("accountName", this.f19441k.name);
            }
            jSONObject.put("idTokenRequested", this.f19442l);
            jSONObject.put("forceCodeForRefreshToken", this.f19444n);
            jSONObject.put("serverAuthRequested", this.f19443m);
            if (!TextUtils.isEmpty(this.f19445o)) {
                jSONObject.put("serverClientId", this.f19445o);
            }
            if (!TextUtils.isEmpty(this.f19446p)) {
                jSONObject.put("hostedDomain", this.f19446p);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, C8616b bVar) {
        this(3, arrayList, account, z, z2, z3, str, str2, map);
    }
}

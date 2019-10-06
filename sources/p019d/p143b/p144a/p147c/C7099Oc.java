package p019d.p143b.p144a.p147c;

import android.util.Log;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Oc */
class C7099Oc implements C7262l {

    /* renamed from: a */
    private final C7142c f13326a;

    /* renamed from: b */
    private C7166i f13327b;

    C7099Oc(C7142c cVar) {
        this.f13326a = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22912a(C7166i iVar) {
        this.f13327b = iVar;
    }

    /* renamed from: a */
    public void mo22913a(String str, String str2) {
        mo22914a(str, str2, null);
    }

    /* renamed from: a */
    public void mo22914a(String str, String str2, Throwable th) {
        String str3 = "] ";
        if (mo22915a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append(str3);
            sb.append(str2);
            Log.w("AppLovinSdk", sb.toString(), th);
        }
        C7166i iVar = this.f13327b;
        if (iVar != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("WARN  [");
            sb2.append(str);
            sb2.append(str3);
            sb2.append(str2);
            iVar.mo23169a(sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo22915a() {
        return this.f13326a.mo23081z().mo23487f() || (this.f13326a.mo23026A() != null && ((Boolean) this.f13326a.mo23026A().mo23249a(C7196pb.f13852n)).booleanValue());
    }

    /* renamed from: b */
    public void mo22916b(String str, String str2) {
        mo22917b(str, str2, null);
    }

    /* renamed from: b */
    public void mo22917b(String str, String str2, Throwable th) {
        String str3;
        String str4 = "] ";
        if (mo22915a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append(str4);
            sb.append(str2);
            Log.e("AppLovinSdk", sb.toString(), th);
        }
        C7166i iVar = this.f13327b;
        if (iVar != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ERROR  [");
            sb2.append(str);
            sb2.append(str4);
            sb2.append(str2);
            if (th != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(": ");
                sb3.append(th.getMessage());
                str3 = sb3.toString();
            } else {
                str3 = "";
            }
            sb2.append(str3);
            iVar.mo23169a(sb2.toString());
        }
    }

    /* renamed from: c */
    public void mo22918c(String str, String str2) {
        String str3 = "] ";
        if (mo22915a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append(str3);
            sb.append(str2);
            Log.d("AppLovinSdk", sb.toString());
        }
        C7166i iVar = this.f13327b;
        if (iVar != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DEBUG  [");
            sb2.append(str);
            sb2.append(str3);
            sb2.append(str2);
            iVar.mo23169a(sb2.toString());
        }
    }

    /* renamed from: c */
    public void mo22919c(String str, String str2, Throwable th) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(str);
        String str4 = "] ";
        sb.append(str4);
        sb.append(str2);
        Log.e("AppLovinSdk", sb.toString(), th);
        C7166i iVar = this.f13327b;
        if (iVar != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("USER  [");
            sb2.append(str);
            sb2.append(str4);
            sb2.append(str2);
            if (th != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(": ");
                sb3.append(th.getMessage());
                str3 = sb3.toString();
            } else {
                str3 = "";
            }
            sb2.append(str3);
            iVar.mo23169a(sb2.toString());
        }
    }

    /* renamed from: d */
    public void mo22920d(String str, String str2) {
        String str3 = "] ";
        if (mo22915a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append(str3);
            sb.append(str2);
            Log.i("AppLovinSdk", sb.toString());
        }
        C7166i iVar = this.f13327b;
        if (iVar != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("INFO  [");
            sb2.append(str);
            sb2.append(str3);
            sb2.append(str2);
            iVar.mo23169a(sb2.toString());
        }
    }

    /* renamed from: e */
    public void mo22921e(String str, String str2) {
        mo22919c(str, str2, null);
    }
}

package p019d.p135a.p136a;

import android.util.Log;
import com.adyen.core.exceptions.PostResponseFormatException;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p135a.p136a.p137a.C6845a;
import p019d.p135a.p136a.p138b.C6875t;
import p019d.p135a.p136a.p139c.C6886b;
import p019d.p135a.p136a.p139c.C6896i;

/* renamed from: d.a.a.m */
/* compiled from: PaymentStateHandler */
class C6921m implements C6845a {

    /* renamed from: a */
    final /* synthetic */ C6924p f12710a;

    C6921m(C6924p this$0) {
        this.f12710a = this$0;
    }

    /* renamed from: a */
    public void mo22278a(byte[] response) {
        Log.d(C6924p.f12713a, "processPayment(): onSuccess");
        try {
            this.f12710a.f12722j = new JSONObject(new String(response, Charset.forName("UTF-8")));
            String type = this.f12710a.f12722j.getString("type");
            if ("redirect".equals(type)) {
                this.f12710a.f12727o.mo22283a(C6875t.REDIRECTION_REQUIRED);
            } else if ("complete".equals(type)) {
                this.f12710a.f12723k = new C6896i(new C6886b(this.f12710a.f12722j));
                this.f12710a.f12727o.mo22283a(C6875t.PAYMENT_RESULT_RECEIVED);
            } else if ("error".equals(type)) {
                String a = C6924p.f12713a;
                StringBuilder sb = new StringBuilder();
                sb.append("Payment failed: ");
                sb.append(this.f12710a.f12722j.toString());
                Log.w(a, sb.toString());
                this.f12710a.f12714b = new PostResponseFormatException(this.f12710a.f12722j.getString("errorMessage"));
                this.f12710a.f12727o.mo22283a(C6875t.ERROR_OCCURRED);
            } else {
                String a2 = C6924p.f12713a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown response type: ");
                sb2.append(this.f12710a.f12722j.toString());
                Log.e(a2, sb2.toString());
                C6924p pVar = this.f12710a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unknown response type. Response must be redirect or complete.");
                sb3.append(this.f12710a.f12722j.toString());
                pVar.f12714b = new PostResponseFormatException(sb3.toString());
                this.f12710a.f12727o.mo22283a(C6875t.ERROR_OCCURRED);
            }
        } catch (JSONException exception) {
            Log.e(C6924p.f12713a, "processPayment(): JSONException occurred", exception);
            this.f12710a.mo22387b((Throwable) exception);
        }
    }

    /* renamed from: a */
    public void mo22277a(Throwable e) {
        Log.e(C6924p.f12713a, "processPayment(): onFailure");
        this.f12710a.mo22387b(e);
    }
}

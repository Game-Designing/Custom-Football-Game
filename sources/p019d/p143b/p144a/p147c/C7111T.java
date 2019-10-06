package p019d.p143b.p144a.p147c;

import android.content.Intent;
import com.applovin.adview.AppLovinConfirmationActivity;

/* renamed from: d.b.a.c.T */
class C7111T implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7108S f13376a;

    C7111T(C7108S s) {
        this.f13376a = s;
    }

    public void run() {
        String str = (String) this.f13376a.f13364a.mo23039a(C7196pb.f13793ba);
        String b = this.f13376a.mo22952b();
        String str2 = (String) this.f13376a.f13364a.mo23039a(C7196pb.f13818ga);
        if (C7182m.m15320a(AppLovinConfirmationActivity.class, this.f13376a.f13366c)) {
            try {
                Intent intent = new Intent(this.f13376a.f13366c, AppLovinConfirmationActivity.class);
                intent.putExtra("dialog_title", str);
                intent.putExtra("dialog_body", b);
                intent.putExtra("dialog_button_text", str2);
                this.f13376a.f13366c.startActivity(intent);
            } catch (Throwable th) {
                this.f13376a.mo22951a(b, th);
            }
        } else {
            this.f13376a.mo22951a(b, null);
        }
    }
}

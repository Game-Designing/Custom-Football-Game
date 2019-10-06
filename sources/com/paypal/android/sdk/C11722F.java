package com.paypal.android.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

/* renamed from: com.paypal.android.sdk.F */
public class C11722F extends C11736J {

    /* renamed from: a */
    private static final String f36659a = C11722F.class.getSimpleName();

    /* renamed from: b */
    private Context f36660b;

    /* renamed from: c */
    private String f36661c;

    /* renamed from: d */
    private Handler f36662d;

    public C11722F(Context context, String str, Handler handler) {
        this.f36660b = context;
        this.f36661c = str;
        this.f36662d = handler;
    }

    public void run() {
        C11754P.m38931a(f36659a, "entering LoadConfigurationRequest.");
        Handler handler = this.f36662d;
        if (handler != null) {
            try {
                handler.sendMessage(Message.obtain(handler, 10, this.f36661c));
                this.f36662d.sendMessage(Message.obtain(this.f36662d, 12, new C11994q(this.f36660b, this.f36661c)));
            } catch (Exception e) {
                C11754P.m38932a(f36659a, "LoadConfigurationRequest loading remote config failed.", (Throwable) e);
                this.f36662d.sendMessage(Message.obtain(this.f36662d, 11, e));
            } catch (Throwable th) {
                C11739K.m38870a().mo38580b(this);
                throw th;
            }
            C11739K.m38870a().mo38580b(this);
            C11754P.m38931a(f36659a, "leaving LoadConfigurationRequest.");
        }
    }
}

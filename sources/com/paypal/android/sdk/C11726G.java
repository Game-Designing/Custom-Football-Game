package com.paypal.android.sdk;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.paypal.android.sdk.G */
public final class C11726G extends C11736J {

    /* renamed from: a */
    private String f36671a;

    /* renamed from: b */
    private HashMap f36672b;

    /* renamed from: c */
    private Map f36673c = new HashMap();

    /* renamed from: d */
    private Handler f36674d;

    /* renamed from: e */
    private boolean f36675e;

    static {
        C12010u.class.getSimpleName();
    }

    public C11726G(String str, HashMap hashMap, Handler handler, boolean z) {
        this.f36671a = str;
        this.f36672b = hashMap;
        this.f36674d = handler;
        this.f36675e = z;
    }

    public final void run() {
        Handler handler;
        Message obtain;
        String str;
        String str2 = "NV";
        Handler handler2 = this.f36674d;
        if (handler2 != null) {
            try {
                handler2.sendMessage(Message.obtain(handler2, 0, this.f36671a));
                if (!this.f36675e) {
                    this.f36673c.put("CLIENT-AUTH", "No cert");
                }
                this.f36673c.put("X-PAYPAL-RESPONSE-DATA-FORMAT", str2);
                this.f36673c.put("X-PAYPAL-REQUEST-DATA-FORMAT", str2);
                this.f36673c.put("X-PAYPAL-SERVICE-VERSION", "1.0.0");
                if (this.f36675e) {
                    C11714D a = C12010u.f37759c.mo38559a();
                    a.mo38556a(Uri.parse(this.f36671a));
                    a.mo38557a(this.f36673c);
                    HashMap hashMap = this.f36672b;
                    StringBuilder sb = new StringBuilder();
                    Iterator it = hashMap.entrySet().iterator();
                    boolean z = true;
                    while (true) {
                        str = "UTF-8";
                        if (!it.hasNext()) {
                            break;
                        }
                        Entry entry = (Entry) it.next();
                        if (z) {
                            z = false;
                        } else {
                            sb.append("&");
                        }
                        sb.append(URLEncoder.encode((String) entry.getKey(), str));
                        sb.append("=");
                        sb.append(URLEncoder.encode((String) entry.getValue(), str));
                    }
                    int a2 = a.mo38555a(sb.toString().getBytes(str));
                    if (a2 == 200) {
                        String str3 = new String(a.mo38558a(), str);
                        handler = this.f36674d;
                        obtain = Message.obtain(this.f36674d, 2, str3);
                    } else {
                        StringBuilder sb2 = new StringBuilder("Network Connection Error with wrong http code: ");
                        sb2.append(a2);
                        throw new Exception(sb2.toString());
                    }
                } else {
                    handler = this.f36674d;
                    obtain = Message.obtain(this.f36674d, 2, "not supported");
                }
                handler.sendMessage(obtain);
            } catch (Exception e) {
                this.f36674d.sendMessage(Message.obtain(this.f36674d, 1, e));
            } catch (Throwable th) {
                C11739K.m38870a().mo38580b(this);
                throw th;
            }
            C11739K.m38870a().mo38580b(this);
        }
    }
}

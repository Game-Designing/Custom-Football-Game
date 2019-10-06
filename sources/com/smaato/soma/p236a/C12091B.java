package com.smaato.soma.p236a;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12369fa;
import com.smaato.soma.p236a.p237a.C12110a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p239c.C12203d;
import com.smaato.soma.p239c.p241b.C12173m;
import com.smaato.soma.p239c.p241b.C12179s;
import com.smaato.soma.p259h.C12396b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.smaato.soma.a.B */
/* compiled from: MraidController */
class C12091B {

    /* renamed from: a */
    private C12173m f37962a;

    /* renamed from: b */
    private C12179s f37963b;

    C12091B() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39318a(Context context, C12369fa bannerView, WebView webView) {
        C12146d.m39966a((Object) new C12139z(this));
        this.f37963b = new C12179s(context, bannerView, webView);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39319a(Handler handler, Context context, C12125n abstractBannerPackage) {
        this.f37962a = new C12173m(handler, context, abstractBannerPackage);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C12179s mo39321b() {
        return this.f37963b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C12173m mo39315a() {
        return this.f37962a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39320a(C12173m mraidBridge) {
        this.f37962a = mraidBridge;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo39316a(C12064Na richMediaBanner, Context context) {
        String mediaData;
        String centerStyle;
        C12146d.m39966a((Object) new C12090A(this));
        C12203d banner = C12396b.m40776a().mo39894b();
        if (banner == null || banner.mo39286c() == null) {
            mediaData = richMediaBanner.mo39286c();
        } else {
            mediaData = banner.mo39286c();
        }
        if (Pattern.compile("[.|<|\"|'](style|css)|(style|css)[.|>|\"|=|:|']").matcher(mediaData).find()) {
            centerStyle = "";
        } else {
            centerStyle = C12110a.m39907a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html lang='en' style='height:100%;'>  <head>    <meta name='viewport' content='width=device-width,height=device-height,initial-scale=1.0'/>    <script>");
        sb.append(mo39317a("mraid.js", context));
        sb.append("</script>  </head>  <body style='margin: 0; padding: 0; min-height:100%; ");
        sb.append(centerStyle);
        sb.append("'>    <div id='smaato-ad-container'>");
        sb.append(mediaData);
        sb.append(C12125n.m39912a(richMediaBanner));
        sb.append("    </div>  </body></html>");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo39317a(String fileName, Context context) {
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[Opcodes.ACC_ABSTRACT];
            while (true) {
                int read = inputStream.read(buffer);
                int length = read;
                if (read == -1) {
                    return result.toString("UTF-8");
                }
                result.write(buffer, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

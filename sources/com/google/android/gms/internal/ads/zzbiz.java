package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@zzard
public class zzbiz extends WebViewClient {

    /* renamed from: a */
    private static final String[] f25404a = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};

    /* renamed from: b */
    private static final String[] f25405b = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};

    /* renamed from: c */
    private zzbje f25406c;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo30670a(zzbje zzbje) {
        this.f25406c = zzbje;
    }

    public final void onPageFinished(WebView webView, String str) {
        if (str != null) {
            zzbja zzbja = new zzbja(str);
            zzbje zzbje = this.f25406c;
            if (zzbje != null) {
                zzbje.mo30681a(zzbja);
            } else {
                mo28843a(zzbja);
            }
        }
    }

    /* renamed from: a */
    public void mo28843a(zzbja zzbja) {
    }

    public final void onLoadResource(WebView webView, String str) {
        if (str != null) {
            String str2 = "Loading resource: ";
            String valueOf = String.valueOf(str);
            zzawz.m26003f(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            mo28844b(new zzbja(str));
        }
    }

    /* renamed from: b */
    public void mo28844b(zzbja zzbja) {
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null) {
            return false;
        }
        return mo28845c(new zzbja(str));
    }

    @TargetApi(24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return false;
        }
        return mo28845c(new zzbja(webResourceRequest));
    }

    /* renamed from: c */
    public boolean mo28845c(zzbja zzbja) {
        return false;
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str == null) {
            return null;
        }
        return mo30664d(new zzbja(str));
    }

    @TargetApi(24)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return mo30664d(new zzbja(webResourceRequest));
    }

    /* renamed from: d */
    public WebResourceResponse mo30664d(zzbja zzbja) {
        return null;
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (i >= 0 || (-i) - 1 >= f25404a.length) {
            String.valueOf(i);
        }
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            if (primaryError < 0 || primaryError >= f25405b.length) {
                String.valueOf(primaryError);
            }
            sslError.getUrl();
        }
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (!(keyCode == 79 || keyCode == 222)) {
            switch (keyCode) {
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                    break;
                default:
                    switch (keyCode) {
                        case Opcodes.IAND /*126*/:
                        case Opcodes.LAND /*127*/:
                        case 128:
                        case Opcodes.LOR /*129*/:
                        case Opcodes.IXOR /*130*/:
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }
}

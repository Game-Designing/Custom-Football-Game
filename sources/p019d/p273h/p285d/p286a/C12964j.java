package p019d.p273h.p285d.p286a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: d.h.d.a.j */
/* compiled from: ISNAdViewWebClient */
public class C12964j extends WebViewClient {

    /* renamed from: a */
    private C12958a f39908a;

    /* renamed from: a */
    private String m42262a(String methodName, String errorCode) {
        String str = "ISNAdViewWebClient | External Adunit failed to load.";
        String str2 = "Status code: ";
        StringBuilder sb = new StringBuilder();
        sb.append("ISNAdViewWebClient | External Adunit failed to load.");
        sb.append(methodName);
        sb.append(" ");
        sb.append("Status code: ");
        sb.append(errorCode);
        return sb.toString();
    }

    public C12964j(C12958a iErrorReportDelegate) {
        this.f39908a = iErrorReportDelegate;
    }

    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        String statusCode = "";
        try {
            if (VERSION.SDK_INT >= 21) {
                statusCode = String.valueOf(errorResponse.getStatusCode());
            }
            this.f39908a.mo41793a(m42262a("onReceivedHttpError", statusCode));
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onReceivedHttpError(view, request, errorResponse);
    }

    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        try {
            this.f39908a.mo41793a(m42262a("onReceivedError", String.valueOf(errorCode)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onReceivedError(view, errorCode, description, failingUrl);
    }

    @TargetApi(23)
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        try {
            this.f39908a.mo41793a(m42262a("onReceivedErrorM", String.valueOf(error.getErrorCode())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onReceivedError(view, request, error);
    }
}

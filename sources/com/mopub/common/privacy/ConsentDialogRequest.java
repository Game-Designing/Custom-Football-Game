package com.mopub.common.privacy;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.network.MoPubRequest;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.toolbox.HttpHeaderParser;
import org.json.JSONException;
import org.json.JSONObject;

class ConsentDialogRequest extends MoPubRequest<C11270i> {

    /* renamed from: s */
    private Listener f34447s;

    public interface Listener extends ErrorListener {
        void onSuccess(C11270i iVar);
    }

    ConsentDialogRequest(Context context, String url, Listener listener) {
        super(context, url, listener);
        this.f34447s = listener;
        setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f));
        setShouldCache(false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Response<C11270i> mo36680a(NetworkResponse networkResponse) {
        try {
            String html = new JSONObject(mo38295b(networkResponse)).getString("dialog_html");
            if (!TextUtils.isEmpty(html)) {
                return Response.success(new C11270i(html), HttpHeaderParser.parseCacheHeaders(networkResponse));
            }
            throw new JSONException("Empty HTML body");
        } catch (JSONException e) {
            return Response.error(new MoPubNetworkError("Unable to parse consent dialog request network response.", Reason.BAD_BODY, (Integer) null));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void deliverResponse(C11270i consentDialogResponse) {
        Listener listener = this.f34447s;
        if (listener != null) {
            listener.onSuccess(consentDialogResponse);
        }
    }
}

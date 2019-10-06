package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.network.MoPubRequestUtils;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;
import com.mopub.volley.toolbox.JsonRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PositioningRequest extends JsonRequest<MoPubClientPositioning> {

    /* renamed from: u */
    private final String f36011u;

    /* renamed from: v */
    private final Context f36012v;

    public PositioningRequest(Context context, String url, Listener<MoPubClientPositioning> listener, ErrorListener errorListener) {
        super(MoPubRequestUtils.chooseMethod(url), MoPubRequestUtils.truncateQueryParamsIfPost(url), null, listener, errorListener);
        this.f36011u = url;
        this.f36012v = context.getApplicationContext();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void deliverResponse(MoPubClientPositioning response) {
        super.deliverResponse(response);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Response<MoPubClientPositioning> mo36680a(NetworkResponse response) {
        if (response.statusCode != 200) {
            return Response.error(new VolleyError(response));
        }
        byte[] bArr = response.data;
        if (bArr.length == 0) {
            return Response.error(new VolleyError("Empty positioning response", new JSONException("Empty response")));
        }
        try {
            return Response.success(mo38065b(new String(bArr, HttpHeaderParser.parseCharset(response.headers))), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new VolleyError("Couldn't parse JSON from Charset", e));
        } catch (JSONException e2) {
            return Response.error(new VolleyError("JSON Parsing Error", e2));
        } catch (MoPubNetworkError e3) {
            return Response.error(e3);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: b */
    public MoPubClientPositioning mo38065b(String jsonString) throws JSONException, MoPubNetworkError {
        JSONObject jsonObject = new JSONObject(jsonString);
        String error = jsonObject.optString("error", null);
        if (error == null) {
            JSONArray fixed = jsonObject.optJSONArray("fixed");
            JSONObject repeating = jsonObject.optJSONObject("repeating");
            if (fixed == null && repeating == null) {
                throw new JSONException("Must contain fixed or repeating positions");
            }
            MoPubClientPositioning positioning = new MoPubClientPositioning();
            if (fixed != null) {
                m38353a(fixed, positioning);
            }
            if (repeating != null) {
                m38354a(repeating, positioning);
            }
            return positioning;
        } else if (error.equalsIgnoreCase("WARMING_UP")) {
            throw new MoPubNetworkError(Reason.WARMING_UP);
        } else {
            throw new JSONException(error);
        }
    }

    /* renamed from: a */
    private void m38353a(JSONArray fixed, MoPubClientPositioning positioning) throws JSONException {
        int i = 0;
        while (i < fixed.length()) {
            JSONObject positionObject = fixed.getJSONObject(i);
            int section = positionObject.optInt("section", 0);
            String str = " in JSON response";
            if (section >= 0) {
                if (section <= 0) {
                    int position = positionObject.getInt("position");
                    if (position < 0 || position > 65536) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid position ");
                        sb.append(position);
                        sb.append(str);
                        throw new JSONException(sb.toString());
                    }
                    positioning.addFixedPosition(position);
                }
                i++;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid section ");
                sb2.append(section);
                sb2.append(str);
                throw new JSONException(sb2.toString());
            }
        }
    }

    /* renamed from: a */
    private void m38354a(JSONObject repeatingObject, MoPubClientPositioning positioning) throws JSONException {
        int interval = repeatingObject.getInt("interval");
        if (interval < 2 || interval > 65536) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid interval ");
            sb.append(interval);
            sb.append(" in JSON response");
            throw new JSONException(sb.toString());
        }
        positioning.enableRepeatingPositions(interval);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Map<String, String> mo38066e() {
        if (!MoPubRequestUtils.isMoPubRequest(getUrl())) {
            return null;
        }
        return MoPubRequestUtils.convertQueryToMap(this.f36012v, this.f36011u);
    }

    public byte[] getBody() {
        String body = MoPubRequestUtils.generateBodyFromParams(mo38066e(), getUrl());
        if (body == null) {
            return null;
        }
        return body.getBytes();
    }
}

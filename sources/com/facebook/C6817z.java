package com.facebook;

import android.util.Log;
import com.facebook.internal.C6676H;
import com.facebook.internal.C6694S;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.facebook.z */
/* compiled from: GraphResponse */
public class C6817z {

    /* renamed from: a */
    private static final String f12540a = C6817z.class.getSimpleName();

    /* renamed from: b */
    private final HttpURLConnection f12541b;

    /* renamed from: c */
    private final JSONObject f12542c;

    /* renamed from: d */
    private final JSONArray f12543d;

    /* renamed from: e */
    private final FacebookRequestError f12544e;

    /* renamed from: f */
    private final String f12545f;

    /* renamed from: g */
    private final GraphRequest f12546g;

    C6817z(GraphRequest request, HttpURLConnection connection, String rawResponse, JSONObject graphObject) {
        this(request, connection, rawResponse, graphObject, null, null);
    }

    C6817z(GraphRequest request, HttpURLConnection connection, String rawResponse, JSONArray graphObjects) {
        this(request, connection, rawResponse, null, graphObjects, null);
    }

    C6817z(GraphRequest request, HttpURLConnection connection, FacebookRequestError error) {
        this(request, connection, null, null, null, error);
    }

    C6817z(GraphRequest request, HttpURLConnection connection, String rawResponse, JSONObject graphObject, JSONArray graphObjects, FacebookRequestError error) {
        this.f12546g = request;
        this.f12541b = connection;
        this.f12545f = rawResponse;
        this.f12542c = graphObject;
        this.f12543d = graphObjects;
        this.f12544e = error;
    }

    /* renamed from: a */
    public final FacebookRequestError mo20227a() {
        return this.f12544e;
    }

    /* renamed from: b */
    public final JSONObject mo20228b() {
        return this.f12542c;
    }

    public String toString() {
        String responseCode;
        try {
            Locale locale = Locale.US;
            String str = "%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.f12541b != null ? this.f12541b.getResponseCode() : 200);
            responseCode = String.format(locale, str, objArr);
        } catch (IOException e) {
            responseCode = "unknown";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{Response: ");
        sb.append(" responseCode: ");
        sb.append(responseCode);
        sb.append(", graphObject: ");
        sb.append(this.f12542c);
        sb.append(", error: ");
        sb.append(this.f12544e);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    static List<C6817z> m13912a(HttpURLConnection connection, C6814y requests) {
        InputStream stream;
        String str = "Response <Error>: %s";
        String str2 = "Response";
        InputStream stream2 = null;
        try {
            if (C6787r.m13828r()) {
                if (connection.getResponseCode() >= 400) {
                    stream = connection.getErrorStream();
                } else {
                    stream = connection.getInputStream();
                }
                return m13910a(stream2, connection, requests);
            }
            String msg = "GraphRequest can't be used when Facebook SDK isn't fully initialized";
            Log.e(f12540a, msg);
            throw new FacebookException(msg);
        } catch (FacebookException facebookException) {
            C6676H.m13323a(C6537C.REQUESTS, str2, str, facebookException);
            return m13914a((List<GraphRequest>) requests, connection, facebookException);
        } catch (Exception exception) {
            C6676H.m13323a(C6537C.REQUESTS, str2, str, exception);
            return m13914a((List<GraphRequest>) requests, connection, new FacebookException((Throwable) exception));
        } finally {
            C6694S.m13420a((Closeable) stream2);
        }
    }

    /* renamed from: a */
    static List<C6817z> m13910a(InputStream stream, HttpURLConnection connection, C6814y requests) throws FacebookException, JSONException, IOException {
        String responseString = C6694S.m13402a(stream);
        C6676H.m13323a(C6537C.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(responseString.length()), responseString);
        return m13911a(responseString, connection, requests);
    }

    /* renamed from: a */
    static List<C6817z> m13911a(String responseString, HttpURLConnection connection, C6814y requests) throws FacebookException, JSONException, IOException {
        List<GraphResponse> responses = m13913a(connection, (List<GraphRequest>) requests, new JSONTokener(responseString).nextValue());
        C6676H.m13323a(C6537C.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", requests.mo20220h(), Integer.valueOf(responseString.length()), responses);
        return responses;
    }

    /* renamed from: a */
    private static List<C6817z> m13913a(HttpURLConnection connection, List<GraphRequest> requests, Object object) throws FacebookException, JSONException {
        int numRequests = requests.size();
        List<GraphResponse> responses = new ArrayList<>(numRequests);
        Object originalResult = object;
        if (numRequests == 1) {
            GraphRequest request = (GraphRequest) requests.get(0);
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("body", object);
                jsonObject.put("code", connection != null ? connection.getResponseCode() : 200);
                JSONArray jsonArray = new JSONArray();
                jsonArray.put(jsonObject);
                object = jsonArray;
            } catch (JSONException e) {
                responses.add(new C6817z(request, connection, new FacebookRequestError(connection, (Exception) e)));
            } catch (IOException e2) {
                responses.add(new C6817z(request, connection, new FacebookRequestError(connection, (Exception) e2)));
            }
        }
        if (!(object instanceof JSONArray) || ((JSONArray) object).length() != numRequests) {
            throw new FacebookException("Unexpected number of results");
        }
        JSONArray jsonArray2 = (JSONArray) object;
        for (int i = 0; i < jsonArray2.length(); i++) {
            GraphRequest request2 = (GraphRequest) requests.get(i);
            try {
                responses.add(m13909a(request2, connection, jsonArray2.get(i), originalResult));
            } catch (JSONException e3) {
                responses.add(new C6817z(request2, connection, new FacebookRequestError(connection, (Exception) e3)));
            } catch (FacebookException e4) {
                responses.add(new C6817z(request2, connection, new FacebookRequestError(connection, (Exception) e4)));
            }
        }
        return responses;
    }

    /* renamed from: a */
    private static C6817z m13909a(GraphRequest request, HttpURLConnection connection, Object object, Object originalResult) throws JSONException {
        if (object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
            FacebookRequestError error = FacebookRequestError.m12857a(jsonObject, originalResult, connection);
            if (error != null) {
                Log.e(f12540a, error.toString());
                if (error.mo19661b() == 190 && C6694S.m13428a(request.mo19683d())) {
                    if (error.mo19667g() != 493) {
                        AccessToken.m12819b(null);
                    } else if (!AccessToken.m12820c().mo19633n()) {
                        AccessToken.m12817a();
                    }
                }
                return new C6817z(request, connection, error);
            }
            Object body = C6694S.m13400a(jsonObject, "body", "FACEBOOK_NON_JSON_RESULT");
            if (body instanceof JSONObject) {
                return new C6817z(request, connection, body.toString(), (JSONObject) body);
            }
            if (body instanceof JSONArray) {
                return new C6817z(request, connection, body.toString(), (JSONArray) body);
            }
            object = JSONObject.NULL;
        }
        if (object == JSONObject.NULL) {
            return new C6817z(request, connection, object.toString(), (JSONObject) null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Got unexpected object type in response, class: ");
        sb.append(object.getClass().getSimpleName());
        throw new FacebookException(sb.toString());
    }

    /* renamed from: a */
    static List<C6817z> m13914a(List<GraphRequest> requests, HttpURLConnection connection, FacebookException error) {
        int count = requests.size();
        List<GraphResponse> responses = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            responses.add(new C6817z((GraphRequest) requests.get(i), connection, new FacebookRequestError(connection, (Exception) error)));
        }
        return responses;
    }
}

package com.facebook;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.C6814y.C6815a;
import com.facebook.C6814y.C6816b;
import com.facebook.internal.C6673E;
import com.facebook.internal.C6676H;
import com.facebook.internal.C6690N;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6697T;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphRequest {

    /* renamed from: a */
    public static final String f11802a = GraphRequest.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f11803b;

    /* renamed from: c */
    private static String f11804c;

    /* renamed from: d */
    private static Pattern f11805d = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");

    /* renamed from: e */
    private static volatile String f11806e;

    /* renamed from: f */
    private AccessToken f11807f;

    /* renamed from: g */
    private C6534A f11808g;

    /* renamed from: h */
    private String f11809h;

    /* renamed from: i */
    private JSONObject f11810i;

    /* renamed from: j */
    private String f11811j;

    /* renamed from: k */
    private String f11812k;

    /* renamed from: l */
    private boolean f11813l;

    /* renamed from: m */
    private Bundle f11814m;

    /* renamed from: n */
    private C6545b f11815n;

    /* renamed from: o */
    private String f11816o;

    /* renamed from: p */
    private Object f11817p;

    /* renamed from: q */
    private String f11818q;

    /* renamed from: r */
    private boolean f11819r;

    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Creator<ParcelableResourceWithMimeType> CREATOR = new C6812w();

        /* renamed from: a */
        private final String f11820a;

        /* renamed from: b */
        private final RESOURCE f11821b;

        /* synthetic */ ParcelableResourceWithMimeType(Parcel x0, C6789s x1) {
            this(x0);
        }

        /* renamed from: a */
        public String mo19694a() {
            return this.f11820a;
        }

        /* renamed from: b */
        public RESOURCE mo19695b() {
            return this.f11821b;
        }

        public int describeContents() {
            return 1;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeString(this.f11820a);
            out.writeParcelable(this.f11821b, flags);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, String mimeType) {
            this.f11820a = mimeType;
            this.f11821b = resource;
        }

        private ParcelableResourceWithMimeType(Parcel in) {
            this.f11820a = in.readString();
            this.f11821b = in.readParcelable(C6787r.m13815e().getClassLoader());
        }
    }

    /* renamed from: com.facebook.GraphRequest$a */
    private static class C6544a {

        /* renamed from: a */
        private final GraphRequest f11822a;

        /* renamed from: b */
        private final Object f11823b;

        public C6544a(GraphRequest request, Object value) {
            this.f11822a = request;
            this.f11823b = value;
        }

        /* renamed from: a */
        public GraphRequest mo19698a() {
            return this.f11822a;
        }

        /* renamed from: b */
        public Object mo19699b() {
            return this.f11823b;
        }
    }

    /* renamed from: com.facebook.GraphRequest$b */
    public interface C6545b {
        /* renamed from: a */
        void mo9460a(C6817z zVar);
    }

    /* renamed from: com.facebook.GraphRequest$c */
    public interface C6546c {
        /* renamed from: a */
        void mo19700a(JSONObject jSONObject, C6817z zVar);
    }

    /* renamed from: com.facebook.GraphRequest$d */
    private interface C6547d {
        /* renamed from: a */
        void mo19701a(String str, String str2) throws IOException;
    }

    /* renamed from: com.facebook.GraphRequest$e */
    public interface C6548e extends C6545b {
        /* renamed from: a */
        void mo19702a(long j, long j2);
    }

    /* renamed from: com.facebook.GraphRequest$f */
    private static class C6549f implements C6547d {

        /* renamed from: a */
        private final OutputStream f11824a;

        /* renamed from: b */
        private final C6676H f11825b;

        /* renamed from: c */
        private boolean f11826c = true;

        /* renamed from: d */
        private boolean f11827d = false;

        public C6549f(OutputStream outputStream, C6676H logger, boolean useUrlEncode) {
            this.f11824a = outputStream;
            this.f11825b = logger;
            this.f11827d = useUrlEncode;
        }

        /* renamed from: a */
        public void mo19707a(String key, Object value, GraphRequest request) throws IOException {
            OutputStream outputStream = this.f11824a;
            if (outputStream instanceof C6553K) {
                ((C6553K) outputStream).mo19714a(request);
            }
            if (GraphRequest.m12905e(value)) {
                mo19701a(key, GraphRequest.m12906f(value));
            } else if (value instanceof Bitmap) {
                mo19704a(key, (Bitmap) value);
            } else if (value instanceof byte[]) {
                mo19710a(key, (byte[]) value);
            } else if (value instanceof Uri) {
                mo19705a(key, (Uri) value, (String) null);
            } else if (value instanceof ParcelFileDescriptor) {
                mo19706a(key, (ParcelFileDescriptor) value, (String) null);
            } else if (value instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType resourceWithMimeType = (ParcelableResourceWithMimeType) value;
                Parcelable resource = resourceWithMimeType.mo19695b();
                String mimeType = resourceWithMimeType.mo19694a();
                if (resource instanceof ParcelFileDescriptor) {
                    mo19706a(key, (ParcelFileDescriptor) resource, mimeType);
                } else if (resource instanceof Uri) {
                    mo19705a(key, (Uri) resource, mimeType);
                } else {
                    throw m12939b();
                }
            } else {
                throw m12939b();
            }
        }

        /* renamed from: b */
        private RuntimeException m12939b() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        /* renamed from: a */
        public void mo19709a(String key, JSONArray requestJsonArray, Collection<GraphRequest> requests) throws IOException, JSONException {
            OutputStream outputStream = this.f11824a;
            if (!(outputStream instanceof C6553K)) {
                mo19701a(key, requestJsonArray.toString());
                return;
            }
            C6553K requestOutputStream = (C6553K) outputStream;
            mo19708a(key, (String) null, (String) null);
            mo19711a("[", new Object[0]);
            int i = 0;
            for (GraphRequest request : requests) {
                JSONObject requestJson = requestJsonArray.getJSONObject(i);
                requestOutputStream.mo19714a(request);
                if (i > 0) {
                    mo19711a(",%s", requestJson.toString());
                } else {
                    mo19711a("%s", requestJson.toString());
                }
                i++;
            }
            mo19711a("]", new Object[0]);
            C6676H h = this.f11825b;
            if (h != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(key);
                h.mo19889a(sb.toString(), (Object) requestJsonArray.toString());
            }
        }

        /* renamed from: a */
        public void mo19701a(String key, String value) throws IOException {
            mo19708a(key, (String) null, (String) null);
            mo19712b("%s", value);
            mo19703a();
            C6676H h = this.f11825b;
            if (h != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(key);
                h.mo19889a(sb.toString(), (Object) value);
            }
        }

        /* renamed from: a */
        public void mo19704a(String key, Bitmap bitmap) throws IOException {
            mo19708a(key, key, "image/png");
            bitmap.compress(CompressFormat.PNG, 100, this.f11824a);
            mo19712b("", new Object[0]);
            mo19703a();
            C6676H h = this.f11825b;
            if (h != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(key);
                h.mo19889a(sb.toString(), (Object) "<Image>");
            }
        }

        /* renamed from: a */
        public void mo19710a(String key, byte[] bytes) throws IOException {
            mo19708a(key, key, "content/unknown");
            this.f11824a.write(bytes);
            mo19712b("", new Object[0]);
            mo19703a();
            C6676H h = this.f11825b;
            if (h != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(key);
                h.mo19889a(sb.toString(), (Object) String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(bytes.length)}));
            }
        }

        /* renamed from: a */
        public void mo19705a(String key, Uri contentUri, String mimeType) throws IOException {
            if (mimeType == null) {
                mimeType = "content/unknown";
            }
            mo19708a(key, key, mimeType);
            int totalBytes = 0;
            if (this.f11824a instanceof C6550H) {
                ((C6550H) this.f11824a).mo19716h(C6694S.m13396a(contentUri));
            } else {
                totalBytes = 0 + C6694S.m13394a(C6787r.m13815e().getContentResolver().openInputStream(contentUri), this.f11824a);
            }
            mo19712b("", new Object[0]);
            mo19703a();
            C6676H h = this.f11825b;
            if (h != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(key);
                h.mo19889a(sb.toString(), (Object) String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(totalBytes)}));
            }
        }

        /* renamed from: a */
        public void mo19706a(String key, ParcelFileDescriptor descriptor, String mimeType) throws IOException {
            if (mimeType == null) {
                mimeType = "content/unknown";
            }
            mo19708a(key, key, mimeType);
            int totalBytes = 0;
            OutputStream outputStream = this.f11824a;
            if (outputStream instanceof C6550H) {
                ((C6550H) outputStream).mo19716h(descriptor.getStatSize());
            } else {
                totalBytes = 0 + C6694S.m13394a((InputStream) new AutoCloseInputStream(descriptor), this.f11824a);
            }
            mo19712b("", new Object[0]);
            mo19703a();
            C6676H h = this.f11825b;
            if (h != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(key);
                h.mo19889a(sb.toString(), (Object) String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(totalBytes)}));
            }
        }

        /* renamed from: a */
        public void mo19703a() throws IOException {
            if (!this.f11827d) {
                mo19712b("--%s", GraphRequest.f11803b);
                return;
            }
            this.f11824a.write("&".getBytes());
        }

        /* renamed from: a */
        public void mo19708a(String name, String filename, String contentType) throws IOException {
            if (!this.f11827d) {
                mo19711a("Content-Disposition: form-data; name=\"%s\"", name);
                if (filename != null) {
                    mo19711a("; filename=\"%s\"", filename);
                }
                String str = "";
                mo19712b(str, new Object[0]);
                if (contentType != null) {
                    mo19712b("%s: %s", "Content-Type", contentType);
                }
                mo19712b(str, new Object[0]);
                return;
            }
            this.f11824a.write(String.format("%s=", new Object[]{name}).getBytes());
        }

        /* renamed from: a */
        public void mo19711a(String format, Object... args) throws IOException {
            if (!this.f11827d) {
                if (this.f11826c) {
                    this.f11824a.write("--".getBytes());
                    this.f11824a.write(GraphRequest.f11803b.getBytes());
                    this.f11824a.write("\r\n".getBytes());
                    this.f11826c = false;
                }
                this.f11824a.write(String.format(format, args).getBytes());
                return;
            }
            this.f11824a.write(URLEncoder.encode(String.format(Locale.US, format, args), "UTF-8").getBytes());
        }

        /* renamed from: b */
        public void mo19712b(String format, Object... args) throws IOException {
            mo19711a(format, args);
            if (!this.f11827d) {
                mo19711a("\r\n", new Object[0]);
            }
        }
    }

    static {
        char[] chars = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder buffer = new StringBuilder();
        SecureRandom random = new SecureRandom();
        int count = random.nextInt(11) + 30;
        for (int i = 0; i < count; i++) {
            buffer.append(chars[random.nextInt(chars.length)]);
        }
        f11803b = buffer.toString();
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accessToken, String graphPath, Bundle parameters, C6534A httpMethod, C6545b callback) {
        this(accessToken, graphPath, parameters, httpMethod, callback, null);
    }

    public GraphRequest(AccessToken accessToken, String graphPath, Bundle parameters, C6534A httpMethod, C6545b callback, String version) {
        this.f11813l = true;
        this.f11819r = false;
        this.f11807f = accessToken;
        this.f11809h = graphPath;
        this.f11818q = version;
        mo19677a(callback);
        mo19676a(httpMethod);
        if (parameters != null) {
            this.f11814m = new Bundle(parameters);
        } else {
            this.f11814m = new Bundle();
        }
        if (this.f11818q == null) {
            this.f11818q = C6787r.m13824n();
        }
    }

    /* renamed from: a */
    public static GraphRequest m12873a(AccessToken accessToken, C6546c callback) {
        AccessToken accessToken2 = accessToken;
        GraphRequest graphRequest = new GraphRequest(accessToken2, "me", null, null, new C6789s(callback));
        return graphRequest;
    }

    /* renamed from: a */
    public static GraphRequest m12875a(AccessToken accessToken, String graphPath, JSONObject graphObject, C6545b callback) {
        GraphRequest request = new GraphRequest(accessToken, graphPath, null, C6534A.POST, callback);
        request.mo19678a(graphObject);
        return request;
    }

    /* renamed from: a */
    public static GraphRequest m12874a(AccessToken accessToken, String graphPath, C6545b callback) {
        GraphRequest graphRequest = new GraphRequest(accessToken, graphPath, null, null, callback);
        return graphRequest;
    }

    /* renamed from: f */
    public final JSONObject mo19685f() {
        return this.f11810i;
    }

    /* renamed from: a */
    public final void mo19678a(JSONObject graphObject) {
        this.f11810i = graphObject;
    }

    /* renamed from: g */
    public final String mo19686g() {
        return this.f11809h;
    }

    /* renamed from: h */
    public final C6534A mo19687h() {
        return this.f11808g;
    }

    /* renamed from: a */
    public final void mo19676a(C6534A httpMethod) {
        if (this.f11816o == null || httpMethod == C6534A.GET) {
            this.f11808g = httpMethod != null ? httpMethod : C6534A.GET;
            return;
        }
        throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }

    /* renamed from: m */
    public final String mo19692m() {
        return this.f11818q;
    }

    /* renamed from: a */
    public final void mo19679a(boolean skipClientToken) {
        this.f11819r = skipClientToken;
    }

    /* renamed from: i */
    public final Bundle mo19688i() {
        return this.f11814m;
    }

    /* renamed from: a */
    public final void mo19675a(Bundle parameters) {
        this.f11814m = parameters;
    }

    /* renamed from: d */
    public final AccessToken mo19683d() {
        return this.f11807f;
    }

    /* renamed from: e */
    public final C6545b mo19684e() {
        return this.f11815n;
    }

    /* renamed from: a */
    public final void mo19677a(C6545b callback) {
        if (C6787r.m13808a(C6537C.GRAPH_API_DEBUG_INFO) || C6787r.m13808a(C6537C.GRAPH_API_DEBUG_WARNING)) {
            this.f11815n = new C6809t(this, callback);
        } else {
            this.f11815n = callback;
        }
    }

    /* renamed from: c */
    public final void mo19682c(Object tag) {
        this.f11817p = tag;
    }

    /* renamed from: k */
    public final Object mo19690k() {
        return this.f11817p;
    }

    /* renamed from: b */
    public final C6817z mo19680b() {
        return m12876a(this);
    }

    /* renamed from: c */
    public final C6813x mo19681c() {
        return m12898b(this);
    }

    /* renamed from: c */
    public static HttpURLConnection m12901c(C6814y requests) {
        URL url;
        m12902d(requests);
        try {
            if (requests.size() == 1) {
                url = new URL(requests.get(0).mo19691l());
            } else {
                url = new URL(C6690N.m13389c());
            }
            HttpURLConnection connection = null;
            try {
                connection = m12879a(url);
                m12887a(requests, connection);
                return connection;
            } catch (IOException | JSONException e) {
                C6694S.m13424a((URLConnection) connection);
                throw new FacebookException("could not construct request body", e);
            }
        } catch (MalformedURLException e2) {
            throw new FacebookException("could not construct URL for request", e2);
        }
    }

    /* renamed from: a */
    public static C6817z m12876a(GraphRequest request) {
        List<GraphResponse> responses = m12883a(request);
        if (responses != null && responses.size() == 1) {
            return (C6817z) responses.get(0);
        }
        throw new FacebookException("invalid state: expected a single response");
    }

    /* renamed from: a */
    public static List<C6817z> m12883a(GraphRequest... requests) {
        C6697T.m13461a((Object) requests, "requests");
        return m12882a((Collection<GraphRequest>) Arrays.asList(requests));
    }

    /* renamed from: a */
    public static List<C6817z> m12882a(Collection<GraphRequest> requests) {
        return m12880a(new C6814y(requests));
    }

    /* renamed from: a */
    public static List<C6817z> m12880a(C6814y requests) {
        C6697T.m13469c(requests, "requests");
        HttpURLConnection connection = null;
        try {
            connection = m12901c(requests);
            return m12881a(connection, requests);
        } catch (Exception ex) {
            List<GraphResponse> responses = C6817z.m13914a(requests.mo20221i(), (HttpURLConnection) null, new FacebookException((Throwable) ex));
            m12888a(requests, responses);
            return responses;
        } finally {
            C6694S.m13424a((URLConnection) connection);
        }
    }

    /* renamed from: b */
    public static C6813x m12898b(GraphRequest... requests) {
        C6697T.m13461a((Object) requests, "requests");
        return m12897b((Collection<GraphRequest>) Arrays.asList(requests));
    }

    /* renamed from: b */
    public static C6813x m12897b(Collection<GraphRequest> requests) {
        return m12896b(new C6814y(requests));
    }

    /* renamed from: b */
    public static C6813x m12896b(C6814y requests) {
        C6697T.m13469c(requests, "requests");
        C6813x asyncTask = new C6813x(requests);
        asyncTask.executeOnExecutor(C6787r.m13822l(), new Void[0]);
        return asyncTask;
    }

    /* renamed from: a */
    public static List<C6817z> m12881a(HttpURLConnection connection, C6814y requests) {
        List<GraphResponse> responses = C6817z.m13912a(connection, requests);
        C6694S.m13424a((URLConnection) connection);
        int numRequests = requests.size();
        if (numRequests == responses.size()) {
            m12888a(requests, responses);
            C6663g.m13290d().mo19870b();
            return responses;
        }
        throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", new Object[]{Integer.valueOf(responses.size()), Integer.valueOf(numRequests)}));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Request: ");
        sb.append(" accessToken: ");
        Object obj = this.f11807f;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", graphPath: ");
        sb.append(this.f11809h);
        sb.append(", graphObject: ");
        sb.append(this.f11810i);
        sb.append(", httpMethod: ");
        sb.append(this.f11808g);
        sb.append(", parameters: ");
        sb.append(this.f11814m);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    static void m12888a(C6814y requests, List<C6817z> responses) {
        int numRequests = requests.size();
        ArrayList<Pair<Callback, GraphResponse>> callbacks = new ArrayList<>();
        for (int i = 0; i < numRequests; i++) {
            C6545b bVar = requests.get(i).f11815n;
            if (bVar != null) {
                callbacks.add(new Pair(bVar, responses.get(i)));
            }
        }
        if (callbacks.size() > 0) {
            Runnable runnable = new C6810u(callbacks, requests);
            Handler callbackHandler = requests.mo20217f();
            if (callbackHandler == null) {
                runnable.run();
            } else {
                callbackHandler.post(runnable);
            }
        }
    }

    /* renamed from: a */
    private static HttpURLConnection m12879a(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", m12912q());
        connection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        connection.setChunkedStreamingMode(0);
        return connection;
    }

    /* renamed from: n */
    private void m12909n() {
        String str = "access_token";
        if (this.f11807f != null) {
            if (!this.f11814m.containsKey(str)) {
                String token = this.f11807f.mo19631k();
                C6676H.m13326c(token);
                this.f11814m.putString(str, token);
            }
        } else if (!this.f11819r && !this.f11814m.containsKey(str)) {
            String appID = C6787r.m13816f();
            String clientToken = C6787r.m13820j();
            if (C6694S.m13436b(appID) || C6694S.m13436b(clientToken)) {
                C6694S.m13433b(f11802a, "Warning: Request without access token missing application ID or client token.");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(appID);
                sb.append("|");
                sb.append(clientToken);
                this.f11814m.putString(str, sb.toString());
            }
        }
        this.f11814m.putString("sdk", "android");
        this.f11814m.putString("format", "json");
        String str2 = "debug";
        if (C6787r.m13808a(C6537C.GRAPH_API_DEBUG_INFO)) {
            this.f11814m.putString(str2, "info");
        } else if (C6787r.m13808a(C6537C.GRAPH_API_DEBUG_WARNING)) {
            this.f11814m.putString(str2, "warning");
        }
    }

    /* renamed from: a */
    private String m12878a(String baseUrl, Boolean isBatch) {
        if (!isBatch.booleanValue() && this.f11808g == C6534A.POST) {
            return baseUrl;
        }
        Builder uriBuilder = Uri.parse(baseUrl).buildUpon();
        for (String key : this.f11814m.keySet()) {
            Object value = this.f11814m.get(key);
            if (value == null) {
                value = "";
            }
            if (m12905e(value)) {
                uriBuilder.appendQueryParameter(key, m12906f(value).toString());
            } else if (this.f11808g == C6534A.GET) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[]{value.getClass().getSimpleName()}));
            }
        }
        return uriBuilder.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public final String mo19689j() {
        if (this.f11816o == null) {
            String baseUrl = String.format("%s/%s", new Object[]{C6690N.m13389c(), m12910o()});
            m12909n();
            Uri uri = Uri.parse(m12878a(baseUrl, Boolean.valueOf(true)));
            return String.format("%s?%s", new Object[]{uri.getPath(), uri.getQuery()});
        }
        throw new FacebookException("Can't override URL for a batch request");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public final String mo19691l() {
        String graphBaseUrlBase;
        String str = this.f11816o;
        if (str != null) {
            return str.toString();
        }
        if (mo19687h() == C6534A.POST) {
            String str2 = this.f11809h;
            if (str2 != null && str2.endsWith("/videos")) {
                graphBaseUrlBase = C6690N.m13390d();
                String baseUrl = String.format("%s/%s", new Object[]{graphBaseUrlBase, m12910o()});
                m12909n();
                return m12878a(baseUrl, Boolean.valueOf(false));
            }
        }
        graphBaseUrlBase = C6690N.m13389c();
        String baseUrl2 = String.format("%s/%s", new Object[]{graphBaseUrlBase, m12910o()});
        m12909n();
        return m12878a(baseUrl2, Boolean.valueOf(false));
    }

    /* renamed from: o */
    private String m12910o() {
        if (f11805d.matcher(this.f11809h).matches()) {
            return this.f11809h;
        }
        return String.format("%s/%s", new Object[]{this.f11818q, this.f11809h});
    }

    /* renamed from: a */
    private void m12892a(JSONArray batch, Map<String, C6544a> attachments) throws JSONException, IOException {
        JSONObject batchEntry = new JSONObject();
        String str = this.f11811j;
        if (str != null) {
            batchEntry.put("name", str);
            batchEntry.put("omit_response_on_success", this.f11813l);
        }
        String str2 = this.f11812k;
        if (str2 != null) {
            batchEntry.put("depends_on", str2);
        }
        String relativeURL = mo19689j();
        batchEntry.put("relative_url", relativeURL);
        batchEntry.put("method", this.f11808g);
        AccessToken accessToken = this.f11807f;
        if (accessToken != null) {
            C6676H.m13326c(accessToken.mo19631k());
        }
        ArrayList<String> attachmentNames = new ArrayList<>();
        for (String key : this.f11814m.keySet()) {
            Object value = this.f11814m.get(key);
            if (m12903d(value)) {
                String name = String.format(Locale.ROOT, "%s%d", new Object[]{"file", Integer.valueOf(attachments.size())});
                attachmentNames.add(name);
                attachments.put(name, new C6544a(this, value));
            }
        }
        if (!attachmentNames.isEmpty()) {
            batchEntry.put("attached_files", TextUtils.join(",", attachmentNames));
        }
        if (this.f11810i != null) {
            ArrayList<String> keysAndValues = new ArrayList<>();
            m12893a(this.f11810i, relativeURL, (C6547d) new C6811v(this, keysAndValues));
            batchEntry.put("body", TextUtils.join("&", keysAndValues));
        }
        batch.put(batchEntry);
    }

    /* renamed from: f */
    private static boolean m12907f(C6814y requests) {
        for (C6815a callback : requests.mo20218g()) {
            if (callback instanceof C6816b) {
                return true;
            }
        }
        Iterator it = requests.iterator();
        while (it.hasNext()) {
            if (((GraphRequest) it.next()).mo19684e() instanceof C6548e) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m12890a(HttpURLConnection connection, boolean shouldUseGzip) {
        String str = "Content-Type";
        if (shouldUseGzip) {
            connection.setRequestProperty(str, "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Encoding", "gzip");
            return;
        }
        connection.setRequestProperty(str, m12911p());
    }

    /* renamed from: g */
    private static boolean m12908g(C6814y requests) {
        Iterator it = requests.iterator();
        while (it.hasNext()) {
            GraphRequest request = (GraphRequest) it.next();
            Iterator it2 = request.f11814m.keySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (m12903d(request.f11814m.get((String) it2.next()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    static final boolean m12900b(GraphRequest request) {
        String version = request.mo19692m();
        boolean z = true;
        if (C6694S.m13436b(version)) {
            return true;
        }
        if (version.startsWith("v")) {
            version = version.substring(1);
        }
        String[] versionParts = version.split("\\.");
        if ((versionParts.length < 2 || Integer.parseInt(versionParts[0]) <= 2) && (Integer.parseInt(versionParts[0]) < 2 || Integer.parseInt(versionParts[1]) < 4)) {
            z = false;
        }
        return z;
    }

    /* renamed from: d */
    static final void m12902d(C6814y requests) {
        Iterator it = requests.iterator();
        while (it.hasNext()) {
            GraphRequest request = (GraphRequest) it.next();
            if (C6534A.GET.equals(request.mo19687h()) && m12900b(request)) {
                Bundle params = request.mo19688i();
                String str = "fields";
                if (!params.containsKey(str) || C6694S.m13436b(params.getString(str))) {
                    C6676H.m13321a(C6537C.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", request.mo19686g());
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.io.FilterOutputStream] */
    /* JADX WARNING: type inference failed for: r19v1 */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r19v2 */
    /* JADX WARNING: type inference failed for: r19v3, types: [java.io.FilterOutputStream] */
    /* JADX WARNING: type inference failed for: r8v0, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r13v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r19v4 */
    /* JADX WARNING: type inference failed for: r19v5 */
    /* JADX WARNING: type inference failed for: r19v6 */
    /* JADX WARNING: type inference failed for: r0v12, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARNING: type inference failed for: r19v7 */
    /* JADX WARNING: type inference failed for: r19v8 */
    /* JADX WARNING: type inference failed for: r19v9 */
    /* JADX WARNING: type inference failed for: r19v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fe  */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final void m12887a(com.facebook.C6814y r22, java.net.HttpURLConnection r23) throws java.io.IOException, org.json.JSONException {
        /*
            r1 = r23
            com.facebook.internal.H r0 = new com.facebook.internal.H
            com.facebook.C r2 = com.facebook.C6537C.REQUESTS
            java.lang.String r3 = "Request"
            r0.<init>(r2, r3)
            r2 = r0
            int r10 = r22.size()
            boolean r11 = m12908g(r22)
            r0 = 0
            r3 = 1
            if (r10 != r3) goto L_0x0021
            r9 = r22
            com.facebook.GraphRequest r4 = r9.get(r0)
            com.facebook.A r4 = r4.f11808g
            goto L_0x0025
        L_0x0021:
            r9 = r22
            com.facebook.A r4 = com.facebook.C6534A.POST
        L_0x0025:
            r14 = r4
            java.lang.String r4 = r14.name()
            r1.setRequestMethod(r4)
            m12890a(r1, r11)
            java.net.URL r13 = r23.getURL()
            java.lang.String r4 = "Request:\n"
            r2.mo19888a(r4)
            java.lang.String r4 = r22.mo20220h()
            java.lang.String r5 = "Id"
            r2.mo19889a(r5, r4)
            java.lang.String r4 = "URL"
            r2.mo19889a(r4, r13)
            java.lang.String r4 = r23.getRequestMethod()
            java.lang.String r5 = "Method"
            r2.mo19889a(r5, r4)
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = r1.getRequestProperty(r4)
            r2.mo19889a(r4, r5)
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = r1.getRequestProperty(r4)
            r2.mo19889a(r4, r5)
            int r4 = r22.mo20222j()
            r1.setConnectTimeout(r4)
            int r4 = r22.mo20222j()
            r1.setReadTimeout(r4)
            com.facebook.A r4 = com.facebook.C6534A.POST
            if (r14 != r4) goto L_0x0075
            r0 = 1
        L_0x0075:
            r18 = r0
            if (r18 != 0) goto L_0x007d
            r2.mo19887a()
            return
        L_0x007d:
            r1.setDoOutput(r3)
            r3 = 0
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00f5 }
            java.io.OutputStream r4 = r23.getOutputStream()     // Catch:{ all -> 0x00f5 }
            r0.<init>(r4)     // Catch:{ all -> 0x00f5 }
            r3 = r0
            if (r11 == 0) goto L_0x009e
            java.util.zip.GZIPOutputStream r0 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0095 }
            r0.<init>(r3)     // Catch:{ all -> 0x0095 }
            r19 = r0
            goto L_0x00a0
        L_0x0095:
            r0 = move-exception
            r19 = r3
            r20 = r13
            r21 = r14
            goto L_0x00fc
        L_0x009e:
            r19 = r3
        L_0x00a0:
            boolean r0 = m12907f(r22)     // Catch:{ all -> 0x00ef }
            if (r0 == 0) goto L_0x00d5
            r0 = 0
            com.facebook.H r7 = new com.facebook.H     // Catch:{ all -> 0x00ef }
            android.os.Handler r3 = r22.mo20217f()     // Catch:{ all -> 0x00ef }
            r7.<init>(r3)     // Catch:{ all -> 0x00ef }
            r4 = 0
            r3 = r22
            r5 = r10
            r6 = r13
            r8 = r11
            m12886a(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00ef }
            int r0 = r7.mo19713a()     // Catch:{ all -> 0x00ef }
            java.util.Map r15 = r7.mo19715b()     // Catch:{ all -> 0x00ef }
            com.facebook.J r3 = new com.facebook.J     // Catch:{ all -> 0x00ef }
            long r4 = (long) r0
            r12 = r3
            r20 = r13
            r13 = r19
            r21 = r14
            r14 = r22
            r16 = r4
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x00ed }
            r19 = r3
            goto L_0x00d9
        L_0x00d5:
            r20 = r13
            r21 = r14
        L_0x00d9:
            r4 = r22
            r5 = r2
            r6 = r10
            r7 = r20
            r8 = r19
            r9 = r11
            m12886a(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00ed }
            r19.close()
            r2.mo19887a()
            return
        L_0x00ed:
            r0 = move-exception
            goto L_0x00fc
        L_0x00ef:
            r0 = move-exception
            r20 = r13
            r21 = r14
            goto L_0x00fc
        L_0x00f5:
            r0 = move-exception
            r20 = r13
            r21 = r14
            r19 = r3
        L_0x00fc:
            if (r19 == 0) goto L_0x0101
            r19.close()
        L_0x0101:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.m12887a(com.facebook.y, java.net.HttpURLConnection):void");
    }

    /* renamed from: a */
    private static void m12886a(C6814y requests, C6676H logger, int numRequests, URL url, OutputStream outputStream, boolean shouldUseGzip) throws IOException, JSONException {
        C6549f serializer = new C6549f(outputStream, logger, shouldUseGzip);
        String str = "  Attachments:\n";
        if (numRequests == 1) {
            GraphRequest request = requests.get(0);
            Map<String, Attachment> attachments = new HashMap<>();
            for (String key : request.f11814m.keySet()) {
                Object value = request.f11814m.get(key);
                if (m12903d(value)) {
                    attachments.put(key, new C6544a(request, value));
                }
            }
            if (logger != null) {
                logger.mo19888a("  Parameters:\n");
            }
            m12884a(request.f11814m, serializer, request);
            if (logger != null) {
                logger.mo19888a(str);
            }
            m12891a(attachments, serializer);
            JSONObject jSONObject = request.f11810i;
            if (jSONObject != null) {
                m12893a(jSONObject, url.getPath(), (C6547d) serializer);
                return;
            }
            return;
        }
        String batchAppID = m12904e(requests);
        if (!C6694S.m13436b(batchAppID)) {
            serializer.mo19701a("batch_app_id", batchAppID);
            Map<String, Attachment> attachments2 = new HashMap<>();
            m12885a(serializer, (Collection<GraphRequest>) requests, attachments2);
            if (logger != null) {
                logger.mo19888a(str);
            }
            m12891a(attachments2, serializer);
            return;
        }
        throw new FacebookException("App ID was not specified at the request or Settings.");
    }

    /* renamed from: a */
    private static boolean m12895a(String path) {
        Matcher matcher = f11805d.matcher(path);
        if (matcher.matches()) {
            path = matcher.group(1);
        }
        if (path.startsWith("me/") || path.startsWith("/me/")) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static void m12893a(JSONObject graphObject, String path, C6547d serializer) throws IOException {
        boolean isOGAction = false;
        if (m12895a(path)) {
            int colonLocation = path.indexOf(":");
            int questionMarkLocation = path.indexOf("?");
            isOGAction = colonLocation > 3 && (questionMarkLocation == -1 || colonLocation < questionMarkLocation);
        }
        Iterator<String> keyIterator = graphObject.keys();
        while (keyIterator.hasNext()) {
            String key = (String) keyIterator.next();
            m12889a(key, graphObject.opt(key), serializer, isOGAction && key.equalsIgnoreCase("image"));
        }
    }

    /* renamed from: a */
    private static void m12889a(String key, Object value, C6547d serializer, boolean passByValue) throws IOException {
        Class<?> valueClass = value.getClass();
        if (JSONObject.class.isAssignableFrom(valueClass)) {
            JSONObject jsonObject = (JSONObject) value;
            if (passByValue) {
                Iterator<String> keys = jsonObject.keys();
                while (keys.hasNext()) {
                    String propertyName = (String) keys.next();
                    m12889a(String.format("%s[%s]", new Object[]{key, propertyName}), jsonObject.opt(propertyName), serializer, passByValue);
                }
                return;
            }
            String str = "id";
            if (jsonObject.has(str)) {
                m12889a(key, (Object) jsonObject.optString(str), serializer, passByValue);
                return;
            }
            String str2 = "url";
            if (jsonObject.has(str2)) {
                m12889a(key, (Object) jsonObject.optString(str2), serializer, passByValue);
            } else if (jsonObject.has("fbsdk:create_object")) {
                m12889a(key, (Object) jsonObject.toString(), serializer, passByValue);
            }
        } else if (JSONArray.class.isAssignableFrom(valueClass)) {
            JSONArray jsonArray = (JSONArray) value;
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                m12889a(String.format(Locale.ROOT, "%s[%d]", new Object[]{key, Integer.valueOf(i)}), jsonArray.opt(i), serializer, passByValue);
            }
        } else if (String.class.isAssignableFrom(valueClass) || Number.class.isAssignableFrom(valueClass) || Boolean.class.isAssignableFrom(valueClass)) {
            serializer.mo19701a(key, value.toString());
        } else if (Date.class.isAssignableFrom(valueClass)) {
            serializer.mo19701a(key, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) value));
        }
    }

    /* renamed from: a */
    private static void m12884a(Bundle bundle, C6549f serializer, GraphRequest request) throws IOException {
        for (String key : bundle.keySet()) {
            Object value = bundle.get(key);
            if (m12905e(value)) {
                serializer.mo19707a(key, value, request);
            }
        }
    }

    /* renamed from: a */
    private static void m12891a(Map<String, C6544a> attachments, C6549f serializer) throws IOException {
        for (String key : attachments.keySet()) {
            C6544a attachment = (C6544a) attachments.get(key);
            if (m12903d(attachment.mo19699b())) {
                serializer.mo19707a(key, attachment.mo19699b(), attachment.mo19698a());
            }
        }
    }

    /* renamed from: a */
    private static void m12885a(C6549f serializer, Collection<GraphRequest> requests, Map<String, C6544a> attachments) throws JSONException, IOException {
        JSONArray batch = new JSONArray();
        for (GraphRequest request : requests) {
            request.m12892a(batch, attachments);
        }
        serializer.mo19709a("batch", batch, requests);
    }

    /* renamed from: p */
    private static String m12911p() {
        return String.format("multipart/form-data; boundary=%s", new Object[]{f11803b});
    }

    /* renamed from: q */
    private static String m12912q() {
        if (f11806e == null) {
            f11806e = String.format("%s.%s", new Object[]{"FBAndroidSDK", "5.0.2"});
            String customUserAgent = C6673E.m13316a();
            if (!C6694S.m13436b(customUserAgent)) {
                f11806e = String.format(Locale.ROOT, "%s/%s", new Object[]{f11806e, customUserAgent});
            }
        }
        return f11806e;
    }

    /* renamed from: e */
    private static String m12904e(C6814y batch) {
        if (!C6694S.m13436b(batch.mo20216e())) {
            return batch.mo20216e();
        }
        Iterator it = batch.iterator();
        while (it.hasNext()) {
            AccessToken accessToken = ((GraphRequest) it.next()).f11807f;
            if (accessToken != null) {
                String applicationId = accessToken.mo19620b();
                if (applicationId != null) {
                    return applicationId;
                }
            }
        }
        if (!C6694S.m13436b(f11804c)) {
            return f11804c;
        }
        return C6787r.m13816f();
    }

    /* renamed from: d */
    private static boolean m12903d(Object value) {
        return (value instanceof Bitmap) || (value instanceof byte[]) || (value instanceof Uri) || (value instanceof ParcelFileDescriptor) || (value instanceof ParcelableResourceWithMimeType);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static boolean m12905e(Object value) {
        return (value instanceof String) || (value instanceof Boolean) || (value instanceof Number) || (value instanceof Date);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static String m12906f(Object value) {
        if (value instanceof String) {
            return (String) value;
        }
        if ((value instanceof Boolean) || (value instanceof Number)) {
            return value.toString();
        }
        if (value instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(value);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }
}

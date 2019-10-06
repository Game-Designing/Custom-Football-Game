package com.smaato.soma.p239c.p246f;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.mopub.common.Constants;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12394h;
import com.smaato.soma.exception.LoadingBeaconFailed;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p255d.C12316i;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* renamed from: com.smaato.soma.c.f.n */
/* compiled from: BeaconRequest */
public class C12242n extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    private C12394h f38361a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C12064Na f38362b;

    /* renamed from: c */
    private final String f38363c = "BeaconRequest##";

    public C12242n() {
    }

    public C12242n(C12394h settings, C12064Na banner) {
        this.f38361a = settings;
        this.f38362b = banner;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void doInBackground(String... params) {
        for (String url : params) {
            mo39611a(url);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39611a(String urlString) {
        try {
            C12146d.m39966a((Object) new C12240l(this));
            if (urlString != null) {
                URL url = new URL(urlString);
                if (!m40279a(url)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" firingUrl");
                    sb.append(url);
                    C12146d.m39965a(new C12147e("BeaconRequest##", sb.toString(), 1, C12143a.VERVOSE));
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setRequestProperty("User-Agent", C12252w.m40307b().mo39629e());
                    connection.connect();
                    InputStream is = mo39609a((URLConnection) connection);
                    if (is != null) {
                        is.close();
                    }
                    connection.disconnect();
                    return;
                }
                m40277a(url, C12316i.SOMAAdViolationSSLBeacon);
                throw new LoadingBeaconFailed("Beacon URL must be secure");
            }
        } catch (Exception e) {
            String str = "BeaconRequest##";
            C12147e eVar = new C12147e(str, String.format("Error requesting beacon URL \"%s\".", new Object[]{urlString}), 1, C12143a.EXCEPTION, e);
            C12146d.m39965a(eVar);
        }
    }

    /* renamed from: a */
    static boolean m40278a(int statusCode) {
        return statusCode >= 300 && statusCode <= 307 && statusCode != 304 && statusCode != 306;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public InputStream mo39609a(URLConnection c) throws IOException, LoadingBeaconFailed {
        InputStream in;
        boolean redir;
        int redirects = 0;
        do {
            if (c instanceof HttpURLConnection) {
                ((HttpURLConnection) c).setInstanceFollowRedirects(false);
            }
            in = c.getInputStream();
            redir = false;
            if (c instanceof HttpURLConnection) {
                HttpURLConnection http = (HttpURLConnection) c;
                if (m40278a(http.getResponseCode())) {
                    URL base = http.getURL();
                    String loc = http.getHeaderField("Location");
                    URL target = null;
                    if (loc != null) {
                        target = new URL(base, loc);
                    }
                    http.disconnect();
                    if (m40279a(target)) {
                        m40277a(target, C12316i.SOMAAdViolationSSLBeaconHTTPRedirect);
                        throw new LoadingBeaconFailed("Beacon redirecting to insecure URL");
                    } else if (target != null) {
                        if (!Constants.HTTP.equalsIgnoreCase(target.getProtocol())) {
                            if (!"https".equalsIgnoreCase(target.getProtocol())) {
                                throw new LoadingBeaconFailed("Beacon trying to redirect to non-HTTP(S) URL");
                            }
                        }
                        if (redirects < 5) {
                            redir = true;
                            c = target.openConnection();
                            redirects++;
                            continue;
                        } else {
                            throw new LoadingBeaconFailed("Beacon performing too many redirects (max. 5 allowed)");
                        }
                    } else {
                        throw new LoadingBeaconFailed("Beacon trying to redirect without supplying a target URL");
                    }
                } else {
                    continue;
                }
            }
        } while (redir);
        return in;
    }

    /* renamed from: a */
    private boolean m40279a(URL url) {
        C12394h hVar = this.f38361a;
        if (!(hVar == null || !hVar.mo39892h() || url == null)) {
            if (!"https".equalsIgnoreCase(url.getProtocol())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m40277a(URL url, C12316i fraudType) {
        if (url != null && this.f38361a != null && this.f38362b != null) {
            HashMap<String, String> reportData = new HashMap<>();
            reportData.put("adspace", String.valueOf(this.f38361a.mo39887c()));
            reportData.put("publisher", String.valueOf(this.f38361a.mo39891g()));
            reportData.put("violatedurl", url.toString());
            reportData.put("type", fraudType.toString());
            reportData.put("sci", this.f38362b.mo39301p() != null ? this.f38362b.mo39301p() : "");
            new Handler(Looper.getMainLooper()).post(new C12241m(this, reportData));
        }
    }
}

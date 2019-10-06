package com.smaato.soma.p239c.p252i;

import android.os.AsyncTask;
import com.mopub.common.Constants;
import com.smaato.soma.exception.LoadingBeaconFailed;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p246f.C12252w;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Vector;

/* renamed from: com.smaato.soma.c.i.e */
/* compiled from: GetRequestTask */
public class C12279e extends AsyncTask<Vector<String>, String, String> {

    /* renamed from: a */
    public static String f38433a = "GetRequestTask##";

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Vector<String>... params) {
        String responseString = null;
        if (params == null || params[0] == null) {
            return null;
        }
        Iterator<String> it = params[0].iterator();
        while (it.hasNext()) {
            try {
                String url = (String) it.next();
                String str = f38433a;
                StringBuilder sb = new StringBuilder();
                sb.append(" Burl##");
                sb.append(url);
                C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.VERVOSE));
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("User-Agent", C12252w.m40307b().mo39629e());
                connection.setDoInput(true);
                connection.connect();
                m40422a((URLConnection) connection).close();
                if (connection.getResponseCode() == 200) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    while (true) {
                        String readLine = br.readLine();
                        String line = readLine;
                        if (readLine == null) {
                            break;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(responseString);
                        sb2.append(line);
                        responseString = sb2.toString();
                    }
                } else {
                    responseString = "";
                }
                connection.disconnect();
            } catch (Exception e) {
            }
        }
        return responseString;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String result) {
        super.onPostExecute(result);
    }

    /* renamed from: a */
    private InputStream m40422a(URLConnection c) throws IOException, LoadingBeaconFailed {
        boolean redir;
        int redirects = 0;
        InputStream in = null;
        do {
            try {
                if (c instanceof HttpURLConnection) {
                    ((HttpURLConnection) c).setInstanceFollowRedirects(false);
                }
                in = c.getInputStream();
                redir = false;
                if (c instanceof HttpURLConnection) {
                    HttpURLConnection http = (HttpURLConnection) c;
                    int stat = http.getResponseCode();
                    if (stat >= 300 && stat <= 307 && stat != 306 && stat != 304) {
                        URL base = http.getURL();
                        String loc = http.getHeaderField("Location");
                        URL target = null;
                        if (loc != null) {
                            target = new URL(base, loc);
                        }
                        http.disconnect();
                        if (target == null || ((!target.getProtocol().equals(Constants.HTTP) && !target.getProtocol().equals("https")) || redirects >= 5)) {
                            throw new SecurityException("illegal URL redirect");
                        }
                        redir = true;
                        c = target.openConnection();
                        redirects++;
                        continue;
                    }
                }
            } catch (EOFException | FileNotFoundException | MalformedURLException | ProtocolException | SocketTimeoutException | UnknownHostException e) {
            } catch (Exception e2) {
                throw new LoadingBeaconFailed((Throwable) e2);
            }
        } while (redir);
        return in;
    }
}

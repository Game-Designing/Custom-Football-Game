package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.C6694S;
import java.net.HttpURLConnection;
import java.util.List;

/* renamed from: com.facebook.x */
/* compiled from: GraphRequestAsyncTask */
public class C6813x extends AsyncTask<Void, Void, List<C6817z>> {

    /* renamed from: a */
    private static final String f12529a = C6813x.class.getCanonicalName();

    /* renamed from: b */
    private final HttpURLConnection f12530b;

    /* renamed from: c */
    private final C6814y f12531c;

    /* renamed from: d */
    private Exception f12532d;

    public C6813x(C6814y requests) {
        this(null, requests);
    }

    public C6813x(HttpURLConnection connection, C6814y requests) {
        this.f12531c = requests;
        this.f12530b = connection;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{RequestAsyncTask: ");
        sb.append(" connection: ");
        sb.append(this.f12530b);
        sb.append(", requests: ");
        sb.append(this.f12531c);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        Handler handler;
        super.onPreExecute();
        if (C6787r.m13827q()) {
            C6694S.m13433b(f12529a, String.format("execute async task: %s", new Object[]{this}));
        }
        if (this.f12531c.mo20217f() == null) {
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.f12531c.mo20206a(handler);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(List<C6817z> result) {
        super.onPostExecute(result);
        Exception exc = this.f12532d;
        if (exc != null) {
            C6694S.m13433b(f12529a, String.format("onPostExecute: exception encountered during request: %s", new Object[]{exc.getMessage()}));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<C6817z> doInBackground(Void... params) {
        try {
            if (this.f12530b == null) {
                return this.f12531c.mo20204a();
            }
            return GraphRequest.m12881a(this.f12530b, this.f12531c);
        } catch (Exception e) {
            this.f12532d = e;
            return null;
        }
    }
}

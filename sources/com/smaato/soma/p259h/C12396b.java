package com.smaato.soma.p259h;

import android.os.AsyncTask;
import android.util.Log;
import com.smaato.soma.C12064Na;
import com.smaato.soma.exception.BannerHttpRequestFailed;
import com.smaato.soma.p239c.C12203d;
import com.smaato.soma.p239c.p246f.C12250u;
import com.smaato.soma.p239c.p252i.C12275a;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.smaato.soma.h.b */
/* compiled from: DummyConnector */
public class C12396b implements C12250u {

    /* renamed from: a */
    public static String f38728a = "SOMA_DummyConnector";

    /* renamed from: b */
    private static C12396b f38729b;

    /* renamed from: c */
    private List<C12203d> f38730c = new ArrayList();

    /* renamed from: d */
    private int f38731d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C12275a f38732e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C12203d f38733f = null;

    /* renamed from: com.smaato.soma.h.b$a */
    /* compiled from: DummyConnector */
    private class C12397a extends AsyncTask<String, Void, C12064Na> {
        private C12397a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C12064Na doInBackground(String... params) {
            Log.d(C12396b.f38728a, "Download task created");
            try {
                return C12396b.this.mo39893b(new URL(params[0]));
            } catch (Exception e) {
                Log.e(C12396b.f38728a, "");
                return C12396b.this.f38733f;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(C12064Na result) {
            Log.d(C12396b.f38728a, "Load async finished!");
            if (C12396b.this.f38732e != null) {
                C12396b.this.f38732e.mo39600a(result);
            }
            super.onPostExecute(result);
        }
    }

    private C12396b(String userAgent) {
    }

    /* renamed from: a */
    public static C12396b m40776a() {
        if (f38729b == null) {
            f38729b = new C12396b("");
        }
        return f38729b;
    }

    /* renamed from: a */
    public void mo39613a(C12275a connectionListener) {
        this.f38732e = connectionListener;
    }

    /* renamed from: b */
    public C12064Na mo39893b(URL url) throws Exception {
        if (this.f38733f != null) {
            String str = f38728a;
            StringBuilder sb = new StringBuilder();
            sb.append("Returning ");
            sb.append(this.f38733f.mo39286c());
            Log.d(str, sb.toString());
        } else {
            Log.d(f38728a, "mNextBanner not set!");
        }
        return this.f38733f;
    }

    /* renamed from: b */
    public C12203d mo39894b() {
        return this.f38733f;
    }

    /* renamed from: a */
    public boolean mo39614a(URL url) throws BannerHttpRequestFailed {
        Log.d(f38728a, "Create new DownloadTask");
        new C12397a().execute(new String[]{url.toString()});
        return true;
    }
}

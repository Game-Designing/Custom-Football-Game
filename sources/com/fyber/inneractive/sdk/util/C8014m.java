package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;

/* renamed from: com.fyber.inneractive.sdk.util.m */
public abstract class C8014m<ResultData> extends AsyncTask<String, Void, ResultData> {

    /* renamed from: a */
    Context f16349a;

    /* renamed from: b */
    C8015a<ResultData> f16350b;

    /* renamed from: com.fyber.inneractive.sdk.util.m$a */
    public interface C8015a<ResultData> {
        /* renamed from: a */
        ResultData mo24177a(String str, String str2) throws Exception;

        /* renamed from: a */
        void mo24178a(ResultData resultdata);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract String mo24850a();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract String mo24851a(String str);

    C8014m(Context context, C8015a<ResultData> aVar) {
        this.f16349a = context;
        this.f16350b = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ResultData doInBackground(String... strArr) {
        if (strArr.length == 0) {
            IAlog.m18023d("Please provide a file name when calling execute");
            return null;
        }
        String a = mo24851a(strArr[0]);
        String a2 = mo24850a();
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        try {
            return this.f16350b.mo24177a(a, a2);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Failed parsing file: ");
            sb.append(e.getMessage());
            IAlog.m18024e(sb.toString());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(ResultData resultdata) {
        this.f16350b.mo24178a(resultdata);
    }
}

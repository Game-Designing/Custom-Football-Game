package com.facebook.p127a.p128a;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import com.facebook.internal.C6673E;
import com.facebook.p127a.p128a.p129a.C6573e;
import com.facebook.p127a.p128a.p129a.C6574f;
import com.facebook.p127a.p130b.C6602h;
import java.util.TimerTask;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.a.a.h */
/* compiled from: ViewIndexer */
class C6585h extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Activity f11958a;

    /* renamed from: b */
    final /* synthetic */ String f11959b;

    /* renamed from: c */
    final /* synthetic */ C6589l f11960c;

    C6585h(C6589l this$0, Activity activity, String str) {
        this.f11960c = this$0;
        this.f11958a = activity;
        this.f11959b = str;
    }

    public void run() {
        try {
            View rootView = this.f11958a.getWindow().getDecorView().getRootView();
            if (C6602h.m13103o()) {
                if (C6673E.m13317b()) {
                    C6573e.m13017a();
                    return;
                }
                FutureTask<String> screenshotFuture = new FutureTask<>(new C6590a(rootView));
                this.f11960c.f11967c.post(screenshotFuture);
                String screenshot = "";
                try {
                    screenshot = (String) screenshotFuture.get(1, TimeUnit.SECONDS);
                } catch (Exception e) {
                    Log.e(C6589l.f11965a, "Failed to take screenshot.", e);
                }
                JSONObject viewTree = new JSONObject();
                try {
                    viewTree.put("screenname", this.f11959b);
                    viewTree.put("screenshot", screenshot);
                    JSONArray viewArray = new JSONArray();
                    viewArray.put(C6574f.m13026c(rootView));
                    viewTree.put("view", viewArray);
                } catch (JSONException e2) {
                    Log.e(C6589l.f11965a, "Failed to create JSONObject");
                }
                this.f11960c.m13066a(viewTree.toString());
            }
        } catch (Exception e3) {
            Log.e(C6589l.f11965a, "UI Component tree indexing failure!", e3);
        }
    }
}

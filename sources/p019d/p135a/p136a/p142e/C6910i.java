package p019d.p135a.p136a.p142e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d.a.a.e.i */
/* compiled from: IconStorage */
final class C6910i {

    /* renamed from: d.a.a.e.i$a */
    /* compiled from: IconStorage */
    private static final class C6911a {

        /* renamed from: a */
        private long f12690a;

        /* renamed from: b */
        private String f12691b;

        private C6911a(String jsonString) throws JSONException {
            JSONObject jsonObject = new JSONObject(jsonString);
            this.f12690a = jsonObject.getLong("last_modified");
            this.f12691b = jsonObject.getString("encoded_image");
        }

        private C6911a(long lastModified, String encodedImage) {
            this.f12690a = lastModified;
            this.f12691b = encodedImage;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public String m14057c() throws JSONException {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("encoded_image", this.f12691b);
            jsonObject.put("last_modified", this.f12690a);
            return jsonObject.toString();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Bitmap mo22362a() {
            byte[] b = Base64.decode(this.f12691b, 0);
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public boolean m14056b() {
            return System.currentTimeMillis() - this.f12690a > TimeUnit.MILLISECONDS.convert(30, TimeUnit.DAYS);
        }
    }

    /* renamed from: a */
    static Bitmap m14052a(Context context, String url) {
        String strPrefs = context.getSharedPreferences("checkout_icons", 0).getString(url, null);
        C6911a iconData = null;
        if (strPrefs == null) {
            return null;
        }
        try {
            iconData = new C6911a(strPrefs);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (iconData == null || iconData.m14056b()) {
            return null;
        }
        return iconData.mo22362a();
    }

    /* renamed from: a */
    static void m14053a(Context context, Bitmap bitmap, String url) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, baos);
        C6911a iconData = new C6911a(System.currentTimeMillis(), Base64.encodeToString(baos.toByteArray(), 0));
        Editor edit = context.getSharedPreferences("checkout_icons", 0).edit();
        try {
            edit.putString(url, iconData.m14057c());
            edit.apply();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

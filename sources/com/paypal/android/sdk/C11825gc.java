package com.paypal.android.sdk;

import android.util.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.gc */
public final class C11825gc implements C11837jc {

    /* renamed from: a */
    private String f37217a;

    /* renamed from: b */
    private String f37218b;

    /* renamed from: c */
    private String f37219c;

    /* renamed from: d */
    private String f37220d;

    /* renamed from: e */
    private String f37221e;

    /* renamed from: f */
    private String f37222f;

    /* renamed from: g */
    private String f37223g;

    /* renamed from: h */
    private String f37224h;

    /* renamed from: i */
    private String f37225i;

    static {
        C11825gc.class.getSimpleName();
    }

    public C11825gc() {
        this("iVBORw0KGgoAAAANSUhEUgAAAEgAAAAyCAYAAAD/VJ3gAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA2hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDowQTgwMTE3NDA3MjA2ODExODA4Mzk0Mzc5Rjc5QzhFNiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDo2NzNGMzY4RUE1MTUxMUUzQkJERUMzQjVDODJGNTgzQyIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDo2NzNGMzY4REE1MTUxMUUzQkJERUMzQjVDODJGNTgzQyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRvc2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NjJFMUU5MzMzNzIxNjgxMTgwODM5NDM3OUY3OUM4RTYiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6MEE4MDExNzQwNzIwNjgxMTgwODM5NDM3OUY3OUM4RTYiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz4h+YbqAAACS0lEQVR42uyb3UoCQRSAz0oXEgRZERiS+UOQSkWgRK1CvkpBr9FtdBN0FYhRUFFQWYjd+Q5dBT1At91FeaGdwRMM4s+q+zOzngMfusPO7JlvndndwTVarRZw9A5jkKB6ve5WLmvIOXKIvLtxwGKxOHCfgCInKoW8Inn6TKnyC1JBUJqkRGk7SttpFgSQQWrIckf5MpVnJlnQBlLtIkeWVKX9Jk7QJvIsDateEaX9NidJ0BbyaEGOLOmR6vleUBa5R2JD1otRvayfBeWQGyQxYv0E1c/5UdA2co0kx2wnSe1s+0nQDnJpgxxZ0iW1q70g0YkLZNXmdlep3R2dBeUdktMpKa+jIJF0yUE5sqSSk5ICGstxRZLdggpI2UU5sqQyHV9ZQQWaE5LgTSTp+AUVBZl06Y17/PAdpzxMlQSJsX+LrIAasUL55FUQJM7UHRIBtSJCeZleCtpFHpAwqBlhym/XC0HizFSQRVA7FilP001B4mAvyALoEQuUr+mGoH85IdArQqNKsirIgPY6zJOGcmRJFeqHYacg0ZhYyatpNKx6xTz1I2tVkhVB69BeE55BfiUamkhpdOQ9Q/1Zt1J5ysI+e3R32pTKxPcl5EADQVfIZ8ePIUD9erND0GmfB8T9YcazByH+eHCCfHhxozityRAbK88AcLAgFuRgTCmQww9Npt3uv4IsCOAI+epSPoscsyCAM+S7S3lQBUEqzEFzQ5bzJM1XMRbEglgQBwtiQSyIBbEg3z/NN8HZJdfmmPXHfhnO4Bfq+sefAAMAoCRc0PJdWtcAAAAASUVORK5CYII=", null, null, null, null, null, null, null);
    }

    private C11825gc(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f37217a = C11756Pb.m38949a(C11761Rb.SHIPPING_ADDRESS);
        this.f37218b = str;
        this.f37219c = str2;
        this.f37220d = str3;
        this.f37221e = str4;
        this.f37222f = str5;
        this.f37223g = str6;
        this.f37224h = str7;
        this.f37225i = str8;
    }

    /* renamed from: a */
    public static ArrayList m39149a(JSONObject jSONObject, JSONArray jSONArray, int i) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            try {
                m39150a(arrayList, jSONObject);
            } catch (JSONException e) {
                Log.e("paypal.sdk", e.getMessage());
            }
        }
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (i2 != i) {
                    m39150a(arrayList, jSONArray.getJSONObject(i2));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m39150a(ArrayList arrayList, JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.optString("type");
            C11825gc gcVar = new C11825gc("iVBORw0KGgoAAAANSUhEUgAAAEgAAAAyCAYAAAD/VJ3gAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA2hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDowQTgwMTE3NDA3MjA2ODExODA4Mzk0Mzc5Rjc5QzhFNiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDo2NzNGMzY4RUE1MTUxMUUzQkJERUMzQjVDODJGNTgzQyIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDo2NzNGMzY4REE1MTUxMUUzQkJERUMzQjVDODJGNTgzQyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRvc2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NjJFMUU5MzMzNzIxNjgxMTgwODM5NDM3OUY3OUM4RTYiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6MEE4MDExNzQwNzIwNjgxMTgwODM5NDM3OUY3OUM4RTYiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz4h+YbqAAACS0lEQVR42uyb3UoCQRSAz0oXEgRZERiS+UOQSkWgRK1CvkpBr9FtdBN0FYhRUFFQWYjd+Q5dBT1At91FeaGdwRMM4s+q+zOzngMfusPO7JlvndndwTVarRZw9A5jkKB6ve5WLmvIOXKIvLtxwGKxOHCfgCInKoW8Inn6TKnyC1JBUJqkRGk7SttpFgSQQWrIckf5MpVnJlnQBlLtIkeWVKX9Jk7QJvIsDateEaX9NidJ0BbyaEGOLOmR6vleUBa5R2JD1otRvayfBeWQGyQxYv0E1c/5UdA2co0kx2wnSe1s+0nQDnJpgxxZ0iW1q70g0YkLZNXmdlep3R2dBeUdktMpKa+jIJF0yUE5sqSSk5ICGstxRZLdggpI2UU5sqQyHV9ZQQWaE5LgTSTp+AUVBZl06Y17/PAdpzxMlQSJsX+LrIAasUL55FUQJM7UHRIBtSJCeZleCtpFHpAwqBlhym/XC0HizFSQRVA7FilP001B4mAvyALoEQuUr+mGoH85IdArQqNKsirIgPY6zJOGcmRJFeqHYacg0ZhYyatpNKx6xTz1I2tVkhVB69BeE55BfiUamkhpdOQ9Q/1Zt1J5ysI+e3R32pTKxPcl5EADQVfIZ8ePIUD9erND0GmfB8T9YcazByH+eHCCfHhxozityRAbK88AcLAgFuRgTCmQww9Npt3uv4IsCOAI+epSPoscsyCAM+S7S3lQBUEqzEFzQ5bzJM1XMRbEglgQBwtiQSyIBbEg3z/NN8HZJdfmmPXHfhnO4Bfq+sefAAMAoCRc0PJdWtcAAAAASUVORK5CYII=", jSONObject.getString("recipient_name"), jSONObject.getString("line1"), jSONObject.optString("line2"), jSONObject.getString("city"), jSONObject.getString("state"), jSONObject.getString("postal_code"), jSONObject.getString("country_code"));
            arrayList.add(gcVar);
        }
    }

    /* renamed from: a */
    public final String mo38634a() {
        return this.f37218b;
    }

    /* renamed from: b */
    public final String mo38635b() {
        return this.f37217a;
    }

    /* renamed from: c */
    public final String mo38636c() {
        return this.f37220d;
    }

    /* renamed from: d */
    public final String mo38637d() {
        return this.f37224h;
    }

    /* renamed from: e */
    public final boolean mo38638e() {
        return false;
    }

    /* renamed from: f */
    public final String mo38793f() {
        return this.f37219c;
    }

    /* renamed from: g */
    public final String mo38794g() {
        return this.f37220d;
    }

    /* renamed from: h */
    public final String mo38795h() {
        return this.f37221e;
    }

    /* renamed from: i */
    public final String mo38796i() {
        return this.f37222f;
    }

    /* renamed from: j */
    public final String mo38797j() {
        return this.f37223g;
    }

    /* renamed from: k */
    public final String mo38798k() {
        return this.f37224h;
    }

    /* renamed from: l */
    public final String mo38799l() {
        return this.f37225i;
    }
}

package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6694S.C6695a;
import com.facebook.internal.C6697T;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile implements Parcelable {
    public static final Creator<Profile> CREATOR = new C6539E();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11865a = Profile.class.getSimpleName();

    /* renamed from: b */
    private final String f11866b;

    /* renamed from: c */
    private final String f11867c;

    /* renamed from: d */
    private final String f11868d;

    /* renamed from: e */
    private final String f11869e;

    /* renamed from: f */
    private final String f11870f;

    /* renamed from: g */
    private final Uri f11871g;

    /* synthetic */ Profile(Parcel x0, C6538D x1) {
        this(x0);
    }

    /* renamed from: c */
    public static Profile m12985c() {
        return C6543G.m12869b().mo19672a();
    }

    /* renamed from: a */
    public static void m12983a(Profile profile) {
        C6543G.m12869b().mo19673a(profile);
    }

    /* renamed from: b */
    public static void m12984b() {
        AccessToken accessToken = AccessToken.m12820c();
        if (!AccessToken.m12821m()) {
            m12983a(null);
        } else {
            C6694S.m13421a(accessToken.mo19631k(), (C6695a) new C6538D());
        }
    }

    public Profile(String id, String firstName, String middleName, String lastName, String name, Uri linkUri) {
        C6697T.m13462a(id, "id");
        this.f11866b = id;
        this.f11867c = firstName;
        this.f11868d = middleName;
        this.f11869e = lastName;
        this.f11870f = name;
        this.f11871g = linkUri;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof Profile)) {
            return false;
        }
        Profile o = (Profile) other;
        if (!this.f11866b.equals(o.f11866b) || this.f11867c != null) {
            if (!this.f11867c.equals(o.f11867c) || this.f11868d != null) {
                if (!this.f11868d.equals(o.f11868d) || this.f11869e != null) {
                    if (!this.f11869e.equals(o.f11869e) || this.f11870f != null) {
                        if (!this.f11870f.equals(o.f11870f) || this.f11871g != null) {
                            z = this.f11871g.equals(o.f11871g);
                        } else if (o.f11871g != null) {
                            z = false;
                        }
                    } else if (o.f11870f != null) {
                        z = false;
                    }
                } else if (o.f11869e != null) {
                    z = false;
                }
            } else if (o.f11868d != null) {
                z = false;
            }
        } else if (o.f11867c != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int result = (17 * 31) + this.f11866b.hashCode();
        String str = this.f11867c;
        if (str != null) {
            result = (result * 31) + str.hashCode();
        }
        String str2 = this.f11868d;
        if (str2 != null) {
            result = (result * 31) + str2.hashCode();
        }
        String str3 = this.f11869e;
        if (str3 != null) {
            result = (result * 31) + str3.hashCode();
        }
        String str4 = this.f11870f;
        if (str4 != null) {
            result = (result * 31) + str4.hashCode();
        }
        Uri uri = this.f11871g;
        if (uri != null) {
            return (result * 31) + uri.hashCode();
        }
        return result;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public JSONObject mo19731d() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", this.f11866b);
            jsonObject.put("first_name", this.f11867c);
            jsonObject.put("middle_name", this.f11868d);
            jsonObject.put("last_name", this.f11869e);
            jsonObject.put("name", this.f11870f);
            if (this.f11871g == null) {
                return jsonObject;
            }
            jsonObject.put("link_uri", this.f11871g.toString());
            return jsonObject;
        } catch (JSONException e) {
            return null;
        }
    }

    Profile(JSONObject jsonObject) {
        Uri uri = null;
        this.f11866b = jsonObject.optString("id", null);
        this.f11867c = jsonObject.optString("first_name", null);
        this.f11868d = jsonObject.optString("middle_name", null);
        this.f11869e = jsonObject.optString("last_name", null);
        this.f11870f = jsonObject.optString("name", null);
        String linkUriString = jsonObject.optString("link_uri", null);
        if (linkUriString != null) {
            uri = Uri.parse(linkUriString);
        }
        this.f11871g = uri;
    }

    private Profile(Parcel source) {
        this.f11866b = source.readString();
        this.f11867c = source.readString();
        this.f11868d = source.readString();
        this.f11869e = source.readString();
        this.f11870f = source.readString();
        String linkUriString = source.readString();
        this.f11871g = linkUriString == null ? null : Uri.parse(linkUriString);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f11866b);
        dest.writeString(this.f11867c);
        dest.writeString(this.f11868d);
        dest.writeString(this.f11869e);
        dest.writeString(this.f11870f);
        Uri uri = this.f11871g;
        dest.writeString(uri == null ? null : uri.toString());
    }
}

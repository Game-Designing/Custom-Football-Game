package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.C8509F;

public final class InternalFrame extends Id3Frame {
    public static final Creator<InternalFrame> CREATOR = new C8356i();

    /* renamed from: b */
    public final String f18096b;

    /* renamed from: c */
    public final String f18097c;

    /* renamed from: d */
    public final String f18098d;

    public InternalFrame(String domain, String description, String text) {
        super("----");
        this.f18096b = domain;
        this.f18097c = description;
        this.f18098d = text;
    }

    InternalFrame(Parcel in) {
        super("----");
        String readString = in.readString();
        C8509F.m20443a(readString);
        this.f18096b = readString;
        String readString2 = in.readString();
        C8509F.m20443a(readString2);
        this.f18097c = readString2;
        String readString3 = in.readString();
        C8509F.m20443a(readString3);
        this.f18098d = readString3;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InternalFrame other = (InternalFrame) obj;
        if (!C8509F.m20455a((Object) this.f18097c, (Object) other.f18097c) || !C8509F.m20455a((Object) this.f18096b, (Object) other.f18096b) || !C8509F.m20455a((Object) this.f18098d, (Object) other.f18098d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 17 * 31;
        String str = this.f18096b;
        int i2 = 0;
        int result = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f18097c;
        int result2 = (result + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f18098d;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return result2 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18095a);
        sb.append(": domain=");
        sb.append(this.f18096b);
        sb.append(", description=");
        sb.append(this.f18097c);
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f18095a);
        dest.writeString(this.f18096b);
        dest.writeString(this.f18098d);
    }
}

package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.C8509F;

public final class TextInformationFrame extends Id3Frame {
    public static final Creator<TextInformationFrame> CREATOR = new C8359l();

    /* renamed from: b */
    public final String f18106b;

    /* renamed from: c */
    public final String f18107c;

    public TextInformationFrame(String id, String description, String value) {
        super(id);
        this.f18106b = description;
        this.f18107c = value;
    }

    TextInformationFrame(Parcel in) {
        String readString = in.readString();
        C8509F.m20443a(readString);
        super(readString);
        this.f18106b = in.readString();
        String readString2 = in.readString();
        C8509F.m20443a(readString2);
        this.f18107c = readString2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextInformationFrame other = (TextInformationFrame) obj;
        if (!this.f18095a.equals(other.f18095a) || !C8509F.m20455a((Object) this.f18106b, (Object) other.f18106b) || !C8509F.m20455a((Object) this.f18107c, (Object) other.f18107c)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int result = ((17 * 31) + this.f18095a.hashCode()) * 31;
        String str = this.f18106b;
        int i = 0;
        int result2 = (result + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f18107c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return result2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18095a);
        sb.append(": value=");
        sb.append(this.f18107c);
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f18095a);
        dest.writeString(this.f18106b);
        dest.writeString(this.f18107c);
    }
}

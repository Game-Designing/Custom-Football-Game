package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.C8509F;

public final class CommentFrame extends Id3Frame {
    public static final Creator<CommentFrame> CREATOR = new C8351f();

    /* renamed from: b */
    public final String f18088b;

    /* renamed from: c */
    public final String f18089c;

    /* renamed from: d */
    public final String f18090d;

    public CommentFrame(String language, String description, String text) {
        super("COMM");
        this.f18088b = language;
        this.f18089c = description;
        this.f18090d = text;
    }

    CommentFrame(Parcel in) {
        super("COMM");
        String readString = in.readString();
        C8509F.m20443a(readString);
        this.f18088b = readString;
        String readString2 = in.readString();
        C8509F.m20443a(readString2);
        this.f18089c = readString2;
        String readString3 = in.readString();
        C8509F.m20443a(readString3);
        this.f18090d = readString3;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CommentFrame other = (CommentFrame) obj;
        if (!C8509F.m20455a((Object) this.f18089c, (Object) other.f18089c) || !C8509F.m20455a((Object) this.f18088b, (Object) other.f18088b) || !C8509F.m20455a((Object) this.f18090d, (Object) other.f18090d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 17 * 31;
        String str = this.f18088b;
        int i2 = 0;
        int result = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f18089c;
        int result2 = (result + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f18090d;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return result2 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18095a);
        sb.append(": language=");
        sb.append(this.f18088b);
        sb.append(", description=");
        sb.append(this.f18089c);
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f18095a);
        dest.writeString(this.f18088b);
        dest.writeString(this.f18090d);
    }
}

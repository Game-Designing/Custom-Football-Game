package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.C8275d;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Creator<DrmInitData> CREATOR = new C8276a();

    /* renamed from: a */
    private final SchemeData[] f17536a;

    /* renamed from: b */
    private int f17537b;

    /* renamed from: c */
    public final String f17538c;

    /* renamed from: d */
    public final int f17539d;

    public static final class SchemeData implements Parcelable {
        public static final Creator<SchemeData> CREATOR = new C8277b();

        /* renamed from: a */
        private int f17540a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final UUID f17541b;

        /* renamed from: c */
        public final String f17542c;

        /* renamed from: d */
        public final String f17543d;

        /* renamed from: e */
        public final byte[] f17544e;

        /* renamed from: f */
        public final boolean f17545f;

        public SchemeData(UUID uuid, String mimeType, byte[] data) {
            this(uuid, mimeType, data, false);
        }

        public SchemeData(UUID uuid, String mimeType, byte[] data, boolean requiresSecureDecryption) {
            this(uuid, null, mimeType, data, requiresSecureDecryption);
        }

        public SchemeData(UUID uuid, String licenseServerUrl, String mimeType, byte[] data, boolean requiresSecureDecryption) {
            C8514e.m20486a(uuid);
            this.f17541b = uuid;
            this.f17542c = licenseServerUrl;
            C8514e.m20486a(mimeType);
            this.f17543d = mimeType;
            this.f17544e = data;
            this.f17545f = requiresSecureDecryption;
        }

        SchemeData(Parcel in) {
            this.f17541b = new UUID(in.readLong(), in.readLong());
            this.f17542c = in.readString();
            this.f17543d = in.readString();
            this.f17544e = in.createByteArray();
            this.f17545f = in.readByte() != 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            boolean z = true;
            if (obj == this) {
                return true;
            }
            SchemeData other = (SchemeData) obj;
            if (!C8509F.m20455a((Object) this.f17542c, (Object) other.f17542c) || !C8509F.m20455a((Object) this.f17543d, (Object) other.f17543d) || !C8509F.m20455a((Object) this.f17541b, (Object) other.f17541b) || !Arrays.equals(this.f17544e, other.f17544e)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            if (this.f17540a == 0) {
                int hashCode = this.f17541b.hashCode() * 31;
                String str = this.f17542c;
                this.f17540a = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f17543d.hashCode()) * 31) + Arrays.hashCode(this.f17544e);
            }
            return this.f17540a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(this.f17541b.getMostSignificantBits());
            dest.writeLong(this.f17541b.getLeastSignificantBits());
            dest.writeString(this.f17542c);
            dest.writeString(this.f17543d);
            dest.writeByteArray(this.f17544e);
            dest.writeByte(this.f17545f ? (byte) 1 : 0);
        }
    }

    public DrmInitData(List<SchemeData> schemeDatas) {
        this(null, false, (SchemeData[]) schemeDatas.toArray(new SchemeData[schemeDatas.size()]));
    }

    public DrmInitData(SchemeData... schemeDatas) {
        this(null, schemeDatas);
    }

    public DrmInitData(String schemeType, SchemeData... schemeDatas) {
        this(schemeType, true, schemeDatas);
    }

    private DrmInitData(String schemeType, boolean cloneSchemeDatas, SchemeData... schemeDatas) {
        this.f17538c = schemeType;
        if (cloneSchemeDatas) {
            schemeDatas = (SchemeData[]) schemeDatas.clone();
        }
        Arrays.sort(schemeDatas, this);
        this.f17536a = schemeDatas;
        this.f17539d = schemeDatas.length;
    }

    DrmInitData(Parcel in) {
        this.f17538c = in.readString();
        this.f17536a = (SchemeData[]) in.createTypedArray(SchemeData.CREATOR);
        this.f17539d = this.f17536a.length;
    }

    /* renamed from: a */
    public SchemeData mo25388a(int index) {
        return this.f17536a[index];
    }

    /* renamed from: a */
    public DrmInitData mo25389a(String schemeType) {
        if (C8509F.m20455a((Object) this.f17538c, (Object) schemeType)) {
            return this;
        }
        return new DrmInitData(schemeType, false, this.f17536a);
    }

    public int hashCode() {
        if (this.f17537b == 0) {
            String str = this.f17538c;
            this.f17537b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f17536a);
        }
        return this.f17537b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DrmInitData other = (DrmInitData) obj;
        if (!C8509F.m20455a((Object) this.f17538c, (Object) other.f17538c) || !Arrays.equals(this.f17536a, other.f17536a)) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public int compare(SchemeData first, SchemeData second) {
        if (C8275d.f17531a.equals(first.f17541b)) {
            return C8275d.f17531a.equals(second.f17541b) ? 0 : 1;
        }
        return first.f17541b.compareTo(second.f17541b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f17538c);
        dest.writeTypedArray(this.f17536a, 0);
    }
}

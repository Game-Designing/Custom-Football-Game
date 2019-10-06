package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import com.liulishuo.filedownloader.message.MessageSnapshot.C10900a;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public abstract class LargeMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements C10901a {
        CompletedFlowDirectlySnapshot(int id, boolean reusedDownloadedFile, long totalBytes) {
            super(id, reusedDownloadedFile, totalBytes);
        }
    }

    public static class CompletedSnapshot extends LargeMessageSnapshot {

        /* renamed from: c */
        private final boolean f33300c;

        /* renamed from: d */
        private final long f33301d;

        CompletedSnapshot(int id, boolean reusedDownloadedFile, long totalBytes) {
            super(id);
            this.f33300c = reusedDownloadedFile;
            this.f33301d = totalBytes;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeByte(this.f33300c ? (byte) 1 : 0);
            dest.writeLong(this.f33301d);
        }

        CompletedSnapshot(Parcel in) {
            super(in);
            this.f33300c = in.readByte() != 0;
            this.f33301d = in.readLong();
        }

        /* renamed from: k */
        public byte mo35687k() {
            return -3;
        }

        /* renamed from: g */
        public long mo35691g() {
            return this.f33301d;
        }

        /* renamed from: o */
        public boolean mo35692o() {
            return this.f33300c;
        }
    }

    public static class ConnectedMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: c */
        private final boolean f33302c;

        /* renamed from: d */
        private final long f33303d;

        /* renamed from: e */
        private final String f33304e;

        /* renamed from: f */
        private final String f33305f;

        ConnectedMessageSnapshot(int id, boolean resuming, long totalBytes, String etag, String fileName) {
            super(id);
            this.f33302c = resuming;
            this.f33303d = totalBytes;
            this.f33304e = etag;
            this.f33305f = fileName;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeByte(this.f33302c ? (byte) 1 : 0);
            dest.writeLong(this.f33303d);
            dest.writeString(this.f33304e);
            dest.writeString(this.f33305f);
        }

        ConnectedMessageSnapshot(Parcel in) {
            super(in);
            this.f33302c = in.readByte() != 0;
            this.f33303d = in.readLong();
            this.f33304e = in.readString();
            this.f33305f = in.readString();
        }

        /* renamed from: d */
        public String mo35695d() {
            return this.f33305f;
        }

        /* renamed from: k */
        public byte mo35687k() {
            return 2;
        }

        /* renamed from: n */
        public boolean mo35696n() {
            return this.f33302c;
        }

        /* renamed from: g */
        public long mo35691g() {
            return this.f33303d;
        }

        /* renamed from: c */
        public String mo35694c() {
            return this.f33304e;
        }
    }

    public static class ErrorMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: c */
        private final long f33306c;

        /* renamed from: d */
        private final Throwable f33307d;

        ErrorMessageSnapshot(int id, long sofarBytes, Throwable throwable) {
            super(id);
            this.f33306c = sofarBytes;
            this.f33307d = throwable;
        }

        /* renamed from: f */
        public long mo35697f() {
            return this.f33306c;
        }

        /* renamed from: k */
        public byte mo35687k() {
            return -1;
        }

        /* renamed from: l */
        public Throwable mo35698l() {
            return this.f33307d;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeLong(this.f33306c);
            dest.writeSerializable(this.f33307d);
        }

        ErrorMessageSnapshot(Parcel in) {
            super(in);
            this.f33306c = in.readLong();
            this.f33307d = (Throwable) in.readSerializable();
        }
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        PausedSnapshot(int id, long sofarBytes, long totalBytes) {
            super(id, sofarBytes, totalBytes);
        }

        /* renamed from: k */
        public byte mo35687k() {
            return -2;
        }
    }

    public static class PendingMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: c */
        private final long f33308c;

        /* renamed from: d */
        private final long f33309d;

        PendingMessageSnapshot(PendingMessageSnapshot snapshot) {
            this(snapshot.mo35701e(), snapshot.mo35697f(), snapshot.mo35691g());
        }

        PendingMessageSnapshot(int id, long sofarBytes, long totalBytes) {
            super(id);
            this.f33308c = sofarBytes;
            this.f33309d = totalBytes;
        }

        /* renamed from: k */
        public byte mo35687k() {
            return 1;
        }

        /* renamed from: f */
        public long mo35697f() {
            return this.f33308c;
        }

        /* renamed from: g */
        public long mo35691g() {
            return this.f33309d;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeLong(this.f33308c);
            dest.writeLong(this.f33309d);
        }

        PendingMessageSnapshot(Parcel in) {
            super(in);
            this.f33308c = in.readLong();
            this.f33309d = in.readLong();
        }
    }

    public static class ProgressMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: c */
        private final long f33310c;

        ProgressMessageSnapshot(int id, long sofarBytes) {
            super(id);
            this.f33310c = sofarBytes;
        }

        /* renamed from: k */
        public byte mo35687k() {
            return 3;
        }

        /* renamed from: f */
        public long mo35697f() {
            return this.f33310c;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeLong(this.f33310c);
        }

        ProgressMessageSnapshot(Parcel in) {
            super(in);
            this.f33310c = in.readLong();
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {

        /* renamed from: e */
        private final int f33311e;

        RetryMessageSnapshot(int id, long sofarBytes, Throwable throwable, int retryingTimes) {
            super(id, sofarBytes, throwable);
            this.f33311e = retryingTimes;
        }

        /* renamed from: h */
        public int mo35699h() {
            return this.f33311e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f33311e);
        }

        RetryMessageSnapshot(Parcel in) {
            super(in);
            this.f33311e = in.readInt();
        }

        /* renamed from: k */
        public byte mo35687k() {
            return 5;
        }
    }

    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements C10901a {
        WarnFlowDirectlySnapshot(int id, long sofarBytes, long totalBytes) {
            super(id, sofarBytes, totalBytes);
        }
    }

    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements C10900a {
        WarnMessageSnapshot(int id, long sofarBytes, long totalBytes) {
            super(id, sofarBytes, totalBytes);
        }

        WarnMessageSnapshot(Parcel in) {
            super(in);
        }

        /* renamed from: a */
        public MessageSnapshot mo35700a() {
            return new PendingMessageSnapshot((PendingMessageSnapshot) this);
        }

        /* renamed from: k */
        public byte mo35687k() {
            return -4;
        }
    }

    LargeMessageSnapshot(int id) {
        super(id);
        this.f33313b = true;
    }

    LargeMessageSnapshot(Parcel in) {
        super(in);
    }

    /* renamed from: i */
    public int mo35688i() {
        if (mo35697f() > 2147483647L) {
            return MoPubClientPositioning.NO_REPEAT;
        }
        return (int) mo35697f();
    }

    /* renamed from: j */
    public int mo35689j() {
        if (mo35691g() > 2147483647L) {
            return MoPubClientPositioning.NO_REPEAT;
        }
        return (int) mo35691g();
    }
}

package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import com.liulishuo.filedownloader.message.MessageSnapshot.C10900a;

public abstract class SmallMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements C10901a {
        CompletedFlowDirectlySnapshot(int id, boolean reusedDownloadedFile, int totalBytes) {
            super(id, reusedDownloadedFile, totalBytes);
        }
    }

    public static class CompletedSnapshot extends SmallMessageSnapshot {

        /* renamed from: c */
        private final boolean f33314c;

        /* renamed from: d */
        private final int f33315d;

        CompletedSnapshot(int id, boolean reusedDownloadedFile, int totalBytes) {
            super(id);
            this.f33314c = reusedDownloadedFile;
            this.f33315d = totalBytes;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeByte(this.f33314c ? (byte) 1 : 0);
            dest.writeInt(this.f33315d);
        }

        CompletedSnapshot(Parcel in) {
            super(in);
            this.f33314c = in.readByte() != 0;
            this.f33315d = in.readInt();
        }

        /* renamed from: k */
        public byte mo35687k() {
            return -3;
        }

        /* renamed from: j */
        public int mo35689j() {
            return this.f33315d;
        }

        /* renamed from: o */
        public boolean mo35692o() {
            return this.f33314c;
        }
    }

    public static class ConnectedMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: c */
        private final boolean f33316c;

        /* renamed from: d */
        private final int f33317d;

        /* renamed from: e */
        private final String f33318e;

        /* renamed from: f */
        private final String f33319f;

        ConnectedMessageSnapshot(int id, boolean resuming, int totalBytes, String etag, String fileName) {
            super(id);
            this.f33316c = resuming;
            this.f33317d = totalBytes;
            this.f33318e = etag;
            this.f33319f = fileName;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeByte(this.f33316c ? (byte) 1 : 0);
            dest.writeInt(this.f33317d);
            dest.writeString(this.f33318e);
            dest.writeString(this.f33319f);
        }

        ConnectedMessageSnapshot(Parcel in) {
            super(in);
            this.f33316c = in.readByte() != 0;
            this.f33317d = in.readInt();
            this.f33318e = in.readString();
            this.f33319f = in.readString();
        }

        /* renamed from: d */
        public String mo35695d() {
            return this.f33319f;
        }

        /* renamed from: k */
        public byte mo35687k() {
            return 2;
        }

        /* renamed from: n */
        public boolean mo35696n() {
            return this.f33316c;
        }

        /* renamed from: j */
        public int mo35689j() {
            return this.f33317d;
        }

        /* renamed from: c */
        public String mo35694c() {
            return this.f33318e;
        }
    }

    public static class ErrorMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: c */
        private final int f33320c;

        /* renamed from: d */
        private final Throwable f33321d;

        ErrorMessageSnapshot(int id, int sofarBytes, Throwable throwable) {
            super(id);
            this.f33320c = sofarBytes;
            this.f33321d = throwable;
        }

        /* renamed from: i */
        public int mo35688i() {
            return this.f33320c;
        }

        /* renamed from: k */
        public byte mo35687k() {
            return -1;
        }

        /* renamed from: l */
        public Throwable mo35698l() {
            return this.f33321d;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f33320c);
            dest.writeSerializable(this.f33321d);
        }

        ErrorMessageSnapshot(Parcel in) {
            super(in);
            this.f33320c = in.readInt();
            this.f33321d = (Throwable) in.readSerializable();
        }
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        PausedSnapshot(int id, int sofarBytes, int totalBytes) {
            super(id, sofarBytes, totalBytes);
        }

        /* renamed from: k */
        public byte mo35687k() {
            return -2;
        }
    }

    public static class PendingMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: c */
        private final int f33322c;

        /* renamed from: d */
        private final int f33323d;

        PendingMessageSnapshot(PendingMessageSnapshot snapshot) {
            this(snapshot.mo35701e(), snapshot.mo35688i(), snapshot.mo35689j());
        }

        PendingMessageSnapshot(int id, int sofarBytes, int totalBytes) {
            super(id);
            this.f33322c = sofarBytes;
            this.f33323d = totalBytes;
        }

        PendingMessageSnapshot(Parcel in) {
            super(in);
            this.f33322c = in.readInt();
            this.f33323d = in.readInt();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f33322c);
            dest.writeInt(this.f33323d);
        }

        /* renamed from: k */
        public byte mo35687k() {
            return 1;
        }

        /* renamed from: i */
        public int mo35688i() {
            return this.f33322c;
        }

        /* renamed from: j */
        public int mo35689j() {
            return this.f33323d;
        }
    }

    public static class ProgressMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: c */
        private final int f33324c;

        ProgressMessageSnapshot(int id, int sofarBytes) {
            super(id);
            this.f33324c = sofarBytes;
        }

        /* renamed from: k */
        public byte mo35687k() {
            return 3;
        }

        /* renamed from: i */
        public int mo35688i() {
            return this.f33324c;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f33324c);
        }

        ProgressMessageSnapshot(Parcel in) {
            super(in);
            this.f33324c = in.readInt();
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {

        /* renamed from: e */
        private final int f33325e;

        RetryMessageSnapshot(int id, int sofarBytes, Throwable throwable, int retryingTimes) {
            super(id, sofarBytes, throwable);
            this.f33325e = retryingTimes;
        }

        /* renamed from: h */
        public int mo35699h() {
            return this.f33325e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f33325e);
        }

        RetryMessageSnapshot(Parcel in) {
            super(in);
            this.f33325e = in.readInt();
        }

        /* renamed from: k */
        public byte mo35687k() {
            return 5;
        }
    }

    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements C10901a {
        WarnFlowDirectlySnapshot(int id, int sofarBytes, int totalBytes) {
            super(id, sofarBytes, totalBytes);
        }
    }

    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements C10900a {
        WarnMessageSnapshot(int id, int sofarBytes, int totalBytes) {
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

    SmallMessageSnapshot(int id) {
        super(id);
        this.f33313b = false;
    }

    SmallMessageSnapshot(Parcel in) {
        super(in);
    }

    /* renamed from: g */
    public long mo35691g() {
        return (long) mo35689j();
    }

    /* renamed from: f */
    public long mo35697f() {
        return (long) mo35688i();
    }
}

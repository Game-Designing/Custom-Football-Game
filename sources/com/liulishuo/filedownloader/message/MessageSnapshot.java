package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import p019d.p307j.p308a.p313e.C13121g;

public abstract class MessageSnapshot implements C10902b, Parcelable {
    public static final Creator<MessageSnapshot> CREATOR = new C10903c();

    /* renamed from: a */
    private final int f33312a;

    /* renamed from: b */
    protected boolean f33313b;

    public static class NoFieldException extends IllegalStateException {
        NoFieldException(String methodName, MessageSnapshot snapshot) {
            super(C13121g.m42792a("There isn't a field for '%s' in this message %d %d %s", methodName, Integer.valueOf(snapshot.mo35701e()), Byte.valueOf(snapshot.mo35687k()), snapshot.getClass().getName()));
        }
    }

    public static class StartedMessageSnapshot extends MessageSnapshot {
        StartedMessageSnapshot(int id) {
            super(id);
        }

        StartedMessageSnapshot(Parcel in) {
            super(in);
        }

        /* renamed from: k */
        public byte mo35687k() {
            return 6;
        }
    }

    /* renamed from: com.liulishuo.filedownloader.message.MessageSnapshot$a */
    public interface C10900a {
        /* renamed from: a */
        MessageSnapshot mo35700a();
    }

    /* renamed from: k */
    public abstract /* synthetic */ byte mo35687k();

    MessageSnapshot(int id) {
        this.f33312a = id;
    }

    /* renamed from: e */
    public int mo35701e() {
        return this.f33312a;
    }

    /* renamed from: l */
    public Throwable mo35698l() {
        throw new NoFieldException("getThrowable", this);
    }

    /* renamed from: h */
    public int mo35699h() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    /* renamed from: n */
    public boolean mo35696n() {
        throw new NoFieldException("isResuming", this);
    }

    /* renamed from: c */
    public String mo35694c() {
        throw new NoFieldException("getEtag", this);
    }

    /* renamed from: f */
    public long mo35697f() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    /* renamed from: g */
    public long mo35691g() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    /* renamed from: i */
    public int mo35688i() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    /* renamed from: j */
    public int mo35689j() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    /* renamed from: o */
    public boolean mo35692o() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    /* renamed from: d */
    public String mo35695d() {
        throw new NoFieldException("getFileName", this);
    }

    /* renamed from: m */
    public boolean mo35702m() {
        return this.f33313b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.f33313b ? (byte) 1 : 0);
        dest.writeByte(mo35687k());
        dest.writeInt(this.f33312a);
    }

    MessageSnapshot(Parcel in) {
        this.f33312a = in.readInt();
    }
}

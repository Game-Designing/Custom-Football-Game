package android.support.p000v4.p037os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.p000v4.p037os.C0570b.C0571a;

/* renamed from: android.support.v4.os.ResultReceiver */
public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new C0573c();
    final Handler mHandler;
    final boolean mLocal;
    C0570b mReceiver;

    /* renamed from: android.support.v4.os.ResultReceiver$a */
    class C0567a extends C0571a {
        C0567a() {
        }

        /* renamed from: a */
        public void mo5443a(int resultCode, Bundle resultData) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.mHandler;
            if (handler != null) {
                handler.post(new C0568b(resultCode, resultData));
            } else {
                resultReceiver.onReceiveResult(resultCode, resultData);
            }
        }
    }

    /* renamed from: android.support.v4.os.ResultReceiver$b */
    class C0568b implements Runnable {

        /* renamed from: a */
        final int f1787a;

        /* renamed from: b */
        final Bundle f1788b;

        C0568b(int resultCode, Bundle resultData) {
            this.f1787a = resultCode;
            this.f1788b = resultData;
        }

        public void run() {
            ResultReceiver.this.onReceiveResult(this.f1787a, this.f1788b);
        }
    }

    public ResultReceiver(Handler handler) {
        this.mLocal = true;
        this.mHandler = handler;
    }

    public void send(int resultCode, Bundle resultData) {
        if (this.mLocal) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new C0568b(resultCode, resultData));
            } else {
                onReceiveResult(resultCode, resultData);
            }
            return;
        }
        C0570b bVar = this.mReceiver;
        if (bVar != null) {
            try {
                bVar.mo5443a(resultCode, resultData);
            } catch (RemoteException e) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int resultCode, Bundle resultData) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        synchronized (this) {
            if (this.mReceiver == null) {
                this.mReceiver = new C0567a();
            }
            out.writeStrongBinder(this.mReceiver.asBinder());
        }
    }

    ResultReceiver(Parcel in) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = C0571a.m2752a(in.readStrongBinder());
    }
}

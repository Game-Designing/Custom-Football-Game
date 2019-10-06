package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataInputStream;
import java.io.IOException;

@zzard
public final class zzaru extends AbstractSafeParcelable {
    public static final Creator<zzaru> CREATOR = new zzarw();

    /* renamed from: a */
    private ParcelFileDescriptor f24712a;

    /* renamed from: b */
    private Parcelable f24713b = null;

    /* renamed from: c */
    private boolean f24714c = true;

    @Constructor
    public zzaru(@Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.f24712a = parcelFileDescriptor;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public final <T extends SafeParcelable> T mo30027a(Creator<T> creator) {
        if (this.f24714c) {
            ParcelFileDescriptor parcelFileDescriptor = this.f24712a;
            if (parcelFileDescriptor == null) {
                zzbad.m26355b("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new AutoCloseInputStream(parcelFileDescriptor));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                IOUtils.m22102a(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.f24713b = (SafeParcelable) creator.createFromParcel(obtain);
                    obtain.recycle();
                    this.f24714c = false;
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            } catch (IOException e) {
                zzbad.m26356b("Could not read from parcel file descriptor", e);
                IOUtils.m22102a(dataInputStream);
                return null;
            } catch (Throwable th2) {
                IOUtils.m22102a(dataInputStream);
                throw th2;
            }
        }
        return (SafeParcelable) this.f24713b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        m25713a();
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.f24712a, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private final ParcelFileDescriptor m25713a() {
        if (this.f24712a == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.f24713b.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.f24712a = m25714a(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        return this.f24712a;
    }

    /* renamed from: a */
    private final <T> ParcelFileDescriptor m25714a(byte[] bArr) {
        AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new C9682rb(this, autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e) {
                e = e;
                zzbad.m26356b("Error transporting the ad response", e);
                zzk.zzlk().mo30168a((Throwable) e, "LargeParcelTeleporter.pipeData.2");
                IOUtils.m22102a(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
        }
    }
}

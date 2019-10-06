package android.support.p000v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.p000v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

/* renamed from: android.support.v4.media.session.a */
/* compiled from: IMediaControllerCallback */
public interface C0542a extends IInterface {

    /* renamed from: android.support.v4.media.session.a$a */
    /* compiled from: IMediaControllerCallback */
    public static abstract class C0543a extends Binder implements C0542a {
        public C0543a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Bundle _arg1;
            PlaybackStateCompat _arg0;
            MediaMetadataCompat _arg02;
            CharSequence _arg03;
            Bundle _arg04;
            ParcelableVolumeInfo _arg05;
            String str = "android.support.v4.media.session.IMediaControllerCallback";
            if (code != 1598968902) {
                boolean _arg06 = false;
                switch (code) {
                    case 1:
                        data.enforceInterface(str);
                        String _arg07 = data.readString();
                        if (data.readInt() != 0) {
                            _arg1 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                        } else {
                            _arg1 = null;
                        }
                        mo5392a(_arg07, _arg1);
                        return true;
                    case 2:
                        data.enforceInterface(str);
                        mo5372w();
                        return true;
                    case 3:
                        data.enforceInterface(str);
                        if (data.readInt() != 0) {
                            _arg0 = (PlaybackStateCompat) PlaybackStateCompat.CREATOR.createFromParcel(data);
                        } else {
                            _arg0 = null;
                        }
                        mo5391a(_arg0);
                        return true;
                    case 4:
                        data.enforceInterface(str);
                        if (data.readInt() != 0) {
                            _arg02 = (MediaMetadataCompat) MediaMetadataCompat.CREATOR.createFromParcel(data);
                        } else {
                            _arg02 = null;
                        }
                        mo5368a(_arg02);
                        return true;
                    case 5:
                        data.enforceInterface(str);
                        mo5371a(data.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR));
                        return true;
                    case 6:
                        data.enforceInterface(str);
                        if (data.readInt() != 0) {
                            _arg03 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
                        } else {
                            _arg03 = null;
                        }
                        mo5370a(_arg03);
                        return true;
                    case 7:
                        data.enforceInterface(str);
                        if (data.readInt() != 0) {
                            _arg04 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                        } else {
                            _arg04 = null;
                        }
                        mo5367a(_arg04);
                        return true;
                    case 8:
                        data.enforceInterface(str);
                        if (data.readInt() != 0) {
                            _arg05 = (ParcelableVolumeInfo) ParcelableVolumeInfo.CREATOR.createFromParcel(data);
                        } else {
                            _arg05 = null;
                        }
                        mo5369a(_arg05);
                        return true;
                    case 9:
                        data.enforceInterface(str);
                        mo5396i(data.readInt());
                        return true;
                    case 10:
                        data.enforceInterface(str);
                        if (data.readInt() != 0) {
                            _arg06 = true;
                        }
                        mo5394c(_arg06);
                        return true;
                    case 11:
                        data.enforceInterface(str);
                        if (data.readInt() != 0) {
                            _arg06 = true;
                        }
                        mo5393b(_arg06);
                        return true;
                    case 12:
                        data.enforceInterface(str);
                        mo5395h(data.readInt());
                        return true;
                    case 13:
                        data.enforceInterface(str);
                        mo5390H();
                        return true;
                    default:
                        return super.onTransact(code, data, reply, flags);
                }
            } else {
                reply.writeString(str);
                return true;
            }
        }
    }

    /* renamed from: H */
    void mo5390H() throws RemoteException;

    /* renamed from: a */
    void mo5367a(Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo5368a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    /* renamed from: a */
    void mo5369a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;

    /* renamed from: a */
    void mo5391a(PlaybackStateCompat playbackStateCompat) throws RemoteException;

    /* renamed from: a */
    void mo5370a(CharSequence charSequence) throws RemoteException;

    /* renamed from: a */
    void mo5392a(String str, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo5371a(List<MediaSessionCompat$QueueItem> list) throws RemoteException;

    /* renamed from: b */
    void mo5393b(boolean z) throws RemoteException;

    /* renamed from: c */
    void mo5394c(boolean z) throws RemoteException;

    /* renamed from: h */
    void mo5395h(int i) throws RemoteException;

    /* renamed from: i */
    void mo5396i(int i) throws RemoteException;

    /* renamed from: w */
    void mo5372w() throws RemoteException;
}

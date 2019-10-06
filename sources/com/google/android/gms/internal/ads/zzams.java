package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzams extends IInterface {
    /* renamed from: Ca */
    IObjectWrapper mo29837Ca() throws RemoteException;

    /* renamed from: Oa */
    Bundle mo29838Oa() throws RemoteException;

    /* renamed from: S */
    zzang mo29839S() throws RemoteException;

    /* renamed from: Y */
    zzafe mo29840Y() throws RemoteException;

    /* renamed from: a */
    void mo29841a(IObjectWrapper iObjectWrapper, zzaiq zzaiq, List<zzaiw> list) throws RemoteException;

    /* renamed from: a */
    void mo29842a(IObjectWrapper iObjectWrapper, zzatk zzatk, List<String> list) throws RemoteException;

    /* renamed from: a */
    void mo29843a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException;

    /* renamed from: a */
    void mo29844a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzatk zzatk, String str2) throws RemoteException;

    /* renamed from: a */
    void mo29845a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException;

    /* renamed from: a */
    void mo29846a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv, zzady zzady, List<String> list) throws RemoteException;

    /* renamed from: a */
    void mo29847a(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, zzamv zzamv) throws RemoteException;

    /* renamed from: a */
    void mo29848a(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException;

    /* renamed from: a */
    void mo29849a(zzxz zzxz, String str) throws RemoteException;

    /* renamed from: a */
    void mo29850a(zzxz zzxz, String str, String str2) throws RemoteException;

    /* renamed from: b */
    void mo29851b(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException;

    /* renamed from: bb */
    zzand mo29852bb() throws RemoteException;

    /* renamed from: da */
    boolean mo29853da() throws RemoteException;

    void destroy() throws RemoteException;

    /* renamed from: eb */
    zzana mo29855eb() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    /* renamed from: l */
    void mo29859l(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: m */
    void mo29860m(IObjectWrapper iObjectWrapper) throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    Bundle zzsh() throws RemoteException;
}

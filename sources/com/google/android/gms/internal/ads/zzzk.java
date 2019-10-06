package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzzk extends IInterface {
    /* renamed from: Aa */
    IObjectWrapper mo29502Aa() throws RemoteException;

    /* renamed from: I */
    boolean mo29503I() throws RemoteException;

    /* renamed from: Ka */
    void mo29504Ka() throws RemoteException;

    /* renamed from: L */
    String mo29505L() throws RemoteException;

    /* renamed from: Ta */
    zzzs mo29506Ta() throws RemoteException;

    /* renamed from: Ya */
    zzyz mo29507Ya() throws RemoteException;

    /* renamed from: Za */
    zzyd mo29508Za() throws RemoteException;

    /* renamed from: a */
    void mo29509a(zzaax zzaax) throws RemoteException;

    /* renamed from: a */
    void mo29510a(zzacd zzacd) throws RemoteException;

    /* renamed from: a */
    void mo29511a(zzado zzado) throws RemoteException;

    /* renamed from: a */
    void mo29512a(zzaqn zzaqn) throws RemoteException;

    /* renamed from: a */
    void mo29513a(zzaqt zzaqt, String str) throws RemoteException;

    /* renamed from: a */
    void mo29514a(zzatb zzatb) throws RemoteException;

    /* renamed from: a */
    void mo29515a(zzyd zzyd) throws RemoteException;

    /* renamed from: a */
    void mo29516a(zzyw zzyw) throws RemoteException;

    /* renamed from: a */
    void mo29517a(zzyz zzyz) throws RemoteException;

    /* renamed from: a */
    void mo29518a(zzzp zzzp) throws RemoteException;

    /* renamed from: a */
    void mo29519a(zzzs zzzs) throws RemoteException;

    /* renamed from: a */
    void mo29520a(zzzy zzzy) throws RemoteException;

    /* renamed from: b */
    boolean mo29521b(zzxz zzxz) throws RemoteException;

    /* renamed from: cb */
    String mo29522cb() throws RemoteException;

    /* renamed from: db */
    void mo29523db() throws RemoteException;

    void destroy() throws RemoteException;

    /* renamed from: e */
    void mo29525e(String str) throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    boolean isReady() throws RemoteException;

    /* renamed from: m */
    void mo29530m(boolean z) throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;
}

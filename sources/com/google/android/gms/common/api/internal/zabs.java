package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface zabs {
    /* renamed from: a */
    <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27546a(T t);

    /* renamed from: a */
    void mo27547a();

    /* renamed from: a */
    boolean mo27548a(SignInConnectionListener signInConnectionListener);

    /* renamed from: b */
    <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T mo27549b(T t);

    /* renamed from: b */
    void mo27550b();

    /* renamed from: c */
    ConnectionResult mo27551c();

    void connect();

    void disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    boolean isConnected();
}

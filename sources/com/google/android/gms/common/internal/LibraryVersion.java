package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
public class LibraryVersion {

    /* renamed from: a */
    private static final GmsLogger f20115a = new GmsLogger("LibraryVersion", "");

    /* renamed from: b */
    private static LibraryVersion f20116b = new LibraryVersion();

    /* renamed from: c */
    private ConcurrentHashMap<String, String> f20117c = new ConcurrentHashMap<>();

    @VisibleForTesting
    protected LibraryVersion() {
    }
}

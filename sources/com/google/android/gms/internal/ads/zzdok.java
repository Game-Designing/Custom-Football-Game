package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzdok extends IOException {

    /* renamed from: a */
    private zzdpk f28089a = null;

    public zzdok(String str) {
        super(str);
    }

    /* renamed from: a */
    public final zzdok mo31617a(zzdpk zzdpk) {
        this.f28089a = zzdpk;
        return this;
    }

    /* renamed from: a */
    static zzdok m29928a() {
        return new zzdok("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static zzdok m29929b() {
        return new zzdok("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static zzdok m29930c() {
        return new zzdok("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static zzdok m29931d() {
        return new zzdok("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static zzdok m29932e() {
        return new zzdok("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static zzdol m29933f() {
        return new zzdol("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static zzdok m29934g() {
        return new zzdok("Failed to parse the message.");
    }

    /* renamed from: h */
    static zzdok m29935h() {
        return new zzdok("Protocol message had invalid UTF-8.");
    }
}

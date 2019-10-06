package com.liulishuo.filedownloader.exception;

import android.annotation.TargetApi;
import java.io.IOException;
import p019d.p307j.p308a.p313e.C13121g;

public class FileDownloadOutOfSpaceException extends IOException {

    /* renamed from: a */
    private long f33296a;

    /* renamed from: b */
    private long f33297b;

    /* renamed from: c */
    private long f33298c;

    @TargetApi(9)
    public FileDownloadOutOfSpaceException(long freeSpaceBytes, long requiredSpaceBytes, long breakpointBytes, Throwable cause) {
        super(C13121g.m42792a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(breakpointBytes), Long.valueOf(requiredSpaceBytes), Long.valueOf(freeSpaceBytes)), cause);
        m35691a(freeSpaceBytes, requiredSpaceBytes, breakpointBytes);
    }

    public FileDownloadOutOfSpaceException(long freeSpaceBytes, long requiredSpaceBytes, long breakpointBytes) {
        super(C13121g.m42792a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(breakpointBytes), Long.valueOf(requiredSpaceBytes), Long.valueOf(freeSpaceBytes)));
        m35691a(freeSpaceBytes, requiredSpaceBytes, breakpointBytes);
    }

    /* renamed from: a */
    private void m35691a(long freeSpaceBytes, long requiredSpaceBytes, long breakpointBytes) {
        this.f33296a = freeSpaceBytes;
        this.f33297b = requiredSpaceBytes;
        this.f33298c = breakpointBytes;
    }
}

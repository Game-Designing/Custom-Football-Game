package com.vladium.emma.p266rt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jacoco.agent.p025rt.C14369RT;

@Deprecated
/* renamed from: com.vladium.emma.rt.RT */
public final class C12650RT {
    private C12650RT() {
    }

    public static void dumpCoverageData(File outFile, boolean merge, boolean stopDataCollection) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(outFile, merge);
        try {
            fileOutputStream.write(C14369RT.getAgent().getExecutionData(false));
        } finally {
            fileOutputStream.close();
        }
    }

    public static synchronized void dumpCoverageData(File outFile, boolean stopDataCollection) throws IOException {
        synchronized (C12650RT.class) {
            dumpCoverageData(outFile, true, stopDataCollection);
        }
    }
}

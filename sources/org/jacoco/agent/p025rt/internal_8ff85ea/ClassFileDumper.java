package org.jacoco.agent.p025rt.internal_8ff85ea;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.data.CRC64;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.ClassFileDumper */
class ClassFileDumper {
    private final File location;

    ClassFileDumper(String location2) {
        if (location2 == null) {
            this.location = null;
        } else {
            this.location = new File(location2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void dump(String name, byte[] contents) throws IOException {
        String localname;
        File outputdir;
        if (this.location != null) {
            int pkgpos = name.lastIndexOf(47);
            if (pkgpos != -1) {
                outputdir = new File(this.location, name.substring(0, pkgpos));
                localname = name.substring(pkgpos + 1);
            } else {
                outputdir = this.location;
                localname = name;
            }
            outputdir.mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(outputdir, String.format("%s.%016x.class", new Object[]{localname, Long.valueOf(CRC64.checksum(contents))})));
            fileOutputStream.write(contents);
            fileOutputStream.close();
        }
    }
}

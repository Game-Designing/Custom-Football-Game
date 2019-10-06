package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.ContentTypeDetector */
public class ContentTypeDetector {
    private static final int BUFFER_SIZE = 8;
    public static final int CLASSFILE = -889275714;
    public static final int GZFILE = 529203200;
    public static final int PACK200FILE = -889270259;
    public static final int UNKNOWN = -1;
    public static final int ZIPFILE = 1347093252;

    /* renamed from: in */
    private final InputStream f43247in;
    private final int type;

    public ContentTypeDetector(InputStream in) throws IOException {
        if (in.markSupported()) {
            this.f43247in = in;
        } else {
            this.f43247in = new BufferedInputStream(in, 8);
        }
        this.f43247in.mark(8);
        this.type = determineType(this.f43247in);
        this.f43247in.reset();
    }

    private static int determineType(InputStream in) throws IOException {
        int header = readInt(in);
        if (header == -889275714) {
            int readInt = readInt(in);
            if (readInt != 196653) {
                switch (readInt) {
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                        break;
                }
            }
            return CLASSFILE;
        } else if (header == -889270259) {
            return PACK200FILE;
        } else {
            if (header == 1347093252) {
                return ZIPFILE;
            }
        }
        if ((-65536 & header) == 529203200) {
            return GZFILE;
        }
        return -1;
    }

    private static int readInt(InputStream in) throws IOException {
        return (in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read();
    }

    public InputStream getInputStream() {
        return this.f43247in;
    }

    public int getType() {
        return this.type;
    }
}

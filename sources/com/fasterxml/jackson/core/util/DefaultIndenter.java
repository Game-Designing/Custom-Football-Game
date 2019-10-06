package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter;
import java.io.IOException;

public class DefaultIndenter extends NopIndenter {
    public static final DefaultIndenter SYSTEM_LINEFEED_INSTANCE = new DefaultIndenter("  ", SYS_LF);
    public static final String SYS_LF;
    private final int charsPerLevel;
    private final String eol;
    private final char[] indents;

    static {
        String lf;
        try {
            lf = System.getProperty("line.separator");
        } catch (Throwable th) {
            lf = "\n";
        }
        SYS_LF = lf;
    }

    public DefaultIndenter(String indent, String eol2) {
        this.charsPerLevel = indent.length();
        this.indents = new char[(indent.length() * 16)];
        int offset = 0;
        for (int i = 0; i < 16; i++) {
            indent.getChars(0, indent.length(), this.indents, offset);
            offset += indent.length();
        }
        this.eol = eol2;
    }

    public boolean isInline() {
        return false;
    }

    public void writeIndentation(JsonGenerator jg, int level) throws IOException {
        jg.writeRaw(this.eol);
        if (level > 0) {
            int level2 = level * this.charsPerLevel;
            while (true) {
                char[] cArr = this.indents;
                if (level2 > cArr.length) {
                    jg.writeRaw(cArr, 0, cArr.length);
                    level2 -= this.indents.length;
                } else {
                    jg.writeRaw(cArr, 0, level2);
                    return;
                }
            }
        }
    }
}

package com.google.zxing.p199c.p200a;

/* renamed from: com.google.zxing.c.a.f */
/* compiled from: EdifactEncoder */
final class C10218f implements C10219g {
    C10218f() {
    }

    /* renamed from: a */
    public int mo33553a() {
        return 4;
    }

    /* renamed from: a */
    public void mo33544a(C10220h context) {
        StringBuilder buffer = new StringBuilder();
        while (true) {
            if (!context.mo33568h()) {
                break;
            }
            m33285a(context.mo33562c(), buffer);
            context.f30986f++;
            if (buffer.length() >= 4) {
                context.mo33559a(m33284a((CharSequence) buffer, 0));
                buffer.delete(0, 4);
                if (C10222j.m33314a(context.mo33564d(), context.f30986f, mo33553a()) != mo33553a()) {
                    context.mo33561b(0);
                    break;
                }
            }
        }
        buffer.append(31);
        m33286a(context, (CharSequence) buffer);
    }

    /* renamed from: a */
    private static void m33286a(C10220h context, CharSequence buffer) {
        try {
            int length = buffer.length();
            int count = length;
            if (length != 0) {
                boolean restInAscii = true;
                if (count == 1) {
                    context.mo33571k();
                    int available = context.mo33567g().mo33572a() - context.mo33554a();
                    if (context.mo33566f() == 0 && available <= 2) {
                        context.mo33561b(0);
                        return;
                    }
                }
                if (count <= 4) {
                    int restChars = count - 1;
                    String encoded = m33284a(buffer, 0);
                    if (!(!context.mo33568h()) || restChars > 2) {
                        restInAscii = false;
                    }
                    if (restChars <= 2) {
                        context.mo33563c(context.mo33554a() + restChars);
                        if (context.mo33567g().mo33572a() - context.mo33554a() >= 3) {
                            restInAscii = false;
                            context.mo33563c(context.mo33554a() + encoded.length());
                        }
                    }
                    if (restInAscii) {
                        context.mo33570j();
                        context.f30986f -= restChars;
                    } else {
                        context.mo33559a(encoded);
                    }
                    context.mo33561b(0);
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            context.mo33561b(0);
        }
    }

    /* renamed from: a */
    private static void m33285a(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            C10222j.m33318a(c);
            throw null;
        } else {
            sb.append((char) (c - '@'));
        }
    }

    /* renamed from: a */
    private static String m33284a(CharSequence sb, int startPos) {
        int length = sb.length() - startPos;
        int len = length;
        if (length != 0) {
            int charAt = (sb.charAt(startPos) << 18) + ((len >= 2 ? sb.charAt(startPos + 1) : 0) << 12) + ((len >= 3 ? sb.charAt(startPos + 2) : 0) << 6) + (len >= 4 ? sb.charAt(startPos + 3) : 0);
            int v = charAt;
            char cw1 = (char) ((charAt >> 16) & 255);
            char cw2 = (char) ((v >> 8) & 255);
            char cw3 = (char) (v & 255);
            StringBuilder sb2 = new StringBuilder(3);
            StringBuilder res = sb2;
            sb2.append(cw1);
            if (len >= 2) {
                res.append(cw2);
            }
            if (len >= 3) {
                res.append(cw3);
            }
            return res.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}

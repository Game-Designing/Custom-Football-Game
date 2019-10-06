package com.google.zxing.p199c.p200a;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.c.a.c */
/* compiled from: C40Encoder */
class C10215c implements C10219g {
    C10215c() {
    }

    /* renamed from: a */
    public int mo33546a() {
        return 1;
    }

    /* renamed from: a */
    public void mo33544a(C10220h context) {
        StringBuilder buffer = new StringBuilder();
        while (true) {
            if (!context.mo33568h()) {
                break;
            }
            char c = context.mo33562c();
            context.f30986f++;
            int lastCharSize = mo33547a(c, buffer);
            int curCodewordCount = context.mo33554a() + ((buffer.length() / 3) << 1);
            context.mo33563c(curCodewordCount);
            int available = context.mo33567g().mo33572a() - curCodewordCount;
            if (!context.mo33568h()) {
                StringBuilder removed = new StringBuilder();
                if (buffer.length() % 3 == 2 && (available < 2 || available > 2)) {
                    lastCharSize = m33265a(context, buffer, removed, lastCharSize);
                }
                while (buffer.length() % 3 == 1 && ((lastCharSize <= 3 && available != 1) || lastCharSize > 3)) {
                    lastCharSize = m33265a(context, buffer, removed, lastCharSize);
                }
            } else if (buffer.length() % 3 == 0) {
                int a = C10222j.m33314a(context.mo33564d(), context.f30986f, mo33546a());
                int newMode = a;
                if (a != mo33546a()) {
                    context.mo33561b(newMode);
                    break;
                }
            }
        }
        mo33548a(context, buffer);
    }

    /* renamed from: a */
    private int m33265a(C10220h context, StringBuilder buffer, StringBuilder removed, int lastCharSize) {
        int count = buffer.length();
        buffer.delete(count - lastCharSize, count);
        context.f30986f--;
        int lastCharSize2 = mo33547a(context.mo33562c(), removed);
        context.mo33570j();
        return lastCharSize2;
    }

    /* renamed from: b */
    static void m33267b(C10220h context, StringBuilder buffer) {
        context.mo33559a(m33266a((CharSequence) buffer, 0));
        buffer.delete(0, 3);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33548a(C10220h context, StringBuilder buffer) {
        int rest = buffer.length() % 3;
        int curCodewordCount = context.mo33554a() + ((buffer.length() / 3) << 1);
        context.mo33563c(curCodewordCount);
        int available = context.mo33567g().mo33572a() - curCodewordCount;
        if (rest == 2) {
            buffer.append(0);
            while (buffer.length() >= 3) {
                m33267b(context, buffer);
            }
            if (context.mo33568h()) {
                context.mo33555a(254);
            }
        } else if (available == 1 && rest == 1) {
            while (buffer.length() >= 3) {
                m33267b(context, buffer);
            }
            if (context.mo33568h()) {
                context.mo33555a(254);
            }
            context.f30986f--;
        } else if (rest == 0) {
            while (buffer.length() >= 3) {
                m33267b(context, buffer);
            }
            if (available > 0 || context.mo33568h()) {
                context.mo33555a(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        context.mo33561b(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo33547a(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append(3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        } else if (c >= 0 && c <= 31) {
            sb.append(0);
            sb.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            sb.append(1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c >= ':' && c <= '@') {
            sb.append(1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            sb.append(1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        } else if (c >= '`' && c <= 127) {
            sb.append(2);
            sb.append((char) (c - '`'));
            return 2;
        } else if (c >= 128) {
            sb.append("\u0001\u001e");
            return mo33547a((char) (c - 128), sb) + 2;
        } else {
            StringBuilder sb2 = new StringBuilder("Illegal character: ");
            sb2.append(c);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* renamed from: a */
    private static String m33266a(CharSequence sb, int startPos) {
        int charAt = (sb.charAt(startPos) * 1600) + (sb.charAt(startPos + 1) * '(') + sb.charAt(startPos + 2) + 1;
        return new String(new char[]{(char) (charAt / Opcodes.ACC_NATIVE), (char) (charAt % Opcodes.ACC_NATIVE)});
    }
}

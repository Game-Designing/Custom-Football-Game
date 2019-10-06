package com.google.zxing.p199c.p200a;

/* renamed from: com.google.zxing.c.a.n */
/* compiled from: X12Encoder */
final class C10226n extends C10215c {
    C10226n() {
    }

    /* renamed from: a */
    public int mo33546a() {
        return 3;
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
            mo33547a(c, buffer);
            if (buffer.length() % 3 == 0) {
                C10215c.m33267b(context, buffer);
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

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo33547a(char c, StringBuilder sb) {
        if (c == 13) {
            sb.append(0);
        } else if (c == '*') {
            sb.append(1);
        } else if (c == '>') {
            sb.append(2);
        } else if (c == ' ') {
            sb.append(3);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c < 'A' || c > 'Z') {
            C10222j.m33318a(c);
            throw null;
        } else {
            sb.append((char) ((c - 'A') + 14));
        }
        return 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33548a(C10220h context, StringBuilder buffer) {
        context.mo33571k();
        int available = context.mo33567g().mo33572a() - context.mo33554a();
        context.f30986f -= buffer.length();
        if (context.mo33566f() > 1 || available > 1 || context.mo33566f() != available) {
            context.mo33555a(254);
        }
        if (context.mo33565e() < 0) {
            context.mo33561b(0);
        }
    }
}

package com.google.zxing.p199c.p200a;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.c.a.a */
/* compiled from: ASCIIEncoder */
final class C10213a implements C10219g {
    C10213a() {
    }

    /* renamed from: a */
    public int mo33543a() {
        return 0;
    }

    /* renamed from: a */
    public void mo33544a(C10220h context) {
        if (C10222j.m33313a((CharSequence) context.mo33564d(), context.f30986f) >= 2) {
            context.mo33555a(m33259a(context.mo33564d().charAt(context.f30986f), context.mo33564d().charAt(context.f30986f + 1)));
            context.f30986f += 2;
            return;
        }
        char c = context.mo33562c();
        int a = C10222j.m33314a(context.mo33564d(), context.f30986f, mo33543a());
        int newMode = a;
        if (a != mo33543a()) {
            if (newMode == 1) {
                context.mo33555a(230);
                context.mo33561b(1);
            } else if (newMode == 2) {
                context.mo33555a(239);
                context.mo33561b(2);
            } else if (newMode == 3) {
                context.mo33555a(238);
                context.mo33561b(3);
            } else if (newMode == 4) {
                context.mo33555a(240);
                context.mo33561b(4);
            } else if (newMode == 5) {
                context.mo33555a(231);
                context.mo33561b(5);
            } else {
                StringBuilder sb = new StringBuilder("Illegal mode: ");
                sb.append(newMode);
                throw new IllegalStateException(sb.toString());
            }
        } else if (C10222j.m33320c(c)) {
            context.mo33555a(235);
            context.mo33555a((char) ((c - 128) + 1));
            context.f30986f++;
        } else {
            context.mo33555a((char) (c + 1));
            context.f30986f++;
        }
    }

    /* renamed from: a */
    private static char m33259a(char digit1, char digit2) {
        if (C10222j.m33319b(digit1) && C10222j.m33319b(digit2)) {
            return (char) (((digit1 - '0') * 10) + (digit2 - '0') + Opcodes.IXOR);
        }
        StringBuilder sb = new StringBuilder("not digits: ");
        sb.append(digit1);
        sb.append(digit2);
        throw new IllegalArgumentException(sb.toString());
    }
}

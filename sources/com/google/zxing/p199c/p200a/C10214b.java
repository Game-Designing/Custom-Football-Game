package com.google.zxing.p199c.p200a;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.c.a.b */
/* compiled from: Base256Encoder */
final class C10214b implements C10219g {
    C10214b() {
    }

    /* renamed from: a */
    public int mo33545a() {
        return 5;
    }

    /* renamed from: a */
    public void mo33544a(C10220h context) {
        StringBuilder sb = new StringBuilder();
        StringBuilder buffer = sb;
        sb.append(0);
        while (true) {
            if (!context.mo33568h()) {
                break;
            }
            buffer.append(context.mo33562c());
            context.f30986f++;
            int a = C10222j.m33314a(context.mo33564d(), context.f30986f, mo33545a());
            int newMode = a;
            if (a != mo33545a()) {
                context.mo33561b(newMode);
                break;
            }
        }
        int dataCount = buffer.length() - 1;
        int currentSize = context.mo33554a() + dataCount + 1;
        context.mo33563c(currentSize);
        boolean mustPad = context.mo33567g().mo33572a() - currentSize > 0;
        if (context.mo33568h() || mustPad) {
            if (dataCount <= 249) {
                buffer.setCharAt(0, (char) dataCount);
            } else if (dataCount <= 1555) {
                buffer.setCharAt(0, (char) ((dataCount / 250) + 249));
                buffer.insert(1, (char) (dataCount % 250));
            } else {
                StringBuilder sb2 = new StringBuilder("Message length not in valid ranges: ");
                sb2.append(dataCount);
                throw new IllegalStateException(sb2.toString());
            }
        }
        int c = buffer.length();
        for (int i = 0; i < c; i++) {
            context.mo33555a(m33262a(buffer.charAt(i), context.mo33554a() + 1));
        }
    }

    /* renamed from: a */
    private static char m33262a(char ch, int codewordPosition) {
        int i = ch + ((codewordPosition * Opcodes.FCMPL) % 255) + 1;
        int tempVariable = i;
        if (i <= 255) {
            return (char) tempVariable;
        }
        return (char) (tempVariable - 256);
    }
}

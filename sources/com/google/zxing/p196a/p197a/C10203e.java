package com.google.zxing.p196a.p197a;

import com.google.zxing.aztec.encoder.State;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.a.a.e */
/* compiled from: HighLevelEncoder */
public final class C10203e {

    /* renamed from: a */
    static final String[] f30911a = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: b */
    static final int[][] f30912b = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: c */
    private static final int[][] f30913c;

    /* renamed from: d */
    static final int[][] f30914d;

    /* renamed from: e */
    private final byte[] f30915e;

    static {
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{5, Opcodes.ACC_NATIVE});
        f30913c = iArr;
        iArr[0][32] = 1;
        for (int c = 65; c <= 90; c++) {
            f30913c[0][c] = (c - 65) + 2;
        }
        f30913c[1][32] = 1;
        for (int c2 = 97; c2 <= 122; c2++) {
            f30913c[1][c2] = (c2 - 97) + 2;
        }
        f30913c[2][32] = 1;
        for (int c3 = 48; c3 <= 57; c3++) {
            f30913c[2][c3] = (c3 - 48) + 2;
        }
        int[][] iArr2 = f30913c;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] mixedTable = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, Opcodes.IUSHR, Opcodes.IAND, Opcodes.LAND};
        for (int i = 0; i < 28; i++) {
            f30913c[3][mixedTable[i]] = i;
        }
        int[] punctTable = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, Opcodes.LUSHR};
        for (int i2 = 0; i2 < 31; i2++) {
            if (punctTable[i2] > 0) {
                f30913c[4][punctTable[i2]] = i2;
            }
        }
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{6, 6});
        f30914d = iArr3;
        for (int[] fill : iArr3) {
            Arrays.fill(fill, -1);
        }
        int[][] iArr4 = f30914d;
        iArr4[0][4] = 0;
        iArr4[1][4] = 0;
        iArr4[1][0] = 28;
        iArr4[3][4] = 0;
        iArr4[2][4] = 0;
        iArr4[2][0] = 15;
    }

    public C10203e(byte[] text) {
        this.f30915e = text;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v4, types: [byte] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.p198b.C10208a mo33499a() {
        /*
            r7 = this;
            com.google.zxing.a.a.g r0 = com.google.zxing.p196a.p197a.C10205g.f30918a
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
        L_0x0007:
            byte[] r2 = r7.f30915e
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0056
            int r3 = r1 + 1
            int r4 = r2.length
            r5 = 0
            if (r3 >= r4) goto L_0x0017
            int r3 = r1 + 1
            byte r2 = r2[r3]
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            byte[] r3 = r7.f30915e
            byte r3 = r3[r1]
            r4 = 13
            if (r3 == r4) goto L_0x003f
            r4 = 44
            r6 = 32
            if (r3 == r4) goto L_0x003a
            r4 = 46
            if (r3 == r4) goto L_0x0035
            r4 = 58
            if (r3 == r4) goto L_0x0030
            r3 = 0
            goto L_0x0046
        L_0x0030:
            if (r2 != r6) goto L_0x0033
            r5 = 5
        L_0x0033:
            r3 = r5
            goto L_0x0046
        L_0x0035:
            if (r2 != r6) goto L_0x0038
            r5 = 3
        L_0x0038:
            r3 = r5
            goto L_0x0046
        L_0x003a:
            if (r2 != r6) goto L_0x003d
            r5 = 4
        L_0x003d:
            r3 = r5
            goto L_0x0046
        L_0x003f:
            r3 = 10
            if (r2 != r3) goto L_0x0044
            r5 = 2
        L_0x0044:
            r3 = r5
        L_0x0046:
            if (r3 <= 0) goto L_0x004f
            java.util.Collection r0 = m33216a(r0, r1, r3)
            int r1 = r1 + 1
            goto L_0x0053
        L_0x004f:
            java.util.Collection r0 = r7.m33215a(r0, r1)
        L_0x0053:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x0056:
            com.google.zxing.a.a.d r1 = new com.google.zxing.a.a.d
            r1.<init>(r7)
            java.lang.Object r1 = java.util.Collections.min(r0, r1)
            com.google.zxing.a.a.g r1 = (com.google.zxing.p196a.p197a.C10205g) r1
            r2 = 0
            byte[] r3 = r7.f30915e
            com.google.zxing.b.a r1 = r1.mo33504a(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.p196a.p197a.C10203e.mo33499a():com.google.zxing.b.a");
    }

    /* renamed from: a */
    private Collection<C10205g> m33215a(Iterable<C10205g> states, int index) {
        Collection<State> result = new LinkedList<>();
        for (C10205g state : states) {
            m33218a(state, index, result);
        }
        return m33214a(result);
    }

    /* renamed from: a */
    private void m33218a(C10205g state, int index, Collection<C10205g> result) {
        char ch = (char) (this.f30915e[index] & 255);
        boolean charInCurrentTable = f30913c[state.mo33509c()][ch] > 0;
        C10205g stateNoBinary = null;
        for (int mode = 0; mode <= 4; mode++) {
            int i = f30913c[mode][ch];
            int charInMode = i;
            if (i > 0) {
                if (stateNoBinary == null) {
                    stateNoBinary = state.mo33507b(index);
                }
                if (!charInCurrentTable || mode == state.mo33509c() || mode == 2) {
                    result.add(stateNoBinary.mo33503a(mode, charInMode));
                }
                if (!charInCurrentTable && f30914d[state.mo33509c()][mode] >= 0) {
                    result.add(stateNoBinary.mo33508b(mode, charInMode));
                }
            }
        }
        if (state.mo33501a() > 0 || f30913c[state.mo33509c()][ch] == 0) {
            result.add(state.mo33502a(index));
        }
    }

    /* renamed from: a */
    private static Collection<C10205g> m33216a(Iterable<C10205g> states, int index, int pairCode) {
        Collection<State> result = new LinkedList<>();
        for (C10205g a : states) {
            m33217a(a, index, pairCode, result);
        }
        return m33214a(result);
    }

    /* renamed from: a */
    private static void m33217a(C10205g state, int index, int pairCode, Collection<C10205g> result) {
        C10205g stateNoBinary = state.mo33507b(index);
        result.add(stateNoBinary.mo33503a(4, pairCode));
        if (state.mo33509c() != 4) {
            result.add(stateNoBinary.mo33508b(4, pairCode));
        }
        if (pairCode == 3 || pairCode == 4) {
            result.add(stateNoBinary.mo33503a(2, 16 - pairCode).mo33503a(2, 1));
        }
        if (state.mo33501a() > 0) {
            result.add(state.mo33502a(index).mo33502a(index + 1));
        }
    }

    /* renamed from: a */
    private static Collection<C10205g> m33214a(Iterable<C10205g> states) {
        List<State> result = new LinkedList<>();
        for (C10205g newState : states) {
            boolean add = true;
            Iterator<State> iterator = result.iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    break;
                }
                C10205g gVar = (C10205g) iterator.next();
                C10205g oldState = gVar;
                if (gVar.mo33505a(newState)) {
                    add = false;
                    break;
                } else if (newState.mo33505a(oldState)) {
                    iterator.remove();
                }
            }
            if (add) {
                result.add(newState);
            }
        }
        return result;
    }
}

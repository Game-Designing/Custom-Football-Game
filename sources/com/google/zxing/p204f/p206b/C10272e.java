package com.google.zxing.p204f.p206b;

/* renamed from: com.google.zxing.f.b.e */
/* compiled from: MaskUtil */
final class C10272e {
    /* renamed from: a */
    static int m33484a(C10269b matrix) {
        return m33485a(matrix, true) + m33485a(matrix, false);
    }

    /* renamed from: b */
    static int m33489b(C10269b matrix) {
        int penalty = 0;
        byte[][] array = matrix.mo33635a();
        int width = matrix.mo33637c();
        int height = matrix.mo33636b();
        for (int y = 0; y < height - 1; y++) {
            for (int x = 0; x < width - 1; x++) {
                byte b = array[y][x];
                int value = b;
                if (b == array[y][x + 1] && value == array[y + 1][x] && value == array[y + 1][x + 1]) {
                    penalty++;
                }
            }
        }
        return penalty * 3;
    }

    /* renamed from: c */
    static int m33490c(C10269b matrix) {
        int numPenalties = 0;
        byte[][] array = matrix.mo33635a();
        int width = matrix.mo33637c();
        int height = matrix.mo33636b();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                byte[] arrayY = array[y];
                if (x + 6 < width && arrayY[x] == 1 && arrayY[x + 1] == 0 && arrayY[x + 2] == 1 && arrayY[x + 3] == 1 && arrayY[x + 4] == 1 && arrayY[x + 5] == 0 && arrayY[x + 6] == 1 && (m33487a(arrayY, x - 4, x) || m33487a(arrayY, x + 7, x + 11))) {
                    numPenalties++;
                }
                if (y + 6 < height && array[y][x] == 1 && array[y + 1][x] == 0 && array[y + 2][x] == 1 && array[y + 3][x] == 1 && array[y + 4][x] == 1 && array[y + 5][x] == 0 && array[y + 6][x] == 1 && (m33488a(array, x, y - 4, y) || m33488a(array, x, y + 7, y + 11))) {
                    numPenalties++;
                }
            }
        }
        return numPenalties * 40;
    }

    /* renamed from: a */
    private static boolean m33487a(byte[] rowArray, int from, int to) {
        int from2 = Math.max(from, 0);
        int to2 = Math.min(to, rowArray.length);
        for (int i = from2; i < to2; i++) {
            if (rowArray[i] == 1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m33488a(byte[][] array, int col, int from, int to) {
        int from2 = Math.max(from, 0);
        int to2 = Math.min(to, array.length);
        for (int i = from2; i < to2; i++) {
            if (array[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    static int m33491d(C10269b matrix) {
        int numDarkCells = 0;
        byte[][] array = matrix.mo33635a();
        int width = matrix.mo33637c();
        int height = matrix.mo33636b();
        for (int y = 0; y < height; y++) {
            byte[] arrayY = array[y];
            for (int x = 0; x < width; x++) {
                if (arrayY[x] == 1) {
                    numDarkCells++;
                }
            }
        }
        int numTotalCells = matrix.mo33636b() * matrix.mo33637c();
        return ((Math.abs((numDarkCells << 1) - numTotalCells) * 10) / numTotalCells) * 10;
    }

    /* renamed from: a */
    static boolean m33486a(int maskPattern, int x, int y) {
        int intermediate;
        switch (maskPattern) {
            case 0:
                intermediate = (y + x) & 1;
                break;
            case 1:
                intermediate = y & 1;
                break;
            case 2:
                intermediate = x % 3;
                break;
            case 3:
                intermediate = (y + x) % 3;
                break;
            case 4:
                intermediate = ((y / 2) + (x / 3)) & 1;
                break;
            case 5:
                int intermediate2 = y * x;
                intermediate = (intermediate2 & 1) + (intermediate2 % 3);
                break;
            case 6:
                int intermediate3 = y * x;
                intermediate = ((intermediate3 & 1) + (intermediate3 % 3)) & 1;
                break;
            case 7:
                intermediate = (((y * x) % 3) + ((y + x) & 1)) & 1;
                break;
            default:
                StringBuilder sb = new StringBuilder("Invalid mask pattern: ");
                sb.append(maskPattern);
                throw new IllegalArgumentException(sb.toString());
        }
        if (intermediate == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r10v2, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r10v4, types: [byte] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m33485a(com.google.zxing.p204f.p206b.C10269b r11, boolean r12) {
        /*
            r0 = 0
            if (r12 == 0) goto L_0x0008
            int r1 = r11.mo33636b()
            goto L_0x000c
        L_0x0008:
            int r1 = r11.mo33637c()
        L_0x000c:
            if (r12 == 0) goto L_0x0013
            int r2 = r11.mo33637c()
            goto L_0x0017
        L_0x0013:
            int r2 = r11.mo33636b()
        L_0x0017:
            byte[][] r3 = r11.mo33635a()
            r4 = 0
            r5 = 0
        L_0x001d:
            if (r4 >= r1) goto L_0x004c
            r6 = 0
            r7 = -1
            r8 = 0
        L_0x0022:
            r9 = 5
            if (r8 >= r2) goto L_0x0042
            if (r12 == 0) goto L_0x002c
            r10 = r3[r4]
            byte r10 = r10[r8]
            goto L_0x0030
        L_0x002c:
            r10 = r3[r8]
            byte r10 = r10[r4]
        L_0x0030:
            r5 = r10
            if (r10 != r7) goto L_0x0036
            int r6 = r6 + 1
            goto L_0x003f
        L_0x0036:
            if (r6 < r9) goto L_0x003d
            int r9 = r6 + -5
            int r9 = r9 + 3
            int r0 = r0 + r9
        L_0x003d:
            r6 = 1
            r7 = r5
        L_0x003f:
            int r8 = r8 + 1
            goto L_0x0022
        L_0x0042:
            if (r6 < r9) goto L_0x0049
            int r8 = r6 + -5
            int r8 = r8 + 3
            int r0 = r0 + r8
        L_0x0049:
            int r4 = r4 + 1
            goto L_0x001d
        L_0x004c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.p204f.p206b.C10272e.m33485a(com.google.zxing.f.b.b, boolean):int");
    }
}

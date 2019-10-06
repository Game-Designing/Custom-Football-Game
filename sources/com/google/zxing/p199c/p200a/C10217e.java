package com.google.zxing.p199c.p200a;

import java.util.Arrays;

/* renamed from: com.google.zxing.c.a.e */
/* compiled from: DefaultPlacement */
public class C10217e {

    /* renamed from: a */
    private final CharSequence f30977a;

    /* renamed from: b */
    private final int f30978b;

    /* renamed from: c */
    private final int f30979c;

    /* renamed from: d */
    private final byte[] f30980d;

    public C10217e(CharSequence codewords, int numcols, int numrows) {
        this.f30977a = codewords;
        this.f30979c = numcols;
        this.f30978b = numrows;
        this.f30980d = new byte[(numcols * numrows)];
        Arrays.fill(this.f30980d, -1);
    }

    /* renamed from: a */
    public final boolean mo33552a(int col, int row) {
        return this.f30980d[(this.f30979c * row) + col] == 1;
    }

    /* renamed from: a */
    private void m33277a(int col, int row, boolean bit) {
        this.f30980d[(this.f30979c * row) + col] = bit ? (byte) 1 : 0;
    }

    /* renamed from: b */
    private boolean m33279b(int col, int row) {
        return this.f30980d[(this.f30979c * row) + col] >= 0;
    }

    /* renamed from: a */
    public final void mo33551a() {
        int i;
        int i2;
        int pos = 0;
        int row = 4;
        int col = 0;
        while (true) {
            if (row == this.f30978b && col == 0) {
                int pos2 = pos + 1;
                m33274a(pos);
                pos = pos2;
            }
            if (row == this.f30978b - 2 && col == 0 && this.f30979c % 4 != 0) {
                int pos3 = pos + 1;
                m33278b(pos);
                pos = pos3;
            }
            if (row == this.f30978b - 2 && col == 0 && this.f30979c % 8 == 4) {
                int pos4 = pos + 1;
                m33280c(pos);
                pos = pos4;
            }
            if (row == this.f30978b + 4 && col == 2 && this.f30979c % 8 == 0) {
                int pos5 = pos + 1;
                m33281d(pos);
                pos = pos5;
            }
            do {
                if (row < this.f30978b && col >= 0 && !m33279b(col, row)) {
                    int pos6 = pos + 1;
                    m33275a(row, col, pos);
                    pos = pos6;
                }
                row -= 2;
                col += 2;
                if (row < 0) {
                    break;
                }
            } while (col < this.f30979c);
            int row2 = row + 1;
            int col2 = col + 3;
            do {
                if (row2 >= 0 && col2 < this.f30979c && !m33279b(col2, row2)) {
                    int pos7 = pos + 1;
                    m33275a(row2, col2, pos);
                    pos = pos7;
                }
                row2 += 2;
                col2 -= 2;
                if (row2 >= this.f30978b) {
                    break;
                }
            } while (col2 >= 0);
            row = row2 + 3;
            col = col2 + 1;
            i = this.f30978b;
            if (row >= i) {
                i2 = this.f30979c;
                if (col >= i2) {
                    break;
                }
            }
        }
        if (!m33279b(i2 - 1, i - 1)) {
            m33277a(this.f30979c - 1, this.f30978b - 1, true);
            m33277a(this.f30979c - 2, this.f30978b - 2, true);
        }
    }

    /* renamed from: a */
    private void m33276a(int row, int col, int pos, int bit) {
        if (row < 0) {
            int i = this.f30978b;
            row += i;
            col += 4 - ((i + 4) % 8);
        }
        if (col < 0) {
            int i2 = this.f30979c;
            col += i2;
            row += 4 - ((i2 + 4) % 8);
        }
        boolean z = false;
        if ((this.f30977a.charAt(pos) & (1 << (8 - bit))) != 0) {
            z = true;
        }
        m33277a(col, row, z);
    }

    /* renamed from: a */
    private void m33275a(int row, int col, int pos) {
        m33276a(row - 2, col - 2, pos, 1);
        m33276a(row - 2, col - 1, pos, 2);
        m33276a(row - 1, col - 2, pos, 3);
        m33276a(row - 1, col - 1, pos, 4);
        m33276a(row - 1, col, pos, 5);
        m33276a(row, col - 2, pos, 6);
        m33276a(row, col - 1, pos, 7);
        m33276a(row, col, pos, 8);
    }

    /* renamed from: a */
    private void m33274a(int pos) {
        m33276a(this.f30978b - 1, 0, pos, 1);
        m33276a(this.f30978b - 1, 1, pos, 2);
        m33276a(this.f30978b - 1, 2, pos, 3);
        m33276a(0, this.f30979c - 2, pos, 4);
        m33276a(0, this.f30979c - 1, pos, 5);
        m33276a(1, this.f30979c - 1, pos, 6);
        m33276a(2, this.f30979c - 1, pos, 7);
        m33276a(3, this.f30979c - 1, pos, 8);
    }

    /* renamed from: b */
    private void m33278b(int pos) {
        m33276a(this.f30978b - 3, 0, pos, 1);
        m33276a(this.f30978b - 2, 0, pos, 2);
        m33276a(this.f30978b - 1, 0, pos, 3);
        m33276a(0, this.f30979c - 4, pos, 4);
        m33276a(0, this.f30979c - 3, pos, 5);
        m33276a(0, this.f30979c - 2, pos, 6);
        m33276a(0, this.f30979c - 1, pos, 7);
        m33276a(1, this.f30979c - 1, pos, 8);
    }

    /* renamed from: c */
    private void m33280c(int pos) {
        m33276a(this.f30978b - 3, 0, pos, 1);
        m33276a(this.f30978b - 2, 0, pos, 2);
        m33276a(this.f30978b - 1, 0, pos, 3);
        m33276a(0, this.f30979c - 2, pos, 4);
        m33276a(0, this.f30979c - 1, pos, 5);
        m33276a(1, this.f30979c - 1, pos, 6);
        m33276a(2, this.f30979c - 1, pos, 7);
        m33276a(3, this.f30979c - 1, pos, 8);
    }

    /* renamed from: d */
    private void m33281d(int pos) {
        m33276a(this.f30978b - 1, 0, pos, 1);
        m33276a(this.f30978b - 1, this.f30979c - 1, pos, 2);
        m33276a(0, this.f30979c - 3, pos, 3);
        m33276a(0, this.f30979c - 2, pos, 4);
        m33276a(0, this.f30979c - 1, pos, 5);
        m33276a(1, this.f30979c - 3, pos, 6);
        m33276a(1, this.f30979c - 2, pos, 7);
        m33276a(1, this.f30979c - 1, pos, 8);
    }
}

package com.google.zxing.p202e.p203a;

/* renamed from: com.google.zxing.e.a.b */
/* compiled from: BarcodeRow */
final class C10255b {

    /* renamed from: a */
    private final byte[] f31066a;

    /* renamed from: b */
    private int f31067b = 0;

    C10255b(int width) {
        this.f31066a = new byte[width];
    }

    /* renamed from: a */
    private void m33402a(int x, boolean black) {
        this.f31066a[x] = black ? (byte) 1 : 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33603a(boolean black, int width) {
        for (int ii = 0; ii < width; ii++) {
            int i = this.f31067b;
            this.f31067b = i + 1;
            m33402a(i, black);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public byte[] mo33604a(int scale) {
        byte[] output = new byte[(this.f31066a.length * scale)];
        for (int i = 0; i < output.length; i++) {
            output[i] = this.f31066a[i / scale];
        }
        return output;
    }
}

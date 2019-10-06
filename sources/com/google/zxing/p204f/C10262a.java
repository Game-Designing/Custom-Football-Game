package com.google.zxing.p204f;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.C10275g;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import com.google.zxing.p204f.p205a.C10263a;
import com.google.zxing.p204f.p206b.C10269b;
import com.google.zxing.p204f.p206b.C10271d;
import com.google.zxing.p204f.p206b.C10274g;
import java.util.Map;

/* renamed from: com.google.zxing.f.a */
/* compiled from: QRCodeWriter */
public final class C10262a implements C10275g {
    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        if (contents.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (format != C10197a.QR_CODE) {
            StringBuilder sb = new StringBuilder("Can only encode QR_CODE, but got ");
            sb.append(format);
            throw new IllegalArgumentException(sb.toString());
        } else if (width < 0 || height < 0) {
            StringBuilder sb2 = new StringBuilder("Requested dimensions are too small: ");
            sb2.append(width);
            sb2.append('x');
            sb2.append(height);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            C10263a errorCorrectionLevel = C10263a.L;
            int quietZone = 4;
            if (hints != null) {
                if (hints.containsKey(C10211c.ERROR_CORRECTION)) {
                    errorCorrectionLevel = C10263a.valueOf(hints.get(C10211c.ERROR_CORRECTION).toString());
                }
                if (hints.containsKey(C10211c.MARGIN)) {
                    quietZone = Integer.parseInt(hints.get(C10211c.MARGIN).toString());
                }
            }
            return m33436a(C10271d.m33470a(contents, errorCorrectionLevel, hints), width, height, quietZone);
        }
    }

    /* renamed from: a */
    private static C10209b m33436a(C10274g code, int width, int height, int quietZone) {
        C10269b a = code.mo33639a();
        C10269b input = a;
        if (a != null) {
            int inputWidth = input.mo33637c();
            int inputHeight = input.mo33636b();
            int qrWidth = (quietZone << 1) + inputWidth;
            int qrHeight = (quietZone << 1) + inputHeight;
            int outputWidth = Math.max(width, qrWidth);
            int outputHeight = Math.max(height, qrHeight);
            int multiple = Math.min(outputWidth / qrWidth, outputHeight / qrHeight);
            int leftPadding = (outputWidth - (inputWidth * multiple)) / 2;
            int topPadding = (outputHeight - (inputHeight * multiple)) / 2;
            C10209b output = new C10209b(outputWidth, outputHeight);
            int inputY = 0;
            int outputY = topPadding;
            while (inputY < inputHeight) {
                int inputX = 0;
                int inputHeight2 = inputHeight;
                int outputX = leftPadding;
                while (inputX < inputWidth) {
                    int inputWidth2 = inputWidth;
                    C10269b input2 = input;
                    if (input.mo33631a(inputX, inputY) == 1) {
                        output.mo33533a(outputX, outputY, multiple, multiple);
                    }
                    inputX++;
                    outputX += multiple;
                    inputWidth = inputWidth2;
                    input = input2;
                }
                C10269b bVar = input;
                inputY++;
                outputY += multiple;
                inputHeight = inputHeight2;
            }
            C10269b bVar2 = input;
            int i = inputHeight;
            return output;
        }
        int i2 = width;
        int i3 = height;
        C10269b bVar3 = input;
        throw new IllegalStateException();
    }
}

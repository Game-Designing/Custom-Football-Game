package com.google.zxing.p196a;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.C10275g;
import com.google.zxing.p196a.p197a.C10199a;
import com.google.zxing.p196a.p197a.C10201c;
import com.google.zxing.p198b.C10209b;
import java.nio.charset.Charset;
import java.util.Map;

/* renamed from: com.google.zxing.a.a */
/* compiled from: AztecWriter */
public final class C10198a implements C10275g {

    /* renamed from: a */
    private static final Charset f30901a = Charset.forName("ISO-8859-1");

    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) {
        Charset charset = f30901a;
        int eccPercent = 33;
        int layers = 0;
        if (hints != null) {
            if (hints.containsKey(C10211c.CHARACTER_SET)) {
                charset = Charset.forName(hints.get(C10211c.CHARACTER_SET).toString());
            }
            if (hints.containsKey(C10211c.ERROR_CORRECTION)) {
                eccPercent = Integer.parseInt(hints.get(C10211c.ERROR_CORRECTION).toString());
            }
            if (hints.containsKey(C10211c.AZTEC_LAYERS)) {
                layers = Integer.parseInt(hints.get(C10211c.AZTEC_LAYERS).toString());
            }
        }
        return m33195a(contents, format, width, height, charset, eccPercent, layers);
    }

    /* renamed from: a */
    private static C10209b m33195a(String contents, C10197a format, int width, int height, Charset charset, int eccPercent, int layers) {
        if (format == C10197a.AZTEC) {
            return m33194a(C10201c.m33205a(contents.getBytes(charset), eccPercent, layers), width, height);
        }
        StringBuilder sb = new StringBuilder("Can only encode AZTEC, but got ");
        sb.append(format);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private static C10209b m33194a(C10199a code, int width, int height) {
        C10209b a = code.mo33489a();
        C10209b input = a;
        if (a != null) {
            int inputWidth = input.mo33537c();
            int inputHeight = input.mo33535b();
            int outputWidth = Math.max(width, inputWidth);
            int outputHeight = Math.max(height, inputHeight);
            int multiple = Math.min(outputWidth / inputWidth, outputHeight / inputHeight);
            int leftPadding = (outputWidth - (inputWidth * multiple)) / 2;
            int topPadding = (outputHeight - (inputHeight * multiple)) / 2;
            C10209b output = new C10209b(outputWidth, outputHeight);
            int inputY = 0;
            int outputY = topPadding;
            while (inputY < inputHeight) {
                int inputX = 0;
                int outputX = leftPadding;
                while (inputX < inputWidth) {
                    if (input.mo33534a(inputX, inputY)) {
                        output.mo33533a(outputX, outputY, multiple, multiple);
                    }
                    inputX++;
                    outputX += multiple;
                }
                inputY++;
                outputY += multiple;
            }
            return output;
        }
        int i = width;
        int i2 = height;
        throw new IllegalStateException();
    }
}

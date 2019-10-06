package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import com.airbnb.lottie.p089c.C5734b;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.e.h */
/* compiled from: DocumentDataParser */
public class C5804h implements C5796K<C5734b> {

    /* renamed from: a */
    public static final C5804h f10083a = new C5804h();

    private C5804h() {
    }

    /* renamed from: a */
    public C5734b m10450a(JsonReader reader, float scale) throws IOException {
        String text = null;
        String fontName = null;
        double size = 0.0d;
        int justification = 0;
        int tracking = 0;
        double lineHeight = 0.0d;
        double baselineShift = 0.0d;
        int fillColor = 0;
        int strokeColor = 0;
        double strokeWidth = 0.0d;
        boolean strokeOverFill = true;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            boolean strokeOverFill2 = strokeOverFill;
            int hashCode = nextName.hashCode();
            double strokeWidth2 = strokeWidth;
            if (hashCode != 102) {
                if (hashCode != 106) {
                    if (hashCode != 3261) {
                        if (hashCode != 3452) {
                            if (hashCode != 3463) {
                                if (hashCode != 3543) {
                                    if (hashCode != 3664) {
                                        if (hashCode != 3684) {
                                            if (hashCode != 3710) {
                                                if (hashCode != 115) {
                                                    if (hashCode == 116 && nextName.equals("t")) {
                                                        c = 0;
                                                    }
                                                } else if (nextName.equals("s")) {
                                                    c = 2;
                                                }
                                            } else if (nextName.equals("tr")) {
                                                c = 4;
                                            }
                                        } else if (nextName.equals("sw")) {
                                            c = 9;
                                        }
                                    } else if (nextName.equals("sc")) {
                                        c = 8;
                                    }
                                } else if (nextName.equals("of")) {
                                    c = 10;
                                }
                            } else if (nextName.equals("ls")) {
                                c = 6;
                            }
                        } else if (nextName.equals("lh")) {
                            c = 5;
                        }
                    } else if (nextName.equals("fc")) {
                        c = 7;
                    }
                } else if (nextName.equals("j")) {
                    c = 3;
                }
            } else if (nextName.equals(InneractiveMediationDefs.GENDER_FEMALE)) {
                c = 1;
            }
            switch (c) {
                case 0:
                    text = reader.nextString();
                    strokeOverFill = strokeOverFill2;
                    strokeWidth = strokeWidth2;
                    break;
                case 1:
                    fontName = reader.nextString();
                    strokeOverFill = strokeOverFill2;
                    strokeWidth = strokeWidth2;
                    break;
                case 2:
                    size = reader.nextDouble();
                    strokeOverFill = strokeOverFill2;
                    strokeWidth = strokeWidth2;
                    break;
                case 3:
                    justification = reader.nextInt();
                    strokeOverFill = strokeOverFill2;
                    strokeWidth = strokeWidth2;
                    break;
                case 4:
                    tracking = reader.nextInt();
                    strokeOverFill = strokeOverFill2;
                    strokeWidth = strokeWidth2;
                    break;
                case 5:
                    lineHeight = reader.nextDouble();
                    strokeOverFill = strokeOverFill2;
                    strokeWidth = strokeWidth2;
                    break;
                case 6:
                    baselineShift = reader.nextDouble();
                    strokeOverFill = strokeOverFill2;
                    strokeWidth = strokeWidth2;
                    break;
                case 7:
                    fillColor = C5813q.m10463a(reader);
                    strokeOverFill = strokeOverFill2;
                    strokeWidth = strokeWidth2;
                    break;
                case 8:
                    strokeColor = C5813q.m10463a(reader);
                    strokeOverFill = strokeOverFill2;
                    strokeWidth = strokeWidth2;
                    break;
                case 9:
                    strokeWidth = reader.nextDouble();
                    strokeOverFill = strokeOverFill2;
                    break;
                case 10:
                    strokeOverFill = reader.nextBoolean();
                    strokeWidth = strokeWidth2;
                    break;
                default:
                    reader.skipValue();
                    strokeOverFill = strokeOverFill2;
                    strokeWidth = strokeWidth2;
                    break;
            }
        }
        double strokeWidth3 = strokeWidth;
        boolean strokeOverFill3 = strokeOverFill;
        reader.endObject();
        C5734b bVar = new C5734b(text, fontName, size, justification, tracking, lineHeight, baselineShift, fillColor, strokeColor, strokeWidth3, strokeOverFill3);
        return bVar;
    }
}

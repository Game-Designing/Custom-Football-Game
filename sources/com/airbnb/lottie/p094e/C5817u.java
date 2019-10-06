package com.airbnb.lottie.p094e;

import android.support.v4.util.LongSparseArray;
import android.util.JsonReader;
import com.airbnb.lottie.C5718c;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.C5853y;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.p089c.C5759c;
import com.airbnb.lottie.p089c.C5775d;
import com.airbnb.lottie.p089c.p092c.C5766g;
import com.airbnb.lottie.p089c.p092c.C5766g.C5767a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1259h;
import p002b.p003c.p053g.p061f.C1274r;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

/* renamed from: com.airbnb.lottie.e.u */
/* compiled from: LottieCompositionParser */
public class C5817u {
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.C5830g m10480a(android.util.JsonReader r26) throws java.io.IOException {
        /*
            r0 = r26
            float r1 = com.airbnb.lottie.p095f.C5829f.m10534a()
            r2 = 0
            r3 = 0
            r4 = 0
            b.c.g.f.h r5 = new b.c.g.f.h
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r15 = r6
            r6 = 0
            r7 = 0
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r14 = r8
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r13 = r8
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r12 = r8
            b.c.g.f.r r8 = new b.c.g.f.r
            r8.<init>()
            r11 = r8
            com.airbnb.lottie.g r8 = new com.airbnb.lottie.g
            r8.<init>()
            r10 = r8
            r26.beginObject()
            r17 = r3
            r18 = r4
            r3 = r7
            r4 = r2
            r2 = r6
        L_0x003e:
            boolean r6 = r26.hasNext()
            r7 = 0
            if (r6 == 0) goto L_0x0135
            java.lang.String r6 = r26.nextName()
            r8 = -1
            int r9 = r6.hashCode()
            r16 = 2
            r19 = 1
            switch(r9) {
                case -1408207997: goto L_0x00b3;
                case -1109732030: goto L_0x00a9;
                case 104: goto L_0x009f;
                case 118: goto L_0x0095;
                case 119: goto L_0x008b;
                case 3276: goto L_0x0081;
                case 3367: goto L_0x0077;
                case 3553: goto L_0x006d;
                case 94623709: goto L_0x0062;
                case 97615364: goto L_0x0057;
                default: goto L_0x0055;
            }
        L_0x0055:
            goto L_0x00bd
        L_0x0057:
            java.lang.String r9 = "fonts"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0055
            r6 = 8
            goto L_0x00be
        L_0x0062:
            java.lang.String r9 = "chars"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0055
            r6 = 9
            goto L_0x00be
        L_0x006d:
            java.lang.String r9 = "op"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0055
            r6 = 3
            goto L_0x00be
        L_0x0077:
            java.lang.String r9 = "ip"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0055
            r6 = 2
            goto L_0x00be
        L_0x0081:
            java.lang.String r9 = "fr"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0055
            r6 = 4
            goto L_0x00be
        L_0x008b:
            java.lang.String r9 = "w"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0055
            r6 = 0
            goto L_0x00be
        L_0x0095:
            java.lang.String r9 = "v"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0055
            r6 = 5
            goto L_0x00be
        L_0x009f:
            java.lang.String r9 = "h"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0055
            r6 = 1
            goto L_0x00be
        L_0x00a9:
            java.lang.String r9 = "layers"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0055
            r6 = 6
            goto L_0x00be
        L_0x00b3:
            java.lang.String r9 = "assets"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0055
            r6 = 7
            goto L_0x00be
        L_0x00bd:
            r6 = -1
        L_0x00be:
            switch(r6) {
                case 0: goto L_0x012c;
                case 1: goto L_0x0126;
                case 2: goto L_0x011f;
                case 3: goto L_0x0113;
                case 4: goto L_0x010b;
                case 5: goto L_0x00d7;
                case 6: goto L_0x00d3;
                case 7: goto L_0x00cf;
                case 8: goto L_0x00cb;
                case 9: goto L_0x00c6;
                default: goto L_0x00c1;
            }
        L_0x00c1:
            r26.skipValue()
            goto L_0x0131
        L_0x00c6:
            m10481a(r0, r10, r11)
            goto L_0x0131
        L_0x00cb:
            m10484a(r0, r12)
            goto L_0x0131
        L_0x00cf:
            m10483a(r0, r10, r14, r13)
            goto L_0x0131
        L_0x00d3:
            m10482a(r0, r10, r15, r5)
            goto L_0x0131
        L_0x00d7:
            java.lang.String r6 = r26.nextString()
            java.lang.String r8 = "\\."
            java.lang.String[] r8 = r6.split(r8)
            r7 = r8[r7]
            int r7 = java.lang.Integer.parseInt(r7)
            r9 = r8[r19]
            int r9 = java.lang.Integer.parseInt(r9)
            r16 = r8[r16]
            int r16 = java.lang.Integer.parseInt(r16)
            r23 = 4
            r24 = 4
            r25 = 0
            r20 = r7
            r21 = r9
            r22 = r16
            boolean r19 = com.airbnb.lottie.p095f.C5829f.m10541a(r20, r21, r22, r23, r24, r25)
            if (r19 != 0) goto L_0x0131
            java.lang.String r0 = "Lottie only supports bodymovin >= 4.4.0"
            r10.mo18189a(r0)
            goto L_0x0131
        L_0x010b:
            double r6 = r26.nextDouble()
            float r0 = (float) r6
            r18 = r0
            goto L_0x0131
        L_0x0113:
            double r6 = r26.nextDouble()
            float r0 = (float) r6
            r6 = 1008981770(0x3c23d70a, float:0.01)
            float r0 = r0 - r6
            r17 = r0
            goto L_0x0131
        L_0x011f:
            double r6 = r26.nextDouble()
            float r0 = (float) r6
            r4 = r0
            goto L_0x0131
        L_0x0126:
            int r0 = r26.nextInt()
            r3 = r0
            goto L_0x0131
        L_0x012c:
            int r0 = r26.nextInt()
            r2 = r0
        L_0x0131:
            r0 = r26
            goto L_0x003e
        L_0x0135:
            r26.endObject()
            float r0 = (float) r2
            float r0 = r0 * r1
            int r0 = (int) r0
            float r6 = (float) r3
            float r6 = r6 * r1
            int r9 = (int) r6
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>(r7, r7, r0, r9)
            r7 = r6
            r6 = r10
            r8 = r4
            r19 = r9
            r9 = r17
            r20 = r10
            r10 = r18
            r21 = r11
            r11 = r15
            r22 = r12
            r12 = r5
            r23 = r13
            r13 = r14
            r24 = r14
            r14 = r23
            r25 = r15
            r15 = r21
            r16 = r22
            r6.mo18188a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p094e.C5817u.m10480a(android.util.JsonReader):com.airbnb.lottie.g");
    }

    /* renamed from: a */
    private static void m10482a(JsonReader reader, C5830g composition, List<C5766g> layers, C1259h<C5766g> layerMap) throws IOException {
        int imageCount = 0;
        reader.beginArray();
        while (reader.hasNext()) {
            C5766g layer = C5816t.m10478a(reader, composition);
            if (layer.mo18096d() == C5767a.Image) {
                imageCount++;
            }
            layers.add(layer);
            layerMap.mo9063c(layer.mo18094b(), layer);
            if (imageCount > 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("You have ");
                sb.append(imageCount);
                sb.append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                C5718c.m10179d(sb.toString());
            }
        }
        reader.endArray();
    }

    /* renamed from: a */
    private static void m10483a(JsonReader reader, C5830g composition, Map<String, List<C5766g>> precomps, Map<String, C5853y> images) throws IOException {
        reader.beginArray();
        while (reader.hasNext()) {
            String id = null;
            List<Layer> layers = new ArrayList<>();
            LongSparseArray<Layer> layerMap = new C1259h<>();
            int width = 0;
            int height = 0;
            String imageFileName = null;
            String relativeFolder = null;
            reader.beginObject();
            while (reader.hasNext()) {
                String nextName = reader.nextName();
                char c = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != -1109732030) {
                    if (hashCode != 104) {
                        if (hashCode != 112) {
                            if (hashCode != 117) {
                                if (hashCode != 119) {
                                    if (hashCode == 3355 && nextName.equals("id")) {
                                        c = 0;
                                    }
                                } else if (nextName.equals("w")) {
                                    c = 2;
                                }
                            } else if (nextName.equals("u")) {
                                c = 5;
                            }
                        } else if (nextName.equals("p")) {
                            c = 4;
                        }
                    } else if (nextName.equals("h")) {
                        c = 3;
                    }
                } else if (nextName.equals("layers")) {
                    c = 1;
                }
                if (c == 0) {
                    id = reader.nextString();
                } else if (c == 1) {
                    reader.beginArray();
                    while (reader.hasNext()) {
                        C5766g layer = C5816t.m10478a(reader, composition);
                        layerMap.mo9063c(layer.mo18094b(), layer);
                        layers.add(layer);
                    }
                    reader.endArray();
                } else if (c == 2) {
                    width = reader.nextInt();
                } else if (c == 3) {
                    height = reader.nextInt();
                } else if (c == 4) {
                    imageFileName = reader.nextString();
                } else if (c != 5) {
                    reader.skipValue();
                } else {
                    relativeFolder = reader.nextString();
                }
            }
            reader.endObject();
            if (imageFileName != null) {
                C5853y image = new C5853y(width, height, id, imageFileName, relativeFolder);
                images.put(image.mo18281c(), image);
                Map<String, List<C5766g>> map = precomps;
            } else {
                Map<String, C5853y> map2 = images;
                precomps.put(id, layers);
            }
        }
        Map<String, List<C5766g>> map3 = precomps;
        Map<String, C5853y> map4 = images;
        reader.endArray();
    }

    /* renamed from: a */
    private static void m10484a(JsonReader reader, Map<String, C5759c> fonts) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 3322014 && nextName.equals(Repo.COLUMN_VIEW)) {
                c = 0;
            }
            if (c != 0) {
                reader.skipValue();
            } else {
                reader.beginArray();
                while (reader.hasNext()) {
                    C5759c font = C5807k.m10454a(reader);
                    fonts.put(font.mo18081b(), font);
                }
                reader.endArray();
            }
        }
        reader.endObject();
    }

    /* renamed from: a */
    private static void m10481a(JsonReader reader, C5830g composition, C1274r<C5775d> characters) throws IOException {
        reader.beginArray();
        while (reader.hasNext()) {
            C5775d character = C5806j.m10453a(reader, composition);
            characters.mo9178c(character.hashCode(), character);
        }
        reader.endArray();
    }
}

package com.airbnb.lottie.p089c.p092c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.C5673K;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.p085a.p086a.C5679d;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p085a.p087b.C5712n;
import com.airbnb.lottie.p089c.C5734b;
import com.airbnb.lottie.p089c.C5759c;
import com.airbnb.lottie.p089c.C5775d;
import com.airbnb.lottie.p089c.p090a.C5720a;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5730k;
import com.airbnb.lottie.p089c.p091b.C5751n;
import com.airbnb.lottie.p095f.C5829f;
import com.airbnb.lottie.p096g.C5833c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.airbnb.lottie.c.c.m */
/* compiled from: TextLayer */
public class C5774m extends C5762c {

    /* renamed from: A */
    private final Paint f10043A = new C5773l(this, 1);

    /* renamed from: B */
    private final Map<C5775d, List<C5679d>> f10044B = new HashMap();

    /* renamed from: C */
    private final C5712n f10045C;

    /* renamed from: D */
    private final C5851x f10046D;

    /* renamed from: E */
    private final C5830g f10047E;

    /* renamed from: F */
    private C5698a<Integer, Integer> f10048F;

    /* renamed from: G */
    private C5698a<Integer, Integer> f10049G;

    /* renamed from: H */
    private C5698a<Float, Float> f10050H;

    /* renamed from: I */
    private C5698a<Float, Float> f10051I;

    /* renamed from: w */
    private final char[] f10052w = new char[1];

    /* renamed from: x */
    private final RectF f10053x = new RectF();

    /* renamed from: y */
    private final Matrix f10054y = new Matrix();

    /* renamed from: z */
    private final Paint f10055z = new C5772k(this, 1);

    C5774m(C5851x lottieDrawable, C5766g layerModel) {
        super(lottieDrawable, layerModel);
        this.f10046D = lottieDrawable;
        this.f10047E = layerModel.mo18092a();
        this.f10045C = layerModel.mo18109q().mo17984a();
        this.f10045C.mo17951a((C5699a) this);
        mo18084a((C5698a<?, ?>) this.f10045C);
        C5730k textProperties = layerModel.mo18110r();
        if (textProperties != null) {
            C5720a aVar = textProperties.f9832a;
            if (aVar != null) {
                this.f10048F = aVar.mo17984a();
                this.f10048F.mo17951a((C5699a) this);
                mo18084a(this.f10048F);
            }
        }
        if (textProperties != null) {
            C5720a aVar2 = textProperties.f9833b;
            if (aVar2 != null) {
                this.f10049G = aVar2.mo17984a();
                this.f10049G.mo17951a((C5699a) this);
                mo18084a(this.f10049G);
            }
        }
        if (textProperties != null) {
            C5721b bVar = textProperties.f9834c;
            if (bVar != null) {
                this.f10050H = bVar.mo17984a();
                this.f10050H.mo17951a((C5699a) this);
                mo18084a(this.f10050H);
            }
        }
        if (textProperties != null) {
            C5721b bVar2 = textProperties.f9835d;
            if (bVar2 != null) {
                this.f10051I = bVar2.mo17984a();
                this.f10051I.mo17951a((C5699a) this);
                mo18084a(this.f10051I);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo18087b(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        canvas.save();
        if (!this.f10046D.mo18276t()) {
            canvas.setMatrix(parentMatrix);
        }
        C5734b documentData = (C5734b) this.f10045C.mo17955d();
        C5759c font = (C5759c) this.f10047E.mo18196f().get(documentData.f9845b);
        if (font == null) {
            canvas.restore();
            return;
        }
        C5698a<Integer, Integer> aVar = this.f10048F;
        if (aVar != null) {
            this.f10055z.setColor(((Integer) aVar.mo17955d()).intValue());
        } else {
            this.f10055z.setColor(documentData.f9851h);
        }
        C5698a<Integer, Integer> aVar2 = this.f10049G;
        if (aVar2 != null) {
            this.f10043A.setColor(((Integer) aVar2.mo17955d()).intValue());
        } else {
            this.f10043A.setColor(documentData.f9852i);
        }
        int alpha = (((Integer) this.f9989u.mo17969c().mo17955d()).intValue() * 255) / 100;
        this.f10055z.setAlpha(alpha);
        this.f10043A.setAlpha(alpha);
        C5698a<Float, Float> aVar3 = this.f10050H;
        if (aVar3 != null) {
            this.f10043A.setStrokeWidth(((Float) aVar3.mo17955d()).floatValue());
        } else {
            float parentScale = C5829f.m10535a(parentMatrix);
            Paint paint = this.f10043A;
            double d = documentData.f9853j;
            double a = (double) C5829f.m10534a();
            Double.isNaN(a);
            double d2 = d * a;
            double d3 = (double) parentScale;
            Double.isNaN(d3);
            paint.setStrokeWidth((float) (d2 * d3));
        }
        if (this.f10046D.mo18276t()) {
            m10375a(documentData, parentMatrix, font, canvas);
        } else {
            m10376a(documentData, font, parentMatrix, canvas);
        }
        canvas.restore();
    }

    /* renamed from: a */
    private void m10375a(C5734b documentData, Matrix parentMatrix, C5759c font, Canvas canvas) {
        C5734b bVar = documentData;
        float fontScale = ((float) bVar.f9846c) / 100.0f;
        float parentScale = C5829f.m10535a(parentMatrix);
        String text = bVar.f9844a;
        for (int i = 0; i < text.length(); i++) {
            C5775d character = (C5775d) this.f10047E.mo18191b().mo9175b(C5775d.m10381a(text.charAt(i), font.mo18080a(), font.mo18082c()));
            if (character == null) {
                Canvas canvas2 = canvas;
            } else {
                m10377a(character, parentMatrix, fontScale, documentData, canvas);
                float tx = ((float) character.mo18116b()) * fontScale * C5829f.m10534a() * parentScale;
                float tracking = ((float) bVar.f9848e) / 10.0f;
                C5698a<Float, Float> aVar = this.f10051I;
                if (aVar != null) {
                    tracking += ((Float) aVar.mo17955d()).floatValue();
                }
                canvas.translate(tx + (tracking * parentScale), 0.0f);
            }
        }
        Canvas canvas3 = canvas;
    }

    /* renamed from: a */
    private void m10376a(C5734b documentData, C5759c font, Matrix parentMatrix, Canvas canvas) {
        float parentScale = C5829f.m10535a(parentMatrix);
        Typeface typeface = this.f10046D.mo18224a(font.mo18080a(), font.mo18082c());
        if (typeface != null) {
            String text = documentData.f9844a;
            C5673K textDelegate = this.f10046D.mo18267p();
            if (textDelegate == null) {
                this.f10055z.setTypeface(typeface);
                Paint paint = this.f10055z;
                double d = documentData.f9846c;
                double a = (double) C5829f.m10534a();
                Double.isNaN(a);
                paint.setTextSize((float) (d * a));
                this.f10043A.setTypeface(this.f10055z.getTypeface());
                this.f10043A.setTextSize(this.f10055z.getTextSize());
                for (int i = 0; i < text.length(); i++) {
                    char character = text.charAt(i);
                    m10373a(character, documentData, canvas);
                    char[] cArr = this.f10052w;
                    cArr[0] = character;
                    float charWidth = this.f10055z.measureText(cArr, 0, 1);
                    float tracking = ((float) documentData.f9848e) / 10.0f;
                    C5698a<Float, Float> aVar = this.f10051I;
                    if (aVar != null) {
                        tracking += ((Float) aVar.mo17955d()).floatValue();
                    }
                    canvas.translate((tracking * parentScale) + charWidth, 0.0f);
                }
                return;
            }
            textDelegate.mo17881a(text);
            throw null;
        }
    }

    /* renamed from: a */
    private void m10377a(C5775d character, Matrix parentMatrix, float fontScale, C5734b documentData, Canvas canvas) {
        List<ContentGroup> contentGroups = m10372a(character);
        for (int j = 0; j < contentGroups.size(); j++) {
            Path path = ((C5679d) contentGroups.get(j)).getPath();
            path.computeBounds(this.f10053x, false);
            this.f10054y.set(parentMatrix);
            this.f10054y.preTranslate(0.0f, ((float) (-documentData.f9850g)) * C5829f.m10534a());
            this.f10054y.preScale(fontScale, fontScale);
            path.transform(this.f10054y);
            if (documentData.f9854k) {
                m10374a(path, this.f10055z, canvas);
                m10374a(path, this.f10043A, canvas);
            } else {
                m10374a(path, this.f10043A, canvas);
                m10374a(path, this.f10055z, canvas);
            }
        }
    }

    /* renamed from: a */
    private void m10374a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    /* renamed from: a */
    private void m10373a(char c, C5734b documentData, Canvas canvas) {
        char[] cArr = this.f10052w;
        cArr[0] = c;
        if (documentData.f9854k) {
            m10378a(cArr, this.f10055z, canvas);
            m10378a(this.f10052w, this.f10043A, canvas);
            return;
        }
        m10378a(cArr, this.f10043A, canvas);
        m10378a(this.f10052w, this.f10055z, canvas);
    }

    /* renamed from: a */
    private void m10378a(char[] character, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(character, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    /* renamed from: a */
    private List<C5679d> m10372a(C5775d character) {
        if (this.f10044B.containsKey(character)) {
            return (List) this.f10044B.get(character);
        }
        List<ShapeGroup> shapes = character.mo18115a();
        int size = shapes.size();
        List<ContentGroup> contents = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            contents.add(new C5679d(this.f10046D, this, (C5751n) shapes.get(i)));
        }
        this.f10044B.put(character, contents);
        return contents;
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        super.mo17936a(property, callback);
        if (property == C5663B.f9595a) {
            C5698a<Integer, Integer> aVar = this.f10048F;
            if (aVar != null) {
                aVar.mo17952a(callback);
                return;
            }
        }
        if (property == C5663B.f9596b) {
            C5698a<Integer, Integer> aVar2 = this.f10049G;
            if (aVar2 != null) {
                aVar2.mo17952a(callback);
                return;
            }
        }
        if (property == C5663B.f9605k) {
            C5698a<Float, Float> aVar3 = this.f10050H;
            if (aVar3 != null) {
                aVar3.mo17952a(callback);
                return;
            }
        }
        if (property == C5663B.f9606l) {
            C5698a<Float, Float> aVar4 = this.f10051I;
            if (aVar4 != null) {
                aVar4.mo17952a(callback);
            }
        }
    }
}

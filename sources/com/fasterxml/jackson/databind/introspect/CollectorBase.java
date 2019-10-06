package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

class CollectorBase {
    protected static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
    protected static final AnnotationMap[] NO_ANNOTATION_MAPS = new AnnotationMap[0];
    protected final AnnotationIntrospector _intr;

    protected CollectorBase(AnnotationIntrospector intr) {
        this._intr = intr;
    }

    /* access modifiers changed from: protected */
    public final AnnotationCollector collectAnnotations(Annotation[] anns) {
        AnnotationCollector c = AnnotationCollector.emptyCollector();
        for (Annotation ann : anns) {
            c = c.addOrOverride(ann);
            if (this._intr.isAnnotationBundle(ann)) {
                c = collectFromBundle(c, ann);
            }
        }
        return c;
    }

    /* access modifiers changed from: protected */
    public final AnnotationCollector collectAnnotations(AnnotationCollector c, Annotation[] anns) {
        for (Annotation ann : anns) {
            c = c.addOrOverride(ann);
            if (this._intr.isAnnotationBundle(ann)) {
                c = collectFromBundle(c, ann);
            }
        }
        return c;
    }

    /* access modifiers changed from: protected */
    public final AnnotationCollector collectFromBundle(AnnotationCollector c, Annotation bundle) {
        Annotation[] anns;
        for (Annotation ann : ClassUtil.findClassAnnotations(bundle.annotationType())) {
            if (!_ignorableAnnotation(ann)) {
                if (!this._intr.isAnnotationBundle(ann)) {
                    c = c.addOrOverride(ann);
                } else if (!c.isPresent(ann)) {
                    c = collectFromBundle(c.addOrOverride(ann), ann);
                }
            }
        }
        return c;
    }

    /* access modifiers changed from: protected */
    public final AnnotationCollector collectDefaultAnnotations(AnnotationCollector c, Annotation[] anns) {
        for (Annotation ann : anns) {
            if (!c.isPresent(ann)) {
                c = c.addOrOverride(ann);
                if (this._intr.isAnnotationBundle(ann)) {
                    c = collectDefaultFromBundle(c, ann);
                }
            }
        }
        return c;
    }

    /* access modifiers changed from: protected */
    public final AnnotationCollector collectDefaultFromBundle(AnnotationCollector c, Annotation bundle) {
        Annotation[] anns;
        for (Annotation ann : ClassUtil.findClassAnnotations(bundle.annotationType())) {
            if (!_ignorableAnnotation(ann) && !c.isPresent(ann)) {
                c = c.addOrOverride(ann);
                if (this._intr.isAnnotationBundle(ann)) {
                    c = collectFromBundle(c, ann);
                }
            }
        }
        return c;
    }

    protected static final boolean _ignorableAnnotation(Annotation a) {
        return (a instanceof Target) || (a instanceof Retention);
    }

    static AnnotationMap _emptyAnnotationMap() {
        return new AnnotationMap();
    }

    static AnnotationMap[] _emptyAnnotationMaps(int count) {
        if (count == 0) {
            return NO_ANNOTATION_MAPS;
        }
        AnnotationMap[] maps = new AnnotationMap[count];
        for (int i = 0; i < count; i++) {
            maps[i] = _emptyAnnotationMap();
        }
        return maps;
    }
}

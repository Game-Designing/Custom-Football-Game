package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSetter {

    public static class Value implements JacksonAnnotationValue<JsonSetter>, Serializable {
        protected static final Value EMPTY;
        private final Nulls _contentNulls;
        private final Nulls _nulls;

        static {
            Nulls nulls = Nulls.DEFAULT;
            EMPTY = new Value(nulls, nulls);
        }

        protected Value(Nulls nulls, Nulls contentNulls) {
            this._nulls = nulls;
            this._contentNulls = contentNulls;
        }

        /* access modifiers changed from: protected */
        public Object readResolve() {
            if (_empty(this._nulls, this._contentNulls)) {
                return EMPTY;
            }
            return this;
        }

        public static Value from(JsonSetter src) {
            if (src == null) {
                return EMPTY;
            }
            return construct(src.nulls(), src.contentNulls());
        }

        public static Value construct(Nulls nulls, Nulls contentNulls) {
            if (nulls == null) {
                nulls = Nulls.DEFAULT;
            }
            if (contentNulls == null) {
                contentNulls = Nulls.DEFAULT;
            }
            if (_empty(nulls, contentNulls)) {
                return EMPTY;
            }
            return new Value(nulls, contentNulls);
        }

        public static Value empty() {
            return EMPTY;
        }

        public Nulls nonDefaultValueNulls() {
            Nulls nulls = this._nulls;
            if (nulls == Nulls.DEFAULT) {
                return null;
            }
            return nulls;
        }

        public Nulls nonDefaultContentNulls() {
            Nulls nulls = this._contentNulls;
            if (nulls == Nulls.DEFAULT) {
                return null;
            }
            return nulls;
        }

        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", new Object[]{this._nulls, this._contentNulls});
        }

        public int hashCode() {
            return this._nulls.ordinal() + (this._contentNulls.ordinal() << 2);
        }

        public boolean equals(Object o) {
            boolean z = true;
            if (o == this) {
                return true;
            }
            if (o == null || o.getClass() != getClass()) {
                return false;
            }
            Value other = (Value) o;
            if (!(other._nulls == this._nulls && other._contentNulls == this._contentNulls)) {
                z = false;
            }
            return z;
        }

        private static boolean _empty(Nulls nulls, Nulls contentNulls) {
            Nulls nulls2 = Nulls.DEFAULT;
            return nulls == nulls2 && contentNulls == nulls2;
        }
    }

    Nulls contentNulls() default Nulls.DEFAULT;

    Nulls nulls() default Nulls.DEFAULT;

    String value() default "";
}

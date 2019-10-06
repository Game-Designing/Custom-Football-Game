package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JacksonInject {

    public static class Value implements JacksonAnnotationValue<JacksonInject>, Serializable {
        protected static final Value EMPTY = new Value(null, null);
        protected final Object _id;
        protected final Boolean _useInput;

        protected Value(Object id, Boolean useInput) {
            this._id = id;
            this._useInput = useInput;
        }

        public static Value construct(Object id, Boolean useInput) {
            if ("".equals(id)) {
                id = null;
            }
            if (_empty(id, useInput)) {
                return EMPTY;
            }
            return new Value(id, useInput);
        }

        public static Value from(JacksonInject src) {
            if (src == null) {
                return EMPTY;
            }
            return construct(src.value(), src.useInput().asBoolean());
        }

        public static Value forId(Object id) {
            return construct(id, null);
        }

        public Value withId(Object id) {
            if (id == null) {
                if (this._id == null) {
                    return this;
                }
            } else if (id.equals(this._id)) {
                return this;
            }
            return new Value(id, this._useInput);
        }

        public Object getId() {
            return this._id;
        }

        public boolean hasId() {
            return this._id != null;
        }

        public String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s)", new Object[]{this._id, this._useInput});
        }

        public int hashCode() {
            int h = 1;
            Object obj = this._id;
            if (obj != null) {
                h = 1 + obj.hashCode();
            }
            Boolean bool = this._useInput;
            if (bool != null) {
                return h + bool.hashCode();
            }
            return h;
        }

        public boolean equals(Object o) {
            boolean z = true;
            if (o == this) {
                return true;
            }
            if (o != null && o.getClass() == getClass()) {
                Value other = (Value) o;
                if (OptBoolean.equals(this._useInput, other._useInput)) {
                    Object obj = this._id;
                    if (obj != null) {
                        return obj.equals(other._id);
                    }
                    if (other._id != null) {
                        z = false;
                    }
                    return z;
                }
            }
            return false;
        }

        private static boolean _empty(Object id, Boolean useInput) {
            return id == null && useInput == null;
        }
    }

    OptBoolean useInput() default OptBoolean.DEFAULT;

    String value() default "";
}

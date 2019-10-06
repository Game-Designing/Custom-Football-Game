package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DateTimeSerializerBase<T> extends StdScalarSerializer<T> implements ContextualSerializer {
    protected final DateFormat _customFormat;
    protected final AtomicReference<DateFormat> _reusedCustomFormat;
    protected final Boolean _useTimestamp;

    public abstract DateTimeSerializerBase<T> withFormat(Boolean bool, DateFormat dateFormat);

    protected DateTimeSerializerBase(Class<T> type, Boolean useTimestamp, DateFormat customFormat) {
        super(type);
        this._useTimestamp = useTimestamp;
        this._customFormat = customFormat;
        this._reusedCustomFormat = customFormat == null ? null : new AtomicReference<>();
    }

    public JsonSerializer<?> createContextual(SerializerProvider serializers, BeanProperty property) throws JsonMappingException {
        SimpleDateFormat df;
        if (property == null) {
            return this;
        }
        Value format = findFormatOverrides(serializers, property, handledType());
        if (format == null) {
            return this;
        }
        Shape shape = format.getShape();
        if (shape.isNumeric()) {
            return withFormat(Boolean.TRUE, null);
        }
        if (format.hasPattern()) {
            SimpleDateFormat df2 = new SimpleDateFormat(format.getPattern(), format.hasLocale() ? format.getLocale() : serializers.getLocale());
            df2.setTimeZone(format.hasTimeZone() ? format.getTimeZone() : serializers.getTimeZone());
            return withFormat(Boolean.FALSE, df2);
        }
        boolean hasLocale = format.hasLocale();
        boolean hasTZ = format.hasTimeZone();
        boolean changeTZ = true;
        boolean asString = shape == Shape.STRING;
        if (!hasLocale && !hasTZ && !asString) {
            return this;
        }
        DateFormat df0 = serializers.getConfig().getDateFormat();
        if (df0 instanceof StdDateFormat) {
            StdDateFormat std = (StdDateFormat) df0;
            if (format.hasLocale()) {
                std = std.withLocale(format.getLocale());
            }
            if (format.hasTimeZone()) {
                std = std.withTimeZone(format.getTimeZone());
            }
            return withFormat(Boolean.FALSE, std);
        }
        if (!(df0 instanceof SimpleDateFormat)) {
            serializers.reportBadDefinition(handledType(), String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", new Object[]{df0.getClass().getName()}));
        }
        SimpleDateFormat df3 = (SimpleDateFormat) df0;
        if (hasLocale) {
            df = new SimpleDateFormat(df3.toPattern(), format.getLocale());
        } else {
            df = (SimpleDateFormat) df3.clone();
        }
        TimeZone newTz = format.getTimeZone();
        if (newTz == null || newTz.equals(df.getTimeZone())) {
            changeTZ = false;
        }
        if (changeTZ) {
            df.setTimeZone(newTz);
        }
        return withFormat(Boolean.FALSE, df);
    }

    public boolean isEmpty(SerializerProvider serializers, T t) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean _asTimestamp(SerializerProvider serializers) {
        Boolean bool = this._useTimestamp;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this._customFormat != null) {
            return false;
        }
        if (serializers != null) {
            return serializers.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Null SerializerProvider passed for ");
        sb.append(handledType().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void _serializeAsString(Date value, JsonGenerator g, SerializerProvider provider) throws IOException {
        if (this._customFormat == null) {
            provider.defaultSerializeDateValue(value, g);
            return;
        }
        DateFormat f = (DateFormat) this._reusedCustomFormat.getAndSet(null);
        if (f == null) {
            f = (DateFormat) this._customFormat.clone();
        }
        g.writeString(f.format(value));
        this._reusedCustomFormat.compareAndSet(null, f);
    }
}

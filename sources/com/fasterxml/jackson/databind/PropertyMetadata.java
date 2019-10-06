package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.Serializable;

public class PropertyMetadata implements Serializable {
    public static final PropertyMetadata STD_OPTIONAL;
    public static final PropertyMetadata STD_REQUIRED;
    public static final PropertyMetadata STD_REQUIRED_OR_OPTIONAL;
    protected Nulls _contentNulls;
    protected final String _defaultValue;
    protected final String _description;
    protected final Integer _index;
    protected final transient MergeInfo _mergeInfo;
    protected final Boolean _required;
    protected Nulls _valueNulls;

    public static final class MergeInfo {
        public final boolean fromDefaults;
        public final AnnotatedMember getter;

        protected MergeInfo(AnnotatedMember getter2, boolean fromDefaults2) {
            this.getter = getter2;
            this.fromDefaults = fromDefaults2;
        }

        public static MergeInfo createForDefaults(AnnotatedMember getter2) {
            return new MergeInfo(getter2, true);
        }

        public static MergeInfo createForTypeOverride(AnnotatedMember getter2) {
            return new MergeInfo(getter2, false);
        }

        public static MergeInfo createForPropertyOverride(AnnotatedMember getter2) {
            return new MergeInfo(getter2, false);
        }
    }

    static {
        PropertyMetadata propertyMetadata = new PropertyMetadata(Boolean.TRUE, null, null, null, null, null, null);
        STD_REQUIRED = propertyMetadata;
        PropertyMetadata propertyMetadata2 = new PropertyMetadata(Boolean.FALSE, null, null, null, null, null, null);
        STD_OPTIONAL = propertyMetadata2;
        PropertyMetadata propertyMetadata3 = new PropertyMetadata(null, null, null, null, null, null, null);
        STD_REQUIRED_OR_OPTIONAL = propertyMetadata3;
    }

    protected PropertyMetadata(Boolean req, String desc, Integer index, String def, MergeInfo mergeInfo, Nulls valueNulls, Nulls contentNulls) {
        this._required = req;
        this._description = desc;
        this._index = index;
        this._defaultValue = (def == null || def.isEmpty()) ? null : def;
        this._mergeInfo = mergeInfo;
        this._valueNulls = valueNulls;
        this._contentNulls = contentNulls;
    }

    public static PropertyMetadata construct(Boolean req, String desc, Integer index, String defaultValue) {
        if (desc != null || index != null || defaultValue != null) {
            PropertyMetadata propertyMetadata = new PropertyMetadata(req, desc, index, defaultValue, null, null, null);
            return propertyMetadata;
        } else if (req == null) {
            return STD_REQUIRED_OR_OPTIONAL;
        } else {
            return req.booleanValue() ? STD_REQUIRED : STD_OPTIONAL;
        }
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        if (this._description != null || this._index != null || this._defaultValue != null || this._mergeInfo != null || this._valueNulls != null || this._contentNulls != null) {
            return this;
        }
        Boolean bool = this._required;
        if (bool == null) {
            return STD_REQUIRED_OR_OPTIONAL;
        }
        return bool.booleanValue() ? STD_REQUIRED : STD_OPTIONAL;
    }

    public PropertyMetadata withDescription(String desc) {
        PropertyMetadata propertyMetadata = new PropertyMetadata(this._required, desc, this._index, this._defaultValue, this._mergeInfo, this._valueNulls, this._contentNulls);
        return propertyMetadata;
    }

    public PropertyMetadata withMergeInfo(MergeInfo mergeInfo) {
        PropertyMetadata propertyMetadata = new PropertyMetadata(this._required, this._description, this._index, this._defaultValue, mergeInfo, this._valueNulls, this._contentNulls);
        return propertyMetadata;
    }

    public PropertyMetadata withNulls(Nulls valueNulls, Nulls contentNulls) {
        PropertyMetadata propertyMetadata = new PropertyMetadata(this._required, this._description, this._index, this._defaultValue, this._mergeInfo, valueNulls, contentNulls);
        return propertyMetadata;
    }

    public boolean isRequired() {
        Boolean bool = this._required;
        return bool != null && bool.booleanValue();
    }

    public MergeInfo getMergeInfo() {
        return this._mergeInfo;
    }

    public Nulls getValueNulls() {
        return this._valueNulls;
    }

    public Nulls getContentNulls() {
        return this._contentNulls;
    }
}

package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import java.io.Serializable;
import java.util.Map;

public class ConfigOverrides implements Serializable {
    protected Value _defaultInclusion;
    protected Boolean _defaultMergeable;
    protected JsonSetter.Value _defaultSetterInfo;
    protected Map<Class<?>, Object> _overrides;
    protected VisibilityChecker<?> _visibilityChecker;

    public ConfigOverrides() {
        this(null, Value.empty(), JsonSetter.Value.empty(), Std.defaultInstance(), null);
    }

    protected ConfigOverrides(Map<Class<?>, Object> overrides, Value defIncl, JsonSetter.Value defSetter, VisibilityChecker<?> defVisibility, Boolean defMergeable) {
        this._overrides = overrides;
        this._defaultInclusion = defIncl;
        this._defaultSetterInfo = defSetter;
        this._visibilityChecker = defVisibility;
        this._defaultMergeable = defMergeable;
    }

    public ConfigOverride findOverride(Class<?> type) {
        Map<Class<?>, Object> map = this._overrides;
        if (map == null) {
            return null;
        }
        return (ConfigOverride) map.get(type);
    }

    public Value getDefaultInclusion() {
        return this._defaultInclusion;
    }

    public JsonSetter.Value getDefaultSetterInfo() {
        return this._defaultSetterInfo;
    }

    public Boolean getDefaultMergeable() {
        return this._defaultMergeable;
    }

    public VisibilityChecker<?> getDefaultVisibility() {
        return this._visibilityChecker;
    }

    public void setDefaultInclusion(Value v) {
        this._defaultInclusion = v;
    }
}

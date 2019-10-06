package com.unity3d.services.ads.adunit;

public class AdUnitMotionEvent {
    private int _action;
    private int _deviceId;
    private long _eventTime;
    private boolean _isObscured;
    private float _pressure;
    private float _size;
    private int _source;
    private int _toolType;

    /* renamed from: _x */
    private float f39020_x;

    /* renamed from: _y */
    private float f39021_y;

    public AdUnitMotionEvent(int action, boolean isObscured, int toolType, int source, int deviceId, float x, float y, long eventTime, float pressure, float size) {
        this._action = action;
        this._isObscured = isObscured;
        this._toolType = toolType;
        this._source = source;
        this._deviceId = deviceId;
        this.f39020_x = x;
        this.f39021_y = y;
        this._eventTime = eventTime;
        this._pressure = pressure;
        this._size = size;
    }

    public int getAction() {
        return this._action;
    }

    public boolean isObscured() {
        return this._isObscured;
    }

    public int getToolType() {
        return this._toolType;
    }

    public int getSource() {
        return this._source;
    }

    public int getDeviceId() {
        return this._deviceId;
    }

    public float getX() {
        return this.f39020_x;
    }

    public float getY() {
        return this.f39021_y;
    }

    public long getEventTime() {
        return this._eventTime;
    }

    public float getPressure() {
        return this._pressure;
    }

    public float getSize() {
        return this._size;
    }
}

package com.facebook;

public class FacebookOperationCanceledException extends FacebookException {
    public FacebookOperationCanceledException() {
    }

    public FacebookOperationCanceledException(String message) {
        super(message);
    }
}

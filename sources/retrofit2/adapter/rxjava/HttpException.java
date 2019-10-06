package retrofit2.adapter.rxjava;

import retrofit2.Response;

public final class HttpException extends Exception {
    private final int code;
    private final String message;
    private final transient Response<?> response;

    public HttpException(Response<?> response2) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP ");
        sb.append(response2.code());
        sb.append(" ");
        sb.append(response2.message());
        super(sb.toString());
        this.code = response2.code();
        this.message = response2.message();
        this.response = response2;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public Response<?> response() {
        return this.response;
    }
}

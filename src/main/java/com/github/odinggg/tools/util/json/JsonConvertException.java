package com.github.odinggg.tools.util.json;

/**
 * 描述:
 *
 * @outhor Hansen
 * @create 2018-08-29 17:55
 */
public class JsonConvertException extends RuntimeException {
    private static final long serialVersionUID = 7324617045427246667L;

    public JsonConvertException() {
    }

    public JsonConvertException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonConvertException(String message) {
        super(message);
    }

    public JsonConvertException(Throwable cause) {
        super(cause);
    }
}

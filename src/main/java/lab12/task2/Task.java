package lab12.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Task<T> {
    private String id;
    private Map<String, String> headers;
    private boolean isFrozen = false;

    public abstract void apply(T arg);

    public void freeze() {
        if (!isFrozen) {
            id = UUID.randomUUID().toString();
            isFrozen = true;
        }
    }

    public String getId() {
        return id;
    }

    protected void setHeader(String header, String headerValue) {
        checkIfFrozen();
        if (headers == null) {
            headers = new HashMap<>();
        }
        headers.put(header, headerValue);
    }

    public String getHeader(String header) {
        if (headers != null) {
            return headers.get(header);
        } else {
            return null;
        }
    }    

    public boolean hasHeader(String header) {
        return headers != null && headers.containsKey(header);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    protected void checkIfFrozen() {
        if (isFrozen) {
            throw new IllegalStateException("Task is already frozen and cannot be modified.");
        }
    }
}

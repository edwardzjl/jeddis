package org.zjl.jeddit.forum.domain.model.valueobjects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * We are using both postg and mongo in the same project,
 * where postg use {@code Long} for id, and mongo use {@code String}.
 */
@Deprecated
@Value
@AllArgsConstructor(staticName = "of")
public class PostId {

    Object value;

    @JsonIgnore
    public Long getLongId() {
        if (value == null) {
            return null;
        }
        if (value instanceof Integer) { // it might be integer, as it is parsed by jackson
            return ((Integer) value).longValue();
        }
        return (Long) value;
    }

    @JsonValue
    public String getStringId() {
        if (value == null) {
            return null;
        }
        return value.toString();
    }
}
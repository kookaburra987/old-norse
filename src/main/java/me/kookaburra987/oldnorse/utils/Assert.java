package me.kookaburra987.oldnorse.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.length;

public final class Assert {
    private Assert() {
    }

    public static void notBlank(String value, String message){
        if (isBlank(value)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void size(String value, int min, int max, String message){
        int length = length(value);
        if (length < min || length > max){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object value, String message) {
        if (value == null){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isFalse(boolean condition, String message){
        if (condition){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if(isEmpty(collection)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Object[] objects, String message) {
        if(isEmpty(objects)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(String string, String message) {
        if (StringUtils.isEmpty(string)){
            throw new IllegalArgumentException(message);
        }
    }
}

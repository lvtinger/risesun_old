package org.risesun.common.utils;

public class StringUtils {
    public static boolean isEmpty(String string) {
        return null == string || string.length() == 0;
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isBlank(String string) {
        if (null == string || string.length() == 0) {
            return true;
        }

        return string.trim().length() == 0;
    }
}

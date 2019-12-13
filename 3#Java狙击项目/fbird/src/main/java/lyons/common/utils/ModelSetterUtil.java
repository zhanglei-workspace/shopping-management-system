package lyons.common.utils;

public class ModelSetterUtil {
    public static String setFieldWithNotNullValue(String value) {
        return value == null ? "" : value.trim();
    }
}

package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
public class Validator {

    private Map<String, String> notValideFields;

    public static List<String> validate(Object obj) {
        //List<String> fieldsList = new ArrayList<>();
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        List<String> fieldsList = new ArrayList<>();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(obj);

                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    //System.out.println("field.isAnnotationPresent(NotNull.class)" + field.isAnnotationPresent(NotNull.class));
                    //System.out.println(field.getName());
                    fieldsList.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fieldsList;
    }




//Map, в котором ключ — это имя поля, не прошедшего валидацию,
// а значение — список List строк, содержащих сообщение об ошибке
    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> errors = new HashMap<>();
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            List<String> fieldErrors = new ArrayList<>();
            field.setAccessible(true); // Даем доступ к приватным полям

            try {
                Object value = field.get(obj);

                // Проверка @NotNull
                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    fieldErrors.add("can not be null");
                }

                // Проверка @MinLength
                if (field.isAnnotationPresent(MinLength.class) && value instanceof String str) {
                    int minLength = field.getAnnotation(MinLength.class).minLength();
                    if (str.length() < minLength) {
                        fieldErrors.add("length less than " + minLength);
                    }
                }

                // Если есть ошибки, добавляем их в результирующий список
                if (!fieldErrors.isEmpty()) {
                    errors.put(field.getName(), fieldErrors);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return errors;
    }
}
// END

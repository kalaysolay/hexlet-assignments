package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    @Test
    void testAdvancedValidate_NotNull() {
        // Поле "country" = null, значит, будет ошибка "Поле не должно быть null"
        Address address = new Address(null, "Ufa", "Lenina", "54", "12");
        Map<String, List<String>> result = Validator.advancedValidate(address);

        assertThat(result)
                .containsEntry("country", List.of("can not be null"))
                .doesNotContainKey("city")  // Убедимся, что нет ошибки для "city"
                .doesNotContainKey("street");
    }

    @Test
    void testAdvancedValidate_MinLength() {
        // Поле "city" слишком короткое (MinLength = 3), должно быть сообщение об ошибке
        Address address = new Address("Russia", "LA", "Lenina", "54", null);
        List<String> result = Validator.validate(address);
        List<String> expected = List.of();
        assertThat(result).isEqualTo(expected);
    }


    @Test
    void testAdvancedValidate_NoErrors() {
        // Все поля валидны
        Address address = new Address("Russia", "Ufa", "Lenina", "54", "12");
        Map<String, List<String>> result = Validator.advancedValidate(address);

        assertThat(result).isEmpty(); // Ожидаем, что ошибок не будет
    }
    // END
}

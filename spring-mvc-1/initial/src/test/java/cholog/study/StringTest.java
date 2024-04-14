package cholog.study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    // 요구사항 1-1
    @Test
    void responsetwosplit() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).contains("1", "2");
    }

    // 요구사항 1-2
    @Test
    void responseonesplit() {
        String input = "1";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    // 요구사항 2
    @Test
    void rmparentheses() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");

    }

    // 요구사항 3-1
    @Test
    void getcharat() {
        String input = "abc";
        char result = input.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    // 요구사항 3-2
    @Test
    void outofboundsgetcharat() {
        String input = "abc";
        assertThatThrownBy(() -> {
            char result = input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
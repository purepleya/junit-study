import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("This is Display Name Demo!!")
public class DisplayNameDemo {

    @Test
    @DisplayName("공백을 포함한 Display Name")
    void testWithDisplayNameContainingSpaces() {
    }

    @Test
    @DisplayName("특수 문자 >> ╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("이모지 >> 😱")
    void testWithDisplayNameContainingEmoji() {
    }
}

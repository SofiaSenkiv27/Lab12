import org.junit.jupiter.api.Test;
import lab12.task1.*;
import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    private static final int VALID_AMOUNT = 1500; 
    private static final int INVALID_AMOUNT = 125; 
    private static final int DENOMINATION_500 = 500;
    private static final int DENOMINATION_200 = 200;
    private static final int DENOMINATION_100 = 100;

    @Test
    void testValidAmountDispensed() {
        ATM atm = new ATM();

        assertDoesNotThrow(() -> atm.getMeMoney(VALID_AMOUNT));
    }

    @Test
    void testInvalidAmountThrowsException() {
        ATM atm = new ATM();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> atm.getMeMoney(INVALID_AMOUNT));
        assertEquals("Invalid exception", exception.getMessage());
    }

    @Test
    void testDenomination500() {
        Section section = new Section_500();
        section.setNext(new Section_200());
        section.setNext(new Section_100());

        int amount = DENOMINATION_500 * 3; 
        assertDoesNotThrow(() -> section.process(amount));
    }

    @Test
    void testDenomination200() {
        Section section = new Section_200();
        section.setNext(new Section_100());

        int amount = DENOMINATION_200 * 2; 
        assertDoesNotThrow(() -> section.process(amount));
    }

    @Test
    void testDenomination100() {
        Section section = new Section_100();

        int amount = DENOMINATION_100 * 4; 
        assertDoesNotThrow(() -> section.process(amount));
    }
}

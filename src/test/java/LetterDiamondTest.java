import de.do_webdev.letterdiamond.LetterDiamond;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LetterDiamondTest {

    LetterDiamond letterDiamond;

    @Test
    public void LetterDiamond_Init_a_Expect_UPPERCASE_A() {
        letterDiamond = new LetterDiamond('a');
        assertEquals('A', letterDiamond.getLetter());
    }

    @Test
    public void LetterDiamond_Init_0_Expect_Exception() {
        assertThrows(IllegalArgumentException.class, () -> new LetterDiamond('0'), "IllegalArgumentException was expected");
    }

    @Test
    public void LetterDiamond_Init_A_Expect_A() {
        letterDiamond = new LetterDiamond('A');
        assertEquals("A", letterDiamond.toString());
    }

    @Test
    public void LetterDiamond_Init_B_Expect_Diamond() {
        letterDiamond = new LetterDiamond('B');
        assertEquals(" A\nB B\n A", letterDiamond.toString());
    }

    @Test
    public void LetterDiamond_Init_D_Expect_Diamond() {
        letterDiamond = new LetterDiamond('D');
        assertEquals("   A\n  B B\n C   C\nD     D\n C   C\n  B B\n   A", letterDiamond.toString());
    }

    @Test
    public void LetterDiamond_Init_F_Expect_Diamond() {
        letterDiamond = new LetterDiamond('F');
        assertEquals("     A\n    B B\n   C   C\n  D     D\n E       E\nF         F\n E       E\n  D     D\n   C   C\n    B B\n     A", letterDiamond.toString());
    }

    @Test
    public void LetterDiamond_calcInnerSpace_B_equals_1Space() {
        letterDiamond = new LetterDiamond('B');
        assertEquals(" ", letterDiamond.calcInnerSpace('B'));
    }

    @Test
    public void LetterDiamond_calcInnerSpace_C_equals_3Space() {
        letterDiamond = new LetterDiamond('C');
        assertEquals("   ", letterDiamond.calcInnerSpace('C'));
    }
    
    @Test
    public void LetterDiamond_calcInnerSpace_Z_equals_49Space() {
        letterDiamond = new LetterDiamond('Z');
        assertEquals(49, letterDiamond.calcInnerSpace('Z').length());
    }

    @Test
    public void LetterDiamond_calcOuterSpace_A_of_D_Diamond_equals_3Space() {
        letterDiamond = new LetterDiamond('D');
        assertEquals("   ", letterDiamond.calcOuterSpace('A'));
    }

    @Test
    public void LetterDiamond_calcOuterSpace_D_of_D_Diamond_equals_3Space() {
        letterDiamond = new LetterDiamond('D');
        assertEquals("", letterDiamond.calcOuterSpace('D'));
    }
}

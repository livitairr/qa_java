package example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final boolean MALE_HAS_MANE = true;
    private static final boolean FEMALE_HAS_MANE = false;

    private Lion lion;
    private Feline feline;
    private String sex;
    private boolean hasMane;

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion(feline, sex); // Moved this inside setUp to avoid repetition
    }

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {MALE, MALE_HAS_MANE},
                {FEMALE, FEMALE_HAS_MANE}
        };
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(hasMane, lion.doesHaveMane());
    }
}
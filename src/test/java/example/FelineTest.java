package example;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private static final String EXPECTED_FAMILY = "Кошачьи";
    private static final int EXPECTED_KITTENS_COUNT = 1;

    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        assertEquals(EXPECTED_FAMILY, feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals(EXPECTED_KITTENS_COUNT, feline.getKittens());
    }

    @Test
    public void testGetKittensWithCustomCount() {
        int kittensCount = 5;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
//test
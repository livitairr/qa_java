package example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final String MALE = "Самец";
    private static final String UNSUPPORTED_SEX = "unsupported sex";
    private static final String TEXT_EXCEPTION = "Используйте допустимые значения пола животного - самей или самка";
    private static final List<String> EXPECTED_FOOD = List.of("Пища");

    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion(feline, MALE);
    }

    @Test
    public void testGetKittens() {
        int expectedKittens = 5;
        when(feline.getKittens()).thenReturn(expectedKittens);

        assertThat(lion.getKittens()).isEqualTo(expectedKittens);
        verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveManeException() {
        Throwable throwable = catchThrowable(() -> new Lion(feline, UNSUPPORTED_SEX));

        assertThat(throwable).isInstanceOf(Exception.class)
                .hasMessage(TEXT_EXCEPTION);
    }

    @Test
    public void testGetFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(EXPECTED_FOOD);

        assertThat(lion.getFood()).isEqualTo(EXPECTED_FOOD);
        verify(feline).getFood("Хищник");
    }
}

//test two
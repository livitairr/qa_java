package example;

import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParameterized {
    private Animal animal;
    private final String animalKind;
    private final List<String> expectedFoods;

    public AnimalParameterized(String animalKind, List<String> expectedFoods) {
        this.animalKind = animalKind;
        this.expectedFoods = expectedFoods;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actualFoods = animal.getFood(animalKind);
        assertEquals("Список еды для животных не совпадает с ожидаемым", expectedFoods, actualFoods);
    }
}

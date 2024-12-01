import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Mock
    Feline felineMock;

    @Before
    public void initCat() {
        this.cat = new Cat(felineMock);
    }

    @Test
    public void getSoundReturnsCorrectValueTest() {
        String actualResult = cat.getSound();
        Assert.assertEquals("Мяу", actualResult);
    }

    @Test
    public void getFoodTestReturnsCorrectValueTest() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedResult);
        List<String> actualResult = cat.getFood();
        Assert.assertEquals(expectedResult, actualResult);
    }


}

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline felineSpy;

    @Test
    public void getFamilyReturnsCorrectValueTest() {
        String actualValue = felineSpy.getFamily();
        Assert.assertEquals("Кошачьи", actualValue);
    }

    @Test
    public void getKittensWithoutParameterTest() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithParametersTest() {
        Assert.assertEquals(3, felineSpy.getKittens(3));
    }

    @Test
    public void eatMeatReturnsCorrectValue() throws Exception {
        felineSpy.eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
    }


}

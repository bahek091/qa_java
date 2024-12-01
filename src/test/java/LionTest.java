import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Spy
    Feline feline;

    @Test(expected = Exception.class)
    public void LionWithWrongSexShouldThrowsExceptionTest() throws Exception {
            Lion lion = new Lion("Неверный пол", feline);
    }

    @Test
    public void getKittensIsInvokedTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodCheckInvokationTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

}

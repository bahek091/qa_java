import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private boolean expectedResult;
    private String sex;

    @Mock
    private Feline feline;

    public LionParametrizedTest(boolean expectedResult, String sex){
        this.expectedResult = expectedResult;
        this.sex = sex;
    }

    @Parameterized.Parameters(name = "expectedResult = {0}, sex = {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {true, "Самец"},
                {false, "Самка"},
        };
    }

    @Before
    public void setUpMocks(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void doesHaveManeWithCorrectSexTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expectedResult, lion.doesHaveMane());
    }


}

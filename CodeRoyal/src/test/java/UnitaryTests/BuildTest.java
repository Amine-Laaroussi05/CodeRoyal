package UnitaryTests;

import CodeRoyal.Reine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.*;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildTest {

    @Spy
    Reine reine = new Reine();

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }



    @ParameterizedTest
    @CsvFileSource(resources = "/CodeRoyal/build.csv", numLinesToSkip = 1)
    public void buildTest(int coord_x, int coord_y, int expectedValue) throws Exception {
        Mockito.doReturn("BARRACKS-KNIGHT").when(reine).barracks();
        reine.touchedSiteInitializer();
        reine.setCoord_x(coord_x);
        reine.setCoord_y(coord_y);
        String text = tapSystemOut(reine::build);
        assertEquals("BUILD " + expectedValue + " " + reine.barracks(), text);
    }


}

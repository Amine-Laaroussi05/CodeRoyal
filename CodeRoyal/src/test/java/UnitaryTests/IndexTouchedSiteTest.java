package UnitaryTests;

import CodeRoyal.Reine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexTouchedSiteTest {



    @ParameterizedTest
    @CsvFileSource(resources = "/CodeRoyal/indexTouchedSite.csv", numLinesToSkip = 1)
    public void IndexTest(int coord_x, int coord_y, int expectedValue){
        Reine reine = new Reine();
        reine.touchedSiteInitializer();
        reine.setCoord_x(coord_x);
        reine.setCoord_y(coord_y);
        assertEquals(expectedValue, reine.indexTouchedSite());
    }



}

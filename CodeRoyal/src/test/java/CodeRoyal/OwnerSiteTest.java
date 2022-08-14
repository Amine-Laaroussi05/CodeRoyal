package CodeRoyal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OwnerSiteTest {



    Reine reine = new Reine();



    @ParameterizedTest
    @CsvFileSource(resources = "/CodeRoyal/ownerSite.csv", numLinesToSkip = 1)
    public void premier_indice(int ownerValue, int coord_x, int coord_y, int index, int expectedValue){
        reine.touchedSiteInitializer();
        reine.setCoord_x(coord_x);
        reine.setCoord_y(coord_y);
        List<Integer> integerList = new ArrayList<>();
        integerList.add(ownerValue);
        integerList.add(coord_x);
        integerList.add(coord_y);
        reine.setTouchedSiteArray(index,integerList);
        assertEquals(expectedValue,reine.ownerSite());


    }


}
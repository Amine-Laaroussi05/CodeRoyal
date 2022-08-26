package UnitaryTests;

import CodeRoyal.Batiment;
import CodeRoyal.Main;
import CodeRoyal.Reine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.*;

import java.util.List;
import java.util.Random;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildTest {

    @Spy
    Reine reine = new Reine();

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }



//    @ParameterizedTest
//    @CsvFileSource(resources = "/CodeRoyal/build.csv", numLinesToSkip = 1)
//    public void buildTest(int coord_x, int coord_y, int expectedValue) throws Exception {
//        Mockito.doReturn("BARRACKS-KNIGHT").when(reine).barracks();
//        reine.touchedSiteInitializer();
//        reine.setCoord_x(coord_x);
//        reine.setCoord_y(coord_y);
//        String text = tapSystemOut(()->{
////            reine.build();
//        });
//        assertEquals("BUILD " + expectedValue + " " + reine.barracks(), text);
//    }



    @RepeatedTest(10000)
    public void test() throws Exception {
        Random random = new Random();
        reine.setCoord_x(random.ints(1,100,1900).iterator().nextInt());
        reine.setCoord_y(random.ints(1,100,900).iterator().nextInt());
        Mockito.when(reine.barracks()).thenReturn("BARRACKS-KNIGHT");


        List<Batiment> batimentList = Main.generateBatiments(random.ints(1,0,10).iterator().nextInt());
        Batiment batimentPlusProche = Main.calculateminimalDistanceForAllBatiments(reine.getCoord_x(),reine.getCoord_y(),batimentList);

        String text = tapSystemOut(()->{
            reine.build(batimentList);
        });



        assert batimentPlusProche != null;
        assertEquals("BUILD " + batimentPlusProche.getId() + " " + reine.barracks(), text);


    }


}

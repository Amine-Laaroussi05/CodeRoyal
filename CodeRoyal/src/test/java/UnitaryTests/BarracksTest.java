package UnitaryTests;

import CodeRoyal.Batiment;
import CodeRoyal.Reine;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BarracksTest {

    Reine reine = new Reine();


//    @ParameterizedTest
//    @CsvFileSource(resources = "/CodeRoyal/barracks.csv", numLinesToSkip = 1)
//    public void Value_Zero(int compteurKnight, String typeArmyExpected){
//        reine.setCompteurKnight(compteurKnight);
//        assertEquals("BARRACKS-" + typeArmyExpected,reine.barracks());
//    }


//    @Test
//    public void ValueMoreThanEight(){
//        reine.setCompteurKnight(9);
//        assertThrows(IllegalArgumentException.class, ()->{
//            reine.barracks();
//        });
//    }

//    @Test
//    public void NonPositiveValue(){
//        reine.setCompteurKnight(-1);
//        assertThrows(IllegalArgumentException.class, ()->{
//            reine.barracks();
//        });
//    }


//    @ParameterizedTest
//    @CsvFileSource(resources = "/CodeRoyal/barracksPostMethod.csv", numLinesToSkip = 1)
//    public void PostMethodTest(int compteurKnight, int expectedCompteurKnight){
//        reine.setCompteurKnight(compteurKnight);
//        reine.barracks();
//        assertEquals(expectedCompteurKnight, reine.getCompteurKnight());
//    }

    @RepeatedTest(1000)
    public void test(){
        int numeroTest = 0;
        Random random = new Random();
        int compteurKnight = random.ints(1,-1,10).iterator().nextInt();
        reine.setCompteurKnight(compteurKnight);
        Batiment batiment = new Batiment(1,random.ints(1,100,1900).iterator().nextInt(),
                random.ints(1,100,900).iterator().nextInt(),
                random.ints(1,-1,2).iterator().nextInt(),false);
        switch(reine.getCompteurKnight()){
            case -1:
            case 9:
                assertThrows(IllegalArgumentException.class,()->{
                    reine.barracks(batiment);
                });
                break;
            case 0:
            case 2:
            case 4:
            case 6:
                assertEquals("BARRACKS-KNIGHT",reine.barracks(batiment));
                assertEquals(compteurKnight+1,reine.getCompteurKnight());
                assertEquals('K',batiment.getArmyType());
                break;
            case 1:
            case 3:
            case 5:
            case 7:
                assertEquals("BARRACKS-ARCHER",reine.barracks(batiment));
                assertEquals(compteurKnight+1,reine.getCompteurKnight());
                assertEquals('A',batiment.getArmyType());
                break;
            case 8:
                assertEquals("BARRACKS-KNIGHT",reine.barracks(batiment));
                assertEquals(0,reine.getCompteurKnight());
                assertEquals('K',batiment.getArmyType());
        }
    }



}

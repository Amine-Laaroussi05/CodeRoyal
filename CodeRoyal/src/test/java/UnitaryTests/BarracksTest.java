package UnitaryTests;

import CodeRoyal.Reine;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BarracksTest {

    Reine reine = new Reine();


    @ParameterizedTest
    @CsvFileSource(resources = "/CodeRoyal/barracks.csv", numLinesToSkip = 1)
    public void Value_Zero(int compteurKnight, String typeArmyExpected){
        reine.setCompteurKnight(compteurKnight);
        assertEquals("BARRACKS-" + typeArmyExpected,reine.barracks());
    }


    @Test
    public void ValueMoreThanEight(){
        reine.setCompteurKnight(9);
        assertThrows(IllegalArgumentException.class, ()->{
            reine.barracks();
        });
    }

    @Test
    public void NonPositiveValue(){
        reine.setCompteurKnight(-1);
        assertThrows(IllegalArgumentException.class, ()->{
            reine.barracks();
        });
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/CodeRoyal/barracksPostMethod.csv", numLinesToSkip = 1)
    public void PostMethodTest(int compteurKnight, int expectedCompteurKnight){
        reine.setCompteurKnight(compteurKnight);
        reine.barracks();
        assertEquals(expectedCompteurKnight, reine.getCompteurKnight());
    }


}

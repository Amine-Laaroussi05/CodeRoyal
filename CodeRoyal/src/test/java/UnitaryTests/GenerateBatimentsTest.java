package UnitaryTests;

import CodeRoyal.Batiment;
import CodeRoyal.Main;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GenerateBatimentsTest {



    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/CodeRoyal/generateBatiments.csv", numLinesToSkip = 1, useHeadersInDisplayName = true)
    public void test(int numberOfOnes){
        List<Batiment> batimentList = Main.generateBatiments(numberOfOnes);
        int compteur = 0;
        for(Batiment batiment: batimentList){
            if(batiment.getOwner() == 1){
                compteur++;
            }
        }
        assertEquals(numberOfOnes, compteur);
    }

    @Test
    public void exceptionTest(){
        assertThrows(IllegalArgumentException.class,()->{
            List<Batiment> batimentList = Main.generateBatiments(-1);
        });
    }


}

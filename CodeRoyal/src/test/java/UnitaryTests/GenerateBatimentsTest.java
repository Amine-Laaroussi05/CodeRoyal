package UnitaryTests;

import CodeRoyal.Batiment;
import CodeRoyal.Main;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateBatimentsTest {



    @Test
    public void OneOwner(){
        List<Batiment> batimentList = Main.generateBatiments(1);
        int compteur = 0;
        for(Batiment batiment: batimentList){
            if(batiment.getOwner() == 1){
                compteur++;
            }
        }
        assertEquals(1, compteur);
    }


}

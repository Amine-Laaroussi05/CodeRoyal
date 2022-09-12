package UnitaryTests;

import CodeRoyal.Batiment;
import CodeRoyal.Main;
import CodeRoyal.Reine;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UpdateBuildedRandomTest {

    Random random = new Random();
    Reine reine = new Reine();

    @RepeatedTest(100)
    public void test(){
        List<Batiment> batimentList = Main.generateBatiments(10);
        reine.setBatimentList(batimentList);
        for(Batiment batiment : batimentList){
            if(random.ints(1,0,2).iterator().nextInt() == 1) batiment.setRecentlyBuilded(true);
            if(random.ints(1,-1,2).iterator().nextInt() == 0) batiment.setOwner(0);
            System.out.println(batiment.toString());
        }
        System.out.println("***********");
        reine.updateBuilded();
        for(Batiment batiment: batimentList){
            if(batiment.getOwner() == 0){
                assertFalse(batiment.isRecentlyBuilded());
                System.out.println(batiment);
            }

        }
        System.out.println("==============");
    }


}

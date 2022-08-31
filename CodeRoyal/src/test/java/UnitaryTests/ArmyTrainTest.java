package UnitaryTests;

import CodeRoyal.Batiment;
import CodeRoyal.Main;
import CodeRoyal.Reine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTrainTest {
    static Random random = new Random();
    static List<Batiment> batimentList = Main.generateBatiments(random.ints(1,0,10).iterator().nextInt());
    static Iterator<Batiment> iterator = batimentList.iterator();
    static Batiment batiment;
    static Reine reine = new Reine();
    static List<Integer> armyTrainedList = new ArrayList<>();


    @BeforeAll
    public static void setUp(){
        for(Batiment batiment: batimentList){
            armyTrainedList.add(random.ints(1,0,10).iterator().nextInt());
            batiment.setArmyTrained(armyTrainedList.get(batimentList.indexOf(batiment)));
        }
        reine.armyTrain(batimentList);
    }

    @BeforeEach
    public void beforeTest(){
        if(iterator.hasNext()) batiment = iterator.next();
        else iterator = batimentList.iterator();
    }

    @RepeatedTest(20)
    public void test(){
        if(batiment.getArmyTrained() > 0 & batiment.getArmyTrained() <= 10) assertEquals(armyTrainedList.get(batimentList.indexOf(batiment))+1, batiment.getArmyTrained());
        else if(armyTrainedList.get(batimentList.indexOf(batiment)) == 10) assertEquals(0,batiment.getArmyTrained());
    }

}
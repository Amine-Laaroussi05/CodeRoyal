package UnitaryTests;

import CodeRoyal.Batiment;
import CodeRoyal.Main;
import CodeRoyal.Reine;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.RepeatedTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {


    static Set<Integer> listeNumerosTest = new HashSet<>();

    /**
     * Le test prend en compte les cas suivants :
     *
     * 1. Au moins un bâtiment allié, pas assez d'or : **TRAIN**
     *
     * 2. Aucun bâtiment allié : **TRAIN**
     *
     * 3. Au moins un bâtiment allié, or compris entre 80 et 99, armyType = K : **TRAIN id**
     *
     * 4. Au moins un bâtiment allié, or compris entre 80 et 99, armyType = A : **TRAIN**
     *
     * 5. Au moins un bâtiment allié, or supérieur à 100 : **TRAIN id**
     */
    @RepeatedTest(1000)
    public void test() throws Exception {
        Random random = new Random();
        List<Batiment> batimentList = Main.generateBatiments(random.ints(1,0,10).iterator().nextInt());
        Reine reine = new Reine();
        int id = -1;
        char armyType = 'O';
        int numeroTest =0;


        // On initialise aléatoirement les valeurs de chaque bâtiment
        for(Batiment batiment: batimentList){
            batiment.setOwner(random.ints(1,-1,2).iterator().nextInt());
            batiment.setArmyTrained(random.ints(1,0,3).iterator().nextInt());
            if(random.ints(1,0,2).iterator().nextInt() == 0) batiment.setArmyType('K');
            else batiment.setArmyType('A');
        }

        // On détermine si la liste contient un bâtiment allié (owner = 0)
        boolean haveBatimentAllieAndArmyTrained = false;
        for(Batiment batiment: batimentList){
            if (batiment.getOwner() == 0 & batiment.getArmyTrained() == 0) {
                haveBatimentAllieAndArmyTrained = true;
                break;
            }
        }

        // On assigne un nombre aléatoire d'or à la reine
        int gold = random.ints(1,0,120).iterator().nextInt();
        reine.setGold(gold);

        // On ordonne la liste du bâtiment le plus proche de la reine au bâtiment le plus loin
        batimentList.sort((batiment1, batiment2) -> (int) Main.compareDistanceEntreDeuxBatimentsAvecLaReine(batiment1,batiment2,reine.getCoord_x(),reine.getCoord_y()));

        // On détermine le numéro du test selon les données actuelles
        if(!haveBatimentAllieAndArmyTrained){
            numeroTest = 2;
            listeNumerosTest.add(numeroTest);
        }
        else if(reine.getGold() < 80){
            numeroTest = 1;
            listeNumerosTest.add(numeroTest);
        }
        else {
            for(Batiment batiment: batimentList){
                if(batiment.getOwner() == 0 & batiment.getArmyTrained() == 0){
                    id = batiment.getId();
                    armyType = batiment.getArmyType();
                    break;
                }
            }
            if(reine.getGold() >= 80 & reine.getGold() < 100 & armyType == 'K'){
                numeroTest = 3;
                listeNumerosTest.add(numeroTest);
            }
            else if(reine.getGold() >= 80 & reine.getGold() < 100 & armyType == 'A'){
                numeroTest = 4;
                listeNumerosTest.add(numeroTest);
            }
            else if(reine.getGold() >= 100){
                numeroTest = 5;
                listeNumerosTest.add(numeroTest);
            }
        }

        System.out.println("Numéro du test: " + numeroTest);
        // On lance les assertions dépendamment du numéro du test obtenu
        switch(numeroTest){
            case 1:
            case 2:
            case 4:
                assertEquals("TRAIN",reine.train(batimentList));
                break;
            case 3:
            case 5:
                    assertEquals("TRAIN " + id, reine.train(batimentList));
        }

    }





    /**
     * Affiche les numéros de test qui ont été lancés durant les tests
     */
    @AfterAll
    public static void tearDown(){
        System.out.println(listeNumerosTest);
    }

}
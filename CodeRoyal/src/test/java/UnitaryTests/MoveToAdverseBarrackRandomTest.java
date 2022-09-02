package UnitaryTests;

import CodeRoyal.Batiment;
import CodeRoyal.Main;
import CodeRoyal.Reine;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveToAdverseBarrackRandomTest {

    Reine reine = new Reine();
    Random random = new Random();
    List<Batiment> batimentList = Main.generateBatiments(random.ints(1,1,10).iterator().nextInt());
    int numeroTest = 0;
    static Set<Integer> numeroTestSet = new HashSet<>();

    /**
     * 1. Le bâtiment ennemi le plus proche et la reine ont la même coordonnée x.
     *
     * 1.1 Le bâtiment a une coordonnée 'y' plus grande que la coordonnée 'y' de la reine.
     *
     * 1.2 Le bâtiment a une coordonnée 'y' plus petite que la coordonnée 'y' de la reine.
     *
     *
     * 2. Le bâtiment ennemi le plus proche et la reine ont la même coordonnée y.
     *
     * 2.1 Le bâtiment a une coordonnée 'x' plus grande que la coordonnée 'x' de la reine.
     *
     * 2.2 Le bâtiment a une coordonnée 'x' plus petite que la coordonnée 'y' de la reine.
     *
     *
     * 3. Le bâtiment ennemi le plus proche et la reine ont différentes coordonnées x et y.
     *
     * 3.1 Le bâtiment a une coordonnée 'x' et une coordonnée 'y' plus grandes que ceux de la reine.
     *
     * 3.2 Le bâtiment a une coordonnée 'x' et une coordonnée 'y' plus petites que ceux de la reine.
     *
     * 3.3 Le bâtiment a une coordonnée 'x' plus grande que la coordonnée 'x' de la reine, et une coordonnée 'y' plus petite que la coordonnée 'y' de la reine.
     *
     * 3.4 Le bâtiment a une coordonnée 'x' plus petite que la coordonnée 'y' de la reine, et une coordonnée 'y' plus grande que la coordonnée 'y' de la reine.
     *
     */
    @RepeatedTest(1000)
    public void test(){
        int coord_x = random.ints(1,100,1920).iterator().nextInt();
        reine.setCoord_x(coord_x);
        System.out.println("Reine coord_x = " + coord_x);
        int coord_y = random.ints(1,100,1000).iterator().nextInt();
        reine.setCoord_y(coord_y);
        System.out.println("Reine coord_y = " + coord_y);

        int indiceBatimentPlusProche = Main.calculateMinimalDistance(reine.getCoord_x(),reine.getCoord_y(),batimentList);

        // Vérifie si la reine se trouve au même endroit que le bâtiment ennemi
        // Dans ce cas, il n'y a rien à faire (aucun déplacement)
        if(Math.abs(batimentList.get(indiceBatimentPlusProche).getCoord_x() - reine.getCoord_x()) <= 60 & Math.abs(batimentList.get(indiceBatimentPlusProche).getCoord_y() - reine.getCoord_y())<= 60){
            System.out.println("No test");
            assertTrue(true);
        } else{ // Dans le cas contraire, on regarde dans quel test on se trouve
            if(batimentList.get(indiceBatimentPlusProche).getCoord_x() == reine.getCoord_x()){ // Test n°1
                if(batimentList.get(indiceBatimentPlusProche).getCoord_y() > reine.getCoord_y()) numeroTest = 11;
                else numeroTest = 12;
            } else if(batimentList.get(indiceBatimentPlusProche).getCoord_y() == reine.getCoord_y()){ // Test n° 2
                if(batimentList.get(indiceBatimentPlusProche).getCoord_x() > reine.getCoord_x()) numeroTest = 21;
                else numeroTest = 22;
            } else{ // Test n°3
                if(batimentList.get(indiceBatimentPlusProche).getCoord_x() >= reine.getCoord_x() & batimentList.get(indiceBatimentPlusProche).getCoord_y() >= reine.getCoord_y()) numeroTest = 31;
                else if(batimentList.get(indiceBatimentPlusProche).getCoord_x() <= reine.getCoord_x() & batimentList.get(indiceBatimentPlusProche).getCoord_y() <= reine.getCoord_y()) numeroTest = 32;
                else if(batimentList.get(indiceBatimentPlusProche).getCoord_x() >= reine.getCoord_x() & batimentList.get(indiceBatimentPlusProche).getCoord_y() <= reine.getCoord_y()) numeroTest = 33;
                else numeroTest = 34;
            }


            reine.moveToAdverseBarrack(batimentList);
            // On exécute l'assertion suivant le numéro du test
            switch(numeroTest){
                case 11:
                    System.out.println("Numero Test: " + numeroTest);
                    numeroTestSet.add(numeroTest);
                    assertEquals(coord_y+60,reine.getCoord_y());
                    break;
                case 12:
                    System.out.println("Numero Test: " + numeroTest);
                    numeroTestSet.add(numeroTest);
                    assertEquals(coord_y-60,reine.getCoord_y());
                    break;
                case 21:
                    System.out.println("Numero Test: " + numeroTest);
                    numeroTestSet.add(numeroTest);
                    assertEquals(coord_x+60,reine.getCoord_x());
                    break;
                case 22:
                    System.out.println("Numero Test: " + numeroTest);
                    numeroTestSet.add(numeroTest);
                    assertEquals(coord_x-60,reine.getCoord_x());
                    break;
                case 31:
                    System.out.println("Numero Test: " + numeroTest);
                    numeroTestSet.add(numeroTest);
                    assertEquals(coord_x+60,reine.getCoord_x());
                    assertEquals(coord_y+60,reine.getCoord_y());
                    break;
                case 32:
                    System.out.println("Numero Test: " + numeroTest);
                    numeroTestSet.add(numeroTest);
                    assertEquals(coord_x-60,reine.getCoord_x());
                    assertEquals(coord_y-60,reine.getCoord_y());
                    break;
                case 33:
                    System.out.println("Numero Test: " + numeroTest);
                    numeroTestSet.add(numeroTest);
                    assertEquals(coord_x+60,reine.getCoord_x());
                    assertEquals(coord_y-60,reine.getCoord_y());
                    break;
                case 34:
                    System.out.println("Numero Test: " + numeroTest);
                    numeroTestSet.add(numeroTest);
                    assertEquals(coord_x-60,reine.getCoord_x());
                    assertEquals(coord_y+60,reine.getCoord_y());
                    break;
            }
        }
    }


    @AfterAll
    public static void tearDown(){
        System.out.println(numeroTestSet);
    }



}

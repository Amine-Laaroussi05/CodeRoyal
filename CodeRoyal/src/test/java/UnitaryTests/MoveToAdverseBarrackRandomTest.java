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
    List<Batiment> batimentList = Main.generateBatiments(random.ints(1, 1, 10).iterator().nextInt());
    String numeroTest = "";
    static Set<Integer> numeroTestSet = new HashSet<>();

    /**
     * 1. Le bâtiment ennemi le plus proche et la reine ont la même coordonnée x.
     * <p>
     * 1.1 Le bâtiment a une coordonnée 'y' plus grande que la coordonnée 'y' de la reine.
     * <p>
     * 1.2 Le bâtiment a une coordonnée 'y' plus petite que la coordonnée 'y' de la reine.
     * <p>
     * <p>
     * 2. Le bâtiment ennemi le plus proche et la reine ont la même coordonnée y.
     * <p>
     * 2.1 Le bâtiment a une coordonnée 'x' plus grande que la coordonnée 'x' de la reine.
     * <p>
     * 2.2 Le bâtiment a une coordonnée 'x' plus petite que la coordonnée 'y' de la reine.
     * <p>
     * <p>
     * 3. Le bâtiment ennemi le plus proche et la reine ont différentes coordonnées x et y.
     * <p>
     * 3.1 Le bâtiment a une coordonnée 'x' et une coordonnée 'y' plus grandes que ceux de la reine.
     * <p>
     * 3.1.1 Les deux coordonnées sont à une distance supérieure à 60 + coord.reine
     * <p>
     * 3.1.2 La coordonnée x est à une distance supérieure à 60 + reine.coord_x et la coordonnée y est à une distance inférieure à 60 + reine.coord_y
     * <p>
     * ... etc
     * <p>
     * <p>
     * 3.2 Le bâtiment a une coordonnée 'x' et une coordonnée 'y' plus petites que ceux de la reine.
     * <p>
     * 3.3 Le bâtiment a une coordonnée 'x' plus grande que la coordonnée 'x' de la reine, et une coordonnée 'y' plus petite que la coordonnée 'y' de la reine.
     * <p>
     * 3.4 Le bâtiment a une coordonnée 'x' plus petite que la coordonnée 'y' de la reine, et une coordonnée 'y' plus grande que la coordonnée 'y' de la reine.
     */
    @RepeatedTest(1000)
    public void test() {
        int coord_x = random.ints(1, 100, 1920).iterator().nextInt();
        reine.setCoord_x(coord_x);
        System.out.println("Reine coord_x = " + coord_x);
        int coord_y = random.ints(1, 100, 1000).iterator().nextInt();
        reine.setCoord_y(coord_y);
        System.out.println("Reine coord_y = " + coord_y);

        int indiceBatimentPlusProche = Main.calculateMinimalDistance(reine.getCoord_x(), reine.getCoord_y(), batimentList);

        // Vérifie si la reine se trouve au même endroit que le bâtiment ennemi
        // Dans ce cas, il n'y a rien à faire (aucun déplacement)
        // Dans le cas contraire, on regarde dans quel test on se trouve
        if (batimentList.get(indiceBatimentPlusProche).getCoord_x() > reine.getCoord_x() + 60) numeroTest += "1";
        else if (batimentList.get(indiceBatimentPlusProche).getCoord_x() > reine.getCoord_x()) numeroTest += "2";
        else if (batimentList.get(indiceBatimentPlusProche).getCoord_x() < reine.getCoord_x() - 60) numeroTest += "3";
        else if (batimentList.get(indiceBatimentPlusProche).getCoord_x() < reine.getCoord_x()) numeroTest += "4";

        if (batimentList.get(indiceBatimentPlusProche).getCoord_y() > reine.getCoord_y() + 60) numeroTest += "1";
        else if (batimentList.get(indiceBatimentPlusProche).getCoord_y() > reine.getCoord_y()) numeroTest += "2";
        else if (batimentList.get(indiceBatimentPlusProche).getCoord_y() < reine.getCoord_y() - 60) numeroTest += "3";
        else if (batimentList.get(indiceBatimentPlusProche).getCoord_y() < reine.getCoord_y()) numeroTest += "4";


        reine.moveToAdverseBarrack(batimentList);
        // On exécute l'assertion suivant le numéro du test
        switch (Integer.parseInt(numeroTest)) {
            case 11:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
                assertEquals(coord_x + 60, reine.getCoord_x());
                assertEquals(coord_y + 60, reine.getCoord_y());
                break;
            case 12:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
            case 14:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
                assertEquals(coord_x + 60, reine.getCoord_x());
                assertEquals(batimentList.get(indiceBatimentPlusProche).getCoord_y(), reine.getCoord_y());
                break;
            case 13:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
                assertEquals(coord_x + 60, reine.getCoord_x());
                assertEquals(coord_y - 60, reine.getCoord_y());
                break;
            case 21:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
            case 41:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
                assertEquals(batimentList.get(indiceBatimentPlusProche).getCoord_x(), reine.getCoord_x());
                assertEquals(coord_y + 60, reine.getCoord_y());
                break;
            case 22:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
            case 24:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
            case 42:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
            case 44:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
                assertEquals(batimentList.get(indiceBatimentPlusProche).getCoord_x(), reine.getCoord_x());
                assertEquals(batimentList.get(indiceBatimentPlusProche).getCoord_y(), reine.getCoord_y());
                break;
            case 23:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
            case 43:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
                assertEquals(batimentList.get(indiceBatimentPlusProche).getCoord_x(), reine.getCoord_x());
                assertEquals(coord_y - 60, reine.getCoord_y());
                break;
            case 31:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
                assertEquals(coord_x - 60, reine.getCoord_x());
                assertEquals(coord_y + 60, reine.getCoord_y());
                break;
            case 32:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
            case 34:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
                assertEquals(coord_x - 60, reine.getCoord_x());
                assertEquals(batimentList.get(indiceBatimentPlusProche).getCoord_y(), reine.getCoord_y());
                break;
            case 33:
                System.out.println("Numero Test: " + numeroTest);
                numeroTestSet.add(Integer.parseInt(numeroTest));
                assertEquals(coord_x - 60, reine.getCoord_x());
                assertEquals(coord_y - 60, reine.getCoord_y());
                break;
        }
    }


    @AfterAll
    public static void tearDown() {
        System.out.println(numeroTestSet);
    }


}

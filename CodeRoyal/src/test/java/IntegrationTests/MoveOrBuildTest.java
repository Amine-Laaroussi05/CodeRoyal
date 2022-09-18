package IntegrationTests;

import CodeRoyal.Batiment;
import CodeRoyal.Main;
import CodeRoyal.Reine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class MoveOrBuildTest {

    @Spy
    Reine reine = new Reine();

    @BeforeEach
    public void beforeTest(){
        MockitoAnnotations.openMocks(this);
    }

    Random random = new Random();

    /**
     * 1. Aucun bâtiment n'est proche de la reine, avec un bâtiment ennemi existant.
     *
     * 2. Aucun bâtiment n'est proche de la reine et aucun bâtiment ennemi de construit.
     *
     * 3. Reine en contact d'un bâtiment non construit et aucun bâtiment ennemi de construit.
     *
     * 4. Reine en contact d'un bâtiment non construit, et au moins un bâtiment ennemi de construit.
     *
     * 5. Reine en contact d'un bâtiment allié et aucun bâtiment ennemi de construit.
     *
     * 6. Reine en contact d'un bâtiment allié, et au moins un bâtiment ennemi de construit.
     *
     * 7. Reine en contact d'un bâtiment ennemi, et c'est le seul bâtiment ennemi construit.
     *
     * 8. Reine en contact d'un bâtiment ennemi, et d'autres bâtiments ennemis existants.
     */
    int numeroTest = 0;

    @RepeatedTest(1000)
    public void test() throws Exception {
        double distanceMinimale;
        int indexBatiment;

        reine.setGold(100);
        reine.setCoord_x(random.ints(1,100,1900).iterator().nextInt());
        System.out.println("coord_x de la reine: " + reine.getCoord_x());
        reine.setCoord_y(random.ints(1,100,980).iterator().nextInt());
        System.out.println("coord_y de la reine: " + reine.getCoord_y());
        System.out.println("**********************************");
        List<Batiment> batimentList = Main.generateBatiments(random.ints(1,1,10).iterator().nextInt());
        reine.setBatimentList(batimentList);
        for (Batiment batiment : batimentList) {
            System.out.println(batiment.toString());
        }
        System.out.println("***********************************");

        // distance du bâtiment le plus proche de la reine
        if(batimentList.size() > 0){
            Batiment batiment = Main.calculateminimalDistanceForAllBatiments(reine.getCoord_x(),reine.getCoord_y(),batimentList);
            distanceMinimale = Math.sqrt(Math.pow(batiment.getCoord_x() - reine.getCoord_x(),2) + Math.pow(batiment.getCoord_y() - reine.getCoord_y(),2));
            System.out.println("Distance du bâtiment ennemi le plus proche de la reine: " + distanceMinimale);
            System.out.println("Index du bâtiment: " + batimentList.indexOf(batiment));
            System.out.println("Owner du bâtiment: " + batiment.getOwner());
            System.out.println("**************************************************");



        // S'il n'y a aucun bâtiment ennemi
        if(Main.calculateMinimalDistance(reine.getCoord_x(),reine.getCoord_y(),batimentList) == -1){
            // Détermine quel test sera lancé suivant le calcul qui a été fait ci-dessus.
            if(distanceMinimale > 30) numeroTest = 2;
            else if(batiment.getOwner() == -1) numeroTest = 3;
            else if(batiment.getOwner() == 0) numeroTest = 5;
            else throw new Exception("la liste contient un bâtiment qui n'a pas été pris en compte dans le calcul.");
        }
        // Si la liste contient au moins un bâtiment ennemi
        else{
            List<Batiment> batimentListCopy = new ArrayList<>(batimentList); // La liste privée du bâtiment ennemi le plus proche
            batimentListCopy.remove(Main.calculateMinimalDistance(reine.getCoord_x(),reine.getCoord_y(),batimentList));
            if(distanceMinimale > 30) numeroTest = 1;
            else if(batiment.getOwner() == -1) numeroTest = 4;
            else if(batiment.getOwner() == 0) numeroTest = 6;
            else if(Main.calculateMinimalDistance(reine.getCoord_x(),reine.getCoord_y(),batimentListCopy) == -1) numeroTest = 7;
            else numeroTest = 8;
        }
        }
        System.out.println("Numéro du test: " + numeroTest);
        System.out.println("***********************");
        reine.moveOrBuild();


        // Vérifie si la bonne méthode a été appelée
        switch (numeroTest){
            case 1:
            case 2:
            case 5:
            case 6:
                Mockito.verify(reine).kinfOfMove();
                break;
            case 3:
            case 4:
            case 7:
            case 8:
                Mockito.verify(reine).build();
                break;
        }

    }

}
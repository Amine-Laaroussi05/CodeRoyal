package IntegrationTests;

import CodeRoyal.Batiment;
import CodeRoyal.Main;
import CodeRoyal.Reine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class moveOrBuildTest {

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

    @RepeatedTest(1)
    public void test() throws Exception {
        reine.setGold(100);
        reine.setCoord_x(random.ints(1,100,1900).iterator().nextInt());
        System.out.println("coord_x de la reine: " + reine.getCoord_x());
        reine.setCoord_y(random.ints(1,100,980).iterator().nextInt());
        System.out.println("coord_y de la reine: " + reine.getCoord_y());
        System.out.println("**********************************");
        List<Batiment> batimentList = Main.generateBatiments(random.ints(1,0,10).iterator().nextInt());
        for (Batiment batiment : batimentList) {
            System.out.println(batiment.toString());
        }
        System.out.println("***********************************");

        // distance du bâtiment le plus proche de la reine
        double distanceMinimale = Math.sqrt(Math.pow(batimentList.get(0).getCoord_x() - reine.getCoord_x(),2) + Math.pow(batimentList.get(0).getCoord_y() - reine.getCoord_y(),2));
        int indexBatiment = 0;
        for(Batiment batiment: batimentList){
            double distance = Math.sqrt(Math.pow(batiment.getCoord_x() - reine.getCoord_x(),2) + Math.pow(batiment.getCoord_y() - reine.getCoord_y(),2));
            if(distance < distanceMinimale){
                distanceMinimale = distance;
                indexBatiment = batimentList.indexOf(batiment);
            }
        }
        System.out.println("Distance du bâtiment ennemi le plus proche de la reine: " + distanceMinimale);
        System.out.println("Owner du bâtiment: " + batimentList.get(indexBatiment).getOwner());

        // S'il n'y a aucun bâtiment ennemi
        if(Main.calculateMinimalDistance(reine.getCoord_x(),reine.getCoord_y(),batimentList) == -1){
            // Détermine quel test sera lancé suivant le calcul qui a été fait ci-dessus.
            if(distanceMinimale > 30) numeroTest = 2;
            else if(batimentList.get(indexBatiment).getOwner() == -1) numeroTest = 3;
            else if(batimentList.get(indexBatiment).getOwner() == 0) numeroTest = 5;
            else throw new Exception("la liste contient un bâtiment qui n'a pas été pris en compte dans le calcul.");
        }
        // Si la liste contient au moins un bâtiment ennemi
        else{
            List<Batiment> batimentListCopy = batimentList; // La liste privée du bâtiment ennemi le plus proche
            batimentListCopy.remove(Main.calculateMinimalDistance(reine.getCoord_x(),reine.getCoord_y(),batimentList));
            if(distanceMinimale > 30) numeroTest = 1;
            else if(batimentList.get(indexBatiment).getOwner() == -1) numeroTest = 4;
            else if(batimentList.get(indexBatiment).getOwner() == 0) numeroTest = 6;
            else if(Main.calculateMinimalDistance(reine.getCoord_x(),reine.getCoord_y(),batimentListCopy) == -1) numeroTest = 7;
            else numeroTest = 8;
        }

        reine.moveOrBuild(batimentList);
        switch (numeroTest){
            case 1:
                Mockito.verify(reine).kinfOfMove(batimentList);
            case 2:
                Mockito.verify(reine).kinfOfMove(batimentList);
            case 3:
                Mockito.verify(reine).build();
            case 4:
                Mockito.verify(reine).build();
            case 5:
                Mockito.verify(reine).kinfOfMove(batimentList);
            case 6:
                Mockito.verify(reine).kinfOfMove(batimentList);
            case 7:
                Mockito.verify(reine).build();
            case 8:
                Mockito.verify(reine).build();
        }

    }

}
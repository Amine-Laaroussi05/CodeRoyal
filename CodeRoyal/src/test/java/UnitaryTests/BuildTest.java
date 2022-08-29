package UnitaryTests;

import CodeRoyal.Batiment;
import CodeRoyal.Main;
import CodeRoyal.Reine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildTest {

    @Spy
    Reine reine = new Reine();


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }



//    @ParameterizedTest
//    @CsvFileSource(resources = "/CodeRoyal/build.csv", numLinesToSkip = 1)
//    public void buildTest(int coord_x, int coord_y, int expectedValue) throws Exception {
//        Mockito.doReturn("BARRACKS-KNIGHT").when(reine).barracks();
//        reine.touchedSiteInitializer();
//        reine.setCoord_x(coord_x);
//        reine.setCoord_y(coord_y);
//        String text = tapSystemOut(()->{
////            reine.build();
//        });
//        assertEquals("BUILD " + expectedValue + " " + reine.barracks(), text);
//    }



    // Vérifie si le message retourné après le build correspond à ce qu'on attendait
//    @RepeatedTest(100)
//    public void testBuild() throws Exception {
//        Random random = new Random();
//        reine.setCoord_x(random.ints(1,100,1900).iterator().nextInt());
//        reine.setCoord_y(random.ints(1,100,900).iterator().nextInt());
//        Mockito.when(reine.barracks()).thenReturn("BARRACKS-KNIGHT");
//
//
//        List<Batiment> batimentList = Main.generateBatiments(random.ints(1,0,10).iterator().nextInt());
//        Batiment batimentPlusProche = Main.calculateminimalDistanceForAllBatiments(reine.getCoord_x(),reine.getCoord_y(),batimentList);
//
//        String text = tapSystemOut(()->{
//            reine.build(batimentList);
//        });
//
//
//
//        assert batimentPlusProche != null;
//        assertEquals("BUILD " + batimentPlusProche.getId() + " " + reine.barracks(), text);
//        assertEquals(0,batimentPlusProche.getOwner());
//
//
//    }


    @RepeatedTest(1000)
    public void test() throws Exception {
        Random random = new Random();
        reine.setGold(100);


        // On génère une liste de bâtiments aléatoire
        List<Batiment> batimentList = Main.generateBatiments(random.ints(1,0,10).iterator().nextInt());

        // On assigne des coordonnées aléatoires à la reine
        reine.setCoord_x(random.ints(1,100,1920).iterator().nextInt());
        reine.setCoord_y(random.ints(1,100,900).iterator().nextInt());

        // On assigne un owner aléatoire à chaque bâtiment
        for(Batiment batiment: batimentList){
            batiment.setOwner(random.ints(1,-1,2).iterator().nextInt());
        }

        // On ajoute dans une nouvelle liste les bâtiments qui ne sont pas des bâtiments alliés (owner != 0)
        List<Batiment> batimentListNotOwner = new ArrayList<>();
        for(Batiment batiment: batimentList) if(batiment.getOwner() != 0) batimentListNotOwner.add(batiment);

        // On vérifie que la liste n'est pas vide (sinon réassigner de façon aléatoire le owner de chaque bâtiment)
        while(batimentListNotOwner.isEmpty()){
            for(Batiment batiment: batimentList){
                batiment.setOwner(random.ints(1,-1,2).iterator().nextInt());
                if(batiment.getOwner() != 0) batimentListNotOwner.add(batiment);
            }
        }

        // On ordonne la liste du bâtiment le plus proche au bâtiment le plus loin de la reine
        batimentListNotOwner.sort((batiment1, batiment2) -> (int) Main.compareDistanceEntreDeuxBatimentsAvecLaReine(batiment1,batiment2,reine.getCoord_x(),reine.getCoord_y()));

        // On met à jour les coordonnées de la reine de sorte qu'elle soit en contact avec le bâtiment le plus proche
        reine.setCoord_x(batimentListNotOwner.get(0).getCoord_x());
        reine.setCoord_y(batimentListNotOwner.get(0).getCoord_y());

        // On stub la méthode barracks
        Mockito.doReturn("BARRACKS-ARCHER").when(reine).barracks(batimentListNotOwner.get(0));

        // On enregistre le résultat de la méthode build() dans un attribut de type String
        String texte = tapSystemOut(()->{
            reine.build(batimentList);
        });

        assertEquals("BUILD " + batimentListNotOwner.get(0).getId() + " " + "BARRACKS-ARCHER", texte);
    }


}

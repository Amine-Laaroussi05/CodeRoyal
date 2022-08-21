package UnitaryTests;

import CodeRoyal.Batiment;
import CodeRoyal.Reine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class moveToAdverseBarrackTest {


    Reine reine = new Reine();


    // Compteur de test qui servira à indiquer l'index de la liste dans le test paramétré.
    public static int numeroTest = 1;

    // Fichier csv contenant les coordonnées des bâtiments dont les données seront stockées dans la hashmap batimentsHashMap après l'exécution de @BeforeAll
    public static File batimentsFile = new File("src/main/resources/moveToAdverseBarrackTest/batiments.csv");
    public static HashMap<Integer,List<Batiment>> batimentsHashMap = new HashMap<>();







    @BeforeAll
    public static void setUp() throws IOException {
        // On extrait les données du fichier batiments.csv
        // Comme certains bâtiments figurent dans le même test, on va les regrouper dans une liste de bâtiments
        // puis les stocker dans une hashmap où la clé associée sera le numéro du test.
        FileReader batimentsReader = new FileReader(batimentsFile);
        BufferedReader batimentsBuffer = new BufferedReader(batimentsReader);
        String ligne = batimentsBuffer.readLine();
        List<Batiment> batimentList = new ArrayList<>();
        int lastInteger = 0;
        while((ligne = batimentsBuffer.readLine()) != null){
            String[] data = ligne.split(",");
            Batiment batiment = new Batiment(Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),false);
            if(Integer.parseInt(data[0]) == lastInteger){
                batimentList.add(batiment);
            } else if(lastInteger == 0){
                batimentList.add(batiment);
                lastInteger++;
            } else{
                List<Batiment> batimentListCopy = new ArrayList<>(batimentList);
                batimentsHashMap.put(lastInteger,batimentListCopy);
                batimentList.clear();
                batimentList.add(batiment);
                lastInteger++;
            }
        }

        batimentsHashMap.put(lastInteger,batimentList);
        batimentsBuffer.close();
    }




    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/moveToAdverseBarrackTest/expectedCoordinates.csv", useHeadersInDisplayName = true)
    public void test(int coord_x, int coord_y){
        reine.moveToAdverseBarrack(batimentsHashMap.get(numeroTest++));
        assertEquals(coord_x,reine.getCoord_x());
        assertEquals(coord_y, reine.getCoord_y());
    }


}
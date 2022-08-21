package UnitaryTests;


import CodeRoyal.Batiment;
import CodeRoyal.Main;
import CodeRoyal.Reine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class calculateMinimalDistanceTest {


    // Compteur de test qui servira à indiquer l'index de la liste dans le test paramétré.
    public static int numeroTest = 1;



    // Fichier csv contenant les coordonnées de la reine dont les données seront stockées dans la liste reineList après l'exécution de @BeforeAll
    public static File coordReineCsv = new File("src/main/resources/calculateMinimalDistanceTest/reineCoordonnees.csv");
    public static List<Reine> reineList = new ArrayList<>();


    // Fichier csv contenant les coordonnées des bâtiments dont les données seront stockées dans la hashmap batimentsHashMap après l'exécution de @BeforeAll
    public static File batimentsFile = new File("src/main/resources/calculateMinimalDistanceTest/batiments.csv");
    public static HashMap<Integer,List<Batiment>> batimentsHashMap = new HashMap<>();





    /**
     * Avant de lancer les tests, on va transformer les données des fichiers csv en objets java pour pouvoir les utiliser dans le test paramétré.
     * @throws IOException si le lecteur n'arrive pas à trouver l'emplacement d'un des fichiers
     */
    @BeforeAll
    public static void setUp() throws IOException {

        // On extrait les données du fichier reineCoordonnees.csv
        FileReader reineReader = new FileReader(coordReineCsv);
        BufferedReader reineBuffer = new BufferedReader(reineReader);
        String ligne = reineBuffer.readLine();
        while((ligne = reineBuffer.readLine()) != null){
            String[] data = ligne.split(",");
            Reine reine = new Reine();
            reine.setCoord_x(Integer.parseInt(data[0]));
            reine.setCoord_y(Integer.parseInt(data[1]));
            reineList.add(reine);
        }




         // On extrait les données du fichier batiments.csv
         // Comme certains bâtiments figurent dans le même test, on va les regrouper dans une liste de bâtiments
         // puis les stocker dans une hashmap où la clé associée sera le numéro du test.
        FileReader batimentsReader = new FileReader(batimentsFile);
        BufferedReader batimentsBuffer = new BufferedReader(batimentsReader);
        ligne = batimentsBuffer.readLine();
        List<Batiment> batimentList = new ArrayList<>();
        int id = 1;
        int lastInteger = 0;
        while((ligne = batimentsBuffer.readLine()) != null){
            String[] data = ligne.split(",");
            Batiment batiment = new Batiment(id++,Integer.parseInt(data[1]),Integer.parseInt(data[2]),1,false);
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

        reineBuffer.close();
        batimentsBuffer.close();
    }








    /**
     * Test paramétré où on essaye de voir si le bâtiment le plus proche de la reine est celui qu'on cherchait.
     * @param expectedIndex : l'indice du bâtiment le plus proche parmi les bâtiments de la liste.
     */
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/calculateMinimalDistanceTest/expectedIndex.csv", useHeadersInDisplayName = true)
    public void test(int expectedIndex){
        assertEquals(expectedIndex, Main.calculateMinimalDistance(reineList.get(numeroTest-1).getCoord_x(), reineList.get(numeroTest-1).getCoord_y(),batimentsHashMap.get(numeroTest++)));
    }







}


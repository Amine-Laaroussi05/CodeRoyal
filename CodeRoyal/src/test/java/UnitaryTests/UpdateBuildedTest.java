package UnitaryTests;

import CodeRoyal.Batiment;
import CodeRoyal.Reine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateBuildedTest {

    static HashMap<Integer,List<Batiment>> batimentsHashMap = new HashMap<>();
    static File batimentsFile = new File("src/main/resources/updateBuildedTest/batiments.csv");
    static String ligne;
    static int id;
    static int numeroTest = 1;
    Reine reine = new Reine();



    @BeforeAll
    public static void setUp() throws IOException {

        // Stockage des informations dans le fichier dans une hashmap
        FileReader batimentsReader = new FileReader(batimentsFile);
        BufferedReader batimentsBuffer = new BufferedReader(batimentsReader);
        batimentsBuffer.readLine();
        List<Batiment> batimentList = new ArrayList<>();
        int lastInteger = 0;
        while((ligne = batimentsBuffer.readLine()) != null){
            String[] data = ligne.split(",");
            Batiment batiment = new Batiment(id++,Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),Boolean.parseBoolean(data[4]));
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

    @ParameterizedTest
    @CsvFileSource(resources = "/updateBuildedTest/expected.csv", numLinesToSkip = 1)
    public void test(boolean expected1, boolean expected2, boolean expected3){
        reine.setBatimentList(batimentsHashMap.get(numeroTest));
        reine.updateBuilded();
        assertEquals(expected1, batimentsHashMap.get(numeroTest).get(0).isRecentlyBuilded());
        assertEquals(expected2, batimentsHashMap.get(numeroTest).get(1).isRecentlyBuilded());
        assertEquals(expected3, batimentsHashMap.get(numeroTest++).get(2).isRecentlyBuilded());
    }

}

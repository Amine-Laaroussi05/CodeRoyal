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

class MoveToAdverseBarrackV2Test {

    Reine reine = new Reine();
    static HashMap<Integer,List<Batiment>> batimentsHashmap = new HashMap<>();
    static File batimentsFile = new File("src/main/resources/moveToAdverseBarrackV2Test/batiments.csv");
    static int id = 1;

    static String ligne;
    static int numeroTest = 1;



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
            Batiment batiment = new Batiment(id++,Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),false);
            if(Integer.parseInt(data[0]) == lastInteger){
                batimentList.add(batiment);
            } else if(lastInteger == 0){
                batimentList.add(batiment);
                lastInteger++;
            } else{
                List<Batiment> batimentListCopy = new ArrayList<>(batimentList);
                batimentsHashmap.put(lastInteger,batimentListCopy);
                batimentList.clear();
                batimentList.add(batiment);
                lastInteger++;
            }
        }

        batimentsHashmap.put(lastInteger,batimentList);
        batimentsBuffer.close();
    }


    @ParameterizedTest(name = "coord_x = {0} , coord_y = {1}")
    @CsvFileSource(resources = "/moveToAdverseBarrackV2Test/reineCoordinates.csv", numLinesToSkip = 1)
    public void test(int coord_x, int coord_y, int expectedCoord_x, int expecetdCoord_y){
        reine.setCoord_x(coord_x);
        System.out.println("Reine coord_x = " + reine.getCoord_x());
        reine.setCoord_y(coord_y);
        System.out.println("Reine coord_y = " + reine.getCoord_y());
        for(Batiment batiment: batimentsHashmap.get(numeroTest)){
            System.out.println(batiment.toString());
        }
        reine.moveToAdverseBarrack(batimentsHashmap.get(numeroTest++));
        assertEquals(expectedCoord_x, reine.getCoord_x());
        assertEquals(expecetdCoord_y, reine.getCoord_y());
    }





}
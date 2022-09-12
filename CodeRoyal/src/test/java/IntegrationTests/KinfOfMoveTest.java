package IntegrationTests;


import CodeRoyal.Batiment;
import CodeRoyal.Reine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class KinfOfMoveTest {

    public static int numeroTest = 1;

    // Fichier csv contenant les coordonnées de la reine dont les données seront stockées dans la liste reineList après l'exécution de @BeforeAll
    public static File coordReineCsv = new File("src/main/resources/kinfOfMoveTest/reineCoordinates.csv");
    public static List<Reine> reineList = new ArrayList<>();
    @Spy
    public Reine reine;

    // Fichier csv contenant les coordonnées des bâtiments dont les données seront stockées dans la hashmap batimentsHashMap après l'exécution de @BeforeAll
    public static File batimentsFile = new File("src/main/resources/kinfOfMoveTest/batiments.csv");
    public static HashMap<Integer,List<Batiment>> batimentsHashMap = new HashMap<>();


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
        int lastNumeroTest = 0;
        while((ligne = batimentsBuffer.readLine()) != null){
            String[] data = ligne.split(",");
            Batiment batiment = new Batiment(Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),false);
            if(Integer.parseInt(data[0]) == lastNumeroTest){
                batimentList.add(batiment);
            } else if(lastNumeroTest == 0){
                batimentList.add(batiment);
                lastNumeroTest++;
            } else{
                List<Batiment> batimentListCopy = new ArrayList<>(batimentList);
                batimentsHashMap.put(lastNumeroTest,batimentListCopy);
                batimentList.clear();
                batimentList.add(batiment);
                lastNumeroTest++;
            }
        }

        batimentsHashMap.put(lastNumeroTest,batimentList);
        reineBuffer.close();
        batimentsBuffer.close();



    }

    @BeforeEach
    public void beforeTest(){
        MockitoAnnotations.openMocks(this);
    }



    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/kinfOfMoveTest/expectedMethod.csv", useHeadersInDisplayName = true)
    public void test(String expectedMethod){

        reine.setCoord_x(reineList.get(numeroTest-1).getCoord_x());
        reine.setCoord_y(reineList.get(numeroTest-1).getCoord_y());
        reine.setBatimentList(batimentsHashMap.get(numeroTest));
        reine.kinfOfMove(batimentsHashMap.get(numeroTest));
        if(expectedMethod.equals("moveToAdverseBarrack")) Mockito.verify(reine).moveToAdverseBarrack();
        else Mockito.verify(reine).Move();
        numeroTest++;

    }


    @RepeatedTest(5)
    public void emptyList(){
        Random random = new Random();
        reine.setCoord_x(random.ints(1,100,1900).iterator().nextInt());
        System.out.println("Reine coord_x = " + reine.getCoord_x());
        reine.setCoord_y(random.ints(1,100,900).iterator().nextInt());
        System.out.println("Reine coord_y = " + reine.getCoord_y());
        List<Batiment> batimentList = new ArrayList<>();
        reine.kinfOfMove(batimentList);
        Mockito.verify(reine).Move();
    }




}
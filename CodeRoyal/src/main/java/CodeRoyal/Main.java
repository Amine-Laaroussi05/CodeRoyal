package CodeRoyal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {


    /**
     * Permet de générer une liste aléatoire de bâtiments.
     * @param numberOfOnes : nombre de bâtiments avec un owner = 1.
     * @return Une liste de bâtiments.
     */
    public static List<Batiment> generateBatiments(int numberOfOnes){

        if(numberOfOnes < 0){
            throw new IllegalArgumentException("Le nombre de Owner de valeur 1 dans la liste doit être un nombre positif");
        }

        Random random = new Random();
        int numBatiment = random.ints(1,numberOfOnes,100).iterator().next();
        List<Batiment> batimentList = new ArrayList<>();
        int owner = -1;

        // Génère une liste d'id des bâtiments 2 à 2 distinctes.
        List<Integer> batimentsIdList = new ArrayList<>();
        for(int index=1; index<=numBatiment; index++) batimentsIdList.add(index);
        Collections.shuffle(batimentsIdList);

        // Génère une liste de nombres aléatoires 2 à 2 distinctes (qui seront les indices de la liste de bâtiments avec un owner = 1)
        List<Integer> numerosAleatoiresList = new ArrayList<>();
        for(int index=0; index<numBatiment; index++) numerosAleatoiresList.add(index);
        Collections.shuffle(numerosAleatoiresList);
        List<Integer> indicesAleatoires = new ArrayList<>();
        for(int index=0; index< numberOfOnes; index++) indicesAleatoires.add(numerosAleatoiresList.get(index));




        // Créer des bâtiments avec des données aléatoires
        for(int index = 0 ; index < numBatiment; index++){
            int coord_x = random.ints(1,100,1900).iterator().next();
            int coord_y = random.ints(1,100,980).iterator().next();

            // Si l'indice coincide avec un nombre de la liste numerosAleatoires, mettre le owner à 1 (pour bâtiment ennemi)
            if(indicesAleatoires.contains(index)) owner = 1;
            else owner = -1;

            // Crée le bâtiment et l'ajoute à la liste
            Batiment batiment = new Batiment(batimentsIdList.get(index),coord_x,coord_y,owner,false);
            batimentList.add(batiment);
        }
        return batimentList;
    }








    

    public static void main(String[] args) {


        Reine reine = new Reine();
        reine.touchedSiteInitializer();
        boolean haveMoved = false;


        for(int index = 1; index < 1300; index++){
            System.out.println("Tour : " + index);
            reine.updateSiteID();
            if(!haveMoved || reine.ownerSite() == 0){
            reine.Move();
            System.out.println("MOVE " + reine.getCoord_x() + " " + reine.getCoord_y());
            haveMoved = true;
            } else{
                reine.build();
                System.out.println("");
                haveMoved = false;
            }
            reine.setGold(reine.getGold()+ 10);
            System.out.println("gold: " + reine.getGold());
            System.out.println(reine.train());
            System.out.println("==================");
        }

    }





}

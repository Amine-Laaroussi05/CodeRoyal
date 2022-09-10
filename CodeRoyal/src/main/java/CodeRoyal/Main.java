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
        int numBatiment = random.ints(1,numberOfOnes+1,20).iterator().next();
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


    /**
     * Calcul la distance minimale qui sépare la reine et le bâtiment le plus proche de celle-ci.
     * @param coord_x : coordonnée x de la reine
     * @param coord_y : coordonnée y de la reine
     * @param batimentList : la liste des bâtiments
     * @return le bâtiment le plus proche
     */
    public static Batiment calculateminimalDistanceForAllBatiments(int coord_x, int coord_y,List<Batiment> batimentList) throws Exception {
        if(batimentList.size() > 0){
            double distanceMinimale = Math.sqrt(Math.pow(batimentList.get(0).getCoord_x() - coord_x,2) + Math.pow(batimentList.get(0).getCoord_y() - coord_y,2));
            int indexBatiment = 0;
            for(Batiment batiment: batimentList){
                double distance = Math.sqrt(Math.pow(batiment.getCoord_x() - coord_x,2) + Math.pow(batiment.getCoord_y() - coord_y,2));
                if(distance < distanceMinimale){
                    distanceMinimale = distance;
                    indexBatiment = batimentList.indexOf(batiment);
                }
            }
            return batimentList.get(indexBatiment);
        }
        else throw new Exception("La liste de bâtiments est vide");
    }







    /**
     * Calcule le point le plus proche en prenant compte de la position actuelle de la reine et de la liste de bâtiments avec un owner = 1.
     * @param coord_x : coordonnée sur l'axe des abscisses
     * @param coord_y : coordonnée sur l'axe des ordonnées
     * @param batimentList : La liste de bâtiments
     * @return l'indice du bâtiment ennemi le plus proche de la reine.
     */
    public static int calculateMinimalDistance(int coord_x, int coord_y,List<Batiment> batimentList){
        double distanceMin = -1;
        int indexBatiment = -1;
        int index = 0;
        for(Batiment batiment: batimentList){
            if(batiment.getOwner() == 1){
                double distance = Math.sqrt(Math.pow(coord_x -batiment.getCoord_x(),2) + Math.pow(coord_y - batiment.getCoord_y(),2));
                if(distance < distanceMin | distanceMin == -1){
                    distanceMin = distance;
                    indexBatiment = index;
                }
            }
            index++;
        }
        return indexBatiment;
    }




    /**
     * Compare la distance de deux bâtiments avec la reine
     * @param batiment1 : Bâtiment
     * @param batiment2 : Bâtiment
     * @return : la plus petite distance
     */
    public static int compareDistanceEntreDeuxBatimentsAvecLaReine(Batiment batiment1, Batiment batiment2, int coord_x, int coord_y){
        double distance1 = Math.sqrt(Math.pow(batiment1.getCoord_x() - coord_x,2) + Math.pow(batiment1.getCoord_y() - coord_y,2));
        double distance2 = Math.sqrt(Math.pow(batiment2.getCoord_x() - coord_x,2) + Math.pow(batiment2.getCoord_y() - coord_y,2));
        if(distance1 < distance2) return -1;
        else return 1;
    }













    

    public static void main(String[] args) throws Exception {

        List<Batiment> batimentList = generateBatiments(10);
        Reine reine = new Reine();
        for(int index = 1; index < 1300; index++){
            System.out.println("Tour : " + index);
            System.out.println("Reine coord_x = " + reine.getCoord_x());
            System.out.println("Reine coord_y = " + reine.getCoord_y());
            System.out.println("Batiment coord_x = " + calculateminimalDistanceForAllBatiments(reine.getCoord_x(),reine.getCoord_y(),batimentList).getCoord_x());
            System.out.println("Batiment coord_y = " + calculateminimalDistanceForAllBatiments(reine.getCoord_x(),reine.getCoord_y(),batimentList).getCoord_y());
            reine.setGold(reine.getGold() + 10);
            reine.updateBuilded(batimentList);
            reine.moveOrBuild(batimentList);
            System.out.println(reine.train(batimentList));
        }



//        Reine reine = new Reine();
//        reine.touchedSiteInitializer();
//        boolean haveMoved = false;


//        for(int index = 1; index < 1300; index++){
//            System.out.println("Tour : " + index);
//            reine.updateSiteID();
//            if(!haveMoved || reine.ownerSite() == 0){
//            reine.Move();
//            System.out.println("MOVE " + reine.getCoord_x() + " " + reine.getCoord_y());
//            haveMoved = true;
//            } else{
////                reine.build();
//                System.out.println("");
//                haveMoved = false;
//            }
//            reine.setGold(reine.getGold()+ 10);
//            System.out.println("gold: " + reine.getGold());
//            System.out.println(reine.train());
//            System.out.println("==================");
//        }

    }





}

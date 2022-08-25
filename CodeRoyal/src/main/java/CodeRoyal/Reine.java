package CodeRoyal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reine {




    private boolean choix_direction = true; // true = horizontale  //  false = verticale

    private boolean direction_horizontale = true; // true = droite // false = gauche

    private boolean direction_verticale = true; // true = bas // false = haut

    private int coord_x = 0;

    private int coord_y = 0;

    private List<List<Integer>> touchedSite = new ArrayList<>();

    private int gold = 100;

    private HashMap<Integer, List<String>> sitesID = new HashMap<>();

    private int compteurKnight = 0;













    /**
     * Déplacement de la reine
     */
    public void Move(){


//            Vérifie si on est dans le bon carré de taille 1920x1000
        if(this.coord_x + 60 > 1920 && this.direction_horizontale){
            this.direction_horizontale = false;
            this.choix_direction = false;
        } else if(this.coord_x - 60 < 0 && !this.direction_horizontale){
            this.direction_horizontale = true;
            this.choix_direction = false;
        }
        if(this.coord_y + 60 > 1000 && this.direction_verticale){
            this.direction_verticale = false;
        } else if(this.coord_y - 60 < 0 && !this.direction_verticale){
            this.direction_verticale = true;
        }

//          La reine se déplace horizontalement jusqu'à arriver au bord, puis descend ou monte de 60 et se déplace à nouveau horizontalement dans l'autre sens
        if(this.choix_direction){
            if(this.direction_horizontale){
                this.coord_x += 60;
            } else{
                this.coord_x -= 60;
            }
        } else{
            if(this.direction_verticale){
                this.coord_y += 60;
            } else{
                this.coord_y -= 60;
            }
            this.choix_direction = true;
        }
    }









    /**
     * Pour déplacer la reine vers le bâtiment adverse le plus proche.
     * @param batimentList : La liste des bâtiments présents sur la carte.
     */
    public void moveToAdverseBarrack(List<Batiment> batimentList){
        int indexBatiment = Main.calculateMinimalDistance(coord_x,coord_y,batimentList);
        if(indexBatiment != -1){
            coord_x = batimentList.get(indexBatiment).getCoord_x();
            coord_y = batimentList.get(indexBatiment).getCoord_y();
        }
    }








    /**
     * Détermine si la méthode utilisée est build() ou kindOfMove().
     * @param batimentList : la liste des bâtiments présents sur la carte.
     */
    public void moveOrBuild(List<Batiment> batimentList){
        for(Batiment batiment: batimentList) System.out.println(batiment.toString());
        if(batimentList.size() > 0){
            System.out.println("IF---------> Liste length: " + batimentList.size());
            Batiment batiment = Main.calculateminimalDistanceForAllBatiments(coord_x,coord_y,batimentList);
            assert batiment != null;
            System.out.println(batiment.toString());
            double distance = Math.sqrt(Math.pow(coord_x - batiment.getCoord_x(),2) + Math.pow(coord_y - batiment.getCoord_y(),2));
            System.out.println("distance du bâtiment: " + distance);
            if(distance <= 30 & batiment.getOwner() != 0) {
                System.out.println("builded!");
                build(batimentList);
            }
            else{
                System.out.println("movement!");
                kinfOfMove(batimentList);
            }
        }
        else{
            kinfOfMove(batimentList);
            System.out.println("movement with empty list");
        }

    }










    /**
     * Permet à la reine de déterminer quel type de mouvement utilisé entre moveToAdverseBarrack() et move().
     * @param batimentList : La liste des bâtiments présents sur la carte.
     */
    public void kinfOfMove(List<Batiment> batimentList){
        int indexBatimentPlusProche = Main.calculateMinimalDistance(coord_x,coord_y,batimentList);
        if( indexBatimentPlusProche == -1){
            Move();
        } else{
            double distanceReineBatimentPlusProche = Math.sqrt(Math.pow(batimentList.get(indexBatimentPlusProche).getCoord_x() - coord_x, 2)
                    + Math.pow(batimentList.get(indexBatimentPlusProche).getCoord_y() - coord_y, 2));
            if(distanceReineBatimentPlusProche < 30) Move();
            else moveToAdverseBarrack(batimentList);
        }
    }










    /**
     * Permet d'initialiser touchedSite selon les futurs déplacements de la reine.
     */
    public void touchedSiteInitializer(){

        for(int index = 0; index <= 560; index++){
            List<Integer> integerList = new ArrayList<>();
            integerList.add(-1);
            integerList.add(this.coord_x);
            integerList.add(this.coord_y);
            this.touchedSite.add(integerList);
            this.Move();
        }

        this.coord_x = 0;
        this.coord_y = 0;
    }












    /**
     * Vérifie si un bâtiment a été construit sur le site ou non.
     * @return -1 ou 0 selon si oui ou non il y a eu un site construit.
     */
    public int ownerSite(){
        int indice = 0;
        for(int index = 0; index <= 560; index++){
            if(this.touchedSite.get(index).get(1) == this.coord_x && this.touchedSite.get(index).get(2) == this.coord_y){
                indice =  this.touchedSite.get(index).get(0);
                break;
            }
        }
        return indice;
    }











    /**
     * Détermine l'indice dans touchedSite où se trouve coord_x et coord_y.
     */
    public int indexTouchedSite(){
        int indice = 0;
        for(int index = 0; index <= 560; index++){
            if(this.touchedSite.get(index).get(1) == this.coord_x && this.touchedSite.get(index).get(2) == this.coord_y){
                indice = index;
                break;
            }
        }
        return indice;
    }






    /**
     * Cette méthode permet de changer les valeurs de siteID qui sont à -1 en des valeurs 0.
     * Le besoin d'une telle méthode réside dans le fait d'éviter de TRAIN l'armée dans le même tour que le bâtiment a été BUILD.
    * On affectera la valeur -1 au siteID du bâtiment quand celui-ci a été construit dans le tour présent.
    * Au tour suivant, la valeur sera à 0 pour signifier que l'armée de ce bâtiment est prête à être TRAIN.
    * Quand l'armée est TRAIN, la valeur sera à 1.
     *
    */
    public void updateSiteID(){

        for(int key: sitesID.keySet()){
            if(sitesID.get(key).get(1).equalsIgnoreCase("-1")){
                List<String> siteIdentifier = new ArrayList<>();
                siteIdentifier.add("K");
                siteIdentifier.add("0");
                sitesID.replace(key,siteIdentifier);
            }
        }
    }








    /**
     * Construction d'un bâtiment.
     * La méthode affiche le BUILD selon s'il n'y a pas de bâtiment allié de construit sur le site.
     */
    public void build(List<Batiment> batimentList){

//        List<Integer> coordonees = new ArrayList<>();
//        coordonees.add(0);
//        coordonees.add(this.coord_x);
//        coordonees.add(this.coord_y);



//        if(ownerSite() != 0){
//            this.setTouchedSiteArray(indexTouchedSite(), coordonees);
//            List<String> siteIdentifier = new ArrayList<>();
//            siteIdentifier.add("K");
//            siteIdentifier.add("-1");
//            sitesID.put(indexTouchedSite(),siteIdentifier);
////            System.out.println("Hashmap: " + sitesID);
//            System.out.print("BUILD " + indexTouchedSite() + " " + barracks());
//        }

        Batiment batimentPlusProche = Main.calculateminimalDistanceForAllBatiments(coord_x,coord_y,batimentList);


        assert batimentPlusProche != null;
        System.out.print("BUILD " + batimentPlusProche.getId() + " " + barracks());



    }











    /**
     * Méthode Train qui permet d'entraîner les soldats si on a suffisamment de gold en possession.
     * L'armée de KNIGHT est construite une fois qu'on a 80 gold,
     * et l'armée ARCHER une fois qu'on a 100 gold.
     * On utilise le cycle suivant d'entraînement : 5 KNIGHT et 4 ARCHER,
     * avec à chaque fois un KNIGHT puis un ARCHER à l'exception que : une fois arriver à 4 KNIGHT,
     * le prochain entraînement sera aussi celui de KNIGHT, et après celui d'ARCHER de sorte à obtenir la configuration 5|4.
     * Un attribut compteur_K permettra de tenir compte des entraînements type KNIGHT.
     *
     */
    public String train(){
        List<String> siteIdentifier = new ArrayList<>();
        for(int key: sitesID.keySet()){
            if(sitesID.get(key).get(1).equalsIgnoreCase("0")){
                if(sitesID.get(key).get(0).equalsIgnoreCase("K") & gold >= 80){
                    gold -= 80;
                    siteIdentifier.add("K");
                    siteIdentifier.add("1");
                    sitesID.replace(key,siteIdentifier);
                    return "TRAIN " + key;
                } else if(sitesID.get(key).get(0).equalsIgnoreCase("A") & gold >= 100){
                    gold -= 100;
                    siteIdentifier.add("A");
                    siteIdentifier.add("1");
                    sitesID.replace(key,siteIdentifier);
                    return "TRAIN " + key;
                }

            } else{
                continue;
            }
        }
        return "TRAIN";
    }








    /**
     * La méthode BARRACKS permet de spécifier quel genre d'unité le bâtiment construit avec BUILD.
     * On utilisera ma configuration suivante : KNIGHT puis ARCHER. Une fois arrivé à 4 KNIGHT, la prochaine unité sera
     * KNIGHT avant de faire un ARCHER, pour arriver à la configuration 5 KNIGHT et 4 ARCHER.
     * @return a String BARRACKS-{typeArmy}
     */
    public String barracks(){
        // vérifie que le compteur est bien compris entre 0 et 8
        if(this.compteurKnight >= 0 & this.compteurKnight <= 8){
            // Si compteur modulo 2, retourne KNIGHT, sinon retourne ARCHER
            if(this.compteurKnight % 2 == 0){
                // Si compteur égal à 8, réinitialise le compteur à 0
                if(this.compteurKnight == 8){
                    this.compteurKnight = 0;
                } else{
                    this.compteurKnight++;
                }
                return "BARRACKS-KNIGHT";
            } else {
                this.compteurKnight++;
                return "BARRACKS-ARCHER";
            }
        } else{
            throw new IllegalArgumentException("Le compteur doit être un entier compris entre 0 et 8");
        }
    }





















    /**
     * Getters & Setters
     * @return
     */
    public boolean isChoix_direction() {
        return choix_direction;
    }

    public void setChoix_direction(boolean choix_direction) {
        this.choix_direction = choix_direction;
    }

    public boolean isDirection_horizontale() {
        return direction_horizontale;
    }

    public void setDirection_horizontale(boolean direction_horizontale) {
        this.direction_horizontale = direction_horizontale;
    }

    public boolean isDirection_verticale() {
        return direction_verticale;
    }

    public void setDirection_verticale(boolean direction_verticale) {
        this.direction_verticale = direction_verticale;
    }

    public int getCoord_x() {
        return coord_x;
    }

    public void setCoord_x(int coord_x) {
        this.coord_x = coord_x;
    }

    public int getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(int coord_y) {
        this.coord_y = coord_y;
    }

    public List<List<Integer>> getTouchedSite() {
        return touchedSite;
    }

    public void setTouchedSite(List<List<Integer>> touchedSite) {
        this.touchedSite = touchedSite;
    }

    public void setTouchedSiteArray(int index, List<Integer> ElementOfTouchedSite){
        this.touchedSite.set(index, ElementOfTouchedSite);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public HashMap<Integer, List<String>> getSitesID() {
        return sitesID;
    }

    public void setSitesID(HashMap<Integer, List<String>> sitesID) {
        this.sitesID = sitesID;
    }


    public int getCompteurKnight() {
        return compteurKnight;
    }

    public void setCompteurKnight(int compteurKnight) {
        this.compteurKnight = compteurKnight;
    }
}

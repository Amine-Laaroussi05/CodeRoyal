package CodeRoyal;

import java.util.ArrayList;
import java.util.List;

public class Reine {




    private boolean choix_direction = true; // true = horizontale  //  false = verticale

    private boolean direction_horizontale = true; // true = droite // false = gauche

    private boolean direction_verticale = true; // true = bas // false = haut

    private int coord_x = 0;

    private int coord_y = 0;

    private int gold = 100;

    private int compteurKnight = 0;
    private List<Batiment> batimentList;













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

        System.out.println("MOVE " + coord_x + " " + coord_y);
    }










    /**
     * Pour déplacer la reine vers le bâtiment adverse le plus proche.
     */
    public void moveToAdverseBarrack(){
        int indexBatiment = Main.calculateMinimalDistance(coord_x,coord_y,batimentList); // Indice du bâtiment ennemi le plus proche de la reine (-1 s'il n'y a aucun bâtiment ennemi)
        if(indexBatiment != -1){
            if(batimentList.get(indexBatiment).getCoord_y() > coord_y + 60) coord_y += 60;
            else if(batimentList.get(indexBatiment).getCoord_y() > coord_y) coord_y = batimentList.get(indexBatiment).getCoord_y();
            else if(batimentList.get(indexBatiment).getCoord_y() < coord_y - 60) coord_y -= 60;
            else if(batimentList.get(indexBatiment).getCoord_y() < coord_y) coord_y = batimentList.get(indexBatiment).getCoord_y();

            if(batimentList.get(indexBatiment).getCoord_x() > coord_x + 60) coord_x += 60;
            else if(batimentList.get(indexBatiment).getCoord_x() > coord_x) coord_x = batimentList.get(indexBatiment).getCoord_x();
            else if(batimentList.get(indexBatiment).getCoord_x() < coord_x - 60 ) coord_x -= 60;
            else if(batimentList.get(indexBatiment).getCoord_x() < coord_x) coord_x = batimentList.get(indexBatiment).getCoord_x();

            System.out.println("MOVE " + batimentList.get(indexBatiment).getCoord_x() + " " + batimentList.get(indexBatiment).getCoord_y());
        }
    }






    /**
     * Détermine si la méthode utilisée est build() ou kindOfMove().
     */
    public void moveOrBuild() throws Exception {
        if(batimentList.size() > 0){
            Batiment batiment = Main.calculateminimalDistanceForAllBatiments(coord_x,coord_y,batimentList);
            double distance = Math.sqrt(Math.pow(coord_x - batiment.getCoord_x(),2) + Math.pow(coord_y - batiment.getCoord_y(),2));
            if(distance <= 30 & batiment.getOwner() != 0) {
                build();
            }
            else{
                kinfOfMove();
            }
        }
        else{
            kinfOfMove();
        }

    }










    /**
     * Permet à la reine de déterminer quel type de mouvement utilisé entre moveToAdverseBarrack() et move().
     */
    public void kinfOfMove(){
        int indexBatimentPlusProche = Main.calculateMinimalDistance(coord_x,coord_y,batimentList);
        if( indexBatimentPlusProche == -1){
            Move();
        } else{
            double distanceReineBatimentPlusProche = Math.sqrt(Math.pow(batimentList.get(indexBatimentPlusProche).getCoord_x() - coord_x, 2)
                    + Math.pow(batimentList.get(indexBatimentPlusProche).getCoord_y() - coord_y, 2));
            if(distanceReineBatimentPlusProche < 30) Move();
            else moveToAdverseBarrack();
        }
    }





    /**
     * Construction d'un bâtiment.
     * La méthode affiche le BUILD selon s'il n'y a pas de bâtiment allié de construit sur le site.
     */
    public void build() throws Exception {
        Batiment batimentPlusProche = Main.calculateminimalDistanceForAllBatiments(coord_x,coord_y,batimentList);

        System.out.println("BUILD " + batimentPlusProche.getId() + " " + barracks(batimentPlusProche));
        batimentPlusProche.setRecentlyBuilded(true);
        batimentPlusProche.setOwner(0);
    }




    /**
     * La méthode `updateBuilded` permet de mettre à jour le statut (attribut) `recentlyBuilded` d'un bâtiment en `false`.
     * Le besoin d'une telle méthode réside dans le fait de prendre en compte l'état d'un bâtiment
     * (récemment builded ou non) pour éviter de `Build` le bâtiment et `Train` une armée du bâtiment
     * dans le même tour du jeu.
     */
    public void updateBuilded(){
        for(Batiment batiment: batimentList) if(batiment.getOwner() == 0) batiment.setRecentlyBuilded(false);
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
    public String train() throws Exception {
        // Une liste de bâtiments qui ne contient que les bâtiments avec un owner = 0 (bâtiments alliés)
        List<Batiment> batimentListOwned = new ArrayList<>();
        for(Batiment batiment: batimentList){
            if(batiment.getOwner() == 0) batimentListOwned.add(batiment);
        }

        // On ordonne la liste selon la plus petite distance avec la reine (on cherche à entrainer l'armée dont le bâtiment est le plus proche de la reine)
        batimentListOwned.sort((batiment1, batiment2) -> (int) Main.compareDistanceEntreDeuxBatimentsAvecLaReine(batiment1,batiment2, coord_x,coord_y));

        // On lance le cycle d'entrainements des armées
        armyTrain();

        // Si on n'a pas assez d'or, on ne fait aucun entrainement
        if(gold < 80) return "TRAIN";

        // On vérifie s'il y a un bâtiment disponible (armyTrained = 0) pour pouvoir lance l'entrainement d'une armée
        for(Batiment batiment: batimentListOwned){
            if(batiment.getArmyTrained() == 0 & batiment.getArmyType() == 'K' & !batiment.isRecentlyBuilded()){
                batiment.setArmyTrained(1);
                gold -= 80;
                return "TRAIN " + batiment.getId();
            } else if(batiment.getArmyTrained() == 0 & batiment.getArmyType() == 'A' & gold >= 100 & !batiment.isRecentlyBuilded()){
                batiment.setArmyTrained(1);
                gold -= 100;
                return "TRAIN " + batiment.getId();
            }
            else if(batiment.getArmyTrained() == 0 & batiment.getArmyType() == 'A' & gold < 100) return "TRAIN";
        }
        // S'il n'y a pas de possibilité d'entrainement (par exemple une liste vide, ou des bâtiments avec que des archers et l'or en possession est < 100)
        return "TRAIN";
    }









    /**
     * Poursuit le cycle d'entrainement des armées qui sont en train d'être entrainées.
     */
    public void armyTrain(){
        for(Batiment batiment: batimentList){
            if(batiment.getArmyTrained() > 0 & batiment.getArmyTrained() < 10 & batiment.getOwner() == 0) batiment.setArmyTrained(batiment.getArmyTrained() +1);
            else if(batiment.getArmyTrained() == 10 & batiment.getOwner() == 0) batiment.setArmyTrained(0);
        }
    }









    /**
     * La méthode BARRACKS permet de spécifier quel genre d'unité le bâtiment construit avec BUILD contiendra comme armée.
     * On utilisera ma configuration suivante : KNIGHT puis ARCHER. Une fois arrivé à 4 KNIGHT, la prochaine unité sera
     * KNIGHT avant de faire un ARCHER, pour arriver à la configuration 5 KNIGHT et 4 ARCHER.
     * @return a String BARRACKS-{typeArmy}
     */
    public String barracks(Batiment batiment){
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
                batiment.setArmyType('K');
                return "BARRACKS-KNIGHT";
            } else {
                this.compteurKnight++;
                batiment.setArmyType('A');
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getCompteurKnight() {
        return compteurKnight;
    }

    public void setCompteurKnight(int compteurKnight) {
        this.compteurKnight = compteurKnight;
    }

    public List<Batiment> getBatimentList() {
        return batimentList;
    }

    public void setBatimentList(List<Batiment> batimentList) {
        this.batimentList = batimentList;
    }
}

package CodeRoyal;

public class Batiment {

    // Attributs
    private int id;
    private int coord_x;
    private int coord_y;
    private int owner = -1;
    private int armyTrained = 0;
    private boolean builded = false;


    // Constructeur

    public Batiment(int id, int coord_x, int coord_y, int owner, boolean builded) {
        if(coord_x < 0 | coord_x > 1920){
            throw new IllegalArgumentException("La coordonnée x doit être comprises entre 0 et 1920");
        }
        if(coord_y < 0 | coord_y > 1000){
            throw new IllegalArgumentException("La coordonnée y doit être comprise entre 0 et 1000");
        }
        if(owner < -1 | owner > 1){
            throw new IllegalArgumentException("La valeur du owner doit être comprise entre -1 et 1");
        }
        this.id = id;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.owner = owner;
        this.builded = builded;
    }


    // Getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoord_x() {
        return coord_x;
    }

    public void setCoord_x(int coord_x) {
        if(coord_x < 0 | coord_x > 1920){
            throw new IllegalArgumentException("La coordonnée x doit être comprises entre 0 et 1920");
        }
        this.coord_x = coord_x;
    }

    public int getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(int coord_y) {
        if(coord_y < 0 | coord_y > 1000){
            throw new IllegalArgumentException("La coordonnée y doit être comprise entre 0 et 1000");
        }
        this.coord_y = coord_y;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        if(owner < -1 | owner > 1){
            throw new IllegalArgumentException("La valeur du owner doit être comprise entre -1 et 1");
        }
        this.owner = owner;
    }

    public int getArmyTrained() {
        return armyTrained;
    }


    public boolean isBuilded() {
        return builded;
    }

    public void setBuilded(boolean builded) {
        this.builded = builded;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Batiment{");
        sb.append("id=").append(id);
        sb.append(", coord_x=").append(coord_x);
        sb.append(", coord_y=").append(coord_y);
        sb.append(", owner=").append(owner);
        sb.append(", armyTrained=").append(armyTrained);
        sb.append(", builded=").append(builded);
        sb.append('}');
        return sb.toString();
    }
}

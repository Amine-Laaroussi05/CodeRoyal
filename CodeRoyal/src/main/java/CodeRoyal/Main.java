package CodeRoyal;

public class Main {



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

package CodeRoyal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TouchedSiteInitializerTest {



    @Test
    public void premier_indice(){
        Reine reine = new Reine();
        reine.touchedSiteInitializer();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(-1);
        integerList.add(0);
        integerList.add(0);
        assertEquals(integerList,reine.getTouchedSite().get(0));
    }

    @Test
    public void deuxieme_indice(){
        Reine reine = new Reine();
        reine.touchedSiteInitializer();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(-1);
        integerList.add(60);
        integerList.add(0);
        assertEquals(integerList,reine.getTouchedSite().get(1));
    }

    @Test
    public void dernier_indice(){
        Reine reine = new Reine();
        reine.touchedSiteInitializer();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(-1);
        integerList.add(1920);
        integerList.add(960);
        assertEquals(integerList,reine.getTouchedSite().get(reine.getTouchedSite().size() - 1));
    }

    @Test
    public void milieu_indice(){
        Reine reine = new Reine();
        reine.touchedSiteInitializer();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(-1);
        integerList.add(480);
        integerList.add(660);
        assertEquals(integerList,reine.getTouchedSite().get(387));
    }

}
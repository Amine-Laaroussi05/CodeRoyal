package UnitaryTests;

import CodeRoyal.Reine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UpdateSiteIDTest {

    Reine reine = new Reine();

    @BeforeEach
    public void setup(){
        reine.touchedSiteInitializer();
    }


    @Test
    public void One_Value(){
        HashMap<Integer, List<String>> hashMapActuel = new HashMap<>();
        HashMap<Integer,List<String>> hashMapExpected = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("-1");

        hashMapActuel.put(1,siteIdentifier);
        reine.setSitesID(hashMapActuel);

        List<String> siteIdentifier1 = new ArrayList<>();
        siteIdentifier1.add("K");
        siteIdentifier1.add("0");

        hashMapExpected.put(1,siteIdentifier1);

        reine.updateSiteID();

        assertEquals(hashMapExpected,reine.getSitesID());
    }

    @Test
    public void One_Value_Without_update(){
        HashMap<Integer,List<String>> hashMapActuel = new HashMap<>();
        HashMap<Integer,List<String>> hashMapExpected = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");

        hashMapActuel.put(1,siteIdentifier);
        reine.setSitesID(hashMapActuel);


        hashMapExpected.put(1,siteIdentifier);

        reine.updateSiteID();

        assertEquals(hashMapExpected,reine.getSitesID());
    }

    @Test
    public void Two_values(){
        HashMap<Integer,List<String>> hashMapActuel = new HashMap<>();
        HashMap<Integer,List<String>> hashMapExpected = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("-1");

        hashMapActuel.put(1,siteIdentifier);
        hashMapActuel.put(4,siteIdentifier);
        reine.setSitesID(hashMapActuel);

        List<String> siteIdentifier1 = new ArrayList<>();
        siteIdentifier1.add("K");
        siteIdentifier1.add("0");
        hashMapExpected.put(1,siteIdentifier1);
        hashMapExpected.put(4,siteIdentifier1);

        reine.updateSiteID();

        assertEquals(hashMapExpected,reine.getSitesID());
    }

    @Test
    public void LotOf_values(){
        HashMap<Integer,List<String>> hashMapActuel = new HashMap<>();
        HashMap<Integer,List<String>> hashMapExpected = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");
        List<String> siteIdentifier1 = new ArrayList<>();
        siteIdentifier1.add("K");
        siteIdentifier1.add("-1");

        hashMapActuel.put(1,siteIdentifier);
        hashMapActuel.put(4,siteIdentifier1);
        hashMapActuel.put(35,siteIdentifier);
        hashMapActuel.put(34,siteIdentifier1);
        hashMapActuel.put(8,siteIdentifier1);
        hashMapActuel.put(7,siteIdentifier);
        hashMapActuel.put(100,siteIdentifier1);
        hashMapActuel.put(123,siteIdentifier1);
        hashMapActuel.put(740,siteIdentifier);
        hashMapActuel.put(96,siteIdentifier1);
        reine.setSitesID(hashMapActuel);

        hashMapExpected.put(1,siteIdentifier);
        hashMapExpected.put(4,siteIdentifier);
        hashMapExpected.put(35,siteIdentifier);
        hashMapExpected.put(34,siteIdentifier);
        hashMapExpected.put(8,siteIdentifier);
        hashMapExpected.put(7,siteIdentifier);
        hashMapExpected.put(100,siteIdentifier);
        hashMapExpected.put(123,siteIdentifier);
        hashMapExpected.put(740,siteIdentifier);
        hashMapExpected.put(96,siteIdentifier);

        reine.updateSiteID();

        assertEquals(hashMapExpected,reine.getSitesID());
    }



}
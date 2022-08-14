package CodeRoyal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {


    Reine reine = new Reine();


    // Verify the correct output : TRAIN-{sitesID}
    @Test
    public void BuildNow_WithoutGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("-1");
        sitesID.put(1, siteIdentifier);
        reine.setSitesID(sitesID);

        assertEquals("TRAIN", reine.train());
    }

    @Test
    public void AfterBuild_WithoutGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");
        sitesID.put(1, siteIdentifier);
        reine.setSitesID(sitesID);

        assertEquals("TRAIN 1", reine.train());
    }

    @Test
    public void AfterBuild_WithoutGold_Variant() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");
        sitesID.put(25, siteIdentifier);
        reine.setSitesID(sitesID);

        assertEquals("TRAIN 25", reine.train());
    }

    @Test
    public void TwoValues_WithoutGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");
        sitesID.put(5, siteIdentifier);

        List<String> siteIdentifier1 = new ArrayList<>();
        siteIdentifier1.add("A");
        siteIdentifier1.add("-1");
        sitesID.put(12, siteIdentifier1);

        reine.setSitesID(sitesID);

        assertEquals("TRAIN 5", reine.train());
    }

    @Test
    public void ThreeValues_WithoutGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("1");
        sitesID.put(12, siteIdentifier);

        List<String> siteIdentifier1 = new ArrayList<>();
        siteIdentifier1.add("A");
        siteIdentifier1.add("0");
        sitesID.put(16, siteIdentifier1);

        List<String> siteIdentifier2 = new ArrayList<>();
        siteIdentifier2.add("K");
        siteIdentifier2.add("-1");
        sitesID.put(18, siteIdentifier2);

        reine.setSitesID(sitesID);

        assertEquals("TRAIN 16", reine.train());
    }

    @Test
    public void MultipleValues_WithoutGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");
        sitesID.put(64, siteIdentifier);

        List<String> siteIdentifier1 = new ArrayList<>();
        siteIdentifier1.add("A");
        siteIdentifier1.add("0");
        sitesID.put(162, siteIdentifier1);

        List<String> siteIdentifier2 = new ArrayList<>();
        siteIdentifier2.add("K");
        siteIdentifier2.add("-1");
        sitesID.put(81, siteIdentifier2);

        List<String> siteIdentifier3 = new ArrayList<>();
        siteIdentifier3.add("K");
        siteIdentifier3.add("0");
        sitesID.put(87, siteIdentifier3);

        List<String> siteIdentifier4 = new ArrayList<>();
        siteIdentifier4.add("K");
        siteIdentifier4.add("0");
        sitesID.put(32, siteIdentifier4);

        List<String> siteIdentifier5 = new ArrayList<>();
        siteIdentifier5.add("K");
        siteIdentifier5.add("1");
        sitesID.put(125, siteIdentifier5);

        List<String> siteIdentifier6 = new ArrayList<>();
        siteIdentifier6.add("A");
        siteIdentifier6.add("1");
        sitesID.put(157, siteIdentifier6);

        List<String> siteIdentifier7 = new ArrayList<>();
        siteIdentifier7.add("K");
        siteIdentifier7.add("1");
        sitesID.put(72, siteIdentifier7);

        List<String> siteIdentifier8 = new ArrayList<>();
        siteIdentifier8.add("K");
        siteIdentifier8.add("1");
        sitesID.put(119, siteIdentifier8);

        List<String> siteIdentifier9 = new ArrayList<>();
        siteIdentifier9.add("A");
        siteIdentifier9.add("0");
        sitesID.put(29, siteIdentifier9);

        List<String> siteIdentifier10 = new ArrayList<>();
        siteIdentifier10.add("K");
        siteIdentifier10.add("0");
        sitesID.put(104, siteIdentifier10);

        List<String> siteIdentifier11 = new ArrayList<>();
        siteIdentifier11.add("A");
        siteIdentifier11.add("0");
        sitesID.put(124, siteIdentifier11);

        List<String> siteIdentifier12 = new ArrayList<>();
        siteIdentifier12.add("K");
        siteIdentifier12.add("0");
        sitesID.put(23, siteIdentifier12);

        reine.setSitesID(sitesID);

        assertEquals("TRAIN 64", reine.train());
    }


    @Test
    public void EmptyHashmap() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        reine.setSitesID(sitesID);

        assertEquals("TRAIN", reine.train());
    }


    // Verify the update of gold
    @Test
    public void BuildNow_WithGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("-1");
        sitesID.put(1, siteIdentifier);
        reine.setSitesID(sitesID);
        reine.setGold(100);
        reine.train();

        assertEquals(100, reine.getGold());
    }

    @Test
    public void AfterBuild_WithGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");
        sitesID.put(1, siteIdentifier);
        reine.setSitesID(sitesID);
        reine.setGold(100);
        reine.train();

        assertEquals(20, reine.getGold());
    }

    @Test
    public void AfterBuild_WithGold_Archer() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("A");
        siteIdentifier.add("0");
        sitesID.put(1, siteIdentifier);
        reine.setSitesID(sitesID);
        reine.setGold(100);
        reine.train();

        assertEquals(0, reine.getGold());
    }

    @Test
    public void TwoValues_WithGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");
        sitesID.put(5, siteIdentifier);

        List<String> siteIdentifier1 = new ArrayList<>();
        siteIdentifier1.add("A");
        siteIdentifier1.add("-1");
        sitesID.put(12, siteIdentifier1);

        reine.setSitesID(sitesID);
        reine.setGold(170);
        reine.train();

        assertEquals(90, reine.getGold());
    }

    @Test
    public void InsufficientGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");
        sitesID.put(1, siteIdentifier);
        reine.setSitesID(sitesID);
        reine.setGold(50);
        reine.train();

        assertEquals(50, reine.getGold());
    }


















    // Verify the update of sitesID
    @Test
    public void AfterTrain_BuildNow() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("-1");
        sitesID.put(1, siteIdentifier);
        reine.setSitesID(sitesID);
        reine.train();
        List<String> expectedSiteIdentifier = new ArrayList<>();
        expectedSiteIdentifier.add("K");
        expectedSiteIdentifier.add("-1");
        HashMap<Integer, List<String>> expectedsitesID = new HashMap<>();
        expectedsitesID.put(1, expectedSiteIdentifier);
        assertEquals(expectedsitesID, reine.getSitesID());
    }

    @Test
    public void AfterTrain_AfterBuild_WithoutGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");
        sitesID.put(1, siteIdentifier);
        reine.setSitesID(sitesID);
        reine.train();
        List<String> expectedSiteIdentifier = new ArrayList<>();
        expectedSiteIdentifier.add("K");
        expectedSiteIdentifier.add("1");
        HashMap<Integer, List<String>> expectedsitesID = new HashMap<>();
        expectedsitesID.put(1, expectedSiteIdentifier);
        assertEquals(expectedsitesID, reine.getSitesID());
    }


    @Test
    public void After_Train_AfterBuild_WithoutGold_Variant() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");
        sitesID.put(25, siteIdentifier);
        reine.setSitesID(sitesID);
        reine.train();
        List<String> expectedSiteIdentifier = new ArrayList<>();
        expectedSiteIdentifier.add("K");
        expectedSiteIdentifier.add("1");
        HashMap<Integer, List<String>> expectedsitesID = new HashMap<>();
        expectedsitesID.put(25, expectedSiteIdentifier);
        assertEquals(expectedsitesID, reine.getSitesID());
    }

    @Test
    public void AfterTrain_TwoValues_WithoutGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("0");
        sitesID.put(5, siteIdentifier);

        List<String> siteIdentifier1 = new ArrayList<>();
        siteIdentifier1.add("A");
        siteIdentifier1.add("-1");
        sitesID.put(12, siteIdentifier1);

        reine.setSitesID(sitesID);
        reine.train();
        List<String> expectedSiteIdentifier = new ArrayList<>();
        expectedSiteIdentifier.add("K");
        expectedSiteIdentifier.add("1");
        List<String> expectedSiteIdentifier1 = new ArrayList<>();
        expectedSiteIdentifier1.add("A");
        expectedSiteIdentifier1.add("-1");
        HashMap<Integer, List<String>> expectedsitesID = new HashMap<>();
        expectedsitesID.put(5, expectedSiteIdentifier);
        expectedsitesID.put(12, expectedSiteIdentifier1);
        assertEquals(expectedsitesID, reine.getSitesID());

    }


    @Test
    public void AfterTrain_ThreeValues_WithoutGold() {
        HashMap<Integer, List<String>> sitesID = new HashMap<>();
        List<String> siteIdentifier = new ArrayList<>();
        siteIdentifier.add("K");
        siteIdentifier.add("1");
        sitesID.put(12, siteIdentifier);

        List<String> siteIdentifier1 = new ArrayList<>();
        siteIdentifier1.add("A");
        siteIdentifier1.add("0");
        sitesID.put(16, siteIdentifier1);

        List<String> siteIdentifier2 = new ArrayList<>();
        siteIdentifier2.add("K");
        siteIdentifier2.add("-1");
        sitesID.put(18, siteIdentifier2);

        reine.setSitesID(sitesID);
        reine.train();
        List<String> expectedSiteIdentifier = new ArrayList<>();
        expectedSiteIdentifier.add("K");
        expectedSiteIdentifier.add("1");
        List<String> expectedSiteIdentifier1 = new ArrayList<>();
        expectedSiteIdentifier1.add("A");
        expectedSiteIdentifier1.add("1");
        List<String> expectedSiteIdentifier2 = new ArrayList<>();
        expectedSiteIdentifier2.add("K");
        expectedSiteIdentifier2.add("-1");
        HashMap<Integer, List<String>> expectedsitesID = new HashMap<>();
        expectedsitesID.put(12, expectedSiteIdentifier);
        expectedsitesID.put(16, expectedSiteIdentifier1);
        expectedsitesID.put(18, expectedSiteIdentifier2);
        assertEquals(expectedsitesID, reine.getSitesID());
    }

}
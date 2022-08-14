package CodeRoyal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {



    @Test
    public void Deplacement_droite(){
        Reine reine = new Reine();

        reine.Move();
        assertEquals(60,reine.getCoord_x());

    }

    @Test
    public void Deplacement_bas(){
        Reine reine = new Reine();

        reine.setCoord_x(1900);

        reine.Move();
        assertEquals(60,reine.getCoord_y());
        assertEquals(1900,reine.getCoord_x());
    }

    @Test
    public void Deplacement_gauche(){
        Reine reine = new Reine();

        reine.setCoord_x(1900);

        reine.Move();
        reine.Move();

        assertEquals(1840,reine.getCoord_x());
        assertEquals(60,reine.getCoord_y());

    }


    @Test
    public void Deplacement_haut(){
        Reine reine = new Reine();

        reine.setCoord_x(1900);
        reine.setCoord_y(980);

        reine.Move();

        assertEquals(1900,reine.getCoord_x());
        assertEquals(920,reine.getCoord_y());
    }

    @Test
    public void Deplacement_bas_Val(){
        Reine reine = new Reine();

        reine.setCoord_x(20);
        reine.setDirection_horizontale(false);

        reine.Move();

        assertEquals(20,reine.getCoord_x());
        assertEquals(60,reine.getCoord_y());
    }


    @Test
    public void Deplacement_bas_Val2(){
        Reine reine = new Reine();

        reine.setCoord_x(1900);
        reine.setCoord_y(20);
        reine.setDirection_verticale(false);

        reine.Move();

        assertEquals(1900,reine.getCoord_x());
        assertEquals(80,reine.getCoord_y());
    }



}
package ed.edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaSETest
{
    /**
     * Default constructor for test class ListaSETest
     */
    public ListaSETest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void insertarLista(){
       ListaSE<Point2D> recta=new ListaSE<Point2D>();
       recta.insertar(new Point2D(1,2));
       recta.insertar(new Point2D(2,2));
       recta.insertar(new Point2D(3,3));    
       assertEquals(recta.toString(),"[(1,2), (2,2), (3,3)]");
    }
    
    @Test
    public void insertarListaDeLista(){
       ListaSE<Point2D> recta=new ListaSE<Point2D>();
       recta.insertar(new Point2D(1,2));
       recta.insertar(new Point2D(2,2));
       recta.insertar(new Point2D(3,3)); 
       ListaSE<ListaSE<Point2D>> rectas=new ListaSE<ListaSE<Point2D>>();
       rectas.insertar(recta);
       rectas.insertar(recta);
       assertEquals(rectas.toString(),"[[(1,2), (2,2), (3,3)], [(1,2), (2,2), (3,3)]]");
    }
    
    public class Point2D{
        int x,y;
        public Point2D(int x, int y){
            this.x=x; this.y=y;
        }
        public String toString(){
            return "("+x+","+y+")";
        }
    }
}


import java.util.Random;
public class Los
{
    int losowanie_x()
    {
        Random r = new Random();
        return r.nextInt(1200);
    }
    int losowanie_y()
    {
        Random r = new Random();
        return r.nextInt(800);
    }
}
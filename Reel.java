import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Collections;

public class Reel {
    //array list for the images
    ArrayList<Symbol>sList = new ArrayList<>();

    //create a reel constructor and implement the 6 symbols
    public Reel(){

        // adding images to im objects
        Image im = new Image("redseven.png");
        Image im1 = new Image("bell.png");
        Image im2 = new Image("plum.png");
        Image im3 = new Image("watermelon.png");
        Image im4 = new Image("lemon.png");
        Image im5 = new Image("cherry.png");

        // create new symbol objects
        Symbol redseven = new Symbol();
        Symbol bell = new Symbol();
        Symbol watermelon = new Symbol();
        Symbol plum = new Symbol();
        Symbol lemon = new Symbol();
        Symbol cherry = new Symbol();

        // adding values to the images
        redseven.setValue(7);
        bell.setValue(6);
        watermelon.setValue(5);
        plum.setValue(4);
        lemon.setValue(3);
        cherry.setValue(2);

        // set im objects to symbol objects
        redseven.setImage(im);
        bell.setImage(im1);
        watermelon.setImage(im3);
        plum.setImage(im2);
        lemon.setImage(im4);
        cherry.setImage(im5);

        // add symbols to the array list
        sList.add(redseven);
        sList.add(bell);
        sList.add(watermelon);
        sList.add(plum);
        sList.add(lemon);
        sList.add(cherry);
    }

    //Return the 6 symbols
    public void Spin(){
        Collections.shuffle(sList);
    }
}

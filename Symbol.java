import javafx.scene.image.Image;

public class Symbol implements ISymbol {

    private Image image;
    private int value;

    //set image
    @Override
    public void setImage(Image image) {

        this.image=image;
    }

    // get image
    @Override
    public Image getImage() {

        return image;
    }

    // set image value
    @Override
    public void setValue(int value) {
        this.value=value;
    }

    // get image value
    @Override
    public int getValue() {

        return value;
    }

    // compare method
     public static int compareImages(Symbol obj1,Symbol obj2){

         if(obj1.getValue()==obj2.getValue()){
             return 0;
        }else{
            return 1;
        }
    }
}

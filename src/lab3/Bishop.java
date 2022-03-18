package lab3;

/**
 * @author Kaiya Takahashi
 */

public class Bishop extends Piece{

    /**
     * Constructor
     * @param value
     * @param isWhite
     */
    Bishop(int value, boolean isWhite){
        super(3, isWhite);
    }

    @Override
    public void move(){
        System.out.println("Diagonally");
    }

    @Override
    public String getIcon() {
        if (this.isWhite()) {
            return "♝";
        }else{
            return "♗";
        }
    }

    @Override
    public void setValue(int value) {
        super.setValue(value);
    }

    @Override
    public int getValue() {
        return super.getValue();
    }
}

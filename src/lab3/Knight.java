package lab3;

/**
 * @author Kaiya Takahashi
 */

public class Knight extends Piece{
    /**
     * Constructor
     * @param value
     * @param isWhite
     */
    Knight(int value, boolean isWhite) {
        super(2, isWhite);
    }

    @Override
    public void move(){
        System.out.println("Like an L");
    }

    @Override
    public String getIcon() {
        if (this.isWhite()) {
            return "♞";
        }else{
            return "♘";
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

package lab3;

/**
 * @author Kaiya Takahashi
 */

public class Rook extends Piece{

    Rook(int value, boolean isWhite) {
        super(5, isWhite);
    }

    @Override
    public void move(){
        System.out.println("Horizontally or vertically");
    }

    @Override
    public String getIcon() {
        if (this.isWhite()) {
            return "♜";
        }else{
            return "♖";
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

package Chess;

public class King extends ChessPiece {

	public King(Player player) {
		super(player);
	}

	public String type() {
		return "King";
	}
	
	public boolean isValidMove(Move move, IChessPiece[][] board) {

		if(!super.isValidMove(move, board)) {
			return false;
		}
		//adds total movement of row and col to int
		int rowM = Math.abs(move.getFromRow()-move.getToRow());
		int colM = Math.abs(move.getFromColumn()-move.getToColumn());

		//if tile movement is 1 spaces total
		if (rowM + colM == 1){
			return true;
		}
		return false;
	}
}

package Chess;

public class Knight extends ChessPiece {

	public Knight(Player player) {
		super(player);
	}

	public String type() {
		return "Knight";
	}

	public boolean isValidMove(Move move, IChessPiece[][] board){

		if(!super.isValidMove(move, board)) {
			return false;
		}
		//adds total movement of row and col to int
		int rowM = Math.abs(move.getFromRow()-move.getToRow());
		int colM = Math.abs(move.getFromColumn()-move.getToColumn());

		//if tile movement is 3 spaces total and no more than 2 in any direction
		if (rowM + colM == 3 && rowM < 3 && colM < 3){
			return true;
		}
		return false;
		
	}

}

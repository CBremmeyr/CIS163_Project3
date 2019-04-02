package Chess;

/**********************************************************************
 * King chess piece for game of chess.
 *
 * @author Corbin Bremmeyr
 * @author Micheal James
 * @version 20 March 2019
 *********************************************************************/
public class King extends ChessPiece {

	/******************************************************************
	 * Constructor that sets the owner of the piece.
	 *
	 * @param player Player that owns the piece.
	 *****************************************************************/
	public King(Player player) {
		super(player);
	}

	/******************************************************************
	 * Gets the type of the piece as a string.
	 *
	 * @return "King", the type of the piece as a string.
	 *****************************************************************/
	public String type() {
		return "King";
	}

	/******************************************************************
	 * Check if a move is valid for a king piece.
	 *
	 * @param move move to be tested.
	 * @param board game board.
	 * @return true if move is valid, false if move is invalid.
	 *****************************************************************/
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
		//if movement is no more than 2 in either direction
		if (rowM < 2 && colM <2){
			if (rowM + colM == 2){
				return true;
			}
		}
		return false;
	}
}

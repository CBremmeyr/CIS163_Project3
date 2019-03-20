package Chess;

/**********************************************************************
 * Kight chess piece for game of chess.
 *
 * @author Corbin Bremmeyr
 * @author Micheal James
 * @version 20 March 2019
 *********************************************************************/
public class Knight extends ChessPiece {

	/******************************************************************
	 * Constructor that sets the player that owns the piece.
	 *
	 * @param player Player that owns the piece.
	 *****************************************************************/
	public Knight(Player player) {
		super(player);
	}

	/******************************************************************
	 * Get the type of the piece as a string.
	 *
	 * @return "Knight", the type of the piece as a string.
	 *****************************************************************/
	public String type() {
		return "Knight";
	}

	/******************************************************************
	 * Test if a move is valid for a knight.
	 *
	 * @param move move to be tested.
	 * @param board game board.
	 * @return true if move is valid, false if move is invalid.
	 *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board){

		if(!super.isValidMove(move, board)) {
			return false;
		}
		//adds total movement of row and col to int
		int rowM = Math.abs(move.getFromRow()-move.getToRow());
		int colM = Math.abs(move.getFromColumn()-move.getToColumn());

		//if tile movement is 3 spaces total and no more than 2 in
		// any direction
		if (rowM + colM == 3 && rowM < 3 && colM < 3){
			return true;
		}
		return false;
	}

}

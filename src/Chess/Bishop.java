package Chess;

/**********************************************************************
 * Bishop piece for game of chess.
 *
 * @author Corbin Bremmeyr
 * @author Michael James
 * @version 4 March 2019
 *********************************************************************/
public class Bishop extends ChessPiece {

	/******************************************************************
	 * Constructor that sets what player owns this bishop.
	 *
	 * @param player player that owns this piece.
	 *****************************************************************/
	public Bishop(Player player) {
		super(player);
	}

	/******************************************************************
	 * Gets the type of piece as a String.
	 *
	 * @return type of the piece as a String.
	 *****************************************************************/
	public String type() {
		return "Bishop";
	}

	/******************************************************************
	 * Checks if a move is valid for this piece.
	 *
	 * @param move move to be checked for validity.
	 * @param board current game board.
	 * @return true if the move is valid, false if the move is invalid.
	 *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {

		// Check if move is valid in general
		if(!super.isValidMove(move, board)) {
			return false;
		}

		// Check if move is diagonal from starting position
		if( !(Math.abs(move.getFromRow() - move.getToRow()) ==
				Math.abs(move.getFromColumn() - move.getToColumn())) ){
			return false;
		}

		// Check if move goes over another piece
		int startPnt = 0;
		int endPnt = 0;

		// Set starting point for loop based on what number is lower
		if(move.getFromRow() < move.getToRow()) {
			startPnt = move.getFromRow();
			endPnt = move.getToRow();
		}
		else {
			startPnt = move.getToRow();
			endPnt = move.getFromRow();
		}

		// Return true if all other test failed
		return true;
	}
}

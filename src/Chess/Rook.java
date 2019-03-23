package Chess;

/**********************************************************************
 * Rook class to be used in a game of chess.
 *
 * @author Corbin Bremmeyr
 * @author Michael James
 * @version 23 March 2019
 *********************************************************************/
public class Rook extends ChessPiece {

	/******************************************************************
	 * Constructor that sets which player owns the piece.
	 *
	 * @param player is the player that has ownership of the piece.
	 *****************************************************************/
	public Rook(Player player) {
		
		super(player);
	}

	/******************************************************************
	 * Gets the type name of the piece's type as a String.
	 *
	 * @return name of the piece's type ("Rook").
	 *****************************************************************/
	public String type() {
		
		return "Rook";
	}

	/******************************************************************
	 * Tell if a move is valid for this Rook.
	 *
	 * @param move is the move being considered.
	 * @param board is the current playing field.
	 * @return true if move is valid, false if move is not valid.
	 *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {

		// Check if move is valid in general
		if(!super.isValidMove(move, board)) {
			return false;
		}

		// Check if move is valid specific to a rook

		// Flags to show if 'move to' position is in different row/col
		boolean diffCol = !(move.getFromColumn()==move.getToColumn());
		boolean diffRow = !(move.getFromRow() == move.getToRow());

		// If move is not along row/column or in same spot it's invalid
		if(diffRow == diffCol) {
			return false;
		}

		// If move goes through another piece it is invalid
		if(diffCol) {		// Moving across the row

			// Starting and end points of the loop
			int startPoint;
			int endPoint;

			if(move.getToColumn() < move.getFromColumn()) {
				startPoint = move.getToColumn();
				endPoint = move.getFromColumn();
			}
			else {
				startPoint = move.getFromColumn();
				endPoint = move.getToColumn();
			}

			// Check for pieces over the range of the move, if there is
			// a piece then the move is invalid
			for(int i = startPoint+1; i < endPoint; ++i) {

				// If a board location has a piece on it
				if( !(board[move.getFromRow()][i] == null)) {
					return false;
				}
			}
		}
		else if(diffRow) {	// Moving along the column

			// Starting and end points of the loop
			int startPoint;
			int endPoint;

			if(move.getToRow() < move.getFromRow()) {
				startPoint = move.getToRow();
				endPoint = move.getFromRow();
			}
			else {
				startPoint = move.getFromRow();
				endPoint = move.getToRow();
			}

			// Check for pieces over the range of the move, if there is
			// a piece then the move is invalid
			for(int i = startPoint+1; i < endPoint; ++i) {

				// If a board location has a piece on it
				if( !(board[i][move.getFromColumn()] == null)) {
					return false;
				}
			}
		}


        // True if passed all other tests
        return true;
	}
	
}

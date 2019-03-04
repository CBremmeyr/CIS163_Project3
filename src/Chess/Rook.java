package Chess;

public class Rook extends ChessPiece {

	public Rook(Player player) {
		
		super(player);
	}

	public String type() {
		
		return "Rook";
	}
	
	// determines if the move is valid for a rook piece
	public boolean isValidMove(Move move, IChessPiece[][] board) {

		// Check if move is valid in general
		if(!super.isValidMove(move, board)) {
			return false;
		}

		// Check if move is valid specific to a rook

		// Flags to show if 'move to' position is in different row/column
		boolean diffCol = !(move.getFromColumn() == move.getToColumn());
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

			// Check for pieces over the range of the move, if there is a piece then the move is invalid
			for(int i=startPoint; i < endPoint; ++i) {

				// If a board location has a piece on it
				if( !(board[i][move.getFromColumn()] == null)) {
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

			// Check for pieces over the range of the move, if there is a piece then the move is invalid
			for(int i=startPoint; i < endPoint; ++i) {

				// If a board location has a piece on it
				if( !(board[move.getFromRow()][i] == null)) {
					return false;
				}
			}
		}


        // True if passed all other tests
        return true;
		
	}
	
}

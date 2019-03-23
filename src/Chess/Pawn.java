package Chess;

/**********************************************************************
 * Class for pawn piece in a game of chess.
 *********************************************************************/
public class Pawn extends ChessPiece {

	/******************************************************************
	 * Constructor that sets the owner of the piece.
	 *
	 * @param player player to be set as the owner of the piece.
	 *****************************************************************/
	public Pawn(Player player) {
		super(player);
	}

	/******************************************************************
	 * Gets the type of the piece as a string.
	 *
	 * @return "Pawn", the piece type.
	 *****************************************************************/
	public String type() {
		return "Pawn";
	}

	/******************************************************************
	 * Check if move is valid.
	 *
	 * @param move move being considered.
	 * @param board game board.
	 * @return true if move is valid, false if move is invalid.
	 *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {

		// Check if move is valid in general
		if(!super.isValidMove(move, board)) {
			return false;
		}

		//top player
		if(super.player() == Player.BLACK) {

			//if first move
			if(move.getFromRow() == 1){
				//if move is down 2, over 0
				if (move.getToRow() == move.getFromRow() + 2 &&
						move.getFromColumn() == move.getToColumn()) {
					return true;
				}
				//if move is down 2 and over any number
				if (move.getToRow() == move.getFromRow() + 2 &&
						move.getFromColumn() != move.getToColumn()) {
					return false;
				}
			}

			//check if move is more than 2 rows while not first move
			// and not up
			if (move.getToRow() >= move.getFromRow() + 2 ||
					move.getToRow() <= move.getFromRow()) {
				return false;
			}

			//check if move is more than 1 column
			if (move.getToColumn() >= move.getFromColumn() + 2 ||
					move.getToColumn() <= move.getFromColumn() - 2) {
				return false;
			}

			//if move is proper attack movement
			if(move.getFromColumn() == move.getToColumn()+1 ||
					move.getFromColumn() == move.getToColumn()-1
			&& move.getFromRow() == move.getToRow() - 1) {
				//if enemy piece is there
				if(board[move.getToRow()][move.getToColumn()]!= null) {
					if(board[move.getToRow()][move.getToColumn()]
							.player() == Player.WHITE) {
						return true;
					}
				}
				//piece not there then invalid
				else return false;
			}

			//move must be true
			return true;
		}

		// Bottom team
		if(super.player() == Player.WHITE) {

			// If first move
			if(move.getFromRow() == board.length - 2){

				// If move is up 2, over 0, and no piece is there
				if(move.getToRow() == move.getFromRow() - 2 &&
						move.getFromColumn() == move.getToColumn() &&
						board[move.getToRow()][move.getToColumn()] == null) {
					return true;
				}

				// If move is up 2 and over any number
				if(move.getToRow() == move.getFromRow() - 2 &&
						move.getFromColumn() != move.getToColumn()) {
					return false;
				}
			}

			//check if move is more than 2 rows while not first move and not down
			if(move.getToRow() <= move.getFromRow() - 2 ||
					move.getToRow() >= move.getFromRow()) {
				return false;
			}

			//check if move is more than 1 column
			if (move.getToColumn() >= move.getFromColumn() + 2 ||
					move.getToColumn() <= move.getFromColumn() - 2) {
				return false;
			}

			//if move is proper attack movement
			if(move.getFromColumn() == move.getToColumn()+1 ||
					move.getFromColumn() == move.getToColumn()-1
					&& move.getFromRow() == move.getToRow() + 1) {
				//if enemy piece is there
				if(board[move.getToRow()][move.getToColumn()]!= null){
					if(board[move.getToRow()][move.getToColumn()]
							.player() == Player.BLACK){
						return true;
					}
				}
				//piece not there then invalid
				else return false;
			}

			//move must be true
			return true;
		}

		//non existent player
		return false;
	}
}

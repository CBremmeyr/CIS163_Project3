package Chess;

/**********************************************************************
 * Base class for chess pieces.
 *
 * @author Corbin Bremmeyr
 * @author Micheal James
 * @version 20 March 2019
 *********************************************************************/
public abstract class ChessPiece implements IChessPiece {

	/** Owner of the game piece */
	private Player owner;

	/******************************************************************
	 * Constructor that sets the owner of the piece.
	 *
	 * @param player player that is the owner of the piece.
	 *****************************************************************/
	protected ChessPiece(Player player) {
		this.owner = player;
	}

	protected ChessPiece(ChessPiece other) {
		this.owner = other.owner;
	}

	public abstract String type();

	public Player player() {
		return owner;
	}

	/******************************************************************
	 * Check if move is valid.
	 *
	 * @param move  a {@link Chess.Move} object describing the move to be made.
	 * @param board the chess board in which this piece resides.
	 * @return true if the move is valid in general, false if move is
	 * 		not valid.
	 *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {

		if(board[move.getToRow()][move.getToColumn()] != null) {

			// Move is invalid if moved to same location
			if ((move.getFromRow() == move.getToRow()) &&
					(move.getFromColumn() == move.getToColumn())) {
				return false;
			}

			// Move is invalid if another piece with same owner is at
			// moveTo location
			if (board[move.getToRow()][move.getToColumn()].player() ==
					this.player()) {
				return false;
			}
			//Move is on the board
			if (move.getToRow() >= board.length || move.getToColumn()
					>= board.length
					|| move.getToRow() < 0 || move.getToColumn() < 0) {
				return false;
			}
		}

		return true;
	}
}

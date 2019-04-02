package Chess;

/**********************************************************************
 * Queen chess piece class.
 *
 * @author Corbin Bremmeyr
 * @author Mike James
 * @version 1 April 2019
 *********************************************************************/
public class Queen extends ChessPiece {

	/******************************************************************
	 * Makes queen piece for a player.
	 *
	 * @param player player that piece is to be owned by.
	 *****************************************************************/
	public Queen(Player player) {
		super(player);

	}

	/******************************************************************
	 * Get pieces type as a string.
	 *
	 * @return string that indicates piece's type.
	 *****************************************************************/
	public String type() {
		return "Queen";
		
	}

	/******************************************************************
	 * Test if a desired move is valid.
	 *
	 * @param move moving being tested if valid.
	 * @param board game board.
	 * @return true if move is valid, false if move is invalid.
	 *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		Bishop move1 = new Bishop(board[move.getFromRow()][move.
				getFromColumn()].player());
		Rook move2 = new Rook(board[move.getFromRow()][move.
				getFromColumn()].player());
		return (move1.isValidMove(move, board) || move2.
				isValidMove(move, board));
	}
}

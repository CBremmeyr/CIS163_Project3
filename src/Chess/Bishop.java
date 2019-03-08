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

		return true;
        // More code is needed
		
	}
}

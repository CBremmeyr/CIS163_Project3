package Chess;

/**********************************************************************
 * Game logic class for game of chess.
 *
 * @author Corbin Bremmeyr
 * @author Micheal James
 * @version 20 March 2019
 **********************************************************************/
public class ChessModel implements IChessModel {

	/** Board to hold logical chess pieces */
    private IChessPiece[][] board;

    /** Next player to make a move */
	private Player player;

	/******************************************************************
	 * Setup game logic for new game.
	 *****************************************************************/
	public ChessModel() {
		board = new IChessPiece[8][8];
		player = Player.WHITE;

		// Make white non-pawn pieces
        board[7][0] = new Rook(Player.WHITE);
        board[7][1] = new Knight(Player.WHITE);
        board[7][2] = new Bishop(Player.WHITE);
        board[7][3] = new Queen(Player.WHITE);
        board[7][4] = new King(Player.WHITE);
        board[7][5] = new Bishop(Player.WHITE);
        board[7][6] = new Knight (Player.WHITE);
        board[7][7] = new Rook(Player.WHITE);

		// Make black non-pawn pieces
		board[0][0] = new Rook(Player.BLACK);
		board[0][1] = new Knight(Player.BLACK);
		board[0][2] = new Bishop(Player.BLACK);
		board[0][3] = new Queen(Player.BLACK);
		board[0][4] = new King(Player.BLACK);
		board[0][5] = new Bishop(Player.BLACK);
		board[0][6] = new Knight (Player.BLACK);
		board[0][7] = new Rook(Player.BLACK);

        // Make pawns
        for(int i=0; i<board.length; ++i) {

        	board[6][i] = new Pawn(Player.WHITE);
        	board[1][i] = new Pawn(Player.BLACK);
		}
	}

	/******************************************************************
	 *
	 *
	 * @return
	 *****************************************************************/
	public boolean isComplete() {
		boolean valid = false;
		return valid;
	}

	/******************************************************************
	 * Check if a move is valid.
	 *
	 * @param move a {@link Chess.Move} object describing the move to be made.
	 * @return true if the move is valid, false if move is invalid.
	 *****************************************************************/
	public boolean isValidMove(Move move) {

		if(board[move.getFromRow()][move.getFromColumn()] != null)
			if(board[move.getFromRow()][move.getFromColumn()].player() == this.player) {
				if(board[move.getFromRow()][move.getFromColumn()]
						.isValidMove(move, board)) {
					return true;
				}
			}

		return false;
	}

	/******************************************************************
	 * Perform move if it is valid.
	 *
	 * @param move a {@link Chess.Move} object describing the move to
	 *             be made.
	 *****************************************************************/
	public void move(Move move) {

		// Only move if valid
		if(this.isValidMove(move)) {

			board[move.getToRow()][move.getToColumn()] = board[move.getFromRow()][move.getFromColumn()];
			board[move.getFromRow()][move.getFromColumn()] = null;

			// Toggle players' turns
			this.player = this.player.next();
		}

		// TODO: maybe throw exception if trying to make an invalid move?
	}

	/******************************************************************
	 * Test if player is in check.
	 *
	 * @param  p {@link Chess.Move} the Player being checked
	 * @return true if player is in check, false if player is not.
	 *****************************************************************/
	public boolean inCheck(Player p) {
		boolean valid = false;
		return valid;
	}

	/******************************************************************
	 * Get the player whoes turn it is currently.
	 *
	 * @return player to take his/her turn.
	 *****************************************************************/
	public Player currentPlayer() {
		return player;
	}

	/******************************************************************
	 * Gets the number of rows in the board.
	 *
	 * @return number of rows on the board.
	 *****************************************************************/
	public int numRows() {
		return 8;
	}

	/******************************************************************
	 * Get the number of columns on the board.
	 *
	 * @return number of columns on the board.
	 *****************************************************************/
	public int numColumns() {
		return 8;
	}

	/******************************************************************
	 * Get the piece with indexes 'row' and 'column'.
	 *
	 * @param row row of piece to get.
	 * @param column column of piece to get.
	 * @return referable to piece with index 'row' and 'column'.
	 *****************************************************************/
	public IChessPiece pieceAt(int row, int column) {		
		return board[row][column];
	}

	/******************************************************************
	 * Set player whoes turn it is to the other player.
	 *****************************************************************/
	public void setNextPlayer() {
		player = player.next();
	}

	/******************************************************************
	 * Set piece at index 'row' and 'column'.
	 *
	 * @param row of piece to set.
	 * @param column of piece to set.
	 * @param piece to be set at 'row' 'column' indices.
	 *****************************************************************/
	public void setPiece(int row, int column, IChessPiece piece) {
		board[row][column] = piece;
	}

	public void AI() {


		/*
		 * Write a simple AI set of rules in the following order. 
		 * a. Check to see if you are in check.
		 * 		i. If so, get out of check by moving the king or placing a piece to block the check 
		 * 
		 * b. Attempt to put opponent into check (or checkmate). 
		 * 		i. Attempt to put opponent into check without losing your piece
		 *		ii. Perhaps you have won the game. 
		 *
		 *c. Determine if any of your pieces are in danger, 
		 *		i. Move them if you can. 
		 *		ii. Attempt to protect that piece. 
		 *
		 *d. Move a piece (pawns first) forward toward opponent king 
		 *		i. check to see if that piece is in danger of being removed, if so, move a different piece.
		 */

		}
}

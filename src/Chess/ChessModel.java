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

	public ChessModel(ChessModel other) {
		board = new IChessPiece[8][8];
		player = other.player;

		for(int i=0; i<board.length; ++i) {
			for(int j=0; j<board[i].length; ++j) {

				this.board[i][j] = other.board[i][j];
			}
		}
	}

	/******************************************************************
	 * Check if current player is in checkmate, and the game is over.
	 *
	 * @return true if the game is over, else false.
	 *****************************************************************/
	public boolean isComplete() {
		boolean valid = false;

		if(!inCheck(player)) {
			return false;
		}

		// Check all possible moves for the current player and see if
		// player can get out of check
		for(int i=0; i<board.length; ++i) {
			for(int j=0; j<board[i].length; ++j) {

				if(pieceAt(i, j) != null) {
					if(pieceAt(i, j).player() == player) {

						// Check all possible moves for this piece
						for(int r=0; r<board.length; ++r) {
							for(int c=0; c<board[r].length; ++c) {

								Move testMove = new Move(i, j, r, c);
								if(isValidMove(testMove)) {

									// Make temp board to able move and test
									ChessModel testGame = new ChessModel(this);

									// Apply test move
									testGame.move(testMove);

									// Test if test move takes player out of check
									if(testGame.inCheck(this.player)) {
										return false;
									}
								}
							}
						}
					}
				}
			}
		}

		return true;
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
	 * @param  p {@link Chess.Move} the Player being checked.
	 * @return true if player is in check, false if player is not.
	 *****************************************************************/
	public boolean inCheck(Player p) {

		int r = 0;
		int c = 0;

		// Get location of current player's king
		for(int i=0; i<board.length; ++i) {
			for(int j=0; j<board[i].length; ++j) {

				if(pieceAt(i, j) != null) {
					if(pieceAt(i, j).player() == p &&
					pieceAt(i, j).type().equals("King")) {

						r = i;
						c = j;
					}
				}
			}
		}

		// Check if any piece has a valid move to take the king
		for(int i=0; i<board.length; ++i) {
			for(int j=0; j<board[i].length; ++j) {

				if(pieceAt(i, j) != null) {
					if(pieceAt(i, j).player() != p) {

						// Check if piece can take the king
						Move testMove = new Move(r, c, i, j);
						if(pieceAt(i, j).isValidMove(testMove, board)) {
							return true;
						}
					}
				}

			}
		}

		return false;
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

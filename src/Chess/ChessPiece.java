package Chess;

public abstract class ChessPiece implements IChessPiece {

	private Player owner;

	protected ChessPiece(Player player) {
		this.owner = player;
	}

	public abstract String type();

	public Player player() {
		return owner;
	}

	public boolean isValidMove(Move move, IChessPiece[][] board) {

		// Move is invalid if moved to same location
		if ((move.getFromRow() == move.getToRow()) && (move.getFromColumn() == move.getToColumn())) {
			return false;
		}

		// Move is invalid if another piece with same owner is at moveTo location
		if(board[move.getToRow()][move.getToColumn()].player() == this.player()) {
			return false;
		}
		//Move is on the board
		if(move.getToRow() >= board.length || move.getToColumn() >= board.length
				|| move.getToRow() < 0 || move.getToColumn() < 0){
			return false;
		}


		return true;
	}



}

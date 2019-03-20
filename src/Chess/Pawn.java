package Chess;

public class Pawn extends ChessPiece {

	public Pawn(Player player) {
		super(player);
	}

	public String type() {
		return "Pawn";
	}

	// determines if the move is valid for a pawn piece
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
				if (move.getToRow() == move.getFromRow() + 2 && move.getFromColumn() == move.getToColumn()) {
					return true;
				}
				//if move is down 2 and over any number
				if (move.getToRow() == move.getFromRow() + 2 && move.getFromColumn() != move.getToColumn()) {
					return false;
				}
			}

			//check if move is more than 2 rows while not first move and not up
			if (move.getToRow() >= move.getFromRow() + 2 || move.getToRow() <= move.getFromRow()) {
				return false;
			}

			//check if move is more than 1 column
			if (move.getToColumn() >= move.getFromColumn() + 2 || move.getToColumn() <= move.getFromColumn() - 2) {
				return false;
			}

			//if move is proper attack movement
			if(move.getFromColumn() == move.getToColumn()+1 || move.getFromColumn() == move.getToColumn()-1
			&& move.getFromRow() == move.getToRow() - 1) {
				//if enemy piece is there
				if(board[move.getToRow()][move.getToColumn()]!= null){
					if(board[move.getToRow()][move.getToColumn()].player() == Player.WHITE){
						return true;
					}
				}
				//piece not there then invalid
				else return false;
			}

			//move must be true
			return true;
		}
		//bottom team
		if(super.player() == Player.WHITE) {

			//if first move
			if(move.getFromRow() == board.length-2){
				//if move is up 2, over 0
				if (move.getToRow() == move.getFromRow() - 2 && move.getFromColumn() == move.getToColumn()) {
					return true;
				}
				//if move is up 2 and over any number
				if (move.getToRow() == move.getFromRow() - 2 && move.getFromColumn() != move.getToColumn()) {
					return false;
				}
			}

			//check if move is more than 2 rows while not first move and not down
			if (move.getToRow() >= move.getFromRow() - 2 || move.getToRow() >= move.getFromRow()) {
				return false;
			}

			//check if move is more than 1 column
			if (move.getToColumn() >= move.getFromColumn() + 2 || move.getToColumn() <= move.getFromColumn() - 2) {
				return false;
			}

			//if move is proper attack movement
			if(move.getFromColumn() == move.getToColumn()+1 || move.getFromColumn() == move.getToColumn()-1
					&& move.getFromRow() == move.getToRow() + 1) {
				//if enemy piece is there
				if(board[move.getToRow()][move.getToColumn()]!= null){
					if(board[move.getToRow()][move.getToColumn()].player() == Player.BLACK){
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

package Chess;

public class Queen extends ChessPiece {

	public Queen(Player player) {
		super(player);

	}

	public String type() {
		return "Queen";
		
	}
	
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		Bishop move1 = new Bishop(board[move.getFromRow()][move.getFromColumn()].player());
		Rook move2 = new Rook(board[move.getFromRow()][move.getFromColumn()].player());
		return (move1.isValidMove(move, board) || move2.isValidMove(move, board));
	}
}

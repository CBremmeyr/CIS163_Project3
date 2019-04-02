package Chess;

/**********************************************************************
 * Class to describe a player's move.
 *
 * @author Corbin Bremmeyr
 * @author Mike James
 * @version 1 April 2019
 *********************************************************************/
public class Move {

	/** Row that piece is being moved from */
	private int fromRow;

	/** Column that piece is being moved from */
	private int fromColumn;

	/** Row that the piece is being moved to */
	private int toRow;

	/** Column that the piece is being moved to */
	private int toColumn;

	/******************************************************************
	 * Constructor that sets the to and from move positions.
	 *
	 * @param fromRow Row that move is going from.
	 * @param fromColumn Column that move is going from.
	 * @param toRow Row that the move is going to.
	 * @param toColumn Column the move is going to.
	 *****************************************************************/
	public Move(int fromRow, int fromColumn, int toRow, int toColumn) {
		this.fromRow = fromRow;
		this.fromColumn = fromColumn;
		this.toRow = toRow;
		this.toColumn = toColumn;
	}

	/******************************************************************
	 * Generate and return a string to describe the move.
	 *
	 * @return descriptor string.
	 *****************************************************************/
	@Override
	public String toString() {
		return "Move [fromRow=" + fromRow + ", fromColumn=" +
				fromColumn + ", toRow=" + toRow + ", toColumn=" +
				toColumn + "]";
	}

	/******************************************************************
	 * Getter for the row being moved from.
	 *
	 * @return row being moved from.
	 *****************************************************************/
	public int getFromRow() {
		return fromRow;
	}

	/******************************************************************
	 * Set the row being moved from.
	 *
	 * @param fromRow value to be set for the row being moved from.
	 *****************************************************************/
	public void setFromRow(int fromRow) {
		this.fromRow = fromRow;
	}

	/******************************************************************
	 * Get the value of the column being moved from.
	 *
	 * @return the value of the column being moved from.
	 *****************************************************************/
	public int getFromColumn() {
		return fromColumn;
	}

	/******************************************************************
	 * Set the value for the column that the move is coming from.
	 *
	 * @param fromColumn value to set for the column being moved from.
	 *****************************************************************/
	public void setFromColumn(int fromColumn) {
		this.fromColumn = fromColumn;
	}

	/******************************************************************
	 * Get the value of the row that the piece is being moved to.
	 *
	 * @return the value of the row that the piece is being moved to.
 	 *****************************************************************/
	public int getToRow() {
		return toRow;
	}

	/******************************************************************
	 * Set the value of the row being moved to.
	 *
	 * @param toRow set the value of the row being moved to.
	 *****************************************************************/
	public void setToRow(int toRow) {
		this.toRow = toRow;
	}

	/******************************************************************
	 * Get the value of the column that is being moved to.
	 *
	 * @return the value of the column that is being moved to.
	 *****************************************************************/
	public int getToColumn() {
		return toColumn;
	}

	/******************************************************************
	 * Set the value of the column being moved to.
	 *
	 * @param toColumn value of the column that is being moved to.
	 *****************************************************************/
	public void setToColumn(int toColumn) {
		this.toColumn = toColumn;
	}
}

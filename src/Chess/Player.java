package Chess;

/**********************************************************************
 * Enum for the two players of the game.
 *
 * @author Corbin Bremmeyr
 * @author Mike James
 * @version 1 April 2019
 *********************************************************************/
public enum Player {
	BLACK, WHITE;

	/**
	 * Return the {@code Player} whose turn is next.
	 *
	 * @return the {@code Player} whose turn is next
	 */
	public Player next() {
		return this == BLACK ? WHITE : BLACK;
	}

	/**
	 * Covert player color to a string.
	 *
	 * @return player's color as a string.
	 */
	public String toString() {
		if(this == BLACK) {
			return "Black";
		}
		else {
			return  "White";
		}
	}
}
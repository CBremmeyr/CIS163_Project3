package Chess;

/**********************************************************************
 * Enum for the two players of the game.
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
}
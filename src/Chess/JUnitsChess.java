package Chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**********************************************************************
 * Test cases for backend of chess game.
 *
 * @author Corbin Bremmeyr
 * @author Mike James
 * @version 1 April 2019
 *********************************************************************/
public class JUnitsChess {

    private ChessModel game;

    @BeforeEach
    void setup() {

        // Make new chess game model for testing
        game = new ChessModel();
    }

    @Test
    void testIsComplete() {

        // Test if player is initial in check
        Assertions.assertFalse(game.isComplete());

        // Put black in check
        game.move(new Move(6, 4, 4, 4));
        game.move(new Move(1, 5, 3, 5));
        game.move(new Move(4, 4, 3, 5));
        game.move(new Move(1, 6, 3, 6));
        game.move(new Move(7, 3, 3, 7));


        Assertions.assertTrue(game.isComplete());
    }

    @Test
    void testIsComplete2() {

        // Put player in check
        game.move(new Move(6, 4, 4, 4));
        game.move(new Move(1, 4, 3, 4));
        game.move(new Move(7, 3, 4, 6));
        game.move(new Move(0, 4, 1, 4));
        game.move(new Move(4, 6, 4, 7));

        // Test that player is not in checkmate
        Assertions.assertFalse(game.isComplete());

    }

    @Test
    void testIsValidMove() {

        // Test a valid move
        boolean result = game.isValidMove(new Move(6, 4, 4, 4));
        Assertions.assertTrue(result);

        // Test invalid move
        result = game.isValidMove(new Move(6, 4, 6, 4));
        Assertions.assertFalse(result);
    }

    @Test
    void testMove() {

        // Make an invalid move
        game.move(new Move(0,0, 4, 4));

        // Check that location moved to is still null
        Assertions.assertTrue(game.pieceAt(2, 4) == null);

        // Make a valid move
        IChessPiece pieceMoved = game.pieceAt(6, 6);
        game.move(new Move(6, 6, 5, 6));

        // Check that piece was moved
        Assertions.assertTrue(pieceMoved == game.pieceAt(5, 6));

    }

    @Test
    void testInCheck() {

        // Check if players are in check at start of game
        Assertions.assertFalse(game.inCheck(Player.BLACK));
        Assertions.assertFalse(game.inCheck(Player.WHITE));

        // Put black in check and test
        game.move(new Move(6, 4, 4, 4));
        game.move(new Move(1, 5, 3, 5));
        game.move(new Move(4, 4, 3, 5));
        game.move(new Move(1, 6, 3, 6));
        game.move(new Move(7, 3, 3, 7));

        Assertions.assertTrue(game.inCheck(Player.BLACK));
        Assertions.assertFalse(game.inCheck(Player.WHITE));
    }

    @Test
    void testNextPlayerSetterGetter() {

        Assertions.assertTrue(game.currentPlayer() == Player.WHITE);
        game.setNextPlayer();
        Assertions.assertTrue(game.currentPlayer() == Player.BLACK);
    }

    @Test
    void testBoardSizeGetters() {
        Assertions.assertTrue(game.numRows() == 8);
        Assertions.assertTrue(game.numColumns() == 8);
    }

    @Test
    void testAIMoveCheck() {

        // Put AI in check
        game.move(new Move(6, 4, 4, 4));
        game.move(new Move(1, 4, 3, 4));
        game.move(new Move(6, 5, 4, 5));
        game.move(new Move(1, 5, 3, 5));
        game.move(new Move(7, 3, 3, 7));

        // See if player is in check
        boolean before = game.inCheck(Player.BLACK);

        // Apply AI move
        game.AI();

        // Test that AI moved out of check
        boolean after = game.inCheck(Player.BLACK);
        Assertions.assertFalse(before == after);
    }

    @Test
    void testAIBlockCheck() {

        // Put AI in check
        game.move(new Move(6, 4, 5, 4));
        game.move(new Move(1, 4, 2, 4));
        game.move(new Move(6, 0, 5, 0));
        game.move(new Move(0, 4, 1, 4));
        game.move(new Move(7, 3, 4, 6));
        game.move(new Move(0, 3, 0, 4));
        game.move(new Move(5, 0, 4, 0));
        game.move(new Move(1, 3, 2, 3));
        game.move(new Move(4, 0, 3, 0));
        game.move(new Move(0, 2, 1, 3));
        game.move(new Move(7, 0, 6, 0));
        game.move(new Move(0, 1, 2, 0));
        game.move(new Move(6, 0, 7, 0));
        game.move(new Move(0, 0, 0, 3));
        game.move(new Move(4, 6, 3, 6));

        // Test if in check
        boolean before = game.inCheck(Player.BLACK);

        // Let AI make move
        game.AI();

        // Test if still in check
        boolean after = game.inCheck(Player.BLACK);
        Assertions.assertFalse(before == after);
    }

    @Test
    void testAICheckEnemy() {

        // Setup AI to put enemy in check
        game.move(new Move(6, 3, 4, 3));
        game.move(new Move(1, 4, 3, 4));
        game.move(new Move(6, 4, 4, 4));

        // Get if other player is in check
        boolean before = game.inCheck(Player.WHITE);

        // Let AI take turn
        game.AI();

        // Test if AI put other player in check
        boolean after = game.inCheck(Player.WHITE);
        Assertions.assertFalse(before == after);
    }

    @Test
    void testAIMoveFromDanger() {

        // Put a non-king piece in danger
        game.move(new Move(6, 4, 5, 4));
        game.move(new Move(1, 4, 2, 4));
        game.move(new Move(7, 3, 5, 5));

        // Test if piece is in danger
        boolean before = game.danger(1, 1) && game.pieceAt(1, 1) != null;

        // Let AI make move
        game.AI();

        // Test if piece is still in danger
        boolean after = game.pieceAt(1, 1) != null;
        Assertions.assertNotEquals(before, after);
    }

    @Test
    void testUndo() {

        // Undo before any moves are made,
        // should do nothing and have no errors/exceptions
        game.undo();

        // Make move
        game.move(new Move(1, 0, 2, 0));

        // Check that there is no piece at (1, 0)
        boolean before = game.pieceAt(1, 0) == null;

        // Undo last move
        game.undo();

        // Check if piece is now there
        boolean after = game.pieceAt(1, 0) == null;
        Assertions.assertNotEquals(before, after);
    }

}

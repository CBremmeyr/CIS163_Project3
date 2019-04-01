package Chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// TODO: bugs to fix
//      -

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
        game.move(new Move(0,0, 2, 4));

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
    void testAI() {

    }

}

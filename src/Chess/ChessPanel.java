package Chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**********************************************************************
 * GUI panel to be used to for a game of chess.
 *********************************************************************/
public class ChessPanel extends JPanel {

    /** Size of the board */
    private int boardSize;

    /** Buttons to make game board */
    private JButton[][] board;

    /** Game logic class instance */
    private ChessModel model;

    /** White rook icon */
    private ImageIcon wRook;

    /** White bishop icon */
    private ImageIcon wBishop;

    /** White queen icon */
    private ImageIcon wQueen;

    /** White king icon */
    private ImageIcon wKing;

    /** White pawn icon */
    private ImageIcon wPawn;

    /** White knight icon */
    private ImageIcon wKnight;

    /** Black rook icon */
    private ImageIcon bRook;

    /** Black bishop icon */
    private ImageIcon bBishop;

    /** Black queen icon */
    private ImageIcon bQueen;

    /** Black king icon */
    private ImageIcon bKing;

    /** Black pawn icon */
    private ImageIcon bPawn;

    /** black knight icon */
    private ImageIcon bKnight;

    /** Tell if button press is the first in a pair making a move */
    private boolean firstTurnFlag;

    /** Row moving piece from */
    private int fromRow;

    /** Row moving piece to */
    private int toRow;

    /** Column moving piece from */
    private int fromCol;

    /** Column moving piece to */
    private int toCol;

    /** Listener for all board buttons */
    private Listener listener;

    /******************************************************************
     * Constructor for chess game panel.
     *****************************************************************/
    public ChessPanel() {
        model = new ChessModel();
        this.boardSize = model.numRows();
        board = new JButton[model.numRows()][model.numColumns()];
        listener = new Listener();
        this.createIcons();

        JPanel boardPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(model.numRows(),
                model.numColumns(), 1, 1));

        for (int r = 0; r < model.numRows(); r++) {
            for (int c = 0; c < model.numColumns(); c++) {

                if(model.pieceAt(r, c) == null) {
                    board[r][c] = new JButton("", null);
                    board[r][c].addActionListener(listener);
                }
                else if (model.pieceAt(r, c).player() == Player.WHITE){
                    placeWhitePieces(r, c);
                }
                else if(model.pieceAt(r, c).player() == Player.BLACK) {
                    placeBlackPieces(r, c);
                }

                setBackGroundColor(r, c);
                boardPanel.add(board[r][c]);
            }
        }
        add(boardPanel, BorderLayout.WEST);
        boardPanel.setPreferredSize(new Dimension(600, 600));
        add(buttonPanel);
        firstTurnFlag = true;

        this.displayBoard();
    }

    /******************************************************************
     * Set background of the buttons to checkered pattern.
     *
     * @param r row of button to have the color set.
     * @param c column of button to have the color set.
     *****************************************************************/
    private void setBackGroundColor(int r, int c) {
        if ((c % 2 == 1 && r % 2 == 0) || (c % 2 == 0 && r % 2 == 1)){
            board[r][c].setBackground(Color.LIGHT_GRAY);
        } else if ((c % 2 == 0 && r % 2 == 0) ||
                (c % 2 == 1 && r % 2 == 1)) {
            board[r][c].setBackground(Color.WHITE);
        }
    }

    /******************************************************************
     * Place buttons and attach listeners for a white piece.
     *
     * @param r row of button to be generated.
     * @param c column of button to be generated.
     *****************************************************************/
    private void placeWhitePieces(int r, int c) {
        if(model.pieceAt(r, c).type().equals("Pawn")) {
            board[r][c] = new JButton(null, wPawn);
            board[r][c].addActionListener(listener);
        }
        if(model.pieceAt(r, c).type().equals("Rook")) {
            board[r][c] = new JButton(null, wRook);
            board[r][c].addActionListener(listener);
        }
        if(model.pieceAt(r, c).type().equals("Knight")) {
            board[r][c] = new JButton(null, wKnight);
            board[r][c].addActionListener(listener);
        }
        if(model.pieceAt(r, c).type().equals("Bishop")) {
            board[r][c] = new JButton(null, wBishop);
            board[r][c].addActionListener(listener);
        }
        if(model.pieceAt(r, c).type().equals("Queen")) {
            board[r][c] = new JButton(null, wQueen);
            board[r][c].addActionListener(listener);
        }
        if(model.pieceAt(r, c).type().equals("King")) {
            board[r][c] = new JButton(null, wKing);
            board[r][c].addActionListener(listener);
        }
    }

    /******************************************************************
     * Place buttons and attach listeners for a black piece.
     *
     * @param r row of button to be generated.
     * @param c column of button to be generated.
     *****************************************************************/
    private void placeBlackPieces(int r, int c) {
        if(model.pieceAt(r, c).type().equals("Pawn")) {
            board[r][c] = new JButton(null, bPawn);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Rook")) {
            board[r][c] = new JButton(null, bRook);
            board[r][c].addActionListener(listener);
        }
        if(model.pieceAt(r, c).type().equals("Knight")) {
            board[r][c] = new JButton(null, bKnight);
            board[r][c].addActionListener(listener);
        }
        if(model.pieceAt(r, c).type().equals("Bishop")) {
            board[r][c] = new JButton(null, bBishop);
            board[r][c].addActionListener(listener);
        }
        if(model.pieceAt(r, c).type().equals("Queen")) {
            board[r][c] = new JButton(null, bQueen);
            board[r][c].addActionListener(listener);
        }
        if(model.pieceAt(r, c).type().equals("King")) {
            board[r][c] = new JButton(null, bKing);
            board[r][c].addActionListener(listener);
        }
    }

    /******************************************************************
     * Load all the icons into instance variables.
     *****************************************************************/
    private void createIcons() {

        String iconPath = "./icons/";

        // Load the images for white player pieces
        wRook   = new ImageIcon(iconPath + "wRook.png");
        wBishop = new ImageIcon(iconPath + "wBishop.png");
        wQueen  = new ImageIcon(iconPath + "wQueen.png");
        wKing   = new ImageIcon(iconPath + "wKing.png");
        wPawn   = new ImageIcon(iconPath + "wPawn.png");
        wKnight = new ImageIcon(iconPath + "wKnight.png");

        // Load the images for black player pieces
        bRook   = new ImageIcon(iconPath + "bRook.png");
        bBishop = new ImageIcon(iconPath + "bBishop.png");
        bQueen  = new ImageIcon(iconPath + "bQueen.png");
        bKing   = new ImageIcon(iconPath + "bKing.png");
        bPawn   = new ImageIcon(iconPath + "bPawn.png");
        bKnight = new ImageIcon(iconPath + "bKnight.png");
    }

    /******************************************************************
     * Update location of piece icons.
     *****************************************************************/
    private void displayBoard() {

        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {

                if (model.pieceAt(r, c) == null) {
                    board[r][c].setIcon(null);
                }
                else if(model.pieceAt(r, c).player() == Player.WHITE) {

                    if(model.pieceAt(r, c).type().equals("Pawn")) {
                        board[r][c].setIcon(wPawn);
                    }
                    else if(model.pieceAt(r, c).type().equals("Rook")){
                        board[r][c].setIcon(wRook);
                    }
                    else if(model.pieceAt(r, c).type().equals("Knight")){
                        board[r][c].setIcon(wKnight);
                    }
                    else if(model.pieceAt(r, c).type().equals("Bishop")){
                        board[r][c].setIcon(wBishop);
                    }
                    else if(model.pieceAt(r, c).type().equals("Queen")){
                        board[r][c].setIcon(wQueen);
                    }
                    else if(model.pieceAt(r, c).type().equals("King")){
                        board[r][c].setIcon(wKing);
                    }
                }
                else if(model.pieceAt(r, c).player() == Player.BLACK) {
                    if(model.pieceAt(r, c).type().equals("Pawn")) {
                        board[r][c].setIcon(bPawn);
                    }
                    else if(model.pieceAt(r, c).type().equals("Rook")){
                        board[r][c].setIcon(bRook);
                    }
                    else if(model.pieceAt(r, c).type().equals("Knight")){
                        board[r][c].setIcon(bKnight);
                    }
                    else if(model.pieceAt(r, c).type().equals("Bishop")){
                        board[r][c].setIcon(bBishop);
                    }
                    else if(model.pieceAt(r, c).type().equals("Queen")){
                        board[r][c].setIcon(bQueen);
                    }
                    else if(model.pieceAt(r, c).type().equals("King")) {
                        board[r][c].setIcon(bKing);
                    }
                }
            }
        }
        repaint();
    }

    /******************************************************************
     * Class to respond to game board button presses.
     *****************************************************************/
    private class Listener implements ActionListener {

        /**************************************************************
         * Respond to game board button press.
         *
         * @param event event that triggered listener.
         *************************************************************/
        public void actionPerformed(ActionEvent event) {

            for(int r = 0; r < model.numRows(); r++) {
                for(int c = 0; c < model.numColumns(); c++) {

                    if(board[r][c] == event.getSource() &&
                            board[r][c] != null) {

                        if(model.pieceAt(r, c) != null && firstTurnFlag) {
                            if(model.getPlayer() != model.pieceAt(r, c).player()) {
                                return;
                            }
                        }

                        if(firstTurnFlag) {
                            if(model.pieceAt(r, c) != null) {
                                fromRow = r;
                                fromCol = c;
                                firstTurnFlag = false;
                            }
                        }
                        else {
                            toRow = r;
                            toCol = c;
                            firstTurnFlag = true;
                            Move m = new Move(fromRow, fromCol,
                                    toRow, toCol);

                            if(model.isValidMove(m)) {
                                model.move(m);
                                displayBoard();
                            }
                        }
                    }
                }
            }
        }
    }
}

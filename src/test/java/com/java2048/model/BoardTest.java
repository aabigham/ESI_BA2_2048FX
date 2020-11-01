package com.java2048.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class of the board class.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class BoardTest {

    public BoardTest() {
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveUp_NoMerge() {
        Board board = new Board(new Tile[][]{
            {null, null, null, null},
            {new Tile(2), new Tile(2), null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.UP);
        Board expBoard = new Board(new Tile[][]{
            {new Tile(2), new Tile(2), null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move UP - No Merge");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveUp_MergeTwo() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.UP);
        Board expBoard = new Board(new Tile[][]{
            {new Tile(4), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move UP - Merge Two");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveUp_MergeThree() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.UP);
        Board expBoard = new Board(new Tile[][]{
            {new Tile(4), null, null, null},
            {new Tile(2), null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move UP - Merge Three");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveUp_MergeFour() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null}
        });
        board.moveTiles(Direction.UP);
        Board expBoard = new Board(new Tile[][]{
            {new Tile(4), null, null, null},
            {new Tile(4), null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move UP - Merge Four");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveDown_NoMerge() {
        Board board = new Board(new Tile[][]{
            {null, null, null, null},
            {new Tile(2), new Tile(2), null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.DOWN);
        Board expBoard = new Board(new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {new Tile(2), new Tile(2), null, null}
        });
        System.out.println("Test move DOWN - No Merge");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveDown_MergeTwo() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.DOWN);
        Board expBoard = new Board(new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {new Tile(4), null, null, null}
        });
        System.out.println("Test move DOWN - Merge Two");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveDown_MergeThree() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.DOWN);
        Board expBoard = new Board(new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {new Tile(2), null, null, null},
            {new Tile(4), null, null, null}
        });
        System.out.println("Test move DOWN - Merge Three");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveDown_MergeFour() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null}
        });
        board.moveTiles(Direction.DOWN);
        Board expBoard = new Board(new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {new Tile(4), null, null, null},
            {new Tile(4), null, null, null}
        });
        System.out.println("Test move DOWN - Merge Four");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveLeft_NoMerge() {
        Board board = new Board(new Tile[][]{
            {null, new Tile(2), null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.LEFT);
        Board expBoard = new Board(new Tile[][]{
            {new Tile(2), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move LEFT - No Merge");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveLeft_MergeTwo() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), new Tile(2), null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.LEFT);
        Board expBoard = new Board(new Tile[][]{
            {new Tile(4), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move LEFT - Merge Two");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveLeft_MergeThree() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), new Tile(2), new Tile(2), null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.LEFT);
        Board expBoard = new Board(new Tile[][]{
            {new Tile(4), new Tile(2), null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move LEFT - Merge Three");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveLeft_MergeFour() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.LEFT);
        Board expBoard = new Board(new Tile[][]{
            {new Tile(4), new Tile(4), null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move LEFT - Merge Four");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveRight_NoMerge() {
        Board board = new Board(new Tile[][]{
            {null, new Tile(2), null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.RIGHT);
        Board expBoard = new Board(new Tile[][]{
            {null, null, null, new Tile(2)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move RIGHT - No Merge");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveRight_MergeTwo() {
        Board board = new Board(new Tile[][]{
            {null, new Tile(2), new Tile(2), null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.RIGHT);
        Board expBoard = new Board(new Tile[][]{
            {null, null, null, new Tile(4)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move RIGHT - Merge Two");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveRight_MergeThree() {
        Board board = new Board(new Tile[][]{
            {null, new Tile(2), new Tile(2), new Tile(2)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.RIGHT);
        Board expBoard = new Board(new Tile[][]{
            {null, null, new Tile(2), new Tile(4)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move RIGHT - Merge Three");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveRight_MergeFour() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.moveTiles(Direction.RIGHT);
        Board expBoard = new Board(new Tile[][]{
            {null, null, new Tile(4), new Tile(4)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test move RIGHT - Merge Four");
        boolean expResult = true;
        boolean similar = board.isSimilarTo(expBoard);
        assertEquals(expResult, similar);
    }

    /**
     * Test of addRandomTile method, of class Board.
     */
    @Test
    public void testAddRandomTile() {
        Board board = new Board(new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        board.addRandomTile();
        System.out.println("Test addRandomTile");
        int expResult = 15;
        int nbFreeTiles = board.getNbFreeTiles();
        assertEquals(expResult, nbFreeTiles);
    }

    /**
     * Test of getNbFreeTiles method, of class Board.
     */
    @Test
    public void testGetNbFreeTiles() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        System.out.println("Test getNbFreeTiles");
        int expResult = 12;
        int nbFreeTiles = board.getNbFreeTiles();
        assertEquals(expResult, nbFreeTiles);
    }

    /**
     * Test of check2048 method, of class Board.
     */
    @Test
    public void testCheck2048_Pass() {
        Board board = new Board(new Tile[][]{
            {new Tile(2048), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}}
        );
        System.out.println("Test check2048 - Pass");
        boolean expResult = true;
        boolean check2048 = board.check2048();
        assertEquals(expResult, check2048);
    }

    /**
     * Test of check2048 method, of class Board.
     */
    @Test
    public void testCheck2048_Fail() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}}
        );
        System.out.println("Test check2048 - Fail");
        boolean expResult = false;
        boolean check2048 = board.check2048();
        assertEquals(expResult, check2048);
    }

    /**
     * Test of isSimilarTo method, of class Board.
     */
    @Test
    public void testIsSimilarTo_SimilarRow() {
        Board board1 = new Board(new Tile[][]{
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}}
        );
        Board board2 = new Board(new Tile[][]{
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}}
        );
        System.out.println("Test isSimilarTo - Similar ROW");
        boolean expResult = true;
        boolean similar = board1.isSimilarTo(board2);
        assertEquals(expResult, similar);
    }

    /**
     * Test of isSimilarTo method, of class Board.
     */
    @Test
    public void testIsSimilarTo_SimilarColumn() {
        Board board1 = new Board(new Tile[][]{
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null}}
        );
        Board board2 = new Board(new Tile[][]{
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null},
            {new Tile(2), null, null, null}}
        );
        System.out.println("Test isSimilarTo - Similar COLUMN");
        boolean expResult = true;
        boolean similar = board1.isSimilarTo(board2);
        assertEquals(expResult, similar);
    }

    public void testIsSimilarTo_SimilarNull() {
        Board board1 = new Board(new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}}
        );
        Board board2 = new Board(new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}}
        );
        System.out.println("Test isSimilarTo - Similar NULL");
        boolean expResult = true;
        boolean similar = board1.isSimilarTo(board2);
        assertEquals(expResult, similar);
    }

    /**
     * Test of isSimilarTo method, of class Board.
     */
    @Test
    public void testIsSimilarTo_NotSimilar() {
        Board board1 = new Board(new Tile[][]{
            {null, null, null, new Tile(2)},
            {null, null, null, new Tile(2)},
            {null, null, null, new Tile(2)},
            {null, null, null, new Tile(2)}}
        );
        Board board2 = new Board(new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {new Tile(2), null, null, null},
            {null, null, null, null}}
        );
        System.out.println("Test isSimilarTo - Not Similar");
        boolean expResult = false;
        boolean similar = board1.isSimilarTo(board2);
        assertEquals(expResult, similar);
    }

}

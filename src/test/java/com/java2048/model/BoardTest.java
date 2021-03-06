package com.java2048.model;

import org.junit.jupiter.api.Assertions;
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
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
        assertTrue(board.isSimilarTo(expBoard));
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testAbleToMove_Pass() {
        Board board = new Board(new Tile[][]{
            {new Tile(16), new Tile(2), new Tile(16), new Tile(2)},
            {null, new Tile(4), new Tile(8), new Tile(4)},
            {new Tile(4), new Tile(64), new Tile(64), new Tile(8)},
            {new Tile(2), new Tile(4), new Tile(2), new Tile(32)}
        });
        System.out.println("Test Able to move - Pass");
        assertTrue(board.ableToMove());
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testAbleToMove_FullPass() {
        Board board = new Board(new Tile[][]{
            {new Tile(16), new Tile(2), new Tile(16), new Tile(2)},
            {new Tile(8), new Tile(4), new Tile(8), new Tile(4)},
            {new Tile(4), new Tile(64), new Tile(64), new Tile(8)},
            {new Tile(2), new Tile(4), new Tile(2), new Tile(32)}
        });
        System.out.println("Test Able to move - Full Pass");
        assertTrue(board.ableToMove());
    }

    /**
     * Test of addRandomTile method, of class Board.
     */
    @Test
    public void testAddRandomTile() {
        Board boardNull = new Board(new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        Board boardTest = new Board(new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
        boardTest.addRandomTile();
        System.out.println("Test addRandomTile");
        assertFalse(boardNull.isSimilarTo(boardTest));
    }

    /**
     * Test of addRandomTile method, of class Board.
     */
    @Test
    public void testAddRandomTile_ExpectedException() {
        Board board = new Board(new Tile[][]{
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)}
        });
        System.out.println("Test addRandomTile - ExpectedException");
        Assertions.assertThrows(RuntimeException.class, () -> {
            board.addRandomTile();
        });
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
        assertTrue(board.check2048());
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
        assertTrue(board1.isSimilarTo(board2));
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
        assertTrue(board1.isSimilarTo(board2));
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
        assertTrue(board1.isSimilarTo(board2));
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
        assertFalse(board1.isSimilarTo(board2));
    }

    /**
     * Test of isSimilarTo method, of class Board.
     */
    @Test
    public void testIsSimilarTo_NotSimilar2() {
        Board board1 = new Board(new Tile[][]{
            {null, null, null, new Tile(2)},
            {null, null, null, new Tile(2)},
            {null, null, null, new Tile(2)},
            {null, null, null, new Tile(2)}}
        );
        Board board2 = new Board(new Tile[][]{
            {null, null, null, new Tile(2)},
            {null, null, null, new Tile(2)},
            {null, null, null, new Tile(4)},
            {null, null, null, new Tile(2)}}
        );
        System.out.println("Test isSimilarTo - Not Similar 2");
        assertFalse(board1.isSimilarTo(board2));
    }

}

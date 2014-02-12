package ValidSudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsValidSudoku() {
		char[][] board1 = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		char[][] board2 = {
				{'5','3','.','.','7','.','8','2','.'},
				{'6','.','.','1','9','5','4','.','.'},
				{'.','9','8','.','.','.','7','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		String[] b3 = {
				"....4.9..",
				"..21..3..",
				".........",
				"........3",
				"...2.....",
				".....7...",
				"...61....",
				"..9......",
				".......9."};
		String[] b4 = {
				".81....6.",
				"....5.2..",
				".....2...",
				"....2..86",
				"....96...",
				"..3..8...",
				"...23...7",
				"...98....",
				"...4....."
		};
		char[][] board3 = new char[9][];
		for (int i = 0;i < 9;i++)
			board3[i] = b3[i].toCharArray();
		char[][] board4 = new char[9][];
		for (int i = 0;i < 9;i++)
			board4[i] = b4[i].toCharArray();
		Solution s = new Solution();
		if (!s.isValidSudoku(board1))
			fail("The tested Sudoku should be valid");
		if (!s.isValidSudoku(board2))
			fail("The tested Sudoku should not be valid");
		if (!s.isValidSudoku(board3))
			fail("The tested Sudoku should be valid");
		if (!s.isValidSudoku(board4))
			fail("The tested Sudoku should be valid");
	}

}

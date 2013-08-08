package graphics;

import java.util.Arrays;

import objects.GameObject;

public class Collision {
	private static boolean[][] gameState;
	
	// +2 for the border around the window
	public static void initGameState(){
		gameState = new boolean[GUI.canvas.getWidth() + 2][GUI.canvas.getHeight() + 2];
		
		// make border
		Arrays.fill(gameState[0], true);
		Arrays.fill(gameState[gameState.length - 1], true);
		
		for (int i = 0; i < gameState.length; ++i){
			for (int j = 0; j < gameState[0].length; j += gameState.length - 1){
				gameState[i][j] = true;
			}
		}
	}
	
	// gives where the box will be after moving
	public static boolean[][] getCollisionRect(GameObject obj){
		int top = (int)(obj.yPos + obj.yVel), bottom = top + obj.image.getHeight();
		int left = (int)(obj.xPos + obj.xVel), right = left + obj.image.getWidth();
		
		
		boolean[][] collRect = new boolean[obj.image.getWidth()][obj.image.getHeight()];
		
		for (int i = top; i < bottom; ++i){
			for (int j = left; j < right; ++j){
				if (0 <= i && i < gameState.length && 0 <= j && j < gameState[0].length){
					collRect[i-top][j-left] = gameState[i][j];
				}
			}
		}
		
		return collRect;
	}
	
	// x1, y1, xf, yf
	public static void drawRect(int[] numsOld, int[] numsNew, boolean erase){
		
		// erase old
		if (erase){
			for (int i = numsOld[1]; i < numsOld[3]; ++i){
				for (int j = numsOld[0]; j < numsOld[2]; ++j){
					if (numsOld[1] == i || numsOld[3] - 1 == i ||
						numsOld[0] == j || numsOld[2] - 1 == j){
						gameState[i][j] = false;
					}
				}
			}
		}
		
		// draw new
		for (int i = numsNew[1]; i < numsNew[3]; ++i){
			for (int j = numsNew[0]; j < numsNew[2]; ++j){
				if (numsNew[1] == i || numsNew[3] - 1 == i ||
					numsNew[0] == j || numsNew[2] - 1 == j){
					gameState[i][j] = true;
				}
			}
		}
	}
}

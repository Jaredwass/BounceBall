package graphics;

import objects.GameObject;

public class Collision {
	private static boolean[][] gameState;
	
	public static void initGameState(){
		gameState = new boolean[GUI.canvas.getWidth()][GUI.canvas.getHeight()];
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
	
	// check for collision in a given direction
	public static boolean isColl(boolean[][] collRect, boolean yCheck){
		for (int i = 0; i < collRect.length; ++i){
			int count = 0;
			for (int j = 0; j < collRect[0].length; ++j){
				boolean isOccupied = (yCheck)?collRect[i][j]:collRect[j][i];
				if (isOccupied) ++count;
			}
			
			if (count >= 2){
				return true;
			}
		}
		
		return false;
	}
	
	// x1, y1, xf, yf
	public static void drawRect(GameObject obj, boolean messWithOld, boolean messWithNew, boolean drawOld, boolean drawNew){
		// make arrays
		int[] numsOld = new int[]{(int) obj.oldxPos, (int) obj.oldyPos,
                (int) (obj.oldxPos + obj.image.getWidth()), 
                (int) (obj.oldyPos + obj.image.getHeight())};
		int[] numsNew = new int[]{(int) obj.xPos, (int) obj.yPos,
                (int) (obj.xPos + obj.image.getWidth()), 
                (int) (obj.yPos + obj.image.getHeight())};
		
		// draw old
		if (messWithOld){
			for (int i = numsOld[1]; i < numsOld[3]; ++i){
				for (int j = numsOld[0]; j < numsOld[2]; ++j){
					if (numsOld[1] == i || numsOld[3] - 1 == i ||
							numsOld[0] == j || numsOld[2] - 1 == j){
						gameState[i][j] = drawOld;
					}
				}
			}
		}
		
		// draw new
		if (messWithNew){
			for (int i = numsNew[1]; i < numsNew[3]; ++i){
				for (int j = numsNew[0]; j < numsNew[2]; ++j){
					if (numsNew[1] == i || numsNew[3] - 1 == i ||
							numsNew[0] == j || numsNew[2] - 1 == j){
						gameState[i][j] = drawNew;
					}
				}
			}
		}
	}
}

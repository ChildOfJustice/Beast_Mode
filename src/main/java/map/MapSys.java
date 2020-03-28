package map;

import game.elements.MyBox;
import game.elements.WorldObject;

public class MapSys {
    public static int worldSize = 100;
    public static float cellSize = 0.1f;

    public static WorldObject[][][] map = new WorldObject[worldSize][worldSize][worldSize];

    public static void initMap(){
        for (int i = 0; i < worldSize; i++) {
            for (int j = 0; j < worldSize; j++) {
                map[i][0][j] = new MyBox("Test\\block1.png", i*cellSize, 0, j*cellSize, cellSize, cellSize, cellSize, 0);
            }
        }

        for (int i = 0; i < worldSize; i++) {
            for (int j = 0; j < worldSize; j++) {
                for (int k = 0; k < worldSize; k++) {
                    //
                }
            }
        }
    }
}

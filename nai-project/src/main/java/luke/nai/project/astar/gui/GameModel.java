package luke.nai.project.astar.gui;

/**
 *
 * @author LukaszDrapala
 */
public class GameModel {
    
    private Status rows[][];
    private int start;
    private int end;
    
    public void setFieldsInRow(int row) {
        rows = new Status[row][row];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length; j++) {
                rows[i][j] = Status.NONE;
            }
        }
    }
    
    public void setStart(int x, int y){
        rows[y][x] = Status.START;
    }
    public void setEnd(int x, int y){
        rows[y][x] = Status.END;
    }
    public void setWall(int x, int y){
        rows[y][x] = Status.WALL;
    }
    public void clear(int x, int y){
        rows[y][x] = Status.NONE;
    }
    
    public void start(){
        
    }
    
}

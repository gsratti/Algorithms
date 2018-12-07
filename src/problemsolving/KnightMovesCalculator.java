package problemsolving;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Cell {

    int x,y;
    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
class QNode {

    Cell cell;
    Integer dist;

    public QNode(Cell cell, int dist) {
        this.cell = cell;
        this.dist = dist;
    }
}
public class KnightMovesCalculator {

    public static int getMinMoves(Cell start, Cell dest, int n) {

        if(start.x <0 || start.y <0 || start.x >=n || start.y >=n)
            return -1;
        if(dest.x <0 || dest.y <0 || dest.x >=n || dest.y >=n)
            return -1;

        Queue<QNode> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        queue.add(new QNode(start, 0));
        vis[start.x][start.y] = true;

        while(!queue.isEmpty()) {

            QNode curr = queue.poll();
            int parentDistance = curr.dist;
            if(isEqual(curr.cell, dest)) {
                return curr.dist;         // Multiply by three for total steps; one step of knight landing on the third cell, in diagonal manner.
            }
            for(Cell neighbour : neighbours(curr.cell, n)) {
                if(!vis[neighbour.x][neighbour.y]) {
                    queue.add(new QNode(neighbour, parentDistance + 1));
                    vis[neighbour.x][neighbour.y] = true;
                }

            }
        }
        return -1;
    }

    private static List<Cell> neighbours(Cell cell, int n) {

        List<Cell> neighbours = new ArrayList<>();
       
        int xpos[] = {1, 2, -1, -2, 1,  2, -1, -2};
        int ypos[] = {2, 1, -2, -1, -2, -1, 2, 1};

        for(int i =0; i<xpos.length; i++)
        {
            if(inBoardBounds(xpos[i],ypos[i],cell, n)) {
               
                neighbours.add(new Cell(cell.x + xpos[i],cell.y + ypos[i]));
            
            }
        }
        return neighbours;
    }

    private static boolean inBoardBounds(int i, int j, Cell cell, int n) {
        if(cell.x+i <0 || cell.y+j <0 || cell.x+i >= n || cell.y+j >= n)
            return false;
        return true;
    }

    private static boolean isEqual(Cell cell, Cell dest) {
        return (cell.x == dest.x && cell.y == dest.y);

    } 

    public static void main(String args[]) {
        System.out.println(getMinMoves(new Cell(5,3), new Cell(0,7), 8));
    }

}

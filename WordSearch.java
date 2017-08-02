package wordSearch;

import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.List;

class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        List<Coordinate>[] hash = new List[58];
        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                int position = board[i][j] - 'A';
                if (hash[position] == null){
                    hash[position] = new ArrayList<>();
                }
                hash[position].add(new Coordinate(i,j));
            }
        }

        int positon = word.charAt(0)-'A';
        if (hash[positon] == null){
            return false;
        }
        for (Coordinate tmp : hash[positon]){
            used[tmp.x][tmp.y] = true;
            if (back(board, word, 1, hash, tmp, used)) {
                return true;
            }
            used[tmp.x][tmp.y] = false;
        }

        return false;
    }

    public boolean back(char[][] board, String word, int index, List<Coordinate>[] hash, Coordinate source, boolean[][] used){
        if (index >= word.length()){
            return true;
        }
        else {
            int position = word.charAt(index)-'A';
            if (hash[position] == null){
                return false;
            }
            for (Coordinate tmp : hash[position]){
                if (isAdjcent(source, tmp) && !used[tmp.x][tmp.y]){
                    used[tmp.x][tmp.y] = true;
                    boolean flag = back(board, word, index+1, hash, tmp, used);
                    if(flag){
                        return true;
                    }
                    used[tmp.x][tmp.y] = false;
                }
            }
        }
        return false;
    }

    public boolean isAdjcent(Coordinate x, Coordinate y){
        int row = Math.abs(x.x - y.x);
        int col = Math.abs(x.y - y.y);
        if (row == 0 && col == 1){
            return true;
        }
        else if (row == 1 && col == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static void  main(String[] args){
        char[][] board = new char[][]{
                {'a', 'a'}
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
        };
        WordSearch t = new WordSearch();
        String tmp = "aaa";
        if (t.exist(board, tmp)){
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
//        char t = 'a';
//        char z = 'z';
//        char b = 'A';
//        char Z = 'Z';
//        System.out.println((int)t);
//        System.out.println((int)b);
//        System.out.println((int)z);
//        System.out.println((int)Z);
    }
}

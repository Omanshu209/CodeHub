/*
Question

You're given a representation of a 5x5 2D map, and if you can only move left, right, up, or down, determine how many moves you would have to make to get between two points on the map.

Task : Determine the total number of moves that are needed between two points on a map.  The points that you move between are marked with a P and the spaces in between are marked with X.

Input Format : A string that represents the 2D space starting at the top left.  Each level from top to bottom is separated by a comma.
Output Format : An integer that represents the total number of moves that you had to make.
*/

import java.util.Scanner;

public class Map
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] map = sc.next().split(",");
        int pos_y = -1, pos_x = -1, target_pos_x = -1, target_pos_y = -1;
        boolean startPosFound = false;
        
        for(int y = 0 ; y < 5 ; y++)
            for(int x = 0 ; x < 5 ; x++)
                if(map[y].toUpperCase().charAt(x) == 'P')
                {
                    if(startPosFound)
                    {
                        target_pos_y = y;
                        target_pos_x = x;
                        break;
                    }
                    
                    pos_y = y;
                    pos_x = x;
                    startPosFound = true;
                }
        
        System.out.println(Math.abs(target_pos_x - pos_x) + Math.abs(target_pos_y - pos_y));
    }
}

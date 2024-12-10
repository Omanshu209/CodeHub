import java.util.List;
import java.util.LinkedList;

public class RatInAMaze
{
	public static boolean notVisited(int i, int j, List<List<Integer>> visited)
	{
		for(List<Integer> pos : visited)
		{
			if(pos.get(0) == i && pos.get(1) == j)
			return false;
		}
		
		return true;
	}
	
	public static List<List<Integer>> addPos(int i, int j, List<List<Integer>> visited)
	{
		List<List<Integer>> newVisited = new LinkedList<>();
		
		for(List<Integer> pos : visited)
			newVisited.add(pos);
		
		List<Integer> pos = new LinkedList<Integer>();
		pos.add(i);
		pos.add(j);
		newVisited.add(pos);
		return newVisited;
	}
	
	public static String solver(int[][] maze, String path, int i, int j, List<List<Integer>> visited)
	{
		if(i == maze.length - 1 && j == maze[0].length - 1)
		{
			System.out.println(path);
			return "";
		}
		
		if(i + 1 < maze.length && maze[i + 1][j] == 1 && notVisited(i + 1, j, visited))
			solver(maze, path + "D", i + 1, j, addPos(i + 1, j, visited));
		
		if(j + 1 < maze[0].length && maze[i][j + 1] == 1 && notVisited(i, j + 1, visited))
			solver(maze, path + "R", i, j + 1, addPos(i, j + 1, visited));
		
		if(i > 0 && maze[i - 1][j] == 1 && notVisited(i - 1, j, visited))
			solver(maze, path + "U", i - 1, j, addPos(i - 1, j, visited));
		
		if(j > 0 && maze[i][j - 1] == 1 && notVisited(i, j - 1, visited))
			solver(maze, path + "L", i, j - 1, addPos(i, j - 1, visited));
		
		return "";
	}
	
	public static void main(String[] args)
	{
		List<List<Integer>> visited = new LinkedList<>();
		int[][] maze = {
			{1, 0, 0, 0},
			{1, 1, 0, 1},
			{1, 1, 0, 0},
			{0, 1, 1, 1}
		};
		
		solver(maze, "", 0, 0, visited);
	}
}

public class matrix_prod
{
	public static int[][] mul_matrix(int[][] mat1, int[][] mat2)
	{
		int[][] out_mat = new int[mat1.length][mat2[0].length];
		
		for(int i = 0 ; i < mat1.length ; i++)
		{
			for(int j = 0 ; j < mat2[0].length ; j++)
			{
				int val = 0;
				
				for(int k = 0 ; k < mat2.length ; k++)
					val += mat1[i][k] * mat2[k][j];
				
				out_mat[i][j] = val;
			}
		}
		
		return out_mat;
	}
	
	public static void print_matrix(int[][] mat)
	{
		for(int i = 0 ; i < mat.length ; i++)
		{
			for(int j = 0 ; j < mat[0].length ; j++)
				System.out.print(mat[i][j] + "  ");
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		/*
		int[][] mat1 = {
					{1, 2, 3}, 
					{4, 5, 6}, 
					{7, 8, 9}
			}, 
			
				mat2 = {
					{9, 8, 7}, 
					{6, 5, 4}, 
					{3, 2, 1}
			};
		*/
		
		/*
		int[][] mat1 = {
					{3, 5}, 
					{4, -2}
			}, 
				mat2 = {
					{2}, 
					{4}
			};
		*/
		
		int[][] mat1 = {
					{1, 2, 3}, 
					{4, 5, 6}, 
					{7, 8, 9}
			}, 
			
				mat2 = {
					{1, 2}, 
					{2, 1}, 
					{1, 2}
			};
		
		print_matrix(mul_matrix(mat1, mat2));
	}
}

//Kruskal Algorithm
import java.util.*;

public class Kruskal {
	
	//Used to track the Running Time of the Algorithm
	static long startTime = System.currentTimeMillis();
		
  public static void main(String[] args){
	  @SuppressWarnings("resource")
	 
	  int[] parent = new int[5];
	  int min;
	  int u=0;
	  int v=0;
	  int noOfEdges = 1;
	  int total = 0;
	  
	
	  int matrix[][] = new int[][] {
		  								{0, 1, 0, 0, 0},
		  								{1, 0, 0, 0, 0},
		  								{0, 0, 0, 0, 0},
		  								{0, 0, 0, 0, 0},
		  								{0, 0, 0, 0, 0},
	  								};
         int w= 0;
 	for(int i=1;i<4;i++)
 	{
 		Random rand = new Random();

 		int a = rand.nextInt(i)+1;
 		w = rand.nextInt(5)+1;
 		matrix[i+1][a] = w;
 		matrix[a][i+1] = w;
 		
 	}

 	System.out.println( " ");
 	for(int i = 0; i<5; i++){
 		for(int j = 0; j<5; j++)
 		{
 			if(matrix[i][j] == 0 && i!=j)
 			{
 				Random rand = new Random();
 				
 				matrix[i][j] = matrix[j][i] = rand.nextInt(100)+20;
 			}
 		}}
 	
 	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
	        System.out.print(matrix[i][j] + " ");
	    }
	    System.out.println();
	    
	}
 	
	  
	  while (noOfEdges <5 ){
		  min = 999;
		  for (int i =0;i<5;i++){
			  for (int j=0;j<5;j++){
				  if (matrix[i][j] < min){
					  min = matrix[i][j];
					  u = i;
					  v = j;
				  }
			  }
		  }
		  while(parent[u]!=0){
			  u=parent[u];
		  }
		  while(parent[v]!=0){
			  v=parent[v];
		  }
		  if (v!=u){
			  noOfEdges++;
			  System.out.println("Edge found" + u + "-->" + v + " Min " +min );
			  total+=min;
			  parent[v]=u;
		  }
		  matrix[u][v] = matrix[v][u] = 999;
	  }
		  System.out.println("The Weight of the MST is "+total);
		  long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("The Time Taken is... " + totalTime + " ms");
  }

}
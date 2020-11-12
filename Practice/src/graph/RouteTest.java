package graph;

public class RouteTest {

	public static void main(String[] args) {

		Route route = new Route(9);
		
		route.addEdge(0, 1);
		route.addEdge(1, 2);
		route.addEdge(1, 3);
		route.addEdge(2, 4);
		route.addEdge(2, 3);
		route.addEdge(3, 4);
//		route.addEdge(3, 5);
		route.addEdge(5, 6);
		route.addEdge(5, 7);
		route.addEdge(6, 8);	
		
		
		/*
		
		 
		   0
		  /
		 1 -- 3    7
		 |  / | \ /
		 | /  |  5
		 2 -- 4   \
		 		   6 - 8
		 
		 
		 */
		
		
		System.out.println(route.search(1, 8));
	}
}

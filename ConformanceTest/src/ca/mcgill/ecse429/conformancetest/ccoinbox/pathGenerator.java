//import java.util.ArrayList;
//
//import ca.mcgill.ecse429.conformancetest.ccoinbox.RoundTripPath.Node;
//
//public class pathGenerator{
//
//	public void printAllPaths(Node node, ArrayList path){
//		
//		if(node==null){
//	        return;
//	    }
//		
//	    path.add(node);
//	
//	    if(node.left==null && node.right==null)
//	    {
//	        System.out.println(path);
//	        return;
//	    }
//	    else
//	    {
//	        printAllRootToLeafPaths(node.left,path);
//	        printAllRootToLeafPaths(node.right,path);
//	    } 
//		
//	}
//}
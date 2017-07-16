import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		
		//Paste ONLY the triangle from the website into the input and press Enter to read it and execute
		
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		Node start = new Node(num, null);
		int lines = 100;
		
		ArrayList<ArrayList<Node>> triangle = new ArrayList<ArrayList<Node>>();
		ArrayList<Node> row = new ArrayList<Node>();
		row.add(start);
		triangle.add(row);
		
		for(int i = 1; i < lines; i++){
			row = new ArrayList<Node>();
			for(int j = 0; j <= i; j++){
				num = in.nextInt();
				Node newNode = new Node(num, null);
				row.add(newNode);
				if(j == 0){
					triangle.get(i-1).get(0).AddConnection(newNode);
				}
				else if(j == i){
					triangle.get(i-1).get(triangle.get(i-1).size() - 1).AddConnection(newNode);
				}
				else{
					triangle.get(i-1).get(j-1).AddConnection(newNode);
					triangle.get(i-1).get(j).AddConnection(newNode);
				}
			}
			triangle.add(row);
		}
		
		in.close();
		
		for(int i = lines - 2; i >= 0; i--){
			ArrayList<Node> templist = triangle.get(i);
			for(int j=0;j<templist.size();j++){
				if(templist.get(j).connections.get(0).sumDown >= templist.get(j).connections.get(1).sumDown){
					templist.get(j).replaceSumDown(templist.get(j).connections.get(0).sumDown);
				}
				else{
					templist.get(j).replaceSumDown(templist.get(j).connections.get(1).sumDown);
				}
			}
		}
		
		System.out.println(triangle.get(0).get(0).sumDown);
	}
	
}

class Node{
	
	int value;
	int sumDown;
	ArrayList<Node> connections = new ArrayList<Node>();
	
	public Node(int value, Node to){
		this.value = value;
		this.sumDown = value;
		if(to != null){
			this.connections.add(to);
		}
	}
	
	public void AddConnection(Node conn){
		this.connections.add(conn);
	}
	
	public void replaceSumDown(int toAdd){
		this.sumDown += toAdd;
	}
}

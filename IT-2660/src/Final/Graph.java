package Final;

import java.util.*;
import javax.swing.JOptionPane;

class Graph{
	
    private Listing[] vertex;
    private int[][] edges;
    private int Vertices;
    private int nodeCheck = 0;
    private int selectNum = 0;
    private int maxV;

    Graph(int d){
    	
        vertex = new Listing[d];
        edges = new int[d][d];
        Vertices = 0;
        maxV = d;
    }
    private void depthFirstSearch(int firstVertex){
    	
        int v;
        Stack<Integer> nodeStack = new Stack<>();

        for(int i = 0; i<Vertices; i++){
        	
            if (vertex[i] != null) {
                vertex[i].setPush(false);
            }
        }
        
        nodeStack.push(firstVertex);
        vertex[firstVertex].setPush(true);

        while (!nodeStack.empty()){
        	
            v = nodeStack.pop();
            vertex[v].visit();
            nodeCheck++;
            for (int column = 0; column < Vertices; column++){
            	

                if(edges[v][column] == 1 && vertex[column].getPush()){
                	
                    nodeStack.push(column);
                    vertex[column].setPush(true);
                }
            }
        }
    }
    private void breathFirstSearch(int firstVertex){
    	
        int V;
        Queue<Integer> nodeQueue = new LinkedList<>();

        for(int i = 0; i < Vertices; i++){
        	
            if(vertex[i] != null)
                vertex[i].setPush(false);
        }
        nodeQueue.add(firstVertex);
        vertex[firstVertex].setPush(true);

        while(!nodeQueue.isEmpty()){
        	
            V = nodeQueue.remove();
            vertex[V].visit();
            nodeCheck++;
            for(int column = 0; column < Vertices; column++){
            	
                if(edges[V][column] == 1 && vertex[column].getPush()){
                	
                    nodeQueue.add(column);
                    vertex[column].setPush(true);
                }
            }
        }
    }

    private void dijkstra(int firstVertex){
    	
        int v;
        LinkedList<Integer> nodeQueue = new LinkedList<>();

        int i = 0;
        while (i < Vertices){
        	
            if(vertex[i] != null)
                vertex[i].setPush(false);
            i++;
        }
        
        nodeQueue.add(firstVertex);
        vertex[firstVertex].setPush(true);

        while(!nodeQueue.isEmpty()){
        	
            v = nodeQueue.remove();
            vertex[v].visit();
            nodeCheck++;
            for(int column = 0; column < Vertices; column++){
            	
                if(edges[v][column] == 1 && vertex[column].getPush()){
                	
                    nodeQueue.add(column);
                    vertex[column].setPush(true);
                }
            }
        }
    }

    private void insertVertex(int vertexNumber, Listing newListing){
    	
        if(vertexNumber >= maxV){
        	
            return;
        }
        vertex[vertexNumber] = newListing.deepCopy();
        Vertices++;
    }

    private void insertEdge(int fromVertex, int toVertex){
    	
        if(vertex[fromVertex] == null || vertex[toVertex] == null)
            return;
        edges[fromVertex][toVertex] = 1;
    }

    void showVertex(int vertexNumber){
    	
        System.out.print(vertex[vertexNumber]);
    }

    void showEdges(int vertexNumber){
    	
        for(int column = 0; column < Vertices; column++){
        	
            if(edges[vertexNumber][column] == 1){
            	
                System.out.println(vertexNumber + "," + column);
            }
        }
        System.out.println();
    }

    void initializeNodes(Graph G, int nodesNum){
    	
        Random random = new Random();
        
        for (int i = 0; i < nodesNum; i++){
        	
            Listing v = new Listing(random.nextInt(32000) + 1);
            G.insertVertex(i, v);
        }

        int vertexListNumber = G.vertex.length;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nodesNum; i++ ){
        	
            list.add(i);
        }
      
        Collections.shuffle(list);
        
        for (int i = 0; i < vertexListNumber; i++){
        	
            int randnum = random.nextInt(4);
            for (int j = 0; j < randnum; j++ ){
            	
                int rand = random.nextInt(4);
                G.insertEdge(i, list.get(rand));
            }
        }

    }

    int search(){
    	
        String search = JOptionPane.showInputDialog("Enter Node to search:");
        
        try{
        	
            if(search != null){
            	
                selectNum = Integer.parseInt(search);
            }
        }
        
        catch (NumberFormatException e){
        	
            selectNum = 0;
        }
        return selectNum;
    }

    private int selectPane(){
    	
        String paneSelect = JOptionPane.showInputDialog("Choose a search method:" +
                "\n1: Use Depth-First Search" +
                "\n2: Use Breadth-First Search" +
                "\n3: Use Dijkstra's Search" +
                "\n4: Exit Program");
        int selectNum = 0;

        try{
        	
            if(paneSelect != null){
            	
                selectNum = Integer.parseInt(paneSelect);
            }
        }
        catch (NumberFormatException ignored){
        	System.out.println("");
        }
        return selectNum;
    }

    void algorithmChoice(Graph graph, int vertexStart){
    	
        int paneNum = 0;
        while (paneNum != 4){
        	
            paneNum = selectPane();
            switch (paneNum){
            
                case 1:
                	System.out.println("||BREADTH-FIRST||\n");
                    graph.breathFirstSearch(vertexStart);
                    System.out.println("Nodes counted: " + nodeCheck + "\n");
                    break;
                case 2:
                	System.out.println("||DEPTH-FIRST||\n");
                    graph.depthFirstSearch(vertexStart);
                    System.out.println("Nodes counted: " + nodeCheck+ "\n");
                    break;
                case 3:
                	System.out.println("||DIJKSTRA's||\n");
                    graph.dijkstra(vertexStart);
                    System.out.println("Nodes counted: " + nodeCheck+ "\n");
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid, enter 4 to exit.");
                    break;
            }
        }
    }


}
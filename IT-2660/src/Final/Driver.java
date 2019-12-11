package Final;

public class Driver                                        //I found this assignment pretty confusing, so i hope this is formatted the way you want it. I mixed my ideas with others 
{                                                          //I saw online and in the book. That being said, most others I saw did this is a very different way and format. 
    public static void main(String[] args)
    {
              
        Graph graph = new Graph(32000);                     //I ran into a problem with making the graph index range any larger, not sure how to get around this issue. I tried
        graph.initializeNodes(graph, 32000);                //allocating more memory in eclipse for heap space, but it didn't work. 30-32k seemed as high as I could take it. 

        for(int i = 1; i<=5; i++)
        {
            System.out.print("Node " + i + "\'s ");
            graph.showVertex(i);
            System.out.print("Routes: \n");
            graph.showEdges(i);
            System.out.println("\n");
        }

        int select = graph.search();
        graph.algorithmChoice(graph, select);
    }
}
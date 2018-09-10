import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

class Agent {

    int noOfvertices; //number of vertices
    LinkedList<SystemState> mainGraph[]; // array of lists of vertices
    static int path[]; //THhe solution path

    //constructor

    public Agent(int vertices) {
        this.noOfvertices = vertices;
        mainGraph = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            mainGraph[i] = new LinkedList<>();
        }
    }

    //add edges to the graph
    public static void addEdge(Agent agent, int noOfvertices, SystemState state) {

        agent.mainGraph[noOfvertices].add(state);
    }

    public static SystemState returnState(
            int source,
            int missionariesSideA,
            int cannibalsSideA,
            int missionariesSideB,
            int cannibalsSideB,
            int boatPosition,
            int nodeNumber
    ) {
        return new SystemState(
                source,
                missionariesSideA,
                cannibalsSideA,
                missionariesSideB,
                cannibalsSideB,
                boatPosition,
                nodeNumber
        );
    }

    public static void printGraph(Agent agent) {
        for (int i = 0; i < agent.noOfvertices; i++) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for (SystemState pCrawl : agent.mainGraph[i]) {
                System.out.print(" -> " + pCrawl.getNodeNumber());
            }
            System.out.println("\n");
        }
    }

    public static void main(String args[]) {
        Agent newAgent = new Agent(15);


        addEdge(newAgent, 0, returnState(0, 3, 2, 0, 1, 1, 1));
        addEdge(newAgent, 0, returnState(0, 2, 2, 1, 1, 1, 2));
        addEdge(newAgent, 0, returnState(0, 3, 1, 0, 2, 1, 3));
        addEdge(newAgent, 2, returnState(2, 3, 2, 0, 1, 0, 4));
        addEdge(newAgent, 3, returnState(3, 3, 2, 0, 1, 0, 4));
        addEdge(newAgent, 4, returnState(4, 3, 0, 0, 3, 1, 5));
        addEdge(newAgent, 5, returnState(5, 3, 1, 0, 2, 0, 6));
        addEdge(newAgent, 6, returnState(6, 1, 1, 2, 2, 1, 7));
        addEdge(newAgent, 7, returnState(7, 2, 2, 1, 1, 0, 8));
        addEdge(newAgent, 8, returnState(8, 0, 2, 3, 1, 1, 9));
        addEdge(newAgent, 9, returnState(9, 0, 3, 3, 0, 0, 10));
        addEdge(newAgent, 10, returnState(10, 0, 1, 3, 2, 1, 11));
        addEdge(newAgent, 11, returnState(11, 1, 1, 2, 2, 0, 12));
        addEdge(newAgent, 11, returnState(11, 0, 2, 3, 1, 0, 13));
        addEdge(newAgent, 12, returnState(12, 0, 0, 3, 3, 1, 14));
        addEdge(newAgent, 13, returnState(13, 0, 0, 3, 3, 1, 14));

        // printGraph(newAgent);

        System.out.println("The following is Depth First Search, starting from vertex 0");
        newAgent.depthFirstSearch(newAgent, 0, 15);

        System.out.println("The solution");
              for(int i = 0; i < path.length; i++) {
                System.out.print(i + " -> ");
              }
              System.out.println(" Goal");

    }

    void depthFirstSearch(Agent agent, int statrtVertex, int noOfvertices) {
        boolean visited[] = new boolean[noOfvertices];
        path = new int[noOfvertices];
        depthFirstSearchProcess(agent, statrtVertex, visited);
    }


    void depthFirstSearchProcess(Agent newAgent, int startVertex, boolean visited[]) {

        visited[startVertex] = true; //mark the current node as visited
        System.out.print(startVertex + " \n");

        //check for adjacent nodes

        for (SystemState pCrawl : newAgent.mainGraph[startVertex]) {

            int nextNode = pCrawl.getNodeNumber();

            //check if the node is visited

            if (!visited[nextNode] ) {

                startVertex = nextNode;
                
                for(int i = 0; i < path.length; i++){
                  
                  path[i] = nextNode;
                  
                }
                depthFirstSearchProcess(newAgent, startVertex, visited);

            }

        }

    }

    static boolean isSolution(SystemState state) {
      if(
        state.missionariesSideA == 0 &&
        state.cannibalsSideA == 0 &&
        state.missionariesSideB == 3 &&
        state.cannibalsSideB == 3 &&
        state.boatPosition == 1
      ){ return true;}

      return false;
    }
}

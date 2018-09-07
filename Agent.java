import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
 
class Agent {
  int nodes;
  LinkedList<SystemState> mainGraph[];
 
  public Agent(int nodes) {
    this.nodes = nodes;
    mainGraph = new LinkedList[nodes];
 
    for(int i = 0; i < nodes; i++) {
      mainGraph[i] = new LinkedList<>();
    }
  }
 
  public static void addEdge(Agent agent, int source, SystemState state) {
    agent.mainGraph[source].add(state);
  }
 
  public static SystemState returnState(
    int missionariesSideA,
    int cannibalsSideA,
    int missionariesSideB,
    int cannibalsSideB,
    int boatPosition,
    int nodeNumber  
  ) {
    return new SystemState(
      missionariesSideA,
      cannibalsSideA,
      missionariesSideB,
      cannibalsSideB,
      boatPosition,
      nodeNumber
    );
  }
 
  public static void printGraph(Agent agent) {
    for(int i = 0; i < agent.nodes; i++) {
      System.out.println("Adjacency list of vertex " + i);
      System.out.print("head");
      for(SystemState pCrawl: agent.mainGraph[i]){
          System.out.print(" -> " + pCrawl.getNodeNumber());
      }
      System.out.println("\n");
    }
  }
 
  public static void main(String args []) {
    Agent newAgent = new Agent(15);
   
    addEdge(newAgent, 0, returnState(3, 2, 0, 1, 1, 1));
    addEdge(newAgent, 0, returnState(2, 2, 1, 1, 1, 2));
    addEdge(newAgent, 0, returnState(3, 1, 0, 2, 1, 3));
    addEdge(newAgent, 2, returnState(3, 2, 0, 1, 0, 4));
    addEdge(newAgent, 3, returnState(3, 2, 0, 1, 0, 4));
    addEdge(newAgent, 4, returnState(3, 0, 0, 3, 1, 5));
    addEdge(newAgent, 5, returnState(3, 1, 0, 2, 0, 6));
    addEdge(newAgent, 6, returnState(1, 1, 2, 2, 1, 7));
    addEdge(newAgent, 7, returnState(2, 2, 1, 1, 0, 8));
    addEdge(newAgent, 8, returnState(0, 2, 3, 1, 1, 9));
    addEdge(newAgent, 9, returnState(0, 3, 3, 0, 0, 10));
    addEdge(newAgent, 10, returnState(0, 1, 3, 2, 1, 11));
    addEdge(newAgent, 11, returnState(1, 1, 2, 2, 0, 12));
    addEdge(newAgent, 11, returnState(0, 2, 3, 1, 0, 13));
    addEdge(newAgent, 12, returnState(0, 0, 3, 3, 1, 14));
    addEdge(newAgent, 13, returnState(0, 0, 3, 3, 1, 14));
 
    // printGraph(newAgent);
    depthFirstSearch(newAgent, 0);
  }
 
  static void depthFirstSearch(Agent agent, int startVertex) {
    boolean visited[] = new boolean[startVertex];
 
    depthFirstSearchProcess(agent, startVertex, visited);
  }
 
  static void depthFirstSearchProcess(Agent agent, int startVertex, boolean visited[]) {
    visited[startVertex] = true;
 
    System.out.print(startVertex + " ");
    for(int n = 0; n < agent.mainGraph[startVertex].size(); n++) {
      if(!visited[startVertex])
        depthFirstSearchProcess(agent, n, visited);
    }
  }
}
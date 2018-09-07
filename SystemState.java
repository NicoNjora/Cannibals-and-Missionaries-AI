class SystemState {
 
  int missionariesSideA, cannibalsSideA, missionariesSideB, cannibalsSideB, boatPosition, nodeNumber;
 
  public SystemState(
    int missionariesSideA, int cannibalsSideA,
    int missionariesSideB, int cannibalsSideB,
    int boatPosition,
    int nodeNumber
  ) {
    this.missionariesSideA = missionariesSideA;
    this.cannibalsSideA = cannibalsSideA;
    this.missionariesSideB = missionariesSideB;
    this.cannibalsSideB = cannibalsSideB;
    this.boatPosition = boatPosition;
    this.nodeNumber = nodeNumber;
  }
 
  public int getNodeNumber() {
    return this.nodeNumber;
  }
}
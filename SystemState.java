class SystemState {

    int source, missionariesSideA, cannibalsSideA, missionariesSideB, cannibalsSideB, boatPosition, nodeNumber;

    public SystemState() {
    }

    public SystemState(
            int source, int missionariesSideA, int cannibalsSideA,
            int missionariesSideB, int cannibalsSideB,
            int boatPosition,
            int nodeNumber
    ) {

        this.source = source;
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

    public  int getSource(){
        return this.source;
    }

}
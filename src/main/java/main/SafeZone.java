package main;

public class SafeZone {
    private final BoardPoint startPoint;
    private final BoardPoint endPoint;

    public SafeZone(BoardPoint startPoint, BoardPoint endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    public int[] getStartPoint(){
        return this.startPoint.getActualPoint();
    }
    public int[] getEndPoint(){
        return this.endPoint.getActualPoint();
    }
}

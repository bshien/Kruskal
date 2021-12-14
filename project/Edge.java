public class Edge {
    private int v1;
    private int v2;
    private int index;
    private float weight;
    public Edge(int v1, int v2, float weight, int index){
        this.v1 = v1;
        this.v2 = v2;
        this.index = index;
        this.weight = weight;
    }
    public float getWeight(){
        return weight;
    }
    public int getIndex(){
        return index;
    }
    public int getVertex1(){
        return v1;
    }
    public int getVertex2(){
        return v2;
    }
    public void printEdge(){
        System.out.printf("%d %d %f %d\n", v1, v2, weight, index);
    }
}

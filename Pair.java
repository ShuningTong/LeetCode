public class Pair implements Comparable<Pair>{
    int index;
    int value;
    
    public Pair(int index, int value){
        this.index = index;
        this.value = value;
    }
    
    @Override
    public int compareTo(Pair other){
        return this.value - other.value;
    }
}

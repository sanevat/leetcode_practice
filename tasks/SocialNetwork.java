package tasks;

import java.util.*;

class AdjacencyListGraph<T>{
    Map<T, Map<T,Integer>>adjacencyList;

    public AdjacencyListGraph() {
        adjacencyList=new HashMap<>();
    }
    public void addVertex(T vertex){
        if(!adjacencyList.containsKey(vertex)){
            adjacencyList.put(vertex,new HashMap<>());
        }
    }
    public void addEgde(T source, T destination,int weight){
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).put(destination,weight);
        adjacencyList.get(destination).put(source,weight);
    }
    @Override
    public String toString() {
        String ret = new String();
        for (Map.Entry<T, Map<T, Integer>> vertex : adjacencyList.entrySet())
            ret += vertex.getKey() + ": " + vertex.getValue() + "\n";
        return ret;
    }
    public void shortestFromTo(T startVertex,T endVertex){
        Map<T,Integer>distances=shortestPath(startVertex);
        System.out.println(distances);
        System.out.println(distances.get(endVertex));
    }
    public Map<T, Integer> shortestPath(T startVertex) {
        Map<T, Integer> distances = new HashMap<>();
        PriorityQueue<T> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        Set<T> explored = new HashSet<>();

        for (T vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(startVertex, 0);

        queue.add(startVertex);

        while (!queue.isEmpty()) {
            T current = queue.poll();
            explored.add(current);

            for (Map.Entry<T, Integer> neighborEntry : adjacencyList.get(current).entrySet()) {
                T neighbor = neighborEntry.getKey();
                int newDist = distances.get(current) + neighborEntry.getValue();

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);

                    if (!explored.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return distances;
    }
}
public class SocialNetwork {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        AdjacencyListGraph<String> graph=new AdjacencyListGraph<>();
        int n= Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            String current= sc.nextLine();
            graph.addVertex(current);
            int numFriends= Integer.parseInt(sc.nextLine());
            for(int j=0;j<numFriends;j++){
                String friend= sc.nextLine();
                graph.addVertex(friend);
                graph.addEgde(current,friend,1);
            }
        }
        System.out.println(graph.toString());
        String start=sc.nextLine();
        String end=sc.nextLine();
        System.out.println("The shortest path is:");
        graph.shortestFromTo(start,end);

    }
}

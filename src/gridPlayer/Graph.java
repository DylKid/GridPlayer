package gridPlayer;

import java.util.*;

/**
 * A representation of a Graph data structure for the Grid Player
 * Contains only an implementation of BFS
 */
public class Graph {


    //Adjacency list for the Graph
    private Map<Position, List<Position>> adj;

    public Graph(){
        adj = new HashMap();
    }

    //Adds a position to the adjacency list with no adjacent nodes
    public void addPosition(Position Position){
        if(adj.containsKey(Position)){
        } else {
            adj.put(Position, new ArrayList());
        }
    }

    //Set the adj list, does a deep copy
    public void setAdj(Map<Location, List<Location>> newAdj){
        adj = new HashMap();
        for(Map.Entry<Location, List<Location>> e : newAdj.entrySet()){
            this.addAllAdjPosition(e.getKey(),e.getValue());
        }
    }

    //Adds the list of Locations in adjPosList to be adjacent to pos1
    public void addAllAdjPosition(Location pos1, List<Location> adjPosList){
        Position pos = new Position(pos1);
        List<Position> posList = new ArrayList();
        for(Location l : adjPosList){
            posList.add(new Position(l));
        }
        if(adj.get(pos1) == null){
            adj.put(pos, posList);
        } else {
            adj.get(pos).addAll(posList);
        }
    }

    //Adds adjPos as adjacent to pos1
    public void addAdjPosition(Position pos1, Position adjPos){
        adj.get(pos1).add(adjPos);
    }

    //Stores which positions are visited
    private HashMap<Position, Boolean> visited;
    //Stores the parent of a position
    private HashMap<Position, Position> parents;
    //Stores the distances of each position
    private HashMap<Position, Integer> distance;

    //Implementation of breadth first search
    public List<Location> bfs(Location s, Location d){
        //Initialize
        Position source = new Position(s);
        Position destination = new Position(d);
        visited = new HashMap();
        parents = new HashMap();
        distance = new HashMap();
        for(Position loc : adj.keySet()){
            visited.put(loc, false);
            parents.put(loc, null);
            distance.put(loc, Integer.MAX_VALUE);
        }
        Queue<Position> Q = new LinkedList();
        Q.add(source);
        distance.put(source, 0);

        //BFS loop
        while(!Q.isEmpty()){
            Position curr = Q.poll();
            List<Position> posList = adj.get(curr);
            for(Position pos : posList){
                int dist = distance.get(curr) + 1;
                if(dist < distance.get(pos) && !visited.get(pos)){
                    Q.add(pos);
                    distance.put(pos, dist);
                    parents.put(pos, curr);
                }
            }
            visited.put(curr, true);
        }

        //Get the path to the destination
        List<Location> ret = getPath(new ArrayList(), destination);
        //Path comes in reverse order, so reverse it
        Collections.reverse(ret);
        return ret;
    }

    //Goes through the parents of each node to find the path
    public List<Location> getPath(List<Location> list, Position curr){
        if(parents.get(curr) == null){
            return list;
        } else {
            list.add(curr);
            return getPath(list, parents.get(curr));
        }
    }

    //Finds the distance between two positions
    private int dist(Position l1, Position l2){
        return Math.abs(l1.getX() - l2.getX()) + Math.abs(l1.getY() - l2.getY());
    }

}

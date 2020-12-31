package io.mango.pathfinder.model.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {

    public static void computePaths(Node source){
        source.shortestDistance=0;

        //implement a priority queue
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(source);

        while(!queue.isEmpty()){
            Node u = queue.poll();

			/*visit the adjacencies, starting from
			the nearest node(smallest shortestDistance)*/

            for(Edge e: u.adjacencies){

                Node v = e.target;
                double weight = e.weight;

                //relax(u,v,weight)
                double distanceFromU = u.shortestDistance+weight;
                if(distanceFromU<v.shortestDistance){

					/*remove v from queue for updating
					the shortestDistance value*/
                    queue.remove(v);
                    v.shortestDistance = distanceFromU;
                    v.parent = u;
                    queue.add(v);

                }
            }
        }
    }

    public static List<Node> getShortestPathTo(Node target){

        //trace path from target to source
        List<Node> path = new ArrayList<Node>();
        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
        }


        //reverse the order such that it will be from source to target
        Collections.reverse(path);

        return path;
    }

}

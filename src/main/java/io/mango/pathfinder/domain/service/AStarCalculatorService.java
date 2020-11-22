package io.mango.pathfinder.domain.service;

import io.mango.pathfinder.domain.model.Map;
import io.mango.pathfinder.domain.model.Node;
import io.mango.pathfinder.domain.model.Robot;
import io.mango.pathfinder.domain.netstuff.AStar;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class AStarCalculatorService implements PathCalculator{

    @Override
    public LinkedList<Node> getShortestPath(Map map, Robot robot) {
        Node startNode = new Node(1,2);
        Node endNode = new Node(5,6);
        Node[][] grid = new Node[2][3];

        





        LinkedList<Node> shortestPath = new LinkedList<>();
        PriorityQueue<Node> openNodes = new PriorityQueue<>((Node node1, Node node2) -> {
            return Integer.compare(node1.getFinalCost(), node2.getFinalCost());
        });
        map.setOpenNodes(openNodes);



        return shortestPath;
    }

    public void aStarMutyi() {
        AStar aStar = new AStar(5,5,0,0,3,2,
                new int[][]{
                        {0,4}, {2,2}, {3,3}, {2,1}, {2,3}
            }
        );
        aStar.display();
        aStar.process();
        aStar.displayScores();
        aStar.displaySolution();

    }
}

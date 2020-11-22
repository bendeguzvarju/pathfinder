package io.mango.pathfinder.domain.service;

import io.mango.pathfinder.domain.netstuff.AStar;
import org.springframework.stereotype.Component;

@Component
public class UserService {



    public String getUserName() {
        return "abdabada";
    }


    public void aStarMutyi() {
        AStar aStar = new AStar(5,5,0,0,3,2,
                new int[][]{
                        {0,4}, {2,2}, {3,1}, {3,3}, {2,1}, {2,3}
                }
        );
        aStar.display();
        aStar.process();
        aStar.displayScores();
        aStar.displaySolution();

    }
}

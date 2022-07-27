package com.camusbai.exercise.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC853_CarFleet {
    public static void main(String[] args) {
        carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,6,1,1,3});
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        List<Integer[]> orderedByPosition = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            orderedByPosition.add(new Integer[]{position[i], speed[i]});
        }
        orderedByPosition.sort((val1, val2)-> val2[0] - val1[0]);
        Stack<Integer[]> fleet = new Stack<>();
        for (Integer[] car : orderedByPosition) {
            if (fleet.isEmpty()) {
                fleet.push(car);
                continue;
            }

            Integer[] prevCar = fleet.peek();
            int prevCarSpeed = prevCar[1];
            int carSpeed = car[1];
            if (carSpeed <= prevCarSpeed) {
                fleet.push(car);
            } else {
                float timeToDest = (target - car[0]) / ((float) carSpeed);
                float timeToDestPrev = (target - prevCar[0]) / ((float) prevCarSpeed);
                if (timeToDest > timeToDestPrev) {
                    fleet.push(car);
                }
            }
        }
        return fleet.size();
    }
}

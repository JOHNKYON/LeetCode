package questions.leetcode853;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Car> heap = new PriorityQueue<>(new Comparator<Car>(){
            @Override
            public int compare(Car a, Car b) {
                return (int)a.distance - (int)b.distance;
            }
        });

        for (int i=0; i<position.length; i++) {
            Car car = new Car(target-position[i], speed[i]);
            heap.offer(car);
        }

        int res = 0;
        double flat_time = 0;
        while (!heap.isEmpty()) {
            Car car = heap.poll();
            double time = car.getTime();
            if (time > flat_time) {
                res++;
                flat_time = time;
            }
        }
        return res;
    }

    private class Car {
        double distance;
        double speed;
        public Car(int d, int s ) {
            distance = (double)d;
            speed = (double)s;
        }

        public double getTime() {
            return distance / speed;
        }
    }
}

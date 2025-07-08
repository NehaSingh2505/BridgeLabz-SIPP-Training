package Stack;

import java.util.*;

class CircularTour {
    static class PetrolPump {
        int petrol, distance;
        PetrolPump(int p, int d) {
            petrol = p;
            distance = d;
        }
    }

    public int findStart(PetrolPump[] pumps) {
        int start = 0, deficit = 0, balance = 0;
        for (int i = 0; i < pumps.length; i++) {
            balance += pumps[i].petrol - pumps[i].distance;
            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }
        return (balance + deficit >= 0) ? start : -1;
    }
}

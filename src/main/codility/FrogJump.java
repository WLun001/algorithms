package codility;

public class FrogJump {

    public static void main(String[] args) {
        System.out.println(frogJump(5, 105, 3));
        System.out.println(frogJump(1, 5, 2));
    }

    // TODO: improve on this
    public static int frogJump(int x, int y, int jumpDistance) {
        return (int) Math.ceil((float)(y - x) / jumpDistance);
    }

    public static int frogJumpv2(int x, int y, int jumpDistance) {
        int currentPos = x;
        int jumpCount = 0;
        while (currentPos < y) {
            currentPos += jumpDistance;
            jumpCount++;
        }
        return jumpCount;
    }
}

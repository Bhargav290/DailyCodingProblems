import java.util.ArrayList;

    public class DCP21{

        public static class Pair
        {
            int value;
            char type;

            Pair(int value, char type)
            {
                this.value = value;
                this.type = type;
            }
        }

        public int countOverlaps(int[][] v)
        {
            int maxCount = 0;
            int count = 0;
            ArrayList<Pair> data = new ArrayList<>();

            for (int[] ints : v) {
                data.add(new Pair(ints[0], 's'));
                data.add(new Pair(ints[1], 'e'));
            }

            data.sort((a, b) -> a.value - b.value);

            for (Pair datum : data) {
                if (datum.type == 's')
                    count++;

                if (datum.type == 'e')
                    count--;

                maxCount = Math.max(maxCount, count);
            }

            return maxCount;
        }

        public static void main(String[] args)
        {
            DCP21 day21= new DCP21();
            int[][] v = {{30, 75}, {0, 50}, {60, 150}} ;
            System.out.println(day21.countOverlaps(v));
        }
    }



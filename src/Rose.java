public class Rose extends Flower{
    public Rose(double price, double neededArea, double chanceOfGrowth) {
        this.name = "rose";
        if (price < 0) {
            this.price = 40;
        } else {
            this.price = price;
        }

        if (neededArea < 0) {
            this.neededArea = 1;
        } else {
            this.neededArea = neededArea;
        }
        if (chanceOfGrowth < 100 && chanceOfGrowth >= 0) {
            this.chanceOfGrowth = chanceOfGrowth;
        } else {
            this.chanceOfGrowth = 0;
        }
        this.isGrown = false;
    }
}

package semifir.kira.exo.tdd.tennis;

public class ScoreTennis {
    private  int point;
    private boolean avantage;

    public int getPoint() {
        return point;
    }

    public int getJeu() {
        return 0;
    }

    public int getSet() {
        return 0;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isAvantage() {
        return avantage;
    }

    public void setAvantage(boolean avantage) {
        this.avantage = avantage;
    }
}

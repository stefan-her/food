package be.stefan.food.models;

public class Food {

    private String name;
    private int kcal;
    private CatFood catFood;

    public enum CatFood {
        VEGETABLE,
        MEAT,
        FRUIT
    }

    public Food(String name, int kcal, CatFood catFood) {
        setName(name);
        setKcal(kcal);
        setCatFood(catFood);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }


    public CatFood getCatFood() {
        return catFood;
    }

    public void setCatFood(CatFood catFood) {
        this.catFood = catFood;
    }

}

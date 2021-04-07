package spring.lesson13.part1.entity;

public class Weapon {

    private String type;
    private Integer damage;
    private Integer weight;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getDamage() {
        return damage;
    }
    public void setDamage(Integer damage) {
        this.damage = damage;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Weapon{");
        sb.append("type='").append(type).append('\'');
        sb.append(", damage=").append(damage);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}

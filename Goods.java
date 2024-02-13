public class Goods {

  /**
   * Класс продуктов Goods
   * Имеет атрибуты:
   * category (Категория),
   * name (Название),
   * cost (Стоимость),
   * weight (Вес)
   */
  private String category = "";
  private String name = "";
  private int cost = 0;
  private double weight = 0.0;

  /**
   * setter для устновки стоимости
   * Принимет @param cost
   */
  public void setCost(int cost) {
    this.cost = cost;
  }
  /**
   * setter для устновки категории
   * Принимет @param category
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * setter для установки названия
   * Принимает @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * setter для установки веса
   * Принимает @param weight
   */
  public void setWeight(double weight) {
    this.weight = weight;
  }

  /**
   * Конструктор для создания пустого экземпляра класса
   */
  public Goods(){
  }

  /**
   * Конструктор для создания экземпляра класса с заполненными атрибутами
   * Принимает @param category, @param name, @param cost, @param weight
   */
  public Goods(String category, String name, int cost, double weight) {
    this.category = category;
    this.name = name;
    this.cost = cost;
    this.weight = weight;
  }

  /**
   * getter для получения категории
   * Возвращает @return категорию
   */
  public String getCategory() {
    return category;
  }

  /**
   * getter для получения названия
   * Возвращает @return название
   */
  public String getName() {
    return name;
  }

  /**
   * getter для получения стоимости
   * Возвращает @return стоимость
   */
  public int getCost() {
    return cost;
  }

  /**
   * getter для получения веса
   * Возвращает @return вес
   */
  public double getWeight() {
    return weight;
  }
}

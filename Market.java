// Автор работы: Смольков Владислав Андреевич, КИ23-16/1б
// Практическая работа №2, Вариант 5

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Market {
  /*
  Класс Market, хранящий список объектов класса Goods
  Отвечает за управление товарами
   */
  public static Scanner sc = new Scanner(System.in);
  public static ArrayList<Goods> goods = new ArrayList<>();

  /**
   * Метод сортировки товаров по цене
   */
  public static void sortGoodsByCost(){
    Collections.sort(goods, new Comparator<>() {
      @Override
      public int compare(Goods o1, Goods o2) {
        return Integer.compare(o1.getCost(), o2.getCost());
      }
    });
    System.out.println("Товары отсортированы.");
  }

  /**
   * Метод фильтрации товаров по категории
   * Принимает название категории @param cat
   */
  public static void getGoodsByCategory(String cat){
    for (Goods g: goods){
      if (g.getCategory().equals(cat)){
        getAttrGood(g);
      }
    }
  }

  /**
   * Метод изменения параметров товара
   * Принимает объект класса Goods @param g,
   * номер параметра, который нужно сменить @param numAtr
   */
  public static void changeAttribute(Goods g, int numAtr){

      switch (numAtr){
        case 1:
          System.out.println("Введите название категории: ");
          String cat = sc.nextLine();
          g.setCategory(cat);
          break;
        case 2:
          System.out.println("Введите название товара: ");
          String name = sc.nextLine();
          boolean exist = false;
          for (Goods el: goods){
            if (el.getName().equals(name)){
              exist = true;
            }
          }
          if (!exist){
            g.setName(name);
          } else{
            System.out.println("Товар с таким названием уже существует");
          }
          break;
        case 3:
          System.out.println("Введите стоимость товара: ");
          String costStr = sc.nextLine();
          while (!costStr.matches("[0-9]\\d*")){
            System.out.println("Введите правильно стоимомсть товара: ");
            costStr = sc.nextLine();
          }
          int cost = Integer.parseInt(costStr);
          g.setCost(cost);
          break;
        case 4:
          System.out.println("Введите вес товара (Ч.Ч): ");
          String weightStr = sc.nextLine();
          while (!weightStr.matches("(([0-9]\\d*).([0-9]\\d*))")){
            System.out.println("Введите правильно вес товара: ");
            weightStr = sc.nextLine();
          }
          double weight = Double.parseDouble(weightStr);
          System.out.println("Введите вес товара (Ч.Ч): ");
          g.setWeight(weight);
          break;
      }


  }

  /**
   * Метод для вывода всех параметров товара
   * Принимает объект класса Goods @param g
   */
  public static void getAttrGood(Goods g){
      System.out.println("Категория: " + g.getCategory());
      System.out.println("Название: " + g.getName());
      System.out.println("Стоимость: " + g.getCost());
      System.out.println("Вес: " + g.getWeight());
    }

  /**
   * Метод для добавления пустого объекта класса Goods
   */
    public static void addPlaceForGood(){
    goods.add(new Goods());
  }
  /**
   * Метод для добавления товара (объекта класса Goods с веденными атрибутами)
   * Принимает название категории @param category,
   * название товара @param name,
   * стоимость товара @param cost,
   * вес товара @param weight
   */
  public static void addGood(String category, String name, int cost, double weight){
    boolean exist = false;
    for (Goods g: goods){
      if (g.getName().equals(name)){
        exist = true;
        break;
      }
    }
    if (!exist){
      goods.add(new Goods(category, name, cost, weight));
    } else{
      System.out.println("Товар с таким названием уже существует");
    }

  }

  /**
   * Метод для вывода всех товаров из массива goods
   */
  public static void showAllGoods(){
    int c = 1;
    System.out.println("Общее количество товаров: " + goods.size());
    for (Goods g: goods){
      System.out.println(c++ + ".");
      if (!g.getName().isEmpty()){
        getAttrGood(g);
      } else{
        System.out.println("""
            Категория: Не определено
            Название: Не определено
            Стоимость: Не определено
            Вес: Не определено
            """);
      }
    }
  }

  /**
   * Главные метод Main
   * Принимает @param args
   */
  public static void main(String[] args) {
    boolean running = true;
    while (running) {
      System.out.println("""
                    
          ___МЕНЮ___
          1. Показать все товары
          2. Добавить пустое место под товар
          3. Добавить товар
          4. Редактировать информацию о товаре
          5. Отсортировать список товаров по цене
          6. Отфильтровать товары по категории
          7. Показать информацию о товаре
          8. Выход
          """);
      System.out.println("Выберете пункт:");
      String act = sc.nextLine();
      switch (act) {
        case "8":
          System.out.println("Выход из приложения...");
          running = false;
          break;
        case "1":
          showAllGoods();
          break;
        case "2":
          addPlaceForGood();
          break;
        case "3":
          System.out.println("Введите категорию товара: ");
          String category = sc.nextLine();
          System.out.println("Введите название товара: ");
          String name = sc.nextLine();
          System.out.println("Введите стоимость товара: ");
          String costStr = sc.nextLine();
          while (!costStr.matches("[0-9]\\d*")){
            System.out.println("Введите правильно стоимомсть товара: ");
            costStr = sc.nextLine();
          }
          int cost = Integer.parseInt(costStr);
          System.out.println("Введите вес товара (Ч.Ч): ");
          String weightStr = sc.nextLine();
          while (!weightStr.matches("(([0-9]\\d*).([0-9]\\d*))")){
            System.out.println("Введите правильно вес товара: ");
            weightStr = sc.nextLine();
          }
          double weight = Double.parseDouble(weightStr);
          addGood(category, name, cost, weight);
          break;
        case "4":
          showAllGoods();
          System.out.println("Введите номер товара, который хотите редактировать");
          String numStr = sc.nextLine();
          while (!numStr.matches("[0-9]\\d*") || Integer.parseInt(numStr) > goods.size()){
            System.out.println("Введите номер товара правильно: ");
            numStr = sc.nextLine();
          }
          int num = Integer.parseInt(numStr);
          Goods g = goods.get(num-1);
          if (g.getName().isEmpty()){
            boolean runDestroy = false;
            System.out.println("Введите категорию товара: ");
            String cat = sc.nextLine();
            System.out.println("Введите название товара: ");
            String n = sc.nextLine();
            while (true){
              boolean exist = false;
              for (Goods el: goods){
                if (el.getName().equals(n)){
                  exist = true;
                  break;
                }
              }
              if (!exist){
                g.setName(n);
                break;
              } else{
                System.out.println("Товар с таким названием уже существует");
                System.out.println("""
              Вы можете:
              1. завершить этап замены атрибутов
              2. продолжить""");
                System.out.println("Выберите пункт: ");
                String a = sc.nextLine();
                while (!a.matches("[1-2]\\d*")){
                  System.out.println("Введите правильно пункт: ");
                  a = sc.nextLine();
                }
                if (a.equals("1")){
                  runDestroy = true;
                  break;
                } else{
                  System.out.println("Введите название товара: ");
                  n = sc.nextLine();
                }
              }
            }
            if (runDestroy){
              break;
            }
            System.out.println("Введите стоимость товара: ");
            String cS = sc.nextLine();
            while (!cS.matches("[0-9]\\d*")){
              System.out.println("Введите правильно стоимомсть товара: ");
              cS = sc.nextLine();
            }
            int c = Integer.parseInt(cS);
            System.out.println("Введите вес товара (Ч.Ч): ");
            String wS = sc.nextLine();
            while (!wS.matches("(([0-9]\\d*).([0-9]\\d*))")){
              System.out.println("Введите правильно вес товара: ");
              wS = sc.nextLine();
            }
            double w = Double.parseDouble(wS);
            g.setName(n);
            g.setCost(c);
            g.setCategory(cat);
            g.setWeight(w);
          } else{
            System.out.println("""
            1. Категория
            2. Название
            3. Стоимость
            4. Вес
            """);
            System.out.println("Введите номер атрибута, который будете менять: ");
            String atr = sc.nextLine();
            while (!atr.matches("[1-4]")){
              System.out.println("Введите правильный номер атрибута: ");
              atr = sc.nextLine();
            }
            changeAttribute(g, Integer.parseInt(atr));
        }
          break;
        case "5":
          sortGoodsByCost();
          break;
        case "6":
          System.out.println("Введите категорию товара: ");
          String cat = sc.nextLine();
          getGoodsByCategory(cat);
          break;
        case "7":
          System.out.println("Введите название товара: ");
          String n = sc.nextLine();
          Goods needgood = new Goods();
          boolean exist = false;
          for (Goods good: goods){
            if (good.getName().equals(n)){
              exist = true;
              needgood = good;
              break;
            }
          }
          if (exist){
            getAttrGood(needgood);
          } else {
            System.out.println("Товара с таким именем не существует");
          }
          break;
        default:
          System.out.println("Вы выбрали несуществующйи пункт. Повторите попытку");
      }
    }
  }
}
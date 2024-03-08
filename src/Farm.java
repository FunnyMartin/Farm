import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Farm {
    private ArrayList<Flower> flowerList;
    private double money;
    private double landSize = 100;
    private ArrayList<Animal> barn;
    private int barnSizeSmall = 10, barnSizeLarge = 10;
    private ArrayList<Animal> shop;

    public void PlantFlower(Flower flower){
        if((CheckSize() + flower.neededArea) <= landSize){
            if(!DuplicateFlowers(flower)){
                flowerList.add(flower);
            } else {
                System.out.println("This type of plant already exists");
            }
        } else{
            System.out.println("There is not enough soil to plant the flower");
        }

    }

    public void WaterFlower(Flower flower){
        if(!flower.isGrown){
            flower.chanceOfGrowth += 5;
            if(flower.chanceOfGrowth >= 100){
                GrowFlower(flower);
            }
        } else{
            System.out.println("Flower is already grown");
        }
    }

    private void GrowFlower(Flower flower){
        flower.isGrown = true;
        flower.chanceOfGrowth = 0;
    }

    private boolean DuplicateFlowers(Flower flower){
        if(flowerList != null){
            for(int i = 0; i < flowerList.size(); i++){
                if(flower.name.equals(flowerList.get(i).name)){
                    return true;
                }
            }
        }
        return false;
    }

    private double CheckSize(){
        double size = 0;
        for(int i = 0; i < flowerList.size(); i++){
            size += flowerList.get(i).neededArea;
        }
        return size;
    }

    public void Harvest(Flower flower){
        if(flower != null){
            if(flower.isGrown){
                money += flower.price;
                flowerList.remove(flower);
            }
        }
    }

    public void addAnimal(Animal animal){
        switch (animal.size){
            case BIG:
                if((CurrentBigAnimals() + 1) <= barnSizeLarge){
                    barn.add(animal);
                } else{
                    System.out.println("Not enough room for large animal");
                }
                break;
            case SMALL:
                if((CurrentSmallAnimals() + 1) <= barnSizeSmall){
                    barn.add(animal);
                } else{
                    System.out.println("Not enough room for small animal");
                }
                break;
        }
    }

    private int CurrentBigAnimals(){
        int count = 0;
        for(int i = 0; i < barn.size(); i++){
            if(barn.get(i).size.equals(Size.BIG)){
                count++;
            }
        }
        return count;
    }

    private int CurrentSmallAnimals(){
        int count = 0;
        for(int i = 0; i < barn.size(); i++){
            if(barn.get(i).size.equals(Size.SMALL)){
                count++;
            }
        }
        return count;
    }

    public void BuyAnimal(Scanner scan){
        int price = 0;
        System.out.println("Current money: " + money);
        System.out.println("Animals: 1. cow, 2. horse, 3. chicken, 4. rabbit");
        System.out.println("Choose animal to buy");
        int input = scan.nextInt();
        switch (input){
            case 1:
                price = CalculatePrice(Size.BIG);
                while(true){
                    System.out.println("Price: " + price);
                    System.out.println("1 = buy, 2 = leave");
                    input = scan.nextInt();
                    if(input == 1){
                        if(money >= price){
                            System.out.println("Name of cow: ");
                            String name = scan.next();
                            System.out.println("Special care (if any):");
                            String specialCare = scan.next();
                            addAnimal(new Cow(name, specialCare));
                        }
                    } else if (input == 2) {
                        break;
                    }
                }
                break;
            case 2:
                price = CalculatePrice(Size.BIG);
                while(true){
                    System.out.println("Price: " + price);
                    System.out.println("1 = buy, 2 = leave");
                    input = scan.nextInt();
                    if(input == 1){
                        if(money >= price){
                            System.out.println("Name of horse: ");
                            String name = scan.next();
                            System.out.println("Special care (if any):");
                            String specialCare = scan.next();
                            addAnimal(new Horse(name, specialCare));
                        }
                    } else if (input == 2) {
                        break;
                    }
                }
                break;
            case 3:
                price = CalculatePrice(Size.SMALL);
                while(true){
                    System.out.println("Price: " + price);
                    System.out.println("1 = buy, 2 = leave");
                    input = scan.nextInt();
                    if(input == 1){
                        if(money >= price){
                            System.out.println("Name of chicken: ");
                            String name = scan.next();
                            System.out.println("Special care (if any):");
                            String specialCare = scan.next();
                            addAnimal(new Chicken(name, specialCare));
                        }
                    } else if (input == 2) {
                        break;
                    }
                }
                break;
            case 4:
                price = CalculatePrice(Size.SMALL);
                while(true){
                    System.out.println("Price: " + price);
                    System.out.println("1 = buy, 2 = leave");
                    input = scan.nextInt();
                    if(input == 1){
                        if(money >= price){
                            System.out.println("Name of rabbit: ");
                            String name = scan.next();
                            System.out.println("Special care (if any):");
                            String specialCare = scan.next();
                            addAnimal(new Rabbit(name, specialCare));
                        }
                    } else if (input == 2) {
                        break;
                    }
                }
                break;
            default:
                System.out.println("Not a valid option");
                break;
        }
    }

    private int CalculatePrice(Size size){
        Random random = new Random();
        if(size.equals(Size.SMALL)){
            return random.nextInt(30) + 10;
        } else{
            return random.nextInt(60) + 10;
        }
    }

    public String PetAnimal(Animal animal){
        switch (animal.type){
            case "cow":
                return "moo";
            case "horse":
                return "nyah";
            case "chicken":
                return "kukuku";
            case "rabbit":
                return "rabbit sounds";
        }
        return null;
    }



}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String name, art;
    static  int age,num, i=0,totalCat=0,totalDog=0,totalAnder=0,totalAge=0,klein,gros;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialis and create Arraylist for Animals
        System.out.println("Wie viele Tiere willst du hinzufügen? ");
        num = scanner.nextInt();
        ArrayList <Animal> listTier = new ArrayList<Animal>();

        //Scanner input Data Animals
        while(i<num){
            try {
                Animal animal = new Animal();
                System.out.println("Name der Tiere " +(i+1)  +" : ");
                name = scanner.next();
                animal.setName(name);

                System.out.println("Art der Tiere " +(i+1) + " : ");
                art = scanner.next();
                animal.setArt(art);

                System.out.println("Alter der Tiere " +(i+1) +" : ");
                age = scanner.nextInt();
                animal.setAge(age);
                listTier.add(animal);
                i++;
                
            }catch (Exception e){
                System.out.println("Invalid Input ");
            }

        }

        // Total Animals user input
        calculTotalAnimal(num);

        // Calculate Total Cats and Dogs and Others
        for (Animal ann:listTier){
            if (calculArtAnimal(ann) == 1){
                totalCat++;
            }if (calculArtAnimal(ann) == 2){
                totalDog++;
            }if (calculArtAnimal(ann)== 3){
                totalAnder++;
            }
        }
        System.out.println("Total Katzen : " +totalCat);
        System.out.println("Total Dogs : " +totalDog);
        System.out.println("Total Ander Tier : " +totalAnder);


        // Calculate Total Age for All Animals
        for (Animal ann: listTier){
            totalAge += ann.getAge();
        }
        System.out.println("Total of Age : " +totalAge);


        // Calculate Average of Age for All Animals
        System.out.println("Average Age of Animals is : " +(totalAge/num));


        // Finde die Groß und klein Alter Animal

        klein = listTier.get(0).getAge();
        gros = listTier.get(0).getAge();
        String nameKlein="",nameGros="";
        for (int j = 0; j <listTier.size() ; j++) {
            if (listTier.get(j).getAge() > klein){
                gros = listTier.get(j).getAge();
                nameGros= listTier.get(j).getName();
            }else {
                klein = listTier.get(j).getAge();
                nameKlein= listTier.get(j).getName();
            }
        }
        // Function to Print Name of Groß und klein Animal
        System.out.println("Das kleinste Tier ist : "+nameKlein);
        System.out.println("Das großte Tier ist : "+nameGros);
    }


    // Calculate Total Animal
    public static void calculTotalAnimal(int num){
        System.out.println("Total of animals is : " +num);
    }


    //  Function to Calculate Total of Art Animals
    public static int calculArtAnimal(Animal ann){
        int i=0;
        if (ann.getArt().equals("Cat")) {
            return 1;
        }if (ann.getArt().equals("Dog")){
            return 2;
        }else
            return 3;
    }
 }




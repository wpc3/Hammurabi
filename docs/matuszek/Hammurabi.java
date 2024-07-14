

package hammurabi.docs.matuszek;

import java.util.Random;
import java.util.Scanner;


//    package hammurabi.docs;

//import java.util.Random;
//import java.util.Scanner;

    public class Hammurabi {
        int year =1;
        public int population = 100;
         int bushels = 2800;
        public int acresOwned = 1000;
        public int landValue = 19;
        public boolean gameOn = true;
        int harvestAmount;
        public int grainToFeed;
        public int grainDestroyedByRats;
        public int newpeople;
        public int yeild;
        public int newLandCost=19;
        public int completeStarved=0;
        public int completeAcreOwned=0;
        public int deathByStarvation;
        public int bushelsToFeed;
        public int acreToPlant;
        public int howManyAcresToPlant;
        public int harvest1;
        int peopleStarving;
        boolean uprising;
//        int deathByStarvation = 0;
//        int immigrants = 5;
        Random rand = new Random();  // this is an instance variable
        Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) { // required in every Java program
            new Hammurabi().playGame();

        }

        void playGame() {
            // declare local variables here: grain, population, etc.
            // statements go after the declations

            int immigrants = 0;
//
            System.out.println("O great Hammurabi!\n" +
                    "You are in year 1 of your ten year rule.\n" +
                    "In the previous year 0 people starved to death.\n" +
                    "In the previous year 5 people entered the kingdom.\n" +
                    "The population is now 100.\n" +
                    "We harvested 3000 bushels at 3 bushels per acre.\n" +
                    "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                    "The city owns 1000 acres of land.\n" +
                    "Land is currently worth 19 bushels per acre. \n");

            while (gameOn && year<10) {
//                System.out.println("O great Hammurabi!\n" +
//                        "You are in year " + year + " of your ten year rule.\n" +
//                        "In the previous year " + starvationDeaths(population,bushelsToFeed) +  " people starved to death.\n" +
//                        "In the previous year " + immigrants +  " people entered the kingdom.\n" +
//                        "The population is now " + population + "\n" +
//                        "We harvested " + harvest1  + "bushels \n" +
//                        "Rats destroyed  " + grainDestroyedByRats + " bushels in storage.\n" +
//                        "The city owns " + acresOwned +  " acres of land.\n" +
//                        "Land is currently worth " + landValue + " bushels per acre.\n");
                System.out.println("Year: " + year);
                System.out.println("Population before decisions: " + population);
                System.out.println("Bushels before decisions: " + this.bushels);
                System.out.println("Acres owned before decisions: " + acresOwned);
                System.out.println("People starved " + peopleStarving);
                System.out.println("Land value " + newLandCost);


                //User Decisions

                howManyAcresToBuy(newLandCost, bushels);
                askHowManyAcresTosell(acresOwned);
                 bushelsToFeed =  askHowMuchGrainToFeedPeople(bushels);
                 acreToPlant = askHowManyAcresToPlant(acresOwned, population, bushels);


                //Yearly Deaths or Uprising
              int plagues = plagueDeaths(population);
                peopleStarving = starvationDeaths(population, bushelsToFeed);
                 uprising = uprising(population,peopleStarving);
//                immigrants(population,acresOwned,bushels);
                harvest1 = harvest(howManyAcresToPlant);
//                grainEatenByRats(bushels);

                completeStarved += deathByStarvation;
                completeAcreOwned += acresOwned;
//                immigrants = immigrants(Population,acresOwned, this.bushels);

//                grainEatenByRats(bushels);
                newCostOfLand();
                year++;

                //Update population
//                int netChangeInPop =   deathByStarvation;
//                this.Population = Math.max(0,Population-starvationDeaths(Population,bushelsToFeed)-plagueDeaths(Population)+immigrants);
//               Population =Population-deathByStarvation+deathByStarvation;
//                immigrants = immigrants(Population,acresOwned, this.bushels);
//                Population += immigrants;



                //Print summary to show updates from last round.
//                printSummary(year, deathByStarvation, immigrants, population, this.bushels,acresOwned, landValue);

                //Updating Landvalue
//                landValue = newCostOfLand();
//                this.harvestAmount= harvest(acreToPlant);

//                System.out.println("Population after decisions: " + population);
//                System.out.println("Bushels after decisions: " + bushels);
//                System.out.println("Acres owned after decisions: " + acresOwned);
                System.out.println("Year: " + year);
                System.out.println("Population after decisions: " + population);
                System.out.println("Bushels after decisions: " + this.bushels);
                System.out.println("Acres owned after decisions: " + acresOwned);
                System.out.println("People starved " + peopleStarving);
                System.out.println("Land value " + newLandCost);


            }
            endGameSummary();
            scanner.close();
        }

        public int howManyAcresToBuy(int price, int bushels) {
            System.out.println("HOW MANY ACRES DO YOU WISH TO BUY? ");
            int userInput = scanner.nextInt();
            price = userInput * 19;
            if (bushels >= price) {
                this.bushels -= price;
                this.acresOwned += userInput;
//                return userInput;
            }
            else {
                System.out.println("You do not have enough bushels :(");
            }
            System.out.println("You have " + this.bushels + " bushels left " + "and " + this.acresOwned + " acres owned.");
            return userInput;
        }

        public int askHowManyAcresTosell(int acresOwned){
            System.out.println("How many acres of land would you like to sell? \n");
            int userInpt = scanner.nextInt();
            if(userInpt <= acresOwned){
                this.acresOwned -= userInpt;
                this.bushels += userInpt * landValue;
                return userInpt;
            }
            else {
                System.out.println("You don't have enough acres to sell that amount");
            }
            System.out.println("You have " + this.bushels + " amount of bushels left" + " and " + this.acresOwned + " amount of acres.");
            return userInpt;
        }
        public int askHowMuchGrainToFeedPeople(int currentbushels){
            System.out.println("How many bushels would you like to feed the people. Each person need 20 bushels to survive. " + "You have " + this.bushels + " bushels." + "\n");

            int userInput = scanner.nextInt();
            if(userInput <= currentbushels){
//                this.bushels -= userInput;
            }
            else {
                System.out.println("You don't have enough :(");
            }
            System.out.println("Thank you for feeding the people " + userInput );

            return userInput;
        }

        public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
            while (true) {
                System.out.println("How many acres would you like to plant with grain. It costs 2 bushels and you need 10 people to plant per acre \n");

                int acresToPlant = scanner.nextInt();
                int amountOfBushelsNeed = acresToPlant * 2;
                int amountOfPeopleNeeded = acresToPlant / 10;
                if (acresToPlant <= this.acresOwned && amountOfBushelsNeed <= this.bushels && amountOfPeopleNeeded <= this.population) {
                    System.out.println("You are currently planting " + acresToPlant + " amount of acres");
                    this.bushels -= amountOfBushelsNeed;
                    return acresToPlant;
                } else {
                    System.out.println("You can't plant these amount of acres");
                }


            }
        }





        public int plagueDeaths(int population) {
            Random random = new Random();
            if(random.nextInt(101) <15){
                System.out.println("Sorry, you guys got hit with a nasty plaque. You lost half your population :(");

                this.population -= (this.population /2);
                return this.population;
            }
//        System.out.println("You have a current population of " + this.Population);
            return 0;
        }

        public int starvationDeaths(int people, int bushelsToFeed) {
            int amountOfBushelsNeeded = people * 20;
            if (bushelsToFeed >= amountOfBushelsNeeded) {
                this.bushels -= amountOfBushelsNeeded;
                deathByStarvation = 0;
//            immigrants(Population, this.acresOwned,this.bushels);
                return 0;
            }

            int bushelsShort = amountOfBushelsNeeded - bushelsToFeed;
            double amountOfPeopleStarved = (double) bushelsShort/20;
            double numberCeil = Math.ceil(amountOfPeopleStarved);

            //To make sure we don't take out more people than we have
//            int peopleStarved = (int) Math.min(people,numberCeil);

            this.population -= numberCeil;
            return (int) numberCeil;

        }

        public boolean uprising(int population, int howManyPeopleStarved) {

            double populationNumber = (double) population *.45;
            if(howManyPeopleStarved > populationNumber){
                System.out.println("You've been impeached!");
                gameOn = false;
                return true;
            }

            return false;
        }

        public int immigrants(int population, int acresOwned, int grainInStorage) {
            if(this.deathByStarvation ==0){
                int result = (20 * acresOwned + grainInStorage) / (100 * population) + 1;
                System.out.println("You gained immigrants");
                newpeople = result;
                this.population +=result;
                return result;

            }
            else{
                System.out.println("You gained no immigrants");}
            newpeople=0;
            return 0;
        }

        public int harvest(int acres) {
            Random random = new Random();
            this.yeild =random.nextInt(6)+1;
//            int haverstedBushels = acres*randomNum;
//            this.bushels = acres * randomNum;
            this.bushels += (acres * this.yeild);
            this.harvestAmount = acres*this.yeild;
//            System.out.println(bushels);
            return this.harvestAmount;
        }

        public int grainEatenByRats(int bushels) {
            Random random = new Random();
            if (random.nextInt(101) < 40) {
                Random random2 = new Random();
                double randomNumber2 = random2.nextInt(21)+10;
                this.grainDestroyedByRats = (int) (bushels * randomNumber2/100);
                this.bushels -= this.grainDestroyedByRats;
                System.out.println("Rats have infested your food! They ate " + this.grainDestroyedByRats + " of your bushels");
                return  this.grainDestroyedByRats;

            }





            return 0;
        }

        public int newCostOfLand() {
            Random random = new Random();
            int newPrice = random.nextInt(7)+17;
            newLandCost = newPrice;

            return newPrice;
        }

        public void printSummary(int year, int deathByStarvation, int immigrants, int Population, int bushels, int acresOwned, int landValue){

            System.out.println("In year " + year + " of your ten year rule.\n " +
                     deathByStarvation +  " people starved to death.\n" +
                    "In the previous year " + immigrants +  " people entered the kingdom.\n" +
                    "The population is now " + Population + "\n" +
                    "You have " + this.bushels + " bushels in storage.\n" +
                    "The city owns " + acresOwned +  " acres of land.\n" +
                    "Land is currently worth " + landValue + " bushels per acre.\n");
        }

        public void endGameSummary(){

            if((this.population /100)> .9 && (acresOwned/1000) >= 1){
                System.out.println("Congratulations. You have finished your reign as leader of WilliamTown. You have done a fine job.");
            } else if (uprising) {
                System.out.println("You have been overthrown and sent to the gallows :(");

            } else System.out.println("You have finished your 10 year reign as leader of WilliamTown. Although you have have not been overthrown, the people decided it's in your best interest to step down.");
        }


        //other methods go here
    }



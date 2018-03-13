# Pet Store

Difficult Level - Intermediate

## This kata focuses on:
1) Test Driven Development (TDD)
2) Mockito

## Rules for the kata:
1) Use the “RED – GREEN – REFACTOR” principle.
2) Try NOT to read ahead; complete the steps one-by-one as ordered.
3) Make sure that you have both positive and negative test cases.
4) Try not to use type casting.
5) Keep test coverage 100%

## Objective:
In this kata, we would be Creating a PetStore which will get the input of Dogs.
The Pet Store can do two Functionalities

   (1)Can Buy Dogs to the Pet store to build the Inventory.
   
   (2)Can Sell Dogs from Pet Store Inventory.
   
  In Order to Buy Dogs to the Pet Store to build the Inventory, there are conditions.
  
       (i) If the breed Name already exists in the inventory Then Don't buy the Pet to the Pet store. 
       **Below is an example :-**
            If I am planning to buy a Breed by name "BEAGLE" to the Pet store Inventory, 
            Then the Pet store should look into its Inventory if it has a Breed by Name "BEAGLE" exists, 
            If exists then the Pet store should not buy the Pet, 
            If not exists then Pet store should buy the Pet.
       (ii) If the Age of the Breed is greater than equal to 10 then Don't buy the Breed
        **Below is an example :-**
       If I am planning to buy a Breed by name “BEAGLE” to the Pet store with an Age as 5, 
       Then the Pet store should See its Inventory if it has a Breed by Name “BEAGLE”  not exists, 
       If not exists , check the age of the breed is 10 or above , If above 10 then Pet store should not buy the Pet.
       (iii) If the Price of the Breed is greater than equal to 500 $ then don’t buy the Breed for the Pet Store
        **Below is an example :-**
        If I am planning to buy a Breed by name “BEAGLE” to the Pet store with an Age as 5,Price less than equal to 500.
        After it Passes the BreedName condition and Age contition, Check for Price, If greater than 500 then dont buy
         breed to the store else buy the breed to the store.

## Stage 1
<b>Goal:</b>
1) Create a class for a Dogs. 
2) Should be able to Dogs (breed Name, Age, Price).
3) Create a Connection Class for an In memory DB (File Provided as part of Solution)

   Note:- The Default User Name and Password for HSQL DB  
   User Name – sa
   
   Password –""

<pre><code>
   class Dogs {

   }
</code></pre>


## Stage 2
<b>Goal:</b>
1) Create a Class PetStore DAO which can Query the Data Base
2) Create a Method which should query the Database for a breed Name and then return a Pet List.

<pre><code>
   class PetStoreDao {

      List<Dogs> checkAvailablityOfPetInInventory (String breedName) {}
   }
</code></pre>

## Stage 3
<b>Goal:</b>
1) Create a Class PetStore
2) This will accept a List<Dogs> and PetStoreDao.
3) Create a Method doesStoreNeedToBuyThisBreed . This Method should take a BreedName, Age and 
   Price 
4) should be able to Buy a Breed irrespective of whether the breed Name already exists or not

<pre><code>
   class PetStore {
    public Boolean doesStoreNeedToBuyThisBreed(String breedName, int Age, float price){
   }
   
      }
      
   }
</code></pre>

<b>Scenario(s):</b><br><br>
Given: I give a BreedName, Any Age, Any Price through this method it should always return me true <br> 
 Use Mockito to Mock the Connection to Database and write the Unit Test

## Stage 4
<b>Goal:</b>
1) In the Method doesStoreNeedToBuyThisBreed, Query the database Using PetStoreDao to check 
   If breed Exists in Database If Exists then Don't Buy the Breed.
2) Check IF the Age of the breed is greater than equal to 10. 
   If Age is Greater than Equal to 10 then return False else True.
3) Check if the Price is greater than equal to 500 $. 
   If the Price is greater than equal to 500 then return False else return True.
 Use Mockito to Mock the Connection to Database and write the Unit Test and verify the different Unit test.
 

## Stage 5
<b>Goal:</b>
1) Create a Method doesPetStoreHaveDogToSell (String BreedName) which should query the database and see If the Dogs Exists in The Pet Store Inventory. 
2) If the Breed Name exists then return True, else return False.
<pre><code>
   class PetStore {
    public Boolean doesStoreNeedToBuyThisBreed(String breedName, int Age, float price){
   }
   
      Public Boolean doesThePetStoreHaveDogToSell(String breedName){
      }
      
   }
</code></pre>
### Happy Coding!!!

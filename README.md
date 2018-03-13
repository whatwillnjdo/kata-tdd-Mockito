# Pet Store

Difficult Level - Easy

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
In this kata, we would be creating a PetStore.
The PetStore have two functionalities

   (1)Can buy Dogs to the Pet store to build the inventory.
   
   (2)Can sell Dogs from Pet Store inventory.
   
  In Order to Buy Dogs to the Pet Store to build the inventory, there are conditions.
  

## Stage 1
<b>Goal:</b>
1) Create a class for a Dogs. 
2) Dogs will have breed Name, age and price as its attributes.
<pre><code>
   class Dogs {

   }
</code></pre>


## Stage 2
<b>Goal:</b>
1) Create a Class PetStoreDAO which can query the database.
2) Create a method which should query the database for a breed Name and return a list of dogs.
3)Create a connection to use HSQL(In memory DB). File provided as part of solution.
  
     Note:- The Default User Name and Password for HSQL DB  
     User Name – sa
     
     Password –""

<pre><code>
   class PetStoreDao {

      List<Dogs> checkAvailablityOfPetInInventory (String breedName) {}
   }
</code></pre>

## Stage 3
<b>Goal:</b>
1) Create a Class PetStore
2) This will accept a list of Dogs.
3) Create a method doesStoreNeedToBuyThisBreed . 
   This method will take a breed name, age and price. 


<pre><code>
   class PetStore {
    public Boolean doesStoreNeedToBuyThisBreed(String breedName, int age, float price){
   }
   
      }
      
   }
</code></pre>

<b>Scenario(s):</b><br><br>
Given: When I give a breed name, age, price it should always return true <br> 


## Stage 4
<b>Goal:</b>
1) In the method doesStoreNeedToBuyThisBreed, query the database to check 
   if breed exists in database if exists then don't buy the breed.
   <b>Note:<b> Use PetStoreDao for database operations.
2) Check if the age of the breed is greater than equal to 10. 
   if age is greater than equal to 10 then return False else True.
3) Check if the price is greater than equal to 500 $. 
   if the price is greater than equal to 500 then return False else return True.
 Use Mockito to mock the connection to database and write the unit test to verify the different scenarios.
 

## Stage 5
<b>Goal:</b>
1) Create a method doesPetStoreHaveDogToSell (String BreedName) 
which should query the database using the PetStoreDao to 
see if the breed exists in the pet store inventory. 
2) If the breed name exists then return True, else return False.
<pre><code>
   class PetStore {
    public Boolean doesStoreNeedToBuyThisBreed(String breedName, int age, float price){
   }
   
      Public Boolean doesThePetStoreHaveDogToSell(String breedName){
      }
      
   }
</code></pre>
### Happy Coding!!!

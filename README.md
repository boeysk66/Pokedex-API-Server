# Pokedex-API-Server
A Spring-boot MVC application with a REST controller for Pokemon application. It has one-to-many relation for Player and Pokemon. Each Pokemon has a Player attached to.

## Built With
The following technologies:
- Java
- Spring-boot MVC 
- REST API/JSON 
- Eclipse

The application exposes the following APIs:
- Insert/Update/Delete Player
- Insert/Update/Delete Pokemon
- Show the Pokemon inventory list that owned by particular Player 

Data persisted on mySQL using JPA.

## DB Config
![Screenshot of DB Config](DBConfig.png)

application.properties:
spring.datasource.url : define DB source

spring.datasource.username : define DB user name

spring.datasource.password : define DB user password

## Test Cases
To run it, right click on PokeDexDemoApplication.java -> Run As -> Java Application

![Screenshot of Application Started](ApplicationStarted.png)

1. Player 1 and Player 2 Creation

![Screenshot of Player 1 Creation](Player1Created.png)

![Screenshot of Player 2 Creation](Player2Created.png)

2. List Player 1 and Player 2

![Screenshot of List of Player 1](ListAllPlayers_1.png)

![Screenshot of List of Player 2](ListAllPlayers_2.png)

3. Pokemons created for Player 2

First Catch:
![Screenshot of Pokemon created for Player 2](PokemonCreatedForPlayer2_1.png)

Second Catch:
![Screenshot of Pokemon created for Player 2](PokemonCreatedForPlayer2_2.png)

Third Catch:
![Screenshot of Pokemon created for Player 2](PokemonCreatedForPlayer2_3.png)

Fourth Catch:
![Screenshot of Pokemon created for Player 2](PokemonCreatedForPlayer2_4.png)

4. Pokemon Inventory Summary for Player 1 and Player 2

![Screenshot of Pokemon Inventory Summary for Player 1](PokemonInventorySummaryForPlayer1.png)

![Screenshot of Pokemon Inventory Summary for Player 2](PokemonInventorySummaryForPlayer2.png)

5. Update Name for Player 1

![Screenshot of Name Update for Player 1](Player1_UpdatedName.png)

6. Delete Player 2

![Screenshot of Deletion of Player 2](Player2_Deleted.png)

7. Player List Refresh

![Screenshot of Player List Refresh](PlayerListRefreshed.png)

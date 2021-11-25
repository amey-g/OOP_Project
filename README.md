# Helper Document

## How the factory works
- User can input the number of cars he would like to produce and the factory would give 
- Multiple assembly lines are implemented like in a real life car factory. 
- Each assembly line is implemented on a different thread. 
- All these lines run simultaneously and multiple cars can be produced at the same time

## How the Input-Output works
- User is given a choice for each basic part of the car. Each car can be produced using these combinations of different parts. 
- Each specific part takes a different amount of time to produce given in the specific class for that part
- Upon completion of each part production on any line the output is given to the user accordingly.

## Class structure and design
- Each basic part has an interface made. Every specific part (types of the basic part) implements this interface and specifies the amount of time required to produce this.
- The Factory class is the main driver class with the main function which takes the input and the output.
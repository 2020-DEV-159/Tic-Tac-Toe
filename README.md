After completion of above steps, the report will be available in below path
<PROJECT_ROOT_FOLDER>\target\site\jacoco\index.html
```
# Passing input values - Guidelines
```
1) Your inputs should be in the format of row, column. for eg.(0,0 or 1,2).
2) Your inputs should be in the range of 0 to 2 i.e (0,1),(2,2) . 
3) Your inputs should contain only digits and comma. for eg(1,2)
4) Please do not enter already played position again.
5) Some Invalid inputs examples for your reference (0,-1),(1,3), (3,3), (m,2), ( ,1), (1, )  .
```
# Steps to run the application in command prompt
```
After successful maven build
Goto <ProjectDirectory>\target\classes
and execute below command
java -classpath .\ com.bnpp.kata.game.TicTacToeGameRunner 
Press Enter
Then give row value, column value to be placed as depicted below
0,1 [in words : Zero comma One]
Please provide the row and column values until the game ends!!
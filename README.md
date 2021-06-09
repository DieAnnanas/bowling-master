## Bowling Master

Bowling Master is an application to calculate the results of a bowling match.

The game consists of 10 frames. In each frame the player has two tries (rolls) and can knock down up to 10 pins. The score per frame is calculated
from the number of pins knocked down and other and additional bonuses. These bonuses result from spares and strikes.

A spare is when the player has knocked down all 10 pins in a frame. The bonus for this is the number of pins knocked down in the next roll.

A strike is when the player knocks down all 10 pins in the first attempt. The bonus for this is the number of pins knocked down in the next two rolls.

In the tenth frame, a player who achieves a spare or a strike may play an additional roll to end the frame. No more than 3 rolls can be played in the
last frame.

The user is asked for the roll results of each frame via console. The inputs are validated. Only when ten valid frame results are given, the end
result is calculated and printed out.

### System Requirements

JDK 11 must be installed to compile and run the project

### Run Bowling Master

First, compile the application. Therefore, inside the ``src`` folder of the project, run:

```bash
javac bowlingmaster/*.java bowlingmaster/app/*.java
```

To run the application, just run:

```bash
java bowlingmaster.BowlingMasterMain
```

### Some example data for testing

``1|4`` ``4|5`` ``6|4`` ``5|5`` ``10|0`` ``0|1`` ``7|3`` ``6|4`` ``10|0`` ``2|8|6`` = ``133``

``10|0`` ``9|1`` ``10|0`` ``8|2`` ``4|4`` ``9|1`` ``10|0`` ``7|3`` ``10|0`` ``5|3`` = ``164``

``6|4`` ``10|0`` ``8|1`` ``10|0`` ``7|0`` ``10|0`` ``7|2`` ``10|0`` ``10|0`` ``10|7|1`` = ``175``

``9|1`` ``8|1`` ``9|1`` ``8|2`` ``10|0`` ``10|0`` ``10|0`` ``9|1`` ``10|0`` ``10|10|9`` = ``223``

``10|0`` ``10|0`` ``10|0`` ``10|0`` ``10|0`` ``10|0`` ``10|0`` ``10|0`` ``10|0`` ``10|10|10`` = ``300``
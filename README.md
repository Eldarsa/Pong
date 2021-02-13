# How to play
Left player control the paddle with the keys W and S and right player with the arrows

# Singleton pattern

We have applied the Singleton patter a few places where we found it suitable, which were with
the GameStateManager- and State-subclasses. This was a natural decision as these classes are only
intended to exist one instance of simultaneously.

# Theory
## Task 4.a
- Observer: Architectural
- State: Architectural
- Template method: Design
- MVC: Architectural
- Abstract factory: Design
- ECS: Architectural
- Pipe and filter: Architectural

## Task 4.b and 4.c

We have used the following patterns in our code:

### Template method:
The template classes used are:
 - State: because it makes a lot of sense to create a common denominator between each state
 - Wall: Experimental try that might be useful in a project on a larger scale. Here it looks a bit
         silly really.

The advantage here is apparent in the State class, not so much in the wall class. With a template
class we can:
 - Create a skeleton class with skeleton methods that allow us to duplicate less code.
 - Morph a class into different shapes, but with similar features. This helps save code and keep
    our classes more coordinated and consistent.
 - Allows us to pass the superclass as a method argument so that we can pass the subclasses as
    arguments where the parent classes are specified as the requested type. This means we can
    pass several types of classes into the same methods without specifying methods for each
    classtype. Not used here though.

Some drawbacks that become apparent here however are
 - As with the Wall-class, it's really to simple of a class to really benefit from having a
    a superclass. The superclass doesn't really add that much.
 - Increases the complexity. When there are not that many subclasses we want to make. Adding
    a superclass increases the complexity and the amount of code you have to keep coordinated.
    As with the wall class, we only use it on two walls. It would be faster and cleaner to
    create them seperately as long as we have no ambition to scale the program with a thousand
    new walls.


### Pipe and filter pattern:
The base structure of libgdx can be considered a simple pipe and filter. However, this
can also be used on a smaller scale - e.g. in the playstate. Then the pipe is the cycle

    -> update -> render ->

but the filters that we have implemented are
1. Handle input
2. Detect collision
3. Update physical state
4. Check game state (levels and if there is a winner)
5. Draw

This can be seen in the PlayState class. It can be further improved by encapsulating the processes
in their own proper classes. The draw functions can be assigned to a view-controller class and
the sprite updates, aswell as the sprite communication, can be assigned to a spritemanager-/controller
class of some sort. Right now the filters are implemented as methods in the PlayState class which
is not architecturally ideal.

One drawback with this pattern is that it's pretty linear. What if we want to increase efficiency
by using threads? Then it's not really apparent how to utilize the benefits the threads can give
to the program without creating bottlenecks between the filters (threads waiting for other threads
to finish before continuing to the next filter).

### State pattern
Disclaimer: The states we have implemented are not really a 'state-pattern', but they carry
some inspiration. It's really just a stack that keep track of the current state by popping and
pushing states to the top of the stack - thereby the the current top is the state of the game in
a sense. This a very simplistic implementation of the pattern.

A more proper implementation that could be applied to the game however would be one that tracks the
state of the physical world the game presents and tells the program to act in a certain way
depending on the state. We have tried to use this partly even though it's a bit 'forced' for this
application. We therefore implemented a 'Level'-class that tracks the timer and changes the ball
speed when the timer reaches a certain count. This is then reset when someone scores a point and
the game is reset. This way, the Level-class defines and controls the state of our program.

The state pattern can be naturally applied in some aspects of this program, but it should be
applied where the programs nature demands it without forcing it just for the sake of using the
pattern. A main advantage however, is that you can eliminate a lot of if-else-statements
that cluster up the program. A disadvantage is that it can lead to a lot of coding having to
be written. With many states, you can get many methods that represent alternatives to what the
program should do. E.g. in our program, we check whether the level has changed since our last
update in the playstate->update function. This if-condition can be eliminated by a state that
encapsulates our update-function in a level (silly example, but it works). This would however
require a ridiculous amount of code duplication for very little to no benefit.


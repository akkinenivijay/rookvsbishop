# rookvsbishop #

We are looking at a 'special' game of chess where each player only has one piece.
Player with white pieces only has a bishop while player with black pieces only has
a rook.
* In chess, the columns (called Files) are denoted as alphabets(a-h) and rows (called
Ranks) are denoted as numbers (1-8).
* Any given square is a combination of file and rank. In the above figure the position of
bishop is c3 while that of the rook is f6.
* Bishop only moves diagonally from its position, in all 4 directions (top-right, top-left,
bottom-right, bottom-left).
* Rook moves either vertically (up and down) or horizontally (left and right) from its given
position.
* Both rook and bishop can capture one another only if the other piece falls in the valid
motion path.

### The Problem ###
We decide to move the black rook and play for its survival. The move happens as follows:
1. Toss a coin, if it's heads, the rook moves up. If it's tails, the rook moves to the right.
2. Roll 2 dice (6 sided). The sum of numbers on the face up side of both the dice will be the
number of squares the rook moves.
3. If the rook reaches the right most column on the board, it emerges again from the left
most column.
4. If the rook reaches the top most row, it emerges again from the bottom most row.
5. Move the rook as described above for 15 rounds. If it manages to survive from being
captured by the bishop, the player with the rook wins. Else the player with bishop wins.
6. The starting position for rook is h1 square and bishop remains stationary on c3.
### How do I get set up? ###

* Clone this repository
* Install [Sbt](https://www.scala-sbt.org/1.x/docs/Setup.html)
* `sbt run` would run game.
* `sbt test` & `sbt jacoco` will run test coverage


### Sample Output ###
Initial state\
a8        b8        c8        d8        e8        f8        g8        h8\
a7        b7        c7        d7        e7        f7        g7        h7\
a6        b6        c6        d6        e6        f6        g6        h6\
a5        b5        c5        d5        e5        f5        g5        h5\
a4        b4        c4        d4        e4        f4        g4        h4\
a3        b3        c3 **Bishop** d3        e3        f3        g3        h3\
a2        b2        c2        d2        e2        f2        g2        h2\
a1        b1        c1        d1        e1        f1        g1        h1 **Rook**\
Rook Col: h, Row: 1 Round: 1 Direction: Tails NumberOfMoves: 8\
a8        b8        c8        d8        e8        f8        g8        h8\
a7        b7        c7        d7        e7        f7        g7        h7\
a6        b6        c6        d6        e6        f6        g6        h6\
a5        b5        c5        d5        e5        f5        g5        h5\
a4        b4        c4        d4        e4        f4        g4        h4\
a3        b3        c3 ***Bishop** d3        e3        f3        g3        h3\
a2        b2        c2        d2        e2        f2        g2        h2\
a1        b1        c1        d1        e1        f1        g1        h1 **Rook**\
Rook Col: h, Row: 1 Round: 2 Direction: Tails NumberOfMoves: 6\
a8        b8        c8        d8        e8        f8        g8        h8\
a7        b7        c7        d7        e7        f7        g7        h7\
a6        b6        c6        d6        e6        f6        g6        h6\
a5        b5        c5        d5        e5        f5        g5        h5\
a4        b4        c4        d4        e4        f4        g4        h4\
a3        b3        c3 **Bishop** d3        e3        f3        g3        h3\
a2        b2        c2        d2        e2        f2        g2        h2\
a1        b1        c1        d1        e1        f1 **Rook**   g1        h1\
Rook Col: f, Row: 1 Round: 3 Direction: Tails NumberOfMoves: 11\
a8        b8        c8        d8        e8        f8        g8        h8\
a7        b7        c7        d7        e7        f7        g7        h7\
a6        b6        c6        d6        e6        f6        g6        h6\
a5        b5        c5        d5        e5        f5        g5        h5\
a4        b4        c4        d4        e4        f4        g4        h4\
a3        b3        c3 **Bishop** d3        e3        f3        g3        h3\
a2        b2        c2        d2        e2        f2        g2        h2\
a1 **Rook**   b1        c1        d1        e1        f1        g1        h1\
Bishop Captured Rook in iteration 3 !!
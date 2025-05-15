### Card Game Framework

**Requirements**

Implement two simple card games, and minimize the duplication of code in the program.

#### Game 1: Simple Poker Size Comparison Game

This game supports four players: players can be either a real player (Human Player) or a computer player (AI Player).

**Player Implementation:**
- Real Player: Use the command-line interface (CLI) to make selections.
- AI Player: Makes random selections.

In the following requirements, we use P1, P2, P3, and P4 to represent the four players.
The game uses a deck of cards (Deck), consisting of 52 cards (Card) initially. 
Each card has a rank (Rank) and a suit (Suit).

The game follows these steps:
a. Each player (P1 to P4) chooses a name for themselves.
b. The deck is shuffled.
c. **Drawing Phase:** Starting with P1, P1~P4 take turns drawing a card from the deck until each player has 13 cards.
d. After drawing the cards, the game proceeds with 13 rounds. In each round:
   - P1~P4 take turns playing a card. The cards played are hidden from others.
   - The cards played by P1~P4 are displayed.
   - The cards are compared to determine the winner. The player with the highest-ranked card earns one point.
   - This continues for 13 rounds, and the player with the most points at the end is the winner.

**Card Comparison Rules:**
- First, compare the rank. The higher rank wins. If ranks are equal, compare the suit. The higher suit wins.
- The rank from lowest to highest is: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A.
- The suit from lowest to highest is: Club, Diamond, Heart, Spade.

#### Game 2: Simple UNO

This game supports four players: players can be either a real player (Human Player) or a computer player (AI Player).

**Player Implementation:**
- Real Player: Use the command-line interface (CLI) to make selections.
- AI Player: Makes random selections.

In the following requirements, we use P1, P2, P3, and P4 to represent the four players.
The game uses a deck of cards, consisting of 40 cards. 
Each card has a color and a number.

The game follows these steps:
i. Each player (P1 to P4) chooses a name for themselves.
ii. The deck is shuffled.
iii. **Drawing Phase:** Starting with P1, P1~P4 take turns drawing a card from the deck until each player has 5 cards.

**Game Process:**
- A card is drawn from the deck and placed face-up on the table.
- Players take turns playing a card in the order: P1 → P2 → P3 → P4 → P1, and so on.
- A player must play a card that matches the color or number of the card on the table. The played card becomes the new top card on the table.
- The first player to get rid of all their cards is the winner.
- If a player cannot play a card, they must draw a card from the deck. If the deck is empty, the cards, except for the top card, are shuffled and returned to the deck.

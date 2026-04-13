# Mega Casino

A Java command-line casino simulation featuring five fully playable gambling games, a shared bankroll system, and ASCII art interfaces throughout.

## Games

| Game | How to Win |
|------|-----------|
| **Craps** | Roll 7 or 11 to win instantly. Roll 2, 3, or 12 to lose. Any other number becomes your "point" — roll it again before hitting 7 or 11 |
| **Heads or Tails** | Predict which side a coin lands on. 1:1 payout |
| **Over / Under / 7** | Predict whether two dice will sum above, below, or exactly 7. Exactly 7 pays 2:1 |
| **Higher / Lower** | Predict whether the next number will be higher or lower than the one shown. Ties go to the house |
| **The Vault** | Guess a secret number between 1-20. Fewer attempts = bigger payout (3:1 on first guess, 2:1 on 2-3, 1:1 on 4-5) |

## How to Run

```bash
javac MegaCasino.java
java MegaCasino
```

You start with $500. Games continue until you cash out or go broke.

## Example

```
  _      _      _      _      _      _      _
 / \    / \    / \    / \    / \    / \    / \
( C )  ( A )  ( S )  ( I )  ( N )  ( O )  ( ! )
 \_/    \_/    \_/    \_/    \_/    \_/    \_/
================================================
  Welcome to the high-stakes world, Shahmeer!
  Your Bankroll: $500
================================================

╔════════════ SELECT YOUR DESTINY ════════════╗
║  (1)  [::]  C R A P S                       ║
║  (2)  ($)   H E A D S / T A I L S           ║
║  (3)  -7+   O V E R / U N D E R / 7         ║
║  (4)  ^v^   H I G H E R / L O W E R         ║
║  (5)  [!]   T H E   V A U L T               ║
║  (6)  [->   E X I T                         ║
╚═════════════════════════════════════════════╝
```

## Why I Built It

Built as a Grade 11 Java project to practice object-oriented design, method decomposition, random number generation, and building a multi-game program with shared state. Each game is its own method with its own logic and payout rules.

## Built With

Java

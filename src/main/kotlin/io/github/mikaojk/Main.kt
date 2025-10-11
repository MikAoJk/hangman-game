package io.github.mikaojk

import kotlin.random.Random

fun main() {
    val words = arrayOf("java", "programming", "computer", "algorithm", "developer")
    val targetWord = words[Random.nextInt(words.size)]

    val guessedLetters = StringBuilder("_".repeat(targetWord.length))

    var attempts = 6
    println("Welcome to Hangman!")
    println("Try to guess the word. You have $attempts attempts.")

    while (attempts > 0) {
        println("Current word: $guessedLetters")
        print("Enter a letter: ")
        val input = readLine() ?: ""
        val guess = input.firstOrNull() ?: continue

        var found = false
        val updatedWord = StringBuilder(guessedLetters)
        for (i in targetWord.indices) {
            if (targetWord[i] == guess) {
                updatedWord.setCharAt(i, guess)
                found = true
            }
        }

        if (found) {
            guessedLetters.clear()
            guessedLetters.append(updatedWord)
            println("Correct guess! Updated word: $guessedLetters")
        } else {
            attempts--
            println("Incorrect guess! You have $attempts attempts left.")
        }

        if (guessedLetters.toString() == targetWord) {
            println("Congratulations! You guessed the word: $targetWord")
            break
        }
    }

    if (attempts == 0) {
        println("Game Over. The word was: $targetWord")
    }
}

package baseball.model

import baseball.constants.Constants.END_NUMBER
import baseball.constants.Constants.ERROR_MSG
import baseball.constants.Constants.MAX_NUMBER
import baseball.constants.Constants.MIN_NUMBER
import baseball.constants.Constants.NUMBER_LENGTH
import baseball.constants.Constants.RESTART_NUMBER
import camp.nextstep.edu.missionutils.Randoms

class GameModel {
    private var strikeCount = 0
    private var ballCount = 0
    var randomNumbers = generateRandomNumbers()

    fun generateRandomNumbers(): String {
        val stringBuilder = StringBuilder()
        while (stringBuilder.length < 3) {
            val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
            if (!stringBuilder.contains(randomNumber.toString())) {
                stringBuilder.append(randomNumber)
            }
        }
        return stringBuilder.toString()
    }

    fun strike(inputNumber: String): Int {
        strikeCount = 0
        for (i in 0 until NUMBER_LENGTH) {
            if (inputNumber[i] == randomNumbers[i]) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun ball(inputNumber: String, randomNumbers: String): Int {
        ballCount = 0
        val ball = inputNumber.toCharArray()
        for (i in 0 until NUMBER_LENGTH) {
            if (ball[i] != randomNumbers[i] && randomNumbers.contains(ball[i])) {
                ballCount++
            }
        }
        return ballCount
    }

    fun errorCheck(inputNumber: String): Boolean {
        if (inputNumber.toIntOrNull() == null || inputNumber.length != NUMBER_LENGTH) {
            throw IllegalArgumentException()
        }
        return true
    }

    fun endGameCheck(inputNumber: String): Boolean {
        return when (inputNumber.toInt()) {
            RESTART_NUMBER -> {
                true
            }

            END_NUMBER -> {
                false
            }

            else -> {
                throw Exception(ERROR_MSG)
            }
        }
    }
}

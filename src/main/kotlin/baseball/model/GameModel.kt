package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class GameModel {
    private var strikeCount = 0
    private var ballCount = 0
    var randomNumbers = generateRandomNumbers()

    fun generateRandomNumbers(): String {
        val stringBuilder = StringBuilder()
        while (stringBuilder.length < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!stringBuilder.contains(randomNumber.toString())) {
                stringBuilder.append(randomNumber)
            }
        }
        return stringBuilder.toString()
    }

    fun strike(inputNumber: String): Int {
        strikeCount = 0
        for (i in 0..2) {
            if (inputNumber[i] == randomNumbers[i]) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun ball(inputNumber: String, randomNumbers: String): Int {
        ballCount = 0
        val ball = inputNumber.toCharArray()
        for (i in 0..2) {
            if (ball[i] != randomNumbers[i] && randomNumbers.contains(ball[i])) {
                ballCount++
            }
        }
        return ballCount
    }

    fun errorCheck(inputNumber: String): Boolean {
        if (inputNumber.toIntOrNull() == null || inputNumber.length != 3) {
            throw IllegalArgumentException()
        }
        return true
    }

    fun endGameCheck(inputNumber: String): Boolean {
        return when (inputNumber) {
            "1" -> {
                true
            }

            "2" -> {
                false
            }

            else -> {
                throw Exception("1이나 2를 입력해주세요.")
            }
        }
    }
}

package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class GameModel() {
    private val stringBuilder = StringBuilder()
    private var strikeCount = 0
    private var ballCount = 0
    val randomNumbers = randomNumbers()

    private fun randomNumbers(): String {
        for (i in 0..2) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            stringBuilder.append(randomNumber)
        }
        return stringBuilder.toString()
    }

    fun strike(inputNumber: String): Int {
        strikeCount = 0
        for (i in 0..2) {
            if (inputNumber[i] == randomNumbers()[i]) {
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
}

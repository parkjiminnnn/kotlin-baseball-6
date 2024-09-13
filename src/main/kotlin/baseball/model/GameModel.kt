package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class GameModel() {
    private var strikeCount = 0
    private var ballCount = 0
    var randomNumbers = randomNumbers()

    private fun randomNumbers(): String {
        val usedNumber = mutableSetOf<Int>()
        val stringBuilder = StringBuilder()
        while (usedNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!usedNumber.contains(randomNumber)) {
                usedNumber.add(randomNumber)
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

    fun endGameCheck(inputNumber: String): Boolean {
        return when (inputNumber) {
            "1" -> {
                randomNumbers = randomNumbers()
                true
            }

            "2" -> {
                false
            }

            else -> {
                throw Exception("1이나 2만 입력해주세요.")
            }
        }
    }
}

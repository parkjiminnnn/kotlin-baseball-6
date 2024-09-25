package baseball.view

import baseball.constants.Constants.BALL_MSG
import baseball.constants.Constants.GAME_END_MSG
import baseball.constants.Constants.GAME_START_MSG
import baseball.constants.Constants.INPUT_NUMBER_MSG
import baseball.constants.Constants.NOTHING_MSG
import baseball.constants.Constants.START_OR_END
import baseball.constants.Constants.STRIKE_MSG


class GameView {
    var inputNumber = ""

    fun gameStartMsg() {
        println(GAME_START_MSG)
    }

    fun inputValue(): String {
        print(INPUT_NUMBER_MSG)
        inputNumber = readln()
        return inputNumber
    }

    fun gameEndMsg() {
        println(GAME_END_MSG)
        println(START_OR_END)
    }

    fun gameResult(strikeCount: Int, ballCount: Int) {
        when {
            strikeCount != 0 && ballCount == 0 -> println("$strikeCount$STRIKE_MSG")
            strikeCount == 0 && ballCount != 0 -> println("$ballCount$BALL_MSG")
            strikeCount != 0 && ballCount != 0 -> println("$ballCount$BALL_MSG $strikeCount$STRIKE_MSG")
            else -> println(NOTHING_MSG)
        }
    }
}

package baseball.view

import baseball.model.GameModel

class GameView() {
    var inputNumber = ""
    val gameModel = GameModel()

    fun gameStartMsg() {
        println("숫자야구 게임을 시작합니다.")
    }

    fun inputValue(): String {
        print("숫자를 입력해주세요:")
        inputNumber = readln()
        return inputNumber
    }

    fun gameEndMsg() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    fun gameRule() {
        val strikeCount = gameModel.strike(inputNumber)
        val ballCount = gameModel.ball(inputNumber, gameModel.randomNumbers)
        when {
            strikeCount != 0 && ballCount == 0 -> println("${strikeCount}스트라이크")
            strikeCount == 0 && ballCount != 0 -> println("${ballCount}볼")
            strikeCount != 0 && ballCount != 0 -> println("${ballCount}볼 ${strikeCount}스트라이크")
            else -> println("낫싱")
        }
    }
}

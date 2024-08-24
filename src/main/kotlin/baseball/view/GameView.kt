package baseball.view

import baseball.model.GameModel

class GameView() {
    var inputNumber = ""
    val gameModel = GameModel()

    fun gameStart() {
        println("숫자야구 게임을 시작합니다.")
    }

    private fun inputValue(): String {
        print("숫자를 입력해주세요:")
        inputNumber = readln()
        return inputNumber
    }

    fun gameEnd() {
        println("3스트라이크 게임을 종료합니다.")
    }

    fun inputError(): Boolean {
        if (!inputValue().toInt().equals(Int) || inputValue().length != 3) {
            return true
        }
        return false
    }

    fun gameRule() {
        inputValue()
//        if (inputError()){
//            throw IllegalArgumentException("3자리 숫자를 입력해주세요.")
//        }
        //println(gameModel.randomNumbers)
        if (gameModel.strike(inputNumber) != 0) {
            println(
                "${gameModel.strike(inputNumber)}스트라이크 ${
                    gameModel.ball(
                        inputNumber,
                        gameModel.randomNumbers
                    )
                }볼"
            )
        } else if (gameModel.ball(inputNumber, gameModel.randomNumbers) != 0) {
            println(
                "${gameModel.strike(inputNumber)}스트라이크 ${
                    gameModel.ball(
                        inputNumber,
                        gameModel.randomNumbers
                    )
                }볼"
            )
        } else {
            println("낫씽")
        }
    }
}



package baseball.controller

import baseball.model.GameModel
import baseball.view.GameView


class GameController {
    private val gameView = GameView()
    private val gameModel = GameModel()

    fun playGame() {
        gameView.gameStartMsg()//시작메시지
        while (gameModel.errorCheck(gameView.inputValue())) {//3자리 숫자가 출력될 때만 실행 아니면 exception발생
            val strikes = gameModel.strike(gameView.inputNumber)
            val balls = gameModel.ball(gameView.inputNumber, gameModel.randomNumbers)
            gameView.gameResult(strikes, balls)//게임결과 출력
            if (gameView.inputNumber == gameModel.randomNumbers) {//사용자입력과 랜덤3자리가 일치할시 종료메시지 출력
                gameView.gameEndMsg()
                val restartOrEndNumber = readln()
                if (gameModel.endGameCheck(restartOrEndNumber)) {// 게임 진행 여부
                    gameModel.randomNumbers = gameModel.generateRandomNumbers()//진행시 랜덤숫자 초기화
                } else {
                    break
                }
            }
        }
    }
}

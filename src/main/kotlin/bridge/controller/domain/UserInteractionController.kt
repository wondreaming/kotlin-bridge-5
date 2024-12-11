package bridge.controller.domain

import bridge.view.InputView
import bridge.view.OutputView

class UserInteractionController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun handleStartMsg() {
        outputView.printMsg("다리 건너기 게임을 시작합니다.")
    }
}
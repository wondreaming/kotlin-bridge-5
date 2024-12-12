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

    fun handleBridgeLength(): String {
        outputView.printMsg("다리의 길이를 입력해주세요.")
        return inputView.getInput()
    }

    fun handleUpDown(): String {
        outputView.printMsg("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        return inputView.getInput()
    }

    fun handleRestartQuit(): String {
        outputView.printMsg("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        return inputView.getInput()
    }

    fun handleGameRound(up: List<String>, down: List<String>) {
        outputView.printMsg(up.joinToString(" | ", "[ ", " ]"))
        outputView.printMsg(down.joinToString(" | ", "[ ", " ]"))
    }

    fun handleResult(up: List<String>, down: List<String>, success: String, round: Int) {
        outputView.printMsg("최종 게임 결과")
        handleGameRound(up, down)
        println("게임 성공 여부: ${success}")
        println("총 시도한 횟수: ${round}")
    }
}
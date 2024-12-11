package bridge.controller.validator

class RestartQuitValidator {
    operator fun invoke(input: String) {
        checkEmpty(input)
        checkRestartQuit(input)
    }

    private fun checkEmpty(input: String) {
        require(input.isNotEmpty()) { RestartQuitErrorType.EMPTY_INPUT }
    }

    private fun checkRestartQuit(input: String) {
        require(input == "R" || input == "Q") { RestartQuitErrorType.RESTART_QUIT }
    }
}
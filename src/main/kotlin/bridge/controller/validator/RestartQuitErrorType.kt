package bridge.controller.validator

enum class RestartQuitErrorType(
    private val errorMessage: String
) {
    EMPTY_INPUT("빈 값입니다. 다시 입력해 주세요."),
    RESTART_QUIT("R나 Q가 아닙니다");

    override fun toString(): String = "$ERROR $errorMessage"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}

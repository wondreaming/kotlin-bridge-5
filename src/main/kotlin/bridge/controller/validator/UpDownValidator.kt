package bridge.controller.validator

class UpDownValidator {
    operator fun invoke(input: String) {
        checkEmpty(input)
        checkUpDown(input)
    }

    private fun checkEmpty(input: String) {
        require(input.isNotEmpty()) { UpDownErrorType.EMPTY_INPUT }
    }

    private fun checkUpDown(input: String) {
        require(input == "U" || input == "D") { UpDownErrorType.UP_DOWN }
    }
}
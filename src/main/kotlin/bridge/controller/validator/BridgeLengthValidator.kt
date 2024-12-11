package bridge.controller.validator

class BridgeLengthValidator {
    operator fun invoke(input: String) {
        checkEmpty(input)
        checkInteger(input)
        checkLength(input)
    }

    private fun checkEmpty(input: String) {
        require(input.isNotEmpty()) { BridgeLengthErrorType.EMPTY_INPUT }
    }

    private fun checkInteger(input: String) {
        requireNotNull(input.toIntOrNull()) { BridgeLengthErrorType.INTEGER }
    }

    private fun checkLength(input: String) {
        require(input.toInt() in 3..20) { BridgeLengthErrorType.LENGTH }
    }
}